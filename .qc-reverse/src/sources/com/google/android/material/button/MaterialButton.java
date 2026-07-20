package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import defpackage.f01;
import defpackage.fc0;
import defpackage.h;
import defpackage.i1;
import defpackage.l11;
import defpackage.lz0;
import defpackage.mz0;
import defpackage.nw0;
import defpackage.pj0;
import defpackage.qj0;
import defpackage.rj0;
import defpackage.s1;
import defpackage.tb0;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.xy0;
import defpackage.xz0;
import defpackage.yb0;
import defpackage.ys0;
import defpackage.zy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, xz0 {
    public static final int[] s = {R.attr.state_checkable};
    public static final int[] t = {R.attr.state_checked};
    public final rj0 e;
    public final LinkedHashSet f;
    public pj0 g;
    public PorterDuff.Mode h;
    public ColorStateList i;
    public Drawable j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public int r;

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(xy0.L(context, attributeSet, i, com.quickcursor.R.style.Widget_MaterialComponents_Button), attributeSet, i);
        this.f = new LinkedHashSet();
        this.p = false;
        this.q = false;
        Context context2 = getContext();
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.n, i, com.quickcursor.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.o = typedArrayE.getDimensionPixelSize(12, 0);
        int i2 = typedArrayE.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.h = i1.J(i2, mode);
        this.i = yb0.i(getContext(), typedArrayE, 14);
        this.j = yb0.j(getContext(), typedArrayE, 10);
        this.r = typedArrayE.getInteger(11, 1);
        this.l = typedArrayE.getDimensionPixelSize(13, 0);
        rj0 rj0Var = new rj0(this, mz0.b(context2, attributeSet, i, com.quickcursor.R.style.Widget_MaterialComponents_Button).a());
        this.e = rj0Var;
        rj0Var.c = typedArrayE.getDimensionPixelOffset(1, 0);
        rj0Var.d = typedArrayE.getDimensionPixelOffset(2, 0);
        rj0Var.e = typedArrayE.getDimensionPixelOffset(3, 0);
        rj0Var.f = typedArrayE.getDimensionPixelOffset(4, 0);
        if (typedArrayE.hasValue(8)) {
            int dimensionPixelSize = typedArrayE.getDimensionPixelSize(8, -1);
            rj0Var.g = dimensionPixelSize;
            float f = dimensionPixelSize;
            lz0 lz0VarF = rj0Var.b.f();
            lz0VarF.e = new h(f);
            lz0VarF.f = new h(f);
            lz0VarF.g = new h(f);
            lz0VarF.h = new h(f);
            rj0Var.c(lz0VarF.a());
            rj0Var.p = true;
        }
        rj0Var.h = typedArrayE.getDimensionPixelSize(20, 0);
        rj0Var.i = i1.J(typedArrayE.getInt(7, -1), mode);
        rj0Var.j = yb0.i(getContext(), typedArrayE, 6);
        rj0Var.k = yb0.i(getContext(), typedArrayE, 19);
        rj0Var.l = yb0.i(getContext(), typedArrayE, 16);
        rj0Var.q = typedArrayE.getBoolean(5, false);
        rj0Var.t = typedArrayE.getDimensionPixelSize(9, 0);
        rj0Var.r = typedArrayE.getBoolean(21, true);
        WeakHashMap weakHashMap = uf1.a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayE.hasValue(0)) {
            rj0Var.o = true;
            setSupportBackgroundTintList(rj0Var.j);
            setSupportBackgroundTintMode(rj0Var.i);
        } else {
            rj0Var.e();
        }
        setPaddingRelative(paddingStart + rj0Var.c, paddingTop + rj0Var.e, paddingEnd + rj0Var.d, paddingBottom + rj0Var.f);
        typedArrayE.recycle();
        setCompoundDrawablePadding(this.o);
        c(this.j != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        rj0 rj0Var = this.e;
        return (rj0Var == null || rj0Var.o) ? false : true;
    }

    public final void b() {
        int i = this.r;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.j, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.j, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.j, null, null);
        }
    }

    public final void c(boolean z) {
        Drawable drawable = this.j;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.j = drawableMutate;
            drawableMutate.setTintList(this.i);
            PorterDuff.Mode mode = this.h;
            if (mode != null) {
                this.j.setTintMode(mode);
            }
            int intrinsicWidth = this.l;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.j.getIntrinsicWidth();
            }
            int intrinsicHeight = this.l;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.j;
            int i = this.m;
            int i2 = this.n;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.j.setVisible(true, z);
        }
        if (z) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i3 = this.r;
        if (((i3 == 1 || i3 == 2) && drawable3 != this.j) || (((i3 == 3 || i3 == 4) && drawable5 != this.j) || ((i3 == 16 || i3 == 32) && drawable4 != this.j))) {
            b();
        }
    }

    public final void d(int i, int i2) {
        if (this.j == null || getLayout() == null) {
            return;
        }
        int i3 = this.r;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 == 16 || i3 == 32) {
                this.m = 0;
                if (i3 == 16) {
                    this.n = 0;
                    c(false);
                    return;
                }
                int intrinsicHeight = this.l;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.j.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i2 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.o) - getPaddingBottom()) / 2);
                if (this.n != iMax) {
                    this.n = iMax;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.n = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i4 = this.r;
        if (i4 == 1 || i4 == 3 || ((i4 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i4 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.m = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.l;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.j.getIntrinsicWidth();
        }
        int textLayoutWidth = i - getTextLayoutWidth();
        WeakHashMap weakHashMap = uf1.a;
        int paddingEnd = (((textLayoutWidth - getPaddingEnd()) - intrinsicWidth) - this.o) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.r == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.m != paddingEnd) {
            this.m = paddingEnd;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        rj0 rj0Var = this.e;
        return ((rj0Var == null || !rj0Var.q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.e.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.j;
    }

    public int getIconGravity() {
        return this.r;
    }

    public int getIconPadding() {
        return this.o;
    }

    public int getIconSize() {
        return this.l;
    }

    public ColorStateList getIconTint() {
        return this.i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.h;
    }

    public int getInsetBottom() {
        return this.e.f;
    }

    public int getInsetTop() {
        return this.e.e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.e.l;
        }
        return null;
    }

    public mz0 getShapeAppearanceModel() {
        if (a()) {
            return this.e.b;
        }
        s1.f("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.e.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.e.h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.e.j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.e.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.p;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            fc0.O(this, this.e.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        rj0 rj0Var = this.e;
        if (rj0Var != null && rj0Var.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, s);
        }
        if (this.p) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, t);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.p);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        rj0 rj0Var = this.e;
        accessibilityNodeInfo.setCheckable(rj0Var != null && rj0Var.q);
        accessibilityNodeInfo.setChecked(this.p);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof qj0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        qj0 qj0Var = (qj0) parcelable;
        super.onRestoreInstanceState(qj0Var.b);
        setChecked(qj0Var.d);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        qj0 qj0Var = new qj0(super.onSaveInstanceState());
        qj0Var.d = this.p;
        return qj0Var;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.e.r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.j != null) {
            if (this.j.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.k = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!a()) {
            super.setBackgroundColor(i);
            return;
        }
        rj0 rj0Var = this.e;
        if (rj0Var.b(false) != null) {
            rj0Var.b(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        rj0 rj0Var = this.e;
        rj0Var.o = true;
        MaterialButton materialButton = rj0Var.a;
        materialButton.setSupportBackgroundTintList(rj0Var.j);
        materialButton.setSupportBackgroundTintMode(rj0Var.i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? tk0.j(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (a()) {
            this.e.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        rj0 rj0Var = this.e;
        if (rj0Var == null || !rj0Var.q || !isEnabled() || this.p == z) {
            return;
        }
        this.p = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.p;
            if (!materialButtonToggleGroup.g) {
                materialButtonToggleGroup.b(getId(), z2);
            }
        }
        if (this.q) {
            return;
        }
        this.q = true;
        Iterator it = this.f.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        this.q = false;
    }

    public void setCornerRadius(int i) {
        if (a()) {
            rj0 rj0Var = this.e;
            if (rj0Var.p && rj0Var.g == i) {
                return;
            }
            rj0Var.g = i;
            rj0Var.p = true;
            float f = i;
            lz0 lz0VarF = rj0Var.b.f();
            lz0VarF.e = new h(f);
            lz0VarF.f = new h(f);
            lz0VarF.g = new h(f);
            lz0VarF.h = new h(f);
            rj0Var.c(lz0VarF.a());
        }
    }

    public void setCornerRadiusResource(int i) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (a()) {
            this.e.b(false).j(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.r != i) {
            this.r = i;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.o != i) {
            this.o = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? tk0.j(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            zy.n("iconSize cannot be less than 0");
        } else if (this.l != i) {
            this.l = i;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.h != mode) {
            this.h = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(xy0.p(getContext(), i));
    }

    public void setInsetBottom(int i) {
        rj0 rj0Var = this.e;
        rj0Var.d(rj0Var.e, i);
    }

    public void setInsetTop(int i) {
        rj0 rj0Var = this.e;
        rj0Var.d(i, rj0Var.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(pj0 pj0Var) {
        this.g = pj0Var;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        pj0 pj0Var = this.g;
        if (pj0Var != null) {
            ((MaterialButtonToggleGroup) ((tb0) pj0Var).c).invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            rj0 rj0Var = this.e;
            MaterialButton materialButton = rj0Var.a;
            if (rj0Var.l != colorStateList) {
                rj0Var.l = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(nw0.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (a()) {
            setRippleColor(xy0.p(getContext(), i));
        }
    }

    @Override // defpackage.xz0
    public void setShapeAppearanceModel(mz0 mz0Var) {
        if (a()) {
            this.e.c(mz0Var);
        } else {
            s1.f("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (a()) {
            rj0 rj0Var = this.e;
            rj0Var.n = z;
            rj0Var.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            rj0 rj0Var = this.e;
            if (rj0Var.k != colorStateList) {
                rj0Var.k = colorStateList;
                rj0Var.f();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (a()) {
            setStrokeColor(xy0.p(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (a()) {
            rj0 rj0Var = this.e;
            if (rj0Var.h != i) {
                rj0Var.h = i;
                rj0Var.f();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        rj0 rj0Var = this.e;
        if (rj0Var.j != colorStateList) {
            rj0Var.j = colorStateList;
            if (rj0Var.b(false) != null) {
                rj0Var.b(false).setTintList(rj0Var.j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        rj0 rj0Var = this.e;
        if (rj0Var.i != mode) {
            rj0Var.i = mode;
            if (rj0Var.b(false) == null || rj0Var.i == null) {
                return;
            }
            rj0Var.b(false).setTintMode(rj0Var.i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.e.r = z;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.p);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.quickcursor.R.attr.materialButtonStyle);
    }
}
