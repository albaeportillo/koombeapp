package com.aportillo.koombeaapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aportillo.koombeaapp.data.repository.PostRepository


class MainActivityViewModel @ViewModelInject constructor(repository: PostRepository
) : ViewModel() {

    val allPosts = repository.getAllPosts()
}
