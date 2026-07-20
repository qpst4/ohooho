package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class is extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ pu0 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ ns e;

    public is(ns nsVar, pu0 pu0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.e = nsVar;
        this.b = pu0Var;
        this.d = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 1:
                this.c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        pu0 pu0Var = this.b;
        ns nsVar = this.e;
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        switch (i) {
            case 0:
                viewPropertyAnimator.setListener(null);
                this.c.setAlpha(1.0f);
                nsVar.d(pu0Var);
                nsVar.q.remove(pu0Var);
                nsVar.j();
                break;
            default:
                viewPropertyAnimator.setListener(null);
                nsVar.d(pu0Var);
                nsVar.o.remove(pu0Var);
                nsVar.j();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                this.e.getClass();
                break;
            default:
                this.e.getClass();
                break;
        }
    }

    public is(ns nsVar, pu0 pu0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.e = nsVar;
        this.b = pu0Var;
        this.c = view;
        this.d = viewPropertyAnimator;
    }
}
