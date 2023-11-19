package com.slvmk.restaurants_demo.ui.business_location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slvmk.R
import com.slvmk.restaurants_demo.domain.DataResult
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocation
import com.slvmk.restaurants_demo.domain.business_location.repository.LocationBusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by SlavaMk on 2/27/23.
 */
@HiltViewModel
class LocationListViewModelV2 @Inject constructor(
    private val repository: LocationBusinessRepository
) : ViewModel() {

    private val _messageData: MutableLiveData<Int> = MutableLiveData()
    val messageData: LiveData<Int> get() = _messageData

    private val _data: MutableLiveData<List<BusinessLocation>> = MutableLiveData()
    val data: LiveData<List<BusinessLocation>> get() = _data

    private val _dataLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val dataLoading: LiveData<Boolean> get() = _dataLoading

    fun fetchData(locationName: String) {
        viewModelScope.launch {
            try {
                _dataLoading.value = true
                val result = withContext(Dispatchers.IO) {

                    val map = HashMap<String, String>()
                    map["location"] = locationName
                    repository.getLocationBusinesses(map)
                }
                _dataLoading.value = false
                when (result) {
                    is DataResult.Success -> {
                        _data.postValue(result.data.list)
                        if (result.data.list.isEmpty()) {
                            _messageData.postValue(R.string.no_results)
                        }
                    }
                    is DataResult.Error -> {
                        _messageData.postValue(R.string.error)
                    }
                    else -> {
                        _messageData.postValue(R.string.no_results)
                    }
                }
            } catch(e: Exception) {
                _messageData.postValue(R.string.error)
            }
        }
    }
}