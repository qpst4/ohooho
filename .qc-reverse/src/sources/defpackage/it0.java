package defpackage;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class it0 extends q90 {
    public final wm b;
    public final uw0 c;
    public Socket d;
    public Socket e;
    public s70 f;
    public vr0 g;
    public u90 h;
    public gt0 i;
    public ft0 j;
    public boolean k;
    public int l;
    public int m = 1;
    public final ArrayList n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public it0(wm wmVar, uw0 uw0Var) {
        this.b = wmVar;
        this.c = uw0Var;
    }

    @Override // defpackage.q90
    public final void a(u90 u90Var) {
        synchronized (this.b) {
            this.m = u90Var.i();
        }
    }

    @Override // defpackage.q90
    public final void b(aa0 aa0Var) {
        aa0Var.c(5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        r9 = r8.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r9.a.h == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
    
        if (r9.b.type() != java.net.Proxy.Type.HTTP) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
    
        if (r8.d == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
    
        throw new defpackage.vw0(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
    
        if (r8.h == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
    
        r9 = r8.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
    
        monitor-enter(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b2, code lost:
    
        r8.m = r8.h.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ba, code lost:
    
        monitor-exit(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bf, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r9, int r10, int r11, boolean r12, defpackage.c70 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.it0.c(int, int, int, boolean, c70):void");
    }

    public final void d(int i, int i2, c70 c70Var) throws IOException {
        uw0 uw0Var = this.c;
        Proxy proxy = uw0Var.b;
        InetSocketAddress inetSocketAddress = uw0Var.c;
        this.d = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? uw0Var.a.c.createSocket() : new Socket(proxy);
        c70Var.getClass();
        this.d.setSoTimeout(i2);
        try {
            qp0.a.g(this.d, inetSocketAddress, i);
            try {
                this.i = new gt0(tn0.b(this.d));
                this.j = new ft0(tn0.a(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void e(int i, int i2, int i3, c70 c70Var) throws IOException {
        g7 g7Var = new g7(11);
        uw0 uw0Var = this.c;
        n4 n4Var = uw0Var.a;
        n4 n4Var2 = uw0Var.a;
        ga0 ga0Var = n4Var.a;
        if (ga0Var == null) {
            zy.r("url == null");
            return;
        }
        g7Var.c = ga0Var;
        g7Var.r("CONNECT", null);
        ((jj) g7Var.d).h("Host", be1.j(n4Var2.a, true));
        ((jj) g7Var.d).h("Proxy-Connection", "Keep-Alive");
        ((jj) g7Var.d).h("User-Agent", "okhttp/3.12.1");
        mv0 mv0VarC = g7Var.c();
        gw0 gw0Var = new gw0();
        gw0Var.a = mv0VarC;
        gw0Var.b = vr0.d;
        gw0Var.c = 407;
        gw0Var.d = "Preemptive Authenticate";
        gw0Var.g = be1.c;
        gw0Var.k = -1L;
        gw0Var.l = -1L;
        gw0Var.f.h("Proxy-Authenticate", "OkHttp-Preemptive");
        gw0Var.a();
        n4Var2.d.getClass();
        ga0 ga0Var2 = mv0VarC.a;
        d(i, i2, c70Var);
        String str = "CONNECT " + be1.j(ga0Var2, true) + " HTTP/1.1";
        gt0 gt0Var = this.i;
        g90 g90Var = new g90(null, null, gt0Var, this.j);
        gt0Var.c.b().g(i2);
        this.j.c.b().g(i3);
        g90Var.i(mv0VarC.c, str);
        g90Var.b();
        gw0 gw0VarF = g90Var.f(false);
        gw0VarF.a = mv0VarC;
        hw0 hw0VarA = gw0VarF.a();
        int i4 = hw0VarA.d;
        long jA = ea0.a(hw0VarA);
        if (jA == -1) {
            jA = 0;
        }
        e90 e90VarG = g90Var.g(jA);
        be1.o(e90VarG, Integer.MAX_VALUE);
        e90VarG.close();
        if (i4 == 200) {
            if (this.i.b.h() && this.j.b.h()) {
                return;
            }
            zy.p("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i4 != 407) {
            zy.p(qq0.i("Unexpected response code for CONNECT: ", i4));
        } else {
            n4Var2.d.getClass();
            zy.p("Failed to authenticate with proxy");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(eg egVar, c70 c70Var) throws Throwable {
        String str;
        SSLSocket sSLSocket;
        uw0 uw0Var = this.c;
        n4 n4Var = uw0Var.a;
        SSLSocketFactory sSLSocketFactory = n4Var.h;
        vr0 vr0VarA = vr0.d;
        if (sSLSocketFactory == null) {
            List list = n4Var.e;
            vr0 vr0Var = vr0.g;
            boolean zContains = list.contains(vr0Var);
            Socket socket = this.d;
            if (!zContains) {
                this.e = socket;
                this.g = vr0VarA;
                return;
            } else {
                this.e = socket;
                this.g = vr0Var;
                i();
                return;
            }
        }
        c70Var.getClass();
        n4 n4Var2 = uw0Var.a;
        SSLSocketFactory sSLSocketFactory2 = n4Var2.h;
        ga0 ga0Var = n4Var2.a;
        SSLSocket sSLSocket2 = null;
        try {
            try {
                Socket socket2 = this.d;
                str = ga0Var.d;
                sSLSocket = (SSLSocket) sSLSocketFactory2.createSocket(socket2, str, ga0Var.e, true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean z = egVar.a(sSLSocket).b;
            if (z) {
                qp0.a.f(sSLSocket, str, n4Var2.e);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            s70 s70VarA = s70.a(session);
            List list2 = s70VarA.c;
            if (!n4Var2.i.verify(str, session)) {
                X509Certificate x509Certificate = (X509Certificate) list2.get(0);
                throw new SSLPeerUnverifiedException("Hostname " + str + " not verified:\n    certificate: " + yi.b(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + rn0.a(x509Certificate));
            }
            n4Var2.j.a(str, list2);
            String strI = z ? qp0.a.i(sSLSocket) : null;
            this.e = sSLSocket;
            this.i = new gt0(tn0.b(sSLSocket));
            this.j = new ft0(tn0.a(this.e));
            this.f = s70VarA;
            if (strI != null) {
                vr0VarA = vr0.a(strI);
            }
            this.g = vr0VarA;
            qp0.a.a(sSLSocket);
            if (this.g == vr0.f) {
                i();
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!be1.m(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                qp0.a.a(sSLSocket2);
            }
            be1.d(sSLSocket2);
            throw th;
        }
    }

    public final boolean g(n4 n4Var, uw0 uw0Var) {
        if (this.n.size() >= this.m || this.k) {
            return false;
        }
        c70 c70Var = c70.l;
        uw0 uw0Var2 = this.c;
        n4 n4Var2 = uw0Var2.a;
        c70Var.getClass();
        boolean zA = n4Var2.a(n4Var);
        ga0 ga0Var = n4Var.a;
        if (!zA) {
            return false;
        }
        if (ga0Var.d.equals(uw0Var2.a.a.d)) {
            return true;
        }
        if (this.h == null || uw0Var == null) {
            return false;
        }
        Proxy.Type type = uw0Var.b.type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || uw0Var2.b.type() != type2 || !uw0Var2.c.equals(uw0Var.c) || uw0Var.a.i != rn0.a || !j(ga0Var)) {
            return false;
        }
        try {
            n4Var.j.a(ga0Var.d, this.f.c);
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final ca0 h(sn0 sn0Var, jt0 jt0Var, u21 u21Var) throws SocketException {
        int i = jt0Var.j;
        if (this.h != null) {
            return new j90(sn0Var, jt0Var, u21Var, this.h);
        }
        this.e.setSoTimeout(i);
        this.i.c.b().g(i);
        this.j.c.b().g(jt0Var.k);
        return new g90(sn0Var, u21Var, this.i, this.j);
    }

    public final void i() throws SocketException {
        this.e.setSoTimeout(0);
        o90 o90Var = new o90();
        o90Var.g = q90.a;
        o90Var.b = true;
        Socket socket = this.e;
        String str = this.c.a.a.d;
        gt0 gt0Var = this.i;
        ft0 ft0Var = this.j;
        o90Var.c = socket;
        o90Var.d = str;
        o90Var.e = gt0Var;
        o90Var.f = ft0Var;
        o90Var.g = this;
        u90 u90Var = new u90(o90Var);
        this.h = u90Var;
        ba0 ba0Var = u90Var.s;
        synchronized (ba0Var) {
            try {
                if (ba0Var.f) {
                    throw new IOException("closed");
                }
                if (ba0Var.c) {
                    Logger logger = ba0.h;
                    if (logger.isLoggable(Level.FINE)) {
                        String strE = h90.a.e();
                        byte[] bArr = be1.a;
                        Locale locale = Locale.US;
                        logger.fine(">> CONNECTION " + strE);
                    }
                    ba0Var.b.write((byte[]) h90.a.b.clone());
                    ba0Var.b.flush();
                }
            } finally {
            }
        }
        ba0 ba0Var2 = u90Var.s;
        jl1 jl1Var = u90Var.o;
        synchronized (ba0Var2) {
            try {
                if (ba0Var2.f) {
                    throw new IOException("closed");
                }
                ba0Var2.h(0, Integer.bitCount(jl1Var.b) * 6, (byte) 4, (byte) 0);
                int i = 0;
                while (i < 10) {
                    if (((1 << i) & jl1Var.b) != 0) {
                        ba0Var2.b.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                        ba0Var2.b.writeInt(((int[]) jl1Var.c)[i]);
                    }
                    i++;
                }
                ba0Var2.b.flush();
            } finally {
            }
        }
        if (u90Var.o.d() != 65535) {
            u90Var.s.s(0, r8 - 65535);
        }
        new Thread(u90Var.t).start();
    }

    public final boolean j(ga0 ga0Var) {
        int i = ga0Var.e;
        String str = ga0Var.d;
        ga0 ga0Var2 = this.c.a.a;
        if (i == ga0Var2.e) {
            if (str.equals(ga0Var2.d)) {
                return true;
            }
            s70 s70Var = this.f;
            if (s70Var != null && rn0.c(str, (X509Certificate) s70Var.c.get(0))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        uw0 uw0Var = this.c;
        sb.append(uw0Var.a.a.d);
        sb.append(":");
        sb.append(uw0Var.a.a.e);
        sb.append(", proxy=");
        sb.append(uw0Var.b);
        sb.append(" hostAddress=");
        sb.append(uw0Var.c);
        sb.append(" cipherSuite=");
        s70 s70Var = this.f;
        sb.append(s70Var != null ? s70Var.b : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
