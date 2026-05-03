package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Intent para abrir el selector de salida de audio nativo
        val intent = Intent("com.android.systemui.action.SHOW_OUTPUT_SWITCHER")
        intent.setPackage("com.android.systemui")
        
        try {
            sendBroadcast(intent)
        } catch (e: Exception) {
            // Fallback si el sistema no responde al broadcast
            val fallbackIntent = Intent(android.provider.Settings.ACTION_SOUND_SETTINGS)
            fallbackIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(fallbackIntent)
        }

        // Cerramos la actividad de inmediato para que sea invisible al usuario
        finish()
    }
}