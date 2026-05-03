package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Usamos el Intent como String para máxima compatibilidad entre versiones [6]
            val intent = Intent("com.android.settings.panel.action.MEDIA_OUTPUT")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            // Si el panel nativo falla, intentamos abrir la configuración de sonido [7, 8]
            val fallbackIntent = Intent(android.provider.Settings.ACTION_SOUND_SETTINGS)
            fallbackIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(fallbackIntent)
        }
        
        finish() // Cerramos la actividad inmediatamente para que sea invisible al usuario [9, 10]
    }
}