package com.antonioleiva.kataagenda.data

import com.antonioleiva.kataagenda.Contact
import com.antonioleiva.kataagenda.data.common.DataSource

class MemoryDataSource : DataSource<Contact> {

    private var data = emptyList<Contact>()

    override fun getData(): List<Contact> = data

    override fun add(item: Contact): Contact = item.apply { data += this }

}