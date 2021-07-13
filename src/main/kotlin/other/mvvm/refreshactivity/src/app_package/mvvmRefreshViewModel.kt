/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:01
 */

package other.mvvm.refreshactivity.src.app_package

fun mvvmRefreshViewModel(
        packageName: String,
        activityClass: String,
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
class ${activityClass}VM : BaseVM() {

    private val orderRepository by lazy {
        MeowCoinOrderRepository()
    }

    public var index = 1
    
    var adapter: My${activityClass}Adapter = My${activityClass}Adapter()
    
    init {
        // item点击
        adapter.setOnItemClickListener { adapter, view, position -> 
            
        }
        // item child点击
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                
            }
        }
    }
    
    override fun refreshData(refreshLayout: RefreshLayout) {
        super.refreshData(refreshLayout)
        index = 1
        getInfoList(refreshLayout)
    }

    public fun adapterLoadMoreData(recyclerView: RecyclerView) {
        adapter.setOnLoadMoreListener({
            index++
            getInfoList(null)
        }, recyclerView)
    }
    
    public fun getInfoList(refreshLayout: RefreshLayout?) {
       launch(netBlock = {orderRepository.mallOrderDetail(1)}) {
           refreshLayout?.finishRefresh()
       }
    }
    
    open inner class My${activityClass}Adapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.${itemLayoutName}, ArrayList<String>()) {

        override fun convert(holder: BaseViewHolder, item: String?) {
//            val header = holder.getView<RImageView>(R.id.ri_header)
        }

    }
    
}   
 
"""