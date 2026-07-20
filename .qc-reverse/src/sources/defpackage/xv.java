package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xv extends w50 {
    public static final xv g;
    public static volatile q50 h;
    public dw d;
    public uv e;
    public int f;

    static {
        xv xvVar = new xv();
        g = xvVar;
        xvVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return g;
            case 1:
                v50 v50Var = (v50) obj;
                xv xvVar = (xv) obj2;
                this.d = (dw) v50Var.e(this.d, xvVar.d);
                this.e = (uv) v50Var.e(this.e, xvVar.e);
                int i2 = this.f;
                boolean z = i2 != 0;
                int i3 = xvVar.f;
                this.f = v50Var.f(i2, i3, z, i3 != 0);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i4 = clVar.i();
                        if (i4 != 0) {
                            if (i4 == 10) {
                                dw dwVar = this.d;
                                cw cwVar = dwVar != null ? (cw) dwVar.k() : null;
                                dw dwVar2 = (dw) clVar.d(dw.g.c(), w00Var);
                                this.d = dwVar2;
                                if (cwVar != null) {
                                    cwVar.d(dwVar2);
                                    this.d = (dw) cwVar.b();
                                }
                            } else if (i4 == 18) {
                                uv uvVar = this.e;
                                tv tvVar = uvVar != null ? (tv) uvVar.k() : null;
                                uv uvVar2 = (uv) clVar.d(uv.e.c(), w00Var);
                                this.e = uvVar2;
                                if (tvVar != null) {
                                    tvVar.d(uvVar2);
                                    this.e = (uv) tvVar.b();
                                }
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
                return new xv();
            case 5:
                return new wv(g);
            case 6:
                break;
            case 7:
                if (h == null) {
                    synchronized (xv.class) {
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
        int iC = this.d != null ? dl.c(1, q()) : 0;
        uv uvVar = this.e;
        if (uvVar != null) {
            if (uvVar == null) {
                uvVar = uv.e;
            }
            iC += dl.c(2, uvVar);
        }
        int i2 = this.f;
        if (i2 != 0) {
            iC += dl.b(3, i2);
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        if (this.d != null) {
            dlVar.k(1, q());
        }
        uv uvVar = this.e;
        if (uvVar != null) {
            if (uvVar == null) {
                uvVar = uv.e;
            }
            dlVar.k(2, uvVar);
        }
        int i = this.f;
        if (i != 0) {
            dlVar.i(3, i);
        }
    }

    public final int p() {
        int i = this.f;
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                i2 = 3;
                if (i != 2) {
                    i2 = i != 3 ? 0 : 4;
                }
            } else {
                i2 = 2;
            }
        }
        if (i2 == 0) {
            return 5;
        }
        return i2;
    }

    public final dw q() {
        dw dwVar = this.d;
        return dwVar == null ? dw.g : dwVar;
    }
}
