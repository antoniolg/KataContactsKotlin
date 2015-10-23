package com.antonioleiva.kataagenda.data.common

interface DataSource<T> {
    fun getData(): List<T>
    fun add(item: T): T
}