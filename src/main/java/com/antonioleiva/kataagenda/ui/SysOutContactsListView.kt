/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.antonioleiva.kataagenda.ui

import com.antonioleiva.kataagenda.domain.Contact

class SysOutContactsListView : ContactsListPresenter.View {

    override fun showWelcomeMessage() {
        println("Welcome to your awesome agenda!")
        println("I'm going to ask you about some of your contacts information :)")
    }

    override fun showGoodbyeMessage() {
        println("\n\nSee you soon!")
    }

    override fun showContacts(contactList: List<Contact>) {
        println()
        contactList.forEach { println("${it.firstName} - ${it.lastName} - ${it.phone}") }
        println()
    }

    override fun getNewContactFirstName(): String = readLine("First Name: ")

    override fun getNewContactLastName(): String = readLine("Last Name: ")

    override fun getNewContactPhoneNumber(): String = readLine("Phone Number: ")

    override fun showDefaultError() = println("Ups, something went wrong :( Try again!")

    override fun showEmptyCase() = println("Your agenda is empty!")

    private fun readLine(message: String): String {
        print(message)
        return readLine() ?: ""
    }
}