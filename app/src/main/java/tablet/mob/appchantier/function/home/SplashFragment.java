package tablet.mob.appchantier.function.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tablet.mob.appchantier.R;
import tablet.mob.appchantier.core.base.BaseMultipleFragment;
import tablet.mob.appchantier.function.activity.MainActivity;

/**
 * Created by ngo.van on 11/07/2016.
 */
public class SplashFragment extends BaseMultipleFragment {
    public static final String TAG = SplashFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
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
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setHeaderBarVisibility(View.GONE);
            ((MainActivity) getActivity()).setLeftContainerVisibility(View.GONE);
        }
    }

    @Override
    public void onBaseFree() {

    }

    @Override
    public void onSingleClick(View v) {

    }


    public static BaseMultipleFragment getInstance() {
        return new SplashFragment();
    }
}
