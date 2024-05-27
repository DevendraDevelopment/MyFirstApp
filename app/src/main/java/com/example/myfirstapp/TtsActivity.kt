package com.example.myfirstapp

import android.database.DatabaseUtils
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityTtsBinding
import java.util.Locale

class TtsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTtsBinding
    private lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tts)

        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
                tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String) {
                        Log.d("TTS", "onStart")
                    }

                    override fun onDone(utteranceId: String) {
                        Log.d("TTS", "onDone")
                    }

                    override fun onError(utteranceId: String) {
                        Log.e("TTS", "onError")
                    }
                })
            } else {
                Log.e("TTS", "Initialization Failed!")
            }
        }
        binding.buttonSpeak.setOnClickListener {
            speakOut()
        }
    }

    private fun speakOut() {
        Log.d("Text To Speech", binding.editText.text.toString())

        val text = binding.editText.text.toString()
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        // Shutdown TTS when activity is destroyed
        if (this::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}