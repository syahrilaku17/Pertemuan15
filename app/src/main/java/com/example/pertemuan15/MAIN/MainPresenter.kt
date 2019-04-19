package com.example.pertemuan15.MAIN

import com.example.pertemuan15.INTERFACES.Presenter
import com.example.pertemuan15.MODEL.Data

class MainPresenter : Presenter<MainView>{

    private var mView : MainView? = null

    override fun onAttach(views: MainView) {
        mView = views
    }

    override fun onDetach() {
        mView = null
    }

    fun ShowFragment(){
        val data = Data()
        data.text = "Hello From Data !"

        mView?.onShowFragment(data)
    }
}