package com.ardaisitan.personsapp.retrofit


import com.ardaisitan.personsapp.data.entity.CRUDCevap
import com.ardaisitan.personsapp.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Kisiler tablosu uzerindeki calismalari yapacagimiz fonksiyonlari burada tanimlayacagiz.
 */

/**
 * Bir webservis calismasi icin bilgi istiyorsa buna POST denir.
 * Bir webservis calismasi icin bilgi istemiyorsa buna GET denir.
 */

interface PersonsDao {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/-> Base url
    // kisiler/tum_kisiler.php-> Webservis url

    //Base URL ve web servis URL'si bu annotation'lar ile birleştirilerek tam URL oluşturulur.

    @GET("kisiler/tum_kisiler.php")//Webservise istek
    suspend fun loadPersons(): KisilerCevap // KisilerCevap turunde bir veri dondurur.

    /**
     * PersonsDao interface'i, belirtilen URL'ye GET isteği yaparak API'den veri almayı sağlar ve bu veriyi KisilerCevap türünde döndürür.
     * Bu türün yapısı ve içeriği, API'den dönen verilere bağlı olarak tanımlanır ve işlenir.
     */

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun searchPersons(@Field("kisi_ad") kisi_ad: String): KisilerCevap

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded //Turkce destegi olmasi icin verdik.
    suspend fun save(
        @Field("kisi_ad") kisi_ad: String,//Field'dan sonraki tanimlama webservisteki isimle birebir ayni olmalidir.
        @Field("kisi_tel") kisi_tel: String  //Field'dan sonraki tanimlama webservisteki isimle birebir ayni olmalidir.
    ): CRUDCevap // CrudCevap turunde bir veri dondurur.


    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun update(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): CRUDCevap


    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun delete(@Field("kisi_id") kisi_id: Int): CRUDCevap


}