package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k7 implements ab1 {
    public final X509TrustManager a;
    public final Method b;

    public k7(X509TrustManager x509TrustManager, Method method) {
        this.b = method;
        this.a = x509TrustManager;
    }

    @Override // defpackage.ab1
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
            return null;
        } catch (IllegalAccessException e) {
            throw be1.a("unable to get issues and signature", e);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k7)) {
            return false;
        }
        k7 k7Var = (k7) obj;
        return this.a.equals(k7Var.a) && this.b.equals(k7Var.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }
}
