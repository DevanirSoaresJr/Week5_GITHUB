package com.example.deva_.week5devanirgithubapimvp.repository

import com.example.deva_.week5devanirgithubapimvp.model.APIResponse
import io.reactivex.Single

interface Repository {
    fun getUsers(username: String): Single<APIResponse>
}