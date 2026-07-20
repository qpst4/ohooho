package defpackage;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mr extends ik0 {
    public static final /* synthetic */ int z = 0;
    public lr y;

    @Override // defpackage.ik0
    public final void f(Canvas canvas) {
        if (this.y.q.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        int i = Build.VERSION.SDK_INT;
        lr lrVar = this.y;
        if (i >= 26) {
            canvas.clipOutRect(lrVar.q);
        } else {
            canvas.clipRect(lrVar.q, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }

    @Override // defpackage.ik0, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.y = new lr(this.y);
        return this;
    }

    public final void o(float f, float f2, float f3, float f4) {
        RectF rectF = this.y.q;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }
}
