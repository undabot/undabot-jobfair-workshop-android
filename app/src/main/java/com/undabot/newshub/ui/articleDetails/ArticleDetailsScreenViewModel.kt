package com.undabot.newshub.ui.articleDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.undabot.newshub.domain.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsScreenViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle,
  private val articlesRepository: ArticlesRepository,
) : ViewModel() {

  private val _state = MutableStateFlow(ArticleDetailsScreenState())
  val state: StateFlow<ArticleDetailsScreenState> = _state.asStateFlow()

  init {
    viewModelScope.launch {
      val articleId = savedStateHandle.get<String>("articleId")!!
      val article = articlesRepository.getArticle(articleId)
      _state.update {
        it.copy(
          isLoading = false,
          article = article,
        )
      }
    }
  }
}
