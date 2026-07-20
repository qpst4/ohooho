package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vd0 implements Closeable {
    public final Reader b;
    public long i;
    public int j;
    public String k;
    public int[] l;
    public String[] n;
    public int[] o;
    public int p = 2;
    public final char[] c = new char[1024];
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int m = 1;

    static {
        c70.k = new c70(19);
    }

    public vd0(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.b = reader;
    }

    public int A() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            long j = this.i;
            int i2 = (int) j;
            if (j == i2) {
                this.h = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + x());
        }
        if (i == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw R("an int");
            }
            if (i == 10) {
                this.k = H();
            } else {
                this.k = F(i == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        int i6 = (int) d;
        if (i6 == d) {
            this.k = null;
            this.h = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + x());
    }

    public long B() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw R("a long");
            }
            if (i == 10) {
                this.k = H();
            } else {
                this.k = F(i == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i3 = this.m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        long j2 = (long) d;
        if (j2 == d) {
            this.k = null;
            this.h = 0;
            int[] iArr3 = this.o;
            int i4 = this.m - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + x());
    }

    public String C() throws IOException {
        String strF;
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 14) {
            strF = H();
        } else if (i == 12) {
            strF = F('\'');
        } else {
            if (i != 13) {
                throw R("a name");
            }
            strF = F('\"');
        }
        this.h = 0;
        this.n[this.m - 1] = strF;
        return strF;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int D(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd0.D(boolean):int");
    }

    public void E() {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i != 7) {
            throw R("null");
        }
        this.h = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String F(char r12) throws defpackage.ej0 {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.d
            int r3 = r11.e
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.c
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.p
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.Q(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r3, r8)
            return r11
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.K()
            r1.append(r2)
            int r2 = r11.d
            int r3 = r11.e
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.f
            int r2 = r2 + r6
            r11.f = r2
            r11.g = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.d = r2
            boolean r2 = r11.r(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.Q(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd0.F(char):java.lang.String");
    }

    public String G() {
        String str;
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 10) {
            str = H();
        } else if (i == 8) {
            str = F('\'');
        } else if (i == 9) {
            str = F('\"');
        } else if (i == 11) {
            str = this.k;
            this.k = null;
        } else if (i == 15) {
            str = Long.toString(this.i);
        } else {
            if (i != 16) {
                throw R("a string");
            }
            str = new String(this.c, this.d, this.j);
            this.d += this.j;
        }
        this.h = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        h();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String H() throws defpackage.ej0 {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.d
            int r3 = r3 + r2
            int r4 = r6.e
            char[] r5 = r6.c
            if (r3 >= r4) goto L4c
            char r3 = r5[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r6.h()
            goto L58
        L4c:
            int r3 = r5.length
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r6.r(r3)
            if (r3 == 0) goto L58
            goto L3
        L58:
            r1 = r2
            goto L78
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            int r3 = r6.d
            r0.append(r5, r3, r2)
            int r3 = r6.d
            int r3 = r3 + r2
            r6.d = r3
            r2 = 1
            boolean r2 = r6.r(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.d
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.d
            int r2 = r2 + r1
            r6.d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd0.H():java.lang.String");
    }

    public int I() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void J(int i) throws ej0 {
        int i2 = this.m;
        if (i2 - 1 >= 255) {
            throw new ej0("Nesting limit 255 reached".concat(x()));
        }
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    public final char K() throws ej0 {
        int i;
        if (this.d == this.e && !r(1)) {
            Q("Unterminated escape sequence");
            throw null;
        }
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        char[] cArr = this.c;
        char c = cArr[i2];
        if (c != '\n') {
            if (c != '\"') {
                if (c != '\'') {
                    if (c != '/' && c != '\\') {
                        if (c == 'b') {
                            return '\b';
                        }
                        if (c == 'f') {
                            return '\f';
                        }
                        if (c == 'n') {
                            return '\n';
                        }
                        if (c == 'r') {
                            return '\r';
                        }
                        if (c == 't') {
                            return '\t';
                        }
                        if (c != 'u') {
                            Q("Invalid escape sequence");
                            throw null;
                        }
                        if (i2 + 5 > this.e && !r(4)) {
                            Q("Unterminated escape sequence");
                            throw null;
                        }
                        int i4 = this.d;
                        int i5 = i4 + 4;
                        int i6 = 0;
                        while (i4 < i5) {
                            char c2 = cArr[i4];
                            int i7 = i6 << 4;
                            if (c2 >= '0' && c2 <= '9') {
                                i = c2 - '0';
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                i = c2 - 'W';
                            } else {
                                if (c2 < 'A' || c2 > 'F') {
                                    Q("Malformed Unicode escape \\u".concat(new String(cArr, this.d, 4)));
                                    throw null;
                                }
                                i = c2 - '7';
                            }
                            i6 = i + i7;
                            i4++;
                        }
                        this.d += 4;
                        return (char) i6;
                    }
                }
            }
            return c;
        }
        if (this.p == 3) {
            Q("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.f++;
        this.g = i3;
        if (this.p == 3) {
            Q("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c;
    }

    public final void L(int i) {
        if (i == 0) {
            throw null;
        }
        this.p = i;
    }

    public final void M(char c) throws ej0 {
        do {
            int i = this.d;
            int i2 = this.e;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = this.c[i];
                if (c2 == c) {
                    this.d = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.d = i3;
                    K();
                    i = this.d;
                    i2 = this.e;
                } else {
                    if (c2 == '\n') {
                        this.f++;
                        this.g = i3;
                    }
                    i = i3;
                }
            }
            this.d = i;
        } while (r(1));
        Q("Unterminated string");
        throw null;
    }

    public final void N() {
        char c;
        do {
            if (this.d >= this.e && !r(1)) {
                return;
            }
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            c = this.c[i];
            if (c == '\n') {
                this.f++;
                this.g = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O() throws defpackage.ej0 {
        /*
            r3 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r3.d
            int r1 = r1 + r0
            int r2 = r3.e
            if (r1 >= r2) goto L4f
            char[] r2 = r3.c
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L49
            r2 = 10
            if (r1 == r2) goto L49
            r2 = 12
            if (r1 == r2) goto L49
            r2 = 13
            if (r1 == r2) goto L49
            r2 = 32
            if (r1 == r2) goto L49
            r2 = 35
            if (r1 == r2) goto L46
            r2 = 44
            if (r1 == r2) goto L49
            r2 = 47
            if (r1 == r2) goto L46
            r2 = 61
            if (r1 == r2) goto L46
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L49
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L49
            r2 = 58
            if (r1 == r2) goto L49
            r2 = 59
            if (r1 == r2) goto L46
            switch(r1) {
                case 91: goto L49;
                case 92: goto L46;
                case 93: goto L49;
                default: goto L43;
            }
        L43:
            int r0 = r0 + 1
            goto L1
        L46:
            r3.h()
        L49:
            int r1 = r3.d
            int r1 = r1 + r0
            r3.d = r1
            return
        L4f:
            r3.d = r1
            r0 = 1
            boolean r0 = r3.r(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd0.O():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void P() throws IOException {
        int i = 0;
        do {
            int i2 = this.h;
            if (i2 == 0) {
                i2 = i();
            }
            switch (i2) {
                case 1:
                    J(3);
                    i++;
                    this.h = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.n[this.m - 1] = null;
                    }
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 3:
                    J(1);
                    i++;
                    this.h = 0;
                    break;
                case 4:
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.h = 0;
                    break;
                case 8:
                    M('\'');
                    this.h = 0;
                    break;
                case 9:
                    M('\"');
                    this.h = 0;
                    break;
                case 10:
                    O();
                    this.h = 0;
                    break;
                case 12:
                    M('\'');
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 13:
                    M('\"');
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 14:
                    O();
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 16:
                    this.d += this.j;
                    this.h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public final void Q(String str) throws ej0 {
        StringBuilder sbL = l11.l(str);
        sbL.append(x());
        sbL.append("\nSee ");
        sbL.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new ej0(sbL.toString());
    }

    public final IllegalStateException R(String str) {
        String str2 = I() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbM = l11.m("Expected ", str, " but was ");
        sbM.append(l11.u(I()));
        sbM.append(x());
        sbM.append("\nSee ");
        sbM.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbM.toString());
    }

    public void a() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i != 3) {
            throw R("BEGIN_ARRAY");
        }
        J(1);
        this.o[this.m - 1] = 0;
        this.h = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    public void g() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i != 1) {
            throw R("BEGIN_OBJECT");
        }
        J(3);
        this.h = 0;
    }

    public final void h() throws ej0 {
        if (this.p == 1) {
            return;
        }
        Q("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x01cd, code lost:
    
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0222, code lost:
    
        if (w(r14) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x027e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd0.i():int");
    }

    public void m() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i != 4) {
            throw R("END_ARRAY");
        }
        int i2 = this.m;
        this.m = i2 - 1;
        int[] iArr = this.o;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.h = 0;
    }

    public void q() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i != 2) {
            throw R("END_OBJECT");
        }
        int i2 = this.m;
        int i3 = i2 - 1;
        this.m = i3;
        this.n[i3] = null;
        int[] iArr = this.o;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.h = 0;
    }

    public final boolean r(int i) throws IOException {
        int i2;
        int i3;
        int i4 = this.g;
        int i5 = this.d;
        this.g = i4 - i5;
        int i6 = this.e;
        char[] cArr = this.c;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.e = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            int i8 = this.e;
            int i9 = this.b.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.e + i9;
            this.e = i2;
            if (this.f == 0 && (i3 = this.g) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.d++;
                this.g = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    public String s() {
        return t(false);
    }

    public final String t(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.l[i];
            switch (i3) {
                case 1:
                case 2:
                    int i4 = this.o[i];
                    if (z && i4 > 0 && i == i2 - 1) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.n[i];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(qq0.i("Unknown scope value: ", i3));
            }
            i++;
        }
    }

    public String toString() {
        return getClass().getSimpleName().concat(x());
    }

    public String u() {
        return t(true);
    }

    public boolean v() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public final boolean w(char c) throws ej0 {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        h();
        return false;
    }

    final String x() {
        return " at line " + (this.f + 1) + " column " + ((this.d - this.g) + 1) + " path " + s();
    }

    public boolean y() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 5) {
            this.h = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i != 6) {
            throw R("a boolean");
        }
        this.h = 0;
        int[] iArr2 = this.o;
        int i3 = this.m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public double z() throws IOException {
        int i = this.h;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (i == 8 || i == 9) {
            this.k = F(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.k = H();
        } else if (i != 11) {
            throw R("a double");
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        if (this.p != 1 && (Double.isNaN(d) || Double.isInfinite(d))) {
            Q("JSON forbids NaN and infinities: " + d);
            throw null;
        }
        this.k = null;
        this.h = 0;
        int[] iArr2 = this.o;
        int i3 = this.m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d;
    }
}
