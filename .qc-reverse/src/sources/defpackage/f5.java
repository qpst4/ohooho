package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f5 extends w50 {
    public static final f5 g;
    public static volatile q50 h;
    public int d;
    public t5 e;
    public i80 f;

    static {
        f5 f5Var = new f5();
        g = f5Var;
        f5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                f5 f5Var = (f5) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = f5Var.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                this.e = (t5) v50Var.e(this.e, f5Var.e);
                this.f = (i80) v50Var.e(this.f, f5Var.f);
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
                                t5 t5Var = this.e;
                                s5 s5Var = t5Var != null ? (s5) t5Var.k() : null;
                                t5 t5Var2 = (t5) clVar.d(t5.g.c(), w00Var);
                                this.e = t5Var2;
                                if (s5Var != null) {
                                    s5Var.d(t5Var2);
                                    this.e = (t5) s5Var.b();
                                }
                            } else if (i4 == 26) {
                                i80 i80Var = this.f;
                                h80 h80Var = i80Var != null ? (h80) i80Var.k() : null;
                                i80 i80Var2 = (i80) clVar.d(i80.g.c(), w00Var);
                                this.f = i80Var2;
                                if (h80Var != null) {
                                    h80Var.d(i80Var2);
                                    this.f = (i80) h80Var.b();
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
                return new f5();
            case 5:
                return new e5(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (f5.class) {
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
        t5 t5Var = this.e;
        if (t5Var != null) {
            if (t5Var == null) {
                t5Var = t5.g;
            }
            iF += dl.c(2, t5Var);
        }
        i80 i80Var = this.f;
        if (i80Var != null) {
            if (i80Var == null) {
                i80Var = i80.g;
            }
            iF += dl.c(3, i80Var);
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
        t5 t5Var = this.e;
        if (t5Var != null) {
            if (t5Var == null) {
                t5Var = t5.g;
            }
            dlVar.k(2, t5Var);
        }
        i80 i80Var = this.f;
        if (i80Var != null) {
            if (i80Var == null) {
                i80Var = i80.g;
            }
            dlVar.k(3, i80Var);
        }
    }
}
