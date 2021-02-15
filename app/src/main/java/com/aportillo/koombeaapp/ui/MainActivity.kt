package com.aportillo.koombeaapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aportillo.koombeaapp.R
import com.aportillo.koombeaapp.utils.Resource
import com.couchbase.lite.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    private lateinit var activityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        CouchbaseLite.init(this)

        setupObservers()



    }

    private fun setupObservers() {
      activityViewModel.allPosts.observe(this, Observer{
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    //     binding.progressBar.visibility = View.GONE
                    //   if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                //     binding.progressBar.visibility = View.VISIBLE
            }
        })
    }
    private fun setupViewModel() {
        try {
            activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java);
            //   adapter.clickCallInc(viewModel)
        }catch (e: Exception){
            Log.e("setupViewModel", e.message.toString())
        }

    }
}