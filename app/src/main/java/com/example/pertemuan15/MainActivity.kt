package com.example.pertemuan15

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.pertemuan15.AllResult.FragmentResult
import com.example.pertemuan15.MAIN.MainPresenter
import com.example.pertemuan15.MAIN.MainView
import com.example.pertemuan15.MODEL.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onShowFragment(data: Data) {
      val bundle = Bundle()
        bundle.putString("data", data.text)

        val tag : String = FragmentResult::class.java.simpleName
        val fragment : Fragment = FragmentResult.newInstance()
        fragment.arguments = bundle

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_main,fragment, tag)
        fragmentTransaction.commit()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
        btn_main.setOnClickListener {
            btn_main.visibility = View.GONE
            presenter.ShowFragment()
        }
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        onAttachView()

    }
}
