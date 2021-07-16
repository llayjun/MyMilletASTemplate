
/**
 * @description
 * @author Millet
 * @date 2021/6/24 17:59
 */

package other.mvvm.refreshactivity

//import other.mvvm.activity.src.app_package.mvvmRepository
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.refreshactivity.res.layout.mvvmRefreshActivityItemXml
import other.mvvm.refreshactivity.res.layout.mvvmRefreshActivityXml
import other.mvvm.refreshactivity.src.app_package.mvvmRefreshAcitivityKt
import other.mvvm.refreshactivity.src.app_package.mvvmRefreshViewModel

fun RecipeExecutor.mvvmRefreshActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
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
    save(mvvmRefreshAcitivityKt(projectData.applicationPackage, activityClass, layoutName, packageName), srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmRefreshActivityXml(packageName, activityClass, itemLayoutName), resOut.resolve("layout/${layoutName}.xml"))
    // 保存item xml
    save(mvvmRefreshActivityItemXml(packageName, activityClass), resOut.resolve("layout/${itemLayoutName}.xml"))
    // 保存viewmodel
    save(mvvmRefreshViewModel(packageName, activityClass), srcOut.resolve("${activityClass}VM.${ktOrJavaExt}"))
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}