package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ba0 implements Closeable {
    public static final Logger h = Logger.getLogger(h90.class.getName());
    public final nh b;
    public final boolean c;
    public final mh d;
    public int e;
    public boolean f;
    public final u80 g;

    public ba0(ft0 ft0Var, boolean z) {
        this.b = ft0Var;
        this.c = z;
        mh mhVar = new mh();
        this.d = mhVar;
        this.g = new u80(mhVar);
        this.e = 16384;
    }

    public final synchronized void a(jl1 jl1Var) {
        try {
            if (this.f) {
                throw new IOException("closed");
            }
            int i = this.e;
            int i2 = jl1Var.b;
            if ((i2 & 32) != 0) {
                i = ((int[]) jl1Var.c)[5];
            }
            this.e = i;
            if (((i2 & 2) != 0 ? ((int[]) jl1Var.c)[1] : -1) != -1) {
                u80 u80Var = this.g;
                int iMin = Math.min((i2 & 2) != 0 ? ((int[]) jl1Var.c)[1] : -1, 16384);
                int i3 = u80Var.d;
                if (i3 != iMin) {
                    if (iMin < i3) {
                        u80Var.b = Math.min(u80Var.b, iMin);
                    }
                    u80Var.c = true;
                    u80Var.d = iMin;
                    int i4 = u80Var.h;
                    if (iMin < i4) {
                        if (iMin == 0) {
                            Arrays.fill(u80Var.e, (Object) null);
                            u80Var.f = u80Var.e.length - 1;
                            u80Var.g = 0;
                            u80Var.h = 0;
                        } else {
                            u80Var.a(i4 - iMin);
                        }
                    }
                }
            }
            h(0, 0, (byte) 4, (byte) 1);
            this.b.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f = true;
        this.b.close();
    }

    public final synchronized void flush() {
        if (this.f) {
            throw new IOException("closed");
        }
        this.b.flush();
    }

    public final synchronized void g(boolean z, int i, mh mhVar, int i2) {
        if (this.f) {
            throw new IOException("closed");
        }
        h(i, i2, (byte) 0, z ? (byte) 1 : (byte) 0);
        if (i2 > 0) {
            this.b.c(mhVar, i2);
        }
    }

    public final void h(int i, int i2, byte b, byte b2) {
        Level level = Level.FINE;
        Logger logger = h;
        if (logger.isLoggable(level)) {
            logger.fine(h90.a(false, i, i2, b, b2));
        }
        int i3 = this.e;
        if (i2 > i3) {
            h90.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            h90.b("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
        nh nhVar = this.b;
        nhVar.writeByte((i2 >>> 16) & 255);
        nhVar.writeByte((i2 >>> 8) & 255);
        nhVar.writeByte(i2 & 255);
        nhVar.writeByte(b & 255);
        nhVar.writeByte(b2 & 255);
        nhVar.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void i(byte[] bArr, int i, int i2) {
        try {
            if (this.f) {
                throw new IOException("closed");
            }
            if (l11.e(i2) == -1) {
                h90.b("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            h(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.b.writeInt(i);
            this.b.writeInt(l11.e(i2));
            if (bArr.length > 0) {
                this.b.write(bArr);
            }
            this.b.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(boolean r18, int r19, java.util.ArrayList r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ba0.m(boolean, int, java.util.ArrayList):void");
    }

    public final synchronized void q(int i, int i2, boolean z) {
        if (this.f) {
            throw new IOException("closed");
        }
        h(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.b.writeInt(i);
        this.b.writeInt(i2);
        this.b.flush();
    }

    public final synchronized void r(int i, int i2) {
        if (this.f) {
            throw new IOException("closed");
        }
        if (l11.e(i2) == -1) {
            throw new IllegalArgumentException();
        }
        h(i, 4, (byte) 3, (byte) 0);
        this.b.writeInt(l11.e(i2));
        this.b.flush();
    }

    public final synchronized void s(int i, long j) {
        if (this.f) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            h90.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
        h(i, 4, (byte) 8, (byte) 0);
        this.b.writeInt((int) j);
        this.b.flush();
    }
}
