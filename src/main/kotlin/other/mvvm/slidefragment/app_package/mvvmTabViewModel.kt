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
import com.hhkj.base_lib.base.BaseVM
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
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

    public val fragmentList = ArrayList<Fragment>()
    
    public val tagArray = listOf("具体描述", "购买须知", "宠友评价")

    public val infoLiveData by lazy {
        MutableLiveData<Any>()
    }

    public fun getInfoList(refreshLayout: RefreshLayout?) {
        launch(netBlock = { orderRepository.mallOrderDetail(1) }) {
            refreshLayout?.finishRefresh()
            infoLiveData.value = it.data
        }
    }
    
}   
 
"""