package com.kryptale.audiooutputswitcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SwitcherShortcutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Intent para abrir el Media Output Switcher (Android 11+)
        val intent = Intent("com.android.systemui.action.SHOW_OUTPUT_SWITCHER")
        intent.setPackage("com.android.systemui")
        
        try {
            sendBroadcast(intent)
        } catch (e: Exception) {
            // Fallback: Si el broadcast falla, intenta usar la lógica de AudioOutputFallback
            // que ya tienes definida en el proyecto
            val fallbackIntent = Intent(android.provider.Settings.ACTION_SOUND_SETTINGS)
            fallbackIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(fallbackIntent)
        }

        // 2. Cerrar la actividad inmediatamente para que sea transparente al usuario
        finish()
    }
}