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
import ${packageName}.base.mvvm.BaseVM
import ${packageName}.http.NetResponseObserver
import ${packageName}.http.engine.ServicesEngine
import ${packageName}.view.dialog.CommonLoadingDialog

/**
 * @description
 * @author Millet
 * @date 
 */
class ${activityClass}VM : BaseVM() {
    
    public fun getInfo() {
        ServicesEngine.businessBanner().subscribe(object : NetResponseObserver<List<String>>(CommonLoadingDialog(mActivity)) {

            override fun success(data: List<String>?) {
                
            }

        })
    }
    
}   
 
"""