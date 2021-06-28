/**
 * @description
 * @author Millet
 * @date
 */

package other.mvvm.slidefragment.app_package

fun mvvmTabViewModel(
        packageName: String,
        activityClass: String,
        itemLayoutName: String
) = """
package $packageName
import ${packageName}.base.mvvm.BaseVM
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import ${packageName}.bean.PageListResult
import ${packageName}.http.NetResponseObserver
import ${packageName}.http.engine.ServicesEngine
import com.scwang.smartrefresh.layout.api.RefreshLayout

/**
 * @description
 * @author Millet
 * @date 
 */
class ${activityClass}VM : BaseVM() {

    public val fragmentList = ArrayList<Fragment>()
    
    public val tagArray = listOf("具体描述", "购买须知", "宠友评价")

    public var index = 1
    
    var adapter: MyXxxAdapter = MyXxxAdapter()
    
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
    
    override fun refreshData(refreshLayout: RefreshLayout) {
        super.refreshData(refreshLayout)
        index = 1
        getXxxList(refreshLayout)
    }

    public fun adapterLoadMoreData(recyclerView: RecyclerView) {
        adapter.setOnLoadMoreListener({
            index++
            getXxxList(null)
        }, recyclerView)
    }
    
    public fun getXxxList(refreshLayout: RefreshLayout?) {
        val map: MutableMap<String, Any> = HashMap()
        map["lon"] = ""
        map["lat"] = ""
        ServicesEngine.homeShopList(map).subscribe(object : NetResponseObserver<PageListResult<String>>() {

            override fun success(data: PageListResult<String>?) {
                refreshLayout?.finishRefresh()
                adapter.loadMoreComplete()
                if (index == 1) {
                    adapter.setNewData(data?.records)
                    refreshLayout?.finishRefresh()
                    adapter.setEnableLoadMore(true)
                } else {
                    adapter.addData(data?.records ?: ArrayList())
                    refreshLayout?.finishLoadMore()
                    if (data?.pages?.toInt() ?: 0 <= index) {
                        adapter.setEnableLoadMore(false)
                    }
                }
            }

            override fun onFailure(respCode: String?, msg: String?) {
                super.onFailure(respCode, msg)
                refreshLayout?.finishRefresh()
                adapter.loadMoreFail()
            }

        })
    }
    
    open inner class MyXxxAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.${itemLayoutName}, ArrayList<String>()) {

        override fun convert(holder: BaseViewHolder, item: String?) {
//            val banner = holder.getView<TextView>(R.id.banner)
        }

    }
    
}   
 
"""