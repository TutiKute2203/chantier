package tablet.mob.appchantier.function.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import tablet.mob.appchantier.R;
import tablet.mob.appchantier.core.base.BaseMultipleFragment;
import tablet.mob.appchantier.function.activity.MainActivity;
import tablet.mob.appchantier.function.home.HomeFragment;

/**
 * Created by ngo.van on 11/07/2016.
 */
public class LoginFragment extends BaseMultipleFragment {
    public static final String TAG = LoginFragment.class.getSimpleName();

    @BindView(R.id.login_btn_login)
    Button mBtnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
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
        registerSingleAction(mBtnLogin);

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
        switch (v.getId()) {
            case R.id.login_btn_login:
                addFragment(R.id.main_single_container, HomeFragment.getInstance(), HomeFragment.TAG);
                break;
            default:
                break;
        }
    }


    public static BaseMultipleFragment getInstance() {
        return new LoginFragment();
    }
}
