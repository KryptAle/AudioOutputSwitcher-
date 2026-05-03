package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings

class VolumePanelActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Intenta abrir el panel de controles de volumen
            val intent = Intent(Settings.ACTION_VOLUME_CONTROLS_SETTING)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            // Fallback: Si falla, abre los ajustes de sonido generales
            val fallbackIntent = Intent(Settings.ACTION_SOUND_SETTINGS)
            fallbackIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(fallbackIntent)
        }
        
        finish() // Cierra la actividad inmediatamente para que sea invisible
    }
}