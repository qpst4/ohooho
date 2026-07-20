package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dl {
    public static final Logger d = Logger.getLogger(dl.class.getName());
    public static final boolean e = md1.c;
    public static final long f = md1.d;
    public final byte[] a;
    public final int b;
    public int c;

    public dl(int i, byte[] bArr) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.a = bArr;
        this.c = 0;
        this.b = i;
    }

    public static int a(int i, zh zhVar) {
        int iE = e(i);
        int size = zhVar.size();
        return g(size) + size + iE;
    }

    public static int b(int i, int i2) {
        return e(i) + (i2 >= 0 ? g(i2) : 10);
    }

    public static int c(int i, w50 w50Var) {
        int iE = e(i);
        int iD = w50Var.d();
        return g(iD) + iD + iE;
    }

    public static int d(String str, int i) {
        int length;
        int iE = e(i);
        try {
            length = zd1.b(str);
        } catch (yd1 unused) {
            length = str.getBytes(ec0.a).length;
        }
        return g(length) + length + iE;
    }

    public static int e(int i) {
        return g(i << 3);
    }

    public static int f(int i, int i2) {
        return g(i2) + e(i);
    }

    public static int g(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public final void h(int i, zh zhVar) throws el {
        m(i, 2);
        o(zhVar.size());
        j(zhVar.c, zhVar.d(), zhVar.size());
    }

    public final void i(int i, int i2) throws el {
        m(i, 0);
        if (i2 >= 0) {
            o(i2);
            return;
        }
        long j = i2;
        boolean z = e;
        int i3 = this.b;
        byte[] bArr = this.a;
        if (z) {
            int i4 = this.c;
            if (i3 - i4 >= 10) {
                long j2 = f + ((long) i4);
                while ((j & (-128)) != 0) {
                    md1.f(bArr, j2, (byte) ((((int) j) & 127) | 128));
                    this.c++;
                    j >>>= 7;
                    j2 = 1 + j2;
                }
                md1.f(bArr, j2, (byte) j);
                this.c++;
                return;
            }
        }
        while (true) {
            long j3 = j & (-128);
            int i5 = this.c;
            if (j3 == 0) {
                this.c = i5 + 1;
                bArr[i5] = (byte) j;
                return;
            } else {
                try {
                    this.c = i5 + 1;
                    bArr[i5] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(i3), 1), e2);
                }
            }
            throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(i3), 1), e2);
        }
    }

    public final void j(byte[] bArr, int i, int i2) throws el {
        try {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(i2)), e2);
        }
    }

    public final void k(int i, w50 w50Var) throws el {
        m(i, 2);
        o(w50Var.d());
        w50Var.o(this);
    }

    public final void l(String str, int i) throws el {
        m(i, 2);
        int i2 = this.c;
        try {
            int iG = g(str.length() * 3);
            int iG2 = g(str.length());
            int i3 = this.b;
            byte[] bArr = this.a;
            if (iG2 != iG) {
                o(zd1.b(str));
                int i4 = this.c;
                this.c = zd1.a.g(str, bArr, i4, i3 - i4);
                return;
            }
            int i5 = i2 + iG2;
            this.c = i5;
            int iG3 = zd1.a.g(str, bArr, i5, i3 - i5);
            this.c = i2;
            o((iG3 - i2) - iG2);
            this.c = iG3;
        } catch (IndexOutOfBoundsException e2) {
            throw new el(e2);
        } catch (yd1 e3) {
            this.c = i2;
            d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(ec0.a);
            try {
                o(bytes.length);
                j(bytes, 0, bytes.length);
            } catch (el e4) {
                throw e4;
            } catch (IndexOutOfBoundsException e5) {
                throw new el(e5);
            }
        }
    }

    public final void m(int i, int i2) throws el {
        o((i << 3) | i2);
    }

    public final void n(int i, int i2) throws el {
        m(i, 0);
        o(i2);
    }

    public final void o(int i) throws el {
        boolean z = e;
        int i2 = this.b;
        byte[] bArr = this.a;
        if (z) {
            int i3 = this.c;
            if (i2 - i3 >= 10) {
                long j = f + ((long) i3);
                while ((i & (-128)) != 0) {
                    md1.f(bArr, j, (byte) ((i & 127) | 128));
                    this.c++;
                    i >>>= 7;
                    j = 1 + j;
                }
                md1.f(bArr, j, (byte) i);
                this.c++;
                return;
            }
        }
        while (true) {
            int i4 = i & (-128);
            int i5 = this.c;
            if (i4 == 0) {
                this.c = i5 + 1;
                bArr[i5] = (byte) i;
                return;
            } else {
                try {
                    this.c = i5 + 1;
                    bArr[i5] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(i2), 1), e2);
                }
            }
            throw new el(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(i2), 1), e2);
        }
    }
}
