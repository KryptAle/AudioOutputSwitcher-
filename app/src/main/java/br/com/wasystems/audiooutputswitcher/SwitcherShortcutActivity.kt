package com.weslley75.audiooutputswitcher // Usa el paquete oficial del repo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weslley75.audiooutputswitcher.utils.AudioOutputFallback

class SwitcherShortcutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Abre el selector nativo usando la lógica de respaldo del proyecto
        AudioOutputFallback.openSelector(this)

        // Cierra la actividad inmediatamente para que sea invisible al usuario 
        finish()
    }
}