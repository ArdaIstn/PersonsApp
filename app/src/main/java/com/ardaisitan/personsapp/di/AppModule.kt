package com.ardaisitan.personsapp.di

import com.ardaisitan.personsapp.data.datasource.PersonsDataSource
import com.ardaisitan.personsapp.data.repo.PersonsRepository
import com.ardaisitan.personsapp.retrofit.ApiUtils
import com.ardaisitan.personsapp.retrofit.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Bagimliliklarimizi saglayan classtir.
 */

@Module
@InstallIn(SingletonComponent::class)

class AppModule {

    @Provides
    @Singleton
    fun providePersonsDao(): PersonsDao {
        return ApiUtils.getPersonsDao()
    }


    @Provides
    @Singleton
    fun provideDataSource(personsDao:PersonsDao): PersonsDataSource { //Data source turunden bir nesneyi repository classina ileticek.
        return PersonsDataSource(personsDao)
    }

    @Provides
    @Singleton
    fun providePersonRepository(pds: PersonsDataSource): PersonsRepository {
        return PersonsRepository(pds)
    }

    // Repositoryden bir nesne olusturucaksak,DataSource nesnesini parametre olarak vermemiz gerekiyor.
    // Data source nesnesini yukarıdaki fonksiyon saglar.

    /**
     * Yani ozetle,data source nesnesini repository'e yolluyorum,sonrasında repository nesnesini de viewmodel classinda kullaniyorum.
     */

}