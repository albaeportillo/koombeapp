package com.aportillo.koombeaapp.data.remote

import com.aportillo.koombeaapp.data.entities.Data
import com.aportillo.koombeaapp.data.entities.DataList
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("mt/api/posts/")
    suspend fun getAllPost() : Response<Data>


}