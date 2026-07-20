package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q5 extends w50 {
    public static final q5 h;
    public static volatile q50 i;
    public int d;
    public int e;
    public int f;
    public m80 g;

    static {
        q5 q5Var = new q5();
        h = q5Var;
        q5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i2, Object obj2) {
        switch (l11.r(i2)) {
            case 0:
                return h;
            case 1:
                v50 v50Var = (v50) obj;
                q5 q5Var = (q5) obj2;
                int i3 = this.d;
                boolean z = i3 != 0;
                int i4 = q5Var.d;
                this.d = v50Var.f(i3, i4, z, i4 != 0);
                int i5 = this.e;
                boolean z2 = i5 != 0;
                int i6 = q5Var.e;
                this.e = v50Var.f(i5, i6, z2, i6 != 0);
                int i7 = this.f;
                boolean z3 = i7 != 0;
                int i8 = q5Var.f;
                this.f = v50Var.f(i7, i8, z3, i8 != 0);
                this.g = (m80) v50Var.e(this.g, q5Var.g);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i9 = clVar.i();
                        if (i9 != 0) {
                            if (i9 == 8) {
                                this.d = clVar.f();
                            } else if (i9 == 16) {
                                this.e = clVar.f();
                            } else if (i9 == 24) {
                                this.f = clVar.f();
                            } else if (i9 == 34) {
                                m80 m80Var = this.g;
                                l80 l80Var = m80Var != null ? (l80) m80Var.k() : null;
                                m80 m80Var2 = (m80) clVar.d(m80.f.c(), w00Var);
                                this.g = m80Var2;
                                if (l80Var != null) {
                                    l80Var.d(m80Var2);
                                    this.g = (m80) l80Var.b();
                                }
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
                return new q5();
            case 5:
                return new p5(h);
            case 6:
                break;
            case 7:
                if (i == null) {
                    synchronized (q5.class) {
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
        int i3 = this.d;
        int iF = i3 != 0 ? dl.f(1, i3) : 0;
        int i4 = this.e;
        if (i4 != 0) {
            iF += dl.f(2, i4);
        }
        int i5 = this.f;
        if (i5 != 0) {
            iF += dl.b(3, i5);
        }
        if (this.g != null) {
            iF += dl.c(4, p());
        }
        this.c = iF;
        return iF;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        int i2 = this.d;
        if (i2 != 0) {
            dlVar.n(1, i2);
        }
        int i3 = this.e;
        if (i3 != 0) {
            dlVar.n(2, i3);
        }
        int i4 = this.f;
        if (i4 != 0) {
            dlVar.i(3, i4);
        }
        if (this.g != null) {
            dlVar.k(4, p());
        }
    }

    public final m80 p() {
        m80 m80Var = this.g;
        return m80Var == null ? m80.f : m80Var;
    }
}
