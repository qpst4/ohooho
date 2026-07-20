package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x5 extends w50 {
    public static final x5 e;
    public static volatile q50 f;
    public int d;

    static {
        x5 x5Var = new x5();
        e = x5Var;
        x5Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return e;
            case 1:
                v50 v50Var = (v50) obj;
                x5 x5Var = (x5) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = x5Var.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i4 = clVar.i();
                        if (i4 != 0) {
                            if (i4 == 8) {
                                this.d = clVar.f();
                            } else if (!clVar.k(i4)) {
                            }
                        }
                        z = true;
                    } catch (ic0 e2) {
                        zy.m(e2);
                        return null;
                    } catch (IOException e3) {
                        zy.m(new ic0(e3.getMessage()));
                        return null;
                    }
                }
                break;
            case 3:
                return null;
            case 4:
                return new x5();
            case 5:
                return new w5(e);
            case 6:
                break;
            case 7:
                if (f == null) {
                    synchronized (x5.class) {
                        try {
                            if (f == null) {
                                f = new q50(e);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return f;
            default:
                zy.a();
                return null;
        }
        return e;
    }

    @Override // defpackage.w50
    public final int d() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.d;
        int iF = i2 != 0 ? dl.f(1, i2) : 0;
        this.c = iF;
        return iF;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        int i = this.d;
        if (i != 0) {
            dlVar.n(1, i);
        }
    }
}
