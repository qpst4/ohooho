package defpackage;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class aa0 {
    public long a = 0;
    public long b;
    public final int c;
    public final u90 d;
    public final ArrayDeque e;
    public boolean f;
    public final y90 g;
    public final x90 h;
    public final z90 i;
    public final z90 j;
    public int k;

    public aa0(int i, u90 u90Var, boolean z, boolean z2, w70 w70Var) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        int i2 = 0;
        this.i = new z90(i2, this);
        this.j = new z90(i2, this);
        this.k = 0;
        if (u90Var == null) {
            zy.r("connection == null");
            throw null;
        }
        this.c = i;
        this.d = u90Var;
        this.b = u90Var.p.d();
        y90 y90Var = new y90(this, u90Var.o.d());
        this.g = y90Var;
        x90 x90Var = new x90(this);
        this.h = x90Var;
        y90Var.f = z2;
        x90Var.d = z;
        if (w70Var != null) {
            arrayDeque.add(w70Var);
        }
        if (f() && w70Var != null) {
            s1.f("locally-initiated streams shouldn't have headers yet");
            throw null;
        }
        if (f() || w70Var != null) {
            return;
        }
        s1.f("remotely-initiated streams should have headers");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            y90 r0 = r2.g     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L1a
            boolean r0 = r0.e     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            x90 r0 = r2.h     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.d     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L18
            boolean r0 = r0.c     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            goto L18
        L16:
            r0 = move-exception
            goto L31
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            boolean r1 = r2.g()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L27
            r0 = 6
            r2.c(r0)
            return
        L27:
            if (r1 != 0) goto L30
            u90 r0 = r2.d
            int r2 = r2.c
            r0.q(r2)
        L30:
            return
        L31:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa0.a():void");
    }

    public final void b() throws IOException {
        x90 x90Var = this.h;
        if (x90Var.c) {
            zy.p("stream closed");
        } else {
            if (x90Var.d) {
                zy.p("stream finished");
                return;
            }
            int i = this.k;
            if (i != 0) {
                throw new v21(i);
            }
        }
    }

    public final void c(int i) {
        if (d(i)) {
            this.d.s.r(this.c, i);
        }
    }

    public final boolean d(int i) {
        synchronized (this) {
            try {
                if (this.k != 0) {
                    return false;
                }
                if (this.g.f && this.h.d) {
                    return false;
                }
                this.k = i;
                notifyAll();
                this.d.q(this.c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final x90 e() {
        synchronized (this) {
            try {
                if (!this.f && !f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    public final boolean f() {
        return this.d.b == ((this.c & 1) == 1);
    }

    public final synchronized boolean g() {
        try {
            if (this.k != 0) {
                return false;
            }
            y90 y90Var = this.g;
            if (y90Var.f || y90Var.e) {
                x90 x90Var = this.h;
                if (x90Var.d || x90Var.c) {
                    if (this.f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h() {
        boolean zG;
        synchronized (this) {
            this.g.f = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.d.q(this.c);
    }
}
