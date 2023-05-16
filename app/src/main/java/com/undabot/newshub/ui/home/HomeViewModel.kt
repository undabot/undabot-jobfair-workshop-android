package com.undabot.newshub.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.undabot.newshub.domain.model.Source
import com.undabot.newshub.domain.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
      val availableSources = articlesRepository.getAvailableSources()
      val initSource = availableSources.first()
      val articles = articlesRepository.getArticlesFrom(initSource)
      _state.update {
        it.copy(
          isLoading = false,
          articles = articles,
          availableSources = availableSources,
          currentSource = initSource,
        )
      }
    }
  }

  fun changeSource(source: Source) {
    viewModelScope.launch {
      _state.update {
        it.copy(
          isLoading = true,
        )
      }
      val articles = articlesRepository.getArticlesFrom(source)
      _state.update {
        it.copy(
          isLoading = false,
          articles = articles,
          currentSource = source,
        )
      }
    }
  }
}
