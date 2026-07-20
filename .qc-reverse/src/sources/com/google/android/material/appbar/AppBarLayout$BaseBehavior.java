package com.google.android.material.appbar;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.gg1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$BaseBehavior<T> extends gg1 {
    public boolean b;
    public int d;
    public VelocityTracker f;
    public int c = -1;
    public int e = -1;

    public AppBarLayout$BaseBehavior() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    @Override // defpackage.no
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(androidx.coordinatorlayout.widget.CoordinatorLayout r4, android.view.View r5, android.view.MotionEvent r6) {
        /*
            r3 = this;
            int r5 = r3.e
            if (r5 >= 0) goto L12
            android.content.Context r4 = r4.getContext()
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            int r4 = r4.getScaledTouchSlop()
            r3.e = r4
        L12:
            int r4 = r6.getActionMasked()
            r5 = 2
            r0 = -1
            r1 = 0
            if (r4 != r5) goto L40
            boolean r4 = r3.b
            if (r4 == 0) goto L40
            int r4 = r3.c
            if (r4 != r0) goto L24
            goto L4d
        L24:
            int r4 = r6.findPointerIndex(r4)
            if (r4 != r0) goto L2b
            goto L4d
        L2b:
            float r4 = r6.getY(r4)
            int r4 = (int) r4
            int r5 = r3.d
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            int r2 = r3.e
            if (r5 <= r2) goto L40
            r3.d = r4
            r3 = 1
            return r3
        L40:
            int r4 = r6.getActionMasked()
            if (r4 == 0) goto L4e
            android.view.VelocityTracker r3 = r3.f
            if (r3 == 0) goto L4d
            r3.addMovement(r6)
        L4d:
            return r1
        L4e:
            r3.c = r0
            r6.getX()
            r6.getY()
            defpackage.s1.d()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.f(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // defpackage.gg1, defpackage.no
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final /* synthetic */ void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final void m(View view, Parcelable parcelable) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final Parcelable n(View view) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final boolean o(View view, int i, int i2) {
        throw new ClassCastException();
    }

    @Override // defpackage.no
    public final void p(View view, View view2, int i) {
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062 A[RETURN] */
    @Override // defpackage.no
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            int r0 = r7.getActionMasked()
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L44
            r4 = 2
            if (r0 == r4) goto L2d
            r6 = 3
            if (r0 == r6) goto L48
            r6 = 6
            if (r0 == r6) goto L13
            goto L56
        L13:
            int r6 = r7.getActionIndex()
            if (r6 != 0) goto L1b
            r6 = r3
            goto L1c
        L1b:
            r6 = r2
        L1c:
            int r0 = r7.getPointerId(r6)
            r5.c = r0
            float r6 = r7.getY(r6)
            r0 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 + r0
            int r6 = (int) r6
            r5.d = r6
            goto L56
        L2d:
            int r0 = r5.c
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r1) goto L36
            goto L61
        L36:
            float r7 = r7.getY(r0)
            int r7 = (int) r7
            r5.d = r7
            r6.getClass()
            defpackage.s1.d()
            return r2
        L44:
            android.view.VelocityTracker r0 = r5.f
            if (r0 != 0) goto L63
        L48:
            r5.b = r2
            r5.c = r1
            android.view.VelocityTracker r6 = r5.f
            if (r6 == 0) goto L56
            r6.recycle()
            r6 = 0
            r5.f = r6
        L56:
            android.view.VelocityTracker r6 = r5.f
            if (r6 == 0) goto L5d
            r6.addMovement(r7)
        L5d:
            boolean r5 = r5.b
            if (r5 != 0) goto L62
        L61:
            return r2
        L62:
            return r3
        L63:
            r0.addMovement(r7)
            android.view.VelocityTracker r7 = r5.f
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.computeCurrentVelocity(r0)
            android.view.VelocityTracker r7 = r5.f
            int r5 = r5.c
            r7.getYVelocity(r5)
            r6.getClass()
            defpackage.s1.d()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.q(android.view.View, android.view.MotionEvent):boolean");
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
    }
}
