package com.antonioleiva.kataagenda.ui

import com.antonioleiva.kataagenda.common.ui.Presenter
import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.GetContacts

class ContactsListPresenter(
        view: ContactsListPresenter.View,
        private val addContact: AddContact,
        private val getContacts: GetContacts) : Presenter<ContactsListPresenter.View>(view) {

    override fun onInitialize() {
        view.showWelcomeMessage()
        loadContactsList()
    }

    override fun onStop() = view.showGoodbyeMessage()

    fun onAddContactOptionSelected() {
        val contactToAdd = requestNewContact()
        contactToAdd?.let {
            addContact(contactToAdd)
            loadContactsList()
        } ?: view.showDefaultError()
    }

    private fun requestNewContact(): Contact? {
        val firstName = view.getNewContactFirstName()
        val lastName = view.getNewContactLastName()
        val phoneNumber = view.getNewContactPhoneNumber()

        return if (isContactInfoValid(firstName, lastName, phoneNumber)) {
            Contact(firstName, lastName, phoneNumber)
        } else {
            null
        }
    }

    private fun isContactInfoValid(vararg info: String) = info.none { it.trim().isEmpty() }

    private fun loadContactsList() {
        val contactList = getContacts()
        if (contactList.isEmpty())
            view.showEmptyCase()
        else
            view.showContacts(contactList)
    }

    interface View : Presenter.View {

        fun showWelcomeMessage()

        fun showGoodbyeMessage()

        fun getNewContactFirstName(): String

        fun getNewContactLastName(): String

        fun getNewContactPhoneNumber(): String

        fun showContacts(contactList: List<Contact>)
    }
}