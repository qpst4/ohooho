package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.ay0;
import defpackage.b10;
import defpackage.b51;
import defpackage.b9;
import defpackage.bp;
import defpackage.c51;
import defpackage.cb0;
import defpackage.d51;
import defpackage.db0;
import defpackage.e51;
import defpackage.ev;
import defpackage.f01;
import defpackage.fc0;
import defpackage.fz;
import defpackage.gl;
import defpackage.h;
import defpackage.hk0;
import defpackage.ht;
import defpackage.hz;
import defpackage.i1;
import defpackage.ik0;
import defpackage.ix;
import defpackage.li;
import defpackage.lk0;
import defpackage.lr;
import defpackage.lz0;
import defpackage.mr;
import defpackage.mz0;
import defpackage.n21;
import defpackage.nc;
import defpackage.of1;
import defpackage.oj0;
import defpackage.ra;
import defpackage.s7;
import defpackage.sp1;
import defpackage.tk0;
import defpackage.tw0;
import defpackage.uf1;
import defpackage.vu;
import defpackage.wg;
import defpackage.wl;
import defpackage.x41;
import defpackage.x81;
import defpackage.xg;
import defpackage.xr;
import defpackage.xy0;
import defpackage.y41;
import defpackage.yb0;
import defpackage.ye;
import defpackage.ys0;
import defpackage.zy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] D0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public boolean A0;
    public ColorStateList B;
    public boolean B0;
    public ColorStateList C;
    public boolean C0;
    public boolean D;
    public CharSequence E;
    public boolean F;
    public ik0 G;
    public ik0 H;
    public StateListDrawable I;
    public boolean J;
    public ik0 K;
    public ik0 L;
    public mz0 M;
    public boolean N;
    public final int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public final Rect W;
    public final Rect a0;
    public final FrameLayout b;
    public final RectF b0;
    public final n21 c;
    public Typeface c0;
    public final hz d;
    public ColorDrawable d0;
    public EditText e;
    public int e0;
    public CharSequence f;
    public final LinkedHashSet f0;
    public int g;
    public ColorDrawable g0;
    public int h;
    public int h0;
    public int i;
    public Drawable i0;
    public int j;
    public ColorStateList j0;
    public final db0 k;
    public ColorStateList k0;
    public boolean l;
    public int l0;
    public int m;
    public int m0;
    public boolean n;
    public int n0;
    public d51 o;
    public ColorStateList o0;
    public AppCompatTextView p;
    public int p0;
    public int q;
    public int q0;
    public int r;
    public int r0;
    public CharSequence s;
    public int s0;
    public boolean t;
    public int t0;
    public AppCompatTextView u;
    public int u0;
    public ColorStateList v;
    public boolean v0;
    public int w;
    public final gl w0;
    public b10 x;
    public boolean x0;
    public b10 y;
    public boolean y0;
    public ColorStateList z;
    public ValueAnimator z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(xy0.L(context, attributeSet, com.quickcursor.R.attr.textInputStyle, com.quickcursor.R.style.Widget_Design_TextInputLayout), attributeSet, com.quickcursor.R.attr.textInputStyle);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = new db0(this);
        this.o = new ay0(4);
        this.W = new Rect();
        this.a0 = new Rect();
        this.b0 = new RectF();
        this.f0 = new LinkedHashSet();
        gl glVar = new gl(this);
        this.w0 = glVar;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = s7.a;
        glVar.Q = linearInterpolator;
        glVar.h(false);
        glVar.P = linearInterpolator;
        glVar.h(false);
        if (glVar.g != 8388659) {
            glVar.g = 8388659;
            glVar.h(false);
        }
        f01.i(context2, attributeSet, com.quickcursor.R.attr.textInputStyle, com.quickcursor.R.style.Widget_Design_TextInputLayout);
        int[] iArr = ys0.G;
        f01.l(context2, attributeSet, iArr, com.quickcursor.R.attr.textInputStyle, com.quickcursor.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 49);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.quickcursor.R.attr.textInputStyle, com.quickcursor.R.style.Widget_Design_TextInputLayout);
        ra raVar = new ra(context2, typedArrayObtainStyledAttributes);
        n21 n21Var = new n21(this, raVar);
        this.c = n21Var;
        this.D = typedArrayObtainStyledAttributes.getBoolean(48, true);
        setHint(typedArrayObtainStyledAttributes.getText(4));
        this.y0 = typedArrayObtainStyledAttributes.getBoolean(47, true);
        this.x0 = typedArrayObtainStyledAttributes.getBoolean(42, true);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(typedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(typedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.M = mz0.b(context2, attributeSet, com.quickcursor.R.attr.textInputStyle, com.quickcursor.R.style.Widget_Design_TextInputLayout).a();
        this.O = context2.getResources().getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.quickcursor.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.quickcursor.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.R = this.S;
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        lz0 lz0VarF = this.M.f();
        if (dimension >= 0.0f) {
            lz0VarF.e = new h(dimension);
        }
        if (dimension2 >= 0.0f) {
            lz0VarF.f = new h(dimension2);
        }
        if (dimension3 >= 0.0f) {
            lz0VarF.g = new h(dimension3);
        }
        if (dimension4 >= 0.0f) {
            lz0VarF.h = new h(dimension4);
        }
        this.M = lz0VarF.a();
        ColorStateList colorStateListH = yb0.h(context2, raVar, 7);
        if (colorStateListH != null) {
            int defaultColor = colorStateListH.getDefaultColor();
            this.p0 = defaultColor;
            this.V = defaultColor;
            if (colorStateListH.isStateful()) {
                this.q0 = colorStateListH.getColorForState(new int[]{-16842910}, -1);
                this.r0 = colorStateListH.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.s0 = colorStateListH.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.r0 = this.p0;
                ColorStateList colorStateListP = xy0.p(context2, com.quickcursor.R.color.mtrl_filled_background_color);
                this.q0 = colorStateListP.getColorForState(new int[]{-16842910}, -1);
                this.s0 = colorStateListP.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.p0 = 0;
            this.q0 = 0;
            this.r0 = 0;
            this.s0 = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateListX = raVar.x(1);
            this.k0 = colorStateListX;
            this.j0 = colorStateListX;
        }
        ColorStateList colorStateListH2 = yb0.h(context2, raVar, 14);
        this.n0 = typedArrayObtainStyledAttributes.getColor(14, 0);
        this.l0 = context2.getColor(com.quickcursor.R.color.mtrl_textinput_default_box_stroke_color);
        this.t0 = context2.getColor(com.quickcursor.R.color.mtrl_textinput_disabled_color);
        this.m0 = context2.getColor(com.quickcursor.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListH2 != null) {
            setBoxStrokeColorStateList(colorStateListH2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(yb0.h(context2, raVar, 15));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(49, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(49, 0));
        }
        this.B = raVar.x(24);
        this.C = raVar.x(25);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(35);
        int i = typedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(45, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(43);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(57, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(56);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(19, -1));
        this.r = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.q = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.q);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.r);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArrayObtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(raVar.x(41));
        }
        if (typedArrayObtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(raVar.x(46));
        }
        if (typedArrayObtainStyledAttributes.hasValue(50)) {
            setHintTextColor(raVar.x(50));
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(raVar.x(23));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(raVar.x(21));
        }
        if (typedArrayObtainStyledAttributes.hasValue(58)) {
            setPlaceholderTextColor(raVar.x(58));
        }
        hz hzVar = new hz(this, raVar);
        this.d = hzVar;
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        raVar.O();
        WeakHashMap weakHashMap = uf1.a;
        setImportantForAccessibility(2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && i2 >= 26) {
            of1.b(this, 1);
        }
        frameLayout.addView(n21Var);
        frameLayout.addView(hzVar);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.e;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.G;
        }
        int iL = xr.l(this.e, com.quickcursor.R.attr.colorControlHighlight);
        int i = this.P;
        int[][] iArr = D0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            ik0 ik0Var = this.G;
            int i2 = this.V;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{xr.z(0.1f, iL, i2), i2}), ik0Var, ik0Var);
        }
        Context context = getContext();
        ik0 ik0Var2 = this.G;
        TypedValue typedValueV = i1.V(com.quickcursor.R.attr.colorSurface, context, "TextInputLayout");
        int i3 = typedValueV.resourceId;
        int color = i3 != 0 ? context.getColor(i3) : typedValueV.data;
        ik0 ik0Var3 = new ik0(ik0Var2.b.a);
        int iZ = xr.z(0.1f, iL, color);
        ik0Var3.k(new ColorStateList(iArr, new int[]{iZ, 0}));
        ik0Var3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iZ, color});
        ik0 ik0Var4 = new ik0(ik0Var2.b.a);
        ik0Var4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, ik0Var3, ik0Var4), ik0Var2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], f(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = f(true);
        }
        return this.H;
    }

    public static void k(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            zy.n("We already have an EditText, can only have one");
            return;
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i = this.g;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.i);
        }
        int i2 = this.h;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.j);
        }
        this.J = false;
        i();
        setTextInputAccessibilityDelegate(new c51(this));
        Typeface typeface = this.e.getTypeface();
        gl glVar = this.w0;
        glVar.m(typeface);
        float textSize = this.e.getTextSize();
        if (glVar.h != textSize) {
            glVar.h = textSize;
            glVar.h(false);
        }
        float letterSpacing = this.e.getLetterSpacing();
        if (glVar.W != letterSpacing) {
            glVar.W = letterSpacing;
            glVar.h(false);
        }
        int gravity = this.e.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (glVar.g != i3) {
            glVar.g = i3;
            glVar.h(false);
        }
        if (glVar.f != gravity) {
            glVar.f = gravity;
            glVar.h(false);
        }
        WeakHashMap weakHashMap = uf1.a;
        this.u0 = editText.getMinimumHeight();
        this.e.addTextChangedListener(new b51(this, editText));
        if (this.j0 == null) {
            this.j0 = this.e.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.e.getHint();
                this.f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        if (this.p != null) {
            n(this.e.getText());
        }
        r();
        this.k.b();
        this.c.bringToFront();
        hz hzVar = this.d;
        hzVar.bringToFront();
        Iterator it = this.f0.iterator();
        while (it.hasNext()) {
            ((fz) it.next()).a(this);
        }
        hzVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        gl glVar = this.w0;
        if (charSequence == null || !TextUtils.equals(glVar.A, charSequence)) {
            glVar.A = charSequence;
            glVar.B = null;
            Bitmap bitmap = glVar.E;
            if (bitmap != null) {
                bitmap.recycle();
                glVar.E = null;
            }
            glVar.h(false);
        }
        if (this.v0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.t == z) {
            return;
        }
        AppCompatTextView appCompatTextView = this.u;
        if (!z) {
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            this.u = null;
        } else if (appCompatTextView != null) {
            this.b.addView(appCompatTextView);
            this.u.setVisibility(0);
        }
        this.t = z;
    }

    public final void a(float f) {
        gl glVar = this.w0;
        if (glVar.b == f) {
            return;
        }
        if (this.z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.z0 = valueAnimator;
            valueAnimator.setInterpolator(i1.U(getContext(), com.quickcursor.R.attr.motionEasingEmphasizedInterpolator, s7.b));
            this.z0.setDuration(i1.T(getContext(), com.quickcursor.R.attr.motionDurationMedium4, 167));
            this.z0.addUpdateListener(new wg(7, this));
        }
        this.z0.setFloatValues(glVar.b, f);
        this.z0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.b;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    public final void b() {
        int i;
        int i2;
        ik0 ik0Var = this.G;
        if (ik0Var == null) {
            return;
        }
        mz0 mz0Var = ik0Var.b.a;
        mz0 mz0Var2 = this.M;
        if (mz0Var != mz0Var2) {
            ik0Var.setShapeAppearanceModel(mz0Var2);
        }
        if (this.P == 2 && (i = this.R) > -1 && (i2 = this.U) != 0) {
            ik0 ik0Var2 = this.G;
            ik0Var2.b.j = i;
            ik0Var2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
            hk0 hk0Var = ik0Var2.b;
            if (hk0Var.d != colorStateListValueOf) {
                hk0Var.d = colorStateListValueOf;
                ik0Var2.onStateChange(ik0Var2.getState());
            }
        }
        int iD = this.V;
        if (this.P == 1) {
            iD = wl.d(this.V, xr.k(getContext(), com.quickcursor.R.attr.colorSurface, 0));
        }
        this.V = iD;
        this.G.k(ColorStateList.valueOf(iD));
        ik0 ik0Var3 = this.K;
        if (ik0Var3 != null && this.L != null) {
            if (this.R > -1 && this.U != 0) {
                ik0Var3.k(this.e.isFocused() ? ColorStateList.valueOf(this.l0) : ColorStateList.valueOf(this.U));
                this.L.k(ColorStateList.valueOf(this.U));
            }
            invalidate();
        }
        s();
    }

    public final int c() {
        float fD;
        if (!this.D) {
            return 0;
        }
        int i = this.P;
        gl glVar = this.w0;
        if (i == 0) {
            fD = glVar.d();
        } else {
            if (i != 2) {
                return 0;
            }
            fD = glVar.d() / 2.0f;
        }
        return (int) fD;
    }

    public final b10 d() {
        b10 b10Var = new b10();
        b10Var.d = i1.T(getContext(), com.quickcursor.R.attr.motionDurationShort2, 87);
        b10Var.e = i1.U(getContext(), com.quickcursor.R.attr.motionEasingLinearInterpolator, s7.a);
        return b10Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f != null) {
            boolean z = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.e.setHint(hint);
                this.F = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.b;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        ik0 ik0Var;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z = this.D;
        gl glVar = this.w0;
        if (z) {
            TextPaint textPaint = glVar.N;
            RectF rectF = glVar.e;
            int iSave = canvas2.save();
            if (glVar.B != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(glVar.G);
                float f = glVar.p;
                float f2 = glVar.q;
                float f3 = glVar.F;
                if (f3 != 1.0f) {
                    canvas2.scale(f3, f3, f, f2);
                }
                if (glVar.d0 <= 1 || glVar.C) {
                    canvas2.translate(f, f2);
                    glVar.Y.draw(canvas2);
                } else {
                    float lineStart = glVar.p - glVar.Y.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f2);
                    float f4 = alpha;
                    textPaint.setAlpha((int) (glVar.b0 * f4));
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        float f5 = glVar.H;
                        float f6 = glVar.I;
                        float f7 = glVar.J;
                        int i2 = glVar.K;
                        textPaint.setShadowLayer(f5, f6, f7, wl.f(i2, (textPaint.getAlpha() * Color.alpha(i2)) / 255));
                    }
                    glVar.Y.draw(canvas2);
                    textPaint.setAlpha((int) (glVar.a0 * f4));
                    if (i >= 31) {
                        float f8 = glVar.H;
                        float f9 = glVar.I;
                        float f10 = glVar.J;
                        int i3 = glVar.K;
                        textPaint.setShadowLayer(f8, f9, f10, wl.f(i3, (Color.alpha(i3) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = glVar.Y.getLineBaseline(0);
                    CharSequence charSequence = glVar.c0;
                    float f11 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, textPaint);
                    if (i >= 31) {
                        textPaint.setShadowLayer(glVar.H, glVar.I, glVar.J, glVar.K);
                    }
                    String strTrim = glVar.c0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(glVar.Y.getLineEnd(0), str.length()), 0.0f, f11, (Paint) textPaint);
                }
                canvas2.restoreToCount(iSave);
            }
        }
        if (this.L == null || (ik0Var = this.K) == null) {
            return;
        }
        ik0Var.draw(canvas2);
        if (this.e.isFocused()) {
            Rect bounds = this.L.getBounds();
            Rect bounds2 = this.K.getBounds();
            float f12 = glVar.b;
            int iCenterX = bounds2.centerX();
            bounds.left = s7.c(f12, iCenterX, bounds2.left);
            bounds.right = s7.c(f12, iCenterX, bounds2.right);
            this.L.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.A0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.A0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            gl r3 = r4.w0
            if (r3 == 0) goto L2f
            r3.L = r1
            android.content.res.ColorStateList r1 = r3.k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.h(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.e
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = defpackage.uf1.a
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.u(r0, r2)
        L47:
            r4.r()
            r4.x()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.A0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof mr);
    }

    public final ik0 f(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_shape_corner_size_small_component);
        float f = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.e;
        float popupElevation = editText instanceof oj0 ? ((oj0) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.quickcursor.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        tw0 tw0Var = new tw0();
        tw0 tw0Var2 = new tw0();
        tw0 tw0Var3 = new tw0();
        tw0 tw0Var4 = new tw0();
        int i = 0;
        ix ixVar = new ix(i);
        ix ixVar2 = new ix(i);
        ix ixVar3 = new ix(i);
        ix ixVar4 = new ix(i);
        h hVar = new h(f);
        h hVar2 = new h(f);
        h hVar3 = new h(dimensionPixelOffset);
        h hVar4 = new h(dimensionPixelOffset);
        mz0 mz0Var = new mz0();
        mz0Var.a = tw0Var;
        mz0Var.b = tw0Var2;
        mz0Var.c = tw0Var3;
        mz0Var.d = tw0Var4;
        mz0Var.e = hVar;
        mz0Var.f = hVar2;
        mz0Var.g = hVar4;
        mz0Var.h = hVar3;
        mz0Var.i = ixVar;
        mz0Var.j = ixVar2;
        mz0Var.k = ixVar3;
        mz0Var.l = ixVar4;
        EditText editText2 = this.e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof oj0 ? ((oj0) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = ik0.x;
            TypedValue typedValueV = i1.V(com.quickcursor.R.attr.colorSurface, context, ik0.class.getSimpleName());
            int i2 = typedValueV.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i2 != 0 ? context.getColor(i2) : typedValueV.data);
        }
        ik0 ik0Var = new ik0();
        ik0Var.i(context);
        ik0Var.k(dropDownBackgroundTintList);
        ik0Var.j(popupElevation);
        ik0Var.setShapeAppearanceModel(mz0Var);
        hk0 hk0Var = ik0Var.b;
        if (hk0Var.g == null) {
            hk0Var.g = new Rect();
        }
        ik0Var.b.g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        ik0Var.invalidateSelf();
        return ik0Var;
    }

    public final int g(int i, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.e.getCompoundPaddingLeft() : this.d.c() : this.c.a()) + i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public ik0 getBoxBackground() {
        int i = this.P;
        if (i == 1 || i == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zE = i1.E(this);
        mz0 mz0Var = this.M;
        RectF rectF = this.b0;
        return zE ? mz0Var.h.a(rectF) : mz0Var.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zE = i1.E(this);
        mz0 mz0Var = this.M;
        RectF rectF = this.b0;
        return zE ? mz0Var.g.a(rectF) : mz0Var.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zE = i1.E(this);
        mz0 mz0Var = this.M;
        RectF rectF = this.b0;
        return zE ? mz0Var.e.a(rectF) : mz0Var.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zE = i1.E(this);
        mz0 mz0Var = this.M;
        RectF rectF = this.b0;
        return zE ? mz0Var.f.a(rectF) : mz0Var.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.n0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.l && this.n && (appCompatTextView = this.p) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    public ColorStateList getCounterTextColor() {
        return this.z;
    }

    public ColorStateList getCursorColor() {
        return this.B;
    }

    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.j0;
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.d.h.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.d.h.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.d.n;
    }

    public int getEndIconMode() {
        return this.d.j;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.d.o;
    }

    public CheckableImageButton getEndIconView() {
        return this.d.h;
    }

    public CharSequence getError() {
        db0 db0Var = this.k;
        if (db0Var.q) {
            return db0Var.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.k.t;
    }

    public CharSequence getErrorContentDescription() {
        return this.k.s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.k.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.d.d.getDrawable();
    }

    public CharSequence getHelperText() {
        db0 db0Var = this.k;
        if (db0Var.x) {
            return db0Var.w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.k.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.w0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        gl glVar = this.w0;
        return glVar.e(glVar.k);
    }

    public ColorStateList getHintTextColor() {
        return this.k0;
    }

    public d51 getLengthCounter() {
        return this.o;
    }

    public int getMaxEms() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.j;
    }

    public int getMinEms() {
        return this.g;
    }

    public int getMinWidth() {
        return this.i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.d.h.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.d.h.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.t) {
            return this.s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.v;
    }

    public CharSequence getPrefixText() {
        return this.c.d;
    }

    public ColorStateList getPrefixTextColor() {
        return this.c.c.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.c.c;
    }

    public mz0 getShapeAppearanceModel() {
        return this.M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.c.e.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.c.e.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.c.h;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.c.i;
    }

    public CharSequence getSuffixText() {
        return this.d.q;
    }

    public ColorStateList getSuffixTextColor() {
        return this.d.r.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.d.r;
    }

    public Typeface getTypeface() {
        return this.c0;
    }

    public final int h(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.e.getCompoundPaddingRight() : this.c.a() : this.d.c());
    }

    public final void i() {
        int i = this.P;
        if (i == 0) {
            this.G = null;
            this.K = null;
            this.L = null;
        } else if (i == 1) {
            this.G = new ik0(this.M);
            this.K = new ik0();
            this.L = new ik0();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.D || (this.G instanceof mr)) {
                this.G = new ik0(this.M);
            } else {
                mz0 mz0Var = this.M;
                int i2 = mr.z;
                if (mz0Var == null) {
                    mz0Var = new mz0();
                }
                lr lrVar = new lr(mz0Var, new RectF());
                mr mrVar = new mr(lrVar);
                mrVar.y = lrVar;
                this.G = mrVar;
            }
            this.K = null;
            this.L = null;
        }
        s();
        x();
        if (this.P == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.Q = getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (yb0.o(getContext())) {
                this.Q = getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.e != null && this.P == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.e;
                WeakHashMap weakHashMap = uf1.a;
                editText.setPaddingRelative(editText.getPaddingStart(), getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_filled_edittext_font_2_0_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (yb0.o(getContext())) {
                EditText editText2 = this.e;
                WeakHashMap weakHashMap2 = uf1.a;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_filled_edittext_font_1_3_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.quickcursor.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.P != 0) {
            t();
        }
        EditText editText3 = this.e;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.P;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.j():void");
    }

    public final void l(AppCompatTextView appCompatTextView, int i) {
        try {
            appCompatTextView.setTextAppearance(i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(com.quickcursor.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(getContext().getColor(com.quickcursor.R.color.design_error));
    }

    public final boolean m() {
        db0 db0Var = this.k;
        return (db0Var.o != 1 || db0Var.r == null || TextUtils.isEmpty(db0Var.p)) ? false : true;
    }

    public final void n(Editable editable) {
        ((ay0) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.n;
        int i = this.m;
        if (i == -1) {
            this.p.setText(String.valueOf(length));
            this.p.setContentDescription(null);
            this.n = false;
        } else {
            this.n = length > i;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.n ? com.quickcursor.R.string.character_counter_overflowed_content_description : com.quickcursor.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.m)));
            if (z != this.n) {
                o();
            }
            String str = ye.b;
            ye yeVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? ye.e : ye.d;
            AppCompatTextView appCompatTextView = this.p;
            String string = getContext().getString(com.quickcursor.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m));
            yeVar.getClass();
            xg xgVar = y41.a;
            appCompatTextView.setText(string != null ? yeVar.c(string).toString() : null);
        }
        if (this.e == null || z == this.n) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.p;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.n ? this.q : this.r);
            if (!this.n && (colorStateList2 = this.z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.A) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.w0.g(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        hz hzVar = this.d;
        hzVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.C0 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (iMax = Math.max(hzVar.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            this.e.setMinimumHeight(iMax);
            z = true;
        }
        boolean zQ = q();
        if (z || zQ) {
            this.e.post(new lk0(11, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.e;
        if (editText != null) {
            ThreadLocal threadLocal = ht.a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.W;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = ht.a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            ht.a(this, editText, matrix);
            ThreadLocal threadLocal3 = ht.b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            ik0 ik0Var = this.K;
            if (ik0Var != null) {
                int i5 = rect.bottom;
                ik0Var.setBounds(rect.left, i5 - this.S, rect.right, i5);
            }
            ik0 ik0Var2 = this.L;
            if (ik0Var2 != null) {
                int i6 = rect.bottom;
                ik0Var2.setBounds(rect.left, i6 - this.T, rect.right, i6);
            }
            if (this.D) {
                float textSize = this.e.getTextSize();
                gl glVar = this.w0;
                if (glVar.h != textSize) {
                    glVar.h = textSize;
                    glVar.h(false);
                }
                int gravity = this.e.getGravity();
                int i7 = (gravity & (-113)) | 48;
                if (glVar.g != i7) {
                    glVar.g = i7;
                    glVar.h(false);
                }
                if (glVar.f != gravity) {
                    glVar.f = gravity;
                    glVar.h(false);
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                boolean zE = i1.E(this);
                int i8 = rect.bottom;
                Rect rect2 = this.a0;
                rect2.bottom = i8;
                int i9 = this.P;
                int i10 = rect.left;
                if (i9 == 1) {
                    rect2.left = g(i10, zE);
                    rect2.top = rect.top + this.Q;
                    rect2.right = h(rect.right, zE);
                } else if (i9 != 2) {
                    rect2.left = g(i10, zE);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, zE);
                } else {
                    rect2.left = this.e.getPaddingLeft() + i10;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.e.getPaddingRight();
                }
                int i11 = rect2.left;
                int i12 = rect2.top;
                int i13 = rect2.right;
                int i14 = rect2.bottom;
                Rect rect3 = glVar.d;
                if (rect3.left != i11 || rect3.top != i12 || rect3.right != i13 || rect3.bottom != i14) {
                    rect3.set(i11, i12, i13, i14);
                    glVar.M = true;
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = glVar.O;
                textPaint.setTextSize(glVar.h);
                textPaint.setTypeface(glVar.u);
                textPaint.setLetterSpacing(glVar.W);
                float f = -textPaint.ascent();
                rect2.left = this.e.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.P != 1 || this.e.getMinLines() > 1) ? rect.top + this.e.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.P != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i15 = rect2.left;
                int i16 = rect2.top;
                int i17 = rect2.right;
                Rect rect4 = glVar.c;
                if (rect4.left != i15 || rect4.top != i16 || rect4.right != i17 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i15, i16, i17, compoundPaddingBottom);
                    glVar.M = true;
                }
                glVar.h(false);
                if (!e() || this.v0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.C0;
        hz hzVar = this.d;
        if (!z) {
            hzVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        if (this.u != null && (editText = this.e) != null) {
            this.u.setGravity(editText.getGravity());
            this.u.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        hzVar.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e51)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e51 e51Var = (e51) parcelable;
        super.onRestoreInstanceState(e51Var.b);
        setError(e51Var.d);
        if (e51Var.e) {
            post(new nc(16, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.N) {
            bp bpVar = this.M.e;
            RectF rectF = this.b0;
            float fA = bpVar.a(rectF);
            float fA2 = this.M.f.a(rectF);
            float fA3 = this.M.h.a(rectF);
            float fA4 = this.M.g.a(rectF);
            mz0 mz0Var = this.M;
            fc0 fc0Var = mz0Var.a;
            fc0 fc0Var2 = mz0Var.b;
            fc0 fc0Var3 = mz0Var.d;
            fc0 fc0Var4 = mz0Var.c;
            ix ixVar = new ix(0);
            ix ixVar2 = new ix(0);
            ix ixVar3 = new ix(0);
            ix ixVar4 = new ix(0);
            h hVar = new h(fA2);
            h hVar2 = new h(fA);
            h hVar3 = new h(fA4);
            h hVar4 = new h(fA3);
            mz0 mz0Var2 = new mz0();
            mz0Var2.a = fc0Var2;
            mz0Var2.b = fc0Var;
            mz0Var2.c = fc0Var3;
            mz0Var2.d = fc0Var4;
            mz0Var2.e = hVar;
            mz0Var2.f = hVar2;
            mz0Var2.g = hVar4;
            mz0Var2.h = hVar3;
            mz0Var2.i = ixVar;
            mz0Var2.j = ixVar2;
            mz0Var2.k = ixVar3;
            mz0Var2.l = ixVar4;
            this.N = z;
            setShapeAppearanceModel(mz0Var2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        e51 e51Var = new e51(super.onSaveInstanceState());
        if (m()) {
            e51Var.d = getError();
        }
        hz hzVar = this.d;
        e51Var.e = hzVar.j != 0 && hzVar.h.e;
        return e51Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.B
            if (r0 == 0) goto L5
            goto L26
        L5:
            android.content.Context r0 = r4.getContext()
            r1 = 2130968837(0x7f040105, float:1.7546339E38)
            android.util.TypedValue r1 = defpackage.i1.Q(r0, r1)
            r2 = 0
            if (r1 != 0) goto L15
        L13:
            r0 = r2
            goto L26
        L15:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1e
            android.content.res.ColorStateList r0 = defpackage.xy0.p(r0, r3)
            goto L26
        L1e:
            int r0 = r1.data
            if (r0 == 0) goto L13
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L26:
            android.widget.EditText r1 = r4.e
            if (r1 == 0) goto L51
            android.graphics.drawable.Drawable r1 = defpackage.d0.f(r1)
            if (r1 != 0) goto L31
            goto L51
        L31:
            android.widget.EditText r1 = r4.e
            android.graphics.drawable.Drawable r1 = defpackage.d0.f(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.m()
            if (r2 != 0) goto L49
            androidx.appcompat.widget.AppCompatTextView r2 = r4.p
            if (r2 == 0) goto L4e
            boolean r2 = r4.n
            if (r2 == 0) goto L4e
        L49:
            android.content.res.ColorStateList r4 = r4.C
            if (r4 == 0) goto L4e
            r0 = r4
        L4e:
            r1.setTintList(r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.e;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = vu.a;
        Drawable drawableMutate = background.mutate();
        if (m()) {
            drawableMutate.setColorFilter(b9.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (appCompatTextView = this.p) != null) {
            drawableMutate.setColorFilter(b9.c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.e.refreshDrawableState();
        }
    }

    public final void s() {
        EditText editText = this.e;
        if (editText == null || this.G == null) {
            return;
        }
        if ((this.J || editText.getBackground() == null) && this.P != 0) {
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            EditText editText2 = this.e;
            WeakHashMap weakHashMap = uf1.a;
            editText2.setBackground(editTextBoxBackground);
            this.J = true;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.V != i) {
            this.V = i;
            this.p0 = i;
            this.r0 = i;
            this.s0 = i;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.p0 = defaultColor;
        this.V = defaultColor;
        this.q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.s0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.P) {
            return;
        }
        this.P = i;
        if (this.e != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.Q = i;
    }

    public void setBoxCornerFamily(int i) {
        lz0 lz0VarF = this.M.f();
        bp bpVar = this.M.e;
        lz0VarF.a = fc0.j(i);
        lz0VarF.e = bpVar;
        bp bpVar2 = this.M.f;
        lz0VarF.b = fc0.j(i);
        lz0VarF.f = bpVar2;
        bp bpVar3 = this.M.h;
        lz0VarF.d = fc0.j(i);
        lz0VarF.h = bpVar3;
        bp bpVar4 = this.M.g;
        lz0VarF.c = fc0.j(i);
        lz0VarF.g = bpVar4;
        this.M = lz0VarF.a();
        b();
    }

    public void setBoxStrokeColor(int i) {
        if (this.n0 != i) {
            this.n0 = i;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.l0 = colorStateList.getDefaultColor();
            this.t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.m0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.n0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.n0 != colorStateList.getDefaultColor()) {
            this.n0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.o0 != colorStateList) {
            this.o0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.S = i;
        x();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.T = i;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            db0 db0Var = this.k;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.p = appCompatTextView;
                appCompatTextView.setId(com.quickcursor.R.id.textinput_counter);
                Typeface typeface = this.c0;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                db0Var.a(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.p != null) {
                    EditText editText = this.e;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                db0Var.g(this.p, 2);
                this.p = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i > 0) {
                this.m = i;
            } else {
                this.m = -1;
            }
            if (!this.l || this.p == null) {
                return;
            }
            EditText editText = this.e;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.r != i) {
            this.r = i;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (m() || (this.p != null && this.n)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.j0 = colorStateList;
        this.k0 = colorStateList;
        if (this.e != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        k(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.d.h.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.d.h.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        hz hzVar = this.d;
        CharSequence text = i != 0 ? hzVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = hzVar.h;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        hz hzVar = this.d;
        Drawable drawableJ = i != 0 ? tk0.j(hzVar.getContext(), i) : null;
        TextInputLayout textInputLayout = hzVar.b;
        CheckableImageButton checkableImageButton = hzVar.h;
        checkableImageButton.setImageDrawable(drawableJ);
        if (drawableJ != null) {
            xy0.b(textInputLayout, checkableImageButton, hzVar.l, hzVar.m);
            xy0.y(textInputLayout, checkableImageButton, hzVar.l);
        }
    }

    public void setEndIconMinSize(int i) {
        hz hzVar = this.d;
        if (i < 0) {
            hzVar.getClass();
            zy.n("endIconSize cannot be less than 0");
        } else if (i != hzVar.n) {
            hzVar.n = i;
            CheckableImageButton checkableImageButton = hzVar.h;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = hzVar.d;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.d.g(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        hz hzVar = this.d;
        CheckableImageButton checkableImageButton = hzVar.h;
        View.OnLongClickListener onLongClickListener = hzVar.p;
        checkableImageButton.setOnClickListener(onClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        hz hzVar = this.d;
        hzVar.p = onLongClickListener;
        CheckableImageButton checkableImageButton = hzVar.h;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        hz hzVar = this.d;
        hzVar.o = scaleType;
        hzVar.h.setScaleType(scaleType);
        hzVar.d.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        hz hzVar = this.d;
        if (hzVar.l != colorStateList) {
            hzVar.l = colorStateList;
            xy0.b(hzVar.b, hzVar.h, colorStateList, hzVar.m);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        hz hzVar = this.d;
        if (hzVar.m != mode) {
            hzVar.m = mode;
            xy0.b(hzVar.b, hzVar.h, hzVar.l, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.d.h(z);
    }

    public void setError(CharSequence charSequence) {
        db0 db0Var = this.k;
        if (!db0Var.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            db0Var.f();
            return;
        }
        db0Var.c();
        db0Var.p = charSequence;
        db0Var.r.setText(charSequence);
        int i = db0Var.n;
        if (i != 1) {
            db0Var.o = 1;
        }
        db0Var.i(i, db0Var.o, db0Var.h(db0Var.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        db0 db0Var = this.k;
        db0Var.t = i;
        AppCompatTextView appCompatTextView = db0Var.r;
        if (appCompatTextView != null) {
            WeakHashMap weakHashMap = uf1.a;
            appCompatTextView.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        db0 db0Var = this.k;
        db0Var.s = charSequence;
        AppCompatTextView appCompatTextView = db0Var.r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        db0 db0Var = this.k;
        TextInputLayout textInputLayout = db0Var.h;
        if (db0Var.q == z) {
            return;
        }
        db0Var.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(db0Var.g, null);
            db0Var.r = appCompatTextView;
            appCompatTextView.setId(com.quickcursor.R.id.textinput_error);
            db0Var.r.setTextAlignment(5);
            Typeface typeface = db0Var.B;
            if (typeface != null) {
                db0Var.r.setTypeface(typeface);
            }
            int i = db0Var.u;
            db0Var.u = i;
            AppCompatTextView appCompatTextView2 = db0Var.r;
            if (appCompatTextView2 != null) {
                db0Var.h.l(appCompatTextView2, i);
            }
            ColorStateList colorStateList = db0Var.v;
            db0Var.v = colorStateList;
            AppCompatTextView appCompatTextView3 = db0Var.r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = db0Var.s;
            db0Var.s = charSequence;
            AppCompatTextView appCompatTextView4 = db0Var.r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i2 = db0Var.t;
            db0Var.t = i2;
            AppCompatTextView appCompatTextView5 = db0Var.r;
            if (appCompatTextView5 != null) {
                WeakHashMap weakHashMap = uf1.a;
                appCompatTextView5.setAccessibilityLiveRegion(i2);
            }
            db0Var.r.setVisibility(4);
            db0Var.a(db0Var.r, 0);
        } else {
            db0Var.f();
            db0Var.g(db0Var.r, 0);
            db0Var.r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        db0Var.q = z;
    }

    public void setErrorIconDrawable(int i) {
        hz hzVar = this.d;
        hzVar.i(i != 0 ? tk0.j(hzVar.getContext(), i) : null);
        xy0.y(hzVar.b, hzVar.d, hzVar.e);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        hz hzVar = this.d;
        CheckableImageButton checkableImageButton = hzVar.d;
        View.OnLongClickListener onLongClickListener = hzVar.g;
        checkableImageButton.setOnClickListener(onClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        hz hzVar = this.d;
        hzVar.g = onLongClickListener;
        CheckableImageButton checkableImageButton = hzVar.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        hz hzVar = this.d;
        if (hzVar.e != colorStateList) {
            hzVar.e = colorStateList;
            xy0.b(hzVar.b, hzVar.d, colorStateList, hzVar.f);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        hz hzVar = this.d;
        if (hzVar.f != mode) {
            hzVar.f = mode;
            xy0.b(hzVar.b, hzVar.d, hzVar.e, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        db0 db0Var = this.k;
        db0Var.u = i;
        AppCompatTextView appCompatTextView = db0Var.r;
        if (appCompatTextView != null) {
            db0Var.h.l(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        db0 db0Var = this.k;
        db0Var.v = colorStateList;
        AppCompatTextView appCompatTextView = db0Var.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.x0 != z) {
            this.x0 = z;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        db0 db0Var = this.k;
        if (zIsEmpty) {
            if (db0Var.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!db0Var.x) {
            setHelperTextEnabled(true);
        }
        db0Var.c();
        db0Var.w = charSequence;
        db0Var.y.setText(charSequence);
        int i = db0Var.n;
        if (i != 2) {
            db0Var.o = 2;
        }
        db0Var.i(i, db0Var.o, db0Var.h(db0Var.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        db0 db0Var = this.k;
        db0Var.A = colorStateList;
        AppCompatTextView appCompatTextView = db0Var.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        db0 db0Var = this.k;
        TextInputLayout textInputLayout = db0Var.h;
        if (db0Var.x == z) {
            return;
        }
        db0Var.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(db0Var.g, null);
            db0Var.y = appCompatTextView;
            appCompatTextView.setId(com.quickcursor.R.id.textinput_helper_text);
            db0Var.y.setTextAlignment(5);
            Typeface typeface = db0Var.B;
            if (typeface != null) {
                db0Var.y.setTypeface(typeface);
            }
            db0Var.y.setVisibility(4);
            AppCompatTextView appCompatTextView2 = db0Var.y;
            WeakHashMap weakHashMap = uf1.a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i = db0Var.z;
            db0Var.z = i;
            AppCompatTextView appCompatTextView3 = db0Var.y;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i);
            }
            ColorStateList colorStateList = db0Var.A;
            db0Var.A = colorStateList;
            AppCompatTextView appCompatTextView4 = db0Var.y;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            db0Var.a(db0Var.y, 1);
            db0Var.y.setAccessibilityDelegate(new cb0(db0Var));
        } else {
            db0Var.c();
            int i2 = db0Var.n;
            if (i2 == 2) {
                db0Var.o = 0;
            }
            db0Var.i(i2, db0Var.o, db0Var.h(db0Var.y, ""));
            db0Var.g(db0Var.y, 1);
            db0Var.y = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        db0Var.x = z;
    }

    public void setHelperTextTextAppearance(int i) {
        db0 db0Var = this.k;
        db0Var.z = i;
        AppCompatTextView appCompatTextView = db0Var.y;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.y0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.D) {
            this.D = z;
            if (z) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        gl glVar = this.w0;
        TextInputLayout textInputLayout = glVar.a;
        x41 x41Var = new x41(textInputLayout.getContext(), i);
        ColorStateList colorStateList = x41Var.j;
        if (colorStateList != null) {
            glVar.k = colorStateList;
        }
        float f = x41Var.k;
        if (f != 0.0f) {
            glVar.i = f;
        }
        ColorStateList colorStateList2 = x41Var.a;
        if (colorStateList2 != null) {
            glVar.U = colorStateList2;
        }
        glVar.S = x41Var.e;
        glVar.T = x41Var.f;
        glVar.R = x41Var.g;
        glVar.V = x41Var.i;
        li liVar = glVar.y;
        if (liVar != null) {
            liVar.h = true;
        }
        sp1 sp1Var = new sp1(11, glVar);
        x41Var.a();
        glVar.y = new li(sp1Var, x41Var.n);
        x41Var.c(textInputLayout.getContext(), glVar.y);
        glVar.h(false);
        this.k0 = glVar.k;
        if (this.e != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            if (this.j0 == null) {
                gl glVar = this.w0;
                if (glVar.k != colorStateList) {
                    glVar.k = colorStateList;
                    glVar.h(false);
                }
            }
            this.k0 = colorStateList;
            if (this.e != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(d51 d51Var) {
        this.o = d51Var;
    }

    public void setMaxEms(int i) {
        this.h = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.j = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.g = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.i = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        hz hzVar = this.d;
        hzVar.h.setContentDescription(i != 0 ? hzVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        hz hzVar = this.d;
        hzVar.h.setImageDrawable(i != 0 ? tk0.j(hzVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        hz hzVar = this.d;
        if (z && hzVar.j != 1) {
            hzVar.g(1);
        } else if (z) {
            hzVar.getClass();
        } else {
            hzVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        hz hzVar = this.d;
        hzVar.l = colorStateList;
        xy0.b(hzVar.b, hzVar.h, colorStateList, hzVar.m);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        hz hzVar = this.d;
        hzVar.m = mode;
        xy0.b(hzVar.b, hzVar.h, hzVar.l, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.u = appCompatTextView;
            appCompatTextView.setId(com.quickcursor.R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.u;
            WeakHashMap weakHashMap = uf1.a;
            appCompatTextView2.setImportantForAccessibility(2);
            b10 b10VarD = d();
            this.x = b10VarD;
            b10VarD.c = 67L;
            this.y = d();
            setPlaceholderTextAppearance(this.w);
            setPlaceholderTextColor(this.v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.t) {
                setPlaceholderTextEnabled(true);
            }
            this.s = charSequence;
        }
        EditText editText = this.e;
        v(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.w = i;
        AppCompatTextView appCompatTextView = this.u;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        n21 n21Var = this.c;
        n21Var.getClass();
        n21Var.d = TextUtils.isEmpty(charSequence) ? null : charSequence;
        n21Var.c.setText(charSequence);
        n21Var.e();
    }

    public void setPrefixTextAppearance(int i) {
        this.c.c.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.c.c.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(mz0 mz0Var) {
        ik0 ik0Var = this.G;
        if (ik0Var == null || ik0Var.b.a == mz0Var) {
            return;
        }
        this.M = mz0Var;
        b();
    }

    public void setStartIconCheckable(boolean z) {
        this.c.e.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? tk0.j(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        n21 n21Var = this.c;
        if (i < 0) {
            n21Var.getClass();
            zy.n("startIconSize cannot be less than 0");
        } else if (i != n21Var.h) {
            n21Var.h = i;
            CheckableImageButton checkableImageButton = n21Var.e;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        n21 n21Var = this.c;
        CheckableImageButton checkableImageButton = n21Var.e;
        View.OnLongClickListener onLongClickListener = n21Var.j;
        checkableImageButton.setOnClickListener(onClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        n21 n21Var = this.c;
        n21Var.j = onLongClickListener;
        CheckableImageButton checkableImageButton = n21Var.e;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        xy0.F(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        n21 n21Var = this.c;
        n21Var.i = scaleType;
        n21Var.e.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        n21 n21Var = this.c;
        if (n21Var.f != colorStateList) {
            n21Var.f = colorStateList;
            xy0.b(n21Var.b, n21Var.e, colorStateList, n21Var.g);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        n21 n21Var = this.c;
        if (n21Var.g != mode) {
            n21Var.g = mode;
            xy0.b(n21Var.b, n21Var.e, n21Var.f, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.c.c(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        hz hzVar = this.d;
        hzVar.getClass();
        hzVar.q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        hzVar.r.setText(charSequence);
        hzVar.n();
    }

    public void setSuffixTextAppearance(int i) {
        this.d.r.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.d.r.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(c51 c51Var) {
        EditText editText = this.e;
        if (editText != null) {
            uf1.n(editText, c51Var);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.c0) {
            this.c0 = typeface;
            this.w0.m(typeface);
            db0 db0Var = this.k;
            if (typeface != db0Var.B) {
                db0Var.B = typeface;
                AppCompatTextView appCompatTextView = db0Var.r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = db0Var.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.p;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.P != 1) {
            FrameLayout frameLayout = this.b;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.j0;
        gl glVar = this.w0;
        if (colorStateList2 != null) {
            glVar.i(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.j0;
            int colorForState = this.t0;
            if (colorStateList3 != null) {
                colorForState = colorStateList3.getColorForState(new int[]{-16842910}, colorForState);
            }
            glVar.i(ColorStateList.valueOf(colorForState));
        } else if (m()) {
            AppCompatTextView appCompatTextView2 = this.k.r;
            glVar.i(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.n && (appCompatTextView = this.p) != null) {
            glVar.i(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.k0) != null && glVar.k != colorStateList) {
            glVar.k = colorStateList;
            glVar.h(false);
        }
        hz hzVar = this.d;
        n21 n21Var = this.c;
        if (z3 || !this.x0 || (isEnabled() && z4)) {
            if (z2 || this.v0) {
                ValueAnimator valueAnimator = this.z0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.z0.cancel();
                }
                if (z && this.y0) {
                    a(1.0f);
                } else {
                    glVar.k(1.0f);
                }
                this.v0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.e;
                v(editText3 != null ? editText3.getText() : null);
                n21Var.k = false;
                n21Var.e();
                hzVar.s = false;
                hzVar.n();
                return;
            }
            return;
        }
        if (z2 || !this.v0) {
            ValueAnimator valueAnimator2 = this.z0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.z0.cancel();
            }
            if (z && this.y0) {
                a(0.0f);
            } else {
                glVar.k(0.0f);
            }
            if (e() && !((mr) this.G).y.q.isEmpty() && e()) {
                ((mr) this.G).o(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.v0 = true;
            AppCompatTextView appCompatTextView3 = this.u;
            if (appCompatTextView3 != null && this.t) {
                appCompatTextView3.setText((CharSequence) null);
                x81.a(this.b, this.y);
                this.u.setVisibility(4);
            }
            n21Var.k = true;
            n21Var.e();
            hzVar.s = true;
            hzVar.n();
        }
    }

    public final void v(Editable editable) {
        ((ay0) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.b;
        if (length != 0 || this.v0) {
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView == null || !this.t) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            x81.a(frameLayout, this.y);
            this.u.setVisibility(4);
            return;
        }
        if (this.u == null || !this.t || TextUtils.isEmpty(this.s)) {
            return;
        }
        this.u.setText(this.s);
        x81.a(frameLayout, this.x);
        this.u.setVisibility(0);
        this.u.bringToFront();
        announceForAccessibility(this.s);
    }

    public final void w(boolean z, boolean z2) {
        int defaultColor = this.o0.getDefaultColor();
        int colorForState = this.o0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.o0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.U = colorForState2;
        } else if (z2) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    public final void x() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.P == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.U = this.t0;
        } else if (m()) {
            if (this.o0 != null) {
                w(z2, z);
            } else {
                this.U = getErrorCurrentTextColors();
            }
        } else if (!this.n || (appCompatTextView = this.p) == null) {
            if (z2) {
                this.U = this.n0;
            } else if (z) {
                this.U = this.m0;
            } else {
                this.U = this.l0;
            }
        } else if (this.o0 != null) {
            w(z2, z);
        } else {
            this.U = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        hz hzVar = this.d;
        TextInputLayout textInputLayout = hzVar.b;
        CheckableImageButton checkableImageButton = hzVar.h;
        TextInputLayout textInputLayout2 = hzVar.b;
        hzVar.l();
        xy0.y(textInputLayout2, hzVar.d, hzVar.e);
        xy0.y(textInputLayout2, checkableImageButton, hzVar.l);
        if (hzVar.b() instanceof ev) {
            if (!textInputLayout.m() || checkableImageButton.getDrawable() == null) {
                xy0.b(textInputLayout, checkableImageButton, hzVar.l, hzVar.m);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        n21 n21Var = this.c;
        xy0.y(n21Var.b, n21Var.e, n21Var.f);
        if (this.P == 2) {
            int i = this.R;
            if (z2 && isEnabled()) {
                this.R = this.T;
            } else {
                this.R = this.S;
            }
            if (this.R != i && e() && !this.v0) {
                if (e()) {
                    ((mr) this.G).o(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.P == 1) {
            if (!isEnabled()) {
                this.V = this.q0;
            } else if (z && !z2) {
                this.V = this.s0;
            } else if (z2) {
                this.V = this.r0;
            } else {
                this.V = this.p0;
            }
        }
        b();
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.c.e;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.c.b(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.d.h.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.d.h.setImageDrawable(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.d.h;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.d.i(drawable);
    }

    public void setEndIconDrawable(Drawable drawable) {
        hz hzVar = this.d;
        TextInputLayout textInputLayout = hzVar.b;
        CheckableImageButton checkableImageButton = hzVar.h;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            xy0.b(textInputLayout, checkableImageButton, hzVar.l, hzVar.m);
            xy0.y(textInputLayout, checkableImageButton, hzVar.l);
        }
    }
}
