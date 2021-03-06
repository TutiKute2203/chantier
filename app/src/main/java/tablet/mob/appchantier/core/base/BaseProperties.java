package tablet.mob.appchantier.core.base;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import tablet.mob.appchantier.core.connection.BackgroundServiceRequester;
import tablet.mob.appchantier.core.connection.ParallelServiceRequester;
import tablet.mob.appchantier.core.connection.QueueServiceRequester;
import tablet.mob.appchantier.core.connection.WebServiceRequester;
import tablet.mob.appchantier.core.dialog.GeneralDialog;
import tablet.mob.appchantier.core.dialog.LoadingDialog;
import tablet.mob.appchantier.core.util.SingleBackPress;
import tablet.mob.appchantier.core.util.SingleTouch;

public abstract class BaseProperties {
    /**
     * Loading dialog reference, this loading dialog will be applied for the
     * entire application
     */
    public static LoadingDialog loadingDialog = null;

    /**
     * Decision dialog reference, this decision dialog will be applied for the
     * entire application
     */
    public static GeneralDialog decisionDialog = null;

    /**
     * Alert dialog reference, this decision dialog will be applied for the
     * entire application
     */
    public static GeneralDialog alertDialog = null;
    /**
     * The web service requester to make the request to server and return the
     * result to the context
     */
    public static WebServiceRequester wsRequester = null;
    /**
     * The queue service requester to make the request to server and return the
     * result to the listeners
     */
    public static QueueServiceRequester queueRequester = null;
    /**
     * The parallel service requester to make the requests (asynchronously) to server and return the
     * result to the listeners
     */
    public static ParallelServiceRequester parallelRequester = null;
    /**
     * The background service requester to make the background request with the
     * low priority and handle the result in the background thread
     */
    public static BackgroundServiceRequester bgRequester = null;
    /**
     * Single touch reference, this single touch will be applied for components
     * to ensure only one component touched at the same time
     */
    private static SingleTouch singleTouch = null;
    /**
     * Single back-press reference, the single back-press ensure only the
     * back-press event only execute once after a short period
     */
    private static SingleBackPress singleBackPress = null;

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean isExceptionalView(View view) {
        return ((view instanceof AdapterView) || (view instanceof EditText)
                || (view instanceof SwipeRefreshLayout)
                || (view instanceof DrawerLayout) || (view instanceof ViewPager));
    }

    public static SingleTouch getSingleTouch() {
        if (singleTouch == null)
            singleTouch = new SingleTouch();
        return singleTouch;
    }

    public static SingleBackPress getSingleBackPress() {
        if (singleBackPress == null)
            singleBackPress = new SingleBackPress();
        return singleBackPress;
    }
}
