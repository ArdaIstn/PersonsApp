package com.ardaisitan.personsapp.retrofit

/**
 * İnterfaceye erismemizi saglayan classtir.
 */
class ApiUtils {
    companion object {
        val base_url = "http://kasimadalan.pe.hu/"

        fun getPersonsDao(): PersonsDao { // Amac interfaceye erisip calistirmaktir.

            return RetrofitClient.getClient(base_url).create(PersonsDao::class.java)
        }
        // Her interface icin ayri bir fonksiyon olusturmamiz gerekecektir.
    }
    /**
     *  Retrofit ile bir REST API'ye erişirken kullanılan bir yardımcı sınıf olan ApiUtils sınıfını temsil eder.
     *  Bu sınıf, genellikle API isteklerini oluşturmak için kullanılan RetrofitClient ile etkileşime geçer
     *  ve ilgili PersonsDao interface'ini kullanarak API ile iletişim kurar.
     */

    /**
     * Bu fonksiyon, aslında API'nin temel URL'si olan base_url değeri ile RetrofitClient üzerinden Retrofit istemcisini oluşturur ve
     * bu istemciyi kullanarak PersonsDao interface'ini oluşturur.
     * Bu sayede API ile etkileşim sağlayacak olan DAO (Data Access Object) sınıfı hazır hale gelir.
     */
}