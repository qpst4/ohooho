package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yy extends w50 {
    public static final yy f;
    public static volatile q50 g;
    public zh d = zh.d;
    public we0 e;

    static {
        yy yyVar = new yy();
        f = yyVar;
        yyVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                yy yyVar = (yy) obj2;
                zh zhVar = this.d;
                zh zhVar2 = zh.d;
                boolean z = zhVar != zhVar2;
                zh zhVar3 = yyVar.d;
                this.d = v50Var.a(z, zhVar, zhVar3 != zhVar2, zhVar3);
                this.e = (we0) v50Var.e(this.e, yyVar.e);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 18) {
                                this.d = clVar.c();
                            } else if (i2 == 26) {
                                we0 we0Var = this.e;
                                te0 te0Var = we0Var != null ? (te0) we0Var.k() : null;
                                we0 we0Var2 = (we0) clVar.d(we0.f.c(), w00Var);
                                this.e = we0Var2;
                                if (te0Var != null) {
                                    te0Var.d(we0Var2);
                                    this.e = (we0) te0Var.b();
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
                return new yy();
            case 5:
                return new xy(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (yy.class) {
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
        int iA = !this.d.isEmpty() ? dl.a(2, this.d) : 0;
        we0 we0Var = this.e;
        if (we0Var != null) {
            if (we0Var == null) {
                we0Var = we0.f;
            }
            iA += dl.c(3, we0Var);
        }
        this.c = iA;
        return iA;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (!this.d.isEmpty()) {
            dlVar.h(2, this.d);
        }
        we0 we0Var = this.e;
        if (we0Var != null) {
            if (we0Var == null) {
                we0Var = we0.f;
            }
            dlVar.k(3, we0Var);
        }
    }
}
