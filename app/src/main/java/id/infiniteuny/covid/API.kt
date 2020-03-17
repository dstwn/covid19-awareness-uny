package id.infiniteuny.covid

import id.infiniteuny.covid.covid.Covid19StatsItem
import id.infiniteuny.covid.info.ResponseInfo
import id.infiniteuny.covid.news.ResponseNews
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
    fun getService() = getRetrofit().create(Aipiai::class.java)
}
    interface Aipiai {
        @GET("protocol/all/")
        fun getProtokol() : Call<List<DataItem>>

        @GET("info/all/")
        fun getInfo() : Call<List<ResponseInfo>>

        @GET("news/all/")
        fun getNews() : Call<List<ResponseNews>>
    }



