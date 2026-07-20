package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v10 implements TypeEvaluator {
    public final float[] a = new float[9];
    public final float[] b = new float[9];
    public final Matrix c = new Matrix();
    public final /* synthetic */ b20 d;

    public v10(b20 b20Var) {
        this.d = b20Var;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        this.d.o = f;
        float[] fArr = this.a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i = 0; i < 9; i++) {
            float f2 = fArr2[i];
            float f3 = fArr[i];
            fArr2[i] = ((f2 - f3) * f) + f3;
        }
        Matrix matrix = this.c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
