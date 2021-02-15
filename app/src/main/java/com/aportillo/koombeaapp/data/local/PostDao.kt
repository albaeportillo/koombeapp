package com.aportillo.koombeaapp.data.local

import androidx.lifecycle.MutableLiveData
import com.aportillo.koombeaapp.data.entities.DataList
import com.couchbase.lite.Database
import javax.inject.Singleton

@Singleton
interface PostDao {

    fun getAllPostList(db: Database) : MutableLiveData<DataList>
    suspend fun insertAll(postList: DataList, db: Database)

}