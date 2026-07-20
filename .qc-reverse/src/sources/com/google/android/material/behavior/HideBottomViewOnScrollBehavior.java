package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.quickcursor.R;
import defpackage.i1;
import defpackage.l11;
import defpackage.m1;
import defpackage.no;
import defpackage.s7;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends no {
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;
    public ViewPropertyAnimator h;
    public final LinkedHashSet a = new LinkedHashSet();
    public int f = 0;
    public int g = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // defpackage.no
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = i1.T(view.getContext(), R.attr.motionDurationLong2, 225);
        this.c = i1.T(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = i1.U(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, s7.d);
        this.e = i1.U(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, s7.c);
        return false;
    }

    @Override // defpackage.no
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        LinkedHashSet linkedHashSet = this.a;
        if (i > 0) {
            if (this.g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.g = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                throw l11.h(it);
            }
            this.h = view.animate().translationY(this.f).setInterpolator(this.e).setDuration(this.c).setListener(new m1(7, this));
            return;
        }
        if (i >= 0 || this.g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.h;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.g = 2;
        Iterator it2 = linkedHashSet.iterator();
        if (it2.hasNext()) {
            throw l11.h(it2);
        }
        this.h = view.animate().translationY(0.0f).setInterpolator(this.d).setDuration(this.b).setListener(new m1(7, this));
    }

    @Override // defpackage.no
    public boolean o(View view, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
