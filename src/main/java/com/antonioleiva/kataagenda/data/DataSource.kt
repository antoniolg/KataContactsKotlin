package com.antonioleiva.kataagenda.data

interface DataSource<T> {
    val data: List<T>
}