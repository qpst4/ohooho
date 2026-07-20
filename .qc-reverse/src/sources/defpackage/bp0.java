package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bp0 implements Serializable {
    public final Object b;
    public final Object c;

    public bp0(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bp0)) {
            return false;
        }
        bp0 bp0Var = (bp0) obj;
        return fc0.b(this.b, bp0Var.b) && fc0.b(this.c, bp0Var.c);
    }

    public final int hashCode() {
        Object obj = this.b;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.c;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.b + ", " + this.c + ')';
    }
}
