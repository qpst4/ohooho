package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import defpackage.c7;
import defpackage.d9;
import defpackage.ej;
import defpackage.fa;
import defpackage.fy;
import defpackage.hf1;
import defpackage.n51;
import defpackage.ra;
import defpackage.sx;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.vg1;
import defpackage.vu;
import defpackage.xr;
import defpackage.xy0;
import defpackage.zs0;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final ej S = new ej(Float.class, "thumbPos", 9);
    public static final int[] T = {R.attr.state_checked};
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public final TextPaint J;
    public final ColorStateList K;
    public StaticLayout L;
    public StaticLayout M;
    public final c7 N;
    public ObjectAnimator O;
    public d9 P;
    public fy Q;
    public final Rect R;
    public Drawable b;
    public ColorStateList c;
    public PorterDuff.Mode d;
    public boolean e;
    public boolean f;
    public Drawable g;
    public ColorStateList h;
    public PorterDuff.Mode i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public CharSequence p;
    public CharSequence q;
    public CharSequence r;
    public CharSequence s;
    public boolean t;
    public int u;
    public final int v;
    public float w;
    public float x;
    public final VelocityTracker y;
    public final int z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, com.quickcursor.R.attr.switchStyle);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.y = VelocityTracker.obtain();
        this.I = true;
        this.R = new Rect();
        n51.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.J = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = zs0.v;
        ra raVarM = ra.M(context, attributeSet, iArr, com.quickcursor.R.attr.switchStyle);
        TypedArray typedArray = (TypedArray) raVarM.c;
        uf1.m(this, context, iArr, attributeSet, typedArray, com.quickcursor.R.attr.switchStyle);
        Drawable drawableY = raVarM.y(2);
        this.b = drawableY;
        if (drawableY != null) {
            drawableY.setCallback(this);
        }
        Drawable drawableY2 = raVarM.y(11);
        this.g = drawableY2;
        if (drawableY2 != null) {
            drawableY2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.t = typedArray.getBoolean(3, true);
        this.l = typedArray.getDimensionPixelSize(8, 0);
        this.m = typedArray.getDimensionPixelSize(5, 0);
        this.n = typedArray.getDimensionPixelSize(6, 0);
        this.o = typedArray.getBoolean(4, false);
        ColorStateList colorStateListX = raVarM.x(9);
        if (colorStateListX != null) {
            this.c = colorStateListX;
            this.e = true;
        }
        PorterDuff.Mode modeC = vu.c(typedArray.getInt(10, -1), null);
        if (this.d != modeC) {
            this.d = modeC;
            this.f = true;
        }
        if (this.e || this.f) {
            a();
        }
        ColorStateList colorStateListX2 = raVarM.x(12);
        if (colorStateListX2 != null) {
            this.h = colorStateListX2;
            this.j = true;
        }
        PorterDuff.Mode modeC2 = vu.c(typedArray.getInt(13, -1), null);
        if (this.i != modeC2) {
            this.i = modeC2;
            this.k = true;
        }
        if (this.j || this.k) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, zs0.w);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = xy0.p(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.K = colorStateList;
            } else {
                this.K = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i2 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i != 1 ? i != 2 ? i != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i2 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
                textPaint.setFakeBoldText((i3 & 1) != 0);
                textPaint.setTextSkewX((2 & i3) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                c7 c7Var = new c7();
                c7Var.b = context2.getResources().getConfiguration().locale;
                this.N = c7Var;
            } else {
                this.N = null;
            }
            setTextOnInternal(this.p);
            setTextOffInternal(this.r);
            typedArrayObtainStyledAttributes.recycle();
        }
        new fa(this).f(attributeSet, com.quickcursor.R.attr.switchStyle);
        raVarM.O();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, com.quickcursor.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private d9 getEmojiTextViewHelper() {
        if (this.P == null) {
            this.P = new d9(this);
        }
        return this.P;
    }

    private boolean getTargetCheckedState() {
        return this.A > 0.5f;
    }

    private int getThumbOffset() {
        boolean z = vg1.a;
        int layoutDirection = getLayoutDirection();
        float f = this.A;
        if (layoutDirection == 1) {
            f = 1.0f - f;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.b;
        Rect rectB = drawable2 != null ? vu.b(drawable2) : vu.c;
        return ((((this.B - this.D) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.r = charSequence;
        TransformationMethod transformationMethodL = ((tk0) getEmojiTextViewHelper().b.c).L(this.N);
        if (transformationMethodL != null) {
            charSequence = transformationMethodL.getTransformation(charSequence, this);
        }
        this.s = charSequence;
        this.M = null;
        if (this.t) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.p = charSequence;
        TransformationMethod transformationMethodL = ((tk0) getEmojiTextViewHelper().b.c).L(this.N);
        if (transformationMethodL != null) {
            charSequence = transformationMethodL.getTransformation(charSequence, this);
        }
        this.q = charSequence;
        this.L = null;
        if (this.t) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.b;
        if (drawable != null) {
            if (this.e || this.f) {
                Drawable drawableMutate = drawable.mutate();
                this.b = drawableMutate;
                if (this.e) {
                    drawableMutate.setTintList(this.c);
                }
                if (this.f) {
                    this.b.setTintMode(this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.g;
        if (drawable != null) {
            if (this.j || this.k) {
                Drawable drawableMutate = drawable.mutate();
                this.g = drawableMutate;
                if (this.j) {
                    drawableMutate.setTintList(this.h);
                }
                if (this.k) {
                    this.g.setTintMode(this.i);
                }
                if (this.g.isStateful()) {
                    this.g.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public final void d() {
        if (this.Q == null && ((tk0) this.P.b.c).q() && sx.k != null) {
            sx sxVarA = sx.a();
            int iB = sxVarA.b();
            if (iB == 3 || iB == 0) {
                fy fyVar = new fy(this);
                this.Q = fyVar;
                sxVarA.f(fyVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.E;
        int i4 = this.F;
        int i5 = this.G;
        int i6 = this.H;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.b;
        Rect rectB = drawable != null ? vu.b(drawable) : vu.c;
        Drawable drawable2 = this.g;
        Rect rect = this.R;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (rectB != null) {
                int i8 = rectB.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectB.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectB.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectB.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.g.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.g.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.D + rect.right;
            this.b.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.b;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z = vg1.a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z = vg1.a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return xr.P(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.t;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.r;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.b;
    }

    public final float getThumbPosition() {
        return this.A;
    }

    public int getThumbTextPadding() {
        return this.l;
    }

    public ColorStateList getThumbTintList() {
        return this.c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.d;
    }

    public Drawable getTrackDrawable() {
        return this.g;
    }

    public ColorStateList getTrackTintList() {
        return this.h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.O.end();
        this.O = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.g;
        Rect rect = this.R;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.F;
        int i2 = this.H;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.b;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = vu.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.L : this.M;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.J;
            ColorStateList colorStateList = this.K;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.p : this.r;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.b != null) {
            Drawable drawable = this.g;
            Rect rect = this.R;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = vu.b(this.b);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        boolean z2 = vg1.a;
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.B + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.B) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i5 = this.C;
            int i6 = height2 - (i5 / 2);
            height = i5 + i6;
            paddingTop = i6;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.C + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.C;
        }
        this.E = paddingLeft;
        this.F = paddingTop;
        this.H = height;
        this.G = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.t) {
            StaticLayout staticLayout = this.L;
            TextPaint textPaint = this.J;
            if (staticLayout == null) {
                CharSequence charSequence = this.q;
                this.L = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.M == null) {
                CharSequence charSequence2 = this.s;
                this.M = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.b;
        Rect rect = this.R;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.b.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.D = Math.max(this.t ? (this.l * 2) + Math.max(this.L.getWidth(), this.M.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            Rect rectB = vu.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        boolean z = this.I;
        int iMax3 = this.m;
        if (z) {
            iMax3 = Math.max(iMax3, (this.D * 2) + iMax + iMax2);
        }
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.B = iMax3;
        this.C = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.p;
                if (string == null) {
                    string = getResources().getString(com.quickcursor.R.string.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = uf1.a;
                new hf1(com.quickcursor.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.r;
            if (string2 == null) {
                string2 = getResources().getString(com.quickcursor.R.string.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = uf1.a;
            new hf1(com.quickcursor.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.O;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, S, zIsChecked ? 1.0f : 0.0f);
        this.O = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.O.setAutoCancel(true);
        this.O.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(xr.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.I = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.t != z) {
            this.t = z;
            requestLayout();
            if (z) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.m = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.n = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.J;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.r;
        if (string == null) {
            string = getResources().getString(com.quickcursor.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = uf1.a;
        new hf1(com.quickcursor.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.p;
        if (string == null) {
            string = getResources().getString(com.quickcursor.R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = uf1.a;
        new hf1(com.quickcursor.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.A = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(tk0.j(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.l = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.e = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(tk0.j(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        this.j = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.i = mode;
        this.k = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b || drawable == this.g;
    }
}
