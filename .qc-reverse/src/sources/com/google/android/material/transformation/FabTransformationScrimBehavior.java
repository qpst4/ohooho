package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.cm0;
import defpackage.fx;
import defpackage.xr;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final cm0 c;
    public final cm0 d;

    public FabTransformationScrimBehavior() {
        this.c = new cm0(75L);
        this.d = new cm0(0L);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, defpackage.no
    public final boolean b(View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // defpackage.no
    public final boolean q(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet s(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        cm0 cm0Var = z ? this.c : this.d;
        if (z) {
            if (!z2) {
                view2.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        cm0Var.a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        xr.E(animatorSet, arrayList);
        animatorSet.addListener(new fx(view2, z));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new cm0(75L);
        this.d = new cm0(0L);
    }
}
