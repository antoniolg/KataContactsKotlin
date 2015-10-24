package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.Agenda
import com.antonioleiva.kataagenda.Contact

class AddContact(val agenda: Agenda) {
    operator fun invoke(contact: Contact) = agenda.add(contact)
}