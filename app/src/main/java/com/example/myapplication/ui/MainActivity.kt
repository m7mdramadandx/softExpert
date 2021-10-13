package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.CarModel
import com.example.myapplication.model.StatusResponse
import com.example.myapplication.network.RetrofitBuilder
import com.example.myapplication.repo.CarsRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CarsViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = ViewModelFactory(CarsRepository(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, viewModelFactory).get(CarsViewModel::class.java)

        retrieveCars()

        binding.swipeLayout.setOnRefreshListener {
            retrieveCars()
            binding.swipeLayout.isRefreshing = false
        }
    }

    private fun retrieveCars() {
        viewModel.retrieveCars(5).observe(this, {
            when (it.statusResponse) {
                StatusResponse.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { list -> initCarsListUI(list) }
                }
                StatusResponse.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMsg.visibility = View.VISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                StatusResponse.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun initCarsListUI(list: MutableList<CarModel>) {
        binding.rvCars.apply {
            adapter = CarsAdapter(list)
            visibility = View.VISIBLE
        }
    }

}