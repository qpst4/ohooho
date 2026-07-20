package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v5 extends w50 {
    public static final v5 f;
    public static volatile q50 g;
    public x5 d;
    public int e;

    static {
        v5 v5Var = new v5();
        f = v5Var;
        v5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                v5 v5Var = (v5) obj2;
                this.d = (x5) v50Var.e(this.d, v5Var.d);
                int i2 = this.e;
                boolean z = i2 != 0;
                int i3 = v5Var.e;
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
                                x5 x5Var = this.d;
                                w5 w5Var = x5Var != null ? (w5) x5Var.k() : null;
                                x5 x5Var2 = (x5) clVar.d(x5.e.c(), w00Var);
                                this.d = x5Var2;
                                if (w5Var != null) {
                                    w5Var.d(x5Var2);
                                    this.d = (x5) w5Var.b();
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
                return new v5();
            case 5:
                return new u5(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (v5.class) {
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
        x5 x5Var = this.d;
        if (x5Var != null) {
            if (x5Var == null) {
                x5Var = x5.e;
            }
            iF = dl.c(1, x5Var);
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
        x5 x5Var = this.d;
        if (x5Var != null) {
            if (x5Var == null) {
                x5Var = x5.e;
            }
            dlVar.k(1, x5Var);
        }
        int i = this.e;
        if (i != 0) {
            dlVar.n(2, i);
        }
    }
}
