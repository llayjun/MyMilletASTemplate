/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:00
 */

package other.mvvm.activity.src.app_package

fun mvvmAcitivityKt(
        applicationPackage: String?,
        activityClass: String,
        layoutName: String,
        packageName: String
) = """
package $packageName
import android.os.Bundle
import com.hhkj.base_lib.base.BaseAty
import ${packageName}.databinding.Activity${activityClass}Binding
//import com.hhkj.base_lib.constant.ArouterPath

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