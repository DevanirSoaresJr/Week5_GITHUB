package com.example.deva_.week5devanirgithubapimvp.ui.mainscreen

import android.util.Log
import com.example.deva_.week5devanirgithubapimvp.model.APIResponse
import com.example.deva_.week5devanirgithubapimvp.repository.RepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainScreenPresenter (private val view: MainScreenContract.View):MainScreenContract.Presenter{
   private val TAG = "MainScreenPresenter"
    private lateinit var repositoryImpl: RepositoryImpl
   //Making this Class a Singleton


    override fun getUsers(username: String) {
        repositoryImpl.getUsers(username)
            .subscribe(object : SingleObserver<APIResponse>{


               override fun onSuccess(t: APIResponse) {
                    for (i in 0 until t.items.size){
                        view.showUsers(t)
                        Log.d(TAG, t.items[i].login)
                    }
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
}

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    override fun onCreate() {
        repositoryImpl = RepositoryImpl()
    }

}