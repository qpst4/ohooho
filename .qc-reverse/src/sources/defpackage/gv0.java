package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gv0 extends w50 {
    public static final gv0 f;
    public static volatile q50 g;
    public String d = "";
    public sr0 e = sr0.d;

    static {
        gv0 gv0Var = new gv0();
        f = gv0Var;
        gv0Var.g();
    }

    public static fv0 p() {
        return (fv0) f.k();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        boolean z = false;
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                gv0 gv0Var = (gv0) obj2;
                this.d = v50Var.b(!this.d.isEmpty(), this.d, !gv0Var.d.isEmpty(), gv0Var.d);
                this.e = v50Var.c(this.e, gv0Var.e);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 10) {
                                this.d = clVar.h();
                            } else if (i2 == 18) {
                                sr0 sr0Var = this.e;
                                if (!sr0Var.b) {
                                    this.e = w50.h(sr0Var);
                                }
                                this.e.add(clVar.d(le0.i.c(), w00Var));
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
                this.e.b = false;
                return null;
            case 4:
                return new gv0();
            case 5:
                return new fv0(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (gv0.class) {
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
        for (int i2 = 0; i2 < this.e.c.size(); i2++) {
            iD += dl.c(2, (w50) this.e.c.get(i2));
        }
        this.c = iD;
        return iD;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (!this.d.isEmpty()) {
            dlVar.l(this.d, 1);
        }
        for (int i = 0; i < this.e.c.size(); i++) {
            dlVar.k(2, (w50) this.e.c.get(i));
        }
    }
}
