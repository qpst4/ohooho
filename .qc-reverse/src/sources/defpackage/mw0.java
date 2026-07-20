package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mw0 implements dc0 {
    public final sn0 a;
    public volatile u21 b;
    public Object c;
    public volatile boolean d;

    public mw0(sn0 sn0Var) {
        this.a = sn0Var;
    }

    public static boolean e(hw0 hw0Var, ga0 ga0Var) {
        ga0 ga0Var2 = hw0Var.b.a;
        return ga0Var2.d.equals(ga0Var.d) && ga0Var2.e == ga0Var.e && ga0Var2.a.equals(ga0Var.a);
    }

    @Override // defpackage.dc0
    public final hw0 a(jt0 jt0Var) throws IOException {
        hw0 hw0VarA;
        mv0 mv0VarC;
        ca0 ca0Var;
        mv0 mv0Var = jt0Var.f;
        ht0 ht0Var = jt0Var.g;
        c70 c70Var = jt0Var.h;
        u21 u21Var = new u21(this.a.q, b(mv0Var.a), ht0Var, c70Var, this.c);
        this.b = u21Var;
        u21 u21Var2 = u21Var;
        int i = 0;
        hw0 hw0Var = null;
        mv0 mv0Var2 = mv0Var;
        while (!this.d) {
            try {
                try {
                    hw0VarA = jt0Var.a(mv0Var2, u21Var2, null, null);
                    if (hw0Var != null) {
                        gw0 gw0VarG = hw0VarA.g();
                        gw0 gw0VarG2 = hw0Var.g();
                        gw0VarG2.g = null;
                        hw0 hw0VarA2 = gw0VarG2.a();
                        if (hw0VarA2.h != null) {
                            zy.n("priorResponse.body != null");
                            return null;
                        }
                        gw0VarG.j = hw0VarA2;
                        hw0VarA = gw0VarG.a();
                    }
                    try {
                        mv0VarC = c(hw0VarA, u21Var2.c);
                    } catch (IOException e) {
                        u21Var2.f();
                        throw e;
                    }
                } catch (IOException e2) {
                    if (!d(e2, u21Var2, !(e2 instanceof ym), mv0Var2)) {
                        throw e2;
                    }
                } catch (vw0 e3) {
                    if (!d(e3.c, u21Var2, false, mv0Var2)) {
                        throw e3.b;
                    }
                }
                if (mv0VarC == null) {
                    u21Var2.f();
                    return hw0VarA;
                }
                be1.c(hw0VarA.h);
                int i2 = i + 1;
                if (i2 > 20) {
                    u21Var2.f();
                    throw new ProtocolException(qq0.i("Too many follow-up requests: ", i2));
                }
                if (e(hw0VarA, mv0VarC.a)) {
                    synchronized (u21Var2.d) {
                        ca0Var = u21Var2.n;
                    }
                    if (ca0Var != null) {
                        zy.e(hw0VarA, " didn't close its backing stream. Bad interceptor?", "Closing the body of ");
                        return null;
                    }
                } else {
                    u21Var2.f();
                    u21 u21Var3 = new u21(this.a.q, b(mv0VarC.a), ht0Var, c70Var, this.c);
                    this.b = u21Var3;
                    u21Var2 = u21Var3;
                }
                hw0Var = hw0VarA;
                mv0Var2 = mv0VarC;
                i = i2;
            } catch (Throwable th) {
                u21Var2.g(null);
                u21Var2.f();
                throw th;
            }
        }
        u21Var2.f();
        zy.p("Canceled");
        return null;
    }

    public final n4 b(ga0 ga0Var) {
        SSLSocketFactory sSLSocketFactory;
        rn0 rn0Var;
        yi yiVar;
        boolean zEquals = ga0Var.a.equals("https");
        sn0 sn0Var = this.a;
        if (zEquals) {
            sSLSocketFactory = sn0Var.k;
            rn0Var = sn0Var.m;
            yiVar = sn0Var.n;
        } else {
            sSLSocketFactory = null;
            rn0Var = null;
            yiVar = null;
        }
        return new n4(ga0Var.d, ga0Var.e, sn0Var.r, sn0Var.j, sSLSocketFactory, rn0Var, yiVar, sn0Var.o, sn0Var.c, sn0Var.d, sn0Var.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.mv0 c(defpackage.hw0 r12, defpackage.uw0 r13) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mw0.c(hw0, uw0):mv0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        if (r3 == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.io.IOException r1, defpackage.u21 r2, boolean r3, defpackage.mv0 r4) {
        /*
            r0 = this;
            r2.g(r1)
            sn0 r0 = r0.a
            boolean r0 = r0.u
            r4 = 0
            if (r0 != 0) goto Lb
            goto L27
        Lb:
            boolean r0 = r1 instanceof java.net.ProtocolException
            if (r0 == 0) goto L10
            return r4
        L10:
            boolean r0 = r1 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L1b
            boolean r0 = r1 instanceof java.net.SocketTimeoutException
            if (r0 == 0) goto L27
            if (r3 != 0) goto L27
            goto L2d
        L1b:
            boolean r0 = r1 instanceof javax.net.ssl.SSLHandshakeException
            if (r0 == 0) goto L28
            java.lang.Throwable r0 = r1.getCause()
            boolean r0 = r0 instanceof java.security.cert.CertificateException
            if (r0 == 0) goto L28
        L27:
            return r4
        L28:
            boolean r0 = r1 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r0 == 0) goto L2d
            return r4
        L2d:
            uw0 r0 = r2.c
            if (r0 != 0) goto L59
            jl1 r0 = r2.b
            if (r0 == 0) goto L42
            int r1 = r0.b
            java.lang.Object r0 = r0.c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r1 >= r0) goto L42
            goto L59
        L42:
            ww0 r0 = r2.h
            int r1 = r0.e
            java.util.List r2 = r0.d
            int r2 = r2.size()
            if (r1 >= r2) goto L4f
            goto L59
        L4f:
            java.util.ArrayList r0 = r0.g
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L58
            goto L59
        L58:
            return r4
        L59:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mw0.d(java.io.IOException, u21, boolean, mv0):boolean");
    }
}
