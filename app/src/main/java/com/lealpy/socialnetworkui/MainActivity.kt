package com.lealpy.socialnetworkui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.lealpy.socialnetworkui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = MainViewModel()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        initObservers()

    }

    private fun initViews() {

        binding.apply {

            profileSettings.setOnClickListener {
                viewModel.onClicked()
            }

            notifications.setOnClickListener {
                viewModel.onClicked()
            }

            language.setOnClickListener {
                viewModel.onClicked()
            }

            confidentiality.setOnClickListener {
                viewModel.onClicked()
            }

            support.setOnClickListener {
                viewModel.onClicked()
            }

            decoration.setOnClickListener {
                viewModel.onClicked()
            }

            logout.setOnClickListener {
                viewModel.onClicked()
            }

            navView.selectedItemId = R.id.navigationProfile

            navView.setOnItemSelectedListener {
                viewModel.onClicked()
                true
            }

            statusText.addTextChangedListener {
                viewModel.onSymbolEntered(statusText.length())
            }

            statusLayout.setEndIconOnClickListener {
                viewModel.onClicked()
            }

        }

    }

    private fun initObservers() {

        viewModel.clickCounter.observe(this, {clickCounter ->
            binding.clickCounter.text = clickCounter.toString()
        })

        viewModel.countersProgress.observe(this, {countersProgress ->
            binding.clickProgressBar.progress = countersProgress
        })

        viewModel.symbolsCounter.observe(this, {symbolsCounter ->
            binding.symbolsCounter.text = symbolsCounter.toString()
        })

        viewModel.symbolsProgress.observe(this, {symbolsProgress ->
            binding.symbolsProgressBar.progress = symbolsProgress
        })
    }

}
