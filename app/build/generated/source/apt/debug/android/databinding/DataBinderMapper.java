
package android.databinding;
import tablet.mob.appchantier.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 17;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case tablet.mob.appchantier.R.layout.activity_main_single_panel:
                    return tablet.mob.appchantier.databinding.ActivityMainSinglePanelBinding.bind(view, bindingComponent);
                case tablet.mob.appchantier.R.layout.layout_action_bar:
                    return tablet.mob.appchantier.databinding.LayoutActionBarBinding.bind(view, bindingComponent);
                case tablet.mob.appchantier.R.layout.activity_main_two_panel:
                    return tablet.mob.appchantier.databinding.ActivityMainTwoPanelBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1188858521: {
                if(tag.equals("layout/activity_main_single_panel_0")) {
                    return tablet.mob.appchantier.R.layout.activity_main_single_panel;
                }
                break;
            }
            case 1691234379: {
                if(tag.equals("layout/layout_action_bar_0")) {
                    return tablet.mob.appchantier.R.layout.layout_action_bar;
                }
                break;
            }
            case -382343993: {
                if(tag.equals("layout/activity_main_two_panel_0")) {
                    return tablet.mob.appchantier.R.layout.activity_main_two_panel;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"viewModel"};
    }
}