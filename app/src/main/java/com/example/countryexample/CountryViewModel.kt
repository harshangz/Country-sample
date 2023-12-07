package com.example.countryexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val _countries = MutableLiveData<Country>()
    val countries: LiveData<Country> get() = _countries

    fun loadCountries() {
        viewModelScope.launch {
            try {
                val countryList = RetrofitClient.apiService.getCountryList()
                _countries.value = countryList
            } catch (e: Exception) {
                // Handle error, for example, show an error message
            }
        }
    }
}
