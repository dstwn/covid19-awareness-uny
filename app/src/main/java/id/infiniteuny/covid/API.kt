package id.infiniteuny.covid

import id.infiniteuny.covid.covid.Covid19StatsItem
import id.infiniteuny.covid.protocol.DataItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class API {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://covid19.infiniteuny.id/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Protokol::class.java)
}
    interface Protokol {
        @GET("protocol/all/")
        fun getProtokol() : Call<List<DataItem>>
    }
    interface  Covid {
        @GET("covid/")
        fun getCovid() : Call<List<Covid19StatsItem>>
    }


