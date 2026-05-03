package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class VolumePanelActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Usamos el String directo para evitar el error "Unresolved reference"
            val intent = Intent("android.settings.VOLUME_CONTROL_SETTINGS")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            // Segundo intento con panel de medios si el anterior falla
            try {
                val mediaIntent = Intent("com.android.settings.panel.action.MEDIA_OUTPUT")
                mediaIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(mediaIntent)
            } catch (e2: Exception) {
                // Fallback final a ajustes de sonido generales
                val fallbackIntent = Intent(android.provider.Settings.ACTION_SOUND_SETTINGS)
                fallbackIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(fallbackIntent)
            }
        }
        
        finish() // Cierra la actividad inmediatamente [5]
    }
}