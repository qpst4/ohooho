package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t50 implements v50 {
    public int a;

    @Override // defpackage.v50
    public final zh a(boolean z, zh zhVar, boolean z2, zh zhVar2) {
        this.a = zhVar.hashCode() + (this.a * 53);
        return zhVar;
    }

    @Override // defpackage.v50
    public final String b(boolean z, String str, boolean z2, String str2) {
        this.a = str.hashCode() + (this.a * 53);
        return str;
    }

    @Override // defpackage.v50
    public final sr0 c(sr0 sr0Var, sr0 sr0Var2) {
        this.a = sr0Var.hashCode() + (this.a * 53);
        return sr0Var;
    }

    @Override // defpackage.v50
    public final boolean d(boolean z, boolean z2, boolean z3, boolean z4) {
        int i = this.a * 53;
        Charset charset = ec0.a;
        this.a = i + (z2 ? 1231 : 1237);
        return z2;
    }

    @Override // defpackage.v50
    public final w50 e(w50 w50Var, w50 w50Var2) {
        int iHashCode;
        if (w50Var == null) {
            iHashCode = 37;
        } else if (w50Var instanceof w50) {
            if (w50Var.a == 0) {
                int i = this.a;
                this.a = 0;
                w50Var.n(this, w50Var);
                w50Var.a = this.a;
                this.a = i;
            }
            iHashCode = w50Var.a;
        } else {
            iHashCode = w50Var.hashCode();
        }
        this.a = (this.a * 53) + iHashCode;
        return w50Var;
    }

    @Override // defpackage.v50
    public final int f(int i, int i2, boolean z, boolean z2) {
        this.a = (this.a * 53) + i;
        return i;
    }

    @Override // defpackage.v50
    public final cd1 g(cd1 cd1Var, cd1 cd1Var2) {
        this.a = cd1Var.hashCode() + (this.a * 53);
        return cd1Var;
    }
}
