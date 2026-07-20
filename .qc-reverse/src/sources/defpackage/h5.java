package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class h5 extends w50 {
    public static final h5 f;
    public static volatile q50 g;
    public v5 d;
    public k80 e;

    static {
        h5 h5Var = new h5();
        f = h5Var;
        h5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                h5 h5Var = (h5) obj2;
                this.d = (v5) v50Var.e(this.d, h5Var.d);
                this.e = (k80) v50Var.e(this.e, h5Var.e);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 10) {
                                v5 v5Var = this.d;
                                u5 u5Var = v5Var != null ? (u5) v5Var.k() : null;
                                v5 v5Var2 = (v5) clVar.d(v5.f.c(), w00Var);
                                this.d = v5Var2;
                                if (u5Var != null) {
                                    u5Var.d(v5Var2);
                                    this.d = (v5) u5Var.b();
                                }
                            } else if (i2 == 18) {
                                k80 k80Var = this.e;
                                j80 j80Var = k80Var != null ? (j80) k80Var.k() : null;
                                k80 k80Var2 = (k80) clVar.d(k80.f.c(), w00Var);
                                this.e = k80Var2;
                                if (j80Var != null) {
                                    j80Var.d(k80Var2);
                                    this.e = (k80) j80Var.b();
                                }
                            } else if (!clVar.k(i2)) {
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
                return new h5();
            case 5:
                return new g5(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (h5.class) {
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
        int iC;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        v5 v5Var = this.d;
        if (v5Var != null) {
            if (v5Var == null) {
                v5Var = v5.f;
            }
            iC = dl.c(1, v5Var);
        } else {
            iC = 0;
        }
        k80 k80Var = this.e;
        if (k80Var != null) {
            if (k80Var == null) {
                k80Var = k80.f;
            }
            iC += dl.c(2, k80Var);
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        v5 v5Var = this.d;
        if (v5Var != null) {
            if (v5Var == null) {
                v5Var = v5.f;
            }
            dlVar.k(1, v5Var);
        }
        k80 k80Var = this.e;
        if (k80Var != null) {
            if (k80Var == null) {
                k80Var = k80.f;
            }
            dlVar.k(2, k80Var);
        }
    }
}
