package com.antonioleiva.kataagenda

import org.junit.Test
import kotlin.test.assertTrue

class AgendaTest {

    @Test fun emptyAgendaReturnsEmptyContactsList() {
        val agenda = Agenda(emptyList())
        assertTrue(agenda.contacts.isEmpty())
    }
}