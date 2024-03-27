package com.ardaisitan.personsapp.data.repo

import com.ardaisitan.personsapp.data.datasource.PersonsDataSource
import com.ardaisitan.personsapp.data.entity.Kisiler
import javax.inject.Inject

class PersonsRepository @Inject constructor(var pds : PersonsDataSource) { // @Inject ve constructor yazarak da ekleyebiliriz,ama buna gerek kalmaz.

   // var pds = PersonsDataSource() Bagimliliktir.Nesneyi disaridan isteyecegiz.

    suspend fun save(personName: String, personNumber: String) = pds.save(personName, personNumber) // Register viewmodelde calisir

    suspend fun update(id: Int, updatedName: String, updatedNumber: String) = // Detail viewmodelde calisir.
        pds.update(id, updatedName, updatedNumber)

    suspend fun delete(personid: Int) = pds.delete(personid) // MainPageViewModelde calisir.

    suspend fun search(kisi_ad: String): List<Kisiler> = pds.search(kisi_ad) // MainPageViewModelde calisir.

    suspend fun loadPersons(): List<Kisiler> = pds.loadPersons() // MainPageViewModelde calisir.


}


