package com.antonioleiva.kataagenda.ui

import com.antonioleiva.kataagenda.Contact
import com.antonioleiva.kataagenda.common.ui.Presenter
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.GetContacts

class ContactsListPresenter(view: ContactsListPresenter.View, val addContact: AddContact, val getContacts: GetContacts) :
        Presenter<ContactsListPresenter.View>(view) {

    override fun onInitialize() {
        view.showWelcomeMessage()
        loadContactsList()
    }

    override fun onStop() = view.showGoodbyeMessage()

    fun onAddContactOptionSelected() {
        val contactToAdd = requestNewContact()
        addContact(contactToAdd)
        loadContactsList()
    }

    private fun requestNewContact(): Contact {
        val firstName = view.getNewContactFirstName()
        val lastName = view.getContactLastName()
        val phoneNumber = view.getNewContactPhoneNumber()
        return Contact(firstName, lastName, phoneNumber)
    }

    private fun loadContactsList() {
        val contactList = getContacts()
        view.showContacts(contactList)
    }

    interface View : Presenter.View {

        fun showWelcomeMessage()

        fun showGoodbyeMessage()

        fun getNewContactFirstName(): String

        fun getContactLastName(): String

        fun getNewContactPhoneNumber(): String

        fun showContacts(contactList: List<Contact>)
    }
}
