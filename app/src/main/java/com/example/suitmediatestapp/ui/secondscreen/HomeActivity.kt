package com.example.suitmediatestapp.ui.secondscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.suitmediatestapp.R
import com.example.suitmediatestapp.databinding.ActivityHomeBinding
import com.example.suitmediatestapp.ui.firstscreen.MainActivity
import com.example.suitmediatestapp.ui.thirdscreen.ListActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()

        binding.btnChooseUser.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setUpView() {
        var actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle("HomeActivity")
        }

        val name = intent.getStringExtra(EXTRA_NAME)
        val bundle = Bundle()
        bundle.putString(EXTRA_NAME, name)

        binding.textViewName.text = name

        val username = intent.getStringExtra(EXTRA_USER_NAME)
        bundle.putString(EXTRA_USER_NAME, username)

        binding.textViewSelectedUserName.text = username
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_USER_NAME = "extra_user_name"
    }
}