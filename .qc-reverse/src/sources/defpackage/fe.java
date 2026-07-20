package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fe extends b80 {
    public int s0;
    public boolean t0;
    public int u0;
    public boolean v0;

    @Override // defpackage.vn
    public final boolean A() {
        return this.v0;
    }

    @Override // defpackage.vn
    public final boolean B() {
        return this.v0;
    }

    public final boolean T() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.r0;
            if (i4 >= i) {
                break;
            }
            vn vnVar = this.q0[i4];
            if ((this.t0 || vnVar.c()) && ((((i2 = this.s0) == 0 || i2 == 1) && !vnVar.A()) || (((i3 = this.s0) == 2 || i3 == 3) && !vnVar.B()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.r0; i5++) {
            vn vnVar2 = this.q0[i5];
            if (this.t0 || vnVar2.c()) {
                if (!z2) {
                    int i6 = this.s0;
                    if (i6 == 0) {
                        iMax = vnVar2.i(2).d();
                    } else if (i6 == 1) {
                        iMax = vnVar2.i(4).d();
                    } else if (i6 == 2) {
                        iMax = vnVar2.i(3).d();
                    } else if (i6 == 3) {
                        iMax = vnVar2.i(5).d();
                    }
                    z2 = true;
                }
                int i7 = this.s0;
                if (i7 == 0) {
                    iMax = Math.min(iMax, vnVar2.i(2).d());
                } else if (i7 == 1) {
                    iMax = Math.max(iMax, vnVar2.i(4).d());
                } else if (i7 == 2) {
                    iMax = Math.min(iMax, vnVar2.i(3).d());
                } else if (i7 == 3) {
                    iMax = Math.max(iMax, vnVar2.i(5).d());
                }
            }
        }
        int i8 = iMax + this.u0;
        int i9 = this.s0;
        if (i9 == 0 || i9 == 1) {
            J(i8, i8);
        } else {
            K(i8, i8);
        }
        this.v0 = true;
        return true;
    }

    public final int U() {
        int i = this.s0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // defpackage.vn
    public final void b(rg0 rg0Var, boolean z) {
        boolean z2;
        int i;
        int i2;
        gn[] gnVarArr = this.Q;
        gn gnVar = this.I;
        gnVarArr[0] = gnVar;
        int i3 = 2;
        gn gnVar2 = this.J;
        gnVarArr[2] = gnVar2;
        gn gnVar3 = this.K;
        gnVarArr[1] = gnVar3;
        gn gnVar4 = this.L;
        gnVarArr[3] = gnVar4;
        for (gn gnVar5 : gnVarArr) {
            gnVar5.i = rg0Var.k(gnVar5);
        }
        int i4 = this.s0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        gn gnVar6 = gnVarArr[i4];
        if (!this.v0) {
            T();
        }
        if (this.v0) {
            this.v0 = false;
            int i5 = this.s0;
            if (i5 == 0 || i5 == 1) {
                rg0Var.d(gnVar.i, this.Y);
                rg0Var.d(gnVar3.i, this.Y);
                return;
            } else {
                if (i5 == 2 || i5 == 3) {
                    rg0Var.d(gnVar2.i, this.Z);
                    rg0Var.d(gnVar4.i, this.Z);
                    return;
                }
                return;
            }
        }
        for (int i6 = 0; i6 < this.r0; i6++) {
            vn vnVar = this.q0[i6];
            if ((this.t0 || vnVar.c()) && ((((i2 = this.s0) == 0 || i2 == 1) && vnVar.p0[0] == 3 && vnVar.I.f != null && vnVar.K.f != null) || ((i2 == 2 || i2 == 3) && vnVar.p0[1] == 3 && vnVar.J.f != null && vnVar.L.f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = gnVar.g() || gnVar3.g();
        boolean z4 = gnVar2.g() || gnVar4.g();
        int i7 = !(!z2 && (((i = this.s0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i8 = 0;
        while (i8 < this.r0) {
            vn vnVar2 = this.q0[i8];
            if (this.t0 || vnVar2.c()) {
                m11 m11VarK = rg0Var.k(vnVar2.Q[this.s0]);
                gn[] gnVarArr2 = vnVar2.Q;
                int i9 = this.s0;
                gn gnVar7 = gnVarArr2[i9];
                gnVar7.i = m11VarK;
                gn gnVar8 = gnVar7.f;
                int i10 = (gnVar8 == null || gnVar8.d != this) ? 0 : gnVar7.g;
                if (i9 == 0 || i9 == i3) {
                    m11 m11Var = gnVar6.i;
                    int i11 = this.u0 - i10;
                    lb lbVarL = rg0Var.l();
                    m11 m11VarM = rg0Var.m();
                    m11VarM.e = 0;
                    lbVarL.c(m11Var, m11VarK, m11VarM, i11);
                    rg0Var.c(lbVarL);
                } else {
                    m11 m11Var2 = gnVar6.i;
                    int i12 = this.u0 + i10;
                    lb lbVarL2 = rg0Var.l();
                    m11 m11VarM2 = rg0Var.m();
                    m11VarM2.e = 0;
                    lbVarL2.b(m11Var2, m11VarK, m11VarM2, i12);
                    rg0Var.c(lbVarL2);
                }
                rg0Var.e(gnVar6.i, m11VarK, this.u0 + i10, i7);
            }
            i8++;
            i3 = 2;
        }
        int i13 = this.s0;
        if (i13 == 0) {
            rg0Var.e(gnVar3.i, gnVar.i, 0, 8);
            rg0Var.e(gnVar.i, this.T.K.i, 0, 4);
            rg0Var.e(gnVar.i, this.T.I.i, 0, 0);
            return;
        }
        if (i13 == 1) {
            rg0Var.e(gnVar.i, gnVar3.i, 0, 8);
            rg0Var.e(gnVar.i, this.T.I.i, 0, 4);
            rg0Var.e(gnVar.i, this.T.K.i, 0, 0);
        } else if (i13 == 2) {
            rg0Var.e(gnVar4.i, gnVar2.i, 0, 8);
            rg0Var.e(gnVar2.i, this.T.L.i, 0, 4);
            rg0Var.e(gnVar2.i, this.T.J.i, 0, 0);
        } else if (i13 == 3) {
            rg0Var.e(gnVar2.i, gnVar4.i, 0, 8);
            rg0Var.e(gnVar2.i, this.T.J.i, 0, 4);
            rg0Var.e(gnVar2.i, this.T.L.i, 0, 0);
        }
    }

    @Override // defpackage.vn
    public final boolean c() {
        return true;
    }

    @Override // defpackage.vn
    public final String toString() {
        String strK = l11.k(new StringBuilder("[Barrier] "), this.h0, " {");
        for (int i = 0; i < this.r0; i++) {
            vn vnVar = this.q0[i];
            if (i > 0) {
                strK = strK.concat(", ");
            }
            StringBuilder sbL = l11.l(strK);
            sbL.append(vnVar.h0);
            strK = sbL.toString();
        }
        return strK.concat("}");
    }
}
