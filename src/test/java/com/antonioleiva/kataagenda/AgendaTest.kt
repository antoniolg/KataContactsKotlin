package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.data.Repository
import com.antonioleiva.kataagenda.mocks.FakeContactsDataSource
import org.junit.Test
import kotlin.test.assertTrue

class AgendaTest {

    @Test fun emptyAgendaReturnsEmptyContactsList() {
        val repository = Repository(FakeContactsDataSource())
        val agenda = Agenda(repository)
        assertTrue(agenda.contacts.isEmpty())
    }
}