package com.example.suitmediatestapp.ui.firstscreen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediatestapp.databinding.ActivityMainBinding
import com.example.suitmediatestapp.ui.secondscreen.HomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        setUpViewModel()

        binding.btnCheck.setOnClickListener {
            checkPalindrome()
        }

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()

            if (name.isEmpty()) {
                binding.etName.setError("name cannot empty!")
            } else {
                Intent(this, HomeActivity::class.java).also {
                    it.putExtra(HomeActivity.EXTRA_NAME, name)
                    startActivity(it)
                }
            }
        }
    }

    private fun setUpView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]
    }

    private fun checkPalindrome() {
        val name = binding.etName.text.toString()
        val palindrome = binding.etPalindrome.text.toString()

        when {
            name.isEmpty() -> {
                binding.etName.error = "Name cannot empty!"
            }
            palindrome.isEmpty() -> {
                binding.etPalindrome.error = "Palindrome cannot empty!"
            }
            else -> {
                if (viewModel.isPalindrome(palindrome)) {
                    Toast.makeText(this@MainActivity, "Palindrome", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Not Palindrome", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}