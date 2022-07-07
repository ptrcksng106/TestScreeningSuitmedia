package com.example.suitmediatestapp.ui.thirdscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediatestapp.adapter.LoadingStateAdapter
import com.example.suitmediatestapp.adapter.UserListAdapter
import com.example.suitmediatestapp.databinding.ActivityListBinding
import com.example.suitmediatestapp.ui.firstscreen.MainActivity
import com.example.suitmediatestapp.ui.secondscreen.HomeActivity

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val listViewModel: ListViewModel by viewModels {
        ListViewModel.ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        getData()
    }

    private fun setUpView() {
        var actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle("ListActivity")
        }
    }

    private fun getData() {
        val adapter = UserListAdapter()
        binding.rvUser.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )

        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.setHasFixedSize(true)

        listViewModel.user.observe(this, {
            adapter.submitData(lifecycle, it)
            Log.d("CEK DATA", "$it")
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        return true
    }
}