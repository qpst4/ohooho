package com.quickcursor.android.activities.actions;

import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.quickcursor.R;
import defpackage.n61;
import defpackage.xy0;
import defpackage.yb0;
import defpackage.z7;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ToggleFlashlightActivity extends z7 {
    public CameraManager B;
    public boolean A = false;
    public final n61 C = new n61(this);

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
        } else {
            getWindow().addFlags(524288);
        }
        this.B = (CameraManager) getSystemService("camera");
        if (xy0.f(this, "android.permission.CAMERA") != 0) {
            yb0.y(R.string.action_require_camera_permission, 0);
            finish();
        } else {
            this.B.registerTorchCallback(this.C, new Handler(Looper.getMainLooper()));
        }
    }
}
