package com.baladroid.baseapp.presentation.main.home


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.baladroid.baseapp.R
import com.baladroid.baseapp.databinding.FragmentHomeBinding
import com.baladroid.baseapp.view.base.fragments.BaseViewModelFragment
import com.baladroid.baseapp.domain.sharedpref.PreferenceRepository
import com.baladroid.baseapp.presentation.main.MainActivity
import com.baladroid.baseapp.utils.extensions.observeLiveData
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment:
    BaseViewModelFragment<FragmentHomeBinding, HomeViewModel, HomeNavigation>(R.layout.fragment_home) {

    private val localViewModel: HomeViewModel by viewModels()

    lateinit var preferenceRepository: PreferenceRepository

    override fun createViewModel(): HomeViewModel {
        return localViewModel
    }
    override fun navigate(navigation: HomeNavigation) {

       //To do
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceRepository = activity?.applicationContext?.let { PreferenceRepository(it) }!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() =
            HomeFragment()
    }



}