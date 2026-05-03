package br.com.wasystems.audiooutputswitcher

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.content.Context
import android.media.AudioManager

class SwitcherShortcutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actions = listOf(
            "com.android.settings.panel.action.MEDIA_OUTPUT",      // Método Android 11+
            "android.settings.panel.action.MEDIA_OUTPUT",          // Variante de sistema
            "android.settings.OUTPUT_SWITCHER_SETTINGS",           // Método Android 12+
            "com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG" // Método directo SystemUI
        )

        var success = false
        for (action in actions) {
            try {
                val intent = Intent(action)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                // Algunas versiones requieren el nombre del paquete para seguridad
                intent.putExtra("com.android.settings.panel.extra.PACKAGE_NAME", packageName)
                startActivity(intent)
                success = true
                break 
            } catch (e: Exception) {
                continue // Si este falla, prueba el siguiente
            }
        }

        // Si nada funcionó, intentamos enviar un "Media Button" para despertar al sistema
        if (!success) {
            try {
                val intentAudio = Intent(Intent.ACTION_MAIN)
                intentAudio.setAction(Intent.ACTION_PROGRAMMATIC_EXPLORE_SETTINGS) // Intento desesperado
                startActivity(intentAudio)
            } catch (e: Exception) {}
        }

        finish() // Cerramos la actividad invisible
    }
}