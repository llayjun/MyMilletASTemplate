/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:01
 */

package other.mvvm.refreshactivity.src.app_package

fun mvvmRefreshViewModel(
        packageName: String,
        activityClass: String
) = """
package $packageName
import com.hhkj.base_lib.base.BaseVM
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
    
    override fun refreshData(refreshLayout: RefreshLayout) {
        super.refreshData(refreshLayout)
        index = 1
        getInfoList(refreshLayout)
    }

    public fun getInfoList(refreshLayout: RefreshLayout?) {
       launch(netBlock = {orderRepository.mallOrderDetail(1)}) {
           refreshLayout?.finishRefresh()
       }
    }
    
}   
 
"""