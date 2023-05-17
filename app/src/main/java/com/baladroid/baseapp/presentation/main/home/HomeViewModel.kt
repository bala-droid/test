package com.baladroid.baseapp.presentation.main.home

import com.baladroid.baseapp.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
)  : BaseViewModel<HomeNavigation>() {

    override suspend fun reloadData() {

    }

}