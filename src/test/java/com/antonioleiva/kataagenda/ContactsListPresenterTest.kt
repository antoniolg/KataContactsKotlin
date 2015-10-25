package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.ui.ContactsListPresenter
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.GetContacts
import com.antonioleiva.kataagenda.util.mock
import org.junit.Test
import org.mockito.Mockito.`when` as _when
import org.mockito.Mockito.verify

class ContactsListPresenterTest {

    companion object {
        private val ANY_NUMBER_OF_CONTACTS = 7
        private val ANY_FIRST_NAME = "Antonio"
        private val ANY_LAST_NAME = "Leiva"
        private val ANY_PHONE_NUMBER = "666777888"
    }

    val view: ContactsListPresenter.View = mock()
    val getContacts: GetContacts = mock()
    val addContact: AddContact = mock()

    @Test fun shouldShowContactsFromTheAgendaOnInitialize() {
        val presenter = givenAContactsListPresenter()
        val contacts = givenTheAgendaIsNotEmpty()

        presenter.onInitialize()
        verify(view).showContacts(contacts)
    }

    private fun givenTheAgendaIsNotEmpty(): List<Contact> {
        val contacts = (1..ANY_NUMBER_OF_CONTACTS).map {
            Contact(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER)
        }
        _when(getContacts()).thenReturn(contacts)
        return contacts
    }

    private fun givenAContactsListPresenter() = ContactsListPresenter(view, addContact, getContacts)
}