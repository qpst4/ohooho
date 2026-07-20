package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vv extends w50 {
    public static final vv e;
    public static volatile q50 f;
    public xv d;

    static {
        vv vvVar = new vv();
        e = vvVar;
        vvVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return e;
            case 1:
                this.d = (xv) ((v50) obj).e(this.d, ((vv) obj2).d);
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
                                xv xvVar = this.d;
                                wv wvVar = xvVar != null ? (wv) xvVar.k() : null;
                                xv xvVar2 = (xv) clVar.d(xv.g.c(), w00Var);
                                this.d = xvVar2;
                                if (wvVar != null) {
                                    wvVar.d(xvVar2);
                                    this.d = (xv) wvVar.b();
                                }
                            } else if (!clVar.k(i2)) {
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
                return new vv();
            case 5:
                return new m5(e);
            case 6:
                break;
            case 7:
                if (f == null) {
                    synchronized (vv.class) {
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
        int iC;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        xv xvVar = this.d;
        if (xvVar != null) {
            if (xvVar == null) {
                xvVar = xv.g;
            }
            iC = dl.c(1, xvVar);
        } else {
            iC = 0;
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        xv xvVar = this.d;
        if (xvVar != null) {
            if (xvVar == null) {
                xvVar = xv.g;
            }
            dlVar.k(1, xvVar);
        }
    }
}
