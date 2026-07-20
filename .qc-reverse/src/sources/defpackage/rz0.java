package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rz0 extends vz0 {
    public final tz0 c;
    public final float d;
    public final float e;

    public rz0(tz0 tz0Var, float f, float f2) {
        this.c = tz0Var;
        this.d = f;
        this.e = f2;
    }

    @Override // defpackage.vz0
    public final void a(Matrix matrix, kz0 kz0Var, int i, Canvas canvas) {
        tz0 tz0Var = this.c;
        float f = tz0Var.c;
        float f2 = this.e;
        float f3 = tz0Var.b;
        float f4 = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = this.a;
        matrix2.set(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(b());
        kz0Var.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i2 = kz0Var.f;
        int[] iArr = kz0.i;
        iArr[0] = i2;
        iArr[1] = kz0Var.e;
        iArr[2] = kz0Var.d;
        Paint paint = kz0Var.c;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, kz0.j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        tz0 tz0Var = this.c;
        return (float) Math.toDegrees(Math.atan((tz0Var.c - this.e) / (tz0Var.b - this.d)));
    }
}
