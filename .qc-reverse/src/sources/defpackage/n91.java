package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n91 extends s91 {
    public final o91 h;
    public int i;
    public int j;
    public final Paint k;

    public n91(o91 o91Var) {
        this.h = o91Var;
        Paint paint = new Paint();
        this.k = paint;
        paint.setColor(o91Var.a());
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.b == null;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return this.b != null;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        Paint paint;
        o91 o91Var;
        Iterator it = this.c.a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            paint = this.k;
            o91Var = this.h;
            if (!zHasNext) {
                break;
            }
            v91 v91Var = (v91) it.next();
            boolean z = v91Var.f;
            Drawable drawable = v91Var.j;
            if (z && drawable != null) {
                if (v91Var.k) {
                    drawable.mutate().setColorFilter(o91Var.b(), PorterDuff.Mode.SRC_IN);
                }
                drawable.setBounds((this.f - o91Var.c()) + this.i, (this.g - o91Var.c()) + this.j, o91Var.c() + this.f + this.i, o91Var.c() + this.g + this.j);
                canvas.drawCircle(this.f + this.i, this.g + this.j, o91Var.c() * 1.6f, paint);
                drawable.draw(canvas);
            }
        }
        for (v91 v91Var2 : this.c.b) {
            boolean z2 = v91Var2.f;
            Drawable drawable2 = v91Var2.j;
            if (z2 && drawable2 != null) {
                if (v91Var2.k) {
                    drawable2.mutate().setColorFilter(o91Var.b(), PorterDuff.Mode.SRC_IN);
                }
                drawable2.setBounds((this.f - o91Var.c()) + this.i, (this.g - o91Var.c()) + this.j, o91Var.c() + this.f + this.i, o91Var.c() + this.g + this.j);
                canvas.drawCircle(this.f + this.i, this.g + this.j, o91Var.c() * 1.6f, paint);
                drawable2.draw(canvas);
            }
        }
    }

    @Override // defpackage.s91
    public final void g(f91 f91Var, u91 u91Var, int i, int i2) {
        this.b = f91Var;
        this.c = u91Var;
        this.d = i;
        this.e = i2;
        this.f = i;
        this.g = i2;
        o91 o91Var = this.h;
        this.i = o91Var.d();
        this.j = o91Var.e() * (-1);
        if ((f91Var.h().f() / 2) + f91Var.h().d() > ey0.c() / 2) {
            this.i *= -1;
        }
        if ((f91Var.h().c() / 2) + f91Var.h().e() <= ey0.b() / 2) {
            this.j *= -1;
        }
    }
}
