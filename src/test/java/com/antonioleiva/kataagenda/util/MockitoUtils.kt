package com.antonioleiva.kataagenda.util

import org.mockito.ArgumentCaptor
import org.mockito.Mockito

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
inline fun <reified T : Any> captor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)