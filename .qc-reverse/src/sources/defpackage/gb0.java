package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gb0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ InkPageIndicator b;

    public /* synthetic */ gb0(InkPageIndicator inkPageIndicator, int i) {
        this.a = i;
        this.b = inkPageIndicator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        InkPageIndicator inkPageIndicator = this.b;
        switch (i) {
            case 0:
                int i2 = InkPageIndicator.K;
                inkPageIndicator.e();
                inkPageIndicator.w = false;
                break;
            default:
                inkPageIndicator.p = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 1:
                this.b.p = false;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
