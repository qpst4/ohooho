package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uv extends w50 {
    public static final uv e;
    public static volatile q50 f;
    public je0 d;

    static {
        uv uvVar = new uv();
        e = uvVar;
        uvVar.g();
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i, Object obj2) {
        switch (l11.r(i)) {
            case 0:
                return e;
            case 1:
                this.d = (je0) ((v50) obj).e(this.d, ((uv) obj2).d);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int i2 = clVar.i();
                        if (i2 != 0) {
                            if (i2 == 18) {
                                je0 je0Var = this.d;
                                ie0 ie0Var = je0Var != null ? (ie0) je0Var.k() : null;
                                je0 je0Var2 = (je0) clVar.d(je0.g.c(), w00Var);
                                this.d = je0Var2;
                                if (ie0Var != null) {
                                    ie0Var.d(je0Var2);
                                    this.d = (je0) ie0Var.b();
                                }
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
                return new uv();
            case 5:
                return new tv(e);
            case 6:
                break;
            case 7:
                if (f == null) {
                    synchronized (uv.class) {
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
        int iC;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        je0 je0Var = this.d;
        if (je0Var != null) {
            if (je0Var == null) {
                je0Var = je0.g;
            }
            iC = dl.c(2, je0Var);
        } else {
            iC = 0;
        }
        this.c = iC;
        return iC;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        je0 je0Var = this.d;
        if (je0Var != null) {
            if (je0Var == null) {
                je0Var = je0.g;
            }
            dlVar.k(2, je0Var);
        }
    }
}
