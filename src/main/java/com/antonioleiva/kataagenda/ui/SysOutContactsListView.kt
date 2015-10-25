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