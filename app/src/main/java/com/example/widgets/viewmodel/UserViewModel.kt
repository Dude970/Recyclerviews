package com.example.widgets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.widgets.data.AlbumsItems
import com.example.widgets.data.PhotosItems
import com.example.widgets.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

    val retrofit = RetrofitClient.retrofit

    private val photosRespnose = MutableLiveData<List<PhotosItems>>()
    val _photosResponse: LiveData<List<PhotosItems>> = photosRespnose

    private val albumResponse = MutableLiveData<List<AlbumsItems>>()
    val _albumResponse: LiveData<List<AlbumsItems>> = albumResponse

    fun getData() {
        CoroutineScope(Dispatchers.IO).async {
            val photos = retrofit.getPhotosFromServer()
            val albums = retrofit.getAlbumsFromServer()

          withContext(Dispatchers.Main) {
                if (photos.isSuccessful) {
                    photosRespnose.value = photos.body()
                }
                if (albums.isSuccessful) {
                    albumResponse.value = albums.body()
                }
           }

        }
    }
}