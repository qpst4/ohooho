package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pe1 extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public pe1(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        qe1 qe1Var = new qe1();
        qe1Var.b = (VectorDrawable) this.a.newDrawable();
        return qe1Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        qe1 qe1Var = new qe1();
        qe1Var.b = (VectorDrawable) this.a.newDrawable(resources);
        return qe1Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        qe1 qe1Var = new qe1();
        qe1Var.b = (VectorDrawable) this.a.newDrawable(resources, theme);
        return qe1Var;
    }
}
