package com.antonioleiva.kataagenda.domain.data

import com.antonioleiva.kataagenda.common.data.DataSource

class MemoryDataSource<T> : DataSource<T> {

    private var data = emptyList<T>()

    override fun getData(): List<T> = data

    override fun add(item: T): T = item.apply { data += this }

}