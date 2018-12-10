package com.example.deva_.week5devanirgithubapimvp.model

import com.google.gson.annotations.SerializedName

data class APIResponse (
    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>
)