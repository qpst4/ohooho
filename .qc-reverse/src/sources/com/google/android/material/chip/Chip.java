package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import defpackage.a51;
import defpackage.bm0;
import defpackage.c8;
import defpackage.dk0;
import defpackage.ek;
import defpackage.f01;
import defpackage.fc0;
import defpackage.fk;
import defpackage.gk;
import defpackage.hk;
import defpackage.i1;
import defpackage.lf1;
import defpackage.mz0;
import defpackage.nw0;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.x41;
import defpackage.xg;
import defpackage.xy0;
import defpackage.xz0;
import defpackage.y41;
import defpackage.yb0;
import defpackage.ye;
import defpackage.ys0;
import defpackage.zy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends c8 implements xz0, Checkable {
    public static final Rect x = new Rect();
    public static final int[] y = {R.attr.state_selected};
    public static final int[] z = {R.attr.state_checkable};
    public hk f;
    public InsetDrawable g;
    public RippleDrawable h;
    public View.OnClickListener i;
    public CompoundButton.OnCheckedChangeListener j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public CharSequence r;
    public final gk s;
    public boolean t;
    public final Rect u;
    public final RectF v;
    public final ek w;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(xy0.L(context, attributeSet, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.quickcursor.R.attr.chipStyle);
        this.u = new Rect();
        this.v = new RectF();
        this.w = new ek(0, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                zy.f("Please set left drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                zy.f("Please set start drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                zy.f("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                zy.f("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                zy.f("Chip does not support multi-line text");
                throw null;
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        hk hkVar = new hk(context2, attributeSet);
        Context context3 = hkVar.f0;
        int[] iArr = ys0.d;
        TypedArray typedArrayE = f01.E(context3, attributeSet, iArr, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        hkVar.F0 = typedArrayE.hasValue(37);
        Context context4 = hkVar.f0;
        ColorStateList colorStateListI = yb0.i(context4, typedArrayE, 24);
        if (hkVar.y != colorStateListI) {
            hkVar.y = colorStateListI;
            hkVar.onStateChange(hkVar.getState());
        }
        ColorStateList colorStateListI2 = yb0.i(context4, typedArrayE, 11);
        if (hkVar.z != colorStateListI2) {
            hkVar.z = colorStateListI2;
            hkVar.onStateChange(hkVar.getState());
        }
        float dimension = typedArrayE.getDimension(19, 0.0f);
        if (hkVar.A != dimension) {
            hkVar.A = dimension;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        if (typedArrayE.hasValue(12)) {
            hkVar.B(typedArrayE.getDimension(12, 0.0f));
        }
        hkVar.G(yb0.i(context4, typedArrayE, 22));
        hkVar.H(typedArrayE.getDimension(23, 0.0f));
        hkVar.Q(yb0.i(context4, typedArrayE, 36));
        String text = typedArrayE.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(hkVar.F, text);
        a51 a51Var = hkVar.l0;
        if (!zEquals) {
            hkVar.F = text;
            a51Var.e = true;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        x41 x41Var = (!typedArrayE.hasValue(0) || (resourceId = typedArrayE.getResourceId(0, 0)) == 0) ? null : new x41(context4, resourceId);
        x41Var.k = typedArrayE.getDimension(1, x41Var.k);
        a51Var.b(x41Var, context4);
        int i = typedArrayE.getInt(3, 0);
        if (i == 1) {
            hkVar.C0 = TextUtils.TruncateAt.START;
        } else if (i == 2) {
            hkVar.C0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i == 3) {
            hkVar.C0 = TextUtils.TruncateAt.END;
        }
        hkVar.F(typedArrayE.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            hkVar.F(typedArrayE.getBoolean(15, false));
        }
        hkVar.C(yb0.j(context4, typedArrayE, 14));
        if (typedArrayE.hasValue(17)) {
            hkVar.E(yb0.i(context4, typedArrayE, 17));
        }
        hkVar.D(typedArrayE.getDimension(16, -1.0f));
        hkVar.N(typedArrayE.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            hkVar.N(typedArrayE.getBoolean(26, false));
        }
        hkVar.I(yb0.j(context4, typedArrayE, 25));
        hkVar.M(yb0.i(context4, typedArrayE, 30));
        hkVar.K(typedArrayE.getDimension(28, 0.0f));
        hkVar.x(typedArrayE.getBoolean(6, false));
        hkVar.A(typedArrayE.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            hkVar.A(typedArrayE.getBoolean(8, false));
        }
        hkVar.y(yb0.j(context4, typedArrayE, 7));
        if (typedArrayE.hasValue(9)) {
            hkVar.z(yb0.i(context4, typedArrayE, 9));
        }
        hkVar.V = bm0.a(context4, typedArrayE, 39);
        hkVar.W = bm0.a(context4, typedArrayE, 33);
        float dimension2 = typedArrayE.getDimension(21, 0.0f);
        if (hkVar.X != dimension2) {
            hkVar.X = dimension2;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        hkVar.P(typedArrayE.getDimension(35, 0.0f));
        hkVar.O(typedArrayE.getDimension(34, 0.0f));
        float dimension3 = typedArrayE.getDimension(41, 0.0f);
        if (hkVar.a0 != dimension3) {
            hkVar.a0 = dimension3;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        float dimension4 = typedArrayE.getDimension(40, 0.0f);
        if (hkVar.b0 != dimension4) {
            hkVar.b0 = dimension4;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        hkVar.L(typedArrayE.getDimension(29, 0.0f));
        hkVar.J(typedArrayE.getDimension(27, 0.0f));
        float dimension5 = typedArrayE.getDimension(13, 0.0f);
        if (hkVar.e0 != dimension5) {
            hkVar.e0 = dimension5;
            hkVar.invalidateSelf();
            hkVar.v();
        }
        hkVar.E0 = typedArrayE.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayE.recycle();
        f01.i(context2, attributeSet, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action);
        f01.l(context2, attributeSet, iArr, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action);
        this.o = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.q = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(i1.p(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(hkVar);
        hkVar.j(lf1.e(this));
        f01.i(context2, attributeSet, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action);
        f01.l(context2, attributeSet, iArr, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.s = new gk(this, this);
        d();
        if (!zHasValue) {
            setOutlineProvider(new fk(this));
        }
        setChecked(this.k);
        setText(hkVar.F);
        setEllipsize(hkVar.C0);
        g();
        if (!this.f.D0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.o) {
            setMinHeight(this.q);
        }
        this.p = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.a.j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.v;
        rectF.setEmpty();
        if (c() && this.i != null) {
            hk hkVar = this.f;
            Rect bounds = hkVar.getBounds();
            rectF.setEmpty();
            if (hkVar.T()) {
                float f = hkVar.e0 + hkVar.d0 + hkVar.P + hkVar.c0 + hkVar.b0;
                if (hkVar.getLayoutDirection() == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i2 = (int) closeIconTouchBounds.top;
        int i3 = (int) closeIconTouchBounds.right;
        int i4 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.u;
        rect.set(i, i2, i3, i4);
        return rect;
    }

    private x41 getTextAppearance() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.l0.g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.m != z2) {
            this.m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.l != z2) {
            this.l = z2;
            refreshDrawableState();
        }
    }

    public final void b(int i) {
        this.q = i;
        if (!this.o) {
            InsetDrawable insetDrawable = this.g;
            if (insetDrawable == null) {
                int[] iArr = nw0.a;
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.g = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = nw0.a;
                    e();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.f.A));
        int iMax2 = Math.max(0, i - this.f.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.g;
            if (insetDrawable2 == null) {
                int[] iArr3 = nw0.a;
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.g = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = nw0.a;
                    e();
                    return;
                }
                return;
            }
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.g != null) {
            Rect rect = new Rect();
            this.g.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                int[] iArr5 = nw0.a;
                e();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.g = new InsetDrawable((Drawable) this.f, i2, i3, i2, i3);
        int[] iArr6 = nw0.a;
        e();
    }

    public final boolean c() {
        hk hkVar = this.f;
        if (hkVar == null) {
            return false;
        }
        Drawable drawable = hkVar.M;
        if (drawable == null) {
            drawable = null;
        }
        return drawable != null;
    }

    public final void d() {
        hk hkVar;
        if (!c() || (hkVar = this.f) == null || !hkVar.L || this.i == null) {
            uf1.n(this, null);
            this.t = false;
        } else {
            uf1.n(this, this.s);
            this.t = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.t
            if (r0 != 0) goto L9
            boolean r7 = super.dispatchHoverEvent(r8)
            return r7
        L9:
            gk r0 = r7.s
            android.view.accessibility.AccessibilityManager r1 = r0.h
            boolean r2 = r1.isEnabled()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L6b
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L1c
            goto L6b
        L1c:
            int r1 = r8.getAction()
            r2 = 7
            r5 = 256(0x100, float:3.59E-43)
            r6 = 128(0x80, float:1.8E-43)
            if (r1 == r2) goto L42
            r2 = 9
            if (r1 == r2) goto L42
            r2 = 10
            if (r1 == r2) goto L30
            goto L6b
        L30:
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L6b
            if (r1 != r2) goto L39
            goto L71
        L39:
            r0.m = r2
            r0.p(r2, r6)
            r0.p(r1, r5)
            return r4
        L42:
            float r7 = r8.getX()
            float r8 = r8.getY()
            com.google.android.material.chip.Chip r1 = r0.n
            boolean r2 = r1.c()
            if (r2 == 0) goto L5d
            android.graphics.RectF r1 = r1.getCloseIconTouchBounds()
            boolean r7 = r1.contains(r7, r8)
            if (r7 == 0) goto L5d
            r3 = r4
        L5d:
            int r7 = r0.m
            if (r7 != r3) goto L62
            goto L71
        L62:
            r0.m = r3
            r0.p(r3, r6)
            r0.p(r7, r5)
            return r4
        L6b:
            boolean r7 = super.dispatchHoverEvent(r8)
            if (r7 == 0) goto L72
        L71:
            return r4
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.t
            if (r0 != 0) goto L9
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        L9:
            gk r0 = r9.s
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 0
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            if (r1 == r4) goto L9d
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L87
            r5 = 66
            if (r1 == r5) goto L58
            switch(r1) {
                case 19: goto L2a;
                case 20: goto L2a;
                case 21: goto L2a;
                case 22: goto L2a;
                case 23: goto L58;
                default: goto L28;
            }
        L28:
            goto L9d
        L2a:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L9d
            r7 = 19
            if (r1 == r7) goto L42
            r7 = 21
            if (r1 == r7) goto L3f
            r7 = 22
            if (r1 == r7) goto L44
            r5 = 130(0x82, float:1.82E-43)
            goto L44
        L3f:
            r5 = 17
            goto L44
        L42:
            r5 = 33
        L44:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r4
            r7 = r2
        L4a:
            if (r2 >= r1) goto L56
            boolean r8 = r0.m(r5, r6)
            if (r8 == 0) goto L56
            int r2 = r2 + 1
            r7 = r4
            goto L4a
        L56:
            r2 = r7
            goto L9d
        L58:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L9d
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L9d
            int r1 = r0.l
            if (r1 == r3) goto L85
            com.google.android.material.chip.Chip r5 = r0.n
            if (r1 != 0) goto L70
            r5.performClick()
            goto L85
        L70:
            if (r1 != r4) goto L85
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r1 = r5.i
            if (r1 == 0) goto L7c
            r1.onClick(r5)
        L7c:
            boolean r1 = r5.t
            if (r1 == 0) goto L85
            gk r1 = r5.s
            r1.p(r4, r4)
        L85:
            r2 = r4
            goto L9d
        L87:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L93
            r1 = 2
            boolean r2 = r0.m(r1, r6)
            goto L9d
        L93:
            boolean r1 = r10.hasModifiers(r4)
            if (r1 == 0) goto L9d
            boolean r2 = r0.m(r4, r6)
        L9d:
            if (r2 == 0) goto La4
            int r0 = r0.l
            if (r0 == r3) goto La4
            return r4
        La4:
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // defpackage.c8, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        super.drawableStateChanged();
        hk hkVar = this.f;
        boolean zW = false;
        if (hkVar != null && hk.u(hkVar.M)) {
            hk hkVar2 = this.f;
            ?? IsEnabled = isEnabled();
            int i2 = IsEnabled;
            if (this.n) {
                i2 = IsEnabled + 1;
            }
            int i3 = i2;
            if (this.m) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.l) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            } else {
                i = 0;
            }
            if (this.n) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.m) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.l) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            if (!Arrays.equals(hkVar2.z0, iArr)) {
                hkVar2.z0 = iArr;
                if (hkVar2.T()) {
                    zW = hkVar2.w(hkVar2.getState(), iArr);
                }
            }
        }
        if (zW) {
            invalidate();
        }
    }

    public final void e() {
        this.h = new RippleDrawable(nw0.c(this.f.E), getBackgroundDrawable(), null);
        this.f.getClass();
        RippleDrawable rippleDrawable = this.h;
        WeakHashMap weakHashMap = uf1.a;
        setBackground(rippleDrawable);
        f();
    }

    public final void f() {
        hk hkVar;
        if (TextUtils.isEmpty(getText()) || (hkVar = this.f) == null) {
            return;
        }
        int iR = (int) (hkVar.r() + hkVar.e0 + hkVar.b0);
        hk hkVar2 = this.f;
        int iQ = (int) (hkVar2.q() + hkVar2.X + hkVar2.a0);
        if (this.g != null) {
            Rect rect = new Rect();
            this.g.getPadding(rect);
            iQ += rect.left;
            iR += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = uf1.a;
        setPaddingRelative(iQ, paddingTop, iR, paddingBottom);
    }

    public final void g() {
        TextPaint paint = getPaint();
        hk hkVar = this.f;
        if (hkVar != null) {
            paint.drawableState = hkVar.getState();
        }
        x41 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.w);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.r)) {
            return this.r;
        }
        hk hkVar = this.f;
        if (hkVar == null || !hkVar.R) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.g;
        return insetDrawable == null ? this.f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.T;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.U;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.z;
        }
        return null;
    }

    public float getChipCornerRadius() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return Math.max(0.0f, hkVar.s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f;
    }

    public float getChipEndPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.e0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        hk hkVar = this.f;
        if (hkVar == null || (drawable = hkVar.H) == null) {
            return null;
        }
        return drawable;
    }

    public float getChipIconSize() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.J;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.I;
        }
        return null;
    }

    public float getChipMinHeight() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.A;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.X;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.C;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.D;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        hk hkVar = this.f;
        if (hkVar == null || (drawable = hkVar.M) == null) {
            return null;
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.Q;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.d0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.P;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.c0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.O;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.C0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.t) {
            gk gkVar = this.s;
            if (gkVar.l == 1 || gkVar.k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public bm0 getHideMotionSpec() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.W;
        }
        return null;
    }

    public float getIconEndPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.Z;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.Y;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.E;
        }
        return null;
    }

    public mz0 getShapeAppearanceModel() {
        return this.f.b.a;
    }

    public bm0 getShowMotionSpec() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.V;
        }
        return null;
    }

    public float getTextEndPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.b0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        hk hkVar = this.f;
        if (hkVar != null) {
            return hkVar.a0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        fc0.O(this, this.f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, y);
        }
        hk hkVar = this.f;
        if (hkVar != null && hkVar.R) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (this.t) {
            gk gkVar = this.s;
            int i2 = gkVar.l;
            if (i2 != Integer.MIN_VALUE) {
                gkVar.j(i2);
            }
            if (z2) {
                gkVar.m(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        hk hkVar = this.f;
        accessibilityNodeInfo.setCheckable(hkVar != null && hkVar.R);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.p != i) {
            this.p = i;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.l
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.l
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.i
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.t
            if (r0 == 0) goto L43
            gk r0 = r5.s
            r0.p(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // defpackage.c8, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // defpackage.c8, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.x(z2);
        }
    }

    public void setCheckableResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.x(hkVar.f0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        hk hkVar = this.f;
        if (hkVar == null) {
            this.k = z2;
        } else if (hkVar.R) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.y(tk0.j(hkVar.f0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.z(xy0.p(hkVar.f0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.A(hkVar.f0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.z == colorStateList) {
            return;
        }
        hkVar.z = colorStateList;
        hkVar.onStateChange(hkVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListP;
        hk hkVar = this.f;
        if (hkVar == null || hkVar.z == (colorStateListP = xy0.p(hkVar.f0, i))) {
            return;
        }
        hkVar.z = colorStateListP;
        hkVar.onStateChange(hkVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.B(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.B(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(hk hkVar) {
        hk hkVar2 = this.f;
        if (hkVar2 != hkVar) {
            if (hkVar2 != null) {
                hkVar2.B0 = new WeakReference(null);
            }
            this.f = hkVar;
            hkVar.D0 = false;
            hkVar.B0 = new WeakReference(this);
            b(this.q);
        }
    }

    public void setChipEndPadding(float f) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.e0 == f) {
            return;
        }
        hkVar.e0 = f;
        hkVar.invalidateSelf();
        hkVar.v();
    }

    public void setChipEndPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            float dimension = hkVar.f0.getResources().getDimension(i);
            if (hkVar.e0 != dimension) {
                hkVar.e0 = dimension;
                hkVar.invalidateSelf();
                hkVar.v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.C(tk0.j(hkVar.f0, i));
        }
    }

    public void setChipIconSize(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.D(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.D(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.E(xy0.p(hkVar.f0, i));
        }
    }

    public void setChipIconVisible(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.F(hkVar.f0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.A == f) {
            return;
        }
        hkVar.A = f;
        hkVar.invalidateSelf();
        hkVar.v();
    }

    public void setChipMinHeightResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            float dimension = hkVar.f0.getResources().getDimension(i);
            if (hkVar.A != dimension) {
                hkVar.A = dimension;
                hkVar.invalidateSelf();
                hkVar.v();
            }
        }
    }

    public void setChipStartPadding(float f) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.X == f) {
            return;
        }
        hkVar.X = f;
        hkVar.invalidateSelf();
        hkVar.v();
    }

    public void setChipStartPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            float dimension = hkVar.f0.getResources().getDimension(i);
            if (hkVar.X != dimension) {
                hkVar.X = dimension;
                hkVar.invalidateSelf();
                hkVar.v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.G(xy0.p(hkVar.f0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.H(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.H(hkVar.f0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.I(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.Q == charSequence) {
            return;
        }
        String str = ye.b;
        ye yeVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? ye.e : ye.d;
        yeVar.getClass();
        xg xgVar = y41.a;
        hkVar.Q = yeVar.c(charSequence);
        hkVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.J(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.J(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.I(tk0.j(hkVar.f0, i));
        }
        d();
    }

    public void setCloseIconSize(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.K(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.K(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.L(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.L(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.M(xy0.p(hkVar.f0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // defpackage.c8, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            zy.f("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            zy.f("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // defpackage.c8, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            zy.f("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            zy.f("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            zy.f("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            zy.f("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            zy.f("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            zy.f("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.j(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            zy.f("Text within a chip are not allowed to scroll.");
            return;
        }
        super.setEllipsize(truncateAt);
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.C0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.o = z2;
        b(this.q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(bm0 bm0Var) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.W = bm0Var;
        }
    }

    public void setHideMotionSpecResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.W = bm0.b(hkVar.f0, i);
        }
    }

    public void setIconEndPadding(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.O(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.O(hkVar.f0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.P(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.P(hkVar.f0.getResources().getDimension(i));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
        } else {
            zy.f("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
        } else {
            zy.f("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.E0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
        } else {
            zy.f("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.Q(colorStateList);
        }
        this.f.getClass();
        e();
    }

    public void setRippleColorResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.Q(xy0.p(hkVar.f0, i));
            this.f.getClass();
            e();
        }
    }

    @Override // defpackage.xz0
    public void setShapeAppearanceModel(mz0 mz0Var) {
        this.f.setShapeAppearanceModel(mz0Var);
    }

    public void setShowMotionSpec(bm0 bm0Var) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.V = bm0Var;
        }
    }

    public void setShowMotionSpecResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.V = bm0.b(hkVar.f0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
        } else {
            zy.f("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        hk hkVar = this.f;
        if (hkVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(hkVar.D0 ? null : charSequence, bufferType);
        hk hkVar2 = this.f;
        if (hkVar2 == null || TextUtils.equals(hkVar2.F, charSequence)) {
            return;
        }
        hkVar2.F = charSequence;
        hkVar2.l0.e = true;
        hkVar2.invalidateSelf();
        hkVar2.v();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        hk hkVar = this.f;
        if (hkVar != null) {
            Context context2 = hkVar.f0;
            hkVar.l0.b(new x41(context2, i), context2);
        }
        g();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.b0 == f) {
            return;
        }
        hkVar.b0 = f;
        hkVar.invalidateSelf();
        hkVar.v();
    }

    public void setTextEndPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            float dimension = hkVar.f0.getResources().getDimension(i);
            if (hkVar.b0 != dimension) {
                hkVar.b0 = dimension;
                hkVar.invalidateSelf();
                hkVar.v();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        hk hkVar = this.f;
        if (hkVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            a51 a51Var = hkVar.l0;
            x41 x41Var = a51Var.g;
            if (x41Var != null) {
                x41Var.k = fApplyDimension;
                a51Var.a.setTextSize(fApplyDimension);
                hkVar.a();
            }
        }
        g();
    }

    public void setTextStartPadding(float f) {
        hk hkVar = this.f;
        if (hkVar == null || hkVar.a0 == f) {
            return;
        }
        hkVar.a0 = f;
        hkVar.invalidateSelf();
        hkVar.v();
    }

    public void setTextStartPaddingResource(int i) {
        hk hkVar = this.f;
        if (hkVar != null) {
            float dimension = hkVar.f0.getResources().getDimension(i);
            if (hkVar.a0 != dimension) {
                hkVar.a0 = dimension;
                hkVar.invalidateSelf();
                hkVar.v();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.N(z2);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z2) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.A(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.F(z2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            zy.f("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            zy.f("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            zy.f("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            zy.f("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(x41 x41Var) {
        hk hkVar = this.f;
        if (hkVar != null) {
            hkVar.l0.b(x41Var, hkVar.f0);
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        hk hkVar = this.f;
        if (hkVar != null) {
            Context context = hkVar.f0;
            hkVar.l0.b(new x41(context, i), context);
        }
        g();
    }

    public void setInternalOnCheckedChangeListener(dk0 dk0Var) {
    }
}
