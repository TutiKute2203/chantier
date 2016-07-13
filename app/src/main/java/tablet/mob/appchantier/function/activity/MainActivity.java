package tablet.mob.appchantier.function.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import tablet.mob.appchantier.R;
import tablet.mob.appchantier.core.base.BaseMultipleFragmentActivity;
import tablet.mob.appchantier.databinding.ActivityMainSinglePanelBinding;
import tablet.mob.appchantier.databinding.ActivityMainTwoPanelBinding;
import tablet.mob.appchantier.databinding.LayoutActionBarBinding;
import tablet.mob.appchantier.function.authentication.AuthenticationFragment;
import tablet.mob.appchantier.function.home.SplashFragment;

public class MainActivity extends BaseMultipleFragmentActivity {

    private boolean isTwoPanel = true;

    private MainViewModel mMainViewModel;

    private ActivityMainTwoPanelBinding mBinding;

    private LayoutActionBarBinding mLayoutActionBarBinding;

    @Override
    protected void onInitializeFragments() {

    }

    @Override
    protected void onLastFragmentBack(int containerId) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutActionBarBinding = DataBindingUtil.setContentView(this, mLayoutActionBarBinding.);
        mMainViewModel = new MainViewModel();
        mBinding.setViewModel(mMainViewModel);

        //isTwoPanel = getResources().getBoolean(R.bool.has_two_panes);

        showSplashScreen();
    }

    /**
     * Check if user is login or not
     *
     * @return
     */
    private boolean isLoggedIn() {
        return false;
    }

    @Override
    public void onBaseCreate() {

    }

    @Override
    public void onDeepLinking(Intent data) {
    }

    @Override
    public void onNotification(Intent data) {

    }

    @Override
    public void onInitializeViewData() {

    }

    @Override
    public void onBaseResume() {

    }

    @Override
    public void onBaseFree() {

    }

    @Override
    public void onBindView() {
        super.onBindView();
    }

    /**
     * Set single click in header
     */
//    private void setSingleClick() {
//        registerSingleAction(mIvHeaderBack, mIvHeaderHome, mIvHeaderSetting, mIvHeaderProfile, mIvHeaderAccident);
//    }

    private void showSplashScreen() {
        if (isLoggedIn()) {
            addFragmentNoAnim(R.id.main_single_container, SplashFragment.getInstance(), SplashFragment.TAG);
        } else {
            addFragmentNoAnim(R.id.main_single_container, SplashFragment.getInstance(), SplashFragment.TAG);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                replaceFragment(R.id.main_single_container, AuthenticationFragment.getInstance(), AuthenticationFragment.TAG, true);
            }
        }, 3000);
    }

    public void setHeaderBarVisibility(int visibility) {
        mMainViewModel.setHeaderBarVisibility(visibility);
    }

    public void setLeftContainerVisibility(int visibility) {
        mMainViewModel.setLeftContainerVisibility(visibility);
    }




    /**
     * Detect whether device is tablet or phone
     *
     * @return
     */
    public boolean isTwoPanel() {
        return isTwoPanel;
    }

    @Override
    public void onSingleClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainViewModel.onDestroy();
    }
}
