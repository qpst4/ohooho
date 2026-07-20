package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oh1 implements et {
    public int a;
    public vn b;
    public yw0 c;
    public int d;
    public final cu e = new cu(this);
    public int f = 0;
    public boolean g = false;
    public final gt h = new gt(this);
    public final gt i = new gt(this);
    public int j = 1;

    public oh1(vn vnVar) {
        this.b = vnVar;
    }

    public static void b(gt gtVar, gt gtVar2, int i) {
        gtVar.l.add(gtVar2);
        gtVar.f = i;
        gtVar2.k.add(gtVar);
    }

    public static gt h(gn gnVar) {
        gn gnVar2 = gnVar.f;
        if (gnVar2 == null) {
            return null;
        }
        vn vnVar = gnVar2.d;
        int iR = l11.r(gnVar2.e);
        if (iR == 1) {
            return vnVar.d.h;
        }
        if (iR == 2) {
            return vnVar.e.h;
        }
        if (iR == 3) {
            return vnVar.d.i;
        }
        if (iR == 4) {
            return vnVar.e.i;
        }
        if (iR != 5) {
            return null;
        }
        return vnVar.e.k;
    }

    public static gt i(gn gnVar, int i) {
        gn gnVar2 = gnVar.f;
        if (gnVar2 == null) {
            return null;
        }
        vn vnVar = gnVar2.d;
        oh1 oh1Var = i == 0 ? vnVar.d : vnVar.e;
        int iR = l11.r(gnVar2.e);
        if (iR == 1 || iR == 2) {
            return oh1Var.h;
        }
        if (iR == 3 || iR == 4) {
            return oh1Var.i;
        }
        return null;
    }

    public final void c(gt gtVar, gt gtVar2, int i, cu cuVar) {
        gtVar.l.add(gtVar2);
        gtVar.l.add(this.e);
        gtVar.h = i;
        gtVar.i = cuVar;
        gtVar2.k.add(gtVar);
        cuVar.k.add(gtVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        vn vnVar = this.b;
        if (i2 == 0) {
            int i3 = vnVar.v;
            int iMax = Math.max(vnVar.u, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            int i4 = vnVar.y;
            int iMax2 = Math.max(vnVar.x, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.e.j) {
            return r2.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(defpackage.gn r12, defpackage.gn r13, int r14) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oh1.l(gn, gn, int):void");
    }
}
