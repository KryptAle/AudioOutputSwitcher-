package com.weslley.audiooutputswitcher // Ajusta según el paquete real

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity

class VolumePanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            // Esta es la intención que usa el TileService para invocar el panel
            val intent = Intent(Settings.ACTION_VOLUME_CONTROLS_SETTING)
            startActivity(intent)
        } catch (e: Exception) {
            // Manejo de errores en caso de que el sistema no responda
            e.printStackTrace()
        }

        // Cerramos la actividad inmediatamente para que el usuario no vea 
        // una pantalla en blanco detrás del panel de volumen
        finish()
    }
}