package other.mvvm.slidefragment.app_package

fun mvvmTabFragmentKt(
        applicationPackage: String?,
        fragmentClass: String,
        layoutFragmentName: String,
        packageName: String
) = """
package $packageName

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.hhkj.base_lib.base.BaseFrag
import ${packageName}.databinding.Fragment${fragmentClass}Binding
import ${packageName}.databinding.Item${fragmentClass}Binding
import com.hhkj.base_lib.base.adater.BaseBindingAdapter
import com.hhkj.base_lib.base.adater.VBViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * @description
 * @author Millet
 * @date 
 */
class ${fragmentClass}Fragment : BaseFrag<Fragment${fragmentClass}Binding, ${fragmentClass}FragVM>() {

    var myAdapter: My${fragmentClass}Adapter = My${fragmentClass}Adapter()

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
        mBinding.rvView.run {
            adapter = myAdapter.apply {
                setEmptyView(R.layout.view_new_empty_data, mBinding.rvView)
                myAdapter.setOnLoadMoreListener({
                    mVM.index++
                    mVM.getInfoList(null)
                }, this@run)
            }
        }
    }

    override fun loadData(savedInstanceState: Bundle?) {
        mVM.refreshData(mBinding.smartRefresh)
        myAdapter.setNewData(listOf("aaa", "bbb", "ccc"))
    }

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
    
     open inner class My${fragmentClass}Adapter : BaseBindingAdapter<String, Item${fragmentClass}Binding>(ArrayList<String>()) {

        override fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup): Item${fragmentClass}Binding {
            return Item${fragmentClass}Binding.inflate(inflater, parent, false)
        }

        override fun convert(helper: VBViewHolder<Item${fragmentClass}Binding>, item: String?) {
            helper.vb.bean = item
            helper.vb.executePendingBindings()
        }

    }
 
} 
    
"""