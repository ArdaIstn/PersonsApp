package com.ardaisitan.personsapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Otomatik olarak json modeli parse etmemizi saglayan altyapiyi burada olusturacagiz.
 */

class RetrofitClient {
    companion object { //static
        fun getClient(baseUrl: String): Retrofit { // Bu fonksiyon, belirtilen baseUrl değerine sahip bir Retrofit istemcisi oluşturur.

            return Retrofit.Builder()
                .baseUrl(baseUrl)//Baseurl bu istemcinin hangi API'ye istek atacagini bildirir.
                .addConverterFactory(GsonConverterFactory.create())//
                .build() // Json cevabının classlara cevirimini  saglar.
        }

        /**
         * Oluşturulan Retrofit istemcisi, belirtilen baseUrl ile yapılandırılır ve bu istemciyi kullanarak API istekleri yapılmak üzere hazır hale getirilir.
         * Örneğin, baseUrl değeri "http://kasimadalan.pe.hu/" olarak belirtilmişse, RetrofitClient bu URL'i temel alarak istemciyi oluşturur.
         */

        /**
         * addConverterFactory(GsonConverterFactory.create()) ifadesi,
         * API'den gelen JSON cevaplarını belirtilen Java veya Kotlin sınıflarına otomatik olarak dönüştürebilmek için Gson kütüphanesini kullanır.
         * Bu sayede Retrofit, API'den gelen verileri kullanılan sınıflara uygun bir şekilde dönüştürerek işleyebilir.
         */
    }

    /**
     * Bu sınıfın temel amacı, Retrofit kütüphanesini kullanarak API istemcisi oluşturmak ve
     * API'den gelen JSON cevaplarını belirtilen sınıflara otomatik olarak dönüştürebilmek için gerekli yapılandırmaları sağlamaktır.
     * Bu yapı, RetrofitClient sınıfının Android uygulamalarında REST API'lerine erişim sağlamak için kullanılmasını kolaylaştırır.
     */

}