package id.infiniteuny.covid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import id.infiniteuny.covid.protocol.DataItem
import kotlinx.android.synthetic.main.activity_protocol_view.*

class ProtocolView : AppCompatActivity() {
    lateinit var pdfView: PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocol_view)
        fillData()
        pdfView()
    }
    private fun protocol() : DataItem = intent.getParcelableExtra("PROT")
    private fun fillData() {
        textTitle!!.setText(protocol().title)
        textUrl!!.setText(protocol().fileUrl)
    }
    private fun pdfView() {
        pdfView = findViewById(R.id.pdfView)
        val uri = protocol().fileUrl.toString()
        pdfView.fromUri(Uri.parse(uri))
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableAnnotationRendering(true)
            .scrollHandle(DefaultScrollHandle(this))
            .load()
    }
}

