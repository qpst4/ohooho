package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import defpackage.au0;
import defpackage.dm0;
import defpackage.gu0;
import defpackage.l2;
import defpackage.lu0;
import defpackage.mu0;
import defpackage.qi;
import defpackage.qq0;
import defpackage.ri;
import defpackage.s1;
import defpackage.ys0;
import defpackage.zt0;
import defpackage.zy;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends zt0 implements lu0 {
    public final dm0 p;
    public ri q;
    public final View.OnLayoutChangeListener r;

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new qi();
        this.r = new View.OnLayoutChangeListener() { // from class: pi
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                if (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) {
                    return;
                }
                view.post(new c(12, this.a));
            }
        };
        this.p = new dm0();
        p0();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.c);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            p0();
            G0(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // defpackage.zt0
    public final void B0(RecyclerView recyclerView, int i) {
        l2 l2Var = new l2(this, recyclerView.getContext());
        l2Var.a = i;
        C0(l2Var);
    }

    public final boolean E0() {
        return this.q.a == 0;
    }

    public final boolean F0() {
        return E0() && G() == 1;
    }

    public final void G0(int i) {
        ri riVar;
        if (i != 0 && i != 1) {
            zy.n(qq0.i("invalid orientation:", i));
            return;
        }
        c(null);
        ri riVar2 = this.q;
        if (riVar2 == null || i != riVar2.a) {
            if (i == 0) {
                riVar = new ri(this, 1);
            } else {
                if (i != 1) {
                    zy.n("invalid orientation");
                    return;
                }
                riVar = new ri(this, 0);
            }
            this.q = riVar;
            p0();
        }
    }

    @Override // defpackage.zt0
    public final boolean P() {
        return true;
    }

    @Override // defpackage.zt0
    public final void U(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        dm0 dm0Var = this.p;
        float dimension = dm0Var.a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        dm0Var.a = dimension;
        float dimension2 = dm0Var.b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        dm0Var.b = dimension2;
        p0();
        recyclerView.addOnLayoutChangeListener(this.r);
    }

    @Override // defpackage.zt0
    public final void V(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.r);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    @Override // defpackage.zt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View W(android.view.View r5, int r6, defpackage.gu0 r7, defpackage.mu0 r8) {
        /*
            r4 = this;
            int r7 = r4.v()
            r8 = 0
            if (r7 != 0) goto L9
            goto L96
        L9:
            ri r7 = r4.q
            int r7 = r7.a
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -1
            r2 = 1
            if (r6 == r2) goto L47
            r3 = 2
            if (r6 == r3) goto L3d
            r3 = 17
            if (r6 == r3) goto L4c
            r3 = 33
            if (r6 == r3) goto L49
            r3 = 66
            if (r6 == r3) goto L3f
            r3 = 130(0x82, float:1.82E-43)
            if (r6 == r3) goto L3b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown focus request:"
            r7.<init>(r3)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "CarouselLayoutManager"
            android.util.Log.d(r7, r6)
        L39:
            r6 = r0
            goto L55
        L3b:
            if (r7 != r2) goto L39
        L3d:
            r6 = r2
            goto L55
        L3f:
            if (r7 != 0) goto L39
            boolean r6 = r4.F0()
            if (r6 == 0) goto L3d
        L47:
            r6 = r1
            goto L55
        L49:
            if (r7 != r2) goto L39
            goto L47
        L4c:
            if (r7 != 0) goto L39
            boolean r6 = r4.F0()
            if (r6 == 0) goto L47
            goto L3d
        L55:
            if (r6 != r0) goto L58
            goto L96
        L58:
            r7 = 0
            if (r6 != r1) goto L8b
            int r5 = defpackage.zt0.L(r5)
            if (r5 != 0) goto L62
            goto L96
        L62:
            android.view.View r5 = r4.u(r7)
            int r5 = defpackage.zt0.L(r5)
            int r5 = r5 - r2
            if (r5 < 0) goto L7a
            int r6 = r4.F()
            if (r5 < r6) goto L74
            goto L7a
        L74:
            ri r4 = r4.q
            r4.a()
            throw r8
        L7a:
            boolean r5 = r4.F0()
            if (r5 == 0) goto L86
            int r5 = r4.v()
            int r7 = r5 + (-1)
        L86:
            android.view.View r4 = r4.u(r7)
            return r4
        L8b:
            int r5 = defpackage.zt0.L(r5)
            int r6 = r4.F()
            int r6 = r6 - r2
            if (r5 != r6) goto L97
        L96:
            return r8
        L97:
            int r5 = r4.v()
            int r5 = r5 - r2
            android.view.View r5 = r4.u(r5)
            int r5 = defpackage.zt0.L(r5)
            int r5 = r5 + r2
            if (r5 < 0) goto Lb4
            int r6 = r4.F()
            if (r5 < r6) goto Lae
            goto Lb4
        Lae:
            ri r4 = r4.q
            r4.a()
            throw r8
        Lb4:
            boolean r5 = r4.F0()
            if (r5 == 0) goto Lbb
            goto Lc1
        Lbb:
            int r5 = r4.v()
            int r7 = r5 + (-1)
        Lc1:
            android.view.View r4 = r4.u(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.W(android.view.View, int, gu0, mu0):android.view.View");
    }

    @Override // defpackage.zt0
    public final void X(AccessibilityEvent accessibilityEvent) {
        super.X(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(zt0.L(u(0)));
            accessibilityEvent.setToIndex(zt0.L(u(v() - 1)));
        }
    }

    @Override // defpackage.lu0
    public final PointF a(int i) {
        return null;
    }

    @Override // defpackage.zt0
    public final void a0(int i, int i2) {
        F();
    }

    @Override // defpackage.zt0
    public final boolean d() {
        return E0();
    }

    @Override // defpackage.zt0
    public final void d0(int i, int i2) {
        F();
    }

    @Override // defpackage.zt0
    public final boolean e() {
        return !E0();
    }

    @Override // defpackage.zt0
    public final void f0(gu0 gu0Var, mu0 mu0Var) {
        if (mu0Var.b() > 0) {
            if ((E0() ? this.n : this.o) > 0.0f) {
                F0();
                View view = gu0Var.i(0, Long.MAX_VALUE).a;
                s1.f("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
                return;
            }
        }
        k0(gu0Var);
    }

    @Override // defpackage.zt0
    public final void g0(mu0 mu0Var) {
        if (v() == 0) {
            return;
        }
        zt0.L(u(0));
    }

    @Override // defpackage.zt0
    public final int j(mu0 mu0Var) {
        v();
        return 0;
    }

    @Override // defpackage.zt0
    public final int k(mu0 mu0Var) {
        return 0;
    }

    @Override // defpackage.zt0
    public final int l(mu0 mu0Var) {
        return 0;
    }

    @Override // defpackage.zt0
    public final int m(mu0 mu0Var) {
        v();
        return 0;
    }

    @Override // defpackage.zt0
    public final int n(mu0 mu0Var) {
        return 0;
    }

    @Override // defpackage.zt0
    public final int o(mu0 mu0Var) {
        return 0;
    }

    @Override // defpackage.zt0
    public final boolean o0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // defpackage.zt0
    public final int q0(int i, gu0 gu0Var, mu0 mu0Var) {
        if (!E0() || v() == 0 || i == 0) {
            return 0;
        }
        View view = gu0Var.i(0, Long.MAX_VALUE).a;
        s1.f("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        return 0;
    }

    @Override // defpackage.zt0
    public final au0 r() {
        return new au0(-2, -2);
    }

    @Override // defpackage.zt0
    public final int s0(int i, gu0 gu0Var, mu0 mu0Var) {
        if (!e() || v() == 0 || i == 0) {
            return 0;
        }
        View view = gu0Var.i(0, Long.MAX_VALUE).a;
        s1.f("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        return 0;
    }

    @Override // defpackage.zt0
    public final void z(Rect rect, View view) {
        RecyclerView.K(rect, view);
        rect.centerY();
        if (E0()) {
            rect.centerX();
        }
        throw null;
    }

    public CarouselLayoutManager() {
        dm0 dm0Var = new dm0();
        new qi();
        this.r = new View.OnLayoutChangeListener() { // from class: pi
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                if (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) {
                    return;
                }
                view.post(new c(12, this.a));
            }
        };
        this.p = dm0Var;
        p0();
        G0(0);
    }

    @Override // defpackage.zt0
    public final void r0(int i) {
    }
}
