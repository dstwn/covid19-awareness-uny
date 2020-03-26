package id.infiniteuny.c3.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import id.infiniteuny.c3.API
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_covid_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_view)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("")
    getDatas()
    }

    private fun getDatas() {
        val call : Call<DataCovid> = API().getStatistic().getStats()
        call.enqueue(object : Callback<DataCovid>{
            override fun onResponse(
                call: Call<DataCovid>,
                response: Response<DataCovid>
            ) {
                if (response.isSuccessful){
                    prog.visibility = View.GONE
                    val data = response.body()
                        txtCases.text = data?.cases.toString()
                        txtDeaths.text = data?.deaths.toString()
                        txtRecovered.text = data?.recovered.toString()
                        txtTodayCases.text = data?.todayCases.toString()
                        Log.d("tag","data cases = ${data?.cases}")
                }
            }
            override fun onFailure(call: Call<DataCovid>, t: Throwable) {
                Log.e("tag", t.message)
            }
        })
    }

}
