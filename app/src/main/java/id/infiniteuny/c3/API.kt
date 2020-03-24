package id.infiniteuny.c3

import id.infiniteuny.c3.covid.DataCovid
import id.infiniteuny.c3.info.ResponseInfo
import id.infiniteuny.c3.news.ResponseNews
import id.infiniteuny.c3.protocol.DataItem
import id.infiniteuny.c3.sigap.ResponseSigap
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
    fun getCovid() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://corona.lmao.ninja/countries/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getStatistic() = getCovid().create(Aipiai::class.java)
    fun getService() = getRetrofit().create(Aipiai::class.java)
}
    interface Aipiai {
        @GET("protocol/all/")
        fun getProtokol() : Call<List<DataItem>>

        @GET("info/all/")
        fun getInfo() : Call<List<ResponseInfo>>

        @GET("news/all/")
        fun getNews() : Call<List<ResponseNews>>

        @GET("tanggap/all")
        fun getTanggap() : Call<List<ResponseSigap>>

        @GET("Indonesia")
        fun getStats() : Call<DataCovid>
    }



