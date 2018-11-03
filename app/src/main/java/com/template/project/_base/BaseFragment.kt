package com.template.project._base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EBean
import kotlin.reflect.KProperty

@EBean
abstract class BaseFragment : Fragment() {

    @Bean
    protected lateinit var viewModelFactory: AndroidAnnotationViewModelFactory

    protected final fun <T : ViewModel> provider(cls: Class<T>): ViewModelProviderDelegate<T> {
        val base = this
        return object : ViewModelProviderDelegate<T>() {
            override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
                return ViewModelProviders.of(base, viewModelFactory).get(cls)
            }
        }
    }

}