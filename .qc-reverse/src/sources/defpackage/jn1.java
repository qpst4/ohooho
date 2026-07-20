package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jn1 extends tk0 {
    @Override // defpackage.tk0
    public final gn1 S(on1 on1Var) {
        gn1 gn1Var;
        gn1 gn1Var2 = gn1.d;
        synchronized (on1Var) {
            try {
                gn1Var = on1Var.c;
                if (gn1Var != gn1Var2) {
                    on1Var.c = gn1Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gn1Var;
    }

    @Override // defpackage.tk0
    public final nn1 T(on1 on1Var) {
        nn1 nn1Var;
        nn1 nn1Var2 = nn1.c;
        synchronized (on1Var) {
            try {
                nn1Var = on1Var.d;
                if (nn1Var != nn1Var2) {
                    on1Var.d = nn1Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nn1Var;
    }

    @Override // defpackage.tk0
    public final void W(nn1 nn1Var, nn1 nn1Var2) {
        nn1Var.b = nn1Var2;
    }

    @Override // defpackage.tk0
    public final void X(nn1 nn1Var, Thread thread) {
        nn1Var.a = thread;
    }

    @Override // defpackage.tk0
    public final boolean Y(on1 on1Var, gn1 gn1Var, gn1 gn1Var2) {
        synchronized (on1Var) {
            try {
                if (on1Var.c != gn1Var) {
                    return false;
                }
                on1Var.c = gn1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.tk0
    public final boolean Z(on1 on1Var, Object obj, Object obj2) {
        synchronized (on1Var) {
            try {
                if (on1Var.b != obj) {
                    return false;
                }
                on1Var.b = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.tk0
    public final boolean a0(on1 on1Var, nn1 nn1Var, nn1 nn1Var2) {
        synchronized (on1Var) {
            try {
                if (on1Var.d != nn1Var) {
                    return false;
                }
                on1Var.d = nn1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
