package id.infiniteuny.c3.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import id.infiniteuny.c3.API
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_info_view.*
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
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        getDatas()
    }

    private fun getDatas() {
        val call : Call<List<ResponseInfo>> = API().getService().getInfo()
        call.enqueue(object : Callback<List<ResponseInfo>>{
            override fun onResponse(
                call: Call<List<ResponseInfo>>,
                response: Response<List<ResponseInfo>>
            ) {
                if (response.isSuccessful){
                    prog.visibility = View.GONE
                    datainfo.addAll(response!!.body()!!)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<ResponseInfo>>, t: Throwable) {
                Toast.makeText(this@InfoView, t.localizedMessage, Toast.LENGTH_SHORT).show()

            }
        })
    }
}
