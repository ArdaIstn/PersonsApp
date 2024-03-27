package com.ardaisitan.personsapp.data.entity

/**
 * Bütün json cevaplarini class seklinde olusturmamiz gerekir.
 * Süslü parantezler class olusturacagimiz anlamina gelir.
 * Json formatindaki isimlerle,classin icerisindeki isimler ve turlerinin birebir ayni olmasi gerekir.
 * Update,delete ve Insert ayni json formatinda oldugu icin ortak bir class olusturduk.
 */
data class CRUDCevap(var success: Int, var message: String) {

}
