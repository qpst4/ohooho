package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wg implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wg(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(float r15) {
        /*
            r14 = this;
            java.lang.Object r14 = r14.b
            com.quickcursor.android.activities.AccessibilityStoppedActivity r14 = (com.quickcursor.android.activities.AccessibilityStoppedActivity) r14
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r0 = r14.U
            int r0 = r0.getScrollX()
            float r0 = (float) r0
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r1 = r14.U
            int r1 = r1.getWidth()
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r2 = r14.U
            int r2 = r2.getCurrentItem()
            float r3 = (float) r2
            int r4 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            r5 = 0
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            if (r4 <= 0) goto L3b
            double r8 = (double) r15
            double r10 = java.lang.Math.floor(r8)
            double r12 = (double) r2
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 == 0) goto L3b
            float r4 = r15 % r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L3b
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r2 = r14.U
            double r3 = java.lang.Math.floor(r8)
            int r3 = (int) r3
            r2.z(r3, r7)
            goto L59
        L3b:
            int r3 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r3 >= 0) goto L59
            double r3 = (double) r15
            double r8 = java.lang.Math.ceil(r3)
            double r10 = (double) r2
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L59
            float r2 = r15 % r6
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L59
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r2 = r14.U
            double r3 = java.lang.Math.ceil(r3)
            int r3 = (int) r3
            r2.z(r3, r7)
        L59:
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r2 = r14.U
            boolean r3 = r2.N
            if (r3 != 0) goto L66
            boolean r2 = r2.d()
            if (r2 != 0) goto L66
            return
        L66:
            com.heinrichreimersoftware.materialintro.view.FadeableViewPager r14 = r14.U
            float r1 = (float) r1
            float r1 = r1 * r15
            float r0 = r0 - r1
            r14.k(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wg.a(float):void");
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ik0 ik0Var = ((BottomSheetBehavior) obj).i;
                if (ik0Var != null) {
                    hk0 hk0Var = ik0Var.b;
                    if (hk0Var.i != fFloatValue) {
                        hk0Var.i = fFloatValue;
                        ik0Var.f = true;
                        ik0Var.invalidateSelf();
                    }
                }
                break;
            case 1:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                k10 k10Var = (k10) obj;
                k10Var.c.setAlpha(iFloatValue);
                k10Var.d.setAlpha(iFloatValue);
                k10Var.s.invalidate();
                break;
            case 2:
                InkPageIndicator inkPageIndicator = (InkPageIndicator) obj;
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                inkPageIndicator.o = fFloatValue2;
                inkPageIndicator.E.a(fFloatValue2);
                inkPageIndicator.postInvalidateOnAnimation();
                break;
            case 3:
                lb0 lb0Var = (lb0) obj;
                InkPageIndicator inkPageIndicator2 = lb0Var.e;
                inkPageIndicator2.u[lb0Var.d] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                inkPageIndicator2.postInvalidateOnAnimation();
                break;
            case 4:
                ((pc0) obj).m = valueAnimator.getAnimatedFraction();
                break;
            case 5:
                try {
                    a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                } catch (Exception unused) {
                    ((AccessibilityStoppedActivity) obj).T();
                    return;
                }
                break;
            case 6:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            default:
                ((TextInputLayout) obj).w0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
