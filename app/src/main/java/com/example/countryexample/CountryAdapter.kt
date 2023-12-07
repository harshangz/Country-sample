package com.example.countryexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countryexample.databinding.CountryListItemBinding

class CountryAdapter(val countries: Country) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryListItemBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(private val binding: CountryListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: CountryItem) {
            binding.lblNameRegion.text = "${country.name}  ${country.region}"
            binding.lblCode.text = country.code
            binding.lblCapital.text = country.capital
        }
    }
}