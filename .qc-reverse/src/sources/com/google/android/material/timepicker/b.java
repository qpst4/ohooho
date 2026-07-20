package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView b;

    public b(ClockFaceView clockFaceView) {
        this.b = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.b;
        ClockHandView clockHandView = clockFaceView.u;
        if (clockFaceView.isShown()) {
            clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
            int height = ((clockFaceView.getHeight() / 2) - clockHandView.e) - clockFaceView.C;
            if (height != clockFaceView.s) {
                clockFaceView.s = height;
                clockFaceView.m();
                clockHandView.m = clockFaceView.s;
                clockHandView.invalidate();
            }
        }
        return true;
    }
}
