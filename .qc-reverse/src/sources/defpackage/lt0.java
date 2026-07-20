package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lt0 extends AccessibilityService.GestureResultCallback {
    public final /* synthetic */ mt0 a;

    public lt0(mt0 mt0Var) {
        this.a = mt0Var;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        mt0.m("onCancelled");
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        super.onCompleted(gestureDescription);
        this.a.l = false;
    }
}
