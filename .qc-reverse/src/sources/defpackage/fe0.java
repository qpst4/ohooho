package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fe0 extends w50 {
    public static final fe0 g;
    public static volatile q50 h;
    public String d = "";
    public zh e = zh.d;
    public int f;

    static {
        fe0 fe0Var = new fe0();
        g = fe0Var;
        fe0Var.g();
    }

    public static ee0 p() {
        return (ee0) g.k();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                fe0 fe0Var = (fe0) obj2;
                this.d = v50Var.b(!this.d.isEmpty(), this.d, !fe0Var.d.isEmpty(), fe0Var.d);
                zh zhVar = this.e;
                zh zhVar2 = zh.d;
                boolean z = zhVar != zhVar2;
                zh zhVar3 = fe0Var.e;
                this.e = v50Var.a(z, zhVar, zhVar3 != zhVar2, zhVar3);
                int i2 = this.f;
                boolean z2 = i2 != 0;
                int i3 = fe0Var.f;
                this.f = v50Var.f(i2, i3, z2, i3 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i4 = clVar.i();
                        if (i4 != 0) {
                            if (i4 == 10) {
                                this.d = clVar.h();
                            } else if (i4 == 18) {
                                this.e = clVar.c();
                            } else if (i4 == 24) {
                                this.f = clVar.f();
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
                return null;
            case 4:
                return new fe0();
            case 5:
                return new ee0(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (fe0.class) {
                        try {
                            if (h == null) {
                                h = new q50(g);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return h;
            default:
                zy.a();
                return null;
        }
        return g;
    }

    @Override // defpackage.w50
    public final int d() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int iD = !this.d.isEmpty() ? dl.d(this.d, 1) : 0;
        if (!this.e.isEmpty()) {
            iD += dl.a(2, this.e);
        }
        int i2 = this.f;
        if (i2 != 0) {
            iD += dl.b(3, i2);
        }
        this.c = iD;
        return iD;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (!this.d.isEmpty()) {
            dlVar.l(this.d, 1);
        }
        if (!this.e.isEmpty()) {
            dlVar.h(2, this.e);
        }
        int i = this.f;
        if (i != 0) {
            dlVar.i(3, i);
        }
    }
}
