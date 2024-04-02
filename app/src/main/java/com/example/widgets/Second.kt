package com.example.widgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgets.adapter.PhotoAdapter
import com.example.widgets.adapter.UserAlbumAdapter
import com.example.widgets.viewmodel.UserViewModel

class Second : AppCompatActivity() {

    private lateinit var recy1: RecyclerView
    private lateinit var recy2: RecyclerView

    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        recy1 = findViewById(R.id.recyclerView1)
        recy2 = findViewById(R.id.recyclerView2)

        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        subscribeLiveData()
    }





    private fun subscribeLiveData() {
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        recy1.layoutManager =
            LinearLayoutManager(this@Second, LinearLayoutManager.VERTICAL, false)
        recy2.layoutManager = GridLayoutManager(this, 4)

        viewModel.apply {
            _photosResponse.observe(this@Second) { photo ->
                recy2.adapter = PhotoAdapter(photo)
            }
            _albumResponse.observe(this@Second) { album ->
                recy1.adapter = UserAlbumAdapter(album)

            }
        }
        viewModel.getData()
    }
}