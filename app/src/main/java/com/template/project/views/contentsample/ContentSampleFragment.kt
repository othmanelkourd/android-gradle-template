package com.template.project.views.contentsample

import com.template.project.R
import com.template.project.tools.BaseFragment
import kotlinx.android.synthetic.main.fragment_content_sample.*
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

@EFragment(R.layout.fragment_content_sample)
class ContentSampleFragment : BaseFragment() {

    private val model: ContentViewModel by viewModel()

    @AfterViews
    fun connectModel() {
        showUpNavigation()
        model.observerTodo(this) {
            list.adapter = ContentAdapter(it.toTypedArray())
        }
    }
}
