package com.example.lab7_1

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.bumptech.glide.Glide
import java.io.FileOutputStream
import java.net.URL

class DownloadService : IntentService("DownloadService") {
    val URL_EXTRA = "url"
    val BROADCAST_TAG = "BROADCAST"
    val MESSAGE_EXTRA = "message"

    override fun onHandleIntent(intent: Intent?) {
        val url = intent?.getStringExtra(URL_EXTRA)
        if (url == null)
            sendBroadcast("null url")
        else {
            val path = load(url)
            sendBroadcast(path)
        }
    }

    private fun load(url: String): String {
        return try {
            val bitmap = URL(url).openStream().use {
                return@use BitmapFactory.decodeStream(it)
            }
            saveImage(bitmap, (0..100).random().toString() + "_image")
        } catch (e: Exception) {
            print(e.message)
            ""
        }
    }


    private fun saveImage(b: Bitmap, imageName: String): String {
        val foStream: FileOutputStream
        try {
            foStream = this.applicationContext.openFileOutput(imageName, Context.MODE_PRIVATE)
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream)
            foStream.close()
        } catch (e: Exception) {
            Log.d("saveImage", "wrong")
            e.printStackTrace()
        }
        return applicationContext.getFileStreamPath(imageName).absolutePath
    }


    private fun sendBroadcast(msg: String) {
        sendBroadcast(Intent(BROADCAST_TAG).putExtra(MESSAGE_EXTRA, msg))
    }

}
