package com.ardaisitan.personsapp.data.entity

/**
 * Webservislerin cevaplarina uygun classlar olusturmamiz gerekir.
 */
/**
 * Bu class hem tüm kisileri yukleme hemde arama icin kullanacagimiz bir classtir.
 */
/**
 * Retrofit kütüphanesi,webservisleri calistirmamizi saglayan bir kütüphanedir.
 */
/**
 * delete,insert,update,search : Post
 * kisileriYukleme : Get
 * Kisileri yuklemenin dondurdugu cevapla , search isleminin cevabi benzerdir.
 */
data class KisilerCevap(
    var kisiler: List<Kisiler>,
    var succes: Int
)
