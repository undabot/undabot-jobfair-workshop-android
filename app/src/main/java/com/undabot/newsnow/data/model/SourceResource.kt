package com.undabot.newsnow.data.model

import com.squareup.moshi.JsonClass
import com.undabot.newsnow.domain.model.Source

@JsonClass(generateAdapter = true)
data class SourceResource(
  val id: String? = null,
  val name: String? = null,
) {

  fun toDomain(): Source {
    return Source(
      id = id!!,
      name = name.orEmpty(),
    )
  }
}
