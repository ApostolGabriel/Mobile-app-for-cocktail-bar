package com.example.proiect.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.proiect.navigation.firstPage.NavigationFirstPageFragment
import com.example.proiect.people.contacts.PeopleFragment

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
object LoggedInUser {
    var displayName: String = ""
    var role: Role = Role.USER
    var contactPeople: MutableList<Person> = mutableListOf(
    Person(69,"Nume",null,"mock","Phone",Role.USER)
    )
    var savedLocations: MutableList<Location> = mutableListOf(
        Location(1,"Magazin","Magazinul pentru mancare",
            "Str. Republicii nr 101"),
        Location(1,
            "Căminul numărul 7",
            "Acasă",
            "Strada Observatorului, Cluj-Napoca 400000"
        ),
        Location(2,
            "Spitalul Județean de Urgență Cluj-Napoca",
            "Spital pentru control medical",
            "Str. Clinicilor 3-5, Cluj-Napoca 400347"
        ),
        Location(3,
            "Lidl",
            "Magazin alimentar pentru mâncare",
            "Strada Republicii 109, Cluj-Napoca 400489"
        ),
        Location(4,
            "Auchan",
            "Hypermarket pentru nevoi extra",
            "Strada Alexandru Vaida Voevod 53B, Cluj-Napoca 400436"
        ),
        Location(5,
            "Îngrijitor",
            "Casa îngrijitorului",
            "Strada Vasile Lupu nr.35, Cluj-Napoca 400423"
        )
    )
    var medication: MutableList<Medicine> = mutableListOf(
        Medicine(
            "Paracetamol",
            4,
            100.0,
            3
        ),
        Medicine(
            "Parasinus",
            6,
            120.40,
            2
        ),
        Medicine(
            "Strepsils",
            67,
            90.21,
            4
        ),
        Medicine(
            "Ibuprofen",
            25,
            65.34,
            2
        )
    )

    fun login(user: String) {
        val user = AvailableSession.possibleUsers.first { it.name.equals(user, true) }
        displayName = user.name
        role = user.role
        contactPeople = user.contactPeople
    }
    fun menuOptions(): List<Option> {
        var options:MutableList<Option> = mutableListOf()
        when(role){
            Role.USER -> {
                return listOf(
                    Option("Contacte", PeopleFragment())
                )
            }
            Role.PACIENT -> {
                return listOf(
                    Option("Contacte", PeopleFragment()),
                    Option("Navigare", NavigationFirstPageFragment()),
                    Option("Activitati", PeopleFragment())
                )
            }
            Role.MEDIC -> {
                return listOf(
                    Option("Contacte", PeopleFragment())
                )
            }
        }
    }
}