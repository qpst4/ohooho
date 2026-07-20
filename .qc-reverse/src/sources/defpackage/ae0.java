package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ae0 implements Closeable, Flushable {
    public static final Pattern m = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    public static final String[] n = new String[128];
    public static final String[] o;
    public final Writer b;
    public int[] c;
    public int d;
    public z20 e;
    public String f;
    public String g;
    public boolean h;
    public int i;
    public boolean j;
    public String k;
    public boolean l;

    static {
        for (int i = 0; i <= 31; i++) {
            n[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = n;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        o = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public ae0(Writer writer) {
        int[] iArr = new int[32];
        this.c = iArr;
        this.d = 0;
        if (iArr.length == 0) {
            this.c = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.c;
        int i = this.d;
        this.d = i + 1;
        iArr2[i] = 6;
        this.i = 2;
        this.l = true;
        Objects.requireNonNull(writer, "out == null");
        this.b = writer;
        v(z20.d);
    }

    public void A(Number number) throws IOException {
        if (number == null) {
            t();
            return;
        }
        D();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.i != 1) {
                    zy.n("Numeric values must be finite, but was ".concat(string));
                    return;
                }
            } else if (cls != Float.class && cls != Double.class && !m.matcher(string).matches()) {
                zy.i("String created by ", cls, " is not a valid JSON number: ", string);
                return;
            }
        }
        a();
        this.b.append((CharSequence) string);
    }

    public void B(String str) throws IOException {
        if (str == null) {
            t();
            return;
        }
        D();
        a();
        x(str);
    }

    public void C(boolean z) throws IOException {
        D();
        a();
        this.b.write(z ? "true" : "false");
    }

    public final void D() throws IOException {
        if (this.k != null) {
            int iU = u();
            if (iU == 5) {
                this.b.write(this.g);
            } else if (iU != 3) {
                s1.f("Nesting problem.");
                return;
            }
            s();
            this.c[this.d - 1] = 4;
            x(this.k);
            this.k = null;
        }
    }

    public final void a() throws IOException {
        int iU = u();
        if (iU == 1) {
            this.c[this.d - 1] = 2;
            s();
            return;
        }
        Writer writer = this.b;
        if (iU == 2) {
            writer.append((CharSequence) this.g);
            s();
            return;
        }
        if (iU == 4) {
            writer.append((CharSequence) this.f);
            this.c[this.d - 1] = 5;
            return;
        }
        if (iU != 6) {
            if (iU != 7) {
                s1.f("Nesting problem.");
                return;
            } else if (this.i != 1) {
                s1.f("JSON must have only one top-level value.");
                return;
            }
        }
        this.c[this.d - 1] = 7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
        int i = this.d;
        if (i > 1 || (i == 1 && this.c[i - 1] != 7)) {
            zy.p("Incomplete document");
        } else {
            this.d = 0;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.d != 0) {
            this.b.flush();
        } else {
            s1.f("JsonWriter is closed.");
        }
    }

    public void g() throws IOException {
        D();
        a();
        int i = this.d;
        int[] iArr = this.c;
        if (i == iArr.length) {
            this.c = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr2[i2] = 1;
        this.b.write(91);
    }

    public void h() throws IOException {
        D();
        a();
        int i = this.d;
        int[] iArr = this.c;
        if (i == iArr.length) {
            this.c = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr2[i2] = 3;
        this.b.write(123);
    }

    public final void i(char c, int i, int i2) throws IOException {
        int iU = u();
        if (iU != i2 && iU != i) {
            s1.f("Nesting problem.");
            return;
        }
        if (this.k != null) {
            zy.t("Dangling name: ", this.k);
            return;
        }
        this.d--;
        if (iU == i2) {
            s();
        }
        this.b.write(c);
    }

    public void m() throws IOException {
        i(']', 1, 2);
    }

    public void q() throws IOException {
        i('}', 3, 5);
    }

    public void r(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.k != null) {
            s1.f("Already wrote a name, expecting a value.");
            return;
        }
        int iU = u();
        if (iU == 3 || iU == 5) {
            this.k = str;
        } else {
            s1.f("Please begin an object before writing a name.");
        }
    }

    public final void s() throws IOException {
        if (this.h) {
            return;
        }
        String str = this.e.a;
        Writer writer = this.b;
        writer.write(str);
        int i = this.d;
        for (int i2 = 1; i2 < i; i2++) {
            writer.write(this.e.b);
        }
    }

    public ae0 t() throws IOException {
        if (this.k != null) {
            if (!this.l) {
                this.k = null;
                return this;
            }
            D();
        }
        a();
        this.b.write("null");
        return this;
    }

    public final int u() {
        int i = this.d;
        if (i != 0) {
            return this.c[i - 1];
        }
        s1.f("JsonWriter is closed.");
        return 0;
    }

    public final void v(z20 z20Var) {
        Objects.requireNonNull(z20Var);
        this.e = z20Var;
        this.g = ",";
        if (z20Var.c) {
            this.f = ": ";
            if (z20Var.a.isEmpty()) {
                this.g = ", ";
            }
        } else {
            this.f = ":";
        }
        this.h = this.e.a.isEmpty() && this.e.b.isEmpty();
    }

    public final void w(int i) {
        if (i == 0) {
            throw null;
        }
        this.i = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.j
            if (r0 == 0) goto L7
            java.lang.String[] r0 = defpackage.ae0.o
            goto L9
        L7:
            java.lang.String[] r0 = defpackage.ae0.n
        L9:
            java.io.Writer r7 = r7.b
            r1 = 34
            r7.write(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r2) goto L41
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L3e
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L3e
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L39
            int r6 = r3 - r4
            r7.write(r8, r4, r6)
        L39:
            r7.write(r5)
            int r4 = r3 + 1
        L3e:
            int r3 = r3 + 1
            goto L16
        L41:
            if (r4 >= r2) goto L47
            int r2 = r2 - r4
            r7.write(r8, r4, r2)
        L47:
            r7.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ae0.x(java.lang.String):void");
    }

    public void y(double d) throws IOException {
        D();
        if (this.i == 1 || !(Double.isNaN(d) || Double.isInfinite(d))) {
            a();
            this.b.append((CharSequence) Double.toString(d));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
    }

    public void z(long j) throws IOException {
        D();
        a();
        this.b.write(Long.toString(j));
    }
}
