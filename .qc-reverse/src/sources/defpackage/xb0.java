package defpackage;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xb0 {
    public static final xb0 e = new xb0(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public xb0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static xb0 a(xb0 xb0Var, xb0 xb0Var2) {
        return b(Math.max(xb0Var.a, xb0Var2.a), Math.max(xb0Var.b, xb0Var2.b), Math.max(xb0Var.c, xb0Var2.c), Math.max(xb0Var.d, xb0Var2.d));
    }

    public static xb0 b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new xb0(i, i2, i3, i4);
    }

    public static xb0 c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return ua.f(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xb0.class != obj.getClass()) {
            return false;
        }
        xb0 xb0Var = (xb0) obj;
        return this.d == xb0Var.d && this.a == xb0Var.a && this.c == xb0Var.c && this.b == xb0Var.b;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
