package defpackage;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.view.View;
import com.quickcursor.android.views.VerticalTabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ o3(tb0 tb0Var, View view) {
        this.a = 4;
        this.b = tb0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((pu0) obj).a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            case 1:
                ((ev) obj).d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                ((nw) obj).setBackgroundTintList(ColorStateList.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
                break;
            case 3:
                up0 up0Var = VerticalTabLayout.O;
                ((VerticalTabLayout) obj).scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            default:
                ((View) ((vh1) ((tb0) obj).c).d.getParent()).invalidate();
                break;
        }
    }

    public /* synthetic */ o3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
