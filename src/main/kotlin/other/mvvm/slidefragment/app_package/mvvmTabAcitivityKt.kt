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
import ${packageName}.base.mvvm.BaseAty
import ${packageName}.databinding.Activity${activityClass}Binding
import ${packageName}.adapter.MyPagerAdapter
import com.blankj.utilcode.util.SizeUtils
import com.ruffian.library.widget.RTextView
import kotlinx.android.synthetic.main.${layoutName}.*

/**
 * @description
 * @author Millet
 * @date 
 */
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
        mBinding.titleLayout.run {
            (rightTextView as RTextView).run {
                setPadding(40, 10, 40, 10)
                textSize = SizeUtils.px2sp(39f).toFloat()
                helper.apply {
                    backgroundColorNormal = getColor(R.color.color_FFD41D)
                    cornerRadius = SizeUtils.dp2px(35f).toFloat()
                }
            }
            setRightTv("保存") {

            }
        }
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
//        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//                view_pager.requestLayout()
//            }
//        })
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