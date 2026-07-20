package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n5 extends w50 {
    public static final n5 f;
    public static volatile q50 g;
    public q5 d;
    public int e;

    static {
        n5 n5Var = new n5();
        f = n5Var;
        n5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                n5 n5Var = (n5) obj2;
                this.d = (q5) v50Var.e(this.d, n5Var.d);
                int i2 = this.e;
                boolean z = i2 != 0;
                int i3 = n5Var.e;
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
                                q5 q5Var = this.d;
                                p5 p5Var = q5Var != null ? (p5) q5Var.k() : null;
                                q5 q5Var2 = (q5) clVar.d(q5.h.c(), w00Var);
                                this.d = q5Var2;
                                if (p5Var != null) {
                                    p5Var.d(q5Var2);
                                    this.d = (q5) p5Var.b();
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
                return new n5();
            case 5:
                return new m5(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (n5.class) {
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
        q5 q5Var = this.d;
        if (q5Var != null) {
            if (q5Var == null) {
                q5Var = q5.h;
            }
            iF = dl.c(1, q5Var);
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
        q5 q5Var = this.d;
        if (q5Var != null) {
            if (q5Var == null) {
                q5Var = q5.h;
            }
            dlVar.k(1, q5Var);
        }
        int i = this.e;
        if (i != 0) {
            dlVar.n(2, i);
        }
    }
}
