package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oz0 {
    public final wz0[] a = new wz0[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final wz0 g = new wz0();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public oz0() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new wz0();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(mz0 mz0Var, float f, RectF rectF, tb0 tb0Var, Path path) {
        Matrix[] matrixArr;
        float[] fArr;
        int i;
        wz0[] wz0VarArr;
        Matrix[] matrixArr2;
        char c;
        float f2;
        char c2;
        int i2;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = this.c;
            fArr = this.h;
            wz0VarArr = this.a;
            matrixArr2 = this.b;
            c = 0;
            if (i3 >= 4) {
                break;
            }
            bp bpVar = i3 != 1 ? i3 != 2 ? i3 != 3 ? mz0Var.f : mz0Var.e : mz0Var.h : mz0Var.g;
            fc0 fc0Var = i3 != 1 ? i3 != 2 ? i3 != 3 ? mz0Var.b : mz0Var.a : mz0Var.d : mz0Var.c;
            wz0 wz0Var = wz0VarArr[i3];
            fc0Var.getClass();
            fc0Var.t(wz0Var, f, bpVar.a(rectF));
            int i4 = i3 + 1;
            float f3 = (i4 % 4) * 90;
            matrixArr2[i3].reset();
            PointF pointF = this.d;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f3);
            wz0 wz0Var2 = wz0VarArr[i2];
            fArr[0] = wz0Var2.b;
            fArr[1] = wz0Var2.c;
            matrixArr2[i2].mapPoints(fArr);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr[0], fArr[1]);
            matrixArr[i2].preRotate(f3);
            i3 = i4;
        }
        int i5 = 0;
        for (i = 4; i5 < i; i = 4) {
            wz0 wz0Var3 = wz0VarArr[i5];
            wz0Var3.getClass();
            fArr[c] = 0.0f;
            fArr[1] = wz0Var3.a;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 0) {
                path.moveTo(fArr[c], fArr[1]);
            } else {
                path.lineTo(fArr[c], fArr[1]);
            }
            wz0VarArr[i5].b(matrixArr2[i5], path);
            if (tb0Var != null) {
                wz0 wz0Var4 = wz0VarArr[i5];
                Matrix matrix = matrixArr2[i5];
                ik0 ik0Var = (ik0) tb0Var.c;
                f2 = 0.0f;
                BitSet bitSet = ik0Var.e;
                wz0Var4.getClass();
                bitSet.set(i5, (boolean) c);
                vz0[] vz0VarArr = ik0Var.c;
                wz0Var4.a(wz0Var4.e);
                vz0VarArr[i5] = new pz0(new ArrayList(wz0Var4.g), new Matrix(matrix));
            } else {
                f2 = 0.0f;
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            wz0 wz0Var5 = wz0VarArr[i5];
            fArr[0] = wz0Var5.b;
            fArr[1] = wz0Var5.c;
            matrixArr2[i5].mapPoints(fArr);
            wz0 wz0Var6 = wz0VarArr[i7];
            wz0Var6.getClass();
            float[] fArr2 = this.i;
            fArr2[0] = f2;
            fArr2[1] = wz0Var6.a;
            matrixArr2[i7].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr;
            wz0[] wz0VarArr2 = wz0VarArr;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, f2);
            wz0 wz0Var7 = wz0VarArr2[i5];
            fArr[0] = wz0Var7.b;
            fArr[1] = wz0Var7.c;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 1 || i5 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            wz0 wz0Var8 = this.g;
            wz0Var8.d(0.0f, 270.0f, 0.0f);
            (i5 != 1 ? i5 != 2 ? i5 != 3 ? mz0Var.j : mz0Var.i : mz0Var.l : mz0Var.k).getClass();
            wz0Var8.c(fMax, 0.0f);
            Path path4 = this.j;
            path4.reset();
            wz0Var8.b(matrixArr3[i5], path4);
            if (this.l && (b(path4, i5) || b(path4, i7))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = wz0Var8.a;
                matrixArr3[i5].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                wz0Var8.b(matrixArr3[i5], path2);
            } else {
                wz0Var8.b(matrixArr3[i5], path);
            }
            if (tb0Var != null) {
                Matrix matrix2 = matrixArr3[i5];
                ik0 ik0Var2 = (ik0) tb0Var.c;
                c2 = 0;
                ik0Var2.e.set(i5 + 4, false);
                vz0[] vz0VarArr2 = ik0Var2.d;
                wz0Var8.a(wz0Var8.e);
                vz0VarArr2[i5] = new pz0(new ArrayList(wz0Var8.g), new Matrix(matrix2));
            } else {
                c2 = 0;
            }
            i5 = i6;
            c = c2;
            wz0VarArr = wz0VarArr2;
            matrixArr = matrixArr3;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.k;
        path2.reset();
        this.a[i].b(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
