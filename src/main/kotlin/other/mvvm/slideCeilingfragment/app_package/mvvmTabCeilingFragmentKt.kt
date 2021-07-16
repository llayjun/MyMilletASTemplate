package other.mvvm.slideCeilingfragment.app_package

fun mvvmTabCeilingFragmentKt(
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

    var myAdapter: ${fragmentClass}Adapter = ${fragmentClass}Adapter()

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
                    mVM.getInfoList(myAdapter)
                }, this@run)
            }
        }
        myAdapter.setNewData(listOf("aaa", "bbb", "ccc", "bbb", "ccc", "bbb", "ccc"))
    }

    override fun loadData(savedInstanceState: Bundle?) {
        refreshRv()
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
    
    /**
     * 刷新界面
     */
    public fun refreshRv() {
        mVM.index = 1
        mVM.getInfoList(myAdapter)
    }
    
     open inner class ${fragmentClass}Adapter : BaseBindingAdapter<String, Item${fragmentClass}Binding>(ArrayList<String>()) {

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