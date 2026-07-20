package defpackage;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qp0 {
    public static final qp0 a;
    public static final Logger b;

    static {
        qp0 qp0Var;
        ra raVar;
        ra raVar2;
        Class<byte[]> cls = byte[].class;
        m7 m7Var = null;
        try {
            try {
                Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                qp0Var = null;
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        int i = 15;
        ra raVar3 = new ra(m7Var, "setUseSessionTickets", new Class[]{Boolean.TYPE}, i);
        ra raVar4 = new ra(m7Var, "setHostname", new Class[]{String.class}, i);
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            raVar = new ra(cls, "getAlpnSelectedProtocol", new Class[0], i);
            raVar2 = new ra(m7Var, "setAlpnProtocols", new Class[]{byte[].class}, i);
            qp0Var = new m7(raVar3, raVar4, raVar, raVar2);
        } else {
            try {
                Class.forName("android.net.Network");
                raVar = new ra(cls, "getAlpnSelectedProtocol", new Class[0], i);
                raVar2 = new ra(m7Var, "setAlpnProtocols", new Class[]{byte[].class}, i);
            } catch (ClassNotFoundException unused3) {
                raVar = null;
                raVar2 = null;
            }
            qp0Var = new m7(raVar3, raVar4, raVar, raVar2);
        }
        if (qp0Var == null) {
            if (!("conscrypt".equals(System.getProperty("okhttp.platform")) ? true : "Conscrypt".equals(Security.getProviders()[0].getName())) || (qp0Var = cn.n()) == null) {
                try {
                    qp0Var = new wc0(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
                } catch (NoSuchMethodException unused4) {
                    qp0Var = null;
                }
                if (qp0Var == null) {
                    try {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        m7Var = new m7(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                    } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    }
                    qp0Var = m7Var != null ? m7Var : new qp0();
                }
            }
        }
        a = qp0Var;
        b = Logger.getLogger(sn0.class.getName());
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            vr0 vr0Var = (vr0) list.get(i);
            if (vr0Var != vr0.c) {
                arrayList.add(vr0Var.b);
            }
        }
        return arrayList;
    }

    public i1 c(X509TrustManager x509TrustManager) {
        return new re(d(x509TrustManager));
    }

    public ab1 d(X509TrustManager x509TrustManager) {
        return new te(x509TrustManager.getAcceptedIssuers());
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public SSLContext h() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String i(SSLSocket sSLSocket) {
        return null;
    }

    public Object j() {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean k(String str) {
        return true;
    }

    public void l(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void m(String str, Object obj) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        l(5, str, (Throwable) obj);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void e(SSLSocketFactory sSLSocketFactory) {
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
    }
}
