package com.antonioleiva.kataagenda

import com.antonioleiva.kataagenda.data.MemoryDataSource
import com.antonioleiva.kataagenda.data.common.Repository
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AgendaTest {

    @Test fun emptyAgendaReturnsEmptyContactsList() = with(givenAnAgenda()) {
        assertTrue(getContacts().isEmpty())
    }

    @Test fun addAContactIncrementsInOneAgendaSize() = with(givenAnAgenda()) {
        add(givenAContact())
        assertEquals(1, getContacts().size)
    }

    @Test fun addAContactReturnsSameContact() = with(givenAnAgenda()) {
        val newContact = givenAContact()
        val resultContact = add(newContact)
        assertEquals(newContact, resultContact)
    }

    private fun givenAnAgenda() = Agenda(Repository(MemoryDataSource()))
    private fun givenAContact() = Contact("Name", "Last Name", "123456789")
}