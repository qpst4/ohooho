package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class iw extends w50 {
    public static final iw g;
    public static volatile q50 h;
    public int d;
    public zh e = zh.d;
    public kw f;

    static {
        iw iwVar = new iw();
        g = iwVar;
        iwVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                iw iwVar = (iw) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = iwVar.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                zh zhVar = this.e;
                zh zhVar2 = zh.d;
                boolean z2 = zhVar != zhVar2;
                zh zhVar3 = iwVar.e;
                this.e = v50Var.a(z2, zhVar, zhVar3 != zhVar2, zhVar3);
                this.f = (kw) v50Var.e(this.f, iwVar.f);
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
                                this.e = clVar.c();
                            } else if (i4 == 26) {
                                kw kwVar = this.f;
                                jw jwVar = kwVar != null ? (jw) kwVar.k() : null;
                                kw kwVar2 = (kw) clVar.d(kw.f.c(), w00Var);
                                this.f = kwVar2;
                                if (jwVar != null) {
                                    jwVar.d(kwVar2);
                                    this.f = (kw) jwVar.b();
                                }
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
                return new iw();
            case 5:
                return new hw(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (iw.class) {
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
        if (!this.e.isEmpty()) {
            iF += dl.a(2, this.e);
        }
        kw kwVar = this.f;
        if (kwVar != null) {
            if (kwVar == null) {
                kwVar = kw.f;
            }
            iF += dl.c(3, kwVar);
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
        if (!this.e.isEmpty()) {
            dlVar.h(2, this.e);
        }
        kw kwVar = this.f;
        if (kwVar != null) {
            if (kwVar == null) {
                kwVar = kw.f;
            }
            dlVar.k(3, kwVar);
        }
    }
}
