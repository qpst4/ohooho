package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qg0 {
    public int a = -1;
    public RecyclerView b;
    public zt0 c;
    public boolean d;
    public boolean e;
    public View f;
    public final ku0 g;
    public boolean h;
    public final LinearInterpolator i;
    public final DecelerateInterpolator j;
    public PointF k;
    public final DisplayMetrics l;
    public boolean m;
    public float n;
    public int o;
    public int p;

    public qg0(Context context) {
        ku0 ku0Var = new ku0();
        ku0Var.d = -1;
        ku0Var.f = false;
        ku0Var.g = 0;
        ku0Var.a = 0;
        ku0Var.b = 0;
        ku0Var.c = Integer.MIN_VALUE;
        ku0Var.e = null;
        this.g = ku0Var;
        this.i = new LinearInterpolator();
        this.j = new DecelerateInterpolator();
        this.m = false;
        this.o = 0;
        this.p = 0;
        this.l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            zy.n("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return 0;
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int b(View view, int i) {
        zt0 zt0Var = this.c;
        if (zt0Var == null || !zt0Var.d()) {
            return 0;
        }
        au0 au0Var = (au0) view.getLayoutParams();
        return a(zt0.A(view) - ((ViewGroup.MarginLayoutParams) au0Var).leftMargin, zt0.D(view) + ((ViewGroup.MarginLayoutParams) au0Var).rightMargin, zt0Var.I(), zt0Var.n - zt0Var.J(), i);
    }

    public int c(View view, int i) {
        zt0 zt0Var = this.c;
        if (zt0Var == null || !zt0Var.e()) {
            return 0;
        }
        au0 au0Var = (au0) view.getLayoutParams();
        return a(zt0.E(view) - ((ViewGroup.MarginLayoutParams) au0Var).topMargin, zt0.y(view) + ((ViewGroup.MarginLayoutParams) au0Var).bottomMargin, zt0Var.K(), zt0Var.o - zt0Var.H(), i);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i) {
        float fAbs = Math.abs(i);
        if (!this.m) {
            this.n = d(this.l);
            this.m = true;
        }
        return (int) Math.ceil(fAbs * this.n);
    }

    public PointF f(int i) {
        Object obj = this.c;
        if (obj instanceof lu0) {
            return ((lu0) obj).a(i);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + lu0.class.getCanonicalName());
        return null;
    }

    public int g() {
        PointF pointF = this.k;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.y;
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qg0.h(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(android.view.View r7, defpackage.ku0 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.k
            r1 = 1
            if (r0 == 0) goto L13
            float r0 = r0.x
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto Ld
            goto L13
        Ld:
            if (r0 <= 0) goto L11
            r0 = r1
            goto L14
        L11:
            r0 = -1
            goto L14
        L13:
            r0 = 0
        L14:
            int r0 = r6.b(r7, r0)
            int r2 = r6.g()
            int r7 = r6.c(r7, r2)
            int r2 = r0 * r0
            int r3 = r7 * r7
            int r3 = r3 + r2
            double r2 = (double) r3
            double r2 = java.lang.Math.sqrt(r2)
            int r2 = (int) r2
            int r2 = r6.e(r2)
            double r2 = (double) r2
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r4
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            if (r2 <= 0) goto L4b
            int r0 = -r0
            int r7 = -r7
            r8.a = r0
            r8.b = r7
            r8.c = r2
            android.view.animation.DecelerateInterpolator r6 = r6.j
            r8.e = r6
            r8.f = r1
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qg0.i(android.view.View, ku0):void");
    }

    public final void j() {
        if (this.e) {
            this.e = false;
            this.p = 0;
            this.o = 0;
            this.k = null;
            this.b.g0.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            zt0 zt0Var = this.c;
            if (zt0Var.e == this) {
                zt0Var.e = null;
            }
            this.c = null;
            this.b = null;
        }
    }
}
