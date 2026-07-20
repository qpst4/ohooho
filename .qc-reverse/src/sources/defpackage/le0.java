package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class le0 extends w50 {
    public static final le0 i;
    public static volatile q50 j;
    public int f;
    public boolean g;
    public String d = "";
    public String e = "";
    public String h = "";

    static {
        le0 le0Var = new le0();
        i = le0Var;
        le0Var.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i2, Object obj2) {
        switch (l11.r(i2)) {
            case 0:
                return i;
            case 1:
                v50 v50Var = (v50) obj;
                le0 le0Var = (le0) obj2;
                this.d = v50Var.b(!this.d.isEmpty(), this.d, !le0Var.d.isEmpty(), le0Var.d);
                this.e = v50Var.b(!this.e.isEmpty(), this.e, !le0Var.e.isEmpty(), le0Var.e);
                int i3 = this.f;
                boolean z = i3 != 0;
                int i4 = le0Var.f;
                this.f = v50Var.f(i3, i4, z, i4 != 0);
                boolean z2 = this.g;
                boolean z3 = le0Var.g;
                this.g = v50Var.d(z2, z2, z3, z3);
                this.h = v50Var.b(!this.h.isEmpty(), this.h, !le0Var.h.isEmpty(), le0Var.h);
                return this;
            case 2:
                cl clVar = (cl) obj;
                while (!z) {
                    try {
                        int i5 = clVar.i();
                        if (i5 != 0) {
                            if (i5 == 10) {
                                this.d = clVar.h();
                            } else if (i5 == 18) {
                                this.e = clVar.h();
                            } else if (i5 == 24) {
                                this.f = clVar.f();
                            } else if (i5 == 32) {
                                this.g = clVar.b();
                            } else if (i5 == 42) {
                                this.h = clVar.h();
                            } else if (!clVar.k(i5)) {
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
                return new le0();
            case 5:
                return new ke0(i);
            case 6:
                break;
            case 7:
                if (j == null) {
                    synchronized (le0.class) {
                        try {
                            if (j == null) {
                                j = new q50(i);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return j;
            default:
                zy.a();
                return null;
        }
        return i;
    }

    @Override // defpackage.w50
    public final int d() {
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        int iD = !this.d.isEmpty() ? dl.d(this.d, 1) : 0;
        if (!this.e.isEmpty()) {
            iD += dl.d(this.e, 2);
        }
        int i3 = this.f;
        if (i3 != 0) {
            iD += dl.f(3, i3);
        }
        if (this.g) {
            iD += dl.e(4) + 1;
        }
        if (!this.h.isEmpty()) {
            iD += dl.d(this.h, 5);
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
            dlVar.l(this.e, 2);
        }
        int i2 = this.f;
        if (i2 != 0) {
            dlVar.n(3, i2);
        }
        boolean z = this.g;
        if (z) {
            dlVar.m(4, 0);
            byte b = z ? (byte) 1 : (byte) 0;
            try {
                byte[] bArr = dlVar.a;
                int i3 = dlVar.c;
                dlVar.c = i3 + 1;
                bArr[i3] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(dlVar.c), Integer.valueOf(dlVar.b), 1), e);
            }
        }
        if (this.h.isEmpty()) {
            return;
        }
        dlVar.l(this.h, 5);
    }
}
