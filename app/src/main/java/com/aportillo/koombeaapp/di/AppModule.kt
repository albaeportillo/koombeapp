package com.aportillo.koombeaapp.di

import android.content.Context
import com.aportillo.koombeaapp.BuildConfig
import com.aportillo.koombeaapp.data.local.AppDatabase
import com.aportillo.koombeaapp.data.remote.PostRemoteDataSource
import com.aportillo.koombeaapp.data.remote.PostService
import com.aportillo.koombeaapp.data.repository.PostRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit {
        val clientBuilder = OkHttpClient.Builder()
        val client: OkHttpClient = clientBuilder.build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

   @Provides
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)

   @Singleton
    @Provides
    fun providePostRemoteDataSource(postService: PostService) =
        PostRemoteDataSource(postService)



 /*   @Singleton
    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()*/

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: PostRemoteDataSource
        //,
        //   localDataSource: PostDao
    ) =
        PostRepository(remoteDataSource)


}
