package id.infiniteuny.covid

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.covid.activity.SliderView
import id.infiniteuny.covid.hotline.HotlineView
import id.infiniteuny.covid.info.InfoView
import id.infiniteuny.covid.maps.MapsView
import id.infiniteuny.covid.news.NewsView
import id.infiniteuny.covid.protocol.DataItem
import id.infiniteuny.covid.protocol.ProtocolView
import id.infiniteuny.covid.protocol.ProtokolAdapter
import id.infiniteuny.covid.protocol.ProtokolList
import kotlinx.android.synthetic.main.activity_hotline_view.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        Menus()
        cardSlider()
        stats.bringToFront()
        stats.invalidate()
        vid.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=vTovNUXoxNk")))
        }

    }

    private fun Menus() {
        btnIntruksi.setOnClickListener {
            startActivity(Intent(this, InfoView::class.java))
        }
        btnNews.setOnClickListener {
            startActivity(Intent(this, NewsView::class.java))
        }
        btnDaring.setOnClickListener {
            startActivity(Intent(this, DaringView::class.java))
        }
        btnProtokol.setOnClickListener {
            startActivity(Intent(this, ProtokolList::class.java))
        }
        btnHotline.setOnClickListener {
            startActivity(Intent(this, HotlineView::class.java))
        }
        btnMaps.setOnClickListener {
            startActivity(Intent(this, MapsView::class.java))
        }
    }

    private fun cardSlider() {
        cardOne.setOnClickListener {
            val setOne = Bundle()
            setOne.putString("url", "http://cont.covid19.infiniteuny.id/pageone.html")
            setOne.putString("title", "Mengenal Virus Corona")
            val intent = Intent(this, SliderView::class.java)
            intent.putExtras(setOne)
            startActivity(intent)
        }
        cardTwo.setOnClickListener {
            val setTwo = Bundle()
            setTwo.putString("url", "http://cont.covid19.infiniteuny.id/pagetwo.html")
            setTwo.putString("title", "Mencegah Virus Corona")
            val intent = Intent(this, SliderView::class.java)
            intent.putExtras(setTwo)
            startActivity(intent)
        }
        cardThree.setOnClickListener {
            val setThree = Bundle()
            setThree.putString("url", "http://cont.covid19.infiniteuny.id/pagethree.html")
            setThree.putString("title", "Mengobati Virus Corona")
            val intent = Intent(this, SliderView::class.java)
            intent.putExtras(setThree)
            startActivity(intent)
        }
        cardFour.setOnClickListener {
            val setFour = Bundle()
            setFour.putString("url", "http://cont.covid19.infiniteuny.id/pagefour.html")
            setFour.putString("title", "Mengantisipasi Virus Corona")
            val intent = Intent(this, SliderView::class.java)
            intent.putExtras(setFour)
            startActivity(intent)
        }
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
            R.id.action_settings -> {
                val bund = Bundle()
                bund.putString("url","http://cont.covid19.infiniteuny.id/about.html")
                bund.putString("title","Tentang Aplikasi")
                val intent = Intent(this,SliderView::class.java)
                intent.putExtras(bund)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
