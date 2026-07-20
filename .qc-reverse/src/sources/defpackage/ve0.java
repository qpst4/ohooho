package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ve0 extends w50 {
    public static final ve0 h;
    public static volatile q50 i;
    public String d = "";
    public int e;
    public int f;
    public int g;

    static {
        ve0 ve0Var = new ve0();
        h = ve0Var;
        ve0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i2, Object obj2) {
        switch (l11.r(i2)) {
            case 0:
                return h;
            case 1:
                v50 v50Var = (v50) obj;
                ve0 ve0Var = (ve0) obj2;
                this.d = v50Var.b(!this.d.isEmpty(), this.d, !ve0Var.d.isEmpty(), ve0Var.d);
                int i3 = this.e;
                boolean z = i3 != 0;
                int i4 = ve0Var.e;
                this.e = v50Var.f(i3, i4, z, i4 != 0);
                int i5 = this.f;
                boolean z2 = i5 != 0;
                int i6 = ve0Var.f;
                this.f = v50Var.f(i5, i6, z2, i6 != 0);
                int i7 = this.g;
                boolean z3 = i7 != 0;
                int i8 = ve0Var.g;
                this.g = v50Var.f(i7, i8, z3, i8 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i9 = clVar.i();
                        if (i9 != 0) {
                            if (i9 == 10) {
                                this.d = clVar.h();
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
                return new ve0();
            case 5:
                return new ue0(h);
            case 6:
                break;
            case 7:
                if (i == null) {
                    synchronized (ve0.class) {
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
        int iD = !this.d.isEmpty() ? dl.d(this.d, 1) : 0;
        int i3 = this.e;
        if (i3 != 0) {
            iD += dl.b(2, i3);
        }
        int i4 = this.f;
        if (i4 != 0) {
            iD += dl.f(3, i4);
        }
        int i5 = this.g;
        if (i5 != 0) {
            iD += dl.b(4, i5);
        }
        this.c = iD;
        return iD;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (!this.d.isEmpty()) {
            dlVar.l(this.d, 1);
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
}
