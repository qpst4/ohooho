package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jb0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ kb0 d;

    public jb0(kb0 kb0Var, int[] iArr, float f, float f2) {
        this.d = kb0Var;
        this.a = iArr;
        this.b = f;
        this.c = f2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        InkPageIndicator inkPageIndicator = this.d.d;
        inkPageIndicator.s = -1.0f;
        inkPageIndicator.t = -1.0f;
        inkPageIndicator.postInvalidateOnAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        InkPageIndicator inkPageIndicator = this.d.d;
        Arrays.fill(inkPageIndicator.r, 0.0f);
        inkPageIndicator.postInvalidateOnAnimation();
        for (int i : this.a) {
            inkPageIndicator.u[i] = 1.0E-5f;
            inkPageIndicator.postInvalidateOnAnimation();
        }
        inkPageIndicator.s = this.b;
        inkPageIndicator.t = this.c;
        inkPageIndicator.postInvalidateOnAnimation();
    }
}
