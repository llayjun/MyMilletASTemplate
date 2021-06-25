package other

/**
 * @description
 * @author Millet
 * @date 2021/6/24 17:56
 */

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.activity.mvvmActivityTemplate
import other.mvvm.refreshactivity.mvvmRefreshActivityTemplate
//import other.mvvm.fragment.mvvmFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
            // activity的模板
            mvvmActivityTemplate,
            // activity列表刷新的模板
            mvvmRefreshActivityTemplate
            // fragment的模板
//            mvvmFragmentTemplate
    )
}