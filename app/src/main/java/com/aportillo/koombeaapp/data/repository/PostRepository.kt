package com.aportillo.koombeaapp.data.repository

import androidx.lifecycle.LiveData
import com.aportillo.koombeaapp.data.entities.DataList
import com.aportillo.koombeaapp.data.remote.PostRemoteDataSource
import com.aportillo.koombeaapp.utils.performGetOperation
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
   // , private val localDataSource: PostDao
) {

    lateinit var valueLiveData : LiveData<DataList>
    fun getAllPosts() = performGetOperation(
     //  databaseQuery = { localDataSource.getAllPostList(db = AppDatabase.getDatabase(context)) },
        databaseQuery = { valueLiveData },
        networkCall = { remoteDataSource.getAllPost() },
        saveCallResult = { valueLiveData
            // saveCallResult = { localDataSource.insertAll(it, db = AppDatabase.getDatabase(context))
        }
    )
}