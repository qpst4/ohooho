package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p70 implements n11 {
    public final gt0 c;
    public final Inflater d;
    public final eb0 e;
    public int b = 0;
    public final CRC32 f = new CRC32();

    public p70(n11 n11Var) {
        if (n11Var == null) {
            zy.n("source == null");
            throw null;
        }
        Inflater inflater = new Inflater(true);
        this.d = inflater;
        Logger logger = tn0.a;
        gt0 gt0Var = new gt0(n11Var);
        this.c = gt0Var;
        this.e = new eb0(gt0Var, inflater);
    }

    public static void a(int i, int i2, String str) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.c.c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.e.close();
    }

    public final void g(mh mhVar, long j, long j2) {
        wy0 wy0Var = mhVar.b;
        while (true) {
            long j3 = wy0Var.c - wy0Var.b;
            if (j < j3) {
                break;
            }
            j -= j3;
            wy0Var = wy0Var.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) wy0Var.b) + j);
            int iMin = (int) Math.min(wy0Var.c - i, j2);
            this.f.update(wy0Var.a, i, iMin);
            j2 -= (long) iMin;
            wy0Var = wy0Var.f;
            j = 0;
        }
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        long j2;
        p70 p70Var = this;
        int i = p70Var.b;
        CRC32 crc32 = p70Var.f;
        gt0 gt0Var = p70Var.c;
        if (i == 0) {
            gt0Var.n(10L);
            mh mhVar2 = gt0Var.b;
            byte bI = mhVar2.i(3L);
            boolean z = ((bI >> 1) & 1) == 1;
            if (z) {
                p70Var.g(mhVar2, 0L, 10L);
            }
            a(8075, gt0Var.readShort(), "ID1ID2");
            gt0Var.skip(8L);
            if (((bI >> 2) & 1) == 1) {
                gt0Var.n(2L);
                if (z) {
                    g(mhVar2, 0L, 2L);
                }
                short s = mhVar2.readShort();
                Charset charset = ce1.a;
                long j3 = (short) (((s & 255) << 8) | ((s & 65280) >>> 8));
                gt0Var.n(j3);
                if (z) {
                    g(mhVar2, 0L, j3);
                }
                gt0Var.skip(j3);
            }
            if (((bI >> 3) & 1) == 1) {
                long jG = gt0Var.g((byte) 0, 0L, Long.MAX_VALUE);
                if (jG == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j2 = 2;
                    g(mhVar2, 0L, jG + 1);
                } else {
                    j2 = 2;
                }
                gt0Var.skip(jG + 1);
            } else {
                j2 = 2;
            }
            if (((bI >> 4) & 1) == 1) {
                long j4 = j2;
                long jG2 = gt0Var.g((byte) 0, 0L, Long.MAX_VALUE);
                if (jG2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j2 = j4;
                    p70Var = this;
                    p70Var.g(mhVar2, 0L, jG2 + 1);
                } else {
                    p70Var = this;
                    j2 = j4;
                }
                gt0Var.skip(jG2 + 1);
            } else {
                p70Var = this;
            }
            if (z) {
                gt0Var.n(j2);
                short s2 = mhVar2.readShort();
                Charset charset2 = ce1.a;
                a((short) (((s2 & 255) << 8) | ((s2 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            p70Var.b = 1;
        }
        if (p70Var.b == 1) {
            long j5 = mhVar.c;
            long j6 = p70Var.e.j(mhVar, 8192L);
            if (j6 != -1) {
                p70Var.g(mhVar, j5, j6);
                return j6;
            }
            p70Var.b = 2;
        }
        if (p70Var.b == 2) {
            gt0Var.n(4L);
            mh mhVar3 = gt0Var.b;
            int i2 = mhVar3.readInt();
            Charset charset3 = ce1.a;
            a(((i2 & 255) << 24) | ((i2 & (-16777216)) >>> 24) | ((i2 & 16711680) >>> 8) | ((i2 & 65280) << 8), (int) crc32.getValue(), "CRC");
            gt0Var.n(4L);
            int i3 = mhVar3.readInt();
            a(((i3 & 255) << 24) | ((i3 & (-16777216)) >>> 24) | ((i3 & 16711680) >>> 8) | ((i3 & 65280) << 8), (int) p70Var.d.getBytesWritten(), "ISIZE");
            p70Var.b = 3;
            if (!gt0Var.a()) {
                zy.p("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }
}
