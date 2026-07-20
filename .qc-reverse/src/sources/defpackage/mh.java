package defpackage;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mh implements oh, nh, Cloneable, ByteChannel {
    public static final byte[] d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public wy0 b;
    public long c;

    public final void A(int i, int i2, String str) {
        if (str == null) {
            zy.n("string == null");
            return;
        }
        if (i < 0) {
            zy.n(qq0.i("beginIndex < 0: ", i));
            return;
        }
        if (i2 < i) {
            zy.n(qq0.h(i2, i, "endIndex < beginIndex: ", " < "));
            return;
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                wy0 wy0VarU = u(1);
                byte[] bArr = wy0VarU.a;
                int i3 = wy0VarU.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = wy0VarU.c;
                int i6 = (i3 + i4) - i5;
                wy0VarU.c = i5 + i6;
                this.c += (long) i6;
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    w((cCharAt >> 6) | 192);
                    w((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    w((cCharAt >> '\f') | 224);
                    w(((cCharAt >> 6) & 63) | 128);
                    w((cCharAt & '?') | 128);
                } else {
                    int i7 = i + 1;
                    char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        w(63);
                        i = i7;
                    } else {
                        int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        w((i8 >> 18) | 240);
                        w(((i8 >> 12) & 63) | 128);
                        w(((i8 >> 6) & 63) | 128);
                        w((i8 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void B(int i) {
        if (i < 128) {
            w(i);
            return;
        }
        if (i < 2048) {
            w((i >> 6) | 192);
            w((i & 63) | 128);
            return;
        }
        if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                w(63);
                return;
            }
            w((i >> 12) | 224);
            w(((i >> 6) & 63) | 128);
            w((i & 63) | 128);
            return;
        }
        if (i > 1114111) {
            s1.j("Unexpected code point: ", Integer.toHexString(i));
            return;
        }
        w((i >> 18) | 240);
        w(((i >> 12) & 63) | 128);
        w(((i >> 6) & 63) | 128);
        w((i & 63) | 128);
    }

    public final long a() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        wy0 wy0Var = this.b.g;
        int i = wy0Var.c;
        return (i >= 8192 || !wy0Var.e) ? j : j - ((long) (i - wy0Var.b));
    }

    @Override // defpackage.n11
    public final a61 b() {
        return a61.d;
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) {
        wy0 wy0VarG;
        if (mhVar == null) {
            zy.n("source == null");
            return;
        }
        if (mhVar == this) {
            zy.n("source == this");
            return;
        }
        ce1.a(mhVar.c, 0L, j);
        while (j > 0) {
            wy0 wy0Var = mhVar.b;
            int i = wy0Var.c - wy0Var.b;
            if (j < i) {
                wy0 wy0Var2 = this.b;
                wy0 wy0Var3 = wy0Var2 != null ? wy0Var2.g : null;
                if (wy0Var3 != null && wy0Var3.e) {
                    if ((((long) wy0Var3.c) + j) - ((long) (wy0Var3.d ? 0 : wy0Var3.b)) <= 8192) {
                        wy0Var.d(wy0Var3, (int) j);
                        mhVar.c -= j;
                        this.c += j;
                        return;
                    }
                }
                int i2 = (int) j;
                if (i2 <= 0 || i2 > i) {
                    throw new IllegalArgumentException();
                }
                if (i2 >= 1024) {
                    wy0VarG = wy0Var.c();
                } else {
                    wy0VarG = xy0.G();
                    System.arraycopy(wy0Var.a, wy0Var.b, wy0VarG.a, 0, i2);
                }
                wy0VarG.c = wy0VarG.b + i2;
                wy0Var.b += i2;
                wy0Var.g.b(wy0VarG);
                mhVar.b = wy0VarG;
            }
            wy0 wy0Var4 = mhVar.b;
            long j2 = wy0Var4.c - wy0Var4.b;
            mhVar.b = wy0Var4.a();
            wy0 wy0Var5 = this.b;
            if (wy0Var5 == null) {
                this.b = wy0Var4;
                wy0Var4.g = wy0Var4;
                wy0Var4.f = wy0Var4;
            } else {
                wy0Var5.g.b(wy0Var4);
                wy0 wy0Var6 = wy0Var4.g;
                if (wy0Var6 == wy0Var4) {
                    throw new IllegalStateException();
                }
                if (wy0Var6.e) {
                    int i3 = wy0Var4.c - wy0Var4.b;
                    if (i3 <= (8192 - wy0Var6.c) + (wy0Var6.d ? 0 : wy0Var6.b)) {
                        wy0Var4.d(wy0Var6, i3);
                        wy0Var4.a();
                        xy0.x(wy0Var4);
                    }
                }
            }
            mhVar.c -= j2;
            this.c += j2;
            j -= j2;
        }
    }

    public final Object clone() {
        mh mhVar = new mh();
        if (this.c == 0) {
            return mhVar;
        }
        wy0 wy0VarC = this.b.c();
        mhVar.b = wy0VarC;
        wy0VarC.g = wy0VarC;
        wy0VarC.f = wy0VarC;
        wy0 wy0Var = this.b;
        while (true) {
            wy0Var = wy0Var.f;
            if (wy0Var == this.b) {
                mhVar.c = this.c;
                return mhVar;
            }
            mhVar.b.g.b(wy0Var.c());
        }
    }

    @Override // defpackage.nh
    public final /* bridge */ /* synthetic */ nh d(long j) {
        x(j);
        return this;
    }

    @Override // defpackage.oh
    public final ai e(long j) {
        return new ai(q(j));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mh)) {
            return false;
        }
        mh mhVar = (mh) obj;
        long j = this.c;
        if (j != mhVar.c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        wy0 wy0Var = this.b;
        wy0 wy0Var2 = mhVar.b;
        int i = wy0Var.b;
        int i2 = wy0Var2.b;
        while (j2 < this.c) {
            long jMin = Math.min(wy0Var.c - i, wy0Var2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (wy0Var.a[i] != wy0Var2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == wy0Var.c) {
                wy0Var = wy0Var.f;
                i = wy0Var.b;
            }
            if (i2 == wy0Var2.c) {
                wy0Var2 = wy0Var2.f;
                i2 = wy0Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // defpackage.oh
    public final String f() {
        return l(Long.MAX_VALUE);
    }

    public final void g(mh mhVar, long j, long j2) {
        if (mhVar == null) {
            zy.n("out == null");
            return;
        }
        long j3 = j;
        ce1.a(this.c, j3, j2);
        if (j2 == 0) {
            return;
        }
        mhVar.c += j2;
        wy0 wy0Var = this.b;
        while (true) {
            long j4 = wy0Var.c - wy0Var.b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            wy0Var = wy0Var.f;
        }
        long j5 = j2;
        while (j5 > 0) {
            wy0 wy0VarC = wy0Var.c();
            int i = (int) (((long) wy0VarC.b) + j3);
            wy0VarC.b = i;
            wy0VarC.c = Math.min(i + ((int) j5), wy0VarC.c);
            wy0 wy0Var2 = mhVar.b;
            if (wy0Var2 == null) {
                wy0VarC.g = wy0VarC;
                wy0VarC.f = wy0VarC;
                mhVar.b = wy0VarC;
            } else {
                wy0Var2.g.b(wy0VarC);
            }
            j5 -= (long) (wy0VarC.c - wy0VarC.b);
            wy0Var = wy0Var.f;
            j3 = 0;
        }
    }

    public final boolean h() {
        return this.c == 0;
    }

    public final int hashCode() {
        wy0 wy0Var = this.b;
        if (wy0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = wy0Var.c;
            for (int i3 = wy0Var.b; i3 < i2; i3++) {
                i = (i * 31) + wy0Var.a[i3];
            }
            wy0Var = wy0Var.f;
        } while (wy0Var != this.b);
        return i;
    }

    public final byte i(long j) {
        int i;
        ce1.a(this.c, j, 1L);
        long j2 = this.c;
        long j3 = j2 - j;
        wy0 wy0Var = this.b;
        if (j3 <= j) {
            long j4 = j - j2;
            do {
                wy0Var = wy0Var.g;
                int i2 = wy0Var.c;
                i = wy0Var.b;
                j4 += (long) (i2 - i);
            } while (j4 < 0);
            return wy0Var.a[i + ((int) j4)];
        }
        long j5 = j;
        while (true) {
            int i3 = wy0Var.c;
            int i4 = wy0Var.b;
            long j6 = i3 - i4;
            if (j5 < j6) {
                return wy0Var.a[i4 + ((int) j5)];
            }
            j5 -= j6;
            wy0Var = wy0Var.f;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
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
        long j2 = this.c;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        mhVar.c(this, j);
        return j;
    }

    @Override // defpackage.oh
    public final long k(sb sbVar) {
        long j = this.c;
        if (j > 0) {
            sbVar.c(this, j);
        }
        return j;
    }

    @Override // defpackage.oh
    public final String l(long j) throws EOFException {
        if (j < 0) {
            s1.i("limit < 0: ", j);
            return null;
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jM = m((byte) 10, 0L, j2);
        if (jM != -1) {
            return t(jM);
        }
        if (j2 < this.c && i(j2 - 1) == 13 && i(j2) == 10) {
            return t(j2);
        }
        mh mhVar = new mh();
        g(mhVar, 0L, Math.min(32L, this.c));
        StringBuilder sb = new StringBuilder("\\n not found: limit=");
        sb.append(Math.min(this.c, j));
        sb.append(" content=");
        try {
            sb.append(new ai(mhVar.q(mhVar.c)).e());
            sb.append((char) 8230);
            throw new EOFException(sb.toString());
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final long m(byte b, long j, long j2) {
        wy0 wy0Var;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException("size=" + this.c + " fromIndex=" + j + " toIndex=" + j2);
        }
        long j4 = this.c;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (wy0Var = this.b) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                wy0Var = wy0Var.g;
                j4 -= (long) (wy0Var.c - wy0Var.b);
            }
        } else {
            while (true) {
                long j5 = ((long) (wy0Var.c - wy0Var.b)) + j3;
                if (j5 >= j) {
                    break;
                }
                wy0Var = wy0Var.f;
                j3 = j5;
            }
            j4 = j3;
        }
        while (j4 < j2) {
            byte[] bArr = wy0Var.a;
            int iMin = (int) Math.min(wy0Var.c, (((long) wy0Var.b) + j2) - j4);
            for (int i = (int) ((((long) wy0Var.b) + j) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - wy0Var.b)) + j4;
                }
            }
            j4 += (long) (wy0Var.c - wy0Var.b);
            wy0Var = wy0Var.f;
            j = j4;
        }
        return -1L;
    }

    @Override // defpackage.oh
    public final void n(long j) throws EOFException {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // defpackage.nh
    public final nh o(String str) {
        A(0, str.length(), str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[EDGE_INSN: B:43:0x0092->B:37:0x0092 BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // defpackage.oh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p() {
        /*
            r14 = this;
            long r0 = r14.c
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L99
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            wy0 r6 = r14.b
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L7e
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L62
            r11 = 70
            if (r10 > r11) goto L62
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            mh r14 = new mh
            r14.<init>()
            r14.x(r4)
            r14.w(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r14 = r14.s()
            java.lang.String r1 = "Number too large: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        L62:
            if (r0 == 0) goto L66
            r1 = 1
            goto L7e
        L66:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.String r0 = java.lang.Integer.toHexString(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r14.<init>(r0)
            throw r14
        L7e:
            if (r8 != r9) goto L8a
            wy0 r7 = r6.a()
            r14.b = r7
            defpackage.xy0.x(r6)
            goto L8c
        L8a:
            r6.b = r8
        L8c:
            if (r1 != 0) goto L92
            wy0 r6 = r14.b
            if (r6 != 0) goto Lb
        L92:
            long r1 = r14.c
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.c = r1
            return r4
        L99:
            java.lang.String r14 = "size == 0"
            defpackage.s1.f(r14)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh.p():long");
    }

    public final byte[] q(long j) throws EOFException {
        ce1.a(this.c, 0L, j);
        if (j > 2147483647L) {
            s1.i("byteCount > Integer.MAX_VALUE: ", j);
            return null;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return bArr;
    }

    public final String r(long j, Charset charset) {
        ce1.a(this.c, 0L, j);
        if (charset == null) {
            zy.n("charset == null");
            return null;
        }
        if (j > 2147483647L) {
            s1.i("byteCount > Integer.MAX_VALUE: ", j);
            return null;
        }
        if (j == 0) {
            return "";
        }
        wy0 wy0Var = this.b;
        int i = wy0Var.b;
        if (((long) i) + j > wy0Var.c) {
            return new String(q(j), charset);
        }
        String str = new String(wy0Var.a, i, (int) j, charset);
        int i2 = (int) (((long) wy0Var.b) + j);
        wy0Var.b = i2;
        this.c -= j;
        if (i2 == wy0Var.c) {
            this.b = wy0Var.a();
            xy0.x(wy0Var);
        }
        return str;
    }

    public final int read(byte[] bArr, int i, int i2) {
        ce1.a(bArr.length, i, i2);
        wy0 wy0Var = this.b;
        if (wy0Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, wy0Var.c - wy0Var.b);
        System.arraycopy(wy0Var.a, wy0Var.b, bArr, i, iMin);
        int i3 = wy0Var.b + iMin;
        wy0Var.b = i3;
        this.c -= (long) iMin;
        if (i3 == wy0Var.c) {
            this.b = wy0Var.a();
            xy0.x(wy0Var);
        }
        return iMin;
    }

    @Override // defpackage.oh
    public final byte readByte() {
        long j = this.c;
        if (j == 0) {
            s1.f("size == 0");
            return (byte) 0;
        }
        wy0 wy0Var = this.b;
        int i = wy0Var.b;
        int i2 = wy0Var.c;
        int i3 = i + 1;
        byte b = wy0Var.a[i];
        this.c = j - 1;
        if (i3 != i2) {
            wy0Var.b = i3;
            return b;
        }
        this.b = wy0Var.a();
        xy0.x(wy0Var);
        return b;
    }

    @Override // defpackage.oh
    public final int readInt() {
        long j = this.c;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.c);
        }
        wy0 wy0Var = this.b;
        int i = wy0Var.b;
        int i2 = wy0Var.c;
        if (i2 - i < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = wy0Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.c = j - 4;
        if (i5 != i2) {
            wy0Var.b = i5;
            return i6;
        }
        this.b = wy0Var.a();
        xy0.x(wy0Var);
        return i6;
    }

    @Override // defpackage.oh
    public final short readShort() {
        long j = this.c;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.c);
        }
        wy0 wy0Var = this.b;
        int i = wy0Var.b;
        int i2 = wy0Var.c;
        if (i2 - i < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = wy0Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.c = j - 2;
        if (i5 == i2) {
            this.b = wy0Var.a();
            xy0.x(wy0Var);
        } else {
            wy0Var.b = i5;
        }
        return (short) i6;
    }

    public final String s() {
        try {
            return r(this.c, ce1.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.oh
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.b == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, r0.c - r0.b);
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            wy0 wy0Var = this.b;
            int i = wy0Var.b + iMin;
            wy0Var.b = i;
            if (i == wy0Var.c) {
                this.b = wy0Var.a();
                xy0.x(wy0Var);
            }
        }
    }

    public final String t(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (i(j2) == 13) {
                String strR = r(j2, ce1.a);
                skip(2L);
                return strR;
            }
        }
        String strR2 = r(j, ce1.a);
        skip(1L);
        return strR2;
    }

    public final String toString() {
        long j = this.c;
        if (j <= 2147483647L) {
            int i = (int) j;
            return (i == 0 ? ai.f : new yy0(this, i)).toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
    }

    public final wy0 u(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        wy0 wy0Var = this.b;
        if (wy0Var == null) {
            wy0 wy0VarG = xy0.G();
            this.b = wy0VarG;
            wy0VarG.g = wy0VarG;
            wy0VarG.f = wy0VarG;
            return wy0VarG;
        }
        wy0 wy0Var2 = wy0Var.g;
        if (wy0Var2.c + i <= 8192 && wy0Var2.e) {
            return wy0Var2;
        }
        wy0 wy0VarG2 = xy0.G();
        wy0Var2.b(wy0VarG2);
        return wy0VarG2;
    }

    public final void v(int i, byte[] bArr) {
        if (bArr == null) {
            zy.n("source == null");
            return;
        }
        long j = i;
        ce1.a(bArr.length, 0L, j);
        int i2 = 0;
        while (i2 < i) {
            wy0 wy0VarU = u(1);
            int iMin = Math.min(i - i2, 8192 - wy0VarU.c);
            System.arraycopy(bArr, i2, wy0VarU.a, wy0VarU.c, iMin);
            i2 += iMin;
            wy0VarU.c += iMin;
        }
        this.c += j;
    }

    public final void w(int i) {
        wy0 wy0VarU = u(1);
        byte[] bArr = wy0VarU.a;
        int i2 = wy0VarU.c;
        wy0VarU.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            zy.n("source == null");
            return 0;
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            wy0 wy0VarU = u(1);
            int iMin = Math.min(i, 8192 - wy0VarU.c);
            byteBuffer.get(wy0VarU.a, wy0VarU.c, iMin);
            i -= iMin;
            wy0VarU.c += iMin;
        }
        this.c += (long) iRemaining;
        return iRemaining;
    }

    @Override // defpackage.nh
    public final /* bridge */ /* synthetic */ nh writeByte(int i) {
        w(i);
        return this;
    }

    @Override // defpackage.nh
    public final /* bridge */ /* synthetic */ nh writeInt(int i) {
        y(i);
        return this;
    }

    @Override // defpackage.nh
    public final /* bridge */ /* synthetic */ nh writeShort(int i) {
        z(i);
        return this;
    }

    public final void x(long j) {
        if (j == 0) {
            w(48);
            return;
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        wy0 wy0VarU = u(iNumberOfTrailingZeros);
        byte[] bArr = wy0VarU.a;
        int i = wy0VarU.c;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        wy0VarU.c += iNumberOfTrailingZeros;
        this.c += (long) iNumberOfTrailingZeros;
    }

    public final void y(int i) {
        wy0 wy0VarU = u(4);
        byte[] bArr = wy0VarU.a;
        int i2 = wy0VarU.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        wy0VarU.c = i2 + 4;
        this.c += 4;
    }

    public final void z(int i) {
        wy0 wy0VarU = u(2);
        byte[] bArr = wy0VarU.a;
        int i2 = wy0VarU.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        wy0VarU.c = i2 + 2;
        this.c += 2;
    }

    @Override // defpackage.nh
    public final nh write(byte[] bArr) {
        v(bArr.length, bArr);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, defpackage.c11
    public final void close() {
    }

    @Override // defpackage.nh, defpackage.c11, java.io.Flushable
    public final void flush() {
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        wy0 wy0Var = this.b;
        if (wy0Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), wy0Var.c - wy0Var.b);
        byteBuffer.put(wy0Var.a, wy0Var.b, iMin);
        int i = wy0Var.b + iMin;
        wy0Var.b = i;
        this.c -= (long) iMin;
        if (i == wy0Var.c) {
            this.b = wy0Var.a();
            xy0.x(wy0Var);
        }
        return iMin;
    }
}
