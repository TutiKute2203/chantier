package tablet.mob.appchantier.core.util.gcm;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import tablet.mob.appchantier.core.data.DataSaver;
import tablet.mob.appchantier.core.data.DataSaver.Key;
import tablet.mob.appchantier.core.util.Constant;
import tablet.mob.appchantier.core.util.DLog;
import tablet.mob.appchantier.core.util.Utils;


@SuppressWarnings("unused")
public class GcmController {
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = GcmController.class.getSimpleName();
    private static GcmController instance;
    private final Activity mContext;
    private String registeredId;

    private GcmController(Activity context) {
        this.mContext = context;
    }

    public static GcmController getInstance(Activity context) {
        if (instance == null)
            instance = new GcmController(context);
        return instance;
    }

    public void subscribeNotification() {
        if (checkPlayServices()) {
            registeredId = getRegistrationId();
            if (Utils.isEmpty(registeredId)) {
                registerInBackground();
            }
        } else {
            DLog.d(TAG, "No valid Google Play Services APK found.");
        }
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If it
     * doesn't, display a dialog that allows users to download the APK from the
     * Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        int resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(mContext);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GoogleApiAvailability.getInstance().isUserResolvableError(resultCode)) {
                GoogleApiAvailability.getInstance().getErrorDialog(mContext, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                DLog.d(TAG, "This device is not supported.");
            }
            return false;
        }
        return true;
    }

    /**
     * Gets the current registration ID for application on GCM service.
     * <p/>
     * If result is empty, the app needs to register.
     *
     * @return registration ID, or empty string if there is no existing
     * registration ID.
     */
    private String getRegistrationId() {
        try {
            final String registrationId = DataSaver.getInstance().getString(Key.GCM);
            if (Utils.isEmpty(registrationId)) {
                DLog.d(TAG, "Registration not found.");
                return "";
            }
            // Check if app was updated; if so, it must clear the registration
            // ID
            // since the existing regID is not guaranteed to work with the new
            // app version.
            String registeredVersion = DataSaver.getInstance().getString(
                    Key.VERSION);
            String currentVersion = Utils.getAppVersion();
            if (!registeredVersion.equals(currentVersion)) {
                DataSaver.getInstance().setEnabled(Key.UPDATED, false);
                DLog.d(TAG, "App version changed.");
                return "";
            } else {
                DLog.d(TAG, "App is already registered with id = "
                        + registrationId);
                DLog.d(TAG, "Checking if the device id has changed...");
                return new AsyncTask<String, Void, String>() {

                    @Override
                    protected String doInBackground(String... params) {
                        InstanceID instanceID = InstanceID.getInstance(mContext);
                        try {
                            String newId = instanceID.getToken(Constant.SENDER_ID,
                                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                            if (registrationId.equals(newId))
                                return registrationId;
                            else {
                                try {
                                    DataSaver.getInstance().setEnabled(Key.UPDATED, false);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return "";
                    }
                }.get();
            }
        } catch (Exception e) {
            return "";
        }

    }

    private void registerInBackground() {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {
                String msg = "";
                DLog.d(TAG, "Start registering...");

                InstanceID instanceID = InstanceID.getInstance(mContext);
                try {
                    registeredId = instanceID.getToken(Constant.SENDER_ID,
                            GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

                    msg = "Device registered, registration id = " + registeredId;

                    if (!DataSaver.getInstance().isEnabled(Key.UPDATED))
                        sendRegistrationIdToBackend(registeredId);

                } catch (IOException e) {
                    msg = "Error :" + e.getMessage();
                    // If there is an error, don't just keep trying to register.
                    // Require the user to click a button again, or perform
                    // exponential back-off.
                } catch (Exception e) {
                    e.printStackTrace();
                }
                DLog.d(TAG, msg);
                return null;
            }
        }.execute();
    }

    /**
     * Sends the registration ID to your server over HTTP, so it can use
     * GCM/HTTP or CCS to send messages to your app. Not needed for this demo
     * since the device sends upstream messages to a server that echoes back the
     * message using the 'from' address in the message.
     */
    private void sendRegistrationIdToBackend(String regId) {
        DLog.d(TAG, "Send the registered id to server...");
        storeRegistrationId(regId);
    }

    /**
     * Stores the registration ID and app versionCode in the application's
     * {@code SharedPreferences}.
     *
     * @param regId registration ID
     */
    private void storeRegistrationId(String regId) {
        try {
            String appVersion = Utils.getAppVersion();
            DLog.d(TAG, "Saving regId on app version " + appVersion);
            DataSaver.getInstance().setString(Key.GCM, regId);
            DataSaver.getInstance().setString(Key.VERSION, appVersion);
            DataSaver.getInstance().setEnabled(Key.UPDATED, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
