package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kg0 extends Drawable implements s60 {
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Paint g;
    public final long h;
    public float i = 1.0f;

    public kg0(int i, int i2, int i3, int i4, int i5, int i6) {
        this.h = System.currentTimeMillis() + ((long) i5);
        this.b = i3;
        this.c = i4;
        this.d = i3 - i;
        this.e = i4 - i2;
        this.f = i5;
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(pn0.t().x());
        paint.setStrokeWidth(Math.max(0, i6));
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setPathEffect(new CornerPathEffect(paint.getStrokeWidth() * 2.0f));
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.i <= 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return !a();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        float fCurrentTimeMillis = ((this.h - System.currentTimeMillis()) * 1.0f) / this.f;
        this.i = fCurrentTimeMillis;
        if (fCurrentTimeMillis <= 0.0f) {
            return;
        }
        Path path = new Path();
        int i = this.b;
        float f = this.d;
        float f2 = this.i;
        float f3 = i - (f * f2);
        int i2 = this.c;
        path.moveTo(f3, i2 - (this.e * f2));
        path.lineTo(i, i2);
        canvas.drawPath(path, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
