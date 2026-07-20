package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class af0 extends w50 {
    public static final af0 e;
    public static volatile q50 f;
    public String d = "";

    static {
        af0 af0Var = new af0();
        e = af0Var;
        af0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return e;
            case 1:
                af0 af0Var = (af0) obj2;
                this.d = ((v50) obj).b(!this.d.isEmpty(), this.d, true ^ af0Var.d.isEmpty(), af0Var.d);
                return this;
            case 2:
                cl clVar = (cl) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 10) {
                                this.d = clVar.h();
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
                return new af0();
            case 5:
                return new ze0(e);
            case 6:
                break;
            case 7:
                if (f == null) {
                    synchronized (af0.class) {
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
        int iD = !this.d.isEmpty() ? dl.d(this.d, 1) : 0;
        this.c = iD;
        return iD;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (this.d.isEmpty()) {
            return;
        }
        dlVar.l(this.d, 1);
    }
}
