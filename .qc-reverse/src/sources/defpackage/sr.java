package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sr extends Drawable implements s60 {
    public final Paint b;
    public final Paint c;
    public final Paint d;
    public f91 e;

    public sr() {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(dn.i0);
        paint.setStrokeWidth(0.0f);
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setColor(dn.j0);
        paint2.setStrokeWidth(0.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setColor(dn.k0);
        paint3.setStrokeWidth(0.0f);
        paint3.setStyle(style);
    }

    public static void f(Canvas canvas, db dbVar, Paint paint) {
        canvas.drawRect(dbVar.d(), dbVar.e(), dbVar.f() + dbVar.d(), dbVar.c() + dbVar.e(), paint);
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.e == null;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        f91 f91Var = this.e;
        if (f91Var != null) {
            f(canvas, f91Var.h(), this.b);
            f(canvas, this.e.f(), this.c);
            f(canvas, this.e.c(), this.d);
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
