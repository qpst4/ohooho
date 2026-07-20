package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ye0 extends w50 {
    public static final ye0 f;
    public static volatile q50 g;
    public int d;
    public af0 e;

    static {
        ye0 ye0Var = new ye0();
        f = ye0Var;
        ye0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                ye0 ye0Var = (ye0) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = ye0Var.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                this.e = (af0) v50Var.e(this.e, ye0Var.e);
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
                                af0 af0Var = this.e;
                                ze0 ze0Var = af0Var != null ? (ze0) af0Var.k() : null;
                                af0 af0Var2 = (af0) clVar.d(af0.e.c(), w00Var);
                                this.e = af0Var2;
                                if (ze0Var != null) {
                                    ze0Var.d(af0Var2);
                                    this.e = (af0) ze0Var.b();
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
                return new ye0();
            case 5:
                return new xe0(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (ye0.class) {
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
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.d;
        int iF = i2 != 0 ? dl.f(1, i2) : 0;
        af0 af0Var = this.e;
        if (af0Var != null) {
            if (af0Var == null) {
                af0Var = af0.e;
            }
            iF += dl.c(2, af0Var);
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
        af0 af0Var = this.e;
        if (af0Var != null) {
            if (af0Var == null) {
                af0Var = af0.e;
            }
            dlVar.k(2, af0Var);
        }
    }
}
