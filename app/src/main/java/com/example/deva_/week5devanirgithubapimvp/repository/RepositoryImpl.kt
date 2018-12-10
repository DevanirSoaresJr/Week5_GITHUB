package com.example.deva_.week5devanirgithubapimvp.repository

import com.example.deva_.week5devanirgithubapimvp.model.APIResponse
import com.example.deva_.week5devanirgithubapimvp.remote.RemoteHelp
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl: Repository {

    override fun getUsers(username: String): Single<APIResponse> {
        return  RemoteHelp.getUsers(username)
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())

    }
}