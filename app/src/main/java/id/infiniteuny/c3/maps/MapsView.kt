package id.infiniteuny.c3.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_maps_view.*

class MapsView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_view)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        webMaps.settings.javaScriptEnabled = true
        webMaps.loadUrl("http://cont.covid19.infiniteuny.id/maps.html")
    }
}
