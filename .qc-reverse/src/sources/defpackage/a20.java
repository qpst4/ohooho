package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a20 extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    public boolean a;
    public float b;
    public float c;
    public final /* synthetic */ d20 d;

    public a20(d20 d20Var) {
        this.d = d20Var;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f = (int) this.c;
        c20 c20Var = this.d.b;
        if (c20Var != null) {
            c20Var.j(f);
        }
        this.a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z = this.a;
        d20 d20Var = this.d;
        if (!z) {
            c20 c20Var = d20Var.b;
            this.b = c20Var == null ? 0.0f : c20Var.b.m;
            this.c = a();
            this.a = true;
        }
        float f = this.b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.c - f)) + f);
        c20 c20Var2 = d20Var.b;
        if (c20Var2 != null) {
            c20Var2.j(animatedFraction);
        }
    }
}
