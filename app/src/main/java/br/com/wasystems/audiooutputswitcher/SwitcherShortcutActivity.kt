package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Intentamos abrir el panel de salida de medios (Media Output)
        try {
            val intent = Intent("com.android.settings.panel.action.MEDIA_OUTPUT")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // Extra necesario para algunas versiones de HyperOS
            intent.putExtra("com.android.settings.panel.extra.PACKAGE_NAME", packageName)
            startActivity(intent)
        } catch (e: Exception) {
            // Fallback 1: Selector de salida de audio nativo
            try {
                val fallbackIntent = Intent("android.settings.OUTPUT_SWITCHER_SETTINGS")
                fallbackIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(fallbackIntent)
            } catch (e2: Exception) {
                // Fallback 2: Ajustes de sonido generales
                val lastIntent = Intent(android.provider.Settings.ACTION_SOUND_SETTINGS)
                lastIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(lastIntent)
            }
        }

        // ESPERA CRÍTICA: No cerramos la actividad de inmediato.
        // Damos 500ms para que el sistema abra el panel antes de hacer finish() [1].
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 500)
    }
}