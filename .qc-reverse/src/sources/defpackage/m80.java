package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m80 extends w50 {
    public static final m80 f;
    public static volatile q50 g;
    public int d;
    public int e;

    static {
        m80 m80Var = new m80();
        f = m80Var;
        m80Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return f;
            case 1:
                v50 v50Var = (v50) obj;
                m80 m80Var = (m80) obj2;
                int i2 = this.d;
                boolean z = i2 != 0;
                int i3 = m80Var.d;
                this.d = v50Var.f(i2, i3, z, i3 != 0);
                int i4 = this.e;
                boolean z2 = i4 != 0;
                int i5 = m80Var.e;
                this.e = v50Var.f(i4, i5, z2, i5 != 0);
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
                return new m80();
            case 5:
                return new l80(f);
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (m80.class) {
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
        int i2 = this.d;
        int iB = i2 != 0 ? dl.b(1, i2) : 0;
        int i3 = this.e;
        if (i3 != 0) {
            iB += dl.f(2, i3);
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
            dlVar.n(2, i2);
        }
    }
}
