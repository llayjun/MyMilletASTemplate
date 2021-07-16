/**
 * @description
 * @author Millet
 * @date
 */

package other.mvvm.slideCeilingfragment.app_package

fun mvvmTabCeilingFragmentViewModel(
        packageName: String,
        fragmentClass: String
) = """
package $packageName
import com.hhkj.base_lib.base.BaseVM
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
    
    public fun getInfoList(adapter: ${fragmentClass}Fragment.${fragmentClass}Adapter) {
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
    
}   
 
"""