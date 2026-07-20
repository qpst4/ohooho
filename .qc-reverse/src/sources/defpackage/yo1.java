package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class yo1 implements Iterable, Serializable {
    public static final yo1 d = new yo1(lp1.b);
    public int b = 0;
    public final byte[] c;

    static {
        int i = to1.a;
    }

    public yo1(byte[] bArr) {
        bArr.getClass();
        this.c = bArr;
    }

    public static int e(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i >= 0) {
            if (i2 < i) {
                throw new IndexOutOfBoundsException(qq0.h(i, i2, "Beginning index larger than ending index: ", ", "));
            }
            throw new IndexOutOfBoundsException(qq0.h(i2, i3, "End index: ", " >= "));
        }
        throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
    }

    public static yo1 f(byte[] bArr, int i, int i2) {
        e(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new yo1(bArr2);
    }

    public byte b(int i) {
        return this.c[i];
    }

    public byte c(int i) {
        return this.c[i];
    }

    public int d() {
        return this.c.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof yo1) && d() == ((yo1) obj).d()) {
            if (d() == 0) {
                return true;
            }
            if (!(obj instanceof yo1)) {
                return obj.equals(this);
            }
            yo1 yo1Var = (yo1) obj;
            int i = this.b;
            int i2 = yo1Var.b;
            if (i == 0 || i2 == 0 || i == i2) {
                int iD = d();
                if (iD > yo1Var.d()) {
                    throw new IllegalArgumentException("Length too large: " + iD + d());
                }
                if (iD > yo1Var.d()) {
                    zy.n(qq0.h(iD, yo1Var.d(), "Ran off end of other: 0, ", ", "));
                    return false;
                }
                byte[] bArr = yo1Var.c;
                int i3 = 0;
                int i4 = 0;
                while (i3 < iD) {
                    if (this.c[i3] == bArr[i4]) {
                        i3++;
                        i4++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iD = d();
        int i2 = iD;
        for (int i3 = 0; i3 < iD; i3++) {
            i2 = (i2 * 31) + this.c[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.b = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new xh(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iD = d();
        if (d() <= 50) {
            strConcat = fp1.I(this);
        } else {
            int iE = e(0, 47, d());
            strConcat = fp1.I(iE == 0 ? d : new xo1(iE, this.c)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iD);
        sb.append(" contents=\"");
        return l11.k(sb, strConcat, "\">");
    }
}
