package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.common.data.Repository
import com.antonioleiva.kataagenda.domain.Agenda
import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.domain.data.MemoryDataSource
import com.antonioleiva.kataagenda.ui.ContactsListPresenter
import com.antonioleiva.kataagenda.ui.SysOutContactsListView
import com.antonioleiva.kataagenda.usecases.AddContact
import com.antonioleiva.kataagenda.usecases.AddContactImpl
import com.antonioleiva.kataagenda.usecases.GetContacts
import com.antonioleiva.kataagenda.usecases.GetContactsImpl

object AgendaServiceLocator {

    private val MEMORY_CONTACTS_DATA_SOURCE = MemoryDataSource<Contact>()
    private val repository: Repository<Contact> = Repository(MEMORY_CONTACTS_DATA_SOURCE)
    private val agenda = Agenda(repository)
    private val addContact: AddContact = AddContactImpl(agenda)
    private val getContacts: GetContacts = GetContactsImpl(agenda)
    private val sysOutView: ContactsListPresenter.View = SysOutContactsListView()

    val contactsListPresenter = ContactsListPresenter(sysOutView, addContact, getContacts)
}