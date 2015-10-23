package com.antonioleiva.kataagenda.data.common

class Repository<T>(val dataSource: DataSource<T>) {
    fun getData() = dataSource.getData()
    fun add(item: T) = dataSource.add(item)
}