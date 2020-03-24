package id.infiniteuny.c3.protocol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.c3.API
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_protokol_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProtokolList : AppCompatActivity() {
    var datalist = ArrayList<DataItem>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProtokolAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protokol_list)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Protokol Kesehatan")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.rv_protocol)
        recyclerView.adapter = ProtokolAdapter(datalist, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getData()
    }
    private fun getData(){
        val call: Call<List<DataItem>> = API().getService().getProtokol()
        call.enqueue(object : Callback<List<DataItem>> {
            override fun onFailure(call : Call<List<DataItem>>, t : Throwable){
                //Toast.makeText(this, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<List<DataItem>>?,
                response: Response<List<DataItem>>?
            ){
                if (response != null) {
                    if (response.isSuccessful){
                        prog.visibility = View.GONE
                        datalist.addAll(response?.body()!!)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
                }

            }

        })
    }
}
