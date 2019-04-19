package com.example.pertemuan15.AllResult

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pertemuan15.R
import kotlinx.android.synthetic.main.result_fragment.*

class FragmentResult : Fragment(), ViewResult{

    lateinit var presenter : PresenterResult
    companion object {
        fun newInstance() : FragmentResult{
            return FragmentResult()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = PresenterResult()
        onAttachView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_fragment,
        container, false)
    }

    override fun onShowResult(text: String) {
        var tv_result : TextView = activity!!.findViewById(R.id.tv_result)
        tv_result.setText(text)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
        setResult()

    }

    override fun onDetachView() {
    presenter.onDetach()
    }

    override fun onDestroyView() {
        onDetachView()
        super.onDestroyView()
    }
    fun setResult(){
        val bundle : Bundle? = arguments
        val text = bundle!!.getString("data")
        presenter.showResult(text)
    }
}