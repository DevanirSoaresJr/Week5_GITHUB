package com.example.deva_.week5devanirgithubapimvp.ui.mainscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.deva_.week5devanirgithubapimvp.R
import com.example.deva_.week5devanirgithubapimvp.adapter.RecyclerViewAdapter
import com.example.deva_.week5devanirgithubapimvp.base.BaseActivity
import com.example.deva_.week5devanirgithubapimvp.model.APIResponse
import com.example.deva_.week5devanirgithubapimvp.model.UserData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainScreenContract.Presenter>(),MainScreenContract.View, RecyclerViewAdapter.OnItemClickedListener {


    lateinit var presenter: MainScreenPresenter

    lateinit var userList: ArrayList<UserData>
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userList= ArrayList()
        layoutManager = LinearLayoutManager(this)


        presenter = MainScreenPresenter(this)
        presenter.onCreate()
    }
    override fun init() {

    }

    override fun getViewPresenter(): MainScreenContract.Presenter = presenter

    override fun showUsers(user: APIResponse) {
     userList.clear()
        for (i in 0 until user.items.size){
            userList.add(UserData(user.items[i].login, user.items[i].avatarUrl, user.items[i].reposUrl))
        }
        adapter = RecyclerViewAdapter(userList, this)
        rvUsers.layoutManager = layoutManager
        rvUsers.adapter = adapter
    }
    fun onClicked(view: View){
        val userName = etSearch.text.toString()
        presenter.getUsers(userName)
    }
    override fun onItemClicked(position: Int) {

    }
}
