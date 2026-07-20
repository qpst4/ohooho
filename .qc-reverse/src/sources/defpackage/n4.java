package defpackage;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n4 {
    public final ga0 a;
    public final ix b;
    public final SocketFactory c;
    public final ix d;
    public final List e;
    public final List f;
    public final ProxySelector g;
    public final SSLSocketFactory h;
    public final HostnameVerifier i;
    public final yi j;

    public n4(String str, int i, ix ixVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, rn0 rn0Var, yi yiVar, ix ixVar2, List list, List list2, ProxySelector proxySelector) {
        fa0 fa0Var = new fa0();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            fa0Var.a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                zy.n("unexpected scheme: ".concat(str2));
                throw null;
            }
            fa0Var.a = "https";
        }
        if (str == null) {
            zy.r("host == null");
            throw null;
        }
        String strB = be1.b(ga0.g(str, 0, str.length(), false));
        if (strB == null) {
            zy.n("unexpected host: ".concat(str));
            throw null;
        }
        fa0Var.d = strB;
        if (i <= 0 || i > 65535) {
            zy.n(qq0.i("unexpected port: ", i));
            throw null;
        }
        fa0Var.e = i;
        this.a = fa0Var.a();
        if (ixVar == null) {
            zy.r("dns == null");
            throw null;
        }
        this.b = ixVar;
        if (socketFactory == null) {
            zy.r("socketFactory == null");
            throw null;
        }
        this.c = socketFactory;
        if (ixVar2 == null) {
            zy.r("proxyAuthenticator == null");
            throw null;
        }
        this.d = ixVar2;
        if (list == null) {
            zy.r("protocols == null");
            throw null;
        }
        this.e = Collections.unmodifiableList(new ArrayList(list));
        if (list2 == null) {
            zy.r("connectionSpecs == null");
            throw null;
        }
        this.f = Collections.unmodifiableList(new ArrayList(list2));
        if (proxySelector == null) {
            zy.r("proxySelector == null");
            throw null;
        }
        this.g = proxySelector;
        this.h = sSLSocketFactory;
        this.i = rn0Var;
        this.j = yiVar;
    }

    public final boolean a(n4 n4Var) {
        return this.b.equals(n4Var.b) && this.d.equals(n4Var.d) && this.e.equals(n4Var.e) && this.f.equals(n4Var.f) && this.g.equals(n4Var.g) && be1.i(null, null) && be1.i(this.h, n4Var.h) && be1.i(this.i, n4Var.i) && be1.i(this.j, n4Var.j) && this.a.e == n4Var.a.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n4)) {
            return false;
        }
        n4 n4Var = (n4) obj;
        return this.a.equals(n4Var.a) && a(n4Var);
    }

    public final int hashCode() {
        int iHashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.b.hashCode() + ((this.a.h.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 961;
        SSLSocketFactory sSLSocketFactory = this.h;
        int iHashCode2 = (iHashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.i;
        int iHashCode3 = (iHashCode2 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        yi yiVar = this.j;
        return iHashCode3 + (yiVar != null ? yiVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        ga0 ga0Var = this.a;
        sb.append(ga0Var.d);
        sb.append(":");
        sb.append(ga0Var.e);
        sb.append(", proxySelector=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
}
