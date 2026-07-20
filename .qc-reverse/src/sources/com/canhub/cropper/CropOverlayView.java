package com.canhub.cropper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ScaleGestureDetector;
import android.view.View;
import defpackage.cm;
import defpackage.cq;
import defpackage.dq;
import defpackage.eq;
import defpackage.fc0;
import defpackage.fq;
import defpackage.gg;
import defpackage.kl;
import defpackage.qq;
import defpackage.rq;
import defpackage.s1;
import defpackage.sq;
import defpackage.vq;
import defpackage.xq;
import defpackage.xr;
import defpackage.zy;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class CropOverlayView extends View {
    public boolean A;
    public int B;
    public int C;
    public float D;
    public fq E;
    public eq F;
    public dq G;
    public boolean H;
    public String I;
    public float J;
    public int K;
    public final Rect L;
    public boolean M;
    public final float N;
    public float b;
    public Integer c;
    public cq d;
    public ScaleGestureDetector e;
    public boolean f;
    public boolean g;
    public final vq h;
    public qq i;
    public final RectF j;
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public Paint o;
    public final Path p;
    public final float[] q;
    public final RectF r;
    public int s;
    public int t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public xq z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        this.g = true;
        this.h = new vq();
        this.j = new RectF();
        this.p = new Path();
        this.q = new float[8];
        this.r = new RectF();
        this.D = this.B / this.C;
        this.I = "";
        this.J = 20.0f;
        this.K = -1;
        this.L = new Rect();
        this.N = TypedValue.applyDimension(1, 200.0f, Resources.getSystem().getDisplayMetrics());
    }

    public final boolean a(RectF rectF) {
        float f;
        float f2;
        Rect rect = gg.a;
        float[] fArr = this.q;
        float fN = gg.n(fArr);
        float fP = gg.p(fArr);
        float fO = gg.o(fArr);
        float fL = gg.l(fArr);
        float f3 = fArr[0];
        float f4 = fArr[6];
        RectF rectF2 = this.r;
        if (f3 == f4 || fArr[1] == fArr[7]) {
            rectF2.set(fN, fP, fO, fL);
            return false;
        }
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        if (f10 < f6) {
            float f11 = fArr[3];
            if (f6 < f11) {
                float f12 = fArr[2];
                f = f10;
                f10 = f11;
                f2 = f9;
                f6 = f8;
                f9 = f12;
                f5 = f7;
            } else {
                f9 = f5;
                f10 = f6;
                f6 = f11;
                f5 = fArr[2];
                f2 = f7;
                f = f8;
            }
        } else {
            f = fArr[3];
            if (f6 > f) {
                f2 = fArr[2];
            } else {
                f2 = f5;
                f5 = f9;
                f = f6;
                f6 = f10;
                f9 = f7;
                f10 = f8;
            }
        }
        float f13 = (f6 - f) / (f5 - f2);
        float f14 = (-1.0f) / f13;
        float f15 = f - (f13 * f2);
        float f16 = f - (f2 * f14);
        float f17 = f10 - (f13 * f9);
        float f18 = f10 - (f9 * f14);
        float fCenterY = rectF.centerY() - rectF.top;
        float fCenterX = rectF.centerX();
        float f19 = rectF.left;
        float f20 = fCenterY / (fCenterX - f19);
        float f21 = -f20;
        float f22 = rectF.top;
        float f23 = f22 - (f19 * f20);
        float f24 = rectF.right;
        float f25 = f22 - (f21 * f24);
        float f26 = f13 - f20;
        float f27 = (f23 - f15) / f26;
        float fMax = Math.max(fN, f27 < f24 ? f27 : fN);
        float f28 = (f23 - f16) / (f14 - f20);
        if (f28 >= rectF.right) {
            f28 = fMax;
        }
        float fMax2 = Math.max(fMax, f28);
        float f29 = f14 - f21;
        float f30 = (f25 - f18) / f29;
        float fMax3 = Math.max(fMax2, f30 < rectF.right ? f30 : fMax2);
        float f31 = (f25 - f16) / f29;
        if (f31 <= rectF.left) {
            f31 = fO;
        }
        float fMin = Math.min(fO, f31);
        float f32 = (f25 - f17) / (f13 - f21);
        if (f32 <= rectF.left) {
            f32 = fMin;
        }
        float fMin2 = Math.min(fMin, f32);
        float f33 = (f23 - f17) / f26;
        if (f33 <= rectF.left) {
            f33 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f33);
        float fMax4 = Math.max(fP, Math.max((f13 * fMax3) + f15, (f14 * fMin3) + f16));
        float fMin4 = Math.min(fL, Math.min((f14 * fMax3) + f18, (f13 * fMin3) + f17));
        rectF2.left = fMax3;
        rectF2.top = fMax4;
        rectF2.right = fMin3;
        rectF2.bottom = fMin4;
        return true;
    }

    public final void b(Canvas canvas, RectF rectF, float f, float f2) {
        eq eqVar = this.F;
        int i = eqVar == null ? -1 : sq.a[eqVar.ordinal()];
        if (i == 1) {
            float f3 = this.b;
            dq dqVar = this.G;
            int i2 = dqVar == null ? -1 : sq.b[dqVar.ordinal()];
            if (i2 != -1) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new cm();
                    }
                    d(canvas, rectF, f, f2);
                    return;
                }
                float f4 = rectF.left - f;
                float f5 = rectF.top - f;
                Paint paint = this.l;
                paint.getClass();
                canvas.drawCircle(f4, f5, f3, paint);
                float f6 = rectF.right + f;
                float f7 = rectF.top - f;
                Paint paint2 = this.l;
                paint2.getClass();
                canvas.drawCircle(f6, f7, f3, paint2);
                float f8 = rectF.left - f;
                float f9 = rectF.bottom + f;
                Paint paint3 = this.l;
                paint3.getClass();
                canvas.drawCircle(f8, f9, f3, paint3);
                float f10 = rectF.right + f;
                float f11 = rectF.bottom + f;
                Paint paint4 = this.l;
                paint4.getClass();
                canvas.drawCircle(f10, f11, f3, paint4);
                return;
            }
            return;
        }
        if (i == 2) {
            float fCenterX = rectF.centerX() - this.v;
            float f12 = rectF.top - f;
            float fCenterX2 = this.v + rectF.centerX();
            float f13 = rectF.top - f;
            Paint paint5 = this.l;
            paint5.getClass();
            canvas.drawLine(fCenterX, f12, fCenterX2, f13, paint5);
            float fCenterX3 = rectF.centerX() - this.v;
            float f14 = rectF.bottom + f;
            float fCenterX4 = rectF.centerX() + this.v;
            float f15 = rectF.bottom + f;
            Paint paint6 = this.l;
            paint6.getClass();
            canvas.drawLine(fCenterX3, f14, fCenterX4, f15, paint6);
            return;
        }
        if (i != 3) {
            if (i == 4) {
                d(canvas, rectF, f, f2);
                return;
            } else {
                s1.f("Unrecognized crop shape");
                return;
            }
        }
        float f16 = rectF.left - f;
        float fCenterY = rectF.centerY() - this.v;
        float f17 = rectF.left - f;
        float fCenterY2 = this.v + rectF.centerY();
        Paint paint7 = this.l;
        paint7.getClass();
        canvas.drawLine(f16, fCenterY, f17, fCenterY2, paint7);
        float f18 = rectF.right + f;
        float fCenterY3 = rectF.centerY() - this.v;
        float f19 = rectF.right + f;
        float fCenterY4 = rectF.centerY() + this.v;
        Paint paint8 = this.l;
        paint8.getClass();
        canvas.drawLine(f18, fCenterY3, f19, fCenterY4, paint8);
    }

    public final void c(Canvas canvas) {
        if (this.m != null) {
            Paint paint = this.k;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rectFG = this.h.g();
            rectFG.inset(strokeWidth, strokeWidth);
            float fWidth = rectFG.width() / 3.0f;
            float fHeight = rectFG.height() / 3.0f;
            eq eqVar = this.F;
            int i = eqVar == null ? -1 : sq.a[eqVar.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                float f = rectFG.left + fWidth;
                float f2 = rectFG.right - fWidth;
                float f3 = rectFG.top;
                float f4 = rectFG.bottom;
                Paint paint2 = this.m;
                paint2.getClass();
                canvas.drawLine(f, f3, f, f4, paint2);
                float f5 = rectFG.top;
                float f6 = rectFG.bottom;
                Paint paint3 = this.m;
                paint3.getClass();
                canvas.drawLine(f2, f5, f2, f6, paint3);
                float f7 = rectFG.top + fHeight;
                float f8 = rectFG.bottom - fHeight;
                float f9 = rectFG.left;
                float f10 = rectFG.right;
                Paint paint4 = this.m;
                paint4.getClass();
                canvas.drawLine(f9, f7, f10, f7, paint4);
                float f11 = rectFG.left;
                float f12 = rectFG.right;
                Paint paint5 = this.m;
                paint5.getClass();
                canvas.drawLine(f11, f8, f12, f8, paint5);
                return;
            }
            if (i != 4) {
                s1.f("Unrecognized crop shape");
                return;
            }
            float fWidth2 = (rectFG.width() / 2.0f) - strokeWidth;
            float fHeight2 = (rectFG.height() / 2.0f) - strokeWidth;
            float f13 = rectFG.left + fWidth;
            float f14 = rectFG.right - fWidth;
            float fSin = (float) (Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)) * ((double) fHeight2));
            float f15 = (rectFG.top + fHeight2) - fSin;
            float f16 = (rectFG.bottom - fHeight2) + fSin;
            Paint paint6 = this.m;
            paint6.getClass();
            canvas.drawLine(f13, f15, f13, f16, paint6);
            float f17 = (rectFG.top + fHeight2) - fSin;
            float f18 = (rectFG.bottom - fHeight2) + fSin;
            Paint paint7 = this.m;
            paint7.getClass();
            canvas.drawLine(f14, f17, f14, f18, paint7);
            float f19 = rectFG.top + fHeight;
            float f20 = rectFG.bottom - fHeight;
            float fCos = (float) (Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)) * ((double) fWidth2));
            float f21 = (rectFG.left + fWidth2) - fCos;
            float f22 = (rectFG.right - fWidth2) + fCos;
            Paint paint8 = this.m;
            paint8.getClass();
            canvas.drawLine(f21, f19, f22, f19, paint8);
            float f23 = (rectFG.left + fWidth2) - fCos;
            float f24 = (rectFG.right - fWidth2) + fCos;
            Paint paint9 = this.m;
            paint9.getClass();
            canvas.drawLine(f23, f20, f24, f20, paint9);
        }
    }

    public final void d(Canvas canvas, RectF rectF, float f, float f2) {
        float f3 = rectF.left - f;
        float f4 = rectF.top;
        float f5 = f4 + this.v;
        Paint paint = this.l;
        paint.getClass();
        canvas.drawLine(f3, f4 - f2, f3, f5, paint);
        float f6 = rectF.left;
        float f7 = rectF.top - f;
        float f8 = f6 + this.v;
        Paint paint2 = this.l;
        paint2.getClass();
        canvas.drawLine(f6 - f2, f7, f8, f7, paint2);
        float f9 = rectF.right + f;
        float f10 = rectF.top;
        float f11 = f10 + this.v;
        Paint paint3 = this.l;
        paint3.getClass();
        canvas.drawLine(f9, f10 - f2, f9, f11, paint3);
        float f12 = rectF.right;
        float f13 = rectF.top - f;
        float f14 = f12 - this.v;
        Paint paint4 = this.l;
        paint4.getClass();
        canvas.drawLine(f12 + f2, f13, f14, f13, paint4);
        float f15 = rectF.left - f;
        float f16 = rectF.bottom;
        float f17 = f16 - this.v;
        Paint paint5 = this.l;
        paint5.getClass();
        canvas.drawLine(f15, f16 + f2, f15, f17, paint5);
        float f18 = rectF.left;
        float f19 = rectF.bottom + f;
        float f20 = f18 + this.v;
        Paint paint6 = this.l;
        paint6.getClass();
        canvas.drawLine(f18 - f2, f19, f20, f19, paint6);
        float f21 = rectF.right + f;
        float f22 = rectF.bottom;
        float f23 = f22 - this.v;
        Paint paint7 = this.l;
        paint7.getClass();
        canvas.drawLine(f21, f22 + f2, f21, f23, paint7);
        float f24 = rectF.right;
        float f25 = rectF.bottom + f;
        float f26 = f24 - this.v;
        Paint paint8 = this.l;
        paint8.getClass();
        canvas.drawLine(f24 + f2, f25, f26, f25, paint8);
    }

    public final void e(RectF rectF) {
        float fWidth = rectF.width();
        vq vqVar = this.h;
        if (fWidth < vqVar.e()) {
            float fE = (vqVar.e() - rectF.width()) / 2.0f;
            rectF.left -= fE;
            rectF.right += fE;
        }
        if (rectF.height() < vqVar.d()) {
            float fD = (vqVar.d() - rectF.height()) / 2.0f;
            rectF.top -= fD;
            rectF.bottom += fD;
        }
        if (rectF.width() > vqVar.c()) {
            float fWidth2 = (rectF.width() - vqVar.c()) / 2.0f;
            rectF.left += fWidth2;
            rectF.right -= fWidth2;
        }
        if (rectF.height() > vqVar.b()) {
            float fHeight = (rectF.height() - vqVar.b()) / 2.0f;
            rectF.top += fHeight;
            rectF.bottom -= fHeight;
        }
        a(rectF);
        RectF rectF2 = this.r;
        if (rectF2.width() > 0.0f && rectF2.height() > 0.0f) {
            float fMax = Math.max(rectF2.left, 0.0f);
            float fMax2 = Math.max(rectF2.top, 0.0f);
            float fMin = Math.min(rectF2.right, getWidth());
            float fMin2 = Math.min(rectF2.bottom, getHeight());
            if (rectF.left < fMax) {
                rectF.left = fMax;
            }
            if (rectF.top < fMax2) {
                rectF.top = fMax2;
            }
            if (rectF.right > fMin) {
                rectF.right = fMin;
            }
            if (rectF.bottom > fMin2) {
                rectF.bottom = fMin2;
            }
        }
        if (!this.A || Math.abs(rectF.width() - (rectF.height() * this.D)) <= 0.1d) {
            return;
        }
        if (rectF.width() > rectF.height() * this.D) {
            float fAbs = Math.abs((rectF.height() * this.D) - rectF.width()) / 2.0f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rectF.width() / this.D) - rectF.height()) / 2.0f;
            rectF.top += fAbs2;
            rectF.bottom -= fAbs2;
        }
    }

    public final void f() {
        Rect rect = gg.a;
        float[] fArr = this.q;
        float fMax = Math.max(gg.n(fArr), 0.0f);
        float fMax2 = Math.max(gg.p(fArr), 0.0f);
        float fMin = Math.min(gg.o(fArr), getWidth());
        float fMin2 = Math.min(gg.l(fArr), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.M = true;
        float f = this.w;
        float f2 = fMin - fMax;
        float f3 = f * f2;
        float f4 = fMin2 - fMax2;
        float f5 = f * f4;
        Rect rect2 = this.L;
        int iWidth = rect2.width();
        vq vqVar = this.h;
        if (iWidth > 0 && rect2.height() > 0) {
            float f6 = (rect2.left / vqVar.k) + fMax;
            rectF.left = f6;
            rectF.top = (rect2.top / vqVar.l) + fMax2;
            rectF.right = (rect2.width() / vqVar.k) + f6;
            rectF.bottom = (rect2.height() / vqVar.l) + rectF.top;
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.A || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f3;
            rectF.top = fMax2 + f5;
            rectF.right = fMin - f3;
            rectF.bottom = fMin2 - f5;
        } else if (f2 / f4 > this.D) {
            rectF.top = fMax2 + f5;
            rectF.bottom = fMin2 - f5;
            float width = getWidth() / 2.0f;
            this.D = this.B / this.C;
            float fMax3 = Math.max(vqVar.e(), rectF.height() * this.D) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f3;
            rectF.right = fMin - f3;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(vqVar.d(), rectF.width() / this.D) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        e(rectF);
        vqVar.getClass();
        vqVar.a.set(rectF);
    }

    public final void g() {
        if (this.M) {
            setCropWindowRect(gg.b);
            f();
            invalidate();
        }
    }

    public final int getAspectRatioX() {
        return this.B;
    }

    public final int getAspectRatioY() {
        return this.C;
    }

    public final dq getCornerShape() {
        return this.G;
    }

    public final eq getCropShape() {
        return this.F;
    }

    public final RectF getCropWindowRect() {
        return this.h.g();
    }

    public final fq getGuidelines() {
        return this.E;
    }

    public final Rect getInitialCropWindowRect() {
        return this.L;
    }

    public final void h(float[] fArr, int i, int i2) {
        float[] fArr2 = this.q;
        if (fArr == null || !Arrays.equals(fArr2, fArr)) {
            if (fArr == null) {
                Arrays.fill(fArr2, 0.0f);
            } else {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            }
            this.s = i;
            this.t = i2;
            RectF rectFG = this.h.g();
            if (rectFG.width() == 0.0f || rectFG.height() == 0.0f) {
                f();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        Canvas canvas2;
        Paint paint;
        canvas.getClass();
        super.onDraw(canvas);
        vq vqVar = this.h;
        RectF rectFG = vqVar.g();
        Rect rect = gg.a;
        float[] fArr = this.q;
        float fMax = Math.max(gg.n(fArr), 0.0f);
        float fMax2 = Math.max(gg.p(fArr), 0.0f);
        float fMin = Math.min(gg.o(fArr), getWidth());
        float fMin2 = Math.min(gg.l(fArr), getHeight());
        eq eqVar = this.F;
        int i3 = eqVar == null ? -1 : sq.a[eqVar.ordinal()];
        Path path = this.p;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            i = 3;
            i2 = 4;
            if (fArr[0] == fArr[6] || fArr[1] == fArr[7]) {
                float f = rectFG.top;
                Paint paint2 = this.n;
                paint2.getClass();
                canvas2 = canvas;
                canvas2.drawRect(fMax, fMax2, fMin, f, paint2);
                float f2 = rectFG.bottom;
                Paint paint3 = this.n;
                paint3.getClass();
                canvas2.drawRect(fMax, f2, fMin, fMin2, paint3);
                float f3 = rectFG.top;
                float f4 = rectFG.left;
                float f5 = rectFG.bottom;
                Paint paint4 = this.n;
                paint4.getClass();
                canvas2.drawRect(fMax, f3, f4, f5, paint4);
                float f6 = rectFG.right;
                float f7 = rectFG.top;
                float f8 = rectFG.bottom;
                Paint paint5 = this.n;
                paint5.getClass();
                canvas2.drawRect(f6, f7, fMin, f8, paint5);
            } else {
                path.reset();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                path.lineTo(fArr[4], fArr[5]);
                path.lineTo(fArr[6], fArr[7]);
                path.close();
                canvas.save();
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipOutPath(path);
                } else {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                Paint paint6 = this.n;
                paint6.getClass();
                canvas2 = canvas;
                canvas2.drawRect(fMax, fMax2, fMin, fMin2, paint6);
                canvas2.restore();
            }
        } else {
            if (i3 != 4) {
                s1.f("Unrecognized crop shape");
                return;
            }
            path.reset();
            float f9 = rectFG.left;
            float f10 = rectFG.top;
            i2 = 4;
            float f11 = rectFG.right;
            float f12 = rectFG.bottom;
            i = 3;
            RectF rectF = this.j;
            rectF.set(f9, f10, f11, f12);
            path.addOval(rectF, Path.Direction.CW);
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutPath(path);
            } else {
                canvas.clipPath(path, Region.Op.XOR);
            }
            Paint paint7 = this.n;
            paint7.getClass();
            canvas.drawRect(fMax, fMax2, fMin, fMin2, paint7);
            canvas.restore();
            canvas2 = canvas;
        }
        RectF rectF2 = vqVar.a;
        if (rectF2.width() >= 100.0f && rectF2.height() >= 100.0f) {
            fq fqVar = this.E;
            if (fqVar == fq.d) {
                c(canvas);
            } else if (fqVar == fq.c && this.z != null) {
                c(canvas);
            }
        }
        cq cqVar = this.d;
        this.l = xr.q(cqVar != null ? cqVar.C : -1, cqVar != null ? cqVar.z : 0.0f);
        if (this.H) {
            RectF rectFG2 = vqVar.g();
            float f13 = (rectFG2.left + rectFG2.right) / 2.0f;
            float f14 = rectFG2.top - 50.0f;
            Paint paint8 = this.o;
            if (paint8 != null) {
                paint8.setTextSize(this.J);
                paint8.setColor(this.K);
            }
            String str = this.I;
            Paint paint9 = this.o;
            paint9.getClass();
            canvas2.drawText(str, f13, f14, paint9);
            canvas2.save();
        }
        Paint paint10 = this.k;
        if (paint10 != null) {
            float strokeWidth = paint10.getStrokeWidth();
            RectF rectFG3 = vqVar.g();
            float f15 = strokeWidth / 2.0f;
            rectFG3.inset(f15, f15);
            eq eqVar2 = this.F;
            int i4 = eqVar2 == null ? -1 : sq.a[eqVar2.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == i) {
                Paint paint11 = this.k;
                paint11.getClass();
                canvas2.drawRect(rectFG3, paint11);
            } else if (i4 != i2) {
                s1.f("Unrecognized crop shape");
                return;
            } else {
                Paint paint12 = this.k;
                paint12.getClass();
                canvas2.drawOval(rectFG3, paint12);
            }
        }
        if (this.l != null) {
            Paint paint13 = this.k;
            float strokeWidth2 = paint13 != null ? paint13.getStrokeWidth() : 0.0f;
            Paint paint14 = this.l;
            paint14.getClass();
            float strokeWidth3 = paint14.getStrokeWidth();
            float f16 = (strokeWidth3 - strokeWidth2) / 2.0f;
            float f17 = strokeWidth3 / 2.0f;
            float f18 = f17 + f16;
            eq eqVar3 = this.F;
            int i5 = eqVar3 == null ? -1 : sq.a[eqVar3.ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                f17 += this.u;
            } else if (i5 != 4) {
                s1.f("Unrecognized crop shape");
                return;
            }
            RectF rectFG4 = vqVar.g();
            rectFG4.inset(f17, f17);
            b(canvas2, rectFG4, f16, f18);
            if (this.G == dq.c) {
                Integer num = this.c;
                if (num != null) {
                    int iIntValue = num.intValue();
                    paint = new Paint();
                    paint.setColor(iIntValue);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setAntiAlias(true);
                } else {
                    paint = null;
                }
                this.l = paint;
                b(canvas2, rectFG4, f16, f18);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            RectF rectFG5 = vqVar.g();
            List systemGestureExclusionRects = getSystemGestureExclusionRects();
            systemGestureExclusionRects.getClass();
            Rect rect2 = (Rect) (systemGestureExclusionRects.size() > 0 ? systemGestureExclusionRects.get(0) : new Rect());
            List systemGestureExclusionRects2 = getSystemGestureExclusionRects();
            systemGestureExclusionRects2.getClass();
            Rect rect3 = (Rect) (1 < systemGestureExclusionRects2.size() ? systemGestureExclusionRects2.get(1) : new Rect());
            List systemGestureExclusionRects3 = getSystemGestureExclusionRects();
            systemGestureExclusionRects3.getClass();
            Rect rect4 = (Rect) (2 < systemGestureExclusionRects3.size() ? systemGestureExclusionRects3.get(2) : new Rect());
            float f19 = rectFG5.left;
            float f20 = this.x;
            int i6 = (int) (f19 - f20);
            rect2.left = i6;
            int i7 = (int) (rectFG5.right + f20);
            rect2.right = i7;
            float f21 = rectFG5.top;
            int i8 = (int) (f21 - f20);
            rect2.top = i8;
            float f22 = this.N;
            float f23 = 0.3f * f22;
            rect2.bottom = (int) (i8 + f23);
            rect3.left = i6;
            rect3.right = i7;
            float f24 = rectFG5.bottom;
            int i9 = (int) (((f21 + f24) / 2.0f) - (0.2f * f22));
            rect3.top = i9;
            rect3.bottom = (int) ((f22 * 0.4f) + i9);
            rect4.left = rect2.left;
            rect4.right = rect2.right;
            int i10 = (int) (f24 + f20);
            rect4.bottom = i10;
            rect4.top = (int) (i10 - f23);
            setSystemGestureExclusionRects(kl.K0(rect2, rect3, rect4));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r1 != 3) goto L216;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03bc A[PHI: r7 r8
  0x03bc: PHI (r7v3 float) = (r7v1 float), (r7v8 float) binds: [B:174:0x0475, B:133:0x03ba] A[DONT_GENERATE, DONT_INLINE]
  0x03bc: PHI (r8v3 float) = (r8v1 float), (r8v8 float) binds: [B:174:0x0475, B:133:0x03ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03ce A[PHI: r7 r8
  0x03ce: PHI (r7v2 float) = (r7v1 float), (r7v8 float) binds: [B:181:0x048f, B:136:0x03cc] A[DONT_GENERATE, DONT_INLINE]
  0x03ce: PHI (r8v2 float) = (r8v1 float), (r8v8 float) binds: [B:181:0x048f, B:136:0x03cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instruction units count: 1328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropOverlayView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setAspectRatioX(int i) {
        if (i <= 0) {
            zy.n("Cannot set aspect ratio value to a number less than or equal to 0.");
            return;
        }
        if (this.B != i) {
            this.B = i;
            this.D = i / this.C;
            if (this.M) {
                f();
                invalidate();
            }
        }
    }

    public final void setAspectRatioY(int i) {
        if (i <= 0) {
            zy.n("Cannot set aspect ratio value to a number less than or equal to 0.");
            return;
        }
        if (this.C != i) {
            this.C = i;
            this.D = this.B / i;
            if (this.M) {
                f();
                invalidate();
            }
        }
    }

    public final void setCropCornerRadius(float f) {
        this.b = f;
    }

    public final void setCropCornerShape(dq dqVar) {
        dqVar.getClass();
        if (this.G != dqVar) {
            this.G = dqVar;
            invalidate();
        }
    }

    public final void setCropLabelText(String str) {
        if (str != null) {
            this.I = str;
        }
    }

    public final void setCropLabelTextColor(int i) {
        this.K = i;
        invalidate();
    }

    public final void setCropLabelTextSize(float f) {
        this.J = f;
        invalidate();
    }

    public final void setCropShape(eq eqVar) {
        eqVar.getClass();
        if (this.F != eqVar) {
            this.F = eqVar;
            invalidate();
        }
    }

    public final void setCropWindowChangeListener(qq qqVar) {
        this.i = qqVar;
    }

    public final void setCropWindowRect(RectF rectF) {
        rectF.getClass();
        vq vqVar = this.h;
        vqVar.getClass();
        vqVar.a.set(rectF);
    }

    public final void setCropperTextLabelVisibility(boolean z) {
        this.H = z;
        invalidate();
    }

    public final void setFixedAspectRatio(boolean z) {
        if (this.A != z) {
            this.A = z;
            if (this.M) {
                f();
                invalidate();
            }
        }
    }

    public final void setGuidelines(fq fqVar) {
        fqVar.getClass();
        if (this.E != fqVar) {
            this.E = fqVar;
            if (this.M) {
                invalidate();
            }
        }
    }

    public final void setInitialAttributeValues(cq cqVar) {
        qq qqVar;
        cqVar.getClass();
        float f = cqVar.l0;
        int i = cqVar.m0;
        int i2 = cqVar.M;
        int i3 = cqVar.L;
        int i4 = cqVar.K;
        int i5 = cqVar.J;
        int i6 = cqVar.w;
        int i7 = cqVar.v;
        boolean z = cqVar.u;
        boolean zB = fc0.b(this.d, cqVar);
        cq cqVar2 = this.d;
        boolean z2 = (cqVar2 != null && z == cqVar2.u && i7 == cqVar2.v && i6 == cqVar2.w) ? false : true;
        this.d = cqVar;
        float f2 = i5;
        vq vqVar = this.h;
        vqVar.g = f2;
        float f3 = i4;
        vqVar.h = f3;
        float f4 = i3;
        vqVar.i = f4;
        float f5 = i2;
        vqVar.j = f5;
        if (zB) {
            return;
        }
        vqVar.c = cqVar.H;
        vqVar.d = cqVar.I;
        vqVar.g = f2;
        vqVar.h = f3;
        vqVar.i = f4;
        vqVar.j = f5;
        this.K = i;
        this.J = f;
        String str = cqVar.n0;
        if (str == null) {
            str = "";
        }
        this.I = str;
        this.H = cqVar.l;
        this.b = cqVar.f;
        this.G = cqVar.e;
        this.F = cqVar.d;
        this.y = cqVar.g;
        setEnabled(cqVar.r);
        this.E = cqVar.i;
        this.A = z;
        setAspectRatioX(i7);
        setAspectRatioY(i6);
        boolean z3 = cqVar.p;
        this.f = z3;
        if (z3 && this.e == null) {
            this.e = new ScaleGestureDetector(getContext(), new rq(this, 0));
        }
        this.g = cqVar.q;
        this.x = cqVar.h;
        this.w = cqVar.t;
        this.k = xr.q(cqVar.y, cqVar.x);
        this.u = cqVar.A;
        this.v = cqVar.B;
        this.c = Integer.valueOf(cqVar.D);
        this.l = xr.q(cqVar.C, cqVar.z);
        this.m = xr.q(cqVar.F, cqVar.E);
        int i8 = cqVar.G;
        Paint paint = new Paint();
        paint.setColor(i8);
        this.n = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setTextSize(f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setColor(i);
        this.o = paint2;
        if (z2) {
            f();
        }
        invalidate();
        if (!z2 || (qqVar = this.i) == null) {
            return;
        }
        ((CropImageView) qqVar).c(false, true);
    }

    public final void setInitialCropWindowRect(Rect rect) {
        if (rect == null) {
            rect = gg.a;
        }
        this.L.set(rect);
        if (this.M) {
            f();
            invalidate();
            qq qqVar = this.i;
            if (qqVar != null) {
                ((CropImageView) qqVar).c(false, true);
            }
        }
    }

    public final void setSnapRadius(float f) {
        this.y = f;
    }
}
