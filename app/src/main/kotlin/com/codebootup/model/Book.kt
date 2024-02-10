package com.codebootup.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Book(
    @get:JsonProperty("id", required = false) val id: String?,
    @get:JsonProperty("title", required = false) val title: String?,
    @get:JsonProperty("author", required = false) val author: String?,
)
