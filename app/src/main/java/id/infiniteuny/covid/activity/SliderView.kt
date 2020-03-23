package id.infiniteuny.covid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.infiniteuny.covid.R
import kotlinx.android.synthetic.main.activity_slider_view.*

class SliderView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_view)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("")
        getData()
    }
    private fun getData() {
        val datas = intent.extras
        fillView(datas)
    }
    private fun fillView(datas: Bundle?) {
        textTitle.setText(datas!!.getString("title"))
        slider.settings.javaScriptEnabled = true
        slider.loadUrl(datas!!.getString("url"))
    }
}
