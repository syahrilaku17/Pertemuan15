package com.example.pertemuan15.AllResult

import com.example.pertemuan15.INTERFACES.Presenter

class PresenterResult : Presenter<ViewResult> {

    var mViewResult : ViewResult? = null

    override fun onAttach(views: ViewResult) {
        mViewResult = views
    }

    override fun onDetach() {
        mViewResult = null
    }
    fun showResult(text: String){
        mViewResult?.onShowResult(text)
    }

}