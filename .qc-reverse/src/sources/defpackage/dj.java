package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dj extends oh1 {
    public final ArrayList k;
    public int l;

    public dj(vn vnVar, int i) {
        vn vnVar2;
        super(vnVar);
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.f = i;
        vn vnVar3 = this.b;
        vn vnVarM = vnVar3.m(i);
        while (true) {
            vnVar2 = vnVar3;
            vnVar3 = vnVarM;
            if (vnVar3 == null) {
                break;
            } else {
                vnVarM = vnVar3.m(this.f);
            }
        }
        this.b = vnVar2;
        int i2 = this.f;
        arrayList.add(i2 == 0 ? vnVar2.d : i2 == 1 ? vnVar2.e : null);
        vn vnVarL = vnVar2.l(this.f);
        while (vnVarL != null) {
            int i3 = this.f;
            arrayList.add(i3 == 0 ? vnVarL.d : i3 == 1 ? vnVarL.e : null);
            vnVarL = vnVarL.l(this.f);
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            oh1 oh1Var = (oh1) obj;
            int i5 = this.f;
            if (i5 == 0) {
                oh1Var.b.b = this;
            } else if (i5 == 1) {
                oh1Var.b.c = this;
            }
        }
        if (this.f == 0 && ((wn) this.b.T).v0 && arrayList.size() > 1) {
            this.b = ((oh1) arrayList.get(arrayList.size() - 1)).b;
        }
        int i6 = this.f;
        vn vnVar4 = this.b;
        this.l = i6 == 0 ? vnVar4.i0 : vnVar4.j0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // defpackage.et
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.et r28) {
        /*
            Method dump skipped, instruction units count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dj.a(et):void");
    }

    @Override // defpackage.oh1
    public final void d() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((oh1) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        vn vnVar = ((oh1) arrayList.get(0)).b;
        vn vnVar2 = ((oh1) arrayList.get(size2 - 1)).b;
        int i2 = this.f;
        gt gtVar = this.i;
        gt gtVar2 = this.h;
        if (i2 == 0) {
            gn gnVar = vnVar.I;
            gn gnVar2 = vnVar2.K;
            gt gtVarI = oh1.i(gnVar, 0);
            int iE = gnVar.e();
            vn vnVarM = m();
            if (vnVarM != null) {
                iE = vnVarM.I.e();
            }
            if (gtVarI != null) {
                oh1.b(gtVar2, gtVarI, iE);
            }
            gt gtVarI2 = oh1.i(gnVar2, 0);
            int iE2 = gnVar2.e();
            vn vnVarN = n();
            if (vnVarN != null) {
                iE2 = vnVarN.K.e();
            }
            if (gtVarI2 != null) {
                oh1.b(gtVar, gtVarI2, -iE2);
            }
        } else {
            gn gnVar3 = vnVar.J;
            gn gnVar4 = vnVar2.L;
            gt gtVarI3 = oh1.i(gnVar3, 1);
            int iE3 = gnVar3.e();
            vn vnVarM2 = m();
            if (vnVarM2 != null) {
                iE3 = vnVarM2.J.e();
            }
            if (gtVarI3 != null) {
                oh1.b(gtVar2, gtVarI3, iE3);
            }
            gt gtVarI4 = oh1.i(gnVar4, 1);
            int iE4 = gnVar4.e();
            vn vnVarN2 = n();
            if (vnVarN2 != null) {
                iE4 = vnVarN2.L.e();
            }
            if (gtVarI4 != null) {
                oh1.b(gtVar, gtVarI4, -iE4);
            }
        }
        gtVar2.a = this;
        gtVar.a = this;
    }

    @Override // defpackage.oh1
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((oh1) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // defpackage.oh1
    public final void f() {
        this.c = null;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((oh1) obj).f();
        }
    }

    @Override // defpackage.oh1
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            oh1 oh1Var = (oh1) arrayList.get(i);
            j = ((long) oh1Var.i.f) + oh1Var.j() + j + ((long) oh1Var.h.f);
        }
        return j;
    }

    @Override // defpackage.oh1
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((oh1) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final vn m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            vn vnVar = ((oh1) arrayList.get(i)).b;
            if (vnVar.g0 != 8) {
                return vnVar;
            }
            i++;
        }
    }

    public final vn n() {
        ArrayList arrayList = this.k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            vn vnVar = ((oh1) arrayList.get(size)).b;
            if (vnVar.g0 != 8) {
                return vnVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append("<");
            sb.append((oh1) obj);
            sb.append("> ");
        }
        return sb.toString();
    }
}
