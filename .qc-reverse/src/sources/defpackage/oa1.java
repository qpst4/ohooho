package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oa1 implements ea1 {
    public Path b;
    public Paint c;
    public Paint d;
    public Paint e;
    public Rect f;
    public int g;
    public int h;

    @Override // defpackage.s60
    public final boolean a() {
        return false;
    }

    @Override // defpackage.ea1
    public final void b() {
        this.h = 0;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return false;
    }

    @Override // defpackage.s60
    public final void draw(Canvas canvas) {
        canvas.translate(0.0f, this.h);
        canvas.drawRect(this.f, this.e);
        Paint paint = this.d;
        if (paint.getStrokeWidth() > 0.0f) {
            canvas.drawPath(this.b, paint);
        }
        canvas.drawPath(this.b, this.c);
        canvas.translate(0.0f, -this.h);
    }

    @Override // defpackage.ea1
    public final void e(Integer num) {
        this.h = 0;
        this.h = num.intValue() - this.g;
    }

    @Override // defpackage.ea1
    public final void d(float f) {
    }
}
