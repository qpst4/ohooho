package defpackage;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ft {
    public wn a;
    public boolean b;
    public boolean c;
    public wn d;
    public ArrayList e;
    public ln f;
    public se g;
    public ArrayList h;

    public final void a(gt gtVar, int i, ArrayList arrayList, yw0 yw0Var) {
        oh1 oh1Var = gtVar.d;
        yw0 yw0Var2 = oh1Var.c;
        gt gtVar2 = oh1Var.i;
        gt gtVar3 = oh1Var.h;
        if (yw0Var2 == null) {
            wn wnVar = this.a;
            if (oh1Var == wnVar.d || oh1Var == wnVar.e) {
                return;
            }
            if (yw0Var == null) {
                yw0Var = new yw0();
                yw0Var.a = null;
                yw0Var.b = new ArrayList();
                yw0Var.a = oh1Var;
                arrayList.add(yw0Var);
            }
            oh1Var.c = yw0Var;
            yw0Var.b.add(oh1Var);
            ArrayList arrayList2 = gtVar3.k;
            int size = arrayList2.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                et etVar = (et) obj;
                if (etVar instanceof gt) {
                    a((gt) etVar, i, arrayList, yw0Var);
                }
            }
            ArrayList arrayList3 = gtVar2.k;
            int size2 = arrayList3.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList3.get(i4);
                i4++;
                et etVar2 = (et) obj2;
                if (etVar2 instanceof gt) {
                    a((gt) etVar2, i, arrayList, yw0Var);
                }
            }
            if (i == 1 && (oh1Var instanceof cf1)) {
                ArrayList arrayList4 = ((cf1) oh1Var).k.k;
                int size3 = arrayList4.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj3 = arrayList4.get(i5);
                    i5++;
                    et etVar3 = (et) obj3;
                    if (etVar3 instanceof gt) {
                        a((gt) etVar3, i, arrayList, yw0Var);
                    }
                }
            }
            ArrayList arrayList5 = gtVar3.l;
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList5.get(i6);
                i6++;
                a((gt) obj4, i, arrayList, yw0Var);
            }
            ArrayList arrayList6 = gtVar2.l;
            int size5 = arrayList6.size();
            int i7 = 0;
            while (i7 < size5) {
                Object obj5 = arrayList6.get(i7);
                i7++;
                a((gt) obj5, i, arrayList, yw0Var);
            }
            if (i == 1 && (oh1Var instanceof cf1)) {
                ArrayList arrayList7 = ((cf1) oh1Var).k.l;
                int size6 = arrayList7.size();
                while (i2 < size6) {
                    Object obj6 = arrayList7.get(i2);
                    i2++;
                    a((gt) obj6, i, arrayList, yw0Var);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.wn r25) {
        /*
            Method dump skipped, instruction units count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ft.b(wn):void");
    }

    public final void c() {
        wn wnVar = this.a;
        ArrayList arrayList = this.h;
        ArrayList arrayList2 = this.e;
        arrayList2.clear();
        wn wnVar2 = this.d;
        wnVar2.d.f();
        wnVar2.e.f();
        arrayList2.add(wnVar2.d);
        arrayList2.add(wnVar2.e);
        ArrayList arrayList3 = wnVar2.q0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            vn vnVar = (vn) obj;
            if (vnVar instanceof n70) {
                o70 o70Var = new o70(vnVar);
                vnVar.d.f();
                vnVar.e.f();
                o70Var.f = ((n70) vnVar).u0;
                arrayList2.add(o70Var);
            } else {
                if (vnVar.x()) {
                    if (vnVar.b == null) {
                        vnVar.b = new dj(vnVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(vnVar.b);
                } else {
                    arrayList2.add(vnVar.d);
                }
                if (vnVar.y()) {
                    if (vnVar.c == null) {
                        vnVar.c = new dj(vnVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(vnVar.c);
                } else {
                    arrayList2.add(vnVar.e);
                }
                if (vnVar instanceof b80) {
                    arrayList2.add(new a80(vnVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            ((oh1) obj2).f();
        }
        int size3 = arrayList2.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            oh1 oh1Var = (oh1) obj3;
            if (oh1Var.b != wnVar2) {
                oh1Var.d();
            }
        }
        arrayList.clear();
        e(wnVar.d, 0, arrayList);
        e(wnVar.e, 1, arrayList);
        this.b = false;
    }

    public final int d(wn wnVar, int i) {
        ArrayList arrayList;
        int i2;
        long jMax;
        float f;
        wn wnVar2 = wnVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        long j = 0;
        int i3 = 0;
        long jMax2 = 0;
        while (i3 < size) {
            oh1 oh1Var = ((yw0) arrayList2.get(i3)).a;
            if (!(oh1Var instanceof dj) ? !(i != 0 ? (oh1Var instanceof cf1) : (oh1Var instanceof q80)) : ((dj) oh1Var).f != i) {
                gt gtVar = (i == 0 ? wnVar2.d : wnVar2.e).h;
                gt gtVar2 = (i == 0 ? wnVar2.d : wnVar2.e).i;
                gt gtVar3 = oh1Var.h;
                gt gtVar4 = oh1Var.i;
                boolean zContains = gtVar3.l.contains(gtVar);
                boolean zContains2 = gtVar4.l.contains(gtVar2);
                long j2 = oh1Var.j();
                if (zContains && zContains2) {
                    long jB = yw0.b(gtVar3, j);
                    arrayList = arrayList2;
                    long jA = yw0.a(gtVar4, j);
                    long j3 = jB - j2;
                    int i4 = gtVar4.f;
                    i2 = i3;
                    if (j3 >= (-i4)) {
                        j3 += (long) i4;
                    }
                    long j4 = gtVar3.f;
                    long j5 = ((-jA) - j2) - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    vn vnVar = oh1Var.b;
                    if (i == 0) {
                        f = vnVar.d0;
                    } else if (i == 1) {
                        f = vnVar.e0;
                    } else {
                        vnVar.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j3 / (1.0f - f)) + (j5 / f)) : 0L;
                    jMax = (((long) gtVar3.f) + ((((long) ((f2 * f) + 0.5f)) + j2) + ((long) (((1.0f - f) * f2) + 0.5f)))) - ((long) gtVar4.f);
                } else {
                    arrayList = arrayList2;
                    i2 = i3;
                    jMax = zContains ? Math.max(yw0.b(gtVar3, gtVar3.f), ((long) gtVar3.f) + j2) : zContains2 ? Math.max(-yw0.a(gtVar4, gtVar4.f), ((long) (-gtVar4.f)) + j2) : (oh1Var.j() + ((long) gtVar3.f)) - ((long) gtVar4.f);
                }
            } else {
                arrayList = arrayList2;
                jMax = j;
                i2 = i3;
            }
            jMax2 = Math.max(jMax2, jMax);
            i3 = i2 + 1;
            arrayList2 = arrayList;
            wnVar2 = wnVar;
            j = 0;
        }
        return (int) jMax2;
    }

    public final void e(oh1 oh1Var, int i, ArrayList arrayList) {
        gt gtVar = oh1Var.h;
        gt gtVar2 = oh1Var.i;
        ArrayList arrayList2 = gtVar.k;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            et etVar = (et) obj;
            if (etVar instanceof gt) {
                a((gt) etVar, i, arrayList, null);
            } else if (etVar instanceof oh1) {
                a(((oh1) etVar).h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = gtVar2.k;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            et etVar2 = (et) obj2;
            if (etVar2 instanceof gt) {
                a((gt) etVar2, i, arrayList, null);
            } else if (etVar2 instanceof oh1) {
                a(((oh1) etVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((cf1) oh1Var).k.k;
            int size3 = arrayList4.size();
            while (i2 < size3) {
                Object obj3 = arrayList4.get(i2);
                i2++;
                et etVar3 = (et) obj3;
                if (etVar3 instanceof gt) {
                    a((gt) etVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void f(int i, int i2, int i3, int i4, vn vnVar) {
        se seVar = this.g;
        seVar.a = i;
        seVar.b = i3;
        seVar.c = i2;
        seVar.d = i4;
        this.f.b(vnVar, seVar);
        vnVar.O(seVar.e);
        vnVar.L(seVar.f);
        vnVar.E = seVar.h;
        vnVar.I(seVar.g);
    }

    public final void g() {
        qe qeVar;
        ft ftVar = this;
        ArrayList arrayList = ftVar.a.q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            vn vnVar = (vn) arrayList.get(i);
            if (!vnVar.a) {
                int[] iArr = vnVar.p0;
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = vnVar.r;
                int i6 = vnVar.s;
                boolean z = i3 == 2 || (i3 == 3 && i5 == 1);
                boolean z2 = i4 == 2 || (i4 == 3 && i6 == 1);
                cu cuVar = vnVar.d.e;
                boolean z3 = cuVar.j;
                cu cuVar2 = vnVar.e.e;
                boolean z4 = cuVar2.j;
                boolean z5 = z;
                if (z3 && z4) {
                    ftVar.f(1, cuVar.g, 1, cuVar2.g, vnVar);
                    vnVar.a = true;
                } else if (z3 && z2) {
                    f(1, cuVar.g, 2, cuVar2.g, vnVar);
                    cf1 cf1Var = vnVar.e;
                    if (i4 == 3) {
                        cf1Var.e.m = vnVar.k();
                    } else {
                        cf1Var.e.d(vnVar.k());
                        vnVar.a = true;
                    }
                } else if (z4 && z5) {
                    f(2, cuVar.g, 1, cuVar2.g, vnVar);
                    q80 q80Var = vnVar.d;
                    if (i3 == 3) {
                        q80Var.e.m = vnVar.q();
                    } else {
                        q80Var.e.d(vnVar.q());
                        vnVar.a = true;
                    }
                }
                if (vnVar.a && (qeVar = vnVar.e.l) != null) {
                    qeVar.d(vnVar.a0);
                }
                ftVar = this;
            }
            i = i2;
        }
    }
}
