package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a6 extends w50 {
    public static final a6 g;
    public static volatile q50 h;
    public int d;
    public e6 e;
    public zh f = zh.d;

    static {
        a6 a6Var = new a6();
        g = a6Var;
        a6Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                a6 a6Var = (a6) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = a6Var.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                this.e = (e6) v50Var.e(this.e, a6Var.e);
                zh zhVar = this.f;
                zh zhVar2 = zh.d;
                boolean z2 = zhVar != zhVar2;
                zh zhVar3 = a6Var.f;
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
                                e6 e6Var = this.e;
                                d6 d6Var = e6Var != null ? (d6) e6Var.k() : null;
                                e6 e6Var2 = (e6) clVar.d(e6.e.c(), w00Var);
                                this.e = e6Var2;
                                if (d6Var != null) {
                                    d6Var.d(e6Var2);
                                    this.e = (e6) d6Var.b();
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
                return new a6();
            case 5:
                return new z5(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (a6.class) {
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
        e6 e6Var = this.e;
        if (e6Var != null) {
            if (e6Var == null) {
                e6Var = e6.e;
            }
            iF += dl.c(2, e6Var);
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
        e6 e6Var = this.e;
        if (e6Var != null) {
            if (e6Var == null) {
                e6Var = e6.e;
            }
            dlVar.k(2, e6Var);
        }
        if (this.f.isEmpty()) {
            return;
        }
        dlVar.h(3, this.f);
    }
}
