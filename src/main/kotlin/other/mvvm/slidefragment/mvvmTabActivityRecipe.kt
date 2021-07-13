
/**
 * @description
 * @author Millet
 * @date 2021/6/24 17:59
 */

package other.mvvm.slidefragment

//import other.mvvm.activity.src.app_package.mvvmRepository
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.slidefragment.app_package.mvvmTabActivityKt
import other.mvvm.slidefragment.app_package.mvvmTabFragmentKt
import other.mvvm.slidefragment.app_package.mvvmTabFragmentViewModel
import other.mvvm.slidefragment.app_package.mvvmTabViewModel
import other.mvvm.slidefragment.layout.mvvmTabActivityXml
import other.mvvm.slidefragment.layout.mvvmTabFragmentItemXml
import other.mvvm.slidefragment.layout.mvvmTabFragmentXml

fun RecipeExecutor.mvvmTabActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        fragmentClass: String,
        layoutFragmentName: String,
        itemLayoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

    // 保存Activity
    save(mvvmTabActivityKt(projectData.applicationPackage, activityClass, layoutName, fragmentClass, packageName), srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存viewmodel
    save(mvvmTabViewModel(packageName, activityClass, itemLayoutName), srcOut.resolve("${activityClass}VM.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmTabActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存Fragment
    save(mvvmTabFragmentKt(projectData.applicationPackage, fragmentClass, layoutFragmentName, activityClass, packageName), srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存Fragment viewmodel
    save(mvvmTabFragmentViewModel(packageName, fragmentClass, itemLayoutName), srcOut.resolve("${fragmentClass}FragVM.${ktOrJavaExt}"))
    // 保存fragment xml
    save(mvvmTabFragmentXml(packageName, fragmentClass, itemLayoutName), resOut.resolve("layout/${layoutFragmentName}.xml"))
    // 保存item xml
    save(mvvmTabFragmentItemXml(packageName, fragmentClass), resOut.resolve("layout/${itemLayoutName}.xml"))
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}