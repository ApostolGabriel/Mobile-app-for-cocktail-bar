package com.example.repo

import com.example.proiect.model.LoggedInUser
import com.example.proiect.model.Medicine

interface MedicationRepo {
    fun getMedication(): List<Medicine>
    fun addMedication(medicine: Medicine): List<Medicine>
}

object ImplMedicationRepo: MedicationRepo {
    private var session = LoggedInUser

    override fun getMedication(): List<Medicine> {
        return session.medication
    }

    override fun addMedication(medicine: Medicine): List<Medicine> {
        session.medication.add(medicine)
        return session.medication
    }

}