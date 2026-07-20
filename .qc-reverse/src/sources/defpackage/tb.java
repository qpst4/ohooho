package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tb implements n11 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public tb(a61 a61Var, InputStream inputStream) {
        this.c = a61Var;
        this.d = inputStream;
    }

    @Override // defpackage.n11
    public final a61 b() {
        switch (this.b) {
            case 0:
                return (z90) this.d;
            default:
                return (a61) this.c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.b;
        Object obj = this.d;
        switch (i) {
            case 0:
                z90 z90Var = (z90) obj;
                try {
                    try {
                        ((tb) this.c).close();
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
                ((InputStream) obj).close();
                return;
        }
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        int i = this.b;
        Object obj = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                z90 z90Var = (z90) obj;
                z90Var.i();
                try {
                    try {
                        long j2 = ((tb) obj2).j(mhVar, 8192L);
                        z90Var.j(true);
                        return j2;
                    } catch (IOException e) {
                        if (z90Var.k()) {
                            throw z90Var.l(e);
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    z90Var.j(false);
                    throw th;
                }
            default:
                try {
                    ((a61) obj2).f();
                    wy0 wy0VarU = mhVar.u(1);
                    int i2 = ((InputStream) obj).read(wy0VarU.a, wy0VarU.c, (int) Math.min(8192L, 8192 - wy0VarU.c));
                    if (i2 == -1) {
                        return -1L;
                    }
                    wy0VarU.c += i2;
                    long j3 = i2;
                    mhVar.c += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    throw new IOException(e2);
                }
        }
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return "AsyncTimeout.source(" + ((tb) this.c) + ")";
            default:
                return "source(" + ((InputStream) this.d) + ")";
        }
    }

    public tb(z90 z90Var, tb tbVar) {
        this.d = z90Var;
        this.c = tbVar;
    }
}
