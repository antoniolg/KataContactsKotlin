package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.Agenda
import com.antonioleiva.kataagenda.Contact

class AddContact(val agenda: Agenda) {
    fun execute(contact: Contact) = agenda.add(contact)
}