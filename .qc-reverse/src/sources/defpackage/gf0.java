package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gf0 extends w50 {
    public static final gf0 f;
    public static volatile q50 g;
    public String d = "";
    public je0 e;

    static {
        gf0 gf0Var = new gf0();
        f = gf0Var;
        gf0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                gf0 gf0Var = (gf0) obj2;
                this.d = v50Var.b(!this.d.isEmpty(), this.d, true ^ gf0Var.d.isEmpty(), gf0Var.d);
                this.e = (je0) v50Var.e(this.e, gf0Var.e);
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
                                this.d = clVar.h();
                            } else if (i2 == 18) {
                                je0 je0Var = this.e;
                                ie0 ie0Var = je0Var != null ? (ie0) je0Var.k() : null;
                                je0 je0Var2 = (je0) clVar.d(je0.g.c(), w00Var);
                                this.e = je0Var2;
                                if (ie0Var != null) {
                                    ie0Var.d(je0Var2);
                                    this.e = (je0) ie0Var.b();
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
                return new gf0();
            case 5:
                return new ff0(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (gf0.class) {
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
        int iD = !this.d.isEmpty() ? dl.d(this.d, 1) : 0;
        je0 je0Var = this.e;
        if (je0Var != null) {
            if (je0Var == null) {
                je0Var = je0.g;
            }
            iD += dl.c(2, je0Var);
        }
        this.c = iD;
        return iD;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (!this.d.isEmpty()) {
            dlVar.l(this.d, 1);
        }
        je0 je0Var = this.e;
        if (je0Var != null) {
            if (je0Var == null) {
                je0Var = je0.g;
            }
            dlVar.k(2, je0Var);
        }
    }
}
