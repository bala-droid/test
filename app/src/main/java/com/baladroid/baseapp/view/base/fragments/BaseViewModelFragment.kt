package com.baladroid.baseapp.view.base.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.baladroid.baseapp.view.base.BaseViewModel
import com.baladroid.baseapp.BR
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.baladroid.baseapp.utils.extensions.observeLiveData

abstract class BaseViewModelFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel<Navigation>, Navigation>
(@LayoutRes private val layoutRes: Int) : BaseFragment<ViewBinding, ViewModel>() {


    val root by lazy { binding.root }

    override fun getModelId(): Int = BR.viewModel

    override fun getLayoutRes(): Int = layoutRes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewSecurity.avoidTapJacking(view)

        observeLiveData(viewModel.navigation) {
            lifecycleScope.launch {
                navigate(it)
                delay(350)
            }
        }
    }


    abstract fun navigate(navigation: Navigation)

    open val onBackPressedAction: (() -> Boolean)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedAction?.also { action ->
            activity?.onBackPressedDispatcher?.addCallback(
                this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        if (action.invoke()) {
                            remove()
                            activity?.onBackPressed()
                        }
                    }
                }
            )
        }
    }
}
