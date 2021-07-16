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
import ${packageName}.databinding.Item${activityClass}Binding
import kotlinx.android.synthetic.main.${layoutName}.*
//import com.hhkj.base_lib.constant.ArouterPath
import com.hhkj.base_lib.base.adater.BaseBindingAdapter
import com.hhkj.base_lib.base.adater.VBViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * @description
 * @author Millet
 * @date 
 */
// @Route(path = ArouterPath.xxxx)
class ${activityClass}Activity : BaseAty<Activity${activityClass}Binding, ${activityClass}VM>() {

    var myAdapter: My${activityClass}Adapter = My${activityClass}Adapter()

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
        mBinding.rvView.run {
            adapter = myAdapter.apply {
                setEmptyView(R.layout.view_new_empty_data, mBinding.rvView)
                myAdapter.setOnLoadMoreListener({
                    mVM.index++
                    mVM.getInfoList(null)
                }, this@run)
            }
        }
        myAdapter.setNewData(listOf("", ""))
    }

    /**
     * 点击事件
     */
    override fun clickListener() {
        // item点击
        myAdapter.setOnItemClickListener { adapter, view, position -> 
            
        }
        // item child点击
        myAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                
            }
        }
    }
    
    /**
     * LiveData监听
     */
    override fun liveDataListener() {
        
    }
    
     open inner class My${activityClass}Adapter : BaseBindingAdapter<String, Item${activityClass}Binding>(ArrayList<String>()) {

        override fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup): Item${activityClass}Binding {
            return Item${activityClass}Binding.inflate(inflater, parent, false)
        }

        override fun convert(helper: VBViewHolder<Item${activityClass}Binding>, item: String?) {
            helper.vb.bean = item
            helper.vb.executePendingBindings()
        }

    }
 
} 
    
"""