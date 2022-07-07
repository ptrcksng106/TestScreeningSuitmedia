package com.example.suitmediatestapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmediatestapp.databinding.ItemUserBinding
import com.example.suitmediatestapp.network.DataItem
import com.example.suitmediatestapp.ui.secondscreen.HomeActivity

class UserListAdapter :
    PagingDataAdapter<DataItem, UserListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    class MyViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItem) {

            Glide.with(binding.root.context)
                .load(data.avatar.toUri())
                .into(binding.imagePhoto)
            binding.textViewEmail.text = data.email
            binding.textViewFirstName.text = data.firstName
            binding.textViewLastName.text = data.lastName

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, HomeActivity::class.java).also {
                    it.putExtra(HomeActivity.EXTRA_USER_NAME, data.firstName + " " + data.lastName)
                }

                binding.root.context.startActivity(intent)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}