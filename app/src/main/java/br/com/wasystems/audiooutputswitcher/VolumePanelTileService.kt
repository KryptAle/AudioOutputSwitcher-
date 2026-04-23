package br.com.wasystems.audiooutputswitcher

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.widget.Toast

class VolumePanelTileService : TileService() {

    companion object {
        private const val TAG = "VolumePanelTileService"
    }

    override fun onStartListening() {
        super.onStartListening()
        updateTile()
    }

    override fun onClick() {
        super.onClick()
        val opened = AudioOutputFallback.tryEach { intent -> tryStartActivity(intent, TAG) }
        if (!opened) {
            Toast.makeText(this, getString(R.string.error_opening_volume_panel), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateTile() {
        val tile = qsTile ?: return
        tile.label = getString(R.string.volume_panel)
        tile.icon = Icon.createWithResource(this, R.drawable.ic_volume_panel)
        tile.state = Tile.STATE_ACTIVE
        tile.subtitle = getString(R.string.volume_panel_subtitle)
        tile.updateTile()
    }
}
