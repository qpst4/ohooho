package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class zb0 implements Iterable, ce0 {
    public final int b;
    public final int c;
    public final int d;

    public zb0(int i, int i2, int i3) {
        if (i3 == 0) {
            zy.n("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            zy.n("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.b = i;
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                int i5 = i % i3;
                int i6 = ((i4 < 0 ? i4 + i3 : i4) - (i5 < 0 ? i5 + i3 : i5)) % i3;
                i2 -= i6 < 0 ? i6 + i3 : i6;
            }
        } else {
            if (i3 >= 0) {
                zy.n("Step is zero.");
                throw null;
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                int i9 = i2 % i7;
                int i10 = ((i8 < 0 ? i8 + i7 : i8) - (i9 < 0 ? i9 + i7 : i9)) % i7;
                i2 += i10 < 0 ? i10 + i7 : i10;
            }
        }
        this.c = i2;
        this.d = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zb0)) {
            return false;
        }
        if (isEmpty() && ((zb0) obj).isEmpty()) {
            return true;
        }
        zb0 zb0Var = (zb0) obj;
        return this.b == zb0Var.b && this.c == zb0Var.c && this.d == zb0Var.d;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public boolean isEmpty() {
        int i = this.c;
        int i2 = this.d;
        int i3 = this.b;
        return i2 > 0 ? i3 > i : i3 < i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new ac0(this.b, this.c, this.d);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.c;
        int i2 = this.d;
        int i3 = this.b;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i2);
        }
        return sb.toString();
    }
}
