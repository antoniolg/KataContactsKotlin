package com.antonioleiva.kataagenda.usecases

import com.antonioleiva.kataagenda.Agenda

class GetContacts(val agenda: Agenda) {
    fun execute() = agenda.getContacts()
}