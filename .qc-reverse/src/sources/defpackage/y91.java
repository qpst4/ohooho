package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y91 extends Drawable implements s60 {
    public final Paint b;
    public final Paint c;
    public f91 d;
    public q91 e;
    public u91 f;
    public int g;
    public int h;
    public final Path i = new Path();
    public final Path j = new Path();
    public final RectF k = new RectF();
    public final RectF l = new RectF();
    public final RectF m = new RectF();

    public y91() {
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.d == null;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return this.d != null;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        boolean z;
        RectF rectF;
        float f;
        float f2;
        u91 u91Var = this.f;
        float f3 = u91Var.d;
        float f4 = u91Var.e;
        float f5 = u91Var.f;
        float f6 = this.g;
        float f7 = this.h;
        RectF rectF2 = this.k;
        rectF2.set(f6 - f3, f7 - f3, f6 + f3, f7 + f3);
        float f8 = this.g;
        float f9 = this.h;
        RectF rectF3 = this.l;
        rectF3.set(f8 - f4, f9 - f4, f8 + f4, f9 + f4);
        float f10 = this.g;
        float f11 = this.h;
        RectF rectF4 = this.m;
        rectF4.set(f10 - f5, f11 - f5, f10 + f5, f11 + f5);
        float fD = this.e.d();
        float f12 = ((f4 - f3) / 2.0f) + f3;
        float f13 = ((f5 - f4) / 2.0f) + f4;
        Iterator it = this.f.a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            paint = this.c;
            paint2 = this.b;
            z = false;
            if (!zHasNext) {
                break;
            }
            v91 v91Var = (v91) it.next();
            Path path = this.i;
            path.reset();
            float f14 = v91Var.a;
            float f15 = v91Var.c;
            Iterator it2 = it;
            Drawable drawable = v91Var.j;
            path.arcTo(rectF3, f14, f15, false);
            path.arcTo(rectF2, v91Var.b, -f15, false);
            path.close();
            canvas.drawPath(path, paint2);
            canvas.drawPath(path, paint);
            if (drawable != null) {
                double d = f12;
                int i = (int) ((v91Var.h * d) + ((double) this.g));
                f = fD;
                f2 = f12;
                int i2 = (int) ((v91Var.i * d) + ((double) this.h));
                if (v91Var.k) {
                    drawable.mutate().setColorFilter(this.e.c(), PorterDuff.Mode.SRC_IN);
                }
                float f16 = i;
                float f17 = i2;
                drawable.setBounds((int) (f16 - f), (int) (f17 - f), (int) (f16 + f), (int) (f17 + f));
                drawable.draw(canvas);
            } else {
                f = fD;
                f2 = f12;
            }
            it = it2;
            fD = f;
            f12 = f2;
        }
        float f18 = fD;
        for (v91 v91Var2 : this.f.b) {
            Path path2 = this.j;
            path2.reset();
            float f19 = v91Var2.a;
            float f20 = v91Var2.c;
            Drawable drawable2 = v91Var2.j;
            path2.arcTo(rectF4, f19, f20, z);
            path2.arcTo(rectF3, v91Var2.b, -f20, z);
            path2.close();
            canvas.drawPath(path2, paint2);
            canvas.drawPath(path2, paint);
            if (drawable2 != null) {
                double d2 = f13;
                int i3 = (int) ((v91Var2.h * d2) + ((double) this.g));
                rectF = rectF3;
                int i4 = (int) ((v91Var2.i * d2) + ((double) this.h));
                if (v91Var2.k) {
                    drawable2.mutate().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
                float f21 = i3;
                float f22 = i4;
                drawable2.setBounds((int) (f21 - f18), (int) (f22 - f18), (int) (f21 + f18), (int) (f22 + f18));
                drawable2.draw(canvas);
            } else {
                rectF = rectF3;
            }
            rectF3 = rectF;
            z = false;
        }
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
