package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a80 extends oh1 {
    @Override // defpackage.et
    public final void a(et etVar) {
        fe feVar = (fe) this.b;
        int i = feVar.s0;
        gt gtVar = this.h;
        ArrayList arrayList = gtVar.l;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            int i5 = ((gt) obj).g;
            if (i3 == -1 || i5 < i3) {
                i3 = i5;
            }
            if (i2 < i5) {
                i2 = i5;
            }
        }
        if (i == 0 || i == 2) {
            gtVar.d(i3 + feVar.u0);
        } else {
            gtVar.d(i2 + feVar.u0);
        }
    }

    @Override // defpackage.oh1
    public final void d() {
        vn vnVar = this.b;
        if (vnVar instanceof fe) {
            gt gtVar = this.h;
            gtVar.b = true;
            ArrayList arrayList = gtVar.l;
            fe feVar = (fe) vnVar;
            int i = feVar.s0;
            boolean z = feVar.t0;
            int i2 = 0;
            if (i == 0) {
                gtVar.e = 4;
                while (i2 < feVar.r0) {
                    vn vnVar2 = feVar.q0[i2];
                    if (z || vnVar2.g0 != 8) {
                        gt gtVar2 = vnVar2.d.h;
                        gtVar2.k.add(gtVar);
                        arrayList.add(gtVar2);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 1) {
                gtVar.e = 5;
                while (i2 < feVar.r0) {
                    vn vnVar3 = feVar.q0[i2];
                    if (z || vnVar3.g0 != 8) {
                        gt gtVar3 = vnVar3.d.i;
                        gtVar3.k.add(gtVar);
                        arrayList.add(gtVar3);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 2) {
                gtVar.e = 6;
                while (i2 < feVar.r0) {
                    vn vnVar4 = feVar.q0[i2];
                    if (z || vnVar4.g0 != 8) {
                        gt gtVar4 = vnVar4.e.h;
                        gtVar4.k.add(gtVar);
                        arrayList.add(gtVar4);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            gtVar.e = 7;
            while (i2 < feVar.r0) {
                vn vnVar5 = feVar.q0[i2];
                if (z || vnVar5.g0 != 8) {
                    gt gtVar5 = vnVar5.e.i;
                    gtVar5.k.add(gtVar);
                    arrayList.add(gtVar5);
                }
                i2++;
            }
            m(this.b.e.h);
            m(this.b.e.i);
        }
    }

    @Override // defpackage.oh1
    public final void e() {
        vn vnVar = this.b;
        if (vnVar instanceof fe) {
            int i = ((fe) vnVar).s0;
            gt gtVar = this.h;
            if (i == 0 || i == 1) {
                vnVar.Y = gtVar.g;
            } else {
                vnVar.Z = gtVar.g;
            }
        }
    }

    @Override // defpackage.oh1
    public final void f() {
        this.c = null;
        this.h.c();
    }

    @Override // defpackage.oh1
    public final boolean k() {
        return false;
    }

    public final void m(gt gtVar) {
        gt gtVar2 = this.h;
        gtVar2.k.add(gtVar);
        gtVar.l.add(gtVar2);
    }
}
