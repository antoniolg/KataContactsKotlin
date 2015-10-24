package com.antonioleiva.kataagenda.ui

import com.antonioleiva.kataagenda.domain.Contact

class SysOutContactsListView : ContactsListPresenter.View {

    override fun showWelcomeMessage() = Unit

    override fun showGoodbyeMessage() = Unit

    override fun getNewContactFirstName(): String = ""

    override fun getContactLastName(): String = ""

    override fun getNewContactPhoneNumber(): String = ""

    override fun showContacts(contactList: List<Contact>) = Unit

    override fun showDefaultError() = Unit

    override fun showEmptyCase() = Unit
}