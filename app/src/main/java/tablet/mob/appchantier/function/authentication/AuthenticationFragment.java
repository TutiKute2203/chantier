package tablet.mob.appchantier.function.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import tablet.mob.appchantier.R;
import tablet.mob.appchantier.core.base.BaseMultipleFragment;
import tablet.mob.appchantier.function.activity.MainActivity;

/**
 * Created by ngo.van on 11/07/2016.
 */
public class AuthenticationFragment extends BaseMultipleFragment implements View.OnClickListener {
    public static final String TAG = AuthenticationFragment.class.getSimpleName();

    @BindView(R.id.home_hv_user)
    LinearLayout mAccountListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_authentication, container, false);
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
        //Sample
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (int i = 0; i < 4; i++) {
            View item = inflater.inflate(R.layout.layout_account_item, null);
            item.setTag(i);
            item.setOnClickListener(this);
            mAccountListView.addView(item);
        }
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
        return new AuthenticationFragment();
    }

    @Override
    public void onClick(View v) {
        try {
            int index = (int) v.getTag();
            Toast.makeText(getActivity(), "Click at: " + index, Toast.LENGTH_SHORT).show();
            addFragment(R.id.main_single_container, LoginFragment.getInstance(), LoginFragment.TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
