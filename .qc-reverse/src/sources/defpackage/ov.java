package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ov extends w50 {
    public static final ov g;
    public static volatile q50 h;
    public int d;
    public int e;
    public int f;

    static {
        ov ovVar = new ov();
        g = ovVar;
        ovVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                ov ovVar = (ov) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = ovVar.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                int i4 = this.e;
                boolean z2 = i4 != 0;
                int i5 = ovVar.e;
                this.e = v50Var.f(i4, i5, z2, i5 != 0);
                int i6 = this.f;
                boolean z3 = i6 != 0;
                int i7 = ovVar.f;
                this.f = v50Var.f(i6, i7, z3, i7 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i8 = clVar.i();
                        if (i8 != 0) {
                            if (i8 == 8) {
                                this.d = clVar.f();
                            } else if (i8 == 16) {
                                this.e = clVar.f();
                            } else if (i8 == 24) {
                                this.f = clVar.f();
                            } else if (!clVar.k(i8)) {
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
                return new ov();
            case 5:
                return new nv(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (ov.class) {
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
        int i2 = this.d;
        int iB = i2 != 0 ? dl.b(1, i2) : 0;
        int i3 = this.e;
        if (i3 != 0) {
            iB += dl.b(2, i3);
        }
        int i4 = this.f;
        if (i4 != 0) {
            iB += dl.b(3, i4);
        }
        this.c = iB;
        return iB;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        int i = this.d;
        if (i != 0) {
            dlVar.i(1, i);
        }
        int i2 = this.e;
        if (i2 != 0) {
            dlVar.i(2, i2);
        }
        int i3 = this.f;
        if (i3 != 0) {
            dlVar.i(3, i3);
        }
    }

    public final int p() {
        int i = this.f;
        int i2 = i != 0 ? i != 1 ? i != 2 ? 0 : 3 : 2 : 1;
        if (i2 == 0) {
            return 4;
        }
        return i2;
    }
}
