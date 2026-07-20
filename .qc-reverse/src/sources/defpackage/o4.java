package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o4 implements bp {
    public final bp a;
    public final float b;

    public o4(float f, bp bpVar) {
        while (bpVar instanceof o4) {
            bpVar = ((o4) bpVar).a;
            f += ((o4) bpVar).b;
        }
        this.a = bpVar;
        this.b = f;
    }

    @Override // defpackage.bp
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o4)) {
            return false;
        }
        o4 o4Var = (o4) obj;
        return this.a.equals(o4Var.a) && this.b == o4Var.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
