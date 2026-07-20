package defpackage;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x10 implements TypeEvaluator {
    public FloatEvaluator a;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        float fFloatValue = this.a.evaluate(f, (Number) obj, (Number) obj2).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
