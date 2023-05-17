package com.baladroid.baseapp.view.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class BaseFragment<Binding : ViewDataBinding, Model : ViewModel> :
    Fragment(), ViewModelOwner<Binding, Model> {

    /**
     * This field contains the activity's [ViewModel] after this activity has been created.
     * The access to this field is read-only.
     */
    lateinit var viewModel: Model
        private set

    protected lateinit var binding: Binding
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = createViewModel()
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.apply {
            setVariable(getModelId(), viewModel)
            lifecycleOwner = provideLifecycleOwner()
            onBindingCreated(this)
        }
        return binding.root
    }

    override fun provideLifecycleOwner(): LifecycleOwner = this

    override fun onBindingCreated(binding: Binding) = Unit
}
