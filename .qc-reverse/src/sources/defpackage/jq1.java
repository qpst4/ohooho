package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jq1 {
    public static final jq1 f = new jq1(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public jq1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static jq1 b() {
        return new jq1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iQ;
        int iA;
        int iQ2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iG = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.c[i2]).getClass();
                    iQ2 = zo1.q(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    yo1 yo1Var = (yo1) this.c[i2];
                    int iQ3 = zo1.q(i6);
                    int iD = yo1Var.d();
                    iG = qq0.g(iD, iD, iQ3, iG);
                } else if (i5 == 3) {
                    int iQ4 = zo1.q(i4 << 3);
                    iQ = iQ4 + iQ4;
                    iA = ((jq1) this.c[i2]).a();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(new mp1());
                    }
                    ((Integer) this.c[i2]).getClass();
                    iQ2 = zo1.q(i4 << 3) + 4;
                }
                iG = iQ2 + iG;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.c[i2]).longValue();
                iQ = zo1.q(i7);
                iA = zo1.a(jLongValue);
            }
            iG = iA + iQ + iG;
        }
        this.d = iG;
        return iG;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            zy.a();
            return;
        }
        e(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void d(tb0 tb0Var) throws ap1 {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    ((zo1) tb0Var.c).n(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    ((zo1) tb0Var.c).f(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    ((zo1) tb0Var.c).c(i4, (yo1) obj);
                } else if (i3 == 3) {
                    ((zo1) tb0Var.c).k(i4, 3);
                    ((jq1) obj).d(tb0Var);
                    ((zo1) tb0Var.c).k(i4, 4);
                } else {
                    if (i3 != 5) {
                        zy.m(new mp1());
                        return;
                    }
                    ((zo1) tb0Var.c).d(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof jq1)) {
            jq1 jq1Var = (jq1) obj;
            int i = this.a;
            if (i == jq1Var.a) {
                int[] iArr = this.b;
                int[] iArr2 = jq1Var.b;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.c;
                        Object[] objArr2 = jq1Var.c;
                        int i3 = this.a;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    }
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = i + 527;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }
}
