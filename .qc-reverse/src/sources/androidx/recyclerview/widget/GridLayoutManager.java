package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import defpackage.au0;
import defpackage.e70;
import defpackage.gu0;
import defpackage.i9;
import defpackage.l50;
import defpackage.m0;
import defpackage.mg0;
import defpackage.mu0;
import defpackage.n0;
import defpackage.ng0;
import defpackage.og0;
import defpackage.qq0;
import defpackage.uf1;
import defpackage.zt0;
import defpackage.zy;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final i9 K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new i9();
        this.L = new Rect();
        q1(zt0.M(context, attributeSet, i, i2).b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final boolean D0() {
        return this.z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(mu0 mu0Var, og0 og0Var, l50 l50Var) {
        int i;
        int i2 = this.F;
        for (int i3 = 0; i3 < this.F && (i = og0Var.d) >= 0 && i < mu0Var.b() && i2 > 0; i3++) {
            l50Var.a(og0Var.d, Math.max(0, og0Var.g));
            this.K.getClass();
            i2--;
            og0Var.d += og0Var.e;
        }
    }

    @Override // defpackage.zt0
    public final int N(gu0 gu0Var, mu0 mu0Var) {
        if (this.p == 0) {
            return this.F;
        }
        if (mu0Var.b() < 1) {
            return 0;
        }
        return m1(mu0Var.b() - 1, gu0Var, mu0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View R0(gu0 gu0Var, mu0 mu0Var, int i, int i2, int i3) {
        K0();
        int iK = this.r.k();
        int iG = this.r.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewU = u(i);
            int iL = zt0.L(viewU);
            if (iL >= 0 && iL < i3 && n1(iL, gu0Var, mu0Var) == 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x013f, code lost:
    
        if (r16 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0141, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0142, code lost:
    
        return r17;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View W(android.view.View r23, int r24, defpackage.gu0 r25, defpackage.mu0 r26) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.W(android.view.View, int, gu0, mu0):android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v32 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void X0(gu0 gu0Var, mu0 mu0Var, og0 og0Var, ng0 ng0Var) {
        int i;
        int i2;
        int i3;
        int iD;
        int iD2;
        int I;
        int iW;
        int iW2;
        ?? r12;
        int i4;
        View viewB;
        int iJ = this.r.j();
        boolean z = iJ != 1073741824;
        int i5 = v() > 0 ? this.G[this.F] : 0;
        if (z) {
            r1();
        }
        boolean z2 = og0Var.e == 1;
        int iN1 = this.F;
        if (!z2) {
            iN1 = n1(og0Var.d, gu0Var, mu0Var) + o1(og0Var.d, gu0Var, mu0Var);
        }
        int i6 = 0;
        while (i6 < this.F && (i4 = og0Var.d) >= 0 && i4 < mu0Var.b() && iN1 > 0) {
            int i7 = og0Var.d;
            int iO1 = o1(i7, gu0Var, mu0Var);
            if (iO1 > this.F) {
                throw new IllegalArgumentException("Item at position " + i7 + " requires " + iO1 + " spans but GridLayoutManager has only " + this.F + " spans.");
            }
            iN1 -= iO1;
            if (iN1 < 0 || (viewB = og0Var.b(gu0Var)) == null) {
                break;
            }
            this.H[i6] = viewB;
            i6++;
        }
        if (i6 == 0) {
            ng0Var.b = true;
            return;
        }
        if (z2) {
            i3 = 1;
            i2 = i6;
            i = 0;
        } else {
            i = i6 - 1;
            i2 = -1;
            i3 = -1;
        }
        int i8 = 0;
        while (i != i2) {
            View view = this.H[i];
            e70 e70Var = (e70) view.getLayoutParams();
            int iO12 = o1(zt0.L(view), gu0Var, mu0Var);
            e70Var.f = iO12;
            e70Var.e = i8;
            i8 += iO12;
            i += i3;
        }
        float f = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            View view2 = this.H[i10];
            if (og0Var.k != null) {
                r12 = 0;
                r12 = 0;
                if (z2) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z2) {
                r12 = 0;
                b(view2, -1, false);
            } else {
                r12 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.b;
            Rect rect = this.L;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.L(view2));
            }
            p1(view2, iJ, r12);
            int iC = this.r.c(view2);
            if (iC > i9) {
                i9 = iC;
            }
            float fD = (this.r.d(view2) * 1.0f) / ((e70) view2.getLayoutParams()).f;
            if (fD > f) {
                f = fD;
            }
        }
        if (z) {
            j1(Math.max(Math.round(f * this.F), i5));
            i9 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                View view3 = this.H[i11];
                p1(view3, 1073741824, true);
                int iC2 = this.r.c(view3);
                if (iC2 > i9) {
                    i9 = iC2;
                }
            }
        }
        for (int i12 = 0; i12 < i6; i12++) {
            View view4 = this.H[i12];
            if (this.r.c(view4) != i9) {
                e70 e70Var2 = (e70) view4.getLayoutParams();
                Rect rect2 = e70Var2.b;
                int i13 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) e70Var2).topMargin + ((ViewGroup.MarginLayoutParams) e70Var2).bottomMargin;
                int i14 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) e70Var2).leftMargin + ((ViewGroup.MarginLayoutParams) e70Var2).rightMargin;
                int iL1 = l1(e70Var2.e, e70Var2.f);
                if (this.p == 1) {
                    iW2 = zt0.w(false, iL1, 1073741824, i14, ((ViewGroup.MarginLayoutParams) e70Var2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i9 - i13, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i14, 1073741824);
                    iW = zt0.w(false, iL1, 1073741824, i13, ((ViewGroup.MarginLayoutParams) e70Var2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (A0(view4, iW2, iW, (au0) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        ng0Var.a = i9;
        int i15 = this.p;
        int i16 = og0Var.f;
        int i17 = og0Var.b;
        if (i15 == 1) {
            if (i16 == -1) {
                i17 -= i9;
                iD2 = i17;
            } else {
                iD2 = i17 + i9;
            }
            I = 0;
            iD = 0;
        } else {
            if (i16 == -1) {
                I = i17 - i9;
                iD2 = 0;
                iD = i17;
            } else {
                iD = i17 + i9;
                iD2 = 0;
                I = i17;
            }
            i17 = iD2;
        }
        int i18 = 0;
        while (true) {
            View[] viewArr = this.H;
            if (i18 >= i6) {
                Arrays.fill(viewArr, (Object) null);
                return;
            }
            View view5 = viewArr[i18];
            e70 e70Var3 = (e70) view5.getLayoutParams();
            if (this.p != 1) {
                int iK = K() + this.G[e70Var3.e];
                i17 = iK;
                iD2 = this.r.d(view5) + iK;
            } else if (W0()) {
                int I2 = I() + this.G[this.F - e70Var3.e];
                iD = I2;
                I = I2 - this.r.d(view5);
            } else {
                I = I() + this.G[e70Var3.e];
                iD = this.r.d(view5) + I;
            }
            zt0.R(view5, I, i17, iD, iD2);
            if (e70Var3.a.i() || e70Var3.a.l()) {
                ng0Var.c = true;
            }
            ng0Var.d = view5.hasFocusable() | ng0Var.d;
            i18++;
        }
    }

    @Override // defpackage.zt0
    public final void Y(gu0 gu0Var, mu0 mu0Var, View view, n0 n0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof e70)) {
            Z(view, n0Var);
            return;
        }
        e70 e70Var = (e70) layoutParams;
        int iM1 = m1(e70Var.a.c(), gu0Var, mu0Var);
        int i = this.p;
        int i2 = e70Var.e;
        int i3 = e70Var.f;
        if (i == 0) {
            n0Var.j(m0.a(false, i2, i3, iM1, 1));
        } else {
            n0Var.j(m0.a(false, iM1, 1, i2, i3));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Y0(gu0 gu0Var, mu0 mu0Var, mg0 mg0Var, int i) {
        r1();
        if (mu0Var.b() > 0 && !mu0Var.g) {
            boolean z = i == 1;
            int iN1 = n1(mg0Var.b, gu0Var, mu0Var);
            if (z) {
                while (iN1 > 0) {
                    int i2 = mg0Var.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    mg0Var.b = i3;
                    iN1 = n1(i3, gu0Var, mu0Var);
                }
            } else {
                int iB = mu0Var.b() - 1;
                int i4 = mg0Var.b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iN12 = n1(i5, gu0Var, mu0Var);
                    if (iN12 <= iN1) {
                        break;
                    }
                    i4 = i5;
                    iN1 = iN12;
                }
                mg0Var.b = i4;
            }
        }
        k1();
    }

    @Override // defpackage.zt0
    public final void a0(int i, int i2) {
        i9 i9Var = this.K;
        i9Var.z();
        ((SparseIntArray) i9Var.d).clear();
    }

    @Override // defpackage.zt0
    public final void b0() {
        i9 i9Var = this.K;
        i9Var.z();
        ((SparseIntArray) i9Var.d).clear();
    }

    @Override // defpackage.zt0
    public final void c0(int i, int i2) {
        i9 i9Var = this.K;
        i9Var.z();
        ((SparseIntArray) i9Var.d).clear();
    }

    @Override // defpackage.zt0
    public final void d0(int i, int i2) {
        i9 i9Var = this.K;
        i9Var.z();
        ((SparseIntArray) i9Var.d).clear();
    }

    @Override // defpackage.zt0
    public final void e0(int i, int i2) {
        i9 i9Var = this.K;
        i9Var.z();
        ((SparseIntArray) i9Var.d).clear();
    }

    @Override // defpackage.zt0
    public final boolean f(au0 au0Var) {
        return au0Var instanceof e70;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final void f0(gu0 gu0Var, mu0 mu0Var) {
        boolean z = mu0Var.g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                e70 e70Var = (e70) u(i).getLayoutParams();
                int iC = e70Var.a.c();
                sparseIntArray2.put(iC, e70Var.f);
                sparseIntArray.put(iC, e70Var.e);
            }
        }
        super.f0(gu0Var, mu0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void f1(boolean z) {
        if (z) {
            zy.f("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.f1(false);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final void g0(mu0 mu0Var) {
        super.g0(mu0Var);
        this.E = false;
    }

    public final void j1(int i) {
        int i2;
        int[] iArr = this.G;
        int i3 = this.F;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.G = iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int k(mu0 mu0Var) {
        return H0(mu0Var);
    }

    public final void k1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int l(mu0 mu0Var) {
        return I0(mu0Var);
    }

    public final int l1(int i, int i2) {
        if (this.p != 1 || !W0()) {
            int[] iArr = this.G;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.G;
        int i3 = this.F;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int m1(int i, gu0 gu0Var, mu0 mu0Var) {
        boolean z = mu0Var.g;
        i9 i9Var = this.K;
        if (!z) {
            int i2 = this.F;
            i9Var.getClass();
            return i9.y(i, i2);
        }
        int iB = gu0Var.b(i);
        if (iB != -1) {
            int i3 = this.F;
            i9Var.getClass();
            return i9.y(iB, i3);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int n(mu0 mu0Var) {
        return H0(mu0Var);
    }

    public final int n1(int i, gu0 gu0Var, mu0 mu0Var) {
        boolean z = mu0Var.g;
        i9 i9Var = this.K;
        if (!z) {
            int i2 = this.F;
            i9Var.getClass();
            return i % i2;
        }
        int i3 = this.J.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int iB = gu0Var.b(i);
        if (iB != -1) {
            int i4 = this.F;
            i9Var.getClass();
            return iB % i4;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int o(mu0 mu0Var) {
        return I0(mu0Var);
    }

    public final int o1(int i, gu0 gu0Var, mu0 mu0Var) {
        boolean z = mu0Var.g;
        i9 i9Var = this.K;
        if (!z) {
            i9Var.getClass();
            return 1;
        }
        int i2 = this.I.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (gu0Var.b(i) != -1) {
            i9Var.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void p1(View view, int i, boolean z) {
        int iW;
        int iW2;
        e70 e70Var = (e70) view.getLayoutParams();
        Rect rect = e70Var.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) e70Var).topMargin + ((ViewGroup.MarginLayoutParams) e70Var).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) e70Var).leftMargin + ((ViewGroup.MarginLayoutParams) e70Var).rightMargin;
        int iL1 = l1(e70Var.e, e70Var.f);
        if (this.p == 1) {
            iW2 = zt0.w(false, iL1, i, i3, ((ViewGroup.MarginLayoutParams) e70Var).width);
            iW = zt0.w(true, this.r.l(), this.m, i2, ((ViewGroup.MarginLayoutParams) e70Var).height);
        } else {
            int iW3 = zt0.w(false, iL1, i, i2, ((ViewGroup.MarginLayoutParams) e70Var).height);
            int iW4 = zt0.w(true, this.r.l(), this.l, i3, ((ViewGroup.MarginLayoutParams) e70Var).width);
            iW = iW3;
            iW2 = iW4;
        }
        au0 au0Var = (au0) view.getLayoutParams();
        if (z ? A0(view, iW2, iW, au0Var) : y0(view, iW2, iW, au0Var)) {
            view.measure(iW2, iW);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int q0(int i, gu0 gu0Var, mu0 mu0Var) {
        r1();
        k1();
        return super.q0(i, gu0Var, mu0Var);
    }

    public final void q1(int i) {
        if (i == this.F) {
            return;
        }
        this.E = true;
        if (i < 1) {
            zy.n(qq0.i("Span count should be at least 1. Provided ", i));
            return;
        }
        this.F = i;
        this.K.z();
        p0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final au0 r() {
        return this.p == 0 ? new e70(-2, -1) : new e70(-1, -2);
    }

    public final void r1() {
        int iH;
        int iK;
        if (this.p == 1) {
            iH = this.n - J();
            iK = I();
        } else {
            iH = this.o - H();
            iK = K();
        }
        j1(iH - iK);
    }

    @Override // defpackage.zt0
    public final au0 s(Context context, AttributeSet attributeSet) {
        e70 e70Var = new e70(context, attributeSet);
        e70Var.e = -1;
        e70Var.f = 0;
        return e70Var;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final int s0(int i, gu0 gu0Var, mu0 mu0Var) {
        r1();
        k1();
        return super.s0(i, gu0Var, mu0Var);
    }

    @Override // defpackage.zt0
    public final au0 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            e70 e70Var = new e70((ViewGroup.MarginLayoutParams) layoutParams);
            e70Var.e = -1;
            e70Var.f = 0;
            return e70Var;
        }
        e70 e70Var2 = new e70(layoutParams);
        e70Var2.e = -1;
        e70Var2.f = 0;
        return e70Var2;
    }

    @Override // defpackage.zt0
    public final void v0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.v0(rect, i, i2);
        }
        int iJ = J() + I();
        int iH = H() + K();
        if (this.p == 1) {
            int iHeight = rect.height() + iH;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = uf1.a;
            iG2 = zt0.g(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = zt0.g(i, iArr[iArr.length - 1] + iJ, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iJ;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = uf1.a;
            iG = zt0.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = zt0.g(i2, iArr2[iArr2.length - 1] + iH, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    @Override // defpackage.zt0
    public final int x(gu0 gu0Var, mu0 mu0Var) {
        if (this.p == 1) {
            return this.F;
        }
        if (mu0Var.b() < 1) {
            return 0;
        }
        return m1(mu0Var.b() - 1, gu0Var, mu0Var) + 1;
    }

    public GridLayoutManager(int i) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new i9();
        this.L = new Rect();
        q1(i);
    }
}
