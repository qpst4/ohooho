package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j90 implements ca0 {
    public static final List f = be1.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List g = be1.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public final jt0 a;
    public final u21 b;
    public final u90 c;
    public aa0 d;
    public final vr0 e;

    public j90(sn0 sn0Var, jt0 jt0Var, u21 u21Var, u90 u90Var) {
        this.a = jt0Var;
        this.b = u21Var;
        this.c = u90Var;
        List list = sn0Var.c;
        vr0 vr0Var = vr0.g;
        this.e = list.contains(vr0Var) ? vr0Var : vr0.f;
    }

    @Override // defpackage.ca0
    public final void a(mv0 mv0Var) {
        int i;
        aa0 aa0Var;
        if (this.d != null) {
            return;
        }
        mv0Var.getClass();
        w70 w70Var = mv0Var.c;
        ArrayList arrayList = new ArrayList(w70Var.d() + 4);
        arrayList.add(new v70(v70.f, mv0Var.b));
        ai aiVar = v70.g;
        ga0 ga0Var = mv0Var.a;
        String str = ga0Var.h;
        int iIndexOf = str.indexOf(47, ga0Var.a.length() + 3);
        String strSubstring = str.substring(iIndexOf, be1.g(iIndexOf, str.length(), str, "?#"));
        String strE = ga0Var.e();
        if (strE != null) {
            strSubstring = strSubstring + '?' + strE;
        }
        arrayList.add(new v70(aiVar, strSubstring));
        String strA = mv0Var.c.a("Host");
        if (strA != null) {
            arrayList.add(new v70(v70.i, strA));
        }
        arrayList.add(new v70(v70.h, ga0Var.a));
        int iD = w70Var.d();
        for (int i2 = 0; i2 < iD; i2++) {
            ai aiVarC = ai.c(w70Var.b(i2).toLowerCase(Locale.US));
            if (!f.contains(aiVarC.l())) {
                arrayList.add(new v70(aiVarC, w70Var.e(i2)));
            }
        }
        u90 u90Var = this.c;
        boolean z = !false;
        synchronized (u90Var.s) {
            synchronized (u90Var) {
                try {
                    if (u90Var.g > 1073741823) {
                        u90Var.r(5);
                    }
                    if (u90Var.h) {
                        throw new ym();
                    }
                    i = u90Var.g;
                    u90Var.g = i + 2;
                    aa0Var = new aa0(i, u90Var, z, false, null);
                    if (aa0Var.g()) {
                        u90Var.d.put(Integer.valueOf(i), aa0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ba0 ba0Var = u90Var.s;
            synchronized (ba0Var) {
                if (ba0Var.f) {
                    throw new IOException("closed");
                }
                ba0Var.m(z, i, arrayList);
            }
        }
        u90Var.s.flush();
        this.d = aa0Var;
        aa0Var.i.g(this.a.j);
        this.d.j.g(this.a.k);
    }

    @Override // defpackage.ca0
    public final void b() {
        this.d.e().close();
    }

    @Override // defpackage.ca0
    public final void c() {
        this.c.flush();
    }

    @Override // defpackage.ca0
    public final void cancel() {
        aa0 aa0Var = this.d;
        if (aa0Var == null || !aa0Var.d(6)) {
            return;
        }
        aa0Var.d.u(aa0Var.c, 6);
    }

    @Override // defpackage.ca0
    public final c11 d(mv0 mv0Var, long j) {
        return this.d.e();
    }

    @Override // defpackage.ca0
    public final kt0 e(hw0 hw0Var) {
        this.b.f.getClass();
        hw0Var.a("Content-Type");
        long jA = ea0.a(hw0Var);
        i90 i90Var = new i90(this, this.d.g);
        Logger logger = tn0.a;
        return new kt0(jA, new gt0(i90Var), 0);
    }

    @Override // defpackage.ca0
    public final gw0 f(boolean z) throws ProtocolException {
        w70 w70Var;
        aa0 aa0Var = this.d;
        synchronized (aa0Var) {
            aa0Var.i.i();
            while (aa0Var.e.isEmpty() && aa0Var.k == 0) {
                try {
                    try {
                        aa0Var.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    aa0Var.i.n();
                    throw th;
                }
            }
            aa0Var.i.n();
            if (aa0Var.e.isEmpty()) {
                throw new v21(aa0Var.k);
            }
            w70Var = (w70) aa0Var.e.removeFirst();
        }
        vr0 vr0Var = this.e;
        ArrayList arrayList = new ArrayList(20);
        int iD = w70Var.d();
        f9 f9VarG = null;
        for (int i = 0; i < iD; i++) {
            String strB = w70Var.b(i);
            String strE = w70Var.e(i);
            if (strB.equals(":status")) {
                f9VarG = f9.g("HTTP/1.1 " + strE);
            } else if (!g.contains(strB)) {
                c70.l.getClass();
                arrayList.add(strB);
                arrayList.add(strE.trim());
            }
        }
        if (f9VarG == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        gw0 gw0Var = new gw0();
        gw0Var.b = vr0Var;
        gw0Var.c = f9VarG.b;
        gw0Var.d = (String) f9VarG.d;
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        jj jjVar = new jj(1);
        Collections.addAll(jjVar.b, strArr);
        gw0Var.f = jjVar;
        if (z) {
            c70.l.getClass();
            if (gw0Var.c == 100) {
                return null;
            }
        }
        return gw0Var;
    }
}
