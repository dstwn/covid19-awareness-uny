package id.infiniteuny.c3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_self_check_view.*

class SelfCheckView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_check_view)
        loadWeb()

        btnHome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun loadWeb() {
        selfView.settings.javaScriptEnabled = true
        selfView.webViewClient = WebViewClient()
        selfView.loadUrl("http://si-c3.uny.ac.id/")
    }
}
