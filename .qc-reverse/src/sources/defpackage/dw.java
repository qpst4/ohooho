package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dw extends w50 {
    public static final dw g;
    public static volatile q50 h;
    public int d;
    public int e;
    public zh f = zh.d;

    static {
        dw dwVar = new dw();
        g = dwVar;
        dwVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                dw dwVar = (dw) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = dwVar.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                int i4 = this.e;
                boolean z2 = i4 != 0;
                int i5 = dwVar.e;
                this.e = v50Var.f(i4, i5, z2, i5 != 0);
                zh zhVar = this.f;
                zh zhVar2 = zh.d;
                boolean z3 = zhVar != zhVar2;
                zh zhVar3 = dwVar.f;
                this.f = v50Var.a(z3, zhVar, zhVar3 != zhVar2, zhVar3);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i6 = clVar.i();
                        if (i6 != 0) {
                            if (i6 == 8) {
                                this.d = clVar.f();
                            } else if (i6 == 16) {
                                this.e = clVar.f();
                            } else if (i6 == 90) {
                                this.f = clVar.c();
                            } else if (!clVar.k(i6)) {
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
                return new dw();
            case 5:
                return new cw(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (dw.class) {
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
        if (!this.f.isEmpty()) {
            iB += dl.a(11, this.f);
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
        if (this.f.isEmpty()) {
            return;
        }
        dlVar.h(11, this.f);
    }
}
