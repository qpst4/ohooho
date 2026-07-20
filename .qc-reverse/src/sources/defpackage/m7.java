package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m7 extends qp0 {
    public final /* synthetic */ int c = 1;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public m7(ra raVar, ra raVar2, ra raVar3, ra raVar4) throws NoSuchMethodException {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls.getMethod("get", null);
            method2 = cls.getMethod("open", String.class);
            method = cls.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.h = new l7(method3, method2, method);
        this.d = raVar;
        this.e = raVar2;
        this.f = raVar3;
        this.g = raVar4;
    }

    public static boolean n(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
            } catch (NoSuchMethodException unused2) {
                return true;
            }
        }
    }

    @Override // defpackage.qp0
    public void a(SSLSocket sSLSocket) {
        switch (this.c) {
            case 1:
                try {
                    try {
                        ((Method) this.f).invoke(null, sSLSocket);
                        return;
                    } catch (InvocationTargetException e) {
                        e = e;
                        throw be1.a("unable to remove alpn", e);
                    }
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    e = e2;
                    throw be1.a("unable to remove alpn", e);
                }
            default:
                return;
        }
    }

    @Override // defpackage.qp0
    public i1 c(X509TrustManager x509TrustManager) {
        switch (this.c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                } catch (Exception unused) {
                    return super.c(x509TrustManager);
                }
                break;
        }
        return super.c(x509TrustManager);
    }

    @Override // defpackage.qp0
    public ab1 d(X509TrustManager x509TrustManager) {
        switch (this.c) {
            case 0:
                try {
                    Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                    declaredMethod.setAccessible(true);
                    return new k7(x509TrustManager, declaredMethod);
                } catch (NoSuchMethodException unused) {
                    return new te(x509TrustManager.getAcceptedIssuers());
                }
            default:
                return super.d(x509TrustManager);
        }
    }

    @Override // defpackage.qp0
    public final void f(SSLSocket sSLSocket, String str, List list) {
        int i = this.c;
        Object obj = this.d;
        Object obj2 = this.g;
        switch (i) {
            case 0:
                ra raVar = (ra) obj2;
                if (str != null) {
                    ((ra) obj).J(sSLSocket, Boolean.TRUE);
                    ((ra) this.e).J(sSLSocket, str);
                }
                if (raVar == null || raVar.C(sSLSocket.getClass()) == null) {
                    return;
                }
                mh mhVar = new mh();
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    vr0 vr0Var = (vr0) list.get(i2);
                    if (vr0Var != vr0.c) {
                        mhVar.w(vr0Var.b.length());
                        String str2 = vr0Var.b;
                        mhVar.A(0, str2.length(), str2);
                    }
                }
                try {
                    try {
                        raVar.I(sSLSocket, mhVar.q(mhVar.c));
                        return;
                    } catch (InvocationTargetException e) {
                        Throwable targetException = e.getTargetException();
                        if (targetException instanceof RuntimeException) {
                            throw ((RuntimeException) targetException);
                        }
                        AssertionError assertionError = new AssertionError("Unexpected exception");
                        assertionError.initCause(targetException);
                        throw assertionError;
                    }
                } catch (EOFException e2) {
                    throw new AssertionError(e2);
                }
            default:
                try {
                    try {
                        ((Method) obj).invoke(null, sSLSocket, Proxy.newProxyInstance(qp0.class.getClassLoader(), new Class[]{(Class) obj2, (Class) this.h}, new xc0(qp0.b(list))));
                        return;
                    } catch (IllegalAccessException e3) {
                        e = e3;
                        throw be1.a("unable to set alpn", e);
                    }
                } catch (IllegalAccessException | InvocationTargetException e4) {
                    e = e4;
                }
                break;
        }
    }

    @Override // defpackage.qp0
    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        switch (this.c) {
            case 0:
                try {
                    socket.connect(inetSocketAddress, i);
                    return;
                } catch (AssertionError e) {
                    if (!be1.m(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (ClassCastException e2) {
                    if (Build.VERSION.SDK_INT != 26) {
                        throw e2;
                    }
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e2);
                    throw iOException;
                } catch (SecurityException e3) {
                    IOException iOException2 = new IOException("Exception in connect");
                    iOException2.initCause(e3);
                    throw iOException2;
                }
            default:
                super.g(socket, inetSocketAddress, i);
                return;
        }
    }

    @Override // defpackage.qp0
    public SSLContext h() {
        switch (this.c) {
            case 0:
                try {
                    return SSLContext.getInstance("TLS");
                } catch (NoSuchAlgorithmException e) {
                    throw new IllegalStateException("No TLS provider", e);
                }
            default:
                return super.h();
        }
    }

    @Override // defpackage.qp0
    public final String i(SSLSocket sSLSocket) {
        switch (this.c) {
            case 0:
                ra raVar = (ra) this.f;
                if (raVar == null || raVar.C(sSLSocket.getClass()) == null) {
                    return null;
                }
                try {
                    byte[] bArr = (byte[]) raVar.I(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, be1.d);
                    }
                    return null;
                } catch (InvocationTargetException e) {
                    Throwable targetException = e.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            default:
                try {
                    try {
                        xc0 xc0Var = (xc0) Proxy.getInvocationHandler(((Method) this.e).invoke(null, sSLSocket));
                        boolean z = xc0Var.b;
                        if (!z && xc0Var.c == null) {
                            qp0.a.l(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                            return null;
                        }
                        if (z) {
                            return null;
                        }
                        return xc0Var.c;
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        e = e2;
                        throw be1.a("unable to get selected protocol", e);
                    }
                } catch (IllegalAccessException e3) {
                    e = e3;
                    throw be1.a("unable to get selected protocol", e);
                }
        }
    }

    @Override // defpackage.qp0
    public Object j() {
        switch (this.c) {
            case 0:
                l7 l7Var = (l7) this.h;
                Method method = l7Var.a;
                if (method == null) {
                    return null;
                }
                try {
                    Object objInvoke = method.invoke(null, null);
                    l7Var.b.invoke(objInvoke, "response.body().close()");
                    return objInvoke;
                } catch (Exception unused) {
                    return null;
                }
            default:
                return super.j();
        }
    }

    @Override // defpackage.qp0
    public boolean k(String str) {
        switch (this.c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                    return n(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    return true;
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw be1.a("unable to determine cleartext support", e);
                }
            default:
                return super.k(str);
        }
    }

    @Override // defpackage.qp0
    public void l(int i, String str, Throwable th) {
        int iMin;
        switch (this.c) {
            case 0:
                int i2 = i != 5 ? 3 : 5;
                if (th != null) {
                    str = str + '\n' + Log.getStackTraceString(th);
                }
                int length = str.length();
                int i3 = 0;
                while (i3 < length) {
                    int iIndexOf = str.indexOf(10, i3);
                    if (iIndexOf == -1) {
                        iIndexOf = length;
                    }
                    while (true) {
                        iMin = Math.min(iIndexOf, i3 + 4000);
                        Log.println(i2, "OkHttp", str.substring(i3, iMin));
                        if (iMin < iIndexOf) {
                            i3 = iMin;
                        }
                        break;
                    }
                    i3 = iMin + 1;
                }
                break;
            default:
                super.l(i, str, th);
                break;
        }
    }

    @Override // defpackage.qp0
    public void m(String str, Object obj) {
        switch (this.c) {
            case 0:
                l7 l7Var = (l7) this.h;
                l7Var.getClass();
                if (obj != null) {
                    try {
                        l7Var.c.invoke(obj, null);
                        break;
                    } catch (Exception unused) {
                    }
                }
                l(5, str, null);
                break;
            default:
                super.m(str, obj);
                break;
        }
    }

    public m7(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }
}
