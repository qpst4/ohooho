package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cf1 extends oh1 {
    public gt k;
    public qe l;

    @Override // defpackage.et
    public final void a(et etVar) {
        float f;
        float f2;
        float f3;
        int i;
        if (l11.r(this.j) == 3) {
            vn vnVar = this.b;
            l(vnVar.J, vnVar.L, 1);
            return;
        }
        cu cuVar = this.e;
        if (cuVar.c && !cuVar.j && this.d == 3) {
            vn vnVar2 = this.b;
            int i2 = vnVar2.s;
            if (i2 == 2) {
                vn vnVar3 = vnVar2.T;
                if (vnVar3 != null) {
                    if (vnVar3.e.e.j) {
                        cuVar.d((int) ((r5.g * vnVar2.z) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                cu cuVar2 = vnVar2.d.e;
                if (cuVar2.j) {
                    int i3 = vnVar2.X;
                    if (i3 == -1) {
                        f = cuVar2.g;
                        f2 = vnVar2.W;
                    } else if (i3 == 0) {
                        f3 = cuVar2.g * vnVar2.W;
                        i = (int) (f3 + 0.5f);
                        cuVar.d(i);
                    } else if (i3 != 1) {
                        i = 0;
                        cuVar.d(i);
                    } else {
                        f = cuVar2.g;
                        f2 = vnVar2.W;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    cuVar.d(i);
                }
            }
        }
        gt gtVar = this.h;
        boolean z = gtVar.c;
        ArrayList arrayList = gtVar.l;
        if (z) {
            gt gtVar2 = this.i;
            boolean z2 = gtVar2.c;
            ArrayList arrayList2 = gtVar2.l;
            if (z2) {
                if (gtVar.j && gtVar2.j && cuVar.j) {
                    return;
                }
                if (!cuVar.j && this.d == 3) {
                    vn vnVar4 = this.b;
                    if (vnVar4.r == 0 && !vnVar4.y()) {
                        gt gtVar3 = (gt) arrayList.get(0);
                        gt gtVar4 = (gt) arrayList2.get(0);
                        int i4 = gtVar3.g + gtVar.f;
                        int i5 = gtVar4.g + gtVar2.f;
                        gtVar.d(i4);
                        gtVar2.d(i5);
                        cuVar.d(i5 - i4);
                        return;
                    }
                }
                if (!cuVar.j && this.d == 3 && this.a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    gt gtVar5 = (gt) arrayList.get(0);
                    int i6 = (((gt) arrayList2.get(0)).g + gtVar2.f) - (gtVar5.g + gtVar.f);
                    int i7 = cuVar.m;
                    if (i6 < i7) {
                        cuVar.d(i6);
                    } else {
                        cuVar.d(i7);
                    }
                }
                if (cuVar.j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    gt gtVar6 = (gt) arrayList.get(0);
                    gt gtVar7 = (gt) arrayList2.get(0);
                    int i8 = gtVar6.g;
                    int i9 = gtVar.f + i8;
                    int i10 = gtVar7.g;
                    int i11 = gtVar2.f + i10;
                    float f4 = this.b.e0;
                    if (gtVar6 == gtVar7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    gtVar.d((int) ((((i10 - i8) - cuVar.g) * f4) + i8 + 0.5f));
                    gtVar2.d(gtVar.g + cuVar.g);
                }
            }
        }
    }

    @Override // defpackage.oh1
    public final void d() {
        vn vnVar;
        vn vnVar2;
        vn vnVar3;
        vn vnVar4;
        gt gtVar = this.k;
        vn vnVar5 = this.b;
        boolean z = vnVar5.a;
        cu cuVar = this.e;
        if (z) {
            cuVar.d(vnVar5.k());
        }
        boolean z2 = cuVar.j;
        ArrayList arrayList = cuVar.k;
        ArrayList arrayList2 = cuVar.l;
        gt gtVar2 = this.i;
        gt gtVar3 = this.h;
        if (!z2) {
            vn vnVar6 = this.b;
            this.d = vnVar6.p0[1];
            if (vnVar6.E) {
                this.l = new qe(this);
            }
            int i = this.d;
            if (i != 3) {
                if (i == 4 && (vnVar4 = this.b.T) != null && vnVar4.p0[1] == 1) {
                    int iK = (vnVar4.k() - this.b.J.e()) - this.b.L.e();
                    oh1.b(gtVar3, vnVar4.e.h, this.b.J.e());
                    oh1.b(gtVar2, vnVar4.e.i, -this.b.L.e());
                    cuVar.d(iK);
                    return;
                }
                if (i == 1) {
                    cuVar.d(this.b.k());
                }
            }
        } else if (this.d == 4 && (vnVar2 = (vnVar = this.b).T) != null && vnVar2.p0[1] == 1) {
            oh1.b(gtVar3, vnVar2.e.h, vnVar.J.e());
            oh1.b(gtVar2, vnVar2.e.i, -this.b.L.e());
            return;
        }
        boolean z3 = cuVar.j;
        if (z3) {
            vn vnVar7 = this.b;
            if (vnVar7.a) {
                gn[] gnVarArr = vnVar7.Q;
                gn gnVar = gnVarArr[2];
                gn gnVar2 = gnVar.f;
                if (gnVar2 != null && gnVarArr[3].f != null) {
                    boolean zY = vnVar7.y();
                    vn vnVar8 = this.b;
                    if (zY) {
                        gtVar3.f = vnVar8.Q[2].e();
                        gtVar2.f = -this.b.Q[3].e();
                    } else {
                        gt gtVarH = oh1.h(vnVar8.Q[2]);
                        if (gtVarH != null) {
                            oh1.b(gtVar3, gtVarH, this.b.Q[2].e());
                        }
                        gt gtVarH2 = oh1.h(this.b.Q[3]);
                        if (gtVarH2 != null) {
                            oh1.b(gtVar2, gtVarH2, -this.b.Q[3].e());
                        }
                        gtVar3.b = true;
                        gtVar2.b = true;
                    }
                    vn vnVar9 = this.b;
                    if (vnVar9.E) {
                        oh1.b(gtVar, gtVar3, vnVar9.a0);
                        return;
                    }
                    return;
                }
                if (gnVar2 != null) {
                    gt gtVarH3 = oh1.h(gnVar);
                    if (gtVarH3 != null) {
                        oh1.b(gtVar3, gtVarH3, this.b.Q[2].e());
                        oh1.b(gtVar2, gtVar3, cuVar.g);
                        vn vnVar10 = this.b;
                        if (vnVar10.E) {
                            oh1.b(gtVar, gtVar3, vnVar10.a0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                gn gnVar3 = gnVarArr[3];
                if (gnVar3.f != null) {
                    gt gtVarH4 = oh1.h(gnVar3);
                    if (gtVarH4 != null) {
                        oh1.b(gtVar2, gtVarH4, -this.b.Q[3].e());
                        oh1.b(gtVar3, gtVar2, -cuVar.g);
                    }
                    vn vnVar11 = this.b;
                    if (vnVar11.E) {
                        oh1.b(gtVar, gtVar3, vnVar11.a0);
                        return;
                    }
                    return;
                }
                gn gnVar4 = gnVarArr[4];
                if (gnVar4.f != null) {
                    gt gtVarH5 = oh1.h(gnVar4);
                    if (gtVarH5 != null) {
                        oh1.b(gtVar, gtVarH5, 0);
                        oh1.b(gtVar3, gtVar, -this.b.a0);
                        oh1.b(gtVar2, gtVar3, cuVar.g);
                        return;
                    }
                    return;
                }
                if ((vnVar7 instanceof b80) || vnVar7.T == null || vnVar7.i(7).f != null) {
                    return;
                }
                vn vnVar12 = this.b;
                oh1.b(gtVar3, vnVar12.T.e.h, vnVar12.s());
                oh1.b(gtVar2, gtVar3, cuVar.g);
                vn vnVar13 = this.b;
                if (vnVar13.E) {
                    oh1.b(gtVar, gtVar3, vnVar13.a0);
                    return;
                }
                return;
            }
        }
        if (z3 || this.d != 3) {
            cuVar.b(this);
        } else {
            vn vnVar14 = this.b;
            int i2 = vnVar14.s;
            if (i2 == 2) {
                vn vnVar15 = vnVar14.T;
                if (vnVar15 != null) {
                    cu cuVar2 = vnVar15.e.e;
                    arrayList2.add(cuVar2);
                    cuVar2.k.add(cuVar);
                    cuVar.b = true;
                    arrayList.add(gtVar3);
                    arrayList.add(gtVar2);
                }
            } else if (i2 == 3 && !vnVar14.y()) {
                vn vnVar16 = this.b;
                if (vnVar16.r != 3) {
                    cu cuVar3 = vnVar16.d.e;
                    arrayList2.add(cuVar3);
                    cuVar3.k.add(cuVar);
                    cuVar.b = true;
                    arrayList.add(gtVar3);
                    arrayList.add(gtVar2);
                }
            }
        }
        vn vnVar17 = this.b;
        gn[] gnVarArr2 = vnVar17.Q;
        gn gnVar5 = gnVarArr2[2];
        gn gnVar6 = gnVar5.f;
        if (gnVar6 != null && gnVarArr2[3].f != null) {
            boolean zY2 = vnVar17.y();
            vn vnVar18 = this.b;
            if (zY2) {
                gtVar3.f = vnVar18.Q[2].e();
                gtVar2.f = -this.b.Q[3].e();
            } else {
                gt gtVarH6 = oh1.h(vnVar18.Q[2]);
                gt gtVarH7 = oh1.h(this.b.Q[3]);
                if (gtVarH6 != null) {
                    gtVarH6.b(this);
                }
                if (gtVarH7 != null) {
                    gtVarH7.b(this);
                }
                this.j = 4;
            }
            if (this.b.E) {
                c(gtVar, gtVar3, 1, this.l);
            }
        } else if (gnVar6 != null) {
            gt gtVarH8 = oh1.h(gnVar5);
            if (gtVarH8 != null) {
                oh1.b(gtVar3, gtVarH8, this.b.Q[2].e());
                c(gtVar2, gtVar3, 1, cuVar);
                if (this.b.E) {
                    c(gtVar, gtVar3, 1, this.l);
                }
                if (this.d == 3) {
                    vn vnVar19 = this.b;
                    if (vnVar19.W > 0.0f) {
                        q80 q80Var = vnVar19.d;
                        if (q80Var.d == 3) {
                            q80Var.e.k.add(cuVar);
                            arrayList2.add(this.b.d.e);
                            cuVar.a = this;
                        }
                    }
                }
            }
        } else {
            gn gnVar7 = gnVarArr2[3];
            if (gnVar7.f != null) {
                gt gtVarH9 = oh1.h(gnVar7);
                if (gtVarH9 != null) {
                    oh1.b(gtVar2, gtVarH9, -this.b.Q[3].e());
                    c(gtVar3, gtVar2, -1, cuVar);
                    if (this.b.E) {
                        c(gtVar, gtVar3, 1, this.l);
                    }
                }
            } else {
                gn gnVar8 = gnVarArr2[4];
                if (gnVar8.f != null) {
                    gt gtVarH10 = oh1.h(gnVar8);
                    if (gtVarH10 != null) {
                        oh1.b(gtVar, gtVarH10, 0);
                        c(gtVar3, gtVar, -1, this.l);
                        c(gtVar2, gtVar3, 1, cuVar);
                    }
                } else if (!(vnVar17 instanceof b80) && (vnVar3 = vnVar17.T) != null) {
                    oh1.b(gtVar3, vnVar3.e.h, vnVar17.s());
                    c(gtVar2, gtVar3, 1, cuVar);
                    if (this.b.E) {
                        c(gtVar, gtVar3, 1, this.l);
                    }
                    if (this.d == 3) {
                        vn vnVar20 = this.b;
                        if (vnVar20.W > 0.0f) {
                            q80 q80Var2 = vnVar20.d;
                            if (q80Var2.d == 3) {
                                q80Var2.e.k.add(cuVar);
                                arrayList2.add(this.b.d.e);
                                cuVar.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            cuVar.c = true;
        }
    }

    @Override // defpackage.oh1
    public final void e() {
        gt gtVar = this.h;
        if (gtVar.j) {
            this.b.Z = gtVar.g;
        }
    }

    @Override // defpackage.oh1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.oh1
    public final boolean k() {
        return this.d != 3 || this.b.s == 0;
    }

    public final void m() {
        this.g = false;
        gt gtVar = this.h;
        gtVar.c();
        gtVar.j = false;
        gt gtVar2 = this.i;
        gtVar2.c();
        gtVar2.j = false;
        gt gtVar3 = this.k;
        gtVar3.c();
        gtVar3.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.b.h0;
    }
}
