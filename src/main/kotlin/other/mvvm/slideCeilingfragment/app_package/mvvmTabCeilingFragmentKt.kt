package other.mvvm.slideCeilingfragment.app_package

fun mvvmTabCeilingFragmentKt(
        applicationPackage: String?,
        fragmentClass: String,
        layoutFragmentName: String,
        activityClass: String,
        packageName: String
) = """
package $packageName

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.hhkj.base_lib.base.BaseFrag
import ${packageName}.databinding.Fragment${fragmentClass}Binding

/**
 * @description
 * @author Millet
 * @date 
 */
class ${fragmentClass}Fragment : BaseFrag<Fragment${fragmentClass}Binding, ${fragmentClass}FragVM>() {

    public fun newInstance(): ${fragmentClass}Fragment{
            return ${fragmentClass}Fragment()
    }

    override val mVMClass: Class<${fragmentClass}FragVM>
        get() = ${fragmentClass}FragVM::class.java

    override val mLayoutRes: Int
        get() = R.layout.${layoutFragmentName}

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.viewModel = mVM
        mVM.mActivity = context as Activity
    }

    override fun initView(contentView: View, savedInstanceState: Bundle?) {
        mBinding.rvXxx.run {
            adapter = mVM.adapter.apply {
                setEmptyView(R.layout.view_new_empty_data, mBinding.rvXxx)
            }
            mVM.adapterLoadMoreData(this)
        }
        mVM.adapter.setNewData(listOf("aaa", "bbb", "ccc", "bbb", "ccc", "bbb", "ccc"))
    }

    override fun loadData(savedInstanceState: Bundle?) {
        mVM.getInfoList(mVM.index)
    }

    override fun clickListener() {
        mVM.initListener()
    }
    
    /**
     * 刷新界面
     */
    public fun refreshRv() {
        mVM.index = 1
        mVM.getInfoList(mVM.index)
    }
 
} 
    
"""