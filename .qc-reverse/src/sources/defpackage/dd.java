package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dd extends um0 {
    public final tm0 a;
    public final sm0 b;

    public dd(tm0 tm0Var, sm0 sm0Var) {
        this.a = tm0Var;
        this.b = sm0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof um0) {
            um0 um0Var = (um0) obj;
            tm0 tm0Var = this.a;
            if (tm0Var != null ? tm0Var.equals(((dd) um0Var).a) : ((dd) um0Var).a == null) {
                sm0 sm0Var = this.b;
                if (sm0Var != null ? sm0Var.equals(((dd) um0Var).b) : ((dd) um0Var).b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        tm0 tm0Var = this.a;
        int iHashCode = ((tm0Var == null ? 0 : tm0Var.hashCode()) ^ 1000003) * 1000003;
        sm0 sm0Var = this.b;
        return iHashCode ^ (sm0Var != null ? sm0Var.hashCode() : 0);
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }
}
