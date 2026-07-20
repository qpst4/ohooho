package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mv extends w50 {
    public static final mv e;
    public static volatile q50 f;
    public ov d;

    static {
        mv mvVar = new mv();
        e = mvVar;
        mvVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return e;
            case 1:
                this.d = (ov) ((v50) obj).e(this.d, ((mv) obj2).d);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 18) {
                                ov ovVar = this.d;
                                nv nvVar = ovVar != null ? (nv) ovVar.k() : null;
                                ov ovVar2 = (ov) clVar.d(ov.g.c(), w00Var);
                                this.d = ovVar2;
                                if (nvVar != null) {
                                    nvVar.d(ovVar2);
                                    this.d = (ov) nvVar.b();
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
                return new mv();
            case 5:
                return new m5(e);
            case 6:
                break;
            case 7:
                if (f == null) {
                    synchronized (mv.class) {
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
        ov ovVar = this.d;
        if (ovVar != null) {
            if (ovVar == null) {
                ovVar = ov.g;
            }
            iC = dl.c(2, ovVar);
        } else {
            iC = 0;
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        ov ovVar = this.d;
        if (ovVar != null) {
            if (ovVar == null) {
                ovVar = ov.g;
            }
            dlVar.k(2, ovVar);
        }
    }
}
