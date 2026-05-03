package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Este comando abre directamente el selector de salida de audio del sistema
            val intent = Intent(Settings.ACTION_OUTPUT_SWITCHER_SETTINGS)
            intent.putExtra("android.intent.extra.PACKAGE_NAME", packageName)
            startActivity(intent)
        } catch (e: Exception) {
            // Si el anterior falla (en versiones viejas de Android), probamos este:
            try {
                val intentFallback = Intent().setAction("com.android.settings.panel.action.MEDIA_OUTPUT")
                startActivity(intentFallback)
            } catch (e2: Exception) {
                // Si ambos fallan, no hace nada para no cerrar la app con error
            }
        }

        finish() // Cierra la actividad invisible
    }
}