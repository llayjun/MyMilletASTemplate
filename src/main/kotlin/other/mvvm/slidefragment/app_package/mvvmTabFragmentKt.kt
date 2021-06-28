package other.mvvm.slidefragment.app_package

fun mvvmTabFragmentKt(
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
import ${packageName}.base.mvvm.BaseFrag
import ${packageName}.databinding.Fragment${fragmentClass}Binding

/**
 * @description
 * @author Millet
 * @date 
 */
class ${fragmentClass}Fragment : BaseFrag<Fragment${fragmentClass}Binding, ${activityClass}VM>() {

    public fun newInstance(): ${fragmentClass}Fragment{
            return ${fragmentClass}Fragment()
    }

    override val mVMClass: Class<${activityClass}VM>
        get() = ${activityClass}VM::class.java

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
    }

    override fun loadData(savedInstanceState: Bundle?) {
        mVM.refreshData(mBinding.smartRefresh)
        mVM.adapter.setNewData(listOf("aaa", "bbb", "ccc"))
    }

    override fun clickListener() {
        mVM.initListener()
    }
 
} 
    
"""