package defpackage;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b60 extends Drawable implements s60 {
    public final CopyOnWriteArrayList b;
    public final Paint c;

    public b60(CopyOnWriteArrayList copyOnWriteArrayList, int i) {
        this.b = copyOnWriteArrayList;
        int iMax = Math.max(0, i);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(oq0.c((SharedPreferences) pn0.t().d, oq0.e0));
        paint.setStrokeWidth(iMax);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setPathEffect(new CornerPathEffect(paint.getStrokeWidth() * 2.0f));
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.b.size() == 0;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return !a();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        Path path = new Path();
        boolean z = true;
        for (t51 t51Var : this.b) {
            if (z) {
                path.moveTo(t51Var.a, t51Var.b);
                z = false;
            } else {
                path.lineTo(t51Var.a, t51Var.b);
            }
        }
        canvas.drawPath(path, this.c);
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
