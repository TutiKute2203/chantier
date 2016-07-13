package tablet.mob.appchantier.databinding;
import tablet.mob.appchantier.R;
import tablet.mob.appchantier.BR;
import android.view.View;
public class LayoutActionBarBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.chantier_layout_home_header, 4);
        sViewsWithIds.put(R.id.chantier_layout_left_header, 5);
        sViewsWithIds.put(R.id.chantier_iv_back_header, 6);
        sViewsWithIds.put(R.id.chantier_iv_home_header, 7);
        sViewsWithIds.put(R.id.chantier_layout_right_header, 8);
    }
    // views
    public final android.widget.ImageView chantierIvAccidentHeader;
    public final android.widget.ImageView chantierIvBackHeader;
    public final android.widget.ImageView chantierIvHomeHeader;
    public final android.widget.ImageView chantierIvProfileHeader;
    public final android.widget.ImageView chantierIvSettingHeader;
    public final android.widget.RelativeLayout chantierLayoutHomeHeader;
    public final android.widget.LinearLayout chantierLayoutLeftHeader;
    public final android.widget.LinearLayout chantierLayoutRightHeader;
    private final android.widget.RelativeLayout mboundView0;
    // variables
    private tablet.mob.appchantier.function.activity.MainViewModel mViewModel;
    private final android.view.View.OnClickListener mCallback3;
    private final android.view.View.OnClickListener mCallback2;
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutActionBarBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.chantierIvAccidentHeader = (android.widget.ImageView) bindings[2];
        this.chantierIvAccidentHeader.setTag(null);
        this.chantierIvBackHeader = (android.widget.ImageView) bindings[6];
        this.chantierIvHomeHeader = (android.widget.ImageView) bindings[7];
        this.chantierIvProfileHeader = (android.widget.ImageView) bindings[3];
        this.chantierIvProfileHeader.setTag(null);
        this.chantierIvSettingHeader = (android.widget.ImageView) bindings[1];
        this.chantierIvSettingHeader.setTag(null);
        this.chantierLayoutHomeHeader = (android.widget.RelativeLayout) bindings[4];
        this.chantierLayoutLeftHeader = (android.widget.LinearLayout) bindings[5];
        this.chantierLayoutRightHeader = (android.widget.LinearLayout) bindings[8];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 3);
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
                return onChangeMHeaderBarVi((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMHeaderBarVi(android.databinding.ObservableInt mHeaderBarVisibilityViewModel, int fieldId) {
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
        android.databinding.ObservableInt mHeaderBarVisibility = null;
        int mHeaderBarVisibility1 = 0;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.mHeaderBarVisibility
                    mHeaderBarVisibility = viewModel.mHeaderBarVisibility;
                }
                updateRegistration(0, mHeaderBarVisibility);


                if (mHeaderBarVisibility != null) {
                    // read viewModel.mHeaderBarVisibility.get()
                    mHeaderBarVisibility1 = mHeaderBarVisibility.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.chantierIvAccidentHeader.setOnClickListener(mCallback2);
            this.chantierIvProfileHeader.setOnClickListener(mCallback3);
            this.chantierIvSettingHeader.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.mboundView0.setVisibility(mHeaderBarVisibility1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // viewModel != null
                boolean viewModelObjectnull = false;
                // viewModel
                tablet.mob.appchantier.function.activity.MainViewModel viewModel = mViewModel;



                viewModelObjectnull = (viewModel) != (null);
                if (viewModelObjectnull) {



                    viewModel.onRightHeaderClick(callbackArg_0);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // viewModel != null
                boolean viewModelObjectnull = false;
                // viewModel
                tablet.mob.appchantier.function.activity.MainViewModel viewModel = mViewModel;



                viewModelObjectnull = (viewModel) != (null);
                if (viewModelObjectnull) {



                    viewModel.onRightHeaderClick(callbackArg_0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel != null
                boolean viewModelObjectnull = false;
                // viewModel
                tablet.mob.appchantier.function.activity.MainViewModel viewModel = mViewModel;



                viewModelObjectnull = (viewModel) != (null);
                if (viewModelObjectnull) {



                    viewModel.onRightHeaderClick(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static LayoutActionBarBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LayoutActionBarBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<LayoutActionBarBinding>inflate(inflater, tablet.mob.appchantier.R.layout.layout_action_bar, root, attachToRoot, bindingComponent);
    }
    public static LayoutActionBarBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LayoutActionBarBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(tablet.mob.appchantier.R.layout.layout_action_bar, null, false), bindingComponent);
    }
    public static LayoutActionBarBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LayoutActionBarBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/layout_action_bar_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new LayoutActionBarBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.mHeaderBarVisibility
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}