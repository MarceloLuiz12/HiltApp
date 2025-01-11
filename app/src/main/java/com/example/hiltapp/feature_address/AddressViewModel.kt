package com.example.hiltapp.feature_address

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltapp.domain.model.AddressModel
import com.example.hiltapp.domain.usecase.GetAddressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    private val getAddressUseCase: GetAddressUseCase
) : ViewModel() {

    var address by mutableStateOf<AddressModel?>(null)
        private set

    fun fetchAddress(cep: String) {
        viewModelScope.launch {
            val result = getAddressUseCase(cep)
            address = result
        }
    }
}
