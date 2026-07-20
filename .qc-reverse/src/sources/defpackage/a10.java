package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a10 extends AnimatorListenerAdapter implements s81 {
    public final View a;
    public boolean b = false;

    public a10(View view) {
        this.a = view;
    }

    @Override // defpackage.s81
    public final void b() {
        View view = this.a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? ug1.a.n(view) : 0.0f));
    }

    @Override // defpackage.s81
    public final void c() {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ug1.a.x(this.a, 1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.b;
        View view = this.a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        ah1 ah1Var = ug1.a;
        ah1Var.x(view, 1.0f);
        ah1Var.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // defpackage.s81
    public final void a(t81 t81Var) {
    }

    @Override // defpackage.s81
    public final void d(t81 t81Var) {
    }

    @Override // defpackage.s81
    public final void e(t81 t81Var) {
    }

    @Override // defpackage.s81
    public final void f(t81 t81Var) {
    }
}
