package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import com.quickcursor.R;
import com.quickcursor.android.activities.actions.ToggleFlashlightActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n61 extends CameraManager.TorchCallback {
    public final /* synthetic */ ToggleFlashlightActivity a;

    public n61(ToggleFlashlightActivity toggleFlashlightActivity) {
        this.a = toggleFlashlightActivity;
    }

    @Override // android.hardware.camera2.CameraManager.TorchCallback
    public final void onTorchModeChanged(String str, boolean z) {
        super.onTorchModeChanged(str, z);
        si0.a("TorchModeChanged: " + str + ", " + z + "");
        ToggleFlashlightActivity toggleFlashlightActivity = this.a;
        if (toggleFlashlightActivity.A) {
            return;
        }
        toggleFlashlightActivity.A = true;
        try {
            toggleFlashlightActivity.B.setTorchMode(str, !z);
            b61.b(new lk0(13, toggleFlashlightActivity), 300L);
        } catch (CameraAccessException unused) {
            toggleFlashlightActivity.B.unregisterTorchCallback(toggleFlashlightActivity.C);
            toggleFlashlightActivity.finish();
            yb0.y(R.string.action_toggle_flashlight_error, 0);
        }
    }

    @Override // android.hardware.camera2.CameraManager.TorchCallback
    public final void onTorchModeUnavailable(String str) {
        super.onTorchModeUnavailable(str);
        si0.a("Torch mode unavailable: " + str);
        ToggleFlashlightActivity toggleFlashlightActivity = this.a;
        toggleFlashlightActivity.B.unregisterTorchCallback(toggleFlashlightActivity.C);
        toggleFlashlightActivity.finish();
    }
}
