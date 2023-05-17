package com.baladroid.baseapp.presentation.main

import com.baladroid.baseapp.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): BaseViewModel<MainNavigation>() {



    override suspend fun reloadData() {
        TODO("Not yet implemented")
    }


}