package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qz0 extends vz0 {
    public final sz0 c;

    public qz0(sz0 sz0Var) {
        this.c = sz0Var;
    }

    @Override // defpackage.vz0
    public final void a(Matrix matrix, kz0 kz0Var, int i, Canvas canvas) {
        sz0 sz0Var = this.c;
        float f = sz0Var.f;
        float f2 = sz0Var.g;
        RectF rectF = new RectF(sz0Var.b, sz0Var.c, sz0Var.d, sz0Var.e);
        Paint paint = kz0Var.b;
        boolean z = f2 < 0.0f;
        Path path = kz0Var.g;
        int[] iArr = kz0.k;
        if (z) {
            iArr[0] = 0;
            iArr[1] = kz0Var.f;
            iArr[2] = kz0Var.e;
            iArr[3] = kz0Var.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            iArr[0] = 0;
            iArr[1] = kz0Var.d;
            iArr[2] = kz0Var.e;
            iArr[3] = kz0Var.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / fWidth);
        float[] fArr = kz0.l;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, kz0Var.h);
        }
        canvas.drawArc(rectF, f, f2, true, paint);
        canvas.restore();
    }
}
