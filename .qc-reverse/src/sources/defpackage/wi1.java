package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wi1 {
    public static final wi1 b;
    public final ri1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = qi1.s;
        } else if (i >= 30) {
            b = oi1.r;
        } else {
            b = ri1.b;
        }
    }

    public wi1(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.a = new qi1(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.a = new pi1(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new oi1(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new ni1(this, windowInsets);
        } else if (i >= 28) {
            this.a = new mi1(this, windowInsets);
        } else {
            this.a = new li1(this, windowInsets);
        }
    }

    public static xb0 e(xb0 xb0Var, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, xb0Var.a - i);
        int iMax2 = Math.max(0, xb0Var.b - i2);
        int iMax3 = Math.max(0, xb0Var.c - i3);
        int iMax4 = Math.max(0, xb0Var.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? xb0Var : xb0.b(iMax, iMax2, iMax3, iMax4);
    }

    public static wi1 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        wi1 wi1Var = new wi1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = uf1.a;
            wi1 wi1VarA = mf1.a(view);
            ri1 ri1Var = wi1Var.a;
            ri1Var.p(wi1VarA);
            ri1Var.d(view.getRootView());
            ri1Var.r(view.getWindowSystemUiVisibility());
        }
        return wi1Var;
    }

    public final int a() {
        return this.a.j().d;
    }

    public final int b() {
        return this.a.j().a;
    }

    public final int c() {
        return this.a.j().c;
    }

    public final int d() {
        return this.a.j().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wi1) {
            return Objects.equals(this.a, ((wi1) obj).a);
        }
        return false;
    }

    public final wi1 f(int i, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        ji1 ii1Var = i5 >= 34 ? new ii1(this) : i5 >= 31 ? new hi1(this) : i5 >= 30 ? new gi1(this) : i5 >= 29 ? new fi1(this) : new di1(this);
        ii1Var.g(xb0.b(i, i2, i3, i4));
        return ii1Var.b();
    }

    public final WindowInsets g() {
        ri1 ri1Var = this.a;
        if (ri1Var instanceof ki1) {
            return ((ki1) ri1Var).c;
        }
        return null;
    }

    public final int hashCode() {
        ri1 ri1Var = this.a;
        if (ri1Var == null) {
            return 0;
        }
        return ri1Var.hashCode();
    }

    public wi1() {
        this.a = new ri1(this);
    }
}
