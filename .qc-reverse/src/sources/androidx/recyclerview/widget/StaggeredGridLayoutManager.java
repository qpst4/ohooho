package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.au0;
import defpackage.g21;
import defpackage.gu0;
import defpackage.h21;
import defpackage.j21;
import defpackage.l50;
import defpackage.lu0;
import defpackage.m0;
import defpackage.mu0;
import defpackage.n0;
import defpackage.nc;
import defpackage.pn0;
import defpackage.px;
import defpackage.qg0;
import defpackage.rf0;
import defpackage.uf1;
import defpackage.xy0;
import defpackage.yi0;
import defpackage.yt0;
import defpackage.zt0;
import defpackage.zy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends zt0 implements lu0 {
    public final pn0 B;
    public final int C;
    public boolean D;
    public boolean E;
    public j21 F;
    public final Rect G;
    public final g21 H;
    public final boolean I;
    public int[] J;
    public final nc K;
    public final int p;
    public final yi0[] q;
    public final px r;
    public final px s;
    public final int t;
    public int u;
    public final rf0 v;
    public boolean w;
    public final BitSet y;
    public boolean x = false;
    public int z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -1;
        this.w = false;
        pn0 pn0Var = new pn0(8, false);
        this.B = pn0Var;
        this.C = 2;
        this.G = new Rect();
        this.H = new g21(this);
        this.I = true;
        this.K = new nc(15, this);
        yt0 yt0VarM = zt0.M(context, attributeSet, i, i2);
        int i3 = yt0VarM.a;
        if (i3 != 0 && i3 != 1) {
            zy.n("invalid orientation.");
            throw null;
        }
        c(null);
        if (i3 != this.t) {
            this.t = i3;
            px pxVar = this.r;
            this.r = this.s;
            this.s = pxVar;
            p0();
        }
        int i4 = yt0VarM.b;
        c(null);
        if (i4 != this.p) {
            int[] iArr = (int[]) pn0Var.d;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            pn0Var.c = null;
            p0();
            this.p = i4;
            this.y = new BitSet(this.p);
            this.q = new yi0[this.p];
            for (int i5 = 0; i5 < this.p; i5++) {
                this.q[i5] = new yi0(this, i5);
            }
            p0();
        }
        boolean z = yt0VarM.c;
        c(null);
        j21 j21Var = this.F;
        if (j21Var != null && j21Var.i != z) {
            j21Var.i = z;
        }
        this.w = z;
        p0();
        rf0 rf0Var = new rf0();
        rf0Var.a = true;
        rf0Var.f = 0;
        rf0Var.g = 0;
        this.v = rf0Var;
        this.r = px.a(this, this.t);
        this.s = px.a(this, 1 - this.t);
    }

    public static int e1(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // defpackage.zt0
    public final void B0(RecyclerView recyclerView, int i) {
        qg0 qg0Var = new qg0(recyclerView.getContext());
        qg0Var.a = i;
        C0(qg0Var);
    }

    @Override // defpackage.zt0
    public final boolean D0() {
        return this.F == null;
    }

    public final boolean E0() {
        int iL0;
        if (v() != 0 && this.C != 0 && this.g) {
            if (this.x) {
                iL0 = M0();
                L0();
            } else {
                iL0 = L0();
                M0();
            }
            if (iL0 == 0 && Q0() != null) {
                pn0 pn0Var = this.B;
                int[] iArr = (int[]) pn0Var.d;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                pn0Var.c = null;
                this.f = true;
                p0();
                return true;
            }
        }
        return false;
    }

    public final int F0(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return xy0.i(mu0Var, this.r, I0(z), H0(z), this, this.I, this.x);
    }

    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean, int] */
    public final int G0(gu0 gu0Var, rf0 rf0Var, mu0 mu0Var) {
        yi0[] yi0VarArr;
        BitSet bitSet;
        int i;
        yi0[] yi0VarArr2;
        yi0 yi0Var;
        ?? r5;
        int i2;
        int iC;
        int iC2;
        int iG;
        BitSet bitSet2;
        int i3;
        int i4;
        gu0 gu0Var2 = gu0Var;
        BitSet bitSet3 = this.y;
        int i5 = this.p;
        bitSet3.set(0, i5, true);
        rf0 rf0Var2 = this.v;
        int i6 = rf0Var2.i ? rf0Var.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : rf0Var.e == 1 ? rf0Var.g + rf0Var.b : rf0Var.f - rf0Var.b;
        int i7 = rf0Var.e;
        int i8 = 0;
        while (true) {
            yi0VarArr = this.q;
            if (i8 >= i5) {
                break;
            }
            if (!((ArrayList) yi0VarArr[i8].f).isEmpty()) {
                d1(yi0VarArr[i8], i7, i6);
            }
            i8++;
        }
        boolean z = this.x;
        px pxVar = this.r;
        int iG2 = z ? pxVar.g() : pxVar.k();
        boolean z2 = false;
        while (true) {
            int i9 = rf0Var.c;
            if (i9 < 0 || i9 >= mu0Var.b() || (!rf0Var2.i && bitSet3.isEmpty())) {
                break;
            }
            View view = gu0Var2.i(rf0Var.c, Long.MAX_VALUE).a;
            rf0Var.c += rf0Var.d;
            h21 h21Var = (h21) view.getLayoutParams();
            int iC3 = h21Var.a.c();
            pn0 pn0Var = this.B;
            int[] iArr = (int[]) pn0Var.d;
            int i10 = (iArr == null || iC3 >= iArr.length) ? -1 : iArr[iC3];
            if (i10 == -1) {
                if (U0(rf0Var.e)) {
                    i = i5;
                    i4 = i5 - 1;
                    i5 = -1;
                    i3 = -1;
                } else {
                    i = i5;
                    i3 = 1;
                    i4 = 0;
                }
                yi0 yi0Var2 = null;
                int i11 = i3;
                if (rf0Var.e == 1) {
                    int iK = pxVar.k();
                    yi0VarArr2 = yi0VarArr;
                    int i12 = i4;
                    int i13 = Integer.MAX_VALUE;
                    while (i12 != i5) {
                        int i14 = i12;
                        yi0 yi0Var3 = yi0VarArr2[i14];
                        BitSet bitSet4 = bitSet3;
                        int iG3 = yi0Var3.g(iK);
                        if (iG3 < i13) {
                            i13 = iG3;
                            yi0Var2 = yi0Var3;
                        }
                        i12 = i14 + i11;
                        bitSet3 = bitSet4;
                    }
                    bitSet = bitSet3;
                } else {
                    bitSet = bitSet3;
                    yi0VarArr2 = yi0VarArr;
                    int iG4 = pxVar.g();
                    int i15 = i4;
                    int i16 = Integer.MIN_VALUE;
                    while (i15 != i5) {
                        yi0 yi0Var4 = yi0VarArr2[i15];
                        int i17 = i5;
                        int i18 = yi0Var4.i(iG4);
                        if (i18 > i16) {
                            i16 = i18;
                            yi0Var2 = yi0Var4;
                        }
                        i15 += i11;
                        i5 = i17;
                    }
                }
                yi0Var = yi0Var2;
                pn0Var.g(iC3);
                ((int[]) pn0Var.d)[iC3] = yi0Var.e;
            } else {
                bitSet = bitSet3;
                i = i5;
                yi0VarArr2 = yi0VarArr;
                yi0Var = yi0VarArr2[i10];
            }
            h21Var.e = yi0Var;
            if (rf0Var.e == 1) {
                r5 = 0;
                b(view, -1, false);
            } else {
                r5 = 0;
                b(view, 0, false);
            }
            int i19 = this.t;
            if (i19 == 1) {
                S0(view, zt0.w(r5, this.u, this.l, r5, ((ViewGroup.MarginLayoutParams) h21Var).width), zt0.w(true, this.o, this.m, H() + K(), ((ViewGroup.MarginLayoutParams) h21Var).height));
            } else {
                S0(view, zt0.w(true, this.n, this.l, J() + I(), ((ViewGroup.MarginLayoutParams) h21Var).width), zt0.w(false, this.u, this.m, 0, ((ViewGroup.MarginLayoutParams) h21Var).height));
            }
            if (rf0Var.e == 1) {
                iC = yi0Var.g(iG2);
                i2 = pxVar.c(view) + iC;
            } else {
                i2 = yi0Var.i(iG2);
                iC = i2 - pxVar.c(view);
            }
            int i20 = rf0Var.e;
            yi0 yi0Var5 = h21Var.e;
            if (i20 == 1) {
                yi0Var5.getClass();
                h21 h21Var2 = (h21) view.getLayoutParams();
                h21Var2.e = yi0Var5;
                ArrayList arrayList = (ArrayList) yi0Var5.f;
                arrayList.add(view);
                yi0Var5.c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    yi0Var5.b = Integer.MIN_VALUE;
                }
                if (h21Var2.a.i() || h21Var2.a.l()) {
                    yi0Var5.d = ((StaggeredGridLayoutManager) yi0Var5.g).r.c(view) + yi0Var5.d;
                }
            } else {
                yi0Var5.getClass();
                h21 h21Var3 = (h21) view.getLayoutParams();
                h21Var3.e = yi0Var5;
                ArrayList arrayList2 = (ArrayList) yi0Var5.f;
                arrayList2.add(0, view);
                yi0Var5.b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    yi0Var5.c = Integer.MIN_VALUE;
                }
                if (h21Var3.a.i() || h21Var3.a.l()) {
                    yi0Var5.d = ((StaggeredGridLayoutManager) yi0Var5.g).r.c(view) + yi0Var5.d;
                }
            }
            boolean zR0 = R0();
            px pxVar2 = this.s;
            if (zR0 && i19 == 1) {
                iG = pxVar2.g() - (((i - 1) - yi0Var.e) * this.u);
                iC2 = iG - pxVar2.c(view);
            } else {
                int iK2 = (yi0Var.e * this.u) + pxVar2.k();
                int iC4 = pxVar2.c(view) + iK2;
                iC2 = iK2;
                iG = iC4;
            }
            z2 = true;
            if (i19 == 1) {
                zt0.R(view, iC2, iC, iG, i2);
            } else {
                zt0.R(view, iC, iC2, i2, iG);
            }
            d1(yi0Var, rf0Var2.e, i6);
            gu0Var2 = gu0Var;
            W0(gu0Var2, rf0Var2);
            if (rf0Var2.h && view.hasFocusable()) {
                bitSet2 = bitSet;
                bitSet2.set(yi0Var.e, false);
            } else {
                bitSet2 = bitSet;
            }
            bitSet3 = bitSet2;
            i5 = i;
            yi0VarArr = yi0VarArr2;
        }
        if (!z2) {
            W0(gu0Var2, rf0Var2);
        }
        int iK3 = rf0Var2.e == -1 ? pxVar.k() - O0(pxVar.k()) : N0(pxVar.g()) - pxVar.g();
        if (iK3 > 0) {
            return Math.min(rf0Var.b, iK3);
        }
        return 0;
    }

    public final View H0(boolean z) {
        px pxVar = this.r;
        int iK = pxVar.k();
        int iG = pxVar.g();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iE = pxVar.e(viewU);
            int iB = pxVar.b(viewU);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final View I0(boolean z) {
        px pxVar = this.r;
        int iK = pxVar.k();
        int iG = pxVar.g();
        int iV = v();
        View view = null;
        for (int i = 0; i < iV; i++) {
            View viewU = u(i);
            int iE = pxVar.e(viewU);
            if (pxVar.b(viewU) > iK && iE < iG) {
                if (iE >= iK || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void J0(gu0 gu0Var, mu0 mu0Var, boolean z) {
        int iG;
        int iN0 = N0(Integer.MIN_VALUE);
        if (iN0 != Integer.MIN_VALUE && (iG = this.r.g() - iN0) > 0) {
            int i = iG - (-a1(-iG, gu0Var, mu0Var));
            if (!z || i <= 0) {
                return;
            }
            this.r.o(i);
        }
    }

    public final void K0(gu0 gu0Var, mu0 mu0Var, boolean z) {
        int iK;
        int iO0 = O0(Integer.MAX_VALUE);
        if (iO0 != Integer.MAX_VALUE && (iK = iO0 - this.r.k()) > 0) {
            int iA1 = iK - a1(iK, gu0Var, mu0Var);
            if (!z || iA1 <= 0) {
                return;
            }
            this.r.o(-iA1);
        }
    }

    public final int L0() {
        if (v() == 0) {
            return 0;
        }
        return zt0.L(u(0));
    }

    public final int M0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return zt0.L(u(iV - 1));
    }

    @Override // defpackage.zt0
    public final int N(gu0 gu0Var, mu0 mu0Var) {
        return this.t == 0 ? this.p : super.N(gu0Var, mu0Var);
    }

    public final int N0(int i) {
        int iG = this.q[0].g(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iG2 = this.q[i2].g(i);
            if (iG2 > iG) {
                iG = iG2;
            }
        }
        return iG;
    }

    public final int O0(int i) {
        int i2 = this.q[0].i(i);
        for (int i3 = 1; i3 < this.p; i3++) {
            int i4 = this.q[i3].i(i);
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    @Override // defpackage.zt0
    public final boolean P() {
        return this.C != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(int r11, int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View Q0() {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0():android.view.View");
    }

    public final boolean R0() {
        return G() == 1;
    }

    @Override // defpackage.zt0
    public final void S(int i) {
        super.S(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            yi0 yi0Var = this.q[i2];
            int i3 = yi0Var.b;
            if (i3 != Integer.MIN_VALUE) {
                yi0Var.b = i3 + i;
            }
            int i4 = yi0Var.c;
            if (i4 != Integer.MIN_VALUE) {
                yi0Var.c = i4 + i;
            }
        }
    }

    public final void S0(View view, int i, int i2) {
        RecyclerView recyclerView = this.b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.L(view));
        }
        h21 h21Var = (h21) view.getLayoutParams();
        int iE1 = e1(i, ((ViewGroup.MarginLayoutParams) h21Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) h21Var).rightMargin + rect.right);
        int iE12 = e1(i2, ((ViewGroup.MarginLayoutParams) h21Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) h21Var).bottomMargin + rect.bottom);
        if (y0(view, iE1, iE12, h21Var)) {
            view.measure(iE1, iE12);
        }
    }

    @Override // defpackage.zt0
    public final void T(int i) {
        super.T(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            yi0 yi0Var = this.q[i2];
            int i3 = yi0Var.b;
            if (i3 != Integer.MIN_VALUE) {
                yi0Var.b = i3 + i;
            }
            int i4 = yi0Var.c;
            if (i4 != Integer.MIN_VALUE) {
                yi0Var.c = i4 + i;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T0(defpackage.gu0 r18, defpackage.mu0 r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T0(gu0, mu0, boolean):void");
    }

    public final boolean U0(int i) {
        if (this.t == 0) {
            return (i == -1) != this.x;
        }
        return ((i == -1) == this.x) == R0();
    }

    @Override // defpackage.zt0
    public final void V(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i = 0; i < this.p; i++) {
            this.q[i].b();
        }
        recyclerView.requestLayout();
    }

    public final void V0(int i, mu0 mu0Var) {
        int iL0;
        int i2;
        if (i > 0) {
            iL0 = M0();
            i2 = 1;
        } else {
            iL0 = L0();
            i2 = -1;
        }
        rf0 rf0Var = this.v;
        rf0Var.a = true;
        c1(iL0, mu0Var);
        b1(i2);
        rf0Var.c = iL0 + rf0Var.d;
        rf0Var.b = Math.abs(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004f  */
    @Override // defpackage.zt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View W(android.view.View r9, int r10, defpackage.gu0 r11, defpackage.mu0 r12) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.W(android.view.View, int, gu0, mu0):android.view.View");
    }

    public final void W0(gu0 gu0Var, rf0 rf0Var) {
        if (!rf0Var.a || rf0Var.i) {
            return;
        }
        int i = rf0Var.b;
        int i2 = rf0Var.e;
        if (i == 0) {
            if (i2 == -1) {
                X0(gu0Var, rf0Var.g);
                return;
            } else {
                Y0(gu0Var, rf0Var.f);
                return;
            }
        }
        int i3 = this.p;
        yi0[] yi0VarArr = this.q;
        int i4 = 1;
        if (i2 == -1) {
            int i5 = rf0Var.f;
            int i6 = yi0VarArr[0].i(i5);
            while (i4 < i3) {
                int i7 = yi0VarArr[i4].i(i5);
                if (i7 > i6) {
                    i6 = i7;
                }
                i4++;
            }
            int i8 = i5 - i6;
            int iMin = rf0Var.g;
            if (i8 >= 0) {
                iMin -= Math.min(i8, rf0Var.b);
            }
            X0(gu0Var, iMin);
            return;
        }
        int i9 = rf0Var.g;
        int iG = yi0VarArr[0].g(i9);
        while (i4 < i3) {
            int iG2 = yi0VarArr[i4].g(i9);
            if (iG2 < iG) {
                iG = iG2;
            }
            i4++;
        }
        int i10 = iG - rf0Var.g;
        int iMin2 = rf0Var.f;
        if (i10 >= 0) {
            iMin2 += Math.min(i10, rf0Var.b);
        }
        Y0(gu0Var, iMin2);
    }

    @Override // defpackage.zt0
    public final void X(AccessibilityEvent accessibilityEvent) {
        super.X(accessibilityEvent);
        if (v() > 0) {
            View viewI0 = I0(false);
            View viewH0 = H0(false);
            if (viewI0 == null || viewH0 == null) {
                return;
            }
            int iL = zt0.L(viewI0);
            int iL2 = zt0.L(viewH0);
            if (iL < iL2) {
                accessibilityEvent.setFromIndex(iL);
                accessibilityEvent.setToIndex(iL2);
            } else {
                accessibilityEvent.setFromIndex(iL2);
                accessibilityEvent.setToIndex(iL);
            }
        }
    }

    public final void X0(gu0 gu0Var, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            px pxVar = this.r;
            if (pxVar.e(viewU) < i || pxVar.n(viewU) < i) {
                return;
            }
            h21 h21Var = (h21) viewU.getLayoutParams();
            h21Var.getClass();
            if (((ArrayList) h21Var.e.f).size() == 1) {
                return;
            }
            yi0 yi0Var = h21Var.e;
            ArrayList arrayList = (ArrayList) yi0Var.f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            h21 h21Var2 = (h21) view.getLayoutParams();
            h21Var2.e = null;
            if (h21Var2.a.i() || h21Var2.a.l()) {
                yi0Var.d -= ((StaggeredGridLayoutManager) yi0Var.g).r.c(view);
            }
            if (size == 1) {
                yi0Var.b = Integer.MIN_VALUE;
            }
            yi0Var.c = Integer.MIN_VALUE;
            m0(viewU, gu0Var);
        }
    }

    @Override // defpackage.zt0
    public final void Y(gu0 gu0Var, mu0 mu0Var, View view, n0 n0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof h21)) {
            Z(view, n0Var);
            return;
        }
        yi0 yi0Var = ((h21) layoutParams).e;
        if (this.t == 0) {
            n0Var.j(m0.a(false, yi0Var == null ? -1 : yi0Var.e, 1, -1, -1));
        } else {
            n0Var.j(m0.a(false, -1, -1, yi0Var == null ? -1 : yi0Var.e, 1));
        }
    }

    public final void Y0(gu0 gu0Var, int i) {
        while (v() > 0) {
            View viewU = u(0);
            px pxVar = this.r;
            if (pxVar.b(viewU) > i || pxVar.m(viewU) > i) {
                return;
            }
            h21 h21Var = (h21) viewU.getLayoutParams();
            h21Var.getClass();
            if (((ArrayList) h21Var.e.f).size() == 1) {
                return;
            }
            yi0 yi0Var = h21Var.e;
            ArrayList arrayList = (ArrayList) yi0Var.f;
            View view = (View) arrayList.remove(0);
            h21 h21Var2 = (h21) view.getLayoutParams();
            h21Var2.e = null;
            if (arrayList.size() == 0) {
                yi0Var.c = Integer.MIN_VALUE;
            }
            if (h21Var2.a.i() || h21Var2.a.l()) {
                yi0Var.d -= ((StaggeredGridLayoutManager) yi0Var.g).r.c(view);
            }
            yi0Var.b = Integer.MIN_VALUE;
            m0(viewU, gu0Var);
        }
    }

    public final void Z0() {
        if (this.t == 1 || !R0()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // defpackage.lu0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.L0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r3 = 0
            return r3
        L24:
            int r3 = r3.t
            r0 = 0
            if (r3 != 0) goto L2f
            float r3 = (float) r1
            r4.x = r3
            r4.y = r0
            return r4
        L2f:
            r4.x = r0
            float r3 = (float) r1
            r4.y = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // defpackage.zt0
    public final void a0(int i, int i2) {
        P0(i, i2, 1);
    }

    public final int a1(int i, gu0 gu0Var, mu0 mu0Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        V0(i, mu0Var);
        rf0 rf0Var = this.v;
        int iG0 = G0(gu0Var, rf0Var, mu0Var);
        if (rf0Var.b >= iG0) {
            i = i < 0 ? -iG0 : iG0;
        }
        this.r.o(-i);
        this.D = this.x;
        rf0Var.b = 0;
        W0(gu0Var, rf0Var);
        return i;
    }

    @Override // defpackage.zt0
    public final void b0() {
        pn0 pn0Var = this.B;
        int[] iArr = (int[]) pn0Var.d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        pn0Var.c = null;
        p0();
    }

    public final void b1(int i) {
        rf0 rf0Var = this.v;
        rf0Var.e = i;
        rf0Var.d = this.x != (i == -1) ? -1 : 1;
    }

    @Override // defpackage.zt0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // defpackage.zt0
    public final void c0(int i, int i2) {
        P0(i, i2, 8);
    }

    public final void c1(int i, mu0 mu0Var) {
        int iL;
        int iL2;
        int i2;
        rf0 rf0Var = this.v;
        boolean z = false;
        rf0Var.b = 0;
        rf0Var.c = i;
        qg0 qg0Var = this.e;
        px pxVar = this.r;
        if (qg0Var == null || !qg0Var.e || (i2 = mu0Var.a) == -1) {
            iL = 0;
            iL2 = 0;
        } else {
            if (this.x == (i2 < i)) {
                iL = pxVar.l();
                iL2 = 0;
            } else {
                iL2 = pxVar.l();
                iL = 0;
            }
        }
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || !recyclerView.h) {
            rf0Var.g = pxVar.f() + iL;
            rf0Var.f = -iL2;
        } else {
            rf0Var.f = pxVar.k() - iL2;
            rf0Var.g = pxVar.g() + iL;
        }
        rf0Var.h = false;
        rf0Var.a = true;
        if (pxVar.i() == 0 && pxVar.f() == 0) {
            z = true;
        }
        rf0Var.i = z;
    }

    @Override // defpackage.zt0
    public final boolean d() {
        return this.t == 0;
    }

    @Override // defpackage.zt0
    public final void d0(int i, int i2) {
        P0(i, i2, 2);
    }

    public final void d1(yi0 yi0Var, int i, int i2) {
        int i3 = yi0Var.d;
        int i4 = yi0Var.e;
        BitSet bitSet = this.y;
        if (i != -1) {
            int i5 = yi0Var.c;
            if (i5 == Integer.MIN_VALUE) {
                yi0Var.a();
                i5 = yi0Var.c;
            }
            if (i5 - i3 >= i2) {
                bitSet.set(i4, false);
                return;
            }
            return;
        }
        int i6 = yi0Var.b;
        if (i6 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) yi0Var.f).get(0);
            h21 h21Var = (h21) view.getLayoutParams();
            yi0Var.b = ((StaggeredGridLayoutManager) yi0Var.g).r.e(view);
            h21Var.getClass();
            i6 = yi0Var.b;
        }
        if (i6 + i3 <= i2) {
            bitSet.set(i4, false);
        }
    }

    @Override // defpackage.zt0
    public final boolean e() {
        return this.t == 1;
    }

    @Override // defpackage.zt0
    public final void e0(int i, int i2) {
        P0(i, i2, 4);
    }

    @Override // defpackage.zt0
    public final boolean f(au0 au0Var) {
        return au0Var instanceof h21;
    }

    @Override // defpackage.zt0
    public final void f0(gu0 gu0Var, mu0 mu0Var) {
        T0(gu0Var, mu0Var, true);
    }

    @Override // defpackage.zt0
    public final void g0(mu0 mu0Var) {
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // defpackage.zt0
    public final void h(int i, int i2, mu0 mu0Var, l50 l50Var) {
        rf0 rf0Var;
        int iG;
        if (this.t != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        V0(i, mu0Var);
        int[] iArr = this.J;
        int i3 = this.p;
        if (iArr == null || iArr.length < i3) {
            this.J = new int[i3];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            rf0Var = this.v;
            if (i4 >= i3) {
                break;
            }
            int i6 = rf0Var.d;
            yi0[] yi0VarArr = this.q;
            if (i6 == -1) {
                int i7 = rf0Var.f;
                iG = i7 - yi0VarArr[i4].i(i7);
            } else {
                iG = yi0VarArr[i4].g(rf0Var.g) - rf0Var.g;
            }
            if (iG >= 0) {
                this.J[i5] = iG;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.J, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = rf0Var.c;
            if (i9 < 0 || i9 >= mu0Var.b()) {
                return;
            }
            l50Var.a(rf0Var.c, this.J[i8]);
            rf0Var.c += rf0Var.d;
        }
    }

    @Override // defpackage.zt0
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof j21) {
            this.F = (j21) parcelable;
            p0();
        }
    }

    @Override // defpackage.zt0
    public final Parcelable i0() {
        int i;
        int iK;
        int[] iArr;
        j21 j21Var = this.F;
        if (j21Var != null) {
            j21 j21Var2 = new j21();
            j21Var2.d = j21Var.d;
            j21Var2.b = j21Var.b;
            j21Var2.c = j21Var.c;
            j21Var2.e = j21Var.e;
            j21Var2.f = j21Var.f;
            j21Var2.g = j21Var.g;
            j21Var2.i = j21Var.i;
            j21Var2.j = j21Var.j;
            j21Var2.k = j21Var.k;
            j21Var2.h = j21Var.h;
            return j21Var2;
        }
        j21 j21Var3 = new j21();
        j21Var3.i = this.w;
        j21Var3.j = this.D;
        j21Var3.k = this.E;
        pn0 pn0Var = this.B;
        if (pn0Var == null || (iArr = (int[]) pn0Var.d) == null) {
            j21Var3.f = 0;
        } else {
            j21Var3.g = iArr;
            j21Var3.f = iArr.length;
            j21Var3.h = (ArrayList) pn0Var.c;
        }
        if (v() <= 0) {
            j21Var3.b = -1;
            j21Var3.c = -1;
            j21Var3.d = 0;
            return j21Var3;
        }
        j21Var3.b = this.D ? M0() : L0();
        View viewH0 = this.x ? H0(true) : I0(true);
        j21Var3.c = viewH0 != null ? zt0.L(viewH0) : -1;
        int i2 = this.p;
        j21Var3.d = i2;
        j21Var3.e = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            boolean z = this.D;
            px pxVar = this.r;
            yi0[] yi0VarArr = this.q;
            if (z) {
                i = yi0VarArr[i3].g(Integer.MIN_VALUE);
                if (i != Integer.MIN_VALUE) {
                    iK = pxVar.g();
                    i -= iK;
                }
            } else {
                i = yi0VarArr[i3].i(Integer.MIN_VALUE);
                if (i != Integer.MIN_VALUE) {
                    iK = pxVar.k();
                    i -= iK;
                }
            }
            j21Var3.e[i3] = i;
        }
        return j21Var3;
    }

    @Override // defpackage.zt0
    public final int j(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return xy0.h(mu0Var, this.r, I0(z), H0(z), this, this.I);
    }

    @Override // defpackage.zt0
    public final void j0(int i) {
        if (i == 0) {
            E0();
        }
    }

    @Override // defpackage.zt0
    public final int k(mu0 mu0Var) {
        return F0(mu0Var);
    }

    @Override // defpackage.zt0
    public final int l(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return xy0.j(mu0Var, this.r, I0(z), H0(z), this, this.I);
    }

    @Override // defpackage.zt0
    public final int m(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return xy0.h(mu0Var, this.r, I0(z), H0(z), this, this.I);
    }

    @Override // defpackage.zt0
    public final int n(mu0 mu0Var) {
        return F0(mu0Var);
    }

    @Override // defpackage.zt0
    public final int o(mu0 mu0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return xy0.j(mu0Var, this.r, I0(z), H0(z), this, this.I);
    }

    @Override // defpackage.zt0
    public final int q0(int i, gu0 gu0Var, mu0 mu0Var) {
        return a1(i, gu0Var, mu0Var);
    }

    @Override // defpackage.zt0
    public final au0 r() {
        return this.t == 0 ? new h21(-2, -1) : new h21(-1, -2);
    }

    @Override // defpackage.zt0
    public final void r0(int i) {
        j21 j21Var = this.F;
        if (j21Var != null && j21Var.b != i) {
            j21Var.e = null;
            j21Var.d = 0;
            j21Var.b = -1;
            j21Var.c = -1;
        }
        this.z = i;
        this.A = Integer.MIN_VALUE;
        p0();
    }

    @Override // defpackage.zt0
    public final au0 s(Context context, AttributeSet attributeSet) {
        return new h21(context, attributeSet);
    }

    @Override // defpackage.zt0
    public final int s0(int i, gu0 gu0Var, mu0 mu0Var) {
        return a1(i, gu0Var, mu0Var);
    }

    @Override // defpackage.zt0
    public final au0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new h21((ViewGroup.MarginLayoutParams) layoutParams) : new h21(layoutParams);
    }

    @Override // defpackage.zt0
    public final void v0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        int iJ = J() + I();
        int iH = H() + K();
        int i3 = this.t;
        int i4 = this.p;
        if (i3 == 1) {
            int iHeight = rect.height() + iH;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = uf1.a;
            iG2 = zt0.g(i2, iHeight, recyclerView.getMinimumHeight());
            iG = zt0.g(i, (this.u * i4) + iJ, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iJ;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = uf1.a;
            iG = zt0.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = zt0.g(i2, (this.u * i4) + iH, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    @Override // defpackage.zt0
    public final int x(gu0 gu0Var, mu0 mu0Var) {
        return this.t == 1 ? this.p : super.x(gu0Var, mu0Var);
    }
}
