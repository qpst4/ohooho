package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c6 extends w50 {
    public static final c6 f;
    public static volatile q50 g;
    public e6 d;
    public int e;

    static {
        c6 c6Var = new c6();
        f = c6Var;
        c6Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                c6 c6Var = (c6) obj2;
                this.d = (e6) v50Var.e(this.d, c6Var.d);
                int i2 = this.e;
                boolean z = i2 != 0;
                int i3 = c6Var.e;
                this.e = v50Var.f(i2, i3, z, i3 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i4 = clVar.i();
                        if (i4 != 0) {
                            if (i4 == 10) {
                                e6 e6Var = this.d;
                                d6 d6Var = e6Var != null ? (d6) e6Var.k() : null;
                                e6 e6Var2 = (e6) clVar.d(e6.e.c(), w00Var);
                                this.d = e6Var2;
                                if (d6Var != null) {
                                    d6Var.d(e6Var2);
                                    this.d = (e6) d6Var.b();
                                }
                            } else if (i4 == 16) {
                                this.e = clVar.f();
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
                return new c6();
            case 5:
                return new b6(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (c6.class) {
                        try {
                            if (g == null) {
                                g = new q50(f);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return g;
            default:
                zy.a();
                return null;
        }
        return f;
    }

    @Override // defpackage.w50
    public final int d() {
        int iF;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        e6 e6Var = this.d;
        if (e6Var != null) {
            if (e6Var == null) {
                e6Var = e6.e;
            }
            iF = dl.c(1, e6Var);
        } else {
            iF = 0;
        }
        int i2 = this.e;
        if (i2 != 0) {
            iF += dl.f(2, i2);
        }
        this.c = iF;
        return iF;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        e6 e6Var = this.d;
        if (e6Var != null) {
            if (e6Var == null) {
                e6Var = e6.e;
            }
            dlVar.k(1, e6Var);
        }
        int i = this.e;
        if (i != 0) {
            dlVar.n(2, i);
        }
    }
}
