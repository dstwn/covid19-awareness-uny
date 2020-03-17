package id.infiniteuny.covid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.covid.info.InfoView
import id.infiniteuny.covid.news.NewsView
import id.infiniteuny.covid.protocol.DataItem
import id.infiniteuny.covid.protocol.ProtokolAdapter

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var datalist = ArrayList<DataItem>()
lateinit var recyclerView: RecyclerView
lateinit var adapter: ProtokolAdapter
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        recyclerView = findViewById(R.id.rv_protocol)
        recyclerView.adapter = ProtokolAdapter(datalist, this@MainActivity)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        getData()
        btnIntruksi.setOnClickListener {
            startActivity(Intent(this, InfoView::class.java))
        }
        btnNews.setOnClickListener {
            startActivity(Intent(this, NewsView::class.java))
        }
        btnDaring.setOnClickListener {
            startActivity(Intent(this, DaringView::class.java))
        }

    }
    private fun getData(){
        val call: Call<List<DataItem>> = API().getService().getProtokol()
        call.enqueue(object : Callback<List<DataItem>> {
            override fun onFailure(call : Call<List<DataItem>>, t : Throwable){
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<List<DataItem>>?,
                response: Response<List<DataItem>>?
            ){
                datalist.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }

        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
