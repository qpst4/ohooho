package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uw0 {
    public final n4 a;
    public final Proxy b;
    public final InetSocketAddress c;

    public uw0(n4 n4Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (n4Var == null) {
            zy.r("address == null");
            throw null;
        }
        if (inetSocketAddress == null) {
            zy.r("inetSocketAddress == null");
            throw null;
        }
        this.a = n4Var;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof uw0)) {
            return false;
        }
        uw0 uw0Var = (uw0) obj;
        return uw0Var.a.equals(this.a) && uw0Var.b.equals(this.b) && uw0Var.c.equals(this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + "}";
    }
}
