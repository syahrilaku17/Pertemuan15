package com.example.pertemuan15.MAIN

import com.example.pertemuan15.INTERFACES.Views
import com.example.pertemuan15.MODEL.Data

interface MainView: Views {

    fun onShowFragment(data : Data)

}