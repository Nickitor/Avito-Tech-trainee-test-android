package com.nikitazamyslov.avito_tech_trainee_test_android

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.nikitazamyslov.avito_tech_trainee_test_android.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapterRv: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterRv = Adapter()
        binding.recyclerView.adapter = adapterRv
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.data.collect { data ->
                    adapterRv.submitList(data)
                }
            }
        }
    }

    private fun setListeners() {
        adapterRv.clickListener = {
            viewModel.deleteItem(it)
        }
    }
}