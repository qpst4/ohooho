package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class we0 extends w50 {
    public static final we0 f;
    public static volatile q50 g;
    public int d;
    public sr0 e = sr0.d;

    static {
        we0 we0Var = new we0();
        f = we0Var;
        we0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        boolean z = false;
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                we0 we0Var = (we0) obj2;
                int i2 = this.d;
                boolean z2 = i2 != 0;
                int i3 = we0Var.d;
                this.d = v50Var.f(i2, i3, z2, i3 != 0);
                this.e = v50Var.c(this.e, we0Var.e);
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
                                sr0 sr0Var = this.e;
                                if (!sr0Var.b) {
                                    this.e = w50.h(sr0Var);
                                }
                                this.e.add(clVar.d(ve0.h.c(), w00Var));
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
                this.e.b = false;
                return null;
            case 4:
                return new we0();
            case 5:
                return new te0(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (we0.class) {
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
        for (int i3 = 0; i3 < this.e.c.size(); i3++) {
            iF += dl.c(2, (w50) this.e.c.get(i3));
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
        for (int i2 = 0; i2 < this.e.c.size(); i2++) {
            dlVar.k(2, (w50) this.e.c.get(i2));
        }
    }
}
