package com.antonioleiva.kataagenda.mocks

import com.antonioleiva.kataagenda.Contact
import com.antonioleiva.kataagenda.data.DataSource

class FakeContactsDataSource : DataSource<Contact> {
    override val data: List<Contact> = emptyList()
}