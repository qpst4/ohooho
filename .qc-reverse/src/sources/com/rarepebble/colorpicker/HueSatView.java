package com.rarepebble.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import defpackage.e21;
import defpackage.f9;
import defpackage.fp1;
import defpackage.ql;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class HueSatView extends e21 implements ql {
    public static Bitmap l;
    public final Paint c;
    public final Paint d;
    public final Path e;
    public final Path f;
    public final Rect g;
    public int h;
    public int i;
    public final PointF j;
    public f9 k;

    public HueSatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Rect();
        this.j = new PointF();
        this.k = new f9(2);
        this.c = fp1.s(context);
        Paint paintS = fp1.s(context);
        this.d = paintS;
        paintS.setColor(-16777216);
        Path path = new Path();
        path.addCircle(0.0f, 0.0f, TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), Path.Direction.CW);
        this.e = path;
        this.f = new Path();
        if (l == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int iMin = Math.min(128, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / 2);
            int[] iArr = new int[iMin * iMin];
            float[] fArr = {0.0f, 0.0f, 1.0f};
            for (int i = 0; i < iMin; i++) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    int i3 = (i * iMin) + i2;
                    float f = iMin;
                    double d = f - 1.0f;
                    double d2 = (d - ((double) i2)) / d;
                    double d3 = (d - ((double) i)) / d;
                    float f2 = (float) ((d3 * d3) + (d2 * d2));
                    if (f2 <= (2.0f / f) + 1.0f) {
                        fArr[0] = (float) ((Math.atan2(d3, d2) * 360.0d) / 1.5707963267948966d);
                        fArr[1] = f2;
                        iArr[i3] = Color.HSVToColor(255, fArr);
                    }
                }
            }
            l = Bitmap.createBitmap(iArr, iMin, iMin, Bitmap.Config.ARGB_8888);
        }
    }

    @Override // defpackage.ql
    public final void a(f9 f9Var) {
        float[] fArr = (float[]) f9Var.c;
        float f = fArr[0];
        float f2 = this.h - 1.0f;
        double dSqrt = Math.sqrt(fArr[1]) * ((double) f2);
        double d = (((double) (f / 360.0f)) * 3.141592653589793d) / 2.0d;
        this.j.set(f2 - ((float) (Math.cos(d) * dSqrt)), f2 - ((float) (Math.sin(d) * dSqrt)));
        this.d.setColor(((double) this.k.c(1.0f)) > 0.5d ? -16777216 : -1);
        invalidate();
    }

    public final boolean b(PointF pointF, float f, float f2, boolean z) {
        float fMin = Math.min(f, this.h);
        float fMin2 = Math.min(f2, this.i);
        float f3 = this.h - fMin;
        float f4 = this.i - fMin2;
        float fSqrt = (float) Math.sqrt((f4 * f4) + (f3 * f3));
        float f5 = this.h;
        boolean z2 = fSqrt > f5;
        if (!z2 || !z) {
            if (z2) {
                fMin = f5 - ((f3 * f5) / fSqrt);
                fMin2 = f5 - ((f4 * f5) / fSqrt);
            }
            pointF.set(fMin, fMin2);
        }
        return !z2;
    }

    public final void c() {
        f9 f9Var = this.k;
        PointF pointF = this.j;
        float f = pointF.x;
        double d = this.h - 1.0f;
        float fAtan2 = (float) ((Math.atan2((d - ((double) pointF.y)) / d, (d - ((double) f)) / d) * 360.0d) / 1.5707963267948966d);
        float f2 = pointF.x;
        double d2 = this.h - 1.0f;
        double d3 = (d2 - ((double) f2)) / d2;
        double d4 = (d2 - ((double) pointF.y)) / d2;
        float f3 = (float) ((d4 * d4) + (d3 * d3));
        float[] fArr = (float[]) f9Var.c;
        fArr[0] = fAtan2;
        fArr[1] = f3;
        f9Var.f(this);
        this.d.setColor(((double) this.k.c(1.0f)) > 0.5d ? -16777216 : -1);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Path path = this.f;
        canvas.clipPath(path);
        canvas.drawBitmap(l, (Rect) null, this.g, (Paint) null);
        PointF pointF = this.j;
        canvas.translate(pointF.x, pointF.y);
        canvas.drawPath(this.e, this.d);
        canvas.restore();
        canvas.drawPath(path, this.c);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.h = i;
        this.i = i2;
        this.g.set(0, 0, i, i2);
        float strokeWidth = this.c.getStrokeWidth() / 2.0f;
        Path path = this.f;
        path.reset();
        float f = (int) (i - strokeWidth);
        path.moveTo(f, strokeWidth);
        float f2 = (int) (i2 - strokeWidth);
        path.lineTo(f, f2);
        path.lineTo(strokeWidth, f2);
        path.addArc(new RectF(strokeWidth, strokeWidth, r3 * 2, r4 * 2), 180.0f, 270.0f);
        path.close();
        a(this.k);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        PointF pointF = this.j;
        if (actionMasked == 0) {
            boolean zB = b(pointF, motionEvent.getX(), motionEvent.getY(), true);
            if (zB) {
                c();
            }
            return zB;
        }
        if (actionMasked != 2) {
            return super.onTouchEvent(motionEvent);
        }
        b(pointF, motionEvent.getX(), motionEvent.getY(), false);
        c();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }
}
