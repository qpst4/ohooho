package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i6 extends w50 {
    public static final i6 f;
    public static volatile q50 g;
    public k6 d;
    public int e;

    static {
        i6 i6Var = new i6();
        f = i6Var;
        i6Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                i6 i6Var = (i6) obj2;
                this.d = (k6) v50Var.e(this.d, i6Var.d);
                int i2 = this.e;
                boolean z = i2 != 0;
                int i3 = i6Var.e;
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
                                k6 k6Var = this.d;
                                j6 j6Var = k6Var != null ? (j6) k6Var.k() : null;
                                k6 k6Var2 = (k6) clVar.d(k6.g.c(), w00Var);
                                this.d = k6Var2;
                                if (j6Var != null) {
                                    j6Var.d(k6Var2);
                                    this.d = (k6) j6Var.b();
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
                return new i6();
            case 5:
                return new m5(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (i6.class) {
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
        k6 k6Var = this.d;
        if (k6Var != null) {
            if (k6Var == null) {
                k6Var = k6.g;
            }
            iF = dl.c(1, k6Var);
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
        k6 k6Var = this.d;
        if (k6Var != null) {
            if (k6Var == null) {
                k6Var = k6.g;
            }
            dlVar.k(1, k6Var);
        }
        int i = this.e;
        if (i != 0) {
            dlVar.n(2, i);
        }
    }
}
