package id.infiniteuny.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_daring_view.*

class DaringView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daring_view)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("")

        daringWeb.settings.javaScriptEnabled = true
        daringWeb.loadUrl("https://covid19.infiniteuny.id")
    }
}
