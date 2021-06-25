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

/**
 * @description
 * @author Millet
 * @date 
 */
class ${activityClass}VM : BaseVM() {
    
}   
 
"""