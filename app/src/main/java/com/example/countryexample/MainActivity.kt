package com.example.countryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CountryAdapter
    private lateinit var countryViewModel: CountryViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        actionBar?.show()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        countryViewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

        countryViewModel.countries.observe(this, Observer { countryList ->
            updateRecyclerView(countryList)
        })

        if (savedInstanceState == null) {
            // Load data for the first time
            countryViewModel.loadCountries()
        }
    }

    private fun updateRecyclerView(countryList: Country?) {
        if (countryList != null) {
            adapter = CountryAdapter(countryList)
            binding.recyclerView.adapter = adapter
            binding.lblNoData.visibility = View.GONE
        } else {
            // Handle null or empty list
            binding.lblNoData.visibility = View.VISIBLE
        }
    }

}