package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class h20 extends b80 {
    public int A0;
    public se B0;
    public ln C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public float N0;
    public float O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public ArrayList W0;
    public vn[] X0;
    public vn[] Y0;
    public int[] Z0;
    public vn[] a1;
    public int b1;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public int x0;
    public boolean y0;
    public int z0;

    @Override // defpackage.b80
    public final void S() {
        for (int i = 0; i < this.r0; i++) {
            vn vnVar = this.q0[i];
            if (vnVar != null) {
                vnVar.F = true;
            }
        }
    }

    public final int T(vn vnVar, int i) {
        vn vnVar2;
        if (vnVar != null) {
            int[] iArr = vnVar.p0;
            if (iArr[1] == 3) {
                int i2 = vnVar.s;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (vnVar.z * i);
                        if (i3 != vnVar.k()) {
                            vnVar.g = true;
                            V(iArr[0], vnVar.q(), 1, i3, vnVar);
                        }
                        return i3;
                    }
                    vnVar2 = vnVar;
                    if (i2 == 1) {
                        return vnVar2.k();
                    }
                    if (i2 == 3) {
                        return (int) ((vnVar2.q() * vnVar2.W) + 0.5f);
                    }
                }
            } else {
                vnVar2 = vnVar;
            }
            return vnVar2.k();
        }
        return 0;
    }

    public final int U(vn vnVar, int i) {
        vn vnVar2;
        if (vnVar != null) {
            int[] iArr = vnVar.p0;
            if (iArr[0] == 3) {
                int i2 = vnVar.r;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (vnVar.w * i);
                        if (i3 != vnVar.q()) {
                            vnVar.g = true;
                            V(1, i3, iArr[1], vnVar.k(), vnVar);
                        }
                        return i3;
                    }
                    vnVar2 = vnVar;
                    if (i2 == 1) {
                        return vnVar2.q();
                    }
                    if (i2 == 3) {
                        return (int) ((vnVar2.k() * vnVar2.W) + 0.5f);
                    }
                }
            } else {
                vnVar2 = vnVar;
            }
            return vnVar2.q();
        }
        return 0;
    }

    public final void V(int i, int i2, int i3, int i4, vn vnVar) {
        ln lnVar;
        vn vnVar2;
        se seVar = this.B0;
        while (true) {
            lnVar = this.C0;
            if (lnVar != null || (vnVar2 = this.T) == null) {
                break;
            } else {
                this.C0 = ((wn) vnVar2).u0;
            }
        }
        seVar.a = i;
        seVar.b = i3;
        seVar.c = i2;
        seVar.d = i4;
        lnVar.b(vnVar, seVar);
        vnVar.O(seVar.e);
        vnVar.L(seVar.f);
        vnVar.E = seVar.h;
        vnVar.I(seVar.g);
    }

    @Override // defpackage.vn
    public final void b(rg0 rg0Var, boolean z) {
        vn vnVar;
        float f;
        int i;
        ArrayList arrayList = this.W0;
        super.b(rg0Var, z);
        vn vnVar2 = this.T;
        boolean z2 = vnVar2 != null && ((wn) vnVar2).v0;
        int i2 = this.T0;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    ((g20) arrayList.get(i3)).b(i3, z2, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        ((g20) arrayList.get(i4)).b(i4, z2, i4 == size2 + (-1));
                        i4++;
                    }
                }
            } else if (this.Z0 != null && this.Y0 != null && this.X0 != null) {
                for (int i5 = 0; i5 < this.b1; i5++) {
                    this.a1[i5].D();
                }
                int[] iArr = this.Z0;
                int i6 = iArr[0];
                int i7 = iArr[1];
                float f2 = this.J0;
                vn vnVar3 = null;
                int i8 = 0;
                while (i8 < i6) {
                    if (z2) {
                        i = (i6 - i8) - 1;
                        f = 1.0f - this.J0;
                    } else {
                        f = f2;
                        i = i8;
                    }
                    vn vnVar4 = this.Y0[i];
                    if (vnVar4 != null) {
                        gn gnVar = vnVar4.I;
                        if (vnVar4.g0 != 8) {
                            if (i8 == 0) {
                                vnVar4.f(gnVar, this.I, this.w0);
                                vnVar4.i0 = this.D0;
                                vnVar4.d0 = f;
                            }
                            if (i8 == i6 - 1) {
                                vnVar4.f(vnVar4.K, this.K, this.x0);
                            }
                            if (i8 > 0 && vnVar3 != null) {
                                gn gnVar2 = vnVar3.K;
                                vnVar4.f(gnVar, gnVar2, this.P0);
                                vnVar3.f(gnVar2, gnVar, 0);
                            }
                            vnVar3 = vnVar4;
                        }
                    }
                    i8++;
                    f2 = f;
                }
                for (int i9 = 0; i9 < i7; i9++) {
                    vn vnVar5 = this.X0[i9];
                    if (vnVar5 != null) {
                        gn gnVar3 = vnVar5.J;
                        if (vnVar5.g0 != 8) {
                            if (i9 == 0) {
                                vnVar5.f(gnVar3, this.J, this.s0);
                                vnVar5.j0 = this.E0;
                                vnVar5.e0 = this.K0;
                            }
                            if (i9 == i7 - 1) {
                                vnVar5.f(vnVar5.L, this.L, this.t0);
                            }
                            if (i9 > 0 && vnVar3 != null) {
                                gn gnVar4 = vnVar3.L;
                                vnVar5.f(gnVar3, gnVar4, this.Q0);
                                vnVar3.f(gnVar4, gnVar3, 0);
                            }
                            vnVar3 = vnVar5;
                        }
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    for (int i11 = 0; i11 < i7; i11++) {
                        int i12 = (i11 * i6) + i10;
                        if (this.V0 == 1) {
                            i12 = (i10 * i7) + i11;
                        }
                        vn[] vnVarArr = this.a1;
                        if (i12 < vnVarArr.length && (vnVar = vnVarArr[i12]) != null && vnVar.g0 != 8) {
                            vn vnVar6 = this.Y0[i10];
                            vn vnVar7 = this.X0[i11];
                            if (vnVar != vnVar6) {
                                vnVar.f(vnVar.I, vnVar6.I, 0);
                                vnVar.f(vnVar.K, vnVar6.K, 0);
                            }
                            if (vnVar != vnVar7) {
                                vnVar.f(vnVar.J, vnVar7.J, 0);
                                vnVar.f(vnVar.L, vnVar7.L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((g20) arrayList.get(0)).b(0, z2, true);
        }
        this.y0 = false;
    }
}
