package id.infiniteuny.c3.hotline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_hotline_view.*

class HotlineView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotline_view)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
