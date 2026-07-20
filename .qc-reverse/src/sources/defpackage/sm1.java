package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sm1 implements Serializable {
    public static final sm1 d = new sm1(tl1.d, tl1.c);
    public final tl1 b;
    public final tl1 c;

    public sm1(tl1 tl1Var, tl1 tl1Var2) {
        this.b = tl1Var;
        this.c = tl1Var2;
        if (tl1Var.a(tl1Var2) > 0 || tl1Var == tl1.c || tl1Var2 == tl1.d) {
            StringBuilder sb = new StringBuilder(16);
            tl1Var.b(sb);
            sb.append("..");
            tl1Var2.c(sb);
            zy.n("Invalid range: ".concat(sb.toString()));
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof sm1)) {
            return false;
        }
        sm1 sm1Var = (sm1) obj;
        return this.b.equals(sm1Var.b) && this.c.equals(sm1Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(16);
        this.b.b(sb);
        sb.append("..");
        this.c.c(sb);
        return sb.toString();
    }
}
