package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pc0 implements Animator.AnimatorListener {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final pu0 e;
    public final int f;
    public final ValueAnimator g;
    public boolean h;
    public float i;
    public float j;
    public boolean k = false;
    public boolean l = false;
    public float m;
    public final /* synthetic */ int n;
    public final /* synthetic */ pu0 o;
    public final /* synthetic */ sc0 p;

    public pc0(sc0 sc0Var, pu0 pu0Var, int i, float f, float f2, float f3, float f4, int i2, pu0 pu0Var2) {
        this.p = sc0Var;
        this.n = i2;
        this.o = pu0Var2;
        this.f = i;
        this.e = pu0Var;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new wg(4, this));
        valueAnimatorOfFloat.setTarget(pu0Var.a);
        valueAnimatorOfFloat.addListener(this);
        this.m = 0.0f;
    }

    public final void a(Animator animator) {
        if (!this.l) {
            this.e.o(true);
        }
        this.l = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.m = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(animator);
        if (this.k) {
            return;
        }
        int i = this.n;
        pu0 pu0Var = this.o;
        sc0 sc0Var = this.p;
        if (i <= 0) {
            sc0Var.m.getClass();
            t3.a(pu0Var);
        } else {
            sc0Var.a.add(pu0Var.a);
            this.h = true;
            if (i > 0) {
                sc0Var.r.post(new vn1(sc0Var, this, i));
            }
        }
        View view = sc0Var.w;
        View view2 = pu0Var.a;
        if (view == view2 && view2 == view) {
            sc0Var.w = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
