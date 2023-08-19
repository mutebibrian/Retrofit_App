package com.mastercoding.retrofit_app

import retrofit2.Response
import retrofit2.http.GET

interface AlbumServices {
    //You should specify the endpoints of the URL
@GET("/albums")
    suspend fun getAlbums():Response<albums>
}