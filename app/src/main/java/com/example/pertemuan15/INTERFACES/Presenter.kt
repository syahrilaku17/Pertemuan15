package com.example.pertemuan15.INTERFACES

interface Presenter<T: Views> {

    fun onAttach(views: T)
    fun onDetach()
}