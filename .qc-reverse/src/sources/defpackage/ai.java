package defpackage;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ai implements Serializable, Comparable {
    public static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ai f = f(new byte[0]);
    public final byte[] b;
    public transient int c;
    public transient String d;

    public ai(byte[] bArr) {
        this.b = bArr;
    }

    public static void a(String str) {
        if (str.length() % 2 != 0) {
            zy.n("Unexpected hex string: ".concat(str));
            return;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (b(str.charAt(i2 + 1)) + (b(str.charAt(i2)) << 4));
        }
        f(bArr);
    }

    public static int b(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static ai c(String str) {
        if (str == null) {
            zy.n("s == null");
            return null;
        }
        ai aiVar = new ai(str.getBytes(ce1.a));
        aiVar.d = str;
        return aiVar;
    }

    public static ai f(byte... bArr) {
        if (bArr != null) {
            return new ai((byte[]) bArr.clone());
        }
        zy.n("data == null");
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ai aiVar = (ai) obj;
        int i = i();
        int i2 = aiVar.i();
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            int iD = d(i3) & 255;
            int iD2 = aiVar.d(i3) & 255;
            if (iD != iD2) {
                return iD < iD2 ? -1 : 1;
            }
        }
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public byte d(int i) {
        return this.b[i];
    }

    public String e() {
        byte[] bArr = this.b;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = e;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ai) {
            ai aiVar = (ai) obj;
            int i = aiVar.i();
            byte[] bArr = this.b;
            if (i == bArr.length && aiVar.g(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.b;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
                Charset charset = ce1.a;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (bArr2[i4 + i] == bArr[i4 + i2]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean h(ai aiVar, int i) {
        return aiVar.g(0, this.b, 0, i);
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b);
        this.c = iHashCode;
        return iHashCode;
    }

    public int i() {
        return this.b.length;
    }

    public ai j() {
        byte[] bArr = this.b;
        if (64 > bArr.length) {
            s1.g("endIndex > length(", bArr.length, ")");
            return null;
        }
        if (64 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, 64);
        return new ai(bArr2);
    }

    public ai k() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ai(bArr2);
            }
            i++;
        }
    }

    public String l() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b, ce1.a);
        this.d = str2;
        return str2;
    }

    public void m(mh mhVar) {
        byte[] bArr = this.b;
        mhVar.v(bArr.length, bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r4 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            byte[] r0 = r10.b
            int r1 = r0.length
            if (r1 != 0) goto L8
            java.lang.String r10 = "[size=0]"
            return r10
        L8:
            java.lang.String r1 = r10.l()
            int r2 = r1.length()
            r3 = 0
            r4 = r3
            r5 = r4
        L13:
            r6 = -1
            r7 = 64
            if (r4 >= r2) goto L3c
            if (r5 != r7) goto L1b
            goto L40
        L1b:
            int r8 = r1.codePointAt(r4)
            boolean r9 = java.lang.Character.isISOControl(r8)
            if (r9 == 0) goto L2d
            r9 = 10
            if (r8 == r9) goto L2d
            r9 = 13
            if (r8 != r9) goto L32
        L2d:
            r9 = 65533(0xfffd, float:9.1831E-41)
            if (r8 != r9) goto L34
        L32:
            r4 = r6
            goto L40
        L34:
            int r5 = r5 + 1
            int r6 = java.lang.Character.charCount(r8)
            int r4 = r4 + r6
            goto L13
        L3c:
            int r4 = r1.length()
        L40:
            java.lang.String r2 = "…]"
            java.lang.String r5 = "[size="
            java.lang.String r8 = "]"
            if (r4 != r6) goto L82
            int r1 = r0.length
            if (r1 > r7) goto L61
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[hex="
            r0.<init>(r1)
            java.lang.String r10 = r10.e()
            r0.append(r10)
            r0.append(r8)
            java.lang.String r10 = r0.toString()
            return r10
        L61:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            int r0 = r0.length
            r1.append(r0)
            java.lang.String r0 = " hex="
            r1.append(r0)
            ai r10 = r10.j()
            java.lang.String r10 = r10.e()
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            return r10
        L82:
            java.lang.String r10 = r1.substring(r3, r4)
            java.lang.String r3 = "\\"
            java.lang.String r6 = "\\\\"
            java.lang.String r10 = r10.replace(r3, r6)
            java.lang.String r3 = "\n"
            java.lang.String r6 = "\\n"
            java.lang.String r10 = r10.replace(r3, r6)
            java.lang.String r3 = "\r"
            java.lang.String r6 = "\\r"
            java.lang.String r10 = r10.replace(r3, r6)
            int r1 = r1.length()
            if (r4 >= r1) goto Lbd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            int r0 = r0.length
            r1.append(r0)
            java.lang.String r0 = " text="
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            return r10
        Lbd:
            java.lang.String r0 = "[text="
            java.lang.String r10 = defpackage.l11.j(r0, r10, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ai.toString():java.lang.String");
    }
}
