package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j7 extends i1 {
    public final Object p;
    public final Method q;

    public j7(Object obj, Method method) {
        super(8);
        this.p = obj;
        this.q = method;
    }

    public final boolean equals(Object obj) {
        return obj instanceof j7;
    }

    @Override // defpackage.i1
    public final List h(String str, List list) throws SSLPeerUnverifiedException {
        try {
            return (List) this.q.invoke(this.p, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public final int hashCode() {
        return 0;
    }
}
