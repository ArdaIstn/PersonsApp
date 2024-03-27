package com.ardaisitan.personsapp.data.datasource

import com.ardaisitan.personsapp.data.entity.Kisiler
import com.ardaisitan.personsapp.retrofit.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonsDataSource(var personsDao: PersonsDao) {

    suspend fun loadPersons(): List<Kisiler> = // Arayuze listeyi gonderecegiz.
        withContext(Dispatchers.IO) {


            return@withContext personsDao.loadPersons().kisiler//Kisileri getirecektir.
        }

    suspend fun search(kisi_ad: String): List<Kisiler> =
        // Bu fonksiyonu calistirdigimiz zaman bize sadece person1'i getirecektir.Arayuze liste gonderecegiz.
        withContext(Dispatchers.IO) {

            return@withContext personsDao.searchPersons(kisi_ad).kisiler
        }

    suspend fun save(personName: String, personNumber: String) {
        personsDao.save(personName, personNumber)
    }

    suspend fun update(id: Int, updatedName: String, updatedNumber: String) {
        personsDao.update(id, updatedName, updatedNumber)
    }

    suspend fun delete(personid: Int) {
        personsDao.delete(personid)
    }

}


