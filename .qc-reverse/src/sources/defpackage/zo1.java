package defpackage;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zo1 {
    public static final Logger e = Logger.getLogger(zo1.class.getName());
    public static final boolean f = oq1.e;
    public tb0 a;
    public final byte[] b;
    public final int c;
    public int d;

    public zo1(int i, byte[] bArr) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            Locale locale = Locale.US;
            zy.n(qq0.h(length, i, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.b = bArr;
        this.d = 0;
        this.c = i;
    }

    public static int a(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int p(String str) {
        int length;
        try {
            length = qq1.c(str);
        } catch (pq1 unused) {
            length = str.getBytes(lp1.a).length;
        }
        return q(length) + length;
    }

    public static int q(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void b(int i, byte[] bArr) throws ap1 {
        try {
            System.arraycopy(bArr, 0, this.b, this.d, i);
            this.d += i;
        } catch (IndexOutOfBoundsException e2) {
            throw new ap1(this.d, this.c, i, e2);
        }
    }

    public final void c(int i, yo1 yo1Var) throws ap1 {
        m((i << 3) | 2);
        m(yo1Var.d());
        b(yo1Var.d(), yo1Var.c);
    }

    public final void d(int i, int i2) throws ap1 {
        m((i << 3) | 5);
        e(i2);
    }

    public final void e(int i) throws ap1 {
        int i2 = this.d;
        try {
            byte[] bArr = this.b;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            this.d = i2 + 4;
        } catch (IndexOutOfBoundsException e2) {
            throw new ap1(i2, this.c, 4, e2);
        }
    }

    public final void f(int i, long j) throws ap1 {
        m((i << 3) | 1);
        g(j);
    }

    public final void g(long j) throws ap1 {
        int i = this.d;
        try {
            byte[] bArr = this.b;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            this.d = i + 8;
        } catch (IndexOutOfBoundsException e2) {
            throw new ap1(i, this.c, 8, e2);
        }
    }

    public final void h(int i, int i2) throws ap1 {
        m(i << 3);
        i(i2);
    }

    public final void i(int i) throws ap1 {
        if (i >= 0) {
            m(i);
        } else {
            o(i);
        }
    }

    public final void j(String str, int i) throws ap1 {
        m((i << 3) | 2);
        int i2 = this.d;
        try {
            int iQ = q(str.length() * 3);
            int iQ2 = q(str.length());
            int i3 = this.c;
            byte[] bArr = this.b;
            if (iQ2 != iQ) {
                m(qq1.c(str));
                int i4 = this.d;
                this.d = qq1.b(str, bArr, i4, i3 - i4);
            } else {
                int i5 = i2 + iQ2;
                this.d = i5;
                int iB = qq1.b(str, bArr, i5, i3 - i5);
                this.d = i2;
                m((iB - i2) - iQ2);
                this.d = iB;
            }
        } catch (IndexOutOfBoundsException e2) {
            throw new ap1(e2);
        } catch (pq1 e3) {
            this.d = i2;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(lp1.a);
            try {
                int length = bytes.length;
                m(length);
                b(length, bytes);
            } catch (IndexOutOfBoundsException e4) {
                throw new ap1(e4);
            }
        }
    }

    public final void k(int i, int i2) {
        m((i << 3) | i2);
    }

    public final void l(int i, int i2) {
        m(i << 3);
        m(i2);
    }

    public final void m(int i) {
        while (true) {
            int i2 = i & (-128);
            int i3 = this.d;
            byte[] bArr = this.b;
            if (i2 == 0) {
                this.d = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    this.d = i3 + 1;
                    bArr[i3] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new ap1(this.d, this.c, 1, e2);
                }
            }
            throw new ap1(this.d, this.c, 1, e2);
        }
    }

    public final void n(int i, long j) throws ap1 {
        m(i << 3);
        o(j);
    }

    public final void o(long j) throws ap1 {
        boolean z = f;
        byte[] bArr = this.b;
        int i = this.c;
        if (!z || i - this.d < 10) {
            while (true) {
                long j2 = j & (-128);
                int i2 = this.d;
                if (j2 == 0) {
                    this.d = i2 + 1;
                    bArr[i2] = (byte) j;
                    return;
                } else {
                    try {
                        this.d = i2 + 1;
                        bArr[i2] = (byte) ((((int) j) | 128) & 255);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new ap1(this.d, i, 1, e2);
                    }
                }
                throw new ap1(this.d, i, 1, e2);
            }
        }
        while (true) {
            long j3 = j & (-128);
            int i3 = (int) j;
            int i4 = this.d;
            if (j3 == 0) {
                this.d = i4 + 1;
                oq1.c.d(bArr, oq1.f + ((long) i4), (byte) i3);
                return;
            }
            this.d = i4 + 1;
            oq1.c.d(bArr, oq1.f + ((long) i4), (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }
}
