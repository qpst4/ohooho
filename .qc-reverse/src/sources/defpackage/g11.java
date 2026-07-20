package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g11 extends View {
    public final Paint b;
    public final Paint c;
    public final Rect d;
    public int e;
    public int f;
    public final Path g;
    public Bitmap h;
    public final Path i;
    public final Paint j;
    public float k;

    public g11(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
        this.c = fp1.r(context);
        this.b = fp1.s(context);
        this.j = fp1.s(context);
        Path path = new Path();
        path.addCircle(0.0f, 0.0f, TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), Path.Direction.CW);
        this.i = path;
        this.g = new Path();
    }

    public abstract int b(float f);

    public abstract Bitmap c(int i, int i2);

    public abstract void d(float f);

    public final void e() {
        int i;
        int i2 = this.e;
        if (i2 <= 0 || (i = this.f) <= 0) {
            return;
        }
        this.h = c(i2, i);
        this.j.setColor(b(this.k));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.c;
        Path path = this.g;
        canvas.drawPath(path, paint);
        canvas.drawBitmap(this.h, (Rect) null, this.d, (Paint) null);
        canvas.drawPath(path, this.b);
        canvas.save();
        int i = this.e;
        int i2 = this.f;
        boolean z = i > i2;
        float f = this.k;
        if (z) {
            canvas.translate(i * f, i2 / 2);
        } else {
            canvas.translate(i / 2, (1.0f - f) * i2);
        }
        canvas.drawPath(this.i, this.j);
        canvas.restore();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.d.set(0, 0, i, i2);
        float strokeWidth = this.b.getStrokeWidth() / 2.0f;
        Path path = this.g;
        path.reset();
        path.addRect(new RectF(strokeWidth, strokeWidth, i - strokeWidth, i2 - strokeWidth), Path.Direction.CW);
        e();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 2) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.e;
        int i2 = this.f;
        float fMax = Math.max(0.0f, Math.min(1.0f, i > i2 ? x / i : 1.0f - (y / i2)));
        this.k = fMax;
        this.j.setColor(b(fMax));
        d(this.k);
        invalidate();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setPos(float f) {
        this.k = f;
        this.j.setColor(b(f));
    }
}
