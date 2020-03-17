package id.infiniteuny.covid.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.covid.API
import id.infiniteuny.covid.R
import kotlinx.android.synthetic.main.activity_info_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsView : AppCompatActivity() {
    var datanews = ArrayList<ResponseNews>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_view)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.rv_news)
        recyclerView.adapter = NewsAdapter(datanews, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getData()
    }
    private fun getData() {
        val call  : Call<List<ResponseNews>> = API().getService().getNews()
        call.enqueue(object : Callback<List<ResponseNews>> {
            override fun onResponse(
                call: Call<List<ResponseNews>>,
                response: Response<List<ResponseNews>>
            ) {
                datanews.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<ResponseNews>>, t: Throwable) {
                print(t)
            }
        })
    }
}
