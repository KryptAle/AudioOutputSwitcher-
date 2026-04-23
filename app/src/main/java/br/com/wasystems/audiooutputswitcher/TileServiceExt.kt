package br.com.wasystems.audiooutputswitcher

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.service.quicksettings.TileService
import android.util.Log

@SuppressLint("StartActivityAndCollapseDeprecated")
internal fun TileService.tryStartActivity(intent: Intent, tag: String): Boolean {
    val action = intent.action ?: "Unknown"
    return try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startActivityAndCollapse(
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            )
        } else {
            @Suppress("DEPRECATION")
            startActivityAndCollapse(intent)
        }
        Log.d(tag, "opened $action")
        true
    } catch (e: ActivityNotFoundException) {
        Log.w(tag, "$action not found: ${e.message}")
        false
    } catch (e: Exception) {
        Log.w(tag, "$action failed: ${e.message}")
        false
    }
}
