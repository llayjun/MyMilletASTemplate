/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:00
 */

package other.mvvm.slideCeilingfragment.app_package

fun mvvmTabCeilingAcitivityKt(
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
//import com.hhkj.base_lib.constant.ArouterPath

/**
 * @description
 * @author Millet
 * @date 
 */
 // @Route(path = ArouterPath.xxxx)
class ${activityClass}Activity : BaseAty<Activity${activityClass}Binding, ${activityClass}VM>() {

    private lateinit var firstFragment: ${fragmentClass}Fragment
    private lateinit var secondFragment: ${fragmentClass}Fragment
    private lateinit var thirdFragment: ${fragmentClass}Fragment

    override val mVMClass: Class<${activityClass}VM>
        get() = ${activityClass}VM::class.java

    override val mLayoutRes: Int
        get() = R.layout.${layoutName}

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.viewModel = mVM
        mVM.mActivity = this
    }
    
    override fun initView(savedInstanceState: Bundle?) {
        firstFragment = ${fragmentClass}Fragment().newInstance()
        secondFragment = ${fragmentClass}Fragment().newInstance()
        thirdFragment = ${fragmentClass}Fragment().newInstance()
        // fragmentList
        mVM.fragmentList.apply {
            add(firstFragment)
            add(secondFragment)
            add(thirdFragment)
        }
        val myPagerAdapter = MyPagerAdapter(supportFragmentManager, mVM.fragmentList)
        view_pager.adapter = myPagerAdapter
        view_pager.offscreenPageLimit = myPagerAdapter.count
        tab_segment.setViewPager(view_pager, mVM.tagArray.toTypedArray())
        mBinding.smartRefresh.setOnRefreshListener {
            mVM.getInfoList(it)
            firstFragment.refreshRv()
            secondFragment.refreshRv()
            thirdFragment.refreshRv()
        }
    }

    override fun loadData(savedInstanceState: Bundle?) {
        
    }

    /**
     * ????????????
     */
    override fun clickListener() {
    
    }
    
    /**
     * LiveData??????
     */
    override fun liveDataListener() {
        
    }
 
} 
    
"""