package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.domain.Agenda
import com.antonioleiva.kataagenda.domain.Contact

interface AddContact {
    operator fun invoke(contact: Contact): Contact
}

class AddContactImpl(val agenda: Agenda) : AddContact {
    override operator fun invoke(contact: Contact) = agenda.add(contact)
}