package tablet.mob.appchantier.databinding;
import tablet.mob.appchantier.R;
import tablet.mob.appchantier.BR;
import android.view.View;
public class ActivityMainTwoPanelBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_single_container, 2);
    }
    // views
    public final android.widget.FrameLayout chantierFlLeftContainer;
    public final android.view.View mainActionbarLayout;
    public final android.widget.FrameLayout mainSingleContainer;
    private final android.widget.RelativeLayout mboundView0;
    // variables
    private tablet.mob.appchantier.function.activity.MainViewModel mViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainTwoPanelBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.chantierFlLeftContainer = (android.widget.FrameLayout) bindings[1];
        this.chantierFlLeftContainer.setTag(null);
        this.mainActionbarLayout = (android.view.View) bindings[0];
        this.mainActionbarLayout.setTag(null);
        this.mainSingleContainer = (android.widget.FrameLayout) bindings[2];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.viewModel :
                setViewModel((tablet.mob.appchantier.function.activity.MainViewModel) variable);
                return true;
        }
        return false;
    }

    public void setViewModel(tablet.mob.appchantier.function.activity.MainViewModel viewModel) {
        this.mViewModel = viewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public tablet.mob.appchantier.function.activity.MainViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMLeftContain((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMLeftContain(android.databinding.ObservableInt mLeftContainerVisibilityViewModel, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        tablet.mob.appchantier.function.activity.MainViewModel viewModel = mViewModel;
        int mLeftContainerVisibi = 0;
        android.databinding.ObservableInt mLeftContainerVisibi1 = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.mLeftContainerVisibility
                    mLeftContainerVisibi1 = viewModel.mLeftContainerVisibility;
                }
                updateRegistration(0, mLeftContainerVisibi1);


                if (mLeftContainerVisibi1 != null) {
                    // read viewModel.mLeftContainerVisibility.get()
                    mLeftContainerVisibi = mLeftContainerVisibi1.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.chantierFlLeftContainer.setVisibility(mLeftContainerVisibi);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityMainTwoPanelBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainTwoPanelBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainTwoPanelBinding>inflate(inflater, tablet.mob.appchantier.R.layout.activity_main_two_panel, root, attachToRoot, bindingComponent);
    }
    public static ActivityMainTwoPanelBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainTwoPanelBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(tablet.mob.appchantier.R.layout.activity_main_two_panel, null, false), bindingComponent);
    }
    public static ActivityMainTwoPanelBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainTwoPanelBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_two_panel_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainTwoPanelBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.mLeftContainerVisibility
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}