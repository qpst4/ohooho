package com.quickcursor.android.services;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.quickcursor.R;
import defpackage.lc1;
import defpackage.yb0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class QuickSettingsTileService extends TileService {
    public final void a() {
        try {
            Tile qsTile = getQsTile();
            if (CursorAccessibilityService.q == null) {
                qsTile.setState(0);
            } else if (CursorAccessibilityService.e()) {
                qsTile.setState(2);
            } else {
                qsTile.setState(1);
            }
            qsTile.updateTile();
        } catch (Exception unused) {
            yb0.A(R.string.debug_toast_tile_add_error);
        }
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        CursorAccessibilityService.m();
        a();
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        a();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        try {
            super.onTileAdded();
            Tile qsTile = getQsTile();
            qsTile.setIcon(Icon.createWithResource(this, R.drawable.icon_quick_settings_tile));
            qsTile.setLabel(lc1.K(R.string.app_name));
            qsTile.setContentDescription(lc1.K(R.string.app_name));
            qsTile.updateTile();
            a();
        } catch (Exception unused) {
            yb0.A(R.string.debug_toast_tile_add_error);
        }
    }
}
