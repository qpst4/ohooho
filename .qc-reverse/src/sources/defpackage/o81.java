package defpackage;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o81 extends Drawable implements s60 {
    public static final PorterDuffXfermode k = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    public final n81 b;
    public final Paint c;
    public final Paint d;
    public final CopyOnWriteArrayList e;
    public final int f;
    public final int g;
    public final int h;
    public t51 i;
    public t51 j;

    public o81(int i) {
        int iR;
        pn0 pn0VarT = pn0.t();
        pn0VarT.getClass();
        try {
            iR = qq0.r(oq0.d((SharedPreferences) pn0VarT.d, oq0.b0));
        } catch (Exception unused) {
            iR = qq0.r((String) oq0.b0.b);
        }
        int iR2 = l11.r(iR);
        this.b = iR2 != 1 ? iR2 != 2 ? null : new n81(dn.o1, dn.p1, dn.k1, dn.l1) : new n81(dn.m1, dn.n1, dn.i1, dn.j1);
        this.f = oq0.c((SharedPreferences) pn0.t().d, oq0.d0);
        this.h = oq0.c((SharedPreferences) pn0.t().d, oq0.c0);
        this.g = Math.max(0, i);
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.e = new CopyOnWriteArrayList();
        this.i = null;
        this.j = null;
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.e.size() == 0;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return !a();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        long jCurrentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<t51> copyOnWriteArrayList = this.e;
        long j = jCurrentTimeMillis - ((t51) copyOnWriteArrayList.get(0)).c;
        int i = this.f;
        if (j > i) {
            copyOnWriteArrayList.remove(0);
        }
        t51 t51Var = null;
        for (t51 t51Var2 : copyOnWriteArrayList) {
            if (t51Var != null) {
                float f = 1.0f - (((jCurrentTimeMillis - t51Var2.c) * 1.0f) / i);
                if (f > 0.0f) {
                    float f2 = this.g * f;
                    int iE = i1.e(this.h, f);
                    Paint paint = this.d;
                    PorterDuffXfermode porterDuffXfermode = k;
                    paint.setXfermode(porterDuffXfermode);
                    float f3 = f2 / 2.0f;
                    canvas2.drawCircle(t51Var.a, t51Var.b, f3, paint);
                    paint.setXfermode(null);
                    paint.setColor(iE);
                    canvas2.drawCircle(t51Var.a, t51Var.b, f3, paint);
                    Paint paint2 = this.c;
                    paint2.setStrokeWidth(f2);
                    paint2.setXfermode(porterDuffXfermode);
                    canvas2.drawLine(t51Var.a, t51Var.b, t51Var2.a, t51Var2.b, paint2);
                    paint2.setXfermode(null);
                    paint2.setColor(iE);
                    canvas.drawLine(t51Var.a, t51Var.b, t51Var2.a, t51Var2.b, paint2);
                }
            }
            canvas2 = canvas;
            t51Var = t51Var2;
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
