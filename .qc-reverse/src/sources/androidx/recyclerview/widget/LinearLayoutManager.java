package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.au0;
import defpackage.gu0;
import defpackage.l50;
import defpackage.lu0;
import defpackage.mg0;
import defpackage.mu0;
import defpackage.ng0;
import defpackage.og0;
import defpackage.pg0;
import defpackage.px;
import defpackage.qg0;
import defpackage.qq0;
import defpackage.xy0;
import defpackage.yt0;
import defpackage.zt0;
import defpackage.zy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends zt0 implements lu0 {
    public final mg0 A;
    public final ng0 B;
    public final int C;
    public final int[] D;
    public int p;
    public og0 q;
    public px r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public final boolean w;
    public int x;
    public int y;
    public pg0 z;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new mg0();
        this.B = new ng0();
        this.C = 2;
        this.D = new int[2];
        yt0 yt0VarM = zt0.M(context, attributeSet, i, i2);
        e1(yt0VarM.a);
        boolean z = yt0VarM.c;
        c(null);
        if (z != this.t) {
            this.t = z;
            p0();
        }
        f1(yt0VarM.d);
    }

    @Override // defpackage.zt0
    public void B0(RecyclerView recyclerView, int i) {
        qg0 qg0Var = new qg0(recyclerView.getContext());
        qg0Var.a = i;
        C0(qg0Var);
    }

    @Override // defpackage.zt0
    public boolean D0() {
        return this.z == null && this.s == this.v;
    }

    public void E0(mu0 mu0Var, int[] iArr) {
        int i;
        int iL = mu0Var.a != -1 ? this.r.l() : 0;
        if (this.q.f == -1) {
            i = 0;
        } else {
            i = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i;
    }

    public void F0(mu0 mu0Var, og0 og0Var, l50 l50Var) {
        int i = og0Var.d;
        if (i < 0 || i >= mu0Var.b()) {
            return;
        }
        l50Var.a(i, Math.max(0, og0Var.g));
    }

    public final int G0(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        px pxVar = this.r;
        boolean z = !this.w;
        return xy0.h(mu0Var, pxVar, N0(z), M0(z), this, this.w);
    }

    public final int H0(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        px pxVar = this.r;
        boolean z = !this.w;
        return xy0.i(mu0Var, pxVar, N0(z), M0(z), this, this.w, this.u);
    }

    public final int I0(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        px pxVar = this.r;
        boolean z = !this.w;
        return xy0.j(mu0Var, pxVar, N0(z), M0(z), this, this.w);
    }

    public final int J0(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.p == 1) ? 1 : Integer.MIN_VALUE : this.p == 0 ? 1 : Integer.MIN_VALUE : this.p == 1 ? -1 : Integer.MIN_VALUE : this.p == 0 ? -1 : Integer.MIN_VALUE : (this.p != 1 && W0()) ? -1 : 1 : (this.p != 1 && W0()) ? 1 : -1;
    }

    public final void K0() {
        if (this.q == null) {
            og0 og0Var = new og0();
            og0Var.a = true;
            og0Var.h = 0;
            og0Var.i = 0;
            og0Var.k = null;
            this.q = og0Var;
        }
    }

    public final int L0(gu0 gu0Var, og0 og0Var, mu0 mu0Var, boolean z) {
        int i;
        int i2 = og0Var.c;
        int i3 = og0Var.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                og0Var.g = i3 + i2;
            }
            Z0(gu0Var, og0Var);
        }
        int i4 = og0Var.c + og0Var.h;
        while (true) {
            if ((!og0Var.l && i4 <= 0) || (i = og0Var.d) < 0 || i >= mu0Var.b()) {
                break;
            }
            ng0 ng0Var = this.B;
            ng0Var.a = 0;
            ng0Var.b = false;
            ng0Var.c = false;
            ng0Var.d = false;
            X0(gu0Var, mu0Var, og0Var, ng0Var);
            if (!ng0Var.b) {
                int i5 = og0Var.b;
                int i6 = ng0Var.a;
                og0Var.b = (og0Var.f * i6) + i5;
                if (!ng0Var.c || og0Var.k != null || !mu0Var.g) {
                    og0Var.c -= i6;
                    i4 -= i6;
                }
                int i7 = og0Var.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    og0Var.g = i8;
                    int i9 = og0Var.c;
                    if (i9 < 0) {
                        og0Var.g = i8 + i9;
                    }
                    Z0(gu0Var, og0Var);
                }
                if (z && ng0Var.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - og0Var.c;
    }

    public final View M0(boolean z) {
        return this.u ? Q0(0, v(), z, true) : Q0(v() - 1, -1, z, true);
    }

    public final View N0(boolean z) {
        return this.u ? Q0(v() - 1, -1, z, true) : Q0(0, v(), z, true);
    }

    public final int O0() {
        View viewQ0 = Q0(v() - 1, -1, false, true);
        if (viewQ0 == null) {
            return -1;
        }
        return zt0.L(viewQ0);
    }

    @Override // defpackage.zt0
    public final boolean P() {
        return true;
    }

    public final View P0(int i, int i2) {
        int i3;
        int i4;
        K0();
        if (i2 <= i && i2 >= i) {
            return u(i);
        }
        if (this.r.e(u(i)) < this.r.k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.p == 0 ? this.c.h(i, i2, i3, i4) : this.d.h(i, i2, i3, i4);
    }

    public final View Q0(int i, int i2, boolean z, boolean z2) {
        K0();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.p == 0 ? this.c.h(i, i2, i3, i4) : this.d.h(i, i2, i3, i4);
    }

    public View R0(gu0 gu0Var, mu0 mu0Var, int i, int i2, int i3) {
        K0();
        int iK = this.r.k();
        int iG = this.r.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewU = u(i);
            int iL = zt0.L(viewU);
            if (iL >= 0 && iL < i3) {
                if (((au0) viewU.getLayoutParams()).a.i()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.r.e(viewU) < iG && this.r.b(viewU) >= iK) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public final int S0(int i, gu0 gu0Var, mu0 mu0Var, boolean z) {
        int iG;
        int iG2 = this.r.g() - i;
        if (iG2 <= 0) {
            return 0;
        }
        int i2 = -c1(-iG2, gu0Var, mu0Var);
        int i3 = i + i2;
        if (!z || (iG = this.r.g() - i3) <= 0) {
            return i2;
        }
        this.r.o(iG);
        return iG + i2;
    }

    public final int T0(int i, gu0 gu0Var, mu0 mu0Var, boolean z) {
        int iK;
        int iK2 = i - this.r.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i2 = -c1(iK2, gu0Var, mu0Var);
        int i3 = i + i2;
        if (!z || (iK = i3 - this.r.k()) <= 0) {
            return i2;
        }
        this.r.o(-iK);
        return i2 - iK;
    }

    public final View U0() {
        return u(this.u ? 0 : v() - 1);
    }

    public final View V0() {
        return u(this.u ? v() - 1 : 0);
    }

    @Override // defpackage.zt0
    public View W(View view, int i, gu0 gu0Var, mu0 mu0Var) {
        int iJ0;
        b1();
        if (v() != 0 && (iJ0 = J0(i)) != Integer.MIN_VALUE) {
            K0();
            g1(iJ0, (int) (this.r.l() * 0.33333334f), false, mu0Var);
            og0 og0Var = this.q;
            og0Var.g = Integer.MIN_VALUE;
            og0Var.a = false;
            L0(gu0Var, og0Var, mu0Var, true);
            boolean z = this.u;
            View viewP0 = iJ0 == -1 ? z ? P0(v() - 1, -1) : P0(0, v()) : z ? P0(0, v()) : P0(v() - 1, -1);
            View viewV0 = iJ0 == -1 ? V0() : U0();
            if (!viewV0.hasFocusable()) {
                return viewP0;
            }
            if (viewP0 != null) {
                return viewV0;
            }
        }
        return null;
    }

    public final boolean W0() {
        return G() == 1;
    }

    @Override // defpackage.zt0
    public final void X(AccessibilityEvent accessibilityEvent) {
        super.X(accessibilityEvent);
        if (v() > 0) {
            View viewQ0 = Q0(0, v(), false, true);
            accessibilityEvent.setFromIndex(viewQ0 == null ? -1 : zt0.L(viewQ0));
            accessibilityEvent.setToIndex(O0());
        }
    }

    public void X0(gu0 gu0Var, mu0 mu0Var, og0 og0Var, ng0 ng0Var) {
        int i;
        int iD;
        int i2;
        int iD2;
        View viewB = og0Var.b(gu0Var);
        if (viewB == null) {
            ng0Var.b = true;
            return;
        }
        au0 au0Var = (au0) viewB.getLayoutParams();
        List list = og0Var.k;
        boolean z = this.u;
        int i3 = og0Var.f;
        if (list == null) {
            if (z == (i3 == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (z == (i3 == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        au0 au0Var2 = (au0) viewB.getLayoutParams();
        Rect rectL = this.b.L(viewB);
        int i4 = rectL.left + rectL.right;
        int i5 = rectL.top + rectL.bottom;
        int iW = zt0.w(d(), this.n, this.l, J() + I() + ((ViewGroup.MarginLayoutParams) au0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) au0Var2).rightMargin + i4, ((ViewGroup.MarginLayoutParams) au0Var2).width);
        int iW2 = zt0.w(e(), this.o, this.m, H() + K() + ((ViewGroup.MarginLayoutParams) au0Var2).topMargin + ((ViewGroup.MarginLayoutParams) au0Var2).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) au0Var2).height);
        if (y0(viewB, iW, iW2, au0Var2)) {
            viewB.measure(iW, iW2);
        }
        ng0Var.a = this.r.c(viewB);
        if (this.p == 1) {
            if (W0()) {
                iD2 = this.n - J();
                iD = iD2 - this.r.d(viewB);
            } else {
                int I = I();
                iD2 = this.r.d(viewB) + I;
                iD = I;
            }
            int i6 = og0Var.f;
            i2 = og0Var.b;
            int i7 = ng0Var.a;
            if (i6 == -1) {
                int i8 = i2 - i7;
                i = i2;
                i2 = i8;
            } else {
                i = i7 + i2;
            }
        } else {
            int iK = K();
            int iD3 = this.r.d(viewB) + iK;
            int i9 = og0Var.f;
            int i10 = og0Var.b;
            int i11 = ng0Var.a;
            if (i9 == -1) {
                int i12 = i10 - i11;
                iD2 = i10;
                i2 = iK;
                i = iD3;
                iD = i12;
            } else {
                int i13 = i10 + i11;
                i = iD3;
                iD = i10;
                i2 = iK;
                iD2 = i13;
            }
        }
        zt0.R(viewB, iD, i2, iD2, i);
        if (au0Var.a.i() || au0Var.a.l()) {
            ng0Var.c = true;
        }
        ng0Var.d = viewB.hasFocusable();
    }

    public final void Z0(gu0 gu0Var, og0 og0Var) {
        if (!og0Var.a || og0Var.l) {
            return;
        }
        int i = og0Var.g;
        int i2 = og0Var.i;
        if (og0Var.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iF = (this.r.f() - i) + i2;
            if (this.u) {
                for (int i3 = 0; i3 < iV; i3++) {
                    View viewU = u(i3);
                    if (this.r.e(viewU) < iF || this.r.n(viewU) < iF) {
                        a1(gu0Var, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = iV - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View viewU2 = u(i5);
                if (this.r.e(viewU2) < iF || this.r.n(viewU2) < iF) {
                    a1(gu0Var, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int iV2 = v();
        if (!this.u) {
            for (int i7 = 0; i7 < iV2; i7++) {
                View viewU3 = u(i7);
                if (this.r.b(viewU3) > i6 || this.r.m(viewU3) > i6) {
                    a1(gu0Var, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = iV2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View viewU4 = u(i9);
            if (this.r.b(viewU4) > i6 || this.r.m(viewU4) > i6) {
                a1(gu0Var, i8, i9);
                return;
            }
        }
    }

    @Override // defpackage.lu0
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < zt0.L(u(0))) != this.u ? -1 : 1;
        return this.p == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public final void a1(gu0 gu0Var, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                View viewU = u(i);
                n0(i);
                gu0Var.f(viewU);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            View viewU2 = u(i3);
            n0(i3);
            gu0Var.f(viewU2);
        }
    }

    public final void b1() {
        if (this.p == 1 || !W0()) {
            this.u = this.t;
        } else {
            this.u = !this.t;
        }
    }

    @Override // defpackage.zt0
    public final void c(String str) {
        if (this.z == null) {
            super.c(str);
        }
    }

    public final int c1(int i, gu0 gu0Var, mu0 mu0Var) {
        if (v() != 0 && i != 0) {
            K0();
            this.q.a = true;
            int i2 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            g1(i2, iAbs, true, mu0Var);
            og0 og0Var = this.q;
            int iL0 = L0(gu0Var, og0Var, mu0Var, false) + og0Var.g;
            if (iL0 >= 0) {
                if (iAbs > iL0) {
                    i = i2 * iL0;
                }
                this.r.o(-i);
                this.q.j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // defpackage.zt0
    public final boolean d() {
        return this.p == 0;
    }

    public final void d1(int i, int i2) {
        this.x = i;
        this.y = i2;
        pg0 pg0Var = this.z;
        if (pg0Var != null) {
            pg0Var.b = -1;
        }
        p0();
    }

    @Override // defpackage.zt0
    public final boolean e() {
        return this.p == 1;
    }

    public final void e1(int i) {
        if (i != 0 && i != 1) {
            zy.n(qq0.i("invalid orientation:", i));
            return;
        }
        c(null);
        if (i != this.p || this.r == null) {
            px pxVarA = px.a(this, i);
            this.r = pxVarA;
            this.A.a = pxVarA;
            this.p = i;
            p0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018d  */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v22 */
    @Override // defpackage.zt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f0(defpackage.gu0 r18, defpackage.mu0 r19) {
        /*
            Method dump skipped, instruction units count: 1192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.f0(gu0, mu0):void");
    }

    public void f1(boolean z) {
        c(null);
        if (this.v == z) {
            return;
        }
        this.v = z;
        p0();
    }

    @Override // defpackage.zt0
    public void g0(mu0 mu0Var) {
        this.z = null;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.A.c();
    }

    public final void g1(int i, int i2, boolean z, mu0 mu0Var) {
        int iK;
        this.q.l = this.r.i() == 0 && this.r.f() == 0;
        this.q.f = i;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        E0(mu0Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        og0 og0Var = this.q;
        int i3 = z2 ? iMax2 : iMax;
        og0Var.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        og0Var.i = iMax;
        if (z2) {
            og0Var.h = this.r.h() + i3;
            View viewU0 = U0();
            og0 og0Var2 = this.q;
            og0Var2.e = this.u ? -1 : 1;
            int iL = zt0.L(viewU0);
            og0 og0Var3 = this.q;
            og0Var2.d = iL + og0Var3.e;
            og0Var3.b = this.r.b(viewU0);
            iK = this.r.b(viewU0) - this.r.g();
        } else {
            View viewV0 = V0();
            og0 og0Var4 = this.q;
            og0Var4.h = this.r.k() + og0Var4.h;
            og0 og0Var5 = this.q;
            og0Var5.e = this.u ? 1 : -1;
            int iL2 = zt0.L(viewV0);
            og0 og0Var6 = this.q;
            og0Var5.d = iL2 + og0Var6.e;
            og0Var6.b = this.r.e(viewV0);
            iK = (-this.r.e(viewV0)) + this.r.k();
        }
        og0 og0Var7 = this.q;
        og0Var7.c = i2;
        if (z) {
            og0Var7.c = i2 - iK;
        }
        og0Var7.g = iK;
    }

    @Override // defpackage.zt0
    public final void h(int i, int i2, mu0 mu0Var, l50 l50Var) {
        if (this.p != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        K0();
        g1(i > 0 ? 1 : -1, Math.abs(i), true, mu0Var);
        F0(mu0Var, this.q, l50Var);
    }

    @Override // defpackage.zt0
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof pg0) {
            this.z = (pg0) parcelable;
            p0();
        }
    }

    public final void h1(int i, int i2) {
        this.q.c = this.r.g() - i2;
        og0 og0Var = this.q;
        og0Var.e = this.u ? -1 : 1;
        og0Var.d = i;
        og0Var.f = 1;
        og0Var.b = i2;
        og0Var.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.zt0
    public final void i(int i, l50 l50Var) {
        boolean z;
        int i2;
        pg0 pg0Var = this.z;
        if (pg0Var == null || (i2 = pg0Var.b) < 0) {
            b1();
            z = this.u;
            i2 = this.x;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = pg0Var.d;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.C && i2 >= 0 && i2 < i; i4++) {
            l50Var.a(i2, 0);
            i2 += i3;
        }
    }

    @Override // defpackage.zt0
    public final Parcelable i0() {
        pg0 pg0Var = this.z;
        if (pg0Var != null) {
            pg0 pg0Var2 = new pg0();
            pg0Var2.b = pg0Var.b;
            pg0Var2.c = pg0Var.c;
            pg0Var2.d = pg0Var.d;
            return pg0Var2;
        }
        pg0 pg0Var3 = new pg0();
        if (v() <= 0) {
            pg0Var3.b = -1;
            return pg0Var3;
        }
        K0();
        boolean z = this.s ^ this.u;
        pg0Var3.d = z;
        if (z) {
            View viewU0 = U0();
            pg0Var3.c = this.r.g() - this.r.b(viewU0);
            pg0Var3.b = zt0.L(viewU0);
            return pg0Var3;
        }
        View viewV0 = V0();
        pg0Var3.b = zt0.L(viewV0);
        pg0Var3.c = this.r.e(viewV0) - this.r.k();
        return pg0Var3;
    }

    public final void i1(int i, int i2) {
        this.q.c = i2 - this.r.k();
        og0 og0Var = this.q;
        og0Var.d = i;
        og0Var.e = this.u ? 1 : -1;
        og0Var.f = -1;
        og0Var.b = i2;
        og0Var.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.zt0
    public final int j(mu0 mu0Var) {
        return G0(mu0Var);
    }

    @Override // defpackage.zt0
    public int k(mu0 mu0Var) {
        return H0(mu0Var);
    }

    @Override // defpackage.zt0
    public int l(mu0 mu0Var) {
        return I0(mu0Var);
    }

    @Override // defpackage.zt0
    public final int m(mu0 mu0Var) {
        return G0(mu0Var);
    }

    @Override // defpackage.zt0
    public int n(mu0 mu0Var) {
        return H0(mu0Var);
    }

    @Override // defpackage.zt0
    public int o(mu0 mu0Var) {
        return I0(mu0Var);
    }

    @Override // defpackage.zt0
    public final View q(int i) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iL = i - zt0.L(u(0));
        if (iL >= 0 && iL < iV) {
            View viewU = u(iL);
            if (zt0.L(viewU) == i) {
                return viewU;
            }
        }
        return super.q(i);
    }

    @Override // defpackage.zt0
    public int q0(int i, gu0 gu0Var, mu0 mu0Var) {
        if (this.p == 1) {
            return 0;
        }
        return c1(i, gu0Var, mu0Var);
    }

    @Override // defpackage.zt0
    public au0 r() {
        return new au0(-2, -2);
    }

    @Override // defpackage.zt0
    public final void r0(int i) {
        this.x = i;
        this.y = Integer.MIN_VALUE;
        pg0 pg0Var = this.z;
        if (pg0Var != null) {
            pg0Var.b = -1;
        }
        p0();
    }

    @Override // defpackage.zt0
    public int s0(int i, gu0 gu0Var, mu0 mu0Var) {
        if (this.p == 0) {
            return 0;
        }
        return c1(i, gu0Var, mu0Var);
    }

    @Override // defpackage.zt0
    public final boolean z0() {
        if (this.m != 1073741824 && this.l != 1073741824) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                ViewGroup.LayoutParams layoutParams = u(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.zt0
    public final void V(RecyclerView recyclerView) {
    }

    public LinearLayoutManager(int i) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new mg0();
        this.B = new ng0();
        this.C = 2;
        this.D = new int[2];
        e1(i);
        c(null);
        if (this.t) {
            this.t = false;
            p0();
        }
    }

    public void Y0(gu0 gu0Var, mu0 mu0Var, mg0 mg0Var, int i) {
    }
}
