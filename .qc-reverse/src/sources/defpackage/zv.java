package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zv extends w50 {
    public static final zv g;
    public static volatile q50 h;
    public int d;
    public bw e;
    public zh f = zh.d;

    static {
        zv zvVar = new zv();
        g = zvVar;
        zvVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                zv zvVar = (zv) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = zvVar.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                this.e = (bw) v50Var.e(this.e, zvVar.e);
                zh zhVar = this.f;
                zh zhVar2 = zh.d;
                boolean z2 = zhVar != zhVar2;
                zh zhVar3 = zvVar.f;
                this.f = v50Var.a(z2, zhVar, zhVar3 != zhVar2, zhVar3);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i4 = clVar.i();
                        if (i4 != 0) {
                            if (i4 == 8) {
                                this.d = clVar.f();
                            } else if (i4 == 18) {
                                bw bwVar = this.e;
                                aw awVar = bwVar != null ? (aw) bwVar.k() : null;
                                bw bwVar2 = (bw) clVar.d(bw.h.c(), w00Var);
                                this.e = bwVar2;
                                if (awVar != null) {
                                    awVar.d(bwVar2);
                                    this.e = (bw) awVar.b();
                                }
                            } else if (i4 == 26) {
                                this.f = clVar.c();
                            } else if (!clVar.k(i4)) {
                            }
                        }
                        z = true;
                    } catch (ic0 e) {
                        zy.m(e);
                        return null;
                    } catch (IOException e2) {
                        zy.m(new ic0(e2.getMessage()));
                        return null;
                    }
                }
                break;
            case 3:
                return null;
            case 4:
                return new zv();
            case 5:
                return new yv(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (zv.class) {
                        try {
                            if (h == null) {
                                h = new q50(g);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return h;
            default:
                zy.a();
                return null;
        }
        return g;
    }

    @Override // defpackage.w50
    public final int d() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.d;
        int iF = i2 != 0 ? dl.f(1, i2) : 0;
        bw bwVar = this.e;
        if (bwVar != null) {
            if (bwVar == null) {
                bwVar = bw.h;
            }
            iF += dl.c(2, bwVar);
        }
        if (!this.f.isEmpty()) {
            iF += dl.a(3, this.f);
        }
        this.c = iF;
        return iF;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        int i = this.d;
        if (i != 0) {
            dlVar.n(1, i);
        }
        bw bwVar = this.e;
        if (bwVar != null) {
            if (bwVar == null) {
                bwVar = bw.h;
            }
            dlVar.k(2, bwVar);
        }
        if (this.f.isEmpty()) {
            return;
        }
        dlVar.h(3, this.f);
    }
}
