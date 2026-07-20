package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nj1 {
    public final w7 a;
    public final l10 b;

    public /* synthetic */ nj1(w7 w7Var, l10 l10Var) {
        this.a = w7Var;
        this.b = l10Var;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof nj1)) {
            return false;
        }
        nj1 nj1Var = (nj1) obj;
        return xy0.o(this.a, nj1Var.a) && xy0.o(this.b, nj1Var.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        pn0 pn0Var = new pn0(this);
        pn0Var.a("key", this.a);
        pn0Var.a("feature", this.b);
        return pn0Var.toString();
    }
}
