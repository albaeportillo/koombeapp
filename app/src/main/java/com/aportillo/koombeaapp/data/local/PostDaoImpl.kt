package com.aportillo.koombeaapp.data.local

import androidx.lifecycle.MutableLiveData
import com.aportillo.koombeaapp.data.entities.DataList
import com.couchbase.lite.*
import javax.inject.Inject


class PostDaoImpl @Inject constructor(
    private val bd: Database
): PostDao {
    private val postListLiveData = MutableLiveData<DataList>()

     override fun getAllPostList(_db: Database): MutableLiveData<DataList> {

        val query: Query = QueryBuilder.select(SelectResult.all())
            .from(DataSource.database(_db))

         val result = query.execute()
         var postListLiveData = MutableLiveData<DataList>()

         result.allResults()
         var postList : DataList
         for (item in result.allResults()) {
              postList = item.getDictionary("data") as DataList
              postListLiveData.value = postList
         }
        return postListLiveData

     }

    override suspend  fun insertAll(postList: DataList, _db: Database) {
      //  var array = postList.toTypedArray()
        var mutableDoc = MutableDocument()
                .setValue("data",postList)
            _db.save(mutableDoc)
    }
}