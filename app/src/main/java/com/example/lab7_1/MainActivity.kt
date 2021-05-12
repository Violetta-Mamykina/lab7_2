package com.example.lab7_1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val URL_EXTRA = "url"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startService(
                Intent(this, DownloadService::class.java).putExtra(
                    URL_EXTRA,
                    "https://i09.fotocdn.net/s115/e57e6239b9698ffa/public_pin_l/2610032688.jpg"
                )
            )
        }
}
}
