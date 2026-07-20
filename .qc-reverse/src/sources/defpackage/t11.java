package defpackage;

import android.content.res.ColorStateList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t11 implements Cloneable {
    public /* synthetic */ int[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public t11() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.b = new int[i4];
        this.c = new Object[i4];
    }

    public final void a(int i, ColorStateList colorStateList) {
        int i2 = this.d;
        if (i2 != 0 && i <= this.b[i2 - 1]) {
            b(i, colorStateList);
            return;
        }
        if (i2 >= this.b.length) {
            int i3 = (i2 + 1) * 4;
            int i4 = 4;
            while (true) {
                if (i4 >= 32) {
                    break;
                }
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
                i4++;
            }
            int i6 = i3 / 4;
            this.b = Arrays.copyOf(this.b, i6);
            this.c = Arrays.copyOf(this.c, i6);
        }
        this.b[i2] = i;
        this.c[i2] = colorStateList;
        this.d = i2 + 1;
    }

    public final void b(int i, Object obj) {
        int iE = f01.e(this.d, i, this.b);
        if (iE >= 0) {
            this.c[iE] = obj;
            return;
        }
        int i2 = ~iE;
        int i3 = this.d;
        if (i2 < i3) {
            Object[] objArr = this.c;
            if (objArr[i2] == xy0.g) {
                this.b[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (i3 >= this.b.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            this.b = Arrays.copyOf(this.b, i7);
            this.c = Arrays.copyOf(this.c, i7);
        }
        int i8 = this.d;
        if (i8 - i2 != 0) {
            int[] iArr = this.b;
            int i9 = i2 + 1;
            pb.e0(i9, i2, i8, iArr, iArr);
            Object[] objArr2 = this.c;
            pb.f0(i9, i2, this.d, objArr2, objArr2);
        }
        this.b[i2] = i;
        this.c[i2] = obj;
        this.d++;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        t11 t11Var = (t11) objClone;
        t11Var.b = (int[]) this.b.clone();
        t11Var.c = (Object[]) this.c.clone();
        return t11Var;
    }

    public final String toString() {
        int i = this.d;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i2 = this.d;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.b[i3]);
            sb.append('=');
            Object obj = this.c[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
