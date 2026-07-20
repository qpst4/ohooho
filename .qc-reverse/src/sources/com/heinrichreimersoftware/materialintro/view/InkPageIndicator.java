package com.heinrichreimersoftware.materialintro.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import defpackage.d10;
import defpackage.gb0;
import defpackage.hb0;
import defpackage.i1;
import defpackage.kb0;
import defpackage.kg1;
import defpackage.lb0;
import defpackage.ls0;
import defpackage.mg1;
import defpackage.wg;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class InkPageIndicator extends View implements kg1, View.OnAttachStateChangeListener {
    public static final /* synthetic */ int K = 0;
    public final Path A;
    public final Path B;
    public final Path C;
    public final RectF D;
    public kb0 E;
    public lb0[] F;
    public final Interpolator G;
    public float H;
    public float I;
    public boolean J;
    public final int b;
    public final int c;
    public final long d;
    public final float e;
    public final float f;
    public final long g;
    public float h;
    public float i;
    public float j;
    public mg1 k;
    public int l;
    public int m;
    public int n;
    public float o;
    public boolean p;
    public float[] q;
    public float[] r;
    public float s;
    public float t;
    public float[] u;
    public boolean v;
    public boolean w;
    public final Paint x;
    public final Paint y;
    public final Path z;

    public InkPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.l = 0;
        this.m = 0;
        this.J = false;
        int i = (int) context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ls0.a, 0, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, i * 8);
        this.b = dimensionPixelSize;
        float f = dimensionPixelSize / 2;
        this.e = f;
        this.f = f / 2.0f;
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, i * 12);
        long integer = typedArrayObtainStyledAttributes.getInteger(0, 400);
        this.d = integer;
        this.g = integer / 2;
        int color = typedArrayObtainStyledAttributes.getColor(4, -2130706433);
        int color2 = typedArrayObtainStyledAttributes.getColor(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.x = paint;
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.y = paint2;
        paint2.setColor(color2);
        if (i1.o == null) {
            i1.o = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in);
        }
        this.G = i1.o;
        this.z = new Path();
        this.A = new Path();
        this.B = new Path();
        this.C = new Path();
        this.D = new RectF();
        addOnAttachStateChangeListener(this);
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.b;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getRequiredWidth() {
        int i = this.l;
        return ((i - 1) * this.c) + (this.b * i);
    }

    private Path getRetreatingJoinPath() {
        Path path = this.A;
        path.rewind();
        float f = this.s;
        float f2 = this.h;
        float f3 = this.t;
        float f4 = this.j;
        RectF rectF = this.D;
        rectF.set(f, f2, f3, f4);
        float f5 = this.e;
        path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageCount(int i) {
        this.l = i;
        c(getWidth(), getHeight());
        e();
        requestLayout();
    }

    private void setSelectedPage(int i) {
        int iMin = Math.min(i, this.l - 1);
        int i2 = this.m;
        if (iMin == i2) {
            return;
        }
        this.w = true;
        this.n = i2;
        this.m = iMin;
        int iAbs = Math.abs(iMin - i2);
        if (iAbs > 1) {
            if (iMin > this.n) {
                for (int i3 = 0; i3 < iAbs; i3++) {
                    int i4 = this.n + i3;
                    float[] fArr = this.r;
                    if (i4 < fArr.length) {
                        fArr[i4] = 1.0f;
                        postInvalidateOnAnimation();
                    }
                }
            } else {
                for (int i5 = -1; i5 > (-iAbs); i5--) {
                    int i6 = this.n + i5;
                    float[] fArr2 = this.r;
                    if (i6 < fArr2.length) {
                        fArr2[i6] = 1.0f;
                        postInvalidateOnAnimation();
                    }
                }
            }
        }
        if (getVisibility() == 0) {
            float f = this.q[iMin];
            int i7 = this.n;
            int i8 = 2;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.o, f);
            float f2 = this.o;
            kb0 kb0Var = new kb0(this, i7, iMin, iAbs, iMin > i7 ? new hb0(1, f - ((f - f2) * 0.25f)) : new hb0(0, ((f2 - f) * 0.25f) + f));
            this.E = kb0Var;
            kb0Var.addListener(new gb0(this, 0));
            valueAnimatorOfFloat.addUpdateListener(new wg(i8, this));
            valueAnimatorOfFloat.addListener(new gb0(this, 1));
            boolean z = this.p;
            long j = this.d;
            valueAnimatorOfFloat.setStartDelay(z ? j / 4 : 0L);
            valueAnimatorOfFloat.setDuration((j * 3) / 4);
            valueAnimatorOfFloat.setInterpolator(this.G);
            valueAnimatorOfFloat.start();
        }
    }

    public final void c(int i, int i2) {
        if (this.J) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            float paddingBottom = ((i2 - getPaddingBottom()) / 2.0f) + paddingTop;
            float paddingRight = (((i - getPaddingRight()) / 2.0f) + paddingLeft) - (getRequiredWidth() / 2.0f);
            float f = this.e;
            float f2 = paddingRight + f;
            this.q = new float[Math.max(1, this.l)];
            for (int i3 = 0; i3 < this.l; i3++) {
                this.q[i3] = ((this.b + this.c) * i3) + f2;
            }
            this.h = paddingBottom - f;
            this.i = paddingBottom;
            this.j = paddingBottom + f;
            f();
        }
    }

    @Override // defpackage.kg1
    public void d(int i) {
        if (this.v) {
            setSelectedPage(i);
        } else {
            f();
        }
    }

    public final void e() {
        float[] fArr = new float[Math.max(this.l - 1, 0)];
        this.r = fArr;
        Arrays.fill(fArr, 0.0f);
        float[] fArr2 = new float[this.l];
        this.u = fArr2;
        Arrays.fill(fArr2, 0.0f);
        this.s = -1.0f;
        this.t = -1.0f;
        this.p = true;
    }

    public final void f() {
        mg1 mg1Var = this.k;
        if (mg1Var != null) {
            this.m = mg1Var.getCurrentItem();
        } else {
            this.m = 0;
        }
        float[] fArr = this.q;
        if (fArr != null) {
            this.o = fArr[Math.max(0, Math.min(this.m, fArr.length - 1))];
        }
    }

    public int getCurrentPageIndicatorColor() {
        return this.y.getColor();
    }

    public int getPageIndicatorColor() {
        return this.x.getColor();
    }

    @Override // defpackage.kg1
    public final void l(float f, int i, int i2) {
        if (this.v) {
            int i3 = this.w ? this.n : this.m;
            if (i3 != i) {
                f = 1.0f - f;
                if (f == 1.0f) {
                    i = Math.min(i3, i);
                }
            }
            float[] fArr = this.r;
            if (i < fArr.length) {
                fArr[i] = f;
                postInvalidateOnAnimation();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        int i;
        float f2;
        Path path;
        int i2;
        float f3;
        Path path2;
        if (this.k == null || this.l == 0) {
            return;
        }
        Path path3 = this.z;
        path3.rewind();
        int i3 = 0;
        while (true) {
            int i4 = this.l;
            f = this.e;
            if (i3 >= i4) {
                break;
            }
            int i5 = i4 - 1;
            int i6 = i3 == i5 ? i3 : i3 + 1;
            float[] fArr = this.q;
            float f4 = fArr[i3];
            float f5 = fArr[i6];
            float f6 = i3 == i5 ? -1.0f : this.r[i3];
            float f7 = this.u[i3];
            Path path4 = this.A;
            path4.rewind();
            if ((f6 == 0.0f || f6 == -1.0f) && f7 == 0.0f && (i3 != this.m || !this.p)) {
                path4.addCircle(this.q[i3], this.i, f, Path.Direction.CW);
            }
            int i7 = this.c;
            RectF rectF = this.D;
            if (f6 <= 0.0f || f6 > 0.5f || this.s != -1.0f) {
                i = i3;
                f2 = f6;
                path = path4;
                i2 = i7;
                f3 = 90.0f;
            } else {
                Path path5 = this.B;
                path5.rewind();
                path5.moveTo(f4, this.j);
                float f8 = f4 + f;
                i = i3;
                rectF.set(f4 - f, this.h, f8, this.j);
                path5.arcTo(rectF, 90.0f, 180.0f, true);
                float f9 = i7 * f6;
                float f10 = f8 + f9;
                this.H = f10;
                float f11 = this.i;
                this.I = f11;
                float f12 = this.f;
                float f13 = f4 + f12;
                path5.cubicTo(f13, this.h, f10, f11 - f12, f10, f11);
                float f14 = this.j;
                float f15 = this.H;
                float f16 = this.I + f12;
                path = path4;
                i2 = i7;
                f2 = f6;
                f3 = 90.0f;
                path5.cubicTo(f15, f16, f13, f14, f4, f14);
                Path.Op op = Path.Op.UNION;
                path.op(path5, op);
                Path path6 = this.C;
                path6.rewind();
                path6.moveTo(f5, this.j);
                float f17 = f5 - f;
                rectF.set(f17, this.h, f5 + f, this.j);
                path6.arcTo(rectF, 90.0f, -180.0f, true);
                float f18 = f17 - f9;
                this.H = f18;
                float f19 = this.i;
                this.I = f19;
                float f20 = f5 - f12;
                path6.cubicTo(f20, this.h, f18, f19 - f12, f18, f19);
                float f21 = this.j;
                path6.cubicTo(this.H, this.I + f12, f20, f21, f5, f21);
                path.op(path6, op);
            }
            if (f2 <= 0.5f || f2 >= 1.0f || this.s != -1.0f) {
                path2 = path;
            } else {
                float f22 = (f2 - 0.2f) * 1.25f;
                path.moveTo(f4, this.j);
                float f23 = f4 + f;
                rectF.set(f4 - f, this.h, f23, this.j);
                path.arcTo(rectF, f3, 180.0f, true);
                float f24 = f23 + (i2 / 2);
                this.H = f24;
                float f25 = f22 * f;
                float f26 = this.i - f25;
                this.I = f26;
                float f27 = (1.0f - f22) * f;
                Path path7 = path;
                path7.cubicTo(f24 - f25, this.h, f24 - f27, f26, f24, f26);
                float f28 = this.h;
                float f29 = this.H;
                path7.cubicTo(f27 + f29, this.I, f25 + f29, f28, f5, f28);
                rectF.set(f5 - f, this.h, f5 + f, this.j);
                path7.arcTo(rectF, 270.0f, 180.0f, true);
                float f30 = this.i + f25;
                this.I = f30;
                float f31 = this.H;
                path7.cubicTo(f25 + f31, this.j, f27 + f31, f30, f31, f30);
                float f32 = this.j;
                float f33 = this.H;
                path7.cubicTo(f33 - f27, this.I, f33 - f25, f32, f4, f32);
                path2 = path7;
            }
            if (f2 == 1.0f && this.s == -1.0f) {
                rectF.set(f4 - f, this.h, f5 + f, this.j);
                path2.addRoundRect(rectF, f, f, Path.Direction.CW);
            }
            if (f7 > 1.0E-5f) {
                path2.addCircle(f4, this.i, f7 * f, Path.Direction.CW);
            }
            path3.op(path2, Path.Op.UNION);
            i3 = i + 1;
        }
        if (this.s != -1.0f) {
            path3.op(getRetreatingJoinPath(), Path.Op.UNION);
        }
        canvas.drawPath(path3, this.x);
        canvas.drawCircle(this.o, this.i, f, this.y);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i2));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i2);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
        if (this.J) {
            return;
        }
        this.J = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        c(i, i2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.v = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.v = false;
    }

    public void setCurrentPageIndicatorColor(int i) {
        this.y.setColor(i);
        invalidate();
    }

    public void setPageIndicatorColor(int i) {
        this.x.setColor(i);
        invalidate();
    }

    public void setViewPager(mg1 mg1Var) {
        this.k = mg1Var;
        mg1Var.b(this);
        setPageCount(mg1Var.getAdapter().c());
        mg1Var.getAdapter().j(new d10(1, this));
    }

    @Override // defpackage.kg1
    public final void a(int i) {
    }
}
