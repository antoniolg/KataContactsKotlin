package com.antonioleiva.kataagenda.common.data

interface DataSource<T> {
    fun getData(): List<T>
    fun add(item: T): T
}