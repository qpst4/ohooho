package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;
import com.quickcursor.android.drawables.globals.cursors.CursorDesignQuickCursorDrawable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public m1(pg1 pg1Var, View view) {
        this.a = 10;
        this.b = pg1Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.x = null;
                actionBarOverlayLayout.k = false;
                break;
            case 5:
                ((ke) obj).d();
                break;
            case 10:
                ((pg1) obj).b();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.x = null;
                actionBarOverlayLayout.k = false;
                break;
            case 1:
                r7 r7Var = (r7) obj;
                ArrayList arrayList = new ArrayList(r7Var.f);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ColorStateList colorStateList = ((ak0) arrayList.get(i2)).b.p;
                    if (colorStateList != null) {
                        r7Var.setTintList(colorStateList);
                    }
                }
                break;
            case 2:
                super.onAnimationEnd(animator);
                ((CursorDesignQuickCursorDrawable) obj).j = null;
                break;
            case 3:
                ev evVar = (ev) obj;
                evVar.p();
                evVar.r.start();
                break;
            case 4:
                ((ExpandableTransformationBehavior) obj).b = null;
                break;
            case 5:
                ((ke) obj).e();
                break;
            case 6:
                b20 b20Var = (b20) obj;
                b20Var.q = 0;
                b20Var.l = null;
                break;
            case 7:
                ((HideBottomViewOnScrollBehavior) obj).h = null;
                break;
            case 8:
                lb0 lb0Var = (lb0) obj;
                InkPageIndicator inkPageIndicator = lb0Var.e;
                inkPageIndicator.u[lb0Var.d] = 0.0f;
                inkPageIndicator.postInvalidateOnAnimation();
                inkPageIndicator.postInvalidateOnAnimation();
                break;
            case 9:
                ((t81) obj).m();
                animator.removeListener(this);
                break;
            default:
                ((pg1) obj).a();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                r7 r7Var = (r7) obj;
                ArrayList arrayList = new ArrayList(r7Var.f);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ck0 ck0Var = ((ak0) arrayList.get(i2)).b;
                    ColorStateList colorStateList = ck0Var.p;
                    if (colorStateList != null) {
                        r7Var.setTint(colorStateList.getColorForState(ck0Var.t, colorStateList.getDefaultColor()));
                    }
                }
                break;
            case 5:
                ((ke) obj).f(animator);
                break;
            case 6:
                b20 b20Var = (b20) obj;
                b20Var.r.a(0, false);
                b20Var.q = 2;
                b20Var.l = animator;
                break;
            case 10:
                ((pg1) obj).c();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ m1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
