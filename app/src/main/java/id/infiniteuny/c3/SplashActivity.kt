package id.infiniteuny.c3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : Activity() {
   lateinit var handler: Handler
//    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val activeNetwork : NetworkInfo? = cm.activeNetworkInfo
//    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000
        )
    }
}
