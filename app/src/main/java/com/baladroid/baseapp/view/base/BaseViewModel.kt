package com.baladroid.baseapp.view.base

import androidx.lifecycle.*
import com.daimler.myfinance.util.extensions.withLoading
import com.daimler.myfinance.util.livedata.SingleLiveEvent
import kotlinx.coroutines.launch
abstract class BaseViewModel<Navigation>  : ViewModel() {
    val navigation: SingleLiveEvent<Navigation> = SingleLiveEvent()
    val loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val refreshing: MutableLiveData<Boolean> = MutableLiveData(false)




    fun launchLoading() {
        launchWithLoading(loading, this::reloadData)
    }

    fun launchRefresh() {
        launchWithLoading(refreshing, this::reloadData)
    }

    fun launchWithLoading(loading: MutableLiveData<Boolean> = this.loading, work: suspend () -> Unit) {
        viewModelScope.launch {
            loading.withLoading(work)
        }
    }

    abstract suspend fun reloadData()
}
