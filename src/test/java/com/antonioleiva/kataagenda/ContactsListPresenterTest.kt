package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.ui.ContactsListPresenter
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.GetContacts
import com.antonioleiva.kataagenda.util.mock
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when` as _when

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

    @Test fun shouldShowWelcomeMessageWhenAppStarts() {
        val presenter = givenAContactsListPresenter()
        presenter.onInitialize()
        verify(view).showWelcomeMessage()
    }

    @Test fun shouldShowEmptyMessageWhenAgendaIsEmpty() {
        val presenter = givenAContactsListPresenter()
        givenTheAgendaIsEmpty()

        presenter.onInitialize()
        verify(view).showEmptyCase()
    }

    @Test fun shouldShowContactsFromTheAgendaOnInitialize() {
        val presenter = givenAContactsListPresenter()
        val contacts = givenTheAgendaIsNotEmpty()

        presenter.onInitialize()
        verify(view).showContacts(contacts)
    }

    @Test fun shouldShowGoodbyeMessage() {
        val presenter = givenAContactsListPresenter()
        presenter.onInitialize()
        presenter.onStop()
        verify(view).showGoodbyeMessage()
    }

    private fun givenTheAgendaIsEmpty() = _when(getContacts()).thenReturn(emptyList())

    private fun givenTheAgendaIsNotEmpty(): List<Contact> {
        val contacts = (1..ANY_NUMBER_OF_CONTACTS).map {
            Contact(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER)
        }
        _when(getContacts()).thenReturn(contacts)
        return contacts
    }

    private fun givenAContactsListPresenter() = ContactsListPresenter(view, addContact, getContacts)
}