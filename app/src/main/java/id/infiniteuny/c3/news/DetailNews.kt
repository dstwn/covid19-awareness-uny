package id.infiniteuny.c3.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.activity_protocol_view.*
import kotlinx.android.synthetic.main.activity_protocol_view.toolbar as toolbar1

class DetailNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("")
        fillView()
    }
    private fun getNews() : ResponseNews = intent.getParcelableExtra("NEWS")

    private fun fillView() {
        Glide.with(this).load(getNews().imageUrl).into(nImage)
        nTitle!!.setText(getNews().title)
        textNews!!.setText(getNews().news)
//        webNews.loadData(getNews().news, "text/html","utf-8")
    }
}
