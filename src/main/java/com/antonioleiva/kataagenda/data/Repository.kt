package com.antonioleiva.kataagenda.data

class Repository<T>(val dataSource: DataSource<T>) {
    fun getData() = dataSource.data
}