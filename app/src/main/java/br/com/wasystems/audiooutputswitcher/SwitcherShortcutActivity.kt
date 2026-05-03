package com.weslley75.audiooutputswitcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weslley75.audiooutputswitcher.utils.AudioOutputFallback

class SwitcherShortcutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Lógica para abrir el selector
            AudioOutputFallback.openSelector(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Cerramos la actividad para que no estorbe
        finish()
    }
}