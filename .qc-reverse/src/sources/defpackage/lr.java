package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lr extends hk0 {
    public final RectF q;

    public lr(lr lrVar) {
        super(lrVar);
        this.q = lrVar.q;
    }

    @Override // defpackage.hk0, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        mr mrVar = new mr(this);
        mrVar.y = this;
        mrVar.invalidateSelf();
        return mrVar;
    }

    public lr(mz0 mz0Var, RectF rectF) {
        super(mz0Var);
        this.q = rectF;
    }
}
