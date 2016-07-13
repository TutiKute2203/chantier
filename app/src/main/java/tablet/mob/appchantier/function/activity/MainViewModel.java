package tablet.mob.appchantier.function.activity;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import tablet.mob.appchantier.R;
import tablet.mob.appchantier.function.base.BaseViewModel;

/**
 * Created by chau.n on 12/07/2016.
 */
public class MainViewModel implements BaseViewModel {

    public ObservableInt isSelectedHeaderAccident;
    public ObservableInt isSelectedHeaderProfile;
    public ObservableInt isSelectedHeaderSetting;
    public ObservableInt mHeaderBarVisibility;
    public ObservableInt mLeftContainerVisibility;

    public MainViewModel() {
        isSelectedHeaderAccident = new ObservableInt(View.VISIBLE);
        isSelectedHeaderProfile = new ObservableInt(View.VISIBLE);
        isSelectedHeaderSetting = new ObservableInt(View.VISIBLE);
        mHeaderBarVisibility = new ObservableInt(View.VISIBLE);
        mLeftContainerVisibility = new ObservableInt(View.GONE);
    }

    @Override
    public void onDestroy() {

    }

    /**
     * Handle right action bar click
     * Set select item and handle click action
     *
     * @param v
     */
    public void onRightHeaderClick(View v) {
        if (v.getId() == R.id.chantier_iv_accident_header) {
            isSelectedHeaderAccident.set(View.VISIBLE);
            isSelectedHeaderProfile.set(View.INVISIBLE);
            isSelectedHeaderSetting.set(View.INVISIBLE);
            //TODO Add fragment Accident
        } else if (v.getId() == R.id.chantier_iv_profile_header) {
            isSelectedHeaderAccident.set(View.INVISIBLE);
            isSelectedHeaderProfile.set(View.VISIBLE);
            isSelectedHeaderSetting.set(View.INVISIBLE);
            //TODO Add fragment Profile
        } else if (v.getId() == R.id.chantier_iv_setting_header) {
            isSelectedHeaderAccident.set(View.INVISIBLE);
            isSelectedHeaderProfile.set(View.INVISIBLE);
            isSelectedHeaderSetting.set(View.VISIBLE);
        }
    }

    public void setHeaderBarVisibility(int visibility) {
        mHeaderBarVisibility.set(visibility);
    }

    public void setLeftContainerVisibility(int visibility) {
        mLeftContainerVisibility.set(visibility);
    }
}
