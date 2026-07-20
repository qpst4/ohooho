package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p3 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public p3(ci1 ci1Var, View view) {
        this.a = 2;
        this.b = ci1Var;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                super.onAnimationEnd(animator);
                TypedValue typedValue = new TypedValue();
                ((q3) obj).t.getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                ((pu0) obj2).a.setBackgroundResource(typedValue.resourceId);
                break;
            case 1:
                ((kb) obj2).remove(animator);
                ((t81) obj).p.remove(animator);
                break;
            default:
                ((ci1) obj2).a.d(1.0f);
                yh1.e((View) obj);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 1:
                ((t81) this.c).p.add(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ p3(Object obj, int i, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }
}
