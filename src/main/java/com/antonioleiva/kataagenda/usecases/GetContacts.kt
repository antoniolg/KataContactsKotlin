package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.Agenda

class GetContacts(val agenda: Agenda) {
    operator fun invoke() = agenda.getContacts()
}