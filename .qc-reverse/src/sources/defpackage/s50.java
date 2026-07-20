package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s50 implements v50 {
    public static final s50 a = new s50();
    public static final r50 b = new r50();

    @Override // defpackage.v50
    public final zh a(boolean z, zh zhVar, boolean z2, zh zhVar2) {
        if (z == z2 && zhVar.equals(zhVar2)) {
            return zhVar;
        }
        throw b;
    }

    @Override // defpackage.v50
    public final String b(boolean z, String str, boolean z2, String str2) {
        if (z == z2 && str.equals(str2)) {
            return str;
        }
        throw b;
    }

    @Override // defpackage.v50
    public final sr0 c(sr0 sr0Var, sr0 sr0Var2) {
        if (sr0Var.equals(sr0Var2)) {
            return sr0Var;
        }
        throw b;
    }

    @Override // defpackage.v50
    public final boolean d(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z == z3 && z2 == z4) {
            return z2;
        }
        throw b;
    }

    @Override // defpackage.v50
    public final w50 e(w50 w50Var, w50 w50Var2) {
        if (w50Var == null && w50Var2 == null) {
            return null;
        }
        if (w50Var == null || w50Var2 == null) {
            throw b;
        }
        if (w50Var == w50Var2 || !((w50) w50Var.b(null, 7, null)).getClass().isInstance(w50Var2)) {
            return w50Var;
        }
        w50Var.n(this, w50Var2);
        return w50Var;
    }

    @Override // defpackage.v50
    public final int f(int i, int i2, boolean z, boolean z2) {
        if (z == z2 && i == i2) {
            return i;
        }
        throw b;
    }

    @Override // defpackage.v50
    public final cd1 g(cd1 cd1Var, cd1 cd1Var2) {
        if (cd1Var.equals(cd1Var2)) {
            return cd1Var;
        }
        throw b;
    }
}
