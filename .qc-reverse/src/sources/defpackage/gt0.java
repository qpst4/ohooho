package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gt0 implements oh {
    public final mh b = new mh();
    public final n11 c;
    public boolean d;

    public gt0(n11 n11Var) {
        if (n11Var != null) {
            this.c = n11Var;
        } else {
            zy.r("source == null");
            throw null;
        }
    }

    public final boolean a() {
        if (this.d) {
            s1.f("closed");
            return false;
        }
        mh mhVar = this.b;
        return mhVar.h() && this.c.j(mhVar, 8192L) == -1;
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c.close();
        mh mhVar = this.b;
        try {
            mhVar.skip(mhVar.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.oh
    public final ai e(long j) throws EOFException {
        n(j);
        return this.b.e(j);
    }

    @Override // defpackage.oh
    public final String f() {
        return l(Long.MAX_VALUE);
    }

    public final long g(byte b, long j, long j2) {
        if (this.d) {
            s1.f("closed");
            return 0L;
        }
        if (j2 < 0) {
            s1.i("fromIndex=0 toIndex=", j2);
            return 0L;
        }
        long jMax = 0;
        while (jMax < j2) {
            mh mhVar = this.b;
            byte b2 = b;
            long j3 = j2;
            long jM = mhVar.m(b2, jMax, j3);
            if (jM != -1) {
                return jM;
            }
            long j4 = mhVar.c;
            if (j4 >= j3 || this.c.j(mhVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }

    public final void h(byte[] bArr) throws EOFException {
        mh mhVar = this.b;
        int i = 0;
        try {
            n(bArr.length);
            while (i < bArr.length) {
                int i2 = mhVar.read(bArr, i, bArr.length - i);
                if (i2 == -1) {
                    throw new EOFException();
                }
                i += i2;
            }
        } catch (EOFException e) {
            while (true) {
                long j = mhVar.c;
                if (j <= 0) {
                    throw e;
                }
                int i3 = mhVar.read(bArr, i, (int) j);
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i += i3;
            }
        }
    }

    public final boolean i(long j) {
        mh mhVar;
        if (j < 0) {
            s1.i("byteCount < 0: ", j);
            return false;
        }
        if (this.d) {
            s1.f("closed");
            return false;
        }
        do {
            mhVar = this.b;
            if (mhVar.c >= j) {
                return true;
            }
        } while (this.c.j(mhVar, 8192L) != -1);
        return false;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.d;
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) {
        if (mhVar == null) {
            zy.n("sink == null");
            return 0L;
        }
        if (j < 0) {
            s1.i("byteCount < 0: ", j);
            return 0L;
        }
        if (this.d) {
            s1.f("closed");
            return 0L;
        }
        mh mhVar2 = this.b;
        if (mhVar2.c == 0 && this.c.j(mhVar2, 8192L) == -1) {
            return -1L;
        }
        return mhVar2.j(mhVar, Math.min(j, mhVar2.c));
    }

    @Override // defpackage.oh
    public final long k(sb sbVar) {
        mh mhVar;
        long j = 0;
        while (true) {
            n11 n11Var = this.c;
            mhVar = this.b;
            if (n11Var.j(mhVar, 8192L) == -1) {
                break;
            }
            long jA = mhVar.a();
            if (jA > 0) {
                j += jA;
                sbVar.c(mhVar, jA);
            }
        }
        long j2 = mhVar.c;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        sbVar.c(mhVar, j2);
        return j3;
    }

    @Override // defpackage.oh
    public final String l(long j) throws EOFException {
        if (j < 0) {
            s1.i("limit < 0: ", j);
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jG = g((byte) 10, 0L, j2);
        mh mhVar = this.b;
        if (jG != -1) {
            return mhVar.t(jG);
        }
        if (j2 < Long.MAX_VALUE && i(j2) && mhVar.i(j2 - 1) == 13 && i(j2 + 1) && mhVar.i(j2) == 10) {
            return mhVar.t(j2);
        }
        mh mhVar2 = new mh();
        mhVar.g(mhVar2, 0L, Math.min(32L, mhVar.c));
        StringBuilder sb = new StringBuilder("\\n not found: limit=");
        sb.append(Math.min(mhVar.c, j));
        sb.append(" content=");
        try {
            sb.append(new ai(mhVar2.q(mhVar2.c)).e());
            sb.append((char) 8230);
            throw new EOFException(sb.toString());
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.oh
    public final void n(long j) throws EOFException {
        if (!i(j)) {
            throw new EOFException();
        }
    }

    @Override // defpackage.oh
    public final long p() throws EOFException {
        mh mhVar;
        byte bI;
        n(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean zI = i(i2);
            mhVar = this.b;
            if (!zI) {
                break;
            }
            bI = mhVar.i(i);
            if ((bI < 48 || bI > 57) && ((bI < 97 || bI > 102) && (bI < 65 || bI > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bI)));
        }
        return mhVar.p();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        mh mhVar = this.b;
        if (mhVar.c == 0 && this.c.j(mhVar, 8192L) == -1) {
            return -1;
        }
        return mhVar.read(byteBuffer);
    }

    @Override // defpackage.oh
    public final byte readByte() throws EOFException {
        n(1L);
        return this.b.readByte();
    }

    @Override // defpackage.oh
    public final int readInt() throws EOFException {
        n(4L);
        return this.b.readInt();
    }

    @Override // defpackage.oh
    public final short readShort() throws EOFException {
        n(2L);
        return this.b.readShort();
    }

    @Override // defpackage.oh
    public final void skip(long j) throws EOFException {
        if (this.d) {
            s1.f("closed");
            return;
        }
        while (j > 0) {
            mh mhVar = this.b;
            if (mhVar.c == 0 && this.c.j(mhVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, mhVar.c);
            mhVar.skip(jMin);
            j -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.c + ")";
    }
}
