package other.mvvm.refreshactivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API


val mvvmRefreshActivityTemplate
    get() = template {
        revision = 1
        name = "Refresh MVVM Activity"
        description = "适用于刷新和加载更多MVVM框架的Activity（Activity和ViewModel和xml和item）"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        // 类名
        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Xxx"
            help = "只输入名字，不要包含Activity，注意布局下划线"
            constraints = listOf(Constraint.NONEMPTY)
        }

        // layout布局
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_xxx"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            // 这边要注意，当Activity输入为驼峰是，这边不会添加_
            suggest = { "activity_${camelCaseToUnderlines(activityClass.value)}" }
        }

        // item layout布局
        val itemLayoutName = stringParameter {
            name = "item Layout Name"
            default = "item_xxx"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            // 这边要注意，当Activity输入为驼峰是，这边不会添加_
            suggest = { "item_${camelCaseToUnderlines(activityClass.value)}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                TextFieldWidget(itemLayoutName),
                PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmRefreshActivityRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    itemLayoutName.value,
                    packageName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.longyan.mmmutually"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }