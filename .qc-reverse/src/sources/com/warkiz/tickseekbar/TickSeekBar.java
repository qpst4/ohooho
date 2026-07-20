package com.warkiz.tickseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.quickcursor.R;
import com.quickcursor.android.preferences.TickSeekBarPreference;
import defpackage.ay0;
import defpackage.fo0;
import defpackage.fp1;
import defpackage.i1;
import defpackage.nc;
import defpackage.os0;
import defpackage.vy0;
import defpackage.yb0;
import defpackage.zy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TickSeekBar extends View {
    public final int A;
    public String[] B;
    public float[] C;
    public float[] D;
    public float E;
    public final int F;
    public final Typeface G;
    public int H;
    public int I;
    public int J;
    public int K;
    public CharSequence[] L;
    public float[] M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public Bitmap R;
    public Bitmap S;
    public Drawable T;
    public final int U;
    public final boolean V;
    public final boolean W;
    public final int a0;
    public final Context b;
    public final boolean b0;
    public final Paint c;
    public final RectF c0;
    public final TextPaint d;
    public final RectF d0;
    public fo0 e;
    public final int e0;
    public final Rect f;
    public final int f0;
    public float g;
    public final int g0;
    public float h;
    public final int h0;
    public float i;
    public float i0;
    public int j;
    public float j0;
    public int k;
    public Bitmap k0;
    public int l;
    public int l0;
    public int m;
    public final int m0;
    public float n;
    public Drawable n0;
    public float o;
    public Bitmap o0;
    public boolean p;
    public int p0;
    public float q;
    public final int q0;
    public float r;
    public float r0;
    public float s;
    public final int s0;
    public final boolean t;
    public final boolean t0;
    public final boolean u;
    public vy0 u0;
    public final boolean v;
    public int v0;
    public final boolean w;
    public boolean w0;
    public float[] x;
    public boolean y;
    public final int z;

    public TickSeekBar(Context context, AttributeSet attributeSet) {
        Context context2;
        super(context, attributeSet, 0);
        this.i = -1.0f;
        this.v0 = 1;
        this.b = context;
        int color = Color.parseColor("#D7D7D7");
        int color2 = Color.parseColor("#FF4081");
        int color3 = Color.parseColor("#FF4081");
        int color4 = Color.parseColor("#FF4081");
        int color5 = Color.parseColor("#FF4081");
        Typeface typeface = Typeface.DEFAULT;
        int color6 = Color.parseColor("#FF4081");
        int iO = i1.o(context, 2.0f);
        int iO2 = i1.o(context, 2.0f);
        int iO3 = i1.o(context, 10.0f);
        int i = (int) ((13.0f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        int iO4 = i1.o(context, 14.0f);
        if (attributeSet == null) {
            this.q = 100.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = false;
            this.w = false;
            this.y = false;
            this.u = true;
            this.t0 = false;
            this.v = false;
            this.e0 = iO;
            this.g0 = color;
            this.f0 = iO2;
            this.h0 = color2;
            this.b0 = false;
            this.m0 = iO4;
            this.n0 = null;
            this.s0 = color3;
            n(color4, null);
            this.q0 = 0;
            this.N = 0;
            this.U = 0;
            this.a0 = iO3;
            this.T = null;
            this.V = false;
            this.W = false;
            p(color6, null);
            this.z = 0;
            this.F = i;
            this.L = null;
            this.G = typeface;
            q(color5, null);
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, os0.a);
            this.q = typedArrayObtainStyledAttributes.getFloat(1, 100.0f);
            this.r = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
            this.s = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
            this.t = typedArrayObtainStyledAttributes.getBoolean(5, false);
            this.u = typedArrayObtainStyledAttributes.getBoolean(31, true);
            this.t0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.v = typedArrayObtainStyledAttributes.getBoolean(3, false);
            this.w = typedArrayObtainStyledAttributes.getBoolean(7, false);
            this.y = typedArrayObtainStyledAttributes.getBoolean(6, false);
            this.e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(27, iO);
            this.f0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(29, iO2);
            this.g0 = typedArrayObtainStyledAttributes.getColor(26, color);
            this.h0 = typedArrayObtainStyledAttributes.getColor(28, color2);
            this.b0 = typedArrayObtainStyledAttributes.getBoolean(30, false);
            this.m0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, iO4);
            this.n0 = typedArrayObtainStyledAttributes.getDrawable(13);
            n(color4, typedArrayObtainStyledAttributes.getColorStateList(12));
            this.w0 = typedArrayObtainStyledAttributes.getBoolean(11, true);
            this.q0 = typedArrayObtainStyledAttributes.getInt(8, 0);
            this.s0 = typedArrayObtainStyledAttributes.getColor(15, color3);
            this.N = typedArrayObtainStyledAttributes.getInt(25, 0);
            this.U = typedArrayObtainStyledAttributes.getInt(9, 0);
            this.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, iO3);
            p(color6, typedArrayObtainStyledAttributes.getColorStateList(16));
            this.T = typedArrayObtainStyledAttributes.getDrawable(17);
            this.W = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.V = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.z = typedArrayObtainStyledAttributes.getInt(10, 0);
            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(23, i);
            q(color5, typedArrayObtainStyledAttributes.getColorStateList(22));
            this.L = typedArrayObtainStyledAttributes.getTextArray(21);
            int i2 = typedArrayObtainStyledAttributes.getInt(24, -1);
            if (i2 == 0) {
                this.G = typeface;
            } else if (i2 == 1) {
                this.G = Typeface.MONOSPACE;
            } else if (i2 == 2) {
                this.G = Typeface.SANS_SERIF;
            } else if (i2 == 3) {
                this.G = Typeface.SERIF;
            } else if (typeface == null) {
                this.G = typeface;
            } else {
                this.G = typeface;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        int i3 = this.N;
        if (i3 < 0 || i3 > 50) {
            ay0.d("the Argument: TICK COUNT must be limited between 0-50, Now is ", this.N);
            throw null;
        }
        j();
        int i4 = this.e0;
        int i5 = this.f0;
        if (i4 > i5) {
            this.e0 = i5;
        }
        if (this.n0 == null) {
            float f = this.m0 / 2.0f;
            this.i0 = f;
            this.j0 = f * 1.2f;
            context2 = context;
        } else {
            context2 = context;
            float fMin = Math.min(i1.o(context2, 30.0f), this.m0) / 2.0f;
            this.i0 = fMin;
            this.j0 = fMin;
        }
        if (this.T == null) {
            this.Q = this.a0 / 2.0f;
        } else {
            this.Q = Math.min(i1.o(context2, 30.0f), this.a0) / 2.0f;
        }
        this.g = Math.max(this.j0, this.Q) * 2.0f;
        if (this.c == null) {
            this.c = new Paint();
        }
        if (this.b0) {
            this.c.setStrokeCap(Paint.Cap.ROUND);
        }
        this.c.setAntiAlias(true);
        int i6 = this.e0;
        if (i6 > this.f0) {
            this.f0 = i6;
        }
        if ((this.z != 0 && this.N != 0) || this.q0 != 0) {
            if (this.d == null) {
                TextPaint textPaint = new TextPaint();
                this.d = textPaint;
                textPaint.setAntiAlias(true);
                this.d.setTextAlign(Paint.Align.CENTER);
                this.d.setTextSize(this.F);
            }
            if (this.f == null) {
                this.f = new Rect();
            }
            this.d.setTypeface(this.G);
            this.d.getTextBounds("j", 0, 1, this.f);
            this.A = i1.o(context2, 3.0f) + this.f.height();
        }
        this.h = this.s;
        b();
        this.c0 = new RectF();
        this.d0 = new RectF();
        if (this.t0) {
            return;
        }
        int iO5 = i1.o(context2, 16.0f);
        if (getPaddingLeft() == 0) {
            super.setPadding(iO5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            super.setPadding(getPaddingLeft(), getPaddingTop(), iO5, getPaddingBottom());
        }
    }

    private int getClosestIndex() {
        float fAbs = Math.abs(this.q - this.r);
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.x;
            if (i >= fArr.length) {
                return i2;
            }
            float fAbs2 = Math.abs(fArr[i] - this.s);
            if (fAbs2 <= fAbs) {
                i2 = i;
                fAbs = fAbs2;
            }
            i++;
        }
    }

    private int getLeftSideTickColor() {
        return this.y ? this.O : this.P;
    }

    private int getLeftSideTickTextsColor() {
        return this.y ? this.H : this.I;
    }

    private int getLeftSideTrackSize() {
        return this.y ? this.e0 : this.f0;
    }

    private int getRightSideTickColor() {
        return this.y ? this.P : this.O;
    }

    private int getRightSideTickTextsColor() {
        return this.H;
    }

    private int getRightSideTrackSize() {
        return this.y ? this.f0 : this.e0;
    }

    private float getThumbCenterX() {
        return this.y ? this.d0.right : this.c0.right;
    }

    private int getThumbPosOnTick() {
        if (this.N != 0) {
            return Math.round((getThumbCenterX() - this.j) / this.o);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.N != 0) {
            return (getThumbCenterX() - this.j) / this.o;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        String[] strArr;
        if (this.e == null) {
            return;
        }
        float f = this.h;
        if (this.t) {
            if (f == this.s) {
                return;
            }
        } else if (Math.round(f) == Math.round(this.s)) {
            return;
        }
        fo0 fo0Var = this.e;
        if (this.u0 == null) {
            this.u0 = new vy0();
        }
        this.u0.a = getProgress();
        vy0 vy0Var = this.u0;
        getProgressFloat();
        vy0Var.getClass();
        this.u0.getClass();
        if (this.N > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.z != 0 && (strArr = this.B) != null) {
                vy0 vy0Var2 = this.u0;
                String str = strArr[thumbPosOnTick];
                vy0Var2.getClass();
            }
            boolean z2 = this.y;
            vy0 vy0Var3 = this.u0;
            if (z2) {
                vy0Var3.getClass();
            } else {
                vy0Var3.getClass();
            }
        }
        vy0 vy0Var4 = this.u0;
        TickSeekBarPreference tickSeekBarPreference = (TickSeekBarPreference) fo0Var;
        if (tickSeekBarPreference.O && tickSeekBarPreference.a(Integer.valueOf(vy0Var4.a))) {
            int i = vy0Var4.a;
            tickSeekBarPreference.T = i;
            if (tickSeekBarPreference.H()) {
                tickSeekBarPreference.y(i);
            }
            try {
                tickSeekBarPreference.k();
            } catch (IllegalStateException unused) {
                yb0.A(R.string.general_error_toast);
            }
        }
    }

    public final void b() {
        int i = this.N;
        if (i < 0 || i > 50) {
            ay0.d("the Argument: TICK COUNT must be limited between (0-50), Now is ", this.N);
            return;
        }
        if (i == 0) {
            return;
        }
        this.M = new float[i];
        if (this.z != 0) {
            this.D = new float[i];
            this.C = new float[i];
        }
        this.x = new float[i];
        int i2 = 0;
        while (true) {
            float[] fArr = this.x;
            if (i2 >= fArr.length) {
                return;
            }
            float f = this.r;
            fArr[i2] = (((this.q - f) * i2) / (this.N + (-1) > 0 ? r3 - 1 : 1)) + f;
            i2++;
        }
    }

    public final void c(Canvas canvas) {
        float thumbCenterX = getThumbCenterX();
        Drawable drawable = this.n0;
        RectF rectF = this.c0;
        Paint paint = this.c;
        if (drawable == null) {
            if (this.p) {
                paint.setColor(this.p0);
            } else {
                paint.setColor(this.l0);
            }
            canvas.drawCircle(thumbCenterX, rectF.top, this.p ? this.j0 : this.i0, paint);
            return;
        }
        if (this.k0 == null || this.o0 == null) {
            m();
        }
        if (this.k0 == null || this.o0 == null) {
            zy.n("the format of the selector thumb drawable is wrong!");
            return;
        }
        paint.setAlpha(255);
        if (this.p) {
            canvas.drawBitmap(this.o0, thumbCenterX - (r1.getWidth() / 2.0f), rectF.top - (this.o0.getHeight() / 2.0f), paint);
        } else {
            canvas.drawBitmap(this.k0, thumbCenterX - (r1.getWidth() / 2.0f), rectF.top - (this.k0.getHeight() / 2.0f), paint);
        }
    }

    public final void d(Canvas canvas) {
        Bitmap bitmap;
        if (this.N != 0) {
            int i = this.U;
            if (i == 0 && this.T == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i2 = 0; i2 < this.M.length; i2++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.W || thumbCenterX < this.M[i2]) && ((!this.V || (i2 != 0 && i2 != this.M.length - 1)) && (i2 != getThumbPosOnTick() || this.N <= 2 || this.w))) {
                    float f = i2;
                    Paint paint = this.c;
                    if (f <= thumbPosOnTickFloat) {
                        paint.setColor(getLeftSideTickColor());
                    } else {
                        paint.setColor(getRightSideTickColor());
                    }
                    Drawable drawable = this.T;
                    RectF rectF = this.c0;
                    if (drawable != null) {
                        if (this.S == null || this.R == null) {
                            o();
                        }
                        Bitmap bitmap2 = this.S;
                        if (bitmap2 == null || (bitmap = this.R) == null) {
                            zy.n("the format of the selector TickMarks drawable is wrong!");
                            return;
                        }
                        float[] fArr = this.M;
                        if (f <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, fArr[i2] - (bitmap.getWidth() / 2.0f), rectF.top - (this.R.getHeight() / 2.0f), paint);
                        } else {
                            canvas.drawBitmap(bitmap, fArr[i2] - (bitmap.getWidth() / 2.0f), rectF.top - (this.R.getHeight() / 2.0f), paint);
                        }
                    } else if (i == 1) {
                        canvas.drawCircle(this.M[i2], rectF.top, this.Q, paint);
                    } else if (i == 3) {
                        int iO = i1.o(this.b, 1.0f);
                        float leftSideTrackSize = thumbCenterX >= this.M[i2] ? getLeftSideTrackSize() : getRightSideTrackSize();
                        float f2 = this.M[i2];
                        float f3 = iO;
                        float f4 = rectF.top;
                        float f5 = leftSideTrackSize / 2.0f;
                        canvas.drawRect(f2 - f3, f4 - f5, f2 + f3, f4 + f5, this.c);
                    } else if (i == 2) {
                        float f6 = this.M[i2];
                        float f7 = this.a0 / 2.0f;
                        float f8 = rectF.top;
                        canvas.drawRect(f6 - f7, f8 - f7, f6 + f7, f7 + f8, this.c);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(Canvas canvas) {
        if (this.B == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        for (int i = 0; i < this.B.length; i++) {
            int thumbPosOnTick = getThumbPosOnTick();
            TextPaint textPaint = this.d;
            if (i == thumbPosOnTick) {
                textPaint.setColor(this.J);
            } else if (i < thumbPosOnTickFloat) {
                textPaint.setColor(getLeftSideTickTextsColor());
            } else {
                textPaint.setColor(getRightSideTickTextsColor());
            }
            int length = this.y ? (this.B.length - 1) - i : i;
            String[] strArr = this.B;
            if (i == 0) {
                canvas.drawText(strArr[length], (this.C[length] / 2.0f) + this.D[i], this.E, textPaint);
            } else if (i == strArr.length - 1) {
                canvas.drawText(strArr[length], this.D[i] - (this.C[length] / 2.0f), this.E, textPaint);
            } else {
                canvas.drawText(strArr[length], this.D[i], this.E, textPaint);
            }
        }
    }

    public final void f(Canvas canvas) {
        int i = this.h0;
        Paint paint = this.c;
        paint.setColor(i);
        paint.setStrokeWidth(this.f0);
        RectF rectF = this.c0;
        canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.c);
        paint.setColor(this.g0);
        paint.setStrokeWidth(this.e0);
        RectF rectF2 = this.d0;
        canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.c);
    }

    public final Bitmap g(Drawable drawable, boolean z) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int iO = i1.o(this.b, 30.0f);
        if (drawable.getIntrinsicWidth() > iO) {
            int i = z ? this.m0 : this.a0;
            intrinsicHeight = Math.round(((i * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            if (i > iO) {
                intrinsicHeight = Math.round(((iO * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            } else {
                iO = i;
            }
        } else {
            iO = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iO, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public float getMax() {
        return this.q;
    }

    public float getMin() {
        return this.r;
    }

    public fo0 getOnSeekChangeListener() {
        return this.e;
    }

    public int getProgress() {
        return Math.round(this.s);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.s).setScale(this.v0, 4).floatValue();
    }

    public int getTickCount() {
        return this.N;
    }

    public synchronized float getTouchX() {
        u(this.s);
        if (this.y) {
            return this.d0.right;
        }
        return this.c0.right;
    }

    public final String h(float f) {
        char[] cArr;
        if (!this.t) {
            return String.valueOf(Math.round(f));
        }
        double d = f;
        int iAbs = Math.abs(this.v0);
        double dPow = (Math.pow(10.0d, iAbs) * Math.abs(d)) + 0.5d;
        if (dPow > 9.99999999999999E14d || iAbs > 16) {
            String string = new BigDecimal(Double.toString(d)).setScale(Math.abs(iAbs), RoundingMode.HALF_UP).toString();
            if (iAbs == 0) {
                return string;
            }
            int length = string.length() - 1;
            while (length >= 0 && string.charAt(length) == '0') {
                length--;
            }
            String strSubstring = string.substring(0, length + 1);
            return strSubstring.charAt(strSubstring.length() + (-1)) == '.' ? strSubstring.substring(0, strSubstring.length() - 1) : strSubstring;
        }
        long jNextUp = (long) Math.nextUp(dPow);
        if (jNextUp < 1) {
            return "0";
        }
        char[] charArray = Long.toString(jNextUp).toCharArray();
        if (charArray.length > iAbs) {
            int length2 = charArray.length - 1;
            int length3 = charArray.length - iAbs;
            while (length2 >= length3 && charArray[length2] == '0') {
                length2--;
            }
            if (length2 >= length3) {
                cArr = new char[length2 + 2];
                System.arraycopy(charArray, 0, cArr, 0, length3);
                cArr[length3] = '.';
                System.arraycopy(charArray, length3, cArr, length3 + 1, (length2 - length3) + 1);
            } else {
                cArr = new char[length3];
                System.arraycopy(charArray, 0, cArr, 0, length3);
            }
        } else {
            int length4 = charArray.length - 1;
            while (length4 >= 0 && charArray[length4] == '0') {
                length4--;
            }
            char[] cArr2 = fp1.b[iAbs - charArray.length];
            char[] cArrCopyOf = Arrays.copyOf(cArr2, cArr2.length + length4 + 1);
            System.arraycopy(charArray, 0, cArrCopyOf, cArr2.length, length4 + 1);
            cArr = cArrCopyOf;
        }
        return Math.signum(d) > 0.0d ? new String(cArr) : "-".concat(new String(cArr));
    }

    public final boolean i() {
        return (this.N != 0 && this.z == 2) || this.q0 == 2;
    }

    public final void j() {
        float f = this.q;
        float f2 = this.r;
        if (f < f2) {
            zy.n("the Argument: MAX's value must be larger than MIN's.");
            return;
        }
        if (this.s < f2) {
            this.s = f2;
        }
        if (this.s > f) {
            this.s = f;
        }
    }

    public final void k() {
        this.l = getMeasuredWidth();
        this.j = getPaddingStart();
        this.k = getPaddingEnd();
        this.m = getPaddingTop();
        float f = (this.l - this.j) - this.k;
        this.n = f;
        this.o = f / (this.N + (-1) > 0 ? r1 - 1 : 1);
    }

    public final void l() {
        if (this.M == null) {
            return;
        }
        int i = this.z;
        if (i != 0) {
            this.B = new String[this.N];
        }
        int i2 = 0;
        while (i2 < this.M.length) {
            if (i != 0) {
                String[] strArr = this.B;
                CharSequence[] charSequenceArr = this.L;
                strArr[i2] = charSequenceArr == null ? h(this.x[i2]) : i2 < charSequenceArr.length ? String.valueOf(charSequenceArr[i2]) : "";
                String str = this.B[i2];
                int length = str.length();
                this.d.getTextBounds(str, 0, length, this.f);
                this.C[i2] = r6.width();
                this.D[i2] = (this.o * i2) + this.j;
            }
            this.M[i2] = (this.o * i2) + this.j;
            i2++;
        }
    }

    public final void m() {
        Drawable drawable = this.n0;
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap bitmapG = g(drawable, true);
            this.k0 = bitmapG;
            this.o0 = bitmapG;
            return;
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i = 0; i < iIntValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.k0 = g((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                } else {
                    if (iArr[0] != 16842919) {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    this.o0 = g((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                }
            }
        } catch (Exception unused) {
            Bitmap bitmapG2 = g(this.n0, true);
            this.k0 = bitmapG2;
            this.o0 = bitmapG2;
        }
    }

    public final void n(int i, ColorStateList colorStateList) {
        if (colorStateList == null) {
            this.l0 = i;
            this.p0 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.l0 = i2;
                this.p0 = i2;
            } else {
                if (iArr.length != 2) {
                    zy.n("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                    return;
                }
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.p0 = iArr2[i3];
                    } else {
                        if (iArr3[0] != 16842919) {
                            zy.n("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                            return;
                        }
                        this.l0 = iArr2[i3];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public final void o() {
        Drawable drawable = this.T;
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap bitmapG = g(drawable, false);
            this.R = bitmapG;
            this.S = bitmapG;
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        try {
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i = 0; i < iIntValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.R = g((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                } else {
                    if (iArr[0] != 16842913) {
                        throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                    }
                    this.S = g((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                }
            }
        } catch (Exception unused) {
            Bitmap bitmapG2 = g(this.T, false);
            this.R = bitmapG2;
            this.S = bitmapG2;
        }
    }

    @Override // android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        f(canvas);
        d(canvas);
        e(canvas);
        c(canvas);
        int i = this.q0;
        if (i != 0 && this.z != i) {
            this.d.setColor(this.s0);
            canvas.drawText(h(this.s), getThumbCenterX(), this.r0, this.d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iRound = Math.round(this.g + getPaddingTop() + getPaddingBottom());
        boolean zR = r();
        Context context = this.b;
        if (zR) {
            setMeasuredDimension(View.resolveSize(i1.o(context, 170.0f), i), (this.A * 2) + iRound);
        } else {
            setMeasuredDimension(View.resolveSize(i1.o(context, 170.0f), i), iRound + this.A);
        }
        k();
        t();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        float f = bundle.getFloat("tsb_progress");
        this.s = f;
        setProgress(f);
        super.onRestoreInstanceState(bundle.getParcelable("tsb_instance_state"));
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tsb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("tsb_progress", this.s);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new nc(17, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fe, code lost:
    
        if (r0 <= (r4 + r3)) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.tickseekbar.TickSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, ColorStateList colorStateList) {
        if (colorStateList == null) {
            this.P = i;
            this.O = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.P = i2;
                this.O = i2;
            } else {
                if (iArr.length != 2) {
                    zy.n("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                    return;
                }
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.O = iArr2[i3];
                    } else {
                        if (iArr3[0] != 16842913) {
                            zy.n("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                            return;
                        }
                        this.P = iArr2[i3];
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e.getMessage());
        }
    }

    public final void q(int i, ColorStateList colorStateList) {
        if (colorStateList == null) {
            this.H = i;
            this.I = i;
            this.J = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.H = i2;
                this.I = i2;
                this.J = i2;
                return;
            }
            if (iArr.length != 3) {
                zy.n("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                return;
            }
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int[] iArr3 = iArr[i3];
                if (iArr3.length == 0) {
                    this.H = iArr2[i3];
                } else {
                    int i4 = iArr3[0];
                    if (i4 == 16842913) {
                        this.I = iArr2[i3];
                    } else {
                        if (i4 != 16843623) {
                            zy.n("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                            return;
                        }
                        this.J = iArr2[i3];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public final boolean r() {
        int i = this.N;
        return (i != 0 && this.z == 2 && this.q0 == 1) || (i != 0 && this.z == 1 && this.q0 == 2);
    }

    public final void s(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float fRound = this.j;
        if (x >= fRound) {
            float x2 = motionEvent.getX();
            fRound = this.l - this.k;
            if (x2 <= fRound) {
                fRound = motionEvent.getX();
            }
        }
        if (this.N > 2 && !this.w) {
            fRound = (this.o * Math.round((fRound - this.j) / this.o)) + this.j;
        }
        if (this.y) {
            fRound = (this.n - fRound) + (this.j * 2);
        }
        this.h = this.s;
        float f = this.r;
        float f2 = (((fRound - this.j) * (this.q - f)) / this.n) + f;
        this.s = f2;
        u(f2);
        setSeekListener(true);
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.v0 = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        if (isEnabled()) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.3f);
        }
    }

    public synchronized void setMax(float f) {
        this.q = Math.max(this.r, f);
        j();
        t();
        invalidate();
    }

    public synchronized void setMin(float f) {
        this.r = Math.min(this.q, f);
        j();
        t();
        invalidate();
    }

    public void setOnSeekChangeListener(fo0 fo0Var) {
        this.e = fo0Var;
    }

    public synchronized void setProgress(float f) {
        try {
            this.h = this.s;
            float f2 = this.r;
            if (f < f2) {
                f = f2;
            } else {
                f2 = this.q;
                if (f > f2) {
                    f = f2;
                }
            }
            this.s = f;
            if (this.N > 2) {
                this.s = this.x[getClosestIndex()];
            }
            setSeekListener(false);
            u(this.s);
            postInvalidate();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setR2L(boolean z) {
        this.y = z;
        requestLayout();
        invalidate();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.w0 = z;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.n0 = drawable;
        float fMin = Math.min(i1.o(this.b, 30.0f), this.m0) / 2.0f;
        this.i0 = fMin;
        this.j0 = fMin;
        this.g = Math.max(fMin, this.Q) * 2.0f;
        m();
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i) {
        int i2 = this.N;
        if (i2 < 0 || i2 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.N);
        }
        this.N = i;
        b();
        l();
        k();
        t();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        this.T = drawable;
        float fMin = Math.min(i1.o(this.b, 30.0f), this.a0) / 2.0f;
        this.Q = fMin;
        this.g = Math.max(this.j0, fMin) * 2.0f;
        o();
        invalidate();
    }

    public final void t() {
        boolean z = this.y;
        RectF rectF = this.c0;
        RectF rectF2 = this.d0;
        Context context = this.b;
        if (z) {
            rectF2.left = this.j;
            boolean zI = i();
            int i = this.m;
            float f = this.j0;
            if (zI) {
                rectF2.top = i + f + this.K + i1.o(context, 3.0f);
            } else {
                rectF2.top = i + f;
            }
            float f2 = this.j;
            float f3 = this.n;
            float f4 = this.s;
            float f5 = this.r;
            float f6 = ((1.0f - ((f4 - f5) / (this.q - f5))) * f3) + f2;
            rectF2.right = f6;
            float f7 = rectF2.top;
            rectF2.bottom = f7;
            rectF.left = f6;
            rectF.top = f7;
            rectF.right = this.l - this.k;
            rectF.bottom = f7;
        } else {
            rectF.left = this.j;
            boolean zI2 = i();
            int i2 = this.m;
            float f8 = this.j0;
            if (zI2) {
                rectF.top = i2 + f8 + this.K + i1.o(context, 3.0f);
            } else {
                rectF.top = i2 + f8;
            }
            float f9 = this.s;
            float f10 = this.r;
            float f11 = (((f9 - f10) * this.n) / (this.q - f10)) + this.j;
            rectF.right = f11;
            float f12 = rectF.top;
            rectF.bottom = f12;
            rectF2.left = f11;
            rectF2.top = f12;
            rectF2.right = this.l - this.k;
            rectF2.bottom = f12;
        }
        int i3 = this.q0;
        int i4 = this.z;
        if ((i4 != 0 && this.N != 0) || i3 != 0) {
            TextPaint textPaint = this.d;
            Rect rect = this.f;
            textPaint.getTextBounds("j", 0, 1, rect);
            this.K = rect.height();
            if (r()) {
                int i5 = this.m;
                int i6 = this.K;
                int i7 = this.A;
                if (i4 == 1) {
                    this.r0 = i1.o(context, 3.0f) + Math.round(i6 - textPaint.descent()) + i5;
                    this.E = i7 + this.m + this.g + Math.round(this.K - textPaint.descent()) + i1.o(context, 3.0f);
                } else {
                    this.E = i1.o(context, 3.0f) + Math.round(i6 - textPaint.descent()) + i5;
                    this.r0 = i7 + this.m + this.g + Math.round(this.K - textPaint.descent()) + i1.o(context, 3.0f);
                }
            } else {
                if ((this.N != 0 && i4 == 1) || i3 == 1) {
                    this.E = this.m + this.g + Math.round(this.K - textPaint.descent()) + i1.o(context, 3.0f);
                } else if (i()) {
                    this.E = i1.o(context, 3.0f) + Math.round(this.K - textPaint.descent()) + this.m;
                }
                this.r0 = this.E;
            }
        }
        if (this.M == null) {
            return;
        }
        l();
        if (this.N > 2) {
            float f13 = this.x[getClosestIndex()];
            this.s = f13;
            this.h = f13;
        }
        u(this.s);
    }

    public final void u(float f) {
        if (!this.y) {
            float f2 = this.r;
            float f3 = (((f - f2) * this.n) / (this.q - f2)) + this.j;
            this.c0.right = f3;
            this.d0.left = f3;
            return;
        }
        float f4 = this.j;
        float f5 = this.n;
        float f6 = this.r;
        float f7 = ((1.0f - ((f - f6) / (this.q - f6))) * f5) + f4;
        this.d0.right = f7;
        this.c0.left = f7;
    }
}
