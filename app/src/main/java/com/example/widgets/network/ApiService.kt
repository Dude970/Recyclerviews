package com.example.widgets.network

import com.example.widgets.data.AlbumsItems
import com.example.widgets.data.PhotosItems
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhotosFromServer(): Response<List<PhotosItems>>

    @GET("albums")
    suspend fun getAlbumsFromServer(): Response<List<AlbumsItems>>
}