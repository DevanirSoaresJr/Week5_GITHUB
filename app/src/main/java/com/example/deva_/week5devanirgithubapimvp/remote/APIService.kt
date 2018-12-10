package com.example.deva_.week5devanirgithubapimvp.remote

import com.example.deva_.week5devanirgithubapimvp.model.APIResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("search/users")
    fun getUsers(@Query("q") user: String):Single<APIResponse>
}