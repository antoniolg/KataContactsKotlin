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