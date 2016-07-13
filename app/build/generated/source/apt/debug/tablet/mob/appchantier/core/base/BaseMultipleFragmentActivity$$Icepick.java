// Generated code from Icepick. Do not modify!
package tablet.mob.appchantier.core.base;
import android.os.Bundle;
import icepick.Bundler;
import icepick.Injector.Helper;
import icepick.Injector.Object;

import java.util.Map;
import java.util.HashMap;

public class BaseMultipleFragmentActivity$$Icepick<T extends BaseMultipleFragmentActivity> extends Object<T> {

  private final static Map<String, Bundler<?>> BUNDLERS = new HashMap<String, Bundler<?>>();
  static {
          
  }

  private final static Helper H = new Helper("tablet.mob.appchantier.core.base.BaseMultipleFragmentActivity$$Icepick.", BUNDLERS);

  public void restore(T target, Bundle state) {
    if (state == null) return;
    target.containers = H.getSerializable(state, "containers");
    target.isFragmentsInitialized = H.getBoolean(state, "isFragmentsInitialized");
    target.mainContainerId = H.getInt(state, "mainContainerId");
    super.restore(target, state);
  }

  public void save(T target, Bundle state) {
    super.save(target, state);
    H.putSerializable(state, "containers", target.containers);
    H.putBoolean(state, "isFragmentsInitialized", target.isFragmentsInitialized);
    H.putInt(state, "mainContainerId", target.mainContainerId);
  }
}