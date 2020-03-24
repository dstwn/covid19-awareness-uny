package id.infiniteuny.c3.protocol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.activity_protocol_view.*
import kotlinx.android.synthetic.main.activity_protocol_view.toolbar

class ProtocolView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocol_view)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("")
        fillData()
    }
    private fun protocol() : DataItem = intent.getParcelableExtra("PROT")
    private fun fillData() {
        textTitle!!.setText(protocol().title)
        pdfView()
    }
    private fun pdfView() {
        web.settings.javaScriptEnabled = true
        web.loadUrl("https://docs.google.com/gview?embedded=true&url="+protocol().fileUrl)
    }
}

