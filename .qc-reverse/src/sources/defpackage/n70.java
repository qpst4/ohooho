package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n70 extends vn {
    public float q0 = -1.0f;
    public int r0 = -1;
    public int s0 = -1;
    public gn t0 = this.J;
    public int u0 = 0;
    public boolean v0;

    public n70() {
        this.R.clear();
        this.R.add(this.t0);
        int length = this.Q.length;
        for (int i = 0; i < length; i++) {
            this.Q[i] = this.t0;
        }
    }

    @Override // defpackage.vn
    public final boolean A() {
        return this.v0;
    }

    @Override // defpackage.vn
    public final boolean B() {
        return this.v0;
    }

    @Override // defpackage.vn
    public final void Q(rg0 rg0Var, boolean z) {
        if (this.T == null) {
            return;
        }
        gn gnVar = this.t0;
        rg0Var.getClass();
        int iN = rg0.n(gnVar);
        if (this.u0 == 1) {
            this.Y = iN;
            this.Z = 0;
            L(this.T.k());
            O(0);
            return;
        }
        this.Y = 0;
        this.Z = iN;
        O(this.T.q());
        L(0);
    }

    public final void R(int i) {
        this.t0.l(i);
        this.v0 = true;
    }

    public final void S(int i) {
        if (this.u0 == i) {
            return;
        }
        this.u0 = i;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.u0 == 1) {
            this.t0 = this.I;
        } else {
            this.t0 = this.J;
        }
        arrayList.add(this.t0);
        gn[] gnVarArr = this.Q;
        int length = gnVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            gnVarArr[i2] = this.t0;
        }
    }

    @Override // defpackage.vn
    public final void b(rg0 rg0Var, boolean z) {
        wn wnVar = (wn) this.T;
        if (wnVar == null) {
            return;
        }
        Object objI = wnVar.i(2);
        Object objI2 = wnVar.i(4);
        vn vnVar = this.T;
        boolean z2 = vnVar != null && vnVar.p0[0] == 2;
        if (this.u0 == 0) {
            objI = wnVar.i(3);
            objI2 = wnVar.i(5);
            vn vnVar2 = this.T;
            z2 = vnVar2 != null && vnVar2.p0[1] == 2;
        }
        if (this.v0) {
            gn gnVar = this.t0;
            if (gnVar.c) {
                m11 m11VarK = rg0Var.k(gnVar);
                rg0Var.d(m11VarK, this.t0.d());
                if (this.r0 != -1) {
                    if (z2) {
                        rg0Var.f(rg0Var.k(objI2), m11VarK, 0, 5);
                    }
                } else if (this.s0 != -1 && z2) {
                    m11 m11VarK2 = rg0Var.k(objI2);
                    rg0Var.f(m11VarK, rg0Var.k(objI), 0, 5);
                    rg0Var.f(m11VarK2, m11VarK, 0, 5);
                }
                this.v0 = false;
                return;
            }
        }
        if (this.r0 != -1) {
            m11 m11VarK3 = rg0Var.k(this.t0);
            rg0Var.e(m11VarK3, rg0Var.k(objI), this.r0, 8);
            if (z2) {
                rg0Var.f(rg0Var.k(objI2), m11VarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.s0 != -1) {
            m11 m11VarK4 = rg0Var.k(this.t0);
            m11 m11VarK5 = rg0Var.k(objI2);
            rg0Var.e(m11VarK4, m11VarK5, -this.s0, 8);
            if (z2) {
                rg0Var.f(m11VarK4, rg0Var.k(objI), 0, 5);
                rg0Var.f(m11VarK5, m11VarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.q0 != -1.0f) {
            m11 m11VarK6 = rg0Var.k(this.t0);
            m11 m11VarK7 = rg0Var.k(objI2);
            float f = this.q0;
            lb lbVarL = rg0Var.l();
            lbVarL.d.g(m11VarK6, -1.0f);
            lbVarL.d.g(m11VarK7, f);
            rg0Var.c(lbVarL);
        }
    }

    @Override // defpackage.vn
    public final boolean c() {
        return true;
    }

    @Override // defpackage.vn
    public final gn i(int i) {
        int iR = l11.r(i);
        if (iR != 1) {
            if (iR != 2) {
                if (iR != 3) {
                    if (iR != 4) {
                        return null;
                    }
                }
            }
            if (this.u0 == 0) {
                return this.t0;
            }
            return null;
        }
        if (this.u0 == 1) {
            return this.t0;
        }
        return null;
    }
}
