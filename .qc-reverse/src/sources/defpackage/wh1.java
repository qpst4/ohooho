package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wh1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ci1 a;
    public final /* synthetic */ wi1 b;
    public final /* synthetic */ wi1 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public wh1(ci1 ci1Var, wi1 wi1Var, wi1 wi1Var2, int i, View view) {
        this.a = ci1Var;
        this.b = wi1Var;
        this.c = wi1Var2;
        this.d = i;
        this.e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        ci1 ci1Var = this.a;
        bi1 bi1Var = ci1Var.a;
        bi1Var.d(animatedFraction);
        float fB = bi1Var.b();
        PathInterpolator pathInterpolator = yh1.e;
        int i = Build.VERSION.SDK_INT;
        wi1 wi1Var = this.b;
        ji1 ii1Var = i >= 34 ? new ii1(wi1Var) : i >= 31 ? new hi1(wi1Var) : i >= 30 ? new gi1(wi1Var) : i >= 29 ? new fi1(wi1Var) : new di1(wi1Var);
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            int i3 = this.d & i2;
            ri1 ri1Var = wi1Var.a;
            if (i3 == 0) {
                ii1Var.c(i2, ri1Var.f(i2));
            } else {
                xb0 xb0VarF = ri1Var.f(i2);
                xb0 xb0VarF2 = this.c.a.f(i2);
                float f = 1.0f - fB;
                ii1Var.c(i2, wi1.e(xb0VarF, (int) (((double) ((xb0VarF.a - xb0VarF2.a) * f)) + 0.5d), (int) (((double) ((xb0VarF.b - xb0VarF2.b) * f)) + 0.5d), (int) (((double) ((xb0VarF.c - xb0VarF2.c) * f)) + 0.5d), (int) (((double) ((xb0VarF.d - xb0VarF2.d) * f)) + 0.5d)));
            }
        }
        yh1.g(this.e, ii1Var.b(), Collections.singletonList(ci1Var));
    }
}
