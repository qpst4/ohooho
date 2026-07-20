package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xc {
    public final lr1 a;

    public xc(lr1 lr1Var) {
        this.a = lr1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xc) || !this.a.equals(((xc) obj).a)) {
            return false;
        }
        Object obj2 = tq0.b;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ (1000003 * 1000003)) * 1000003) ^ tq0.b.hashCode();
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.a + ", priority=" + tq0.b + "}";
    }
}
