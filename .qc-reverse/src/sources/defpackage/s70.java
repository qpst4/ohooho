package defpackage;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s70 {
    public final g61 a;
    public final jk b;
    public final List c;
    public final List d;

    public s70(g61 g61Var, jk jkVar, List list, List list2) {
        this.a = g61Var;
        this.b = jkVar;
        this.c = list;
        this.d = list2;
    }

    public static s70 a(SSLSession sSLSession) throws IOException {
        String cipherSuite = sSLSession.getCipherSuite();
        Certificate[] peerCertificates = null;
        if (cipherSuite == null) {
            s1.f("cipherSuite == null");
            return null;
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            zy.p("cipherSuite == SSL_NULL_WITH_NULL_NULL");
            return null;
        }
        jk jkVarA = jk.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            s1.f("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            zy.p("tlsVersion == NONE");
            return null;
        }
        g61 g61VarA = g61.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
        }
        List listK = peerCertificates != null ? be1.k(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new s70(g61VarA, jkVarA, listK, localCertificates != null ? be1.k(localCertificates) : Collections.EMPTY_LIST);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s70) {
            s70 s70Var = (s70) obj;
            if (this.a.equals(s70Var.a) && this.b == s70Var.b && this.c.equals(s70Var.c) && this.d.equals(s70Var.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
