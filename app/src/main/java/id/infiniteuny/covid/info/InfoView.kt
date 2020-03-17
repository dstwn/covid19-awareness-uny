package id.infiniteuny.covid.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.covid.API
import id.infiniteuny.covid.R
import kotlinx.android.synthetic.main.activity_main.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoView : AppCompatActivity() {
    var datainfo = ArrayList<ResponseInfo>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: InfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_view)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.rv_info)
        recyclerView.adapter = InfoAdapter(datainfo, this@InfoView)
        recyclerView.layoutManager =LinearLayoutManager(this@InfoView, LinearLayoutManager.VERTICAL,false)
        getDatas()

    }

    private fun getDatas() {
        val call : Call<List<ResponseInfo>> = API().getService().getInfo()
        call.enqueue(object : Callback<List<ResponseInfo>>{
            override fun onResponse(
                call: Call<List<ResponseInfo>>,
                response: Response<List<ResponseInfo>>
            ) {
                datainfo.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<ResponseInfo>>, t: Throwable) {
                Toast.makeText(this@InfoView, t.localizedMessage, Toast.LENGTH_SHORT).show()

            }
        })
    }
}
