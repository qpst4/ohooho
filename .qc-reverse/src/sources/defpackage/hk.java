package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hk extends ik0 implements Drawable.Callback, z41 {
    public static final int[] G0 = {R.attr.state_enabled};
    public static final ShapeDrawable H0 = new ShapeDrawable(new OvalShape());
    public float A;
    public ColorStateList A0;
    public float B;
    public WeakReference B0;
    public ColorStateList C;
    public TextUtils.TruncateAt C0;
    public float D;
    public boolean D0;
    public ColorStateList E;
    public int E0;
    public CharSequence F;
    public boolean F0;
    public boolean G;
    public Drawable H;
    public ColorStateList I;
    public float J;
    public boolean K;
    public boolean L;
    public Drawable M;
    public RippleDrawable N;
    public ColorStateList O;
    public float P;
    public SpannableStringBuilder Q;
    public boolean R;
    public boolean S;
    public Drawable T;
    public ColorStateList U;
    public bm0 V;
    public bm0 W;
    public float X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public final Context f0;
    public final Paint g0;
    public final Paint.FontMetrics h0;
    public final RectF i0;
    public final PointF j0;
    public final Path k0;
    public final a51 l0;
    public int m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public boolean s0;
    public int t0;
    public int u0;
    public ColorFilter v0;
    public PorterDuffColorFilter w0;
    public ColorStateList x0;
    public ColorStateList y;
    public PorterDuff.Mode y0;
    public ColorStateList z;
    public int[] z0;

    public hk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.quickcursor.R.attr.chipStyle, com.quickcursor.R.style.Widget_MaterialComponents_Chip_Action);
        this.B = -1.0f;
        this.g0 = new Paint(1);
        this.h0 = new Paint.FontMetrics();
        this.i0 = new RectF();
        this.j0 = new PointF();
        this.k0 = new Path();
        this.u0 = 255;
        this.y0 = PorterDuff.Mode.SRC_IN;
        this.B0 = new WeakReference(null);
        i(context);
        this.f0 = context;
        a51 a51Var = new a51(this);
        this.l0 = a51Var;
        this.F = "";
        a51Var.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = G0;
        setState(iArr);
        if (!Arrays.equals(this.z0, iArr)) {
            this.z0 = iArr;
            if (T()) {
                w(getState(), iArr);
            }
        }
        this.D0 = true;
        int[] iArr2 = nw0.a;
        H0.setTint(-1);
    }

    public static void U(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean t(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean u(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z) {
        if (this.S != z) {
            boolean zR = R();
            this.S = z;
            boolean zR2 = R();
            if (zR != zR2) {
                Drawable drawable = this.T;
                if (zR2) {
                    o(drawable);
                } else {
                    U(drawable);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void B(float f) {
        if (this.B != f) {
            this.B = f;
            lz0 lz0VarF = this.b.a.f();
            lz0VarF.e = new h(f);
            lz0VarF.f = new h(f);
            lz0VarF.g = new h(f);
            lz0VarF.h = new h(f);
            setShapeAppearanceModel(lz0VarF.a());
        }
    }

    public final void C(Drawable drawable) {
        Drawable drawable2 = this.H;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fQ = q();
            this.H = drawable != null ? drawable.mutate() : null;
            float fQ2 = q();
            U(drawable2);
            if (S()) {
                o(this.H);
            }
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void D(float f) {
        if (this.J != f) {
            float fQ = q();
            this.J = f;
            float fQ2 = q();
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        this.K = true;
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (S()) {
                this.H.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z) {
        if (this.G != z) {
            boolean zS = S();
            this.G = z;
            boolean zS2 = S();
            if (zS != zS2) {
                Drawable drawable = this.H;
                if (zS2) {
                    o(drawable);
                } else {
                    U(drawable);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void G(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (this.F0) {
                hk0 hk0Var = this.b;
                if (hk0Var.d != colorStateList) {
                    hk0Var.d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void H(float f) {
        if (this.D != f) {
            this.D = f;
            this.g0.setStrokeWidth(f);
            if (this.F0) {
                this.b.j = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void I(Drawable drawable) {
        Drawable drawable2 = this.M;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fR = r();
            this.M = drawable != null ? drawable.mutate() : null;
            int[] iArr = nw0.a;
            this.N = new RippleDrawable(nw0.c(this.E), this.M, H0);
            float fR2 = r();
            U(drawable2);
            if (T()) {
                o(this.M);
            }
            invalidateSelf();
            if (fR != fR2) {
                v();
            }
        }
    }

    public final void J(float f) {
        if (this.d0 != f) {
            this.d0 = f;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void K(float f) {
        if (this.P != f) {
            this.P = f;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void L(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void M(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (T()) {
                this.M.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void N(boolean z) {
        if (this.L != z) {
            boolean zT = T();
            this.L = z;
            boolean zT2 = T();
            if (zT != zT2) {
                Drawable drawable = this.M;
                if (zT2) {
                    o(drawable);
                } else {
                    U(drawable);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void O(float f) {
        if (this.Z != f) {
            float fQ = q();
            this.Z = f;
            float fQ2 = q();
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void P(float f) {
        if (this.Y != f) {
            float fQ = q();
            this.Y = f;
            float fQ2 = q();
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            this.A0 = null;
            onStateChange(getState());
        }
    }

    public final boolean R() {
        return this.S && this.T != null && this.s0;
    }

    public final boolean S() {
        return this.G && this.H != null;
    }

    public final boolean T() {
        return this.L && this.M != null;
    }

    @Override // defpackage.z41
    public final void a() {
        v();
        invalidateSelf();
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f;
        int i2;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.u0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.F0;
        Paint paint = this.g0;
        RectF rectF = this.i0;
        if (!z) {
            paint.setColor(this.m0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, s(), s(), paint);
        }
        if (!this.F0) {
            paint.setColor(this.n0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.v0;
            if (colorFilter == null) {
                colorFilter = this.w0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, s(), s(), paint);
        }
        if (this.F0) {
            super.draw(canvas);
        }
        if (this.D > 0.0f && !this.F0) {
            paint.setColor(this.p0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.F0) {
                ColorFilter colorFilter2 = this.v0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.w0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f2 = bounds.left;
            float f3 = this.D / 2.0f;
            rectF.set(f2 + f3, bounds.top + f3, bounds.right - f3, bounds.bottom - f3);
            float f4 = this.B - (this.D / 2.0f);
            canvas2.drawRoundRect(rectF, f4, f4, paint);
        }
        paint.setColor(this.q0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.F0) {
            RectF rectF2 = new RectF(bounds);
            hk0 hk0Var = this.b;
            mz0 mz0Var = hk0Var.a;
            float f5 = hk0Var.i;
            tb0 tb0Var = this.r;
            oz0 oz0Var = this.s;
            Path path = this.k0;
            oz0Var.a(mz0Var, f5, rectF2, tb0Var, path);
            e(canvas2, paint, path, this.b.a, g());
        } else {
            canvas2.drawRoundRect(rectF, s(), s(), paint);
        }
        if (S()) {
            p(bounds, rectF);
            float f6 = rectF.left;
            float f7 = rectF.top;
            canvas2.translate(f6, f7);
            this.H.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.H.draw(canvas2);
            canvas2.translate(-f6, -f7);
        }
        if (R()) {
            p(bounds, rectF);
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas2.translate(f8, f9);
            this.T.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.T.draw(canvas2);
            canvas2.translate(-f8, -f9);
        }
        if (this.D0 && this.F != null) {
            PointF pointF = this.j0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.F;
            a51 a51Var = this.l0;
            if (charSequence != null) {
                float fQ = q() + this.X + this.a0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fQ;
                } else {
                    pointF.x = bounds.right - fQ;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = a51Var.a;
                Paint.FontMetrics fontMetrics = this.h0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.F != null) {
                float fQ2 = q() + this.X + this.a0;
                float fR = r() + this.e0 + this.b0;
                int layoutDirection = getLayoutDirection();
                int i3 = bounds.left;
                if (layoutDirection == 0) {
                    rectF.left = i3 + fQ2;
                    rectF.right = bounds.right - fR;
                } else {
                    rectF.left = i3 + fR;
                    rectF.right = bounds.right - fQ2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            x41 x41Var = a51Var.g;
            TextPaint textPaint2 = a51Var.a;
            if (x41Var != null) {
                textPaint2.drawableState = getState();
                a51Var.g.e(this.f0, textPaint2, a51Var.b);
            }
            textPaint2.setTextAlign(align);
            String string = this.F.toString();
            if (a51Var.e) {
                a51Var.a(string);
                f = a51Var.c;
            } else {
                f = a51Var.c;
            }
            boolean z2 = Math.round(f) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i2 = iSave;
            } else {
                i2 = 0;
            }
            CharSequence charSequenceEllipsize = this.F;
            if (z2 && this.C0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.C0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i2);
            }
        }
        if (T()) {
            rectF.setEmpty();
            if (T()) {
                float f10 = this.e0 + this.d0;
                if (getLayoutDirection() == 0) {
                    float f11 = bounds.right - f10;
                    rectF.right = f11;
                    rectF.left = f11 - this.P;
                } else {
                    float f12 = bounds.left + f10;
                    rectF.left = f12;
                    rectF.right = f12 + this.P;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f13 = this.P;
                float f14 = fExactCenterY - (f13 / 2.0f);
                rectF.top = f14;
                rectF.bottom = f14 + f13;
            }
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas2.translate(f15, f16);
            this.M.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = nw0.a;
            this.N.setBounds(this.M.getBounds());
            this.N.jumpToCurrentState();
            this.N.draw(canvas2);
            canvas2.translate(-f15, -f16);
        }
        if (this.u0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.u0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.v0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float fQ = q() + this.X + this.a0;
        String string = this.F.toString();
        a51 a51Var = this.l0;
        if (a51Var.e) {
            a51Var.a(string);
        }
        return Math.min(Math.round(r() + a51Var.c + fQ + this.b0 + this.e0), this.E0);
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.F0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.A, this.B);
        } else {
            outline.setRoundRect(bounds, this.B);
            outline2 = outline;
        }
        outline2.setAlpha(this.u0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (t(this.y) || t(this.z) || t(this.C)) {
            return true;
        }
        x41 x41Var = this.l0.g;
        if (x41Var == null || (colorStateList = x41Var.j) == null || !colorStateList.isStateful()) {
            return (this.S && this.T != null && this.R) || u(this.H) || u(this.T) || t(this.x0);
        }
        return true;
    }

    public final void o(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.M) {
            if (drawable.isStateful()) {
                drawable.setState(this.z0);
            }
            drawable.setTintList(this.O);
            return;
        }
        Drawable drawable2 = this.H;
        if (drawable == drawable2 && this.K) {
            drawable2.setTintList(this.I);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (S()) {
            zOnLayoutDirectionChanged |= this.H.setLayoutDirection(i);
        }
        if (R()) {
            zOnLayoutDirectionChanged |= this.T.setLayoutDirection(i);
        }
        if (T()) {
            zOnLayoutDirectionChanged |= this.M.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (S()) {
            zOnLevelChange |= this.H.setLevel(i);
        }
        if (R()) {
            zOnLevelChange |= this.T.setLevel(i);
        }
        if (T()) {
            zOnLevelChange |= this.M.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable, defpackage.z41
    public final boolean onStateChange(int[] iArr) {
        if (this.F0) {
            super.onStateChange(iArr);
        }
        return w(iArr, this.z0);
    }

    public final void p(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (S() || R()) {
            float f = this.X + this.Y;
            Drawable drawable = this.s0 ? this.T : this.H;
            float intrinsicWidth = this.J;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + intrinsicWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - intrinsicWidth;
            }
            Drawable drawable2 = this.s0 ? this.T : this.H;
            float fCeil = this.J;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(i1.p(this.f0, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float q() {
        if (!S() && !R()) {
            return 0.0f;
        }
        float f = this.Y;
        Drawable drawable = this.s0 ? this.T : this.H;
        float intrinsicWidth = this.J;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.Z;
    }

    public final float r() {
        if (T()) {
            return this.c0 + this.P + this.d0;
        }
        return 0.0f;
    }

    public final float s() {
        return this.F0 ? this.b.a.e.a(g()) : this.B;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.u0 != i) {
            this.u0 = i;
            invalidateSelf();
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.v0 != colorFilter) {
            this.v0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.y0 != mode) {
            this.y0 = mode;
            ColorStateList colorStateList = this.x0;
            this.w0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (S()) {
            visible |= this.H.setVisible(z, z2);
        }
        if (R()) {
            visible |= this.T.setVisible(z, z2);
        }
        if (T()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v() {
        Chip chip = (Chip) this.B0.get();
        if (chip != null) {
            chip.b(chip.q);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    public final boolean w(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.y;
        int iC = c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.m0) : 0);
        boolean state = true;
        if (this.m0 != iC) {
            this.m0 = iC;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.z;
        int iC2 = c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.n0) : 0);
        if (this.n0 != iC2) {
            this.n0 = iC2;
            zOnStateChange = true;
        }
        int iD = wl.d(iC2, iC);
        if ((this.o0 != iD) | (this.b.c == null)) {
            this.o0 = iD;
            k(ColorStateList.valueOf(iD));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.C;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.p0) : 0;
        if (this.p0 != colorForState) {
            this.p0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.A0 == null || !nw0.d(iArr)) ? 0 : this.A0.getColorForState(iArr, this.q0);
        if (this.q0 != colorForState2) {
            this.q0 = colorForState2;
        }
        x41 x41Var = this.l0.g;
        int colorForState3 = (x41Var == null || (colorStateList = x41Var.j) == null) ? 0 : colorStateList.getColorForState(iArr, this.r0);
        if (this.r0 != colorForState3) {
            this.r0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z = false;
        } else {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (state2[i] != 16842912) {
                    i++;
                } else if (this.R) {
                    z = true;
                }
            }
            z = false;
        }
        if (this.s0 == z || this.T == null) {
            z2 = false;
        } else {
            float fQ = q();
            this.s0 = z;
            if (fQ != q()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.x0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.t0) : 0;
        if (this.t0 != colorForState4) {
            this.t0 = colorForState4;
            ColorStateList colorStateList6 = this.x0;
            PorterDuff.Mode mode = this.y0;
            this.w0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (u(this.H)) {
            state |= this.H.setState(iArr);
        }
        if (u(this.T)) {
            state |= this.T.setState(iArr);
        }
        if (u(this.M)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.M.setState(iArr3);
        }
        int[] iArr4 = nw0.a;
        if (u(this.N)) {
            state |= this.N.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            v();
        }
        return state;
    }

    public final void x(boolean z) {
        if (this.R != z) {
            this.R = z;
            float fQ = q();
            if (!z && this.s0) {
                this.s0 = false;
            }
            float fQ2 = q();
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void y(Drawable drawable) {
        if (this.T != drawable) {
            float fQ = q();
            this.T = drawable;
            float fQ2 = q();
            U(this.T);
            o(this.T);
            invalidateSelf();
            if (fQ != fQ2) {
                v();
            }
        }
    }

    public final void z(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (this.S && (drawable = this.T) != null && this.R) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }
}
