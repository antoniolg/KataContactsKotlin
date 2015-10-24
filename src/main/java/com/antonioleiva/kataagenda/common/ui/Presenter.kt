package com.antonioleiva.kataagenda.common.ui

abstract class Presenter<T : Presenter.View>(val view: T) {

    abstract fun onInitialize()
    abstract fun onStop()

    interface View {
        fun showDefaultError()
        fun showEmptyCase()
    }
}