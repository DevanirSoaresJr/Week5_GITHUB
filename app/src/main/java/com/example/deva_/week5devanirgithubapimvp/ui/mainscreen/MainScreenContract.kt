package com.example.deva_.week5devanirgithubapimvp.ui.mainscreen

import com.example.deva_.week5devanirgithubapimvp.base.BasePresenter
import com.example.deva_.week5devanirgithubapimvp.base.BaseView
import com.example.deva_.week5devanirgithubapimvp.model.APIResponse

interface MainScreenContract {
    interface View: BaseView{
        fun showUsers(user: APIResponse)
    }

    interface Presenter: BasePresenter{
        fun getUsers(username: String)
    }

    }
