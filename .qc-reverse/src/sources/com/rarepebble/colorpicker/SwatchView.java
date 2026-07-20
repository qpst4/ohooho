package com.rarepebble.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import defpackage.e21;
import defpackage.f9;
import defpackage.fp1;
import defpackage.ns0;
import defpackage.ql;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SwatchView extends e21 implements ql {
    public final Paint c;
    public final Path d;
    public final Paint e;
    public final Path f;
    public final Path g;
    public final Paint h;
    public final Paint i;
    public final float j;

    public SwatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            this.j = context.getTheme().obtainStyledAttributes(attributeSet, ns0.b, 0, 0).getDimension(0, 0.0f);
        } else {
            this.j = 0.0f;
        }
        this.c = fp1.s(context);
        this.e = fp1.r(context);
        this.h = new Paint();
        this.i = new Paint();
        this.d = new Path();
        this.f = new Path();
        this.g = new Path();
    }

    @Override // defpackage.ql
    public final void a(f9 f9Var) {
        this.i.setColor(Color.HSVToColor(f9Var.b, (float[]) f9Var.c));
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.e;
        Path path = this.d;
        canvas.drawPath(path, paint);
        canvas.drawPath(this.f, this.h);
        canvas.drawPath(this.g, this.i);
        canvas.drawPath(path, this.c);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        float strokeWidth = this.c.getStrokeWidth() / 2.0f;
        float fMin = Math.min(i, i2);
        float f = this.j;
        float f2 = (f * 2.0f) + fMin;
        float fSqrt = (float) Math.sqrt((f2 * f2) - (fMin * fMin));
        float f3 = fMin - fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan2(fSqrt, fMin));
        float f4 = 270.0f - degrees;
        float f5 = degrees - 45.0f;
        float f6 = 90.0f - degrees;
        Path path = this.d;
        path.reset();
        path.moveTo(strokeWidth, strokeWidth);
        float f7 = f - strokeWidth;
        float f8 = -f7;
        RectF rectF = new RectF(f8, f8, f7, f7);
        rectF.offset(f3, strokeWidth);
        path.arcTo(rectF, 0.0f, f6);
        float f9 = f + fMin;
        float f10 = -f9;
        RectF rectF2 = new RectF(f10, f10, f9, f9);
        rectF2.offset(fMin, fMin);
        path.arcTo(rectF2, f4, 2.0f * f5);
        float f11 = 90.0f - f6;
        RectF rectF3 = new RectF(f8, f8, f7, f7);
        rectF3.offset(strokeWidth, f3);
        path.arcTo(rectF3, f11, f6);
        path.lineTo(strokeWidth, strokeWidth);
        path.close();
        Path path2 = this.f;
        path2.reset();
        path2.moveTo(strokeWidth, strokeWidth);
        RectF rectF4 = new RectF(f10, f10, f9, f9);
        rectF4.offset(fMin, fMin);
        path2.arcTo(rectF4, 225.0f, f5);
        RectF rectF5 = new RectF(f8, f8, f7, f7);
        rectF5.offset(strokeWidth, f3);
        path2.arcTo(rectF5, f11, f6);
        path2.lineTo(strokeWidth, strokeWidth);
        path2.close();
        Path path3 = this.g;
        path3.reset();
        path3.moveTo(strokeWidth, strokeWidth);
        RectF rectF6 = new RectF(f8, f8, f7, f7);
        rectF6.offset(f3, strokeWidth);
        path3.arcTo(rectF6, 0.0f, f6);
        RectF rectF7 = new RectF(f10, f10, f9, f9);
        rectF7.offset(fMin, fMin);
        path3.arcTo(rectF7, f4, f5);
        path3.lineTo(strokeWidth, strokeWidth);
        path3.close();
    }

    public void setOriginalColor(int i) {
        this.h.setColor(i);
        invalidate();
    }
}
