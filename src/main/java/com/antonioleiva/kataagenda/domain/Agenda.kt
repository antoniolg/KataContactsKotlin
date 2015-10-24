package com.antonioleiva.kataagenda.domain

import com.antonioleiva.kataagenda.common.data.Repository

class Agenda(private val contactsRepository: Repository<Contact>) {
    fun getContacts() = contactsRepository.getData()
    fun add(contact: Contact) = contactsRepository.add(contact)
}