package defpackage;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cn extends qp0 {
    public static cn n() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new cn();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Provider o() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // defpackage.qp0
    public final void e(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // defpackage.qp0
    public final void f(SSLSocket sSLSocket, String str, List list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) qp0.b(list).toArray(new String[0]));
        }
    }

    @Override // defpackage.qp0
    public final SSLContext h() {
        try {
            return SSLContext.getInstance("TLSv1.3", o());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", o());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // defpackage.qp0
    public final String i(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }
}
