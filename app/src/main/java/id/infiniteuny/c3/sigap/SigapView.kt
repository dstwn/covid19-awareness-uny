package id.infiniteuny.c3.sigap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.c3.API
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_sigap_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigapView : AppCompatActivity() {
    var datalist = ArrayList<ResponseSigap>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SigapAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigap_view)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.rv_sigap)
        recyclerView.adapter = SigapAdapter(datalist,this)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        getdatas()
    }

    private fun getdatas() {
        val call : Call<List<ResponseSigap>> = API().getService().getTanggap()
        call.enqueue(object : Callback<List<ResponseSigap>>{
            override fun onResponse(
                call: Call<List<ResponseSigap>>,
                response: Response<List<ResponseSigap>>
            ) {
                if (response.isSuccessful){
                    prog.visibility = View.GONE
                    datalist.addAll(response.body()!!)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<List<ResponseSigap>>, t: Throwable) {
                print(t)
            }
        })
    }
}
