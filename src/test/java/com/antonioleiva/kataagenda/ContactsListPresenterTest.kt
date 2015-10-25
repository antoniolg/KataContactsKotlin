package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.ui.ContactsListPresenter
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.GetContacts
import com.antonioleiva.kataagenda.util.captor
import com.antonioleiva.kataagenda.util.mock
import org.junit.Ignore
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.verify
import kotlin.test.assertTrue
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
    val contactsCaptor: ArgumentCaptor<List<Contact>> = captor()

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

    // TODO: Not working because of an error in capture (Kotlin interoperability?)
    @Ignore
    @Test fun shouldShowTheContactsListWithTheNewContactOnContactAdded() {
        val presenter = givenAContactsListPresenter()
        val contactToCreate = givenTheUserAddsAContact()
        givenTheContactIsAddedCorrectly(contactToCreate)

        presenter.onInitialize()
        presenter.onAddContactOptionSelected()

        verify(view).showContacts(contactsCaptor.capture())
        val newContacts = contactsCaptor.allValues[1]
        assertTrue(newContacts.contains(contactToCreate))
    }

    @Test fun shouldShowAnErrorIfTheFirstNameOfTheNewContactIsEmpty() {
        val presenter = givenAContactsListPresenter()
        givenTheUserTypesContactInfo("", ANY_LAST_NAME, ANY_PHONE_NUMBER)

        presenter.onInitialize()
        presenter.onAddContactOptionSelected()

        verify(view).showDefaultError()
    }

    @Test fun shouldShowAnErrorIfTheLastNameOfTheNewContactIsEmpty() {
        val presenter = givenAContactsListPresenter()
        givenTheUserTypesContactInfo(ANY_FIRST_NAME, "", ANY_PHONE_NUMBER)

        presenter.onInitialize()
        presenter.onAddContactOptionSelected()

        verify(view).showDefaultError()
    }

    @Test fun shouldShowAnErrorIfThePhoneOfTheNewContactIsEmpty() {
        val presenter = givenAContactsListPresenter()
        givenTheUserTypesContactInfo(ANY_FIRST_NAME, ANY_LAST_NAME, "")

        presenter.onInitialize()
        presenter.onAddContactOptionSelected()

        verify(view).showDefaultError()
    }

    private fun givenTheContactIsAddedCorrectly(contact: Contact) {
        _when(addContact(contact)).thenReturn(contact)
        _when(getContacts()).thenReturn(listOf(contact))
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

    private fun givenTheUserAddsAContact(): Contact {
        val contact = Contact(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER)
        givenTheUserTypesContactInfo(contact.firstName, contact.lastName, contact.phone)
        return contact
    }

    private fun givenTheUserTypesContactInfo(firstName: String, lastName: String, phone: String) {
        _when(view.getNewContactFirstName()).thenReturn(firstName)
        _when(view.getNewContactLastName()).thenReturn(lastName)
        _when(view.getNewContactPhoneNumber()).thenReturn(phone)
    }
}