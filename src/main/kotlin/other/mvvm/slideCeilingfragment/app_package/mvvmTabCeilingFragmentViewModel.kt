/**
 * @description
 * @author Millet
 * @date
 */

package other.mvvm.slideCeilingfragment.app_package

fun mvvmTabCeilingFragmentViewModel(
        packageName: String,
        fragmentClass: String,
        itemLayoutName: String
) = """
package $packageName
import com.hhkj.base_lib.base.BaseVM
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import ${packageName}.order.repository.MeowCoinOrderRepository

/**
 * @description
 * @author Millet
 * @date 
 */
class ${fragmentClass}FragVM : BaseVM() {

    private val orderRepository by lazy {
        MeowCoinOrderRepository()
    }

    public var index = 1
    
    var adapter: My${fragmentClass}Adapter = My${fragmentClass}Adapter()
    
    public fun initListener() {
        // item点击
        adapter.setOnItemClickListener { adapter, view, position ->

        }
        // item child点击
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {

            }
        }
    }
    
    public fun getInfoList(currentPage: Int) {
//        launch(netBlock = { orderRepository.mallOrderDetail(1) }) {
//            val list = it.data?.records ?: ArrayList()
//            if (index == 1) {
//                adapter.setNewData(list)
//                adapter.setEnableLoadMore(true)
//            } else {
//                adapter.addData(list)
//                if (it.data?.pages ?: 0 <= index) {
//                    adapter.setEnableLoadMore(false)
//                }
//            }
//        }
    }
    
    public fun adapterLoadMoreData(recyclerView: RecyclerView) {
        adapter.setOnLoadMoreListener({
            index++
            getInfoList(index)
        }, recyclerView)
    }
    
    open inner class My${fragmentClass}Adapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.${itemLayoutName}, ArrayList<String>()) {

        override fun convert(holder: BaseViewHolder, item: String?) {
//            val header = holder.getView<RImageView>(R.id.ri_header)
        }

    }
    
}   
 
"""