package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wr1 extends f01 {
    @Override // defpackage.f01
    public final void W(xr1 xr1Var, xr1 xr1Var2) {
        xr1Var.b = xr1Var2;
    }

    @Override // defpackage.f01
    public final void Y(xr1 xr1Var, Thread thread) {
        xr1Var.a = thread;
    }

    @Override // defpackage.f01
    public final boolean Z(as1 as1Var, fq1 fq1Var, fq1 fq1Var2) {
        synchronized (as1Var) {
            try {
                if (as1Var.c != fq1Var) {
                    return false;
                }
                as1Var.c = fq1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.f01
    public final boolean a0(as1 as1Var, Object obj, Object obj2) {
        synchronized (as1Var) {
            try {
                if (as1Var.b != obj) {
                    return false;
                }
                as1Var.b = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.f01
    public final boolean c0(as1 as1Var, xr1 xr1Var, xr1 xr1Var2) {
        synchronized (as1Var) {
            try {
                if (as1Var.d != xr1Var) {
                    return false;
                }
                as1Var.d = xr1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
