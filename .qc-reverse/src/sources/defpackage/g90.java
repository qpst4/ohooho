package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g90 implements ca0 {
    public final sn0 a;
    public final u21 b;
    public final oh c;
    public final nh d;
    public int e = 0;
    public long f = 262144;

    public g90(sn0 sn0Var, u21 u21Var, gt0 gt0Var, ft0 ft0Var) {
        this.a = sn0Var;
        this.b = u21Var;
        this.c = gt0Var;
        this.d = ft0Var;
    }

    @Override // defpackage.ca0
    public final void a(mv0 mv0Var) {
        Proxy.Type type = this.b.a().c.b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(mv0Var.b);
        sb.append(' ');
        ga0 ga0Var = mv0Var.a;
        if (ga0Var.a.equals("https") || type != Proxy.Type.HTTP) {
            String str = ga0Var.h;
            int iIndexOf = str.indexOf(47, ga0Var.a.length() + 3);
            String strSubstring = str.substring(iIndexOf, be1.g(iIndexOf, str.length(), str, "?#"));
            String strE = ga0Var.e();
            if (strE != null) {
                strSubstring = strSubstring + '?' + strE;
            }
            sb.append(strSubstring);
        } else {
            sb.append(ga0Var);
        }
        sb.append(" HTTP/1.1");
        i(mv0Var.c, sb.toString());
    }

    @Override // defpackage.ca0
    public final void b() {
        this.d.flush();
    }

    @Override // defpackage.ca0
    public final void c() {
        this.d.flush();
    }

    @Override // defpackage.ca0
    public final void cancel() {
        it0 it0VarA = this.b.a();
        if (it0VarA != null) {
            be1.d(it0VarA.d);
        }
    }

    @Override // defpackage.ca0
    public final c11 d(mv0 mv0Var, long j) {
        if ("chunked".equalsIgnoreCase(mv0Var.c.a("Transfer-Encoding"))) {
            if (this.e == 1) {
                this.e = 2;
                return new b90(this);
            }
            zy.g("state: ", this.e);
            return null;
        }
        if (j == -1) {
            s1.f("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.e == 1) {
            this.e = 2;
            return new d90(this, j);
        }
        zy.g("state: ", this.e);
        return null;
    }

    @Override // defpackage.ca0
    public final kt0 e(hw0 hw0Var) {
        u21 u21Var = this.b;
        u21Var.f.getClass();
        hw0Var.a("Content-Type");
        if (!ea0.b(hw0Var)) {
            e90 e90VarG = g(0L);
            Logger logger = tn0.a;
            return new kt0(0L, new gt0(e90VarG), 0);
        }
        if ("chunked".equalsIgnoreCase(hw0Var.a("Transfer-Encoding"))) {
            ga0 ga0Var = hw0Var.b.a;
            if (this.e != 4) {
                zy.g("state: ", this.e);
                return null;
            }
            this.e = 5;
            c90 c90Var = new c90(this, ga0Var);
            Logger logger2 = tn0.a;
            return new kt0(-1L, new gt0(c90Var), 0);
        }
        long jA = ea0.a(hw0Var);
        if (jA != -1) {
            e90 e90VarG2 = g(jA);
            Logger logger3 = tn0.a;
            return new kt0(jA, new gt0(e90VarG2), 0);
        }
        if (this.e != 4) {
            zy.g("state: ", this.e);
            return null;
        }
        this.e = 5;
        u21Var.e();
        f90 f90Var = new f90(this);
        Logger logger4 = tn0.a;
        return new kt0(-1L, new gt0(f90Var), 0);
    }

    @Override // defpackage.ca0
    public final gw0 f(boolean z) {
        int i = this.e;
        if (i != 1 && i != 3) {
            zy.g("state: ", this.e);
            return null;
        }
        try {
            String strL = this.c.l(this.f);
            this.f -= (long) strL.length();
            f9 f9VarG = f9.g(strL);
            int i2 = f9VarG.b;
            gw0 gw0Var = new gw0();
            gw0Var.b = (vr0) f9VarG.c;
            gw0Var.c = i2;
            gw0Var.d = (String) f9VarG.d;
            gw0Var.f = h().c();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.e = 3;
                return gw0Var;
            }
            this.e = 4;
            return gw0Var;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public final e90 g(long j) {
        if (this.e != 4) {
            zy.g("state: ", this.e);
            return null;
        }
        this.e = 5;
        e90 e90Var = new e90(this);
        e90Var.f = j;
        if (j == 0) {
            e90Var.a(true, null);
        }
        return e90Var;
    }

    public final w70 h() {
        jj jjVar = new jj(1);
        while (true) {
            String strL = this.c.l(this.f);
            this.f -= (long) strL.length();
            if (strL.length() == 0) {
                return new w70(jjVar);
            }
            c70.l.getClass();
            int iIndexOf = strL.indexOf(":", 1);
            if (iIndexOf != -1) {
                jjVar.f(strL.substring(0, iIndexOf), strL.substring(iIndexOf + 1));
            } else if (strL.startsWith(":")) {
                jjVar.f("", strL.substring(1));
            } else {
                jjVar.f("", strL);
            }
        }
    }

    public final void i(w70 w70Var, String str) {
        if (this.e != 0) {
            zy.g("state: ", this.e);
            return;
        }
        nh nhVar = this.d;
        nhVar.o(str).o("\r\n");
        int iD = w70Var.d();
        for (int i = 0; i < iD; i++) {
            nhVar.o(w70Var.b(i)).o(": ").o(w70Var.e(i)).o("\r\n");
        }
        nhVar.o("\r\n");
        this.e = 1;
    }
}
