package com.aportillo.koombeaapp.data.remote

import javax.inject.Inject


class PostRemoteDataSource @Inject constructor(
    private val postService: PostService
): BaseDataSource() {

    suspend fun getAllPost() = getResult { postService. getAllPost() }
}