package com.google.android.material.timepicker;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.quickcursor.R;
import defpackage.h0;
import defpackage.m0;
import defpackage.n0;
import defpackage.y;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends y {
    public final /* synthetic */ ClockFaceView d;

    public c(ClockFaceView clockFaceView) {
        this.d = clockFaceView;
    }

    @Override // defpackage.y
    public final void d(View view, n0 n0Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.d.y.get(iIntValue - 1));
        }
        n0Var.j(m0.a(view.isSelected(), 0, 1, iIntValue, 1));
        accessibilityNodeInfo.setClickable(true);
        n0Var.b(h0.e);
    }

    @Override // defpackage.y
    public final boolean g(View view, int i, Bundle bundle) {
        ClockFaceView clockFaceView = this.d;
        ClockHandView clockHandView = clockFaceView.u;
        Rect rect = clockFaceView.v;
        if (i != 16) {
            return super.g(view, i, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        view.getHitRect(rect);
        float fCenterX = rect.centerX();
        float fCenterY = rect.centerY();
        clockHandView.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockHandView.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
