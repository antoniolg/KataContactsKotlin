package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.domain.Agenda
import com.antonioleiva.kataagenda.domain.Contact

interface GetContacts {
    operator fun invoke(): List<Contact>
}

class GetContactsImpl(val agenda: Agenda) : GetContacts {
    override operator fun invoke() = agenda.getContacts()
}