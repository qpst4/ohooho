package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.quickcursor.R;
import defpackage.b20;
import defpackage.b9;
import defpackage.bm0;
import defpackage.c20;
import defpackage.d;
import defpackage.d20;
import defpackage.f01;
import defpackage.f9;
import defpackage.fc0;
import defpackage.fx;
import defpackage.i1;
import defpackage.ih1;
import defpackage.m1;
import defpackage.mo;
import defpackage.mz0;
import defpackage.n00;
import defpackage.no;
import defpackage.nw0;
import defpackage.p00;
import defpackage.qo;
import defpackage.sp1;
import defpackage.t01;
import defpackage.tg;
import defpackage.uf1;
import defpackage.xy0;
import defpackage.xz0;
import defpackage.yb0;
import defpackage.ys0;
import defpackage.zy;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ih1 implements n00, xz0, mo {
    public ColorStateList c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public final Rect m;
    public final Rect n;
    public final f9 o;
    public final d p;
    public d20 q;

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateList;
        Drawable drawable;
        Drawable layerDrawable;
        super(xy0.L(context, attributeSet, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton), attributeSet, R.attr.floatingActionButtonStyle);
        this.b = getVisibility();
        this.m = new Rect();
        this.n = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.i, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.c = yb0.i(context2, typedArrayE, 1);
        this.d = i1.J(typedArrayE.getInt(2, -1), null);
        this.g = yb0.i(context2, typedArrayE, 12);
        this.h = typedArrayE.getInt(7, -1);
        this.i = typedArrayE.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = typedArrayE.getDimensionPixelSize(3, 0);
        float dimension = typedArrayE.getDimension(4, 0.0f);
        float dimension2 = typedArrayE.getDimension(9, 0.0f);
        float dimension3 = typedArrayE.getDimension(11, 0.0f);
        this.l = typedArrayE.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayE.getDimensionPixelSize(10, 0));
        bm0 bm0VarA = bm0.a(context2, typedArrayE, 15);
        bm0 bm0VarA2 = bm0.a(context2, typedArrayE, 8);
        mz0 mz0VarA = mz0.c(context2, attributeSet, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton, mz0.m).a();
        boolean z = typedArrayE.getBoolean(5, false);
        setEnabled(typedArrayE.getBoolean(0, true));
        typedArrayE.recycle();
        f9 f9Var = new f9(this);
        this.o = f9Var;
        f9Var.e(attributeSet, R.attr.floatingActionButtonStyle);
        this.p = new d(this);
        getImpl().g(mz0VarA);
        b20 impl = getImpl();
        ColorStateList colorStateList2 = this.c;
        PorterDuff.Mode mode = this.d;
        ColorStateList colorStateList3 = this.g;
        d20 d20Var = (d20) impl;
        FloatingActionButton floatingActionButton = d20Var.r;
        mz0 mz0Var = d20Var.a;
        mz0Var.getClass();
        c20 c20Var = new c20(mz0Var);
        d20Var.b = c20Var;
        c20Var.setTintList(colorStateList2);
        if (mode != null) {
            d20Var.b.setTintMode(mode);
        }
        d20Var.b.i(floatingActionButton.getContext());
        if (dimensionPixelSize > 0) {
            Context context3 = floatingActionButton.getContext();
            mz0 mz0Var2 = d20Var.a;
            mz0Var2.getClass();
            tg tgVar = new tg(mz0Var2);
            int color = context3.getColor(R.color.design_fab_stroke_top_outer_color);
            int color2 = context3.getColor(R.color.design_fab_stroke_top_inner_color);
            colorStateList = colorStateList3;
            int color3 = context3.getColor(R.color.design_fab_stroke_end_inner_color);
            int color4 = context3.getColor(R.color.design_fab_stroke_end_outer_color);
            tgVar.i = color;
            tgVar.j = color2;
            tgVar.k = color3;
            tgVar.l = color4;
            float f = dimensionPixelSize;
            if (tgVar.h != f) {
                tgVar.h = f;
                tgVar.b.setStrokeWidth(f * 1.3333f);
                tgVar.n = true;
                tgVar.invalidateSelf();
            }
            if (colorStateList2 != null) {
                tgVar.m = colorStateList2.getColorForState(tgVar.getState(), tgVar.m);
            }
            tgVar.p = colorStateList2;
            tgVar.n = true;
            tgVar.invalidateSelf();
            d20Var.d = tgVar;
            tg tgVar2 = d20Var.d;
            tgVar2.getClass();
            c20 c20Var2 = d20Var.b;
            c20Var2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{tgVar2, c20Var2});
            drawable = null;
        } else {
            colorStateList = colorStateList3;
            drawable = null;
            d20Var.d = null;
            layerDrawable = d20Var.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(nw0.c(colorStateList), layerDrawable, drawable);
        d20Var.c = rippleDrawable;
        d20Var.e = rippleDrawable;
        getImpl().k = dimensionPixelSize2;
        b20 impl2 = getImpl();
        if (impl2.h != dimension) {
            impl2.h = dimension;
            impl2.e(dimension, impl2.i, impl2.j);
        }
        b20 impl3 = getImpl();
        if (impl3.i != dimension2) {
            impl3.i = dimension2;
            impl3.e(impl3.h, dimension2, impl3.j);
        }
        b20 impl4 = getImpl();
        if (impl4.j != dimension3) {
            impl4.j = dimension3;
            impl4.e(impl4.h, impl4.i, dimension3);
        }
        getImpl().m = bm0VarA;
        getImpl().n = bm0VarA2;
        getImpl().f = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private b20 getImpl() {
        if (this.q == null) {
            this.q = new d20(this, new sp1(22, this));
        }
        return this.q;
    }

    public final int c(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
    }

    public final void d() {
        b20 impl = getImpl();
        FloatingActionButton floatingActionButton = impl.r;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.q;
        if (visibility == 0) {
            if (i == 1) {
                return;
            }
        } else if (i != 2) {
            return;
        }
        Animator animator = impl.l;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.r;
        WeakHashMap weakHashMap = uf1.a;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(4, false);
            return;
        }
        bm0 bm0Var = impl.n;
        AnimatorSet animatorSetB = bm0Var != null ? impl.b(bm0Var, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, b20.A, b20.B);
        animatorSetB.addListener(new fx(impl));
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b20 impl = getImpl();
        getDrawableState();
        impl.getClass();
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(b9.c(colorForState, mode));
    }

    public final void f() {
        b20 impl = getImpl();
        FloatingActionButton floatingActionButton = impl.r;
        Matrix matrix = impl.w;
        FloatingActionButton floatingActionButton2 = impl.r;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.q;
        if (visibility != 0) {
            if (i == 2) {
                return;
            }
        } else if (i != 1) {
            return;
        }
        Animator animator = impl.l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z = impl.m == null;
        WeakHashMap weakHashMap = uf1.a;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(0, false);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.o = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z ? 0.4f : 0.0f);
            float f = z ? 0.4f : 0.0f;
            impl.o = f;
            impl.a(f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
        }
        bm0 bm0Var = impl.m;
        AnimatorSet animatorSetB = bm0Var != null ? impl.b(bm0Var, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, b20.y, b20.z);
        animatorSetB.addListener(new m1(6, impl));
        animatorSetB.start();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // defpackage.mo
    public no getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return ((d20) getImpl()).r.getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().j;
    }

    public Drawable getContentBackground() {
        return getImpl().e;
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.b;
    }

    public bm0 getHideMotionSpec() {
        return getImpl().n;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public mz0 getShapeAppearanceModel() {
        mz0 mz0Var = getImpl().a;
        mz0Var.getClass();
        return mz0Var;
    }

    public bm0 getShowMotionSpec() {
        return getImpl().m;
    }

    public int getSize() {
        return this.h;
    }

    public int getSizeDimension() {
        return c(this.h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public boolean getUseCompatPadding() {
        return this.l;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().getClass();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b20 impl = getImpl();
        c20 c20Var = impl.b;
        if (c20Var != null) {
            fc0.O(impl.r, c20Var);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r.getViewTreeObserver();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().h();
        int iMin = Math.min(View.resolveSize(sizeDimension, i), View.resolveSize(sizeDimension, i2));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p00)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p00 p00Var = (p00) parcelable;
        super.onRestoreInstanceState(p00Var.b);
        Bundle bundle = (Bundle) p00Var.d.get("expandableWidgetHelper");
        bundle.getClass();
        d dVar = this.p;
        dVar.getClass();
        dVar.a = bundle.getBoolean("expanded", false);
        dVar.b = bundle.getInt("expandedComponentIdHint", 0);
        if (dVar.a) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) dVar.c;
            ViewParent parent = floatingActionButton.getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                List list = (List) ((t01) coordinatorLayout.c.d).get(floatingActionButton);
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    View view = (View) list.get(i);
                    no noVar = ((qo) view.getLayoutParams()).a;
                    if (noVar != null) {
                        noVar.d(coordinatorLayout, view, floatingActionButton);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        p00 p00Var = new p00(parcelableOnSaveInstanceState);
        d dVar = this.p;
        dVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", dVar.a);
        bundle.putInt("expandedComponentIdHint", dVar.b);
        p00Var.d.put("expandableWidgetHelper", bundle);
        return p00Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.n;
            rect.set(0, 0, measuredWidth, measuredHeight);
            int i = rect.left;
            Rect rect2 = this.m;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
            d20 d20Var = this.q;
            int i2 = -(d20Var.f ? Math.max((d20Var.k - d20Var.r.getSizeDimension()) / 2, 0) : 0);
            rect.inset(i2, i2);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            b20 impl = getImpl();
            c20 c20Var = impl.b;
            if (c20Var != null) {
                c20Var.setTintList(colorStateList);
            }
            tg tgVar = impl.d;
            if (tgVar != null) {
                if (colorStateList != null) {
                    tgVar.m = colorStateList.getColorForState(tgVar.getState(), tgVar.m);
                }
                tgVar.p = colorStateList;
                tgVar.n = true;
                tgVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            c20 c20Var = getImpl().b;
            if (c20Var != null) {
                c20Var.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        b20 impl = getImpl();
        if (impl.h != f) {
            impl.h = f;
            impl.e(f, impl.i, impl.j);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        b20 impl = getImpl();
        if (impl.i != f) {
            impl.i = f;
            impl.e(impl.h, f, impl.j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        b20 impl = getImpl();
        if (impl.j != f) {
            impl.j = f;
            impl.e(impl.h, impl.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            zy.n("Custom size must be non-negative");
        } else if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c20 c20Var = getImpl().b;
        if (c20Var != null) {
            c20Var.j(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f) {
            getImpl().f = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.p.b = i;
    }

    public void setHideMotionSpec(bm0 bm0Var) {
        getImpl().n = bm0Var;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(bm0.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            b20 impl = getImpl();
            float f = impl.o;
            impl.o = f;
            Matrix matrix = impl.w;
            impl.a(f, matrix);
            impl.r.setImageMatrix(matrix);
            if (this.e != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.o.h(i);
        e();
    }

    public void setMaxImageSize(int i) {
        this.k = i;
        b20 impl = getImpl();
        if (impl.p != i) {
            impl.p = i;
            float f = impl.o;
            impl.o = f;
            Matrix matrix = impl.w;
            impl.a(f, matrix);
            impl.r.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            b20 impl = getImpl();
            ColorStateList colorStateList2 = this.g;
            RippleDrawable rippleDrawable = ((d20) impl).c;
            if (rippleDrawable != null) {
                rippleDrawable.setColor(nw0.c(colorStateList2));
            } else if (rippleDrawable != null) {
                rippleDrawable.setTintList(nw0.c(colorStateList2));
            }
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().getClass();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z) {
        b20 impl = getImpl();
        impl.g = z;
        impl.h();
    }

    @Override // defpackage.xz0
    public void setShapeAppearanceModel(mz0 mz0Var) {
        getImpl().g(mz0Var);
    }

    public void setShowMotionSpec(bm0 bm0Var) {
        getImpl().m = bm0Var;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(bm0.b(getContext(), i));
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().f();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.l != z) {
            this.l = z;
            ((d20) getImpl()).h();
        }
    }

    @Override // defpackage.ih1, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class BaseBehavior<T extends FloatingActionButton> extends no {
        public final boolean a;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.j);
            this.a = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // defpackage.no
        public final boolean a(Rect rect, View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // defpackage.no
        public final void c(qo qoVar) {
            if (qoVar.h == 0) {
                qoVar.h = 80;
            }
        }

        @Override // defpackage.no
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof qo ? ((qo) layoutParams).a instanceof BottomSheetBehavior : false) {
                r(view2, floatingActionButton);
            }
            return false;
        }

        @Override // defpackage.no
        public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListJ = coordinatorLayout.j(floatingActionButton);
            int size = arrayListJ.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = (View) arrayListJ.get(i3);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if ((layoutParams instanceof qo ? ((qo) layoutParams).a instanceof BottomSheetBehavior : false) && r(view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.q(floatingActionButton, i);
            Rect rect = floatingActionButton.m;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                qo qoVar = (qo) floatingActionButton.getLayoutParams();
                int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) qoVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) qoVar).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) qoVar).bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) qoVar).topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    WeakHashMap weakHashMap = uf1.a;
                    floatingActionButton.offsetTopAndBottom(i2);
                }
                if (i4 != 0) {
                    WeakHashMap weakHashMap2 = uf1.a;
                    floatingActionButton.offsetLeftAndRight(i4);
                }
            }
            return true;
        }

        public final boolean r(View view, FloatingActionButton floatingActionButton) {
            qo qoVar = (qo) floatingActionButton.getLayoutParams();
            if (!this.a || qoVar.f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((qo) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public BaseBehavior() {
            this.a = true;
        }
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }
}
