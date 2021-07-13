/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:00
 */

package other.mvvm.slidefragment.app_package

fun mvvmTabAcitivityKt(
        applicationPackage: String?,
        activityClass: String,
        layoutName: String,
        fragmentClass: String,
        packageName: String
) = """
package $packageName
import android.os.Bundle
import com.hhkj.base_lib.base.BaseAty
import ${packageName}.databinding.Activity${activityClass}Binding
import com.hhkj.base_lib.utils.MyPagerAdapter
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
        // fragmentList
        mVM.fragmentList.apply {
            add(${fragmentClass}Fragment().newInstance())
            add(${fragmentClass}Fragment().newInstance())
            add(${fragmentClass}Fragment().newInstance())
        }
        val myPagerAdapter = MyPagerAdapter(supportFragmentManager, mVM.fragmentList)
        view_pager.adapter = myPagerAdapter
        view_pager.offscreenPageLimit = myPagerAdapter.count
        tab_segment.setViewPager(view_pager, mVM.tagArray.toTypedArray())
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