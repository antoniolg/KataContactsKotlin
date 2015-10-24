package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.ui.ContactsListPresenter

object AgendaApplication {

    fun init() {
        val presenter = getPresenter()
        presenter.onInitialize()
        while (true) {
            presenter.onAddContactOptionSelected()
        }
    }

    private fun getPresenter() = AgendaServiceLocator.contactsListPresenter.apply {
        hookPresenterStopEvent(this)
    }

    private fun hookPresenterStopEvent(presenter: ContactsListPresenter) {
        Runtime.getRuntime().addShutdownHook(Thread() {
            run { presenter.onStop() }
        })
    }
}

fun main(args: Array<String>) {
    AgendaApplication.init()
}