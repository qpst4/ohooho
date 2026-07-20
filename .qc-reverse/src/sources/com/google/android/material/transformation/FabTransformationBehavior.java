package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quickcursor.R;
import defpackage.bm0;
import defpackage.c70;
import defpackage.ck;
import defpackage.cm0;
import defpackage.i9;
import defpackage.lf1;
import defpackage.qo;
import defpackage.s1;
import defpackage.s7;
import defpackage.uf1;
import defpackage.xr;
import defpackage.y00;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public static Pair t(float f, float f2, boolean z, i9 i9Var) {
        cm0 cm0VarF;
        cm0 cm0VarF2;
        if (f == 0.0f || f2 == 0.0f) {
            cm0VarF = ((bm0) i9Var.c).f("translationXLinear");
            cm0VarF2 = ((bm0) i9Var.c).f("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            cm0VarF = ((bm0) i9Var.c).f("translationXCurveDownwards");
            cm0VarF2 = ((bm0) i9Var.c).f("translationYCurveDownwards");
        } else {
            cm0VarF = ((bm0) i9Var.c).f("translationXCurveUpwards");
            cm0VarF2 = ((bm0) i9Var.c).f("translationYCurveUpwards");
        }
        return new Pair(cm0VarF, cm0VarF2);
    }

    public static float w(i9 i9Var, cm0 cm0Var, float f) {
        long j = cm0Var.a;
        long j2 = cm0Var.b;
        cm0 cm0VarF = ((bm0) i9Var.c).f("expansion");
        return s7.a(f, 0.0f, cm0Var.b().getInterpolation((((cm0VarF.a + cm0VarF.b) + 17) - j) / j2));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, defpackage.no
    public final boolean b(View view, View view2) {
        int expandedComponentIdHint;
        if (view.getVisibility() != 8) {
            return (view2 instanceof FloatingActionButton) && ((expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint()) == 0 || expandedComponentIdHint == view.getId());
        }
        s1.f("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        return false;
    }

    @Override // defpackage.no
    public final void c(qo qoVar) {
        if (qoVar.h == 0) {
            qoVar.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet s(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        int i;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        i9 i9VarY = y(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        WeakHashMap weakHashMap = uf1.a;
        float fE = lf1.e(view2) - lf1.e(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fE);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fE);
        }
        ((bm0) i9VarY.c).f("elevation").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        float fU = u(view, view2, (c70) i9VarY.d);
        float fV = v(view, view2, (c70) i9VarY.d);
        Pair pairT = t(fU, fV, z, i9VarY);
        cm0 cm0Var = (cm0) pairT.first;
        cm0 cm0Var2 = (cm0) pairT.second;
        RectF rectF = this.d;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fU);
                view2.setTranslationY(-fV);
            }
            i = 0;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            f = 0.0f;
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fW = w(i9VarY, cm0Var, -fU);
            float fW2 = w(i9VarY, cm0Var2, -fV);
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.e;
            x(view2, rectF2);
            rectF2.offset(fW, fW2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
        } else {
            i = 0;
            f = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fU);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fV);
        }
        cm0Var.a(objectAnimatorOfFloat2);
        cm0Var2.a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        rectF.width();
        rectF.height();
        float fU2 = u(view, view2, (c70) i9VarY.d);
        float fV2 = v(view, view2, (c70) i9VarY.d);
        Pair pairT2 = t(fU2, fV2, z, i9VarY);
        cm0 cm0Var3 = (cm0) pairT2.first;
        cm0 cm0Var4 = (cm0) pairT2.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fU2 = this.g;
        }
        float[] fArr = new float[1];
        fArr[i] = fU2;
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            fV2 = this.h;
        }
        float[] fArr2 = new float[1];
        fArr2[i] = fV2;
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        cm0Var3.a(objectAnimatorOfFloat5);
        cm0Var4.a(objectAnimatorOfFloat6);
        arrayList.add(objectAnimatorOfFloat5);
        arrayList.add(objectAnimatorOfFloat6);
        if (view2 instanceof ViewGroup) {
            View viewFindViewById = view2.findViewById(R.id.mtrl_child_content_container);
            ViewGroup viewGroup = viewFindViewById != null ? viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null : (ViewGroup) view2;
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        ck.a.set(viewGroup, Float.valueOf(f));
                    }
                    ck ckVar = ck.a;
                    float[] fArr3 = new float[1];
                    fArr3[i] = 1.0f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, ckVar, fArr3);
                } else {
                    ck ckVar2 = ck.a;
                    float[] fArr4 = new float[1];
                    fArr4[i] = f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, ckVar2, fArr4);
                }
                ((bm0) i9VarY.c).f("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        xr.E(animatorSet, arrayList);
        animatorSet.addListener(new y00(z, view2, view));
        int size = arrayList2.size();
        for (int i2 = i; i2 < size; i2++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i2));
        }
        return animatorSet;
    }

    public final float u(View view, View view2, c70 c70Var) {
        RectF rectF = this.d;
        x(view, rectF);
        rectF.offset(this.g, this.h);
        RectF rectF2 = this.e;
        x(view2, rectF2);
        c70Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float v(View view, View view2, c70 c70Var) {
        RectF rectF = this.d;
        x(view, rectF);
        rectF.offset(this.g, this.h);
        RectF rectF2 = this.e;
        x(view2, rectF2);
        c70Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void x(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract i9 y(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
