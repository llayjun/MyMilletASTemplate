/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:00
 */

package other.mvvm.refreshactivity.src.app_package

fun mvvmRefreshAcitivityKt(
        applicationPackage: String?,
        activityClass: String,
        layoutName: String,
        packageName: String
) = """
package $packageName
import android.os.Bundle
import com.hhkj.base_lib.base.BaseAty
import ${packageName}.databinding.Activity${activityClass}Binding
import kotlinx.android.synthetic.main.${layoutName}.*
import com.hhkj.base_lib.constant.ArouterPath

/**
 * @description
 * @author Millet
 * @date 
 */
// @Route(path = ArouterPath.xxxx)
class ${activityClass}Activity : BaseAty<Activity${activityClass}Binding, ${activityClass}VM>() {

    override val mVMClass: Class<${activityClass}VM>
        get() = ${activityClass}VM::class.java

    override val mLayoutRes: Int
        get() = R.layout.${layoutName}

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.viewModel = mVM
        mVM.mActivity = this
    }
    
    override fun initView(savedInstanceState: Bundle?) {
        
    }

    override fun loadData(savedInstanceState: Bundle?) {
        mVM.refreshData(smart_refresh)
        mBinding.rvXxx.run {
            adapter = mVM.adapter.apply {
                setEmptyView(R.layout.view_new_empty_data, mBinding.rvXxx)
            }
            mVM.adapterLoadMoreData(this)
        }
        mVM.adapter.setNewData(listOf("", ""))
    }

    /**
     * 点击事件
     */
    override fun clickListener() {
    
    }
    
    /**
     * LiveData监听
     */
    override fun liveDataListener() {
        
    }
 
} 
    
"""