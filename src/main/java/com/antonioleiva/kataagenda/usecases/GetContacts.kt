package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.domain.Agenda

class GetContacts(val agenda: Agenda) {
    operator fun invoke() = agenda.getContacts()
}