package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ft0 implements nh {
    public final mh b = new mh();
    public final c11 c;
    public boolean d;

    public ft0(c11 c11Var) {
        this.c = c11Var;
    }

    public final nh a() {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        mh mhVar = this.b;
        long jA = mhVar.a();
        if (jA > 0) {
            this.c.c(mhVar, jA);
        }
        return this;
    }

    @Override // defpackage.c11
    public final a61 b() {
        return this.c.b();
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) {
        if (this.d) {
            s1.f("closed");
        } else {
            this.b.c(mhVar, j);
            a();
        }
    }

    @Override // defpackage.c11, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        c11 c11Var = this.c;
        if (this.d) {
            return;
        }
        try {
            mh mhVar = this.b;
            long j = mhVar.c;
            if (j > 0) {
                c11Var.c(mhVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            c11Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.d = true;
        if (th == null) {
            return;
        }
        Charset charset = ce1.a;
        throw th;
    }

    @Override // defpackage.nh
    public final nh d(long j) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.x(j);
        a();
        return this;
    }

    @Override // defpackage.nh, defpackage.c11, java.io.Flushable
    public final void flush() {
        if (this.d) {
            s1.f("closed");
            return;
        }
        mh mhVar = this.b;
        long j = mhVar.c;
        c11 c11Var = this.c;
        if (j > 0) {
            c11Var.c(mhVar, j);
        }
        c11Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.d;
    }

    @Override // defpackage.nh
    public final nh o(String str) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.A(0, str.length(), str);
        a();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.c + ")";
    }

    @Override // defpackage.nh
    public final nh write(byte[] bArr) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.v(bArr.length, bArr);
        a();
        return this;
    }

    @Override // defpackage.nh
    public final nh writeByte(int i) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.w(i);
        a();
        return this;
    }

    @Override // defpackage.nh
    public final nh writeInt(int i) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.y(i);
        a();
        return this;
    }

    @Override // defpackage.nh
    public final nh writeShort(int i) {
        if (this.d) {
            s1.f("closed");
            return null;
        }
        this.b.z(i);
        a();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (!this.d) {
            int iWrite = this.b.write(byteBuffer);
            a();
            return iWrite;
        }
        s1.f("closed");
        return 0;
    }
}
