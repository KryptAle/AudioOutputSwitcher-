package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.os.Bundle
import android.content.Intent

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Este es el método universal para abrir el panel de salida de medios
            val intent = Intent("com.android.settings.panel.action.MEDIA_OUTPUT")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            // Si el anterior falla, intentamos el método alternativo de sistema
            try {
                val intentAlt = Intent("android.settings.OUTPUT_SWITCHER_SETTINGS")
                intentAlt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intentAlt)
            } catch (e2: Exception) {
                // Si falla, la app no se cierra con error
            }
        }

        finish() // Cerramos la actividad invisible
    }
}