package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q81 extends AppCompatImageView {
    public final float[] e;
    public final float[] f;
    public final float[] g;
    public final Matrix h;
    public int i;
    public int j;
    public p81 k;
    public float[] l;
    public float[] m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;
    public String r;
    public xz s;

    public q81(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.e = new float[8];
        this.f = new float[2];
        this.g = new float[9];
        this.h = new Matrix();
        this.n = false;
        this.o = false;
        this.p = 0;
        GestureCropImageView gestureCropImageView = (GestureCropImageView) this;
        gestureCropImageView.setScaleType(ImageView.ScaleType.MATRIX);
        gestureCropImageView.H = new GestureDetector(gestureCropImageView.getContext(), new a60(gestureCropImageView), null, true);
        gestureCropImageView.F = new ScaleGestureDetector(gestureCropImageView.getContext(), new rq(gestureCropImageView, 1));
        sp1 sp1Var = new sp1(25, gestureCropImageView);
        qw0 qw0Var = new qw0();
        qw0Var.i = sp1Var;
        qw0Var.e = -1;
        qw0Var.f = -1;
        gestureCropImageView.G = qw0Var;
    }

    public final float c(Matrix matrix) {
        float[] fArr = this.g;
        matrix.getValues(fArr);
        double dPow = Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(Math.pow(fArr[3], 2.0d) + dPow);
    }

    public final void d(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        Matrix matrix = this.h;
        matrix.postTranslate(f, f2);
        setImageMatrix(matrix);
    }

    public float getCurrentAngle() {
        Matrix matrix = this.h;
        float[] fArr = this.g;
        matrix.getValues(fArr);
        double d = fArr[1];
        matrix.getValues(fArr);
        return (float) (-(Math.atan2(d, fArr[0]) * 57.29577951308232d));
    }

    public float getCurrentScale() {
        return c(this.h);
    }

    public xz getExifInfo() {
        return this.s;
    }

    public String getImageInputPath() {
        return this.q;
    }

    public String getImageOutputPath() {
        return this.r;
    }

    public int getMaxBitmapSize() {
        int iY;
        if (this.p <= 0) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int i = point.x;
            int iSqrt = (int) Math.sqrt(Math.pow(point.y, 2.0d) + Math.pow(i, 2.0d));
            Canvas canvas = new Canvas();
            int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
            if (iMin > 0) {
                iSqrt = Math.min(iSqrt, iMin);
            }
            try {
                iY = i1.y();
            } catch (Exception e) {
                Log.d("EglUtils", "getMaxTextureSize: ", e);
                iY = 0;
            }
            if (iY > 0) {
                iSqrt = Math.min(iSqrt, iY);
            }
            Log.d("BitmapLoadUtils", "maxBitmapSize: " + iSqrt);
            this.p = iSqrt;
        }
        return this.p;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof h10)) {
            return null;
        }
        return ((h10) getDrawable()).b;
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.n && !this.o)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.i = width - paddingLeft;
            this.j = height - paddingTop;
            pq pqVar = (pq) this;
            Drawable drawable = pqVar.getDrawable();
            if (drawable != null) {
                float intrinsicWidth = drawable.getIntrinsicWidth();
                float intrinsicHeight = drawable.getIntrinsicHeight();
                Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                float f = rectF.left;
                float f2 = rectF.top;
                float f3 = rectF.right;
                float f4 = rectF.bottom;
                pqVar.l = new float[]{f, f2, f3, f2, f3, f4, f, f4};
                pqVar.m = new float[]{rectF.centerX(), rectF.centerY()};
                pqVar.o = true;
                p81 p81Var = pqVar.k;
                if (p81Var != null) {
                    UCropActivity uCropActivity = ((wc1) p81Var).b;
                    uCropActivity.L.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
                    uCropActivity.X.setClickable(false);
                    uCropActivity.K = false;
                    uCropActivity.u().b();
                }
            }
            Drawable drawable2 = pqVar.getDrawable();
            if (drawable2 == null) {
                return;
            }
            float intrinsicWidth2 = drawable2.getIntrinsicWidth();
            float intrinsicHeight2 = drawable2.getIntrinsicHeight();
            if (pqVar.v == 0.0f) {
                pqVar.v = intrinsicWidth2 / intrinsicHeight2;
            }
            int i5 = pqVar.i;
            float f5 = i5;
            float f6 = pqVar.v;
            int i6 = (int) (f5 / f6);
            int i7 = pqVar.j;
            RectF rectF2 = pqVar.t;
            if (i6 > i7) {
                float f7 = i7;
                rectF2.set((i5 - ((int) (f6 * f7))) / 2, 0.0f, r1 + r11, f7);
            } else {
                rectF2.set(0.0f, (i7 - i6) / 2, f5, i6 + r3);
            }
            pqVar.e(intrinsicWidth2, intrinsicHeight2);
            float fWidth = rectF2.width();
            float fHeight = rectF2.height();
            float fMax = Math.max(rectF2.width() / intrinsicWidth2, rectF2.height() / intrinsicHeight2);
            float f8 = ((fWidth - (intrinsicWidth2 * fMax)) / 2.0f) + rectF2.left;
            float f9 = ((fHeight - (intrinsicHeight2 * fMax)) / 2.0f) + rectF2.top;
            Matrix matrix = pqVar.h;
            matrix.reset();
            matrix.postScale(fMax, fMax);
            matrix.postTranslate(f8, f9);
            pqVar.setImageMatrix(matrix);
            tp tpVar = pqVar.x;
            if (tpVar != null) {
                ((yc1) tpVar).a.c.setTargetAspectRatio(pqVar.v);
            }
            p81 p81Var2 = pqVar.k;
            if (p81Var2 != null) {
                ((wc1) p81Var2).d(pqVar.getCurrentScale());
                p81 p81Var3 = pqVar.k;
                float currentAngle = pqVar.getCurrentAngle();
                TextView textView = ((wc1) p81Var3).b.V;
                if (textView != null) {
                    textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(currentAngle)));
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new h10(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        Matrix matrix2 = this.h;
        matrix2.set(matrix);
        matrix2.mapPoints(this.e, this.l);
        matrix2.mapPoints(this.f, this.m);
    }

    public void setMaxBitmapSize(int i) {
        this.p = i;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(p81 p81Var) {
        this.k = p81Var;
    }
}
