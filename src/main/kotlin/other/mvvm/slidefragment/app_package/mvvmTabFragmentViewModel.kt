/**
 * @description
 * @author Millet
 * @date
 */

package other.mvvm.slidefragment.app_package

fun mvvmTabFragmentViewModel(
        packageName: String,
        fragmentClass: String
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
class ${fragmentClass}FragVM : BaseVM() {

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