package defpackage;

import android.animation.ValueAnimator;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ib0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ kb0 b;

    public /* synthetic */ ib0(kb0 kb0Var, int i) {
        this.a = i;
        this.b = kb0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        int i2 = 0;
        kb0 kb0Var = this.b;
        switch (i) {
            case 0:
                InkPageIndicator inkPageIndicator = kb0Var.d;
                inkPageIndicator.s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                inkPageIndicator.postInvalidateOnAnimation();
                lb0[] lb0VarArr = inkPageIndicator.F;
                int length = lb0VarArr.length;
                while (i2 < length) {
                    lb0VarArr[i2].a(inkPageIndicator.s);
                    i2++;
                }
                break;
            default:
                InkPageIndicator inkPageIndicator2 = kb0Var.d;
                inkPageIndicator2.t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                inkPageIndicator2.postInvalidateOnAnimation();
                lb0[] lb0VarArr2 = inkPageIndicator2.F;
                int length2 = lb0VarArr2.length;
                while (i2 < length2) {
                    lb0VarArr2[i2].a(inkPageIndicator2.t);
                    i2++;
                }
                break;
        }
    }
}
