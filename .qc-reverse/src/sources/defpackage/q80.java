package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q80 extends oh1 {
    public static final int[] k = new int[2];

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // defpackage.et
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.et r24) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q80.a(et):void");
    }

    @Override // defpackage.oh1
    public final void d() {
        vn vnVar;
        vn vnVar2;
        int i;
        vn vnVar3;
        vn vnVar4;
        int i2;
        vn vnVar5 = this.b;
        boolean z = vnVar5.a;
        cu cuVar = this.e;
        if (z) {
            cuVar.d(vnVar5.q());
        }
        boolean z2 = cuVar.j;
        ArrayList arrayList = cuVar.k;
        ArrayList arrayList2 = cuVar.l;
        gt gtVar = this.i;
        gt gtVar2 = this.h;
        if (!z2) {
            vn vnVar6 = this.b;
            int i3 = vnVar6.p0[0];
            this.d = i3;
            if (i3 != 3) {
                if (i3 == 4 && (vnVar4 = vnVar6.T) != null && ((i2 = vnVar4.p0[0]) == 1 || i2 == 4)) {
                    int iQ = (vnVar4.q() - this.b.I.e()) - this.b.K.e();
                    oh1.b(gtVar2, vnVar4.d.h, this.b.I.e());
                    oh1.b(gtVar, vnVar4.d.i, -this.b.K.e());
                    cuVar.d(iQ);
                    return;
                }
                if (i3 == 1) {
                    cuVar.d(vnVar6.q());
                }
            }
        } else if (this.d == 4 && (vnVar2 = (vnVar = this.b).T) != null && ((i = vnVar2.p0[0]) == 1 || i == 4)) {
            oh1.b(gtVar2, vnVar2.d.h, vnVar.I.e());
            oh1.b(gtVar, vnVar2.d.i, -this.b.K.e());
            return;
        }
        if (cuVar.j) {
            vn vnVar7 = this.b;
            if (vnVar7.a) {
                gn[] gnVarArr = vnVar7.Q;
                gn gnVar = gnVarArr[0];
                gn gnVar2 = gnVar.f;
                if (gnVar2 != null && gnVarArr[1].f != null) {
                    boolean zX = vnVar7.x();
                    vn vnVar8 = this.b;
                    if (zX) {
                        gtVar2.f = vnVar8.Q[0].e();
                        gtVar.f = -this.b.Q[1].e();
                        return;
                    }
                    gt gtVarH = oh1.h(vnVar8.Q[0]);
                    if (gtVarH != null) {
                        oh1.b(gtVar2, gtVarH, this.b.Q[0].e());
                    }
                    gt gtVarH2 = oh1.h(this.b.Q[1]);
                    if (gtVarH2 != null) {
                        oh1.b(gtVar, gtVarH2, -this.b.Q[1].e());
                    }
                    gtVar2.b = true;
                    gtVar.b = true;
                    return;
                }
                if (gnVar2 != null) {
                    gt gtVarH3 = oh1.h(gnVar);
                    if (gtVarH3 != null) {
                        oh1.b(gtVar2, gtVarH3, this.b.Q[0].e());
                        oh1.b(gtVar, gtVar2, cuVar.g);
                        return;
                    }
                    return;
                }
                gn gnVar3 = gnVarArr[1];
                if (gnVar3.f != null) {
                    gt gtVarH4 = oh1.h(gnVar3);
                    if (gtVarH4 != null) {
                        oh1.b(gtVar, gtVarH4, -this.b.Q[1].e());
                        oh1.b(gtVar2, gtVar, -cuVar.g);
                        return;
                    }
                    return;
                }
                if ((vnVar7 instanceof b80) || vnVar7.T == null || vnVar7.i(7).f != null) {
                    return;
                }
                vn vnVar9 = this.b;
                oh1.b(gtVar2, vnVar9.T.d.h, vnVar9.r());
                oh1.b(gtVar, gtVar2, cuVar.g);
                return;
            }
        }
        if (this.d == 3) {
            vn vnVar10 = this.b;
            int i4 = vnVar10.r;
            if (i4 == 2) {
                vn vnVar11 = vnVar10.T;
                if (vnVar11 != null) {
                    cu cuVar2 = vnVar11.e.e;
                    arrayList2.add(cuVar2);
                    cuVar2.k.add(cuVar);
                    cuVar.b = true;
                    arrayList.add(gtVar2);
                    arrayList.add(gtVar);
                }
            } else if (i4 == 3) {
                if (vnVar10.s == 3) {
                    gtVar2.a = this;
                    gtVar.a = this;
                    cf1 cf1Var = vnVar10.e;
                    cf1Var.h.a = this;
                    cf1Var.i.a = this;
                    cuVar.a = this;
                    if (vnVar10.y()) {
                        arrayList2.add(this.b.e.e);
                        this.b.e.e.k.add(cuVar);
                        cf1 cf1Var2 = this.b.e;
                        cf1Var2.e.a = this;
                        arrayList2.add(cf1Var2.h);
                        arrayList2.add(this.b.e.i);
                        this.b.e.h.k.add(cuVar);
                        this.b.e.i.k.add(cuVar);
                    } else {
                        boolean zX2 = this.b.x();
                        vn vnVar12 = this.b;
                        if (zX2) {
                            vnVar12.e.e.l.add(cuVar);
                            arrayList.add(this.b.e.e);
                        } else {
                            vnVar12.e.e.l.add(cuVar);
                        }
                    }
                } else {
                    cu cuVar3 = vnVar10.e.e;
                    arrayList2.add(cuVar3);
                    cuVar3.k.add(cuVar);
                    this.b.e.h.k.add(cuVar);
                    this.b.e.i.k.add(cuVar);
                    cuVar.b = true;
                    arrayList.add(gtVar2);
                    arrayList.add(gtVar);
                    gtVar2.l.add(cuVar);
                    gtVar.l.add(cuVar);
                }
            }
        }
        vn vnVar13 = this.b;
        gn[] gnVarArr2 = vnVar13.Q;
        gn gnVar4 = gnVarArr2[0];
        gn gnVar5 = gnVar4.f;
        if (gnVar5 != null && gnVarArr2[1].f != null) {
            boolean zX3 = vnVar13.x();
            vn vnVar14 = this.b;
            if (zX3) {
                gtVar2.f = vnVar14.Q[0].e();
                gtVar.f = -this.b.Q[1].e();
                return;
            }
            gt gtVarH5 = oh1.h(vnVar14.Q[0]);
            gt gtVarH6 = oh1.h(this.b.Q[1]);
            if (gtVarH5 != null) {
                gtVarH5.b(this);
            }
            if (gtVarH6 != null) {
                gtVarH6.b(this);
            }
            this.j = 4;
            return;
        }
        if (gnVar5 != null) {
            gt gtVarH7 = oh1.h(gnVar4);
            if (gtVarH7 != null) {
                oh1.b(gtVar2, gtVarH7, this.b.Q[0].e());
                c(gtVar, gtVar2, 1, cuVar);
                return;
            }
            return;
        }
        gn gnVar6 = gnVarArr2[1];
        if (gnVar6.f != null) {
            gt gtVarH8 = oh1.h(gnVar6);
            if (gtVarH8 != null) {
                oh1.b(gtVar, gtVarH8, -this.b.Q[1].e());
                c(gtVar2, gtVar, -1, cuVar);
                return;
            }
            return;
        }
        if ((vnVar13 instanceof b80) || (vnVar3 = vnVar13.T) == null) {
            return;
        }
        oh1.b(gtVar2, vnVar3.d.h, vnVar13.r());
        c(gtVar, gtVar2, 1, cuVar);
    }

    @Override // defpackage.oh1
    public final void e() {
        gt gtVar = this.h;
        if (gtVar.j) {
            this.b.Y = gtVar.g;
        }
    }

    @Override // defpackage.oh1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.oh1
    public final boolean k() {
        return this.d != 3 || this.b.r == 0;
    }

    public final void n() {
        this.g = false;
        gt gtVar = this.h;
        gtVar.c();
        gtVar.j = false;
        gt gtVar2 = this.i;
        gtVar2.c();
        gtVar2.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.b.h0;
    }
}
