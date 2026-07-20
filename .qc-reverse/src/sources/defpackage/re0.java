package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class re0 extends w50 {
    public static final re0 h;
    public static volatile q50 i;
    public fe0 d;
    public int e;
    public int f;
    public int g;

    static {
        re0 re0Var = new re0();
        h = re0Var;
        re0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i2, Object obj2) {
        switch (l11.r(i2)) {
            case 0:
                return h;
            case 1:
                v50 v50Var = (v50) obj;
                re0 re0Var = (re0) obj2;
                this.d = (fe0) v50Var.e(this.d, re0Var.d);
                int i3 = this.e;
                boolean z = i3 != 0;
                int i4 = re0Var.e;
                this.e = v50Var.f(i3, i4, z, i4 != 0);
                int i5 = this.f;
                boolean z2 = i5 != 0;
                int i6 = re0Var.f;
                this.f = v50Var.f(i5, i6, z2, i6 != 0);
                int i7 = this.g;
                boolean z3 = i7 != 0;
                int i8 = re0Var.g;
                this.g = v50Var.f(i7, i8, z3, i8 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i9 = clVar.i();
                        if (i9 != 0) {
                            if (i9 == 10) {
                                fe0 fe0Var = this.d;
                                ee0 ee0Var = fe0Var != null ? (ee0) fe0Var.k() : null;
                                fe0 fe0Var2 = (fe0) clVar.d(fe0.g.c(), w00Var);
                                this.d = fe0Var2;
                                if (ee0Var != null) {
                                    ee0Var.d(fe0Var2);
                                    this.d = (fe0) ee0Var.b();
                                }
                            } else if (i9 == 16) {
                                this.e = clVar.f();
                            } else if (i9 == 24) {
                                this.f = clVar.f();
                            } else if (i9 == 32) {
                                this.g = clVar.f();
                            } else if (!clVar.k(i9)) {
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
                return new re0();
            case 5:
                return new qe0(h);
            case 6:
                break;
            case 7:
                if (i == null) {
                    synchronized (re0.class) {
                        try {
                            if (i == null) {
                                i = new q50(h);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return i;
            default:
                zy.a();
                return null;
        }
        return h;
    }

    @Override // defpackage.w50
    public final int d() {
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        int iC = this.d != null ? dl.c(1, p()) : 0;
        int i3 = this.e;
        if (i3 != 0) {
            iC += dl.b(2, i3);
        }
        int i4 = this.f;
        if (i4 != 0) {
            iC += dl.f(3, i4);
        }
        int i5 = this.g;
        if (i5 != 0) {
            iC += dl.b(4, i5);
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (this.d != null) {
            dlVar.k(1, p());
        }
        int i2 = this.e;
        if (i2 != 0) {
            dlVar.i(2, i2);
        }
        int i3 = this.f;
        if (i3 != 0) {
            dlVar.n(3, i3);
        }
        int i4 = this.g;
        if (i4 != 0) {
            dlVar.i(4, i4);
        }
    }

    public final fe0 p() {
        fe0 fe0Var = this.d;
        return fe0Var == null ? fe0.g : fe0Var;
    }

    public final int q() {
        int i2 = this.e;
        int i3 = 1;
        if (i2 != 0) {
            if (i2 != 1) {
                i3 = 3;
                if (i2 != 2) {
                    i3 = i2 != 3 ? 0 : 4;
                }
            } else {
                i3 = 2;
            }
        }
        if (i3 == 0) {
            return 5;
        }
        return i3;
    }
}
