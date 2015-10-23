package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.data.Repository

class Agenda(private val contactsRepository: Repository<Contact>) {
    val contacts = contactsRepository.getData()
}