package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sb implements c11 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public sb(a61 a61Var, OutputStream outputStream) {
        this.c = a61Var;
        this.d = outputStream;
    }

    @Override // defpackage.c11
    public final a61 b() {
        switch (this.b) {
            case 0:
                return (z90) this.d;
            default:
                return (a61) this.c;
        }
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) {
        int i = this.b;
        Object obj = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                z90 z90Var = (z90) obj;
                ce1.a(mhVar.c, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    wy0 wy0Var = mhVar.b;
                    long j3 = 0;
                    while (true) {
                        if (j3 < 65536) {
                            j3 += (long) (wy0Var.c - wy0Var.b);
                            if (j3 >= j2) {
                                j3 = j2;
                            } else {
                                wy0Var = wy0Var.f;
                            }
                        }
                    }
                    z90Var.i();
                    try {
                        try {
                            ((sb) obj2).c(mhVar, j3);
                            j2 -= j3;
                            z90Var.j(true);
                        } catch (IOException e) {
                            if (!z90Var.k()) {
                                throw e;
                            }
                            throw z90Var.l(e);
                        }
                    } catch (Throwable th) {
                        z90Var.j(false);
                        throw th;
                    }
                }
                return;
            default:
                ce1.a(mhVar.c, 0L, j);
                long j4 = j;
                while (j4 > 0) {
                    ((a61) obj2).f();
                    wy0 wy0Var2 = mhVar.b;
                    int iMin = (int) Math.min(j4, wy0Var2.c - wy0Var2.b);
                    ((OutputStream) obj).write(wy0Var2.a, wy0Var2.b, iMin);
                    int i2 = wy0Var2.b + iMin;
                    wy0Var2.b = i2;
                    long j5 = iMin;
                    j4 -= j5;
                    mhVar.c -= j5;
                    if (i2 == wy0Var2.c) {
                        mhVar.b = wy0Var2.a();
                        xy0.x(wy0Var2);
                    }
                }
                return;
        }
    }

    @Override // defpackage.c11, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.b;
        Object obj = this.d;
        switch (i) {
            case 0:
                z90 z90Var = (z90) obj;
                z90Var.i();
                try {
                    try {
                        ((sb) this.c).close();
                        z90Var.j(true);
                        return;
                    } catch (IOException e) {
                        if (!z90Var.k()) {
                            throw e;
                        }
                        throw z90Var.l(e);
                    }
                } catch (Throwable th) {
                    z90Var.j(false);
                    throw th;
                }
            default:
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // defpackage.c11, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.b;
        Object obj = this.d;
        switch (i) {
            case 0:
                z90 z90Var = (z90) obj;
                z90Var.i();
                try {
                    try {
                        ((sb) this.c).flush();
                        z90Var.j(true);
                        return;
                    } catch (IOException e) {
                        if (!z90Var.k()) {
                            throw e;
                        }
                        throw z90Var.l(e);
                    }
                } catch (Throwable th) {
                    z90Var.j(false);
                    throw th;
                }
            default:
                ((OutputStream) obj).flush();
                return;
        }
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return "AsyncTimeout.sink(" + ((sb) this.c) + ")";
            default:
                return "sink(" + ((OutputStream) this.d) + ")";
        }
    }

    public sb(z90 z90Var, sb sbVar) {
        this.d = z90Var;
        this.c = sbVar;
    }
}
