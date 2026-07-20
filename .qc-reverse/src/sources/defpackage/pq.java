package defpackage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pq extends q81 {
    public float A;
    public float B;
    public int C;
    public int D;
    public long E;
    public final RectF t;
    public final Matrix u;
    public float v;
    public float w;
    public tp x;
    public nq y;
    public oq z;

    public pq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new RectF();
        this.u = new Matrix();
        this.w = 10.0f;
        this.z = null;
        this.C = 0;
        this.D = 0;
        this.E = 500L;
    }

    public final void e(float f, float f2) {
        RectF rectF = this.t;
        float fMin = Math.min(Math.min(rectF.width() / f, rectF.width() / f2), Math.min(rectF.height() / f2, rectF.height() / f));
        this.B = fMin;
        this.A = fMin * this.w;
    }

    public final void f() {
        removeCallbacks(this.y);
        removeCallbacks(this.z);
    }

    public final boolean g(float[] fArr) {
        Matrix matrix = this.u;
        matrix.reset();
        matrix.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        matrix.mapPoints(fArrCopyOf);
        RectF rectF = this.t;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        float[] fArr2 = {f, f2, f3, f2, f3, f4, f, f4};
        matrix.mapPoints(fArr2);
        return xr.O(fArrCopyOf).contains(xr.O(fArr2));
    }

    public tp getCropBoundsChangeListener() {
        return this.x;
    }

    public float getMaxScale() {
        return this.A;
    }

    public float getMinScale() {
        return this.B;
    }

    public float getTargetAspectRatio() {
        return this.v;
    }

    public final void h(float f, float f2, float f3) {
        Matrix matrix = this.h;
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            if (f != 0.0f) {
                matrix.postScale(f, f, f2, f3);
                setImageMatrix(matrix);
                p81 p81Var = this.k;
                if (p81Var != null) {
                    ((wc1) p81Var).d(c(matrix));
                    return;
                }
                return;
            }
            return;
        }
        if (f >= 1.0f || getCurrentScale() * f < getMinScale() || f == 0.0f) {
            return;
        }
        matrix.postScale(f, f, f2, f3);
        setImageMatrix(matrix);
        p81 p81Var2 = this.k;
        if (p81Var2 != null) {
            ((wc1) p81Var2).d(c(matrix));
        }
    }

    public final void i(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            h(f / getCurrentScale(), f2, f3);
        }
    }

    public void setCropBoundsChangeListener(tp tpVar) {
        this.x = tpVar;
    }

    public void setCropRect(RectF rectF) {
        this.v = rectF.width() / rectF.height();
        this.t.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        if (getDrawable() != null) {
            e(r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        boolean z2;
        float f;
        float fMax;
        if (this.o) {
            float[] fArr = this.e;
            if (g(fArr)) {
                return;
            }
            float[] fArr2 = this.f;
            float f2 = fArr2[0];
            float f3 = fArr2[1];
            float currentScale = getCurrentScale();
            RectF rectF = this.t;
            float fCenterX = rectF.centerX() - f2;
            float fCenterY = rectF.centerY() - f3;
            Matrix matrix = this.u;
            matrix.reset();
            matrix.setTranslate(fCenterX, fCenterY);
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            matrix.mapPoints(fArrCopyOf);
            boolean zG = g(fArrCopyOf);
            if (zG) {
                matrix.reset();
                matrix.setRotate(-getCurrentAngle());
                float[] fArrCopyOf2 = Arrays.copyOf(fArr, fArr.length);
                float f4 = rectF.left;
                float f5 = rectF.top;
                float f6 = rectF.right;
                float f7 = rectF.bottom;
                float[] fArr3 = {f4, f5, f6, f5, f6, f7, f4, f7};
                matrix.mapPoints(fArrCopyOf2);
                matrix.mapPoints(fArr3);
                RectF rectFO = xr.O(fArrCopyOf2);
                RectF rectFO2 = xr.O(fArr3);
                float f8 = rectFO.left - rectFO2.left;
                float f9 = rectFO.top - rectFO2.top;
                float f10 = rectFO.right - rectFO2.right;
                float f11 = rectFO.bottom - rectFO2.bottom;
                fMax = 0.0f;
                if (f8 <= 0.0f) {
                    f8 = 0.0f;
                }
                if (f9 <= 0.0f) {
                    f9 = 0.0f;
                }
                if (f10 >= 0.0f) {
                    f10 = 0.0f;
                }
                if (f11 >= 0.0f) {
                    f11 = 0.0f;
                }
                float[] fArr4 = {f8, f9, f10, f11};
                matrix.reset();
                matrix.setRotate(getCurrentAngle());
                matrix.mapPoints(fArr4);
                fCenterX = -(fArr4[0] + fArr4[2]);
                fCenterY = -(fArr4[1] + fArr4[3]);
                f = f3;
                z2 = zG;
            } else {
                RectF rectF2 = new RectF(rectF);
                matrix.reset();
                matrix.setRotate(getCurrentAngle());
                matrix.mapRect(rectF2);
                z2 = zG;
                f = f3;
                float[] fArr5 = {(float) Math.sqrt(Math.pow(fArr[1] - fArr[3], 2.0d) + Math.pow(fArr[0] - fArr[2], 2.0d)), (float) Math.sqrt(Math.pow(fArr[3] - fArr[5], 2.0d) + Math.pow(fArr[2] - fArr[4], 2.0d))};
                fMax = (Math.max(rectF2.width() / fArr5[0], rectF2.height() / fArr5[1]) * currentScale) - currentScale;
            }
            float f12 = fCenterY;
            float f13 = fMax;
            if (z) {
                nq nqVar = new nq(this, this.E, f2, f, fCenterX, f12, currentScale, f13, z2);
                this.y = nqVar;
                post(nqVar);
                return;
            }
            d(fCenterX, f12);
            if (z2) {
                return;
            }
            i(currentScale + f13, rectF.centerX(), rectF.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.E = j;
        } else {
            zy.n("Animation duration cannot be negative value.");
        }
    }

    public void setMaxResultImageSizeX(int i) {
        this.C = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.D = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.w = f;
    }

    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.v = f;
            return;
        }
        if (f == 0.0f) {
            this.v = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.v = f;
        }
        tp tpVar = this.x;
        if (tpVar != null) {
            ((yc1) tpVar).a.c.setTargetAspectRatio(this.v);
        }
    }
}
