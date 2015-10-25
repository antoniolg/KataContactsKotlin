/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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