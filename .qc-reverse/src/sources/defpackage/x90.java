package defpackage;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x90 implements c11 {
    public final mh b = new mh();
    public boolean c;
    public boolean d;
    public final /* synthetic */ aa0 e;

    public x90(aa0 aa0Var) {
        this.e = aa0Var;
    }

    public final void a(boolean z) {
        aa0 aa0Var;
        long jMin;
        aa0 aa0Var2;
        synchronized (this.e) {
            this.e.j.i();
            while (true) {
                try {
                    aa0Var = this.e;
                    if (aa0Var.b > 0 || this.d || this.c || aa0Var.k != 0) {
                        break;
                    }
                    try {
                        aa0Var.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } finally {
                    this.e.j.n();
                }
            }
            aa0Var.j.n();
            this.e.b();
            jMin = Math.min(this.e.b, this.b.c);
            aa0Var2 = this.e;
            aa0Var2.b -= jMin;
        }
        aa0Var2.j.i();
        try {
            aa0 aa0Var3 = this.e;
            aa0Var3.d.t(aa0Var3.c, z && jMin == this.b.c, this.b, jMin);
            this.e.j.n();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.c11
    public final a61 b() {
        return this.e.j;
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) {
        mh mhVar2 = this.b;
        mhVar2.c(mhVar, j);
        while (mhVar2.c >= 16384) {
            a(false);
        }
    }

    @Override // defpackage.c11, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.e) {
            try {
                if (this.c) {
                    return;
                }
                aa0 aa0Var = this.e;
                if (!aa0Var.h.d) {
                    if (this.b.c > 0) {
                        while (this.b.c > 0) {
                            a(true);
                        }
                    } else {
                        aa0Var.d.t(aa0Var.c, true, null, 0L);
                    }
                }
                synchronized (this.e) {
                    this.c = true;
                }
                this.e.d.flush();
                this.e.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.c11, java.io.Flushable
    public final void flush() {
        synchronized (this.e) {
            this.e.b();
        }
        while (this.b.c > 0) {
            a(false);
            this.e.d.flush();
        }
    }
}
