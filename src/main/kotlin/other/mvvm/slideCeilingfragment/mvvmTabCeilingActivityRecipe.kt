
/**
 * @description
 * @author Millet
 * @date 2021/6/24 17:59
 */

package other.mvvm.slideCeilingfragment

//import other.mvvm.activity.src.app_package.mvvmRepository
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.slideCeilingfragment.app_package.mvvmTabCeilingAcitivityKt
import other.mvvm.slideCeilingfragment.app_package.mvvmTabCeilingFragmentKt
import other.mvvm.slideCeilingfragment.app_package.mvvmTabCeilingFragmentViewModel
import other.mvvm.slideCeilingfragment.app_package.mvvmTabCeilingViewModel
import other.mvvm.slideCeilingfragment.layout.mvvmTabCeilingActivityXml
import other.mvvm.slideCeilingfragment.layout.mvvmTabCeilingFragmentItemXml
import other.mvvm.slideCeilingfragment.layout.mvvmTabCeilingFragmentXml

fun RecipeExecutor.mvvmTabCeilingActivityRecipe(
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
    save(mvvmTabCeilingAcitivityKt(projectData.applicationPackage, activityClass, layoutName, fragmentClass, packageName), srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存viewmodel
    save(mvvmTabCeilingViewModel(packageName, activityClass, itemLayoutName), srcOut.resolve("${activityClass}VM.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmTabCeilingActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存Fragment
    save(mvvmTabCeilingFragmentKt(projectData.applicationPackage, fragmentClass, layoutFragmentName, packageName), srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存Fragment viewmodel
    save(mvvmTabCeilingFragmentViewModel(packageName, fragmentClass), srcOut.resolve("${fragmentClass}FragVM.${ktOrJavaExt}"))
    // 保存fragment xml
    save(mvvmTabCeilingFragmentXml(packageName, fragmentClass, itemLayoutName), resOut.resolve("layout/${layoutFragmentName}.xml"))
    // 保存item xml
    save(mvvmTabCeilingFragmentItemXml(packageName, fragmentClass), resOut.resolve("layout/${itemLayoutName}.xml"))
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}