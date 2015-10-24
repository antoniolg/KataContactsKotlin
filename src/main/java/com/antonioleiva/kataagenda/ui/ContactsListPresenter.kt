package com.antonioleiva.kataagenda.ui

import com.antonioleiva.kataagenda.common.ui.Presenter

class ContactsListPresenter(view: ContactsListPresenter.View) : Presenter<ContactsListPresenter.View>(view) {

    override fun onInitialize() = Unit
    override fun onStop() = Unit

    interface View : Presenter.View
}