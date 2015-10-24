package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.domain.Agenda
import com.antonioleiva.kataagenda.domain.Contact

class AddContact(val agenda: Agenda) {
    operator fun invoke(contact: Contact) = agenda.add(contact)
}