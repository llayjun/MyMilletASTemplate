/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:01
 */

package other.mvvm.activity.src.app_package

fun mvvmViewModel(
        packageName: String,
        activityClass: String
) = """
package $packageName
import com.hhkj.base_lib.base.BaseVM
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

    public fun getInfo() {
        launch(netBlock = { orderRepository.mallOrderDetail(1) }) {

        }
    }
    
}   
 
"""