package com.undabot.newsnow.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.undabot.newsnow.domain.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val articlesRepository: ArticlesRepository,
) : ViewModel() {

  private val _state = MutableStateFlow(HomeScreenState())
  val state: StateFlow<HomeScreenState> = _state.asStateFlow()

  init {
    viewModelScope.launch {
      delay(500)
      val articles = articlesRepository.getArticlesFrom("bbc-news")
      _state.update {
        it.copy(
          isLoading = false,
          articles = articles,
        )
      }
    }
  }
}
