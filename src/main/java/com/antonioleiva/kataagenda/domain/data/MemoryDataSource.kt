package com.antonioleiva.kataagenda.domain.data

import com.antonioleiva.kataagenda.domain.Contact
import com.antonioleiva.kataagenda.common.data.DataSource

class MemoryDataSource : DataSource<Contact> {

    private var data = emptyList<Contact>()

    override fun getData(): List<Contact> = data

    override fun add(item: Contact): Contact = item.apply { data += this }

}