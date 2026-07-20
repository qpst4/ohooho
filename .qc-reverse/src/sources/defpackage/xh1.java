package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xh1 implements View.OnApplyWindowInsetsListener {
    public final eo a;
    public wi1 b;

    public xh1(View view, eo eoVar) {
        wi1 wi1VarB;
        this.a = eoVar;
        WeakHashMap weakHashMap = uf1.a;
        wi1 wi1VarA = mf1.a(view);
        if (wi1VarA != null) {
            int i = Build.VERSION.SDK_INT;
            wi1VarB = (i >= 34 ? new ii1(wi1VarA) : i >= 31 ? new hi1(wi1VarA) : i >= 30 ? new gi1(wi1VarA) : i >= 29 ? new fi1(wi1VarA) : new di1(wi1VarA)).b();
        } else {
            wi1VarB = null;
        }
        this.b = wi1VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z;
        if (!view.isLaidOut()) {
            this.b = wi1.h(view, windowInsets);
            return yh1.i(view, windowInsets);
        }
        wi1 wi1VarH = wi1.h(view, windowInsets);
        ri1 ri1Var = wi1VarH.a;
        if (this.b == null) {
            WeakHashMap weakHashMap = uf1.a;
            this.b = mf1.a(view);
        }
        if (this.b == null) {
            this.b = wi1VarH;
            return yh1.i(view, windowInsets);
        }
        eo eoVarJ = yh1.j(view);
        if (eoVarJ != null && Objects.equals((wi1) eoVarJ.c, wi1VarH)) {
            return yh1.i(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        wi1 wi1Var = this.b;
        int i = 1;
        while (i <= 512) {
            xb0 xb0VarF = ri1Var.f(i);
            xb0 xb0VarF2 = wi1Var.a.f(i);
            int i2 = xb0VarF.a;
            int i3 = xb0VarF.d;
            int i4 = xb0VarF.c;
            int i5 = xb0VarF.b;
            int i6 = xb0VarF2.a;
            int i7 = xb0VarF2.d;
            int i8 = xb0VarF2.c;
            int i9 = xb0VarF2.b;
            if (i2 > i6 || i5 > i9 || i4 > i8 || i3 > i7) {
                iArr = iArr2;
                z = true;
            } else {
                iArr = iArr2;
                z = false;
            }
            if (z != (i2 < i6 || i5 < i9 || i4 < i8 || i3 < i7)) {
                if (z) {
                    iArr[0] = iArr[0] | i;
                } else {
                    iArr3[0] = iArr3[0] | i;
                }
            }
            i <<= 1;
            iArr2 = iArr;
        }
        boolean z2 = false;
        int i10 = iArr2[0];
        int i11 = iArr3[0];
        int i12 = i10 | i11;
        if (i12 == 0) {
            this.b = wi1VarH;
            return yh1.i(view, windowInsets);
        }
        wi1 wi1Var2 = this.b;
        ci1 ci1Var = new ci1(i12, (i10 & 8) != 0 ? yh1.e : (i11 & 8) != 0 ? yh1.f : (i10 & 519) != 0 ? yh1.g : (i11 & 519) != 0 ? yh1.h : null, (i12 & 8) != 0 ? 160L : 250L);
        ci1Var.a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(ci1Var.a.a());
        xb0 xb0VarF3 = ri1Var.f(i12);
        xb0 xb0VarF4 = wi1Var2.a.f(i12);
        int iMin = Math.min(xb0VarF3.a, xb0VarF4.a);
        int i13 = xb0VarF3.b;
        int i14 = xb0VarF4.b;
        int iMin2 = Math.min(i13, i14);
        int i15 = xb0VarF3.c;
        int i16 = xb0VarF4.c;
        int iMin3 = Math.min(i15, i16);
        int i17 = xb0VarF3.d;
        int i18 = xb0VarF4.d;
        pn0 pn0Var = new pn0(xb0.b(iMin, iMin2, iMin3, Math.min(i17, i18)), xb0.b(Math.max(xb0VarF3.a, xb0VarF4.a), Math.max(i13, i14), Math.max(i15, i16), Math.max(i17, i18)), 16, z2);
        yh1.f(view, wi1VarH, false);
        duration.addUpdateListener(new wh1(ci1Var, wi1VarH, wi1Var2, i12, view));
        duration.addListener(new p3(ci1Var, view));
        go0.a(view, new qv0(view, ci1Var, pn0Var, duration));
        this.b = wi1VarH;
        return yh1.i(view, windowInsets);
    }
}
