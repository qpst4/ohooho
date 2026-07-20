package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q7 extends Drawable.ConstantState {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public q7(tg tgVar) {
        this.b = tgVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).getChangingConfigurations();
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.a) {
            case 0:
                r7 r7Var = new r7(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources);
                r7Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(r7Var.g);
                return r7Var;
            default:
                return super.newDrawable(resources);
        }
    }

    public q7(Drawable.ConstantState constantState) {
        this.b = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                r7 r7Var = new r7(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) obj).newDrawable();
                r7Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(r7Var.g);
                return r7Var;
            default:
                return (tg) obj;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.a) {
            case 0:
                r7 r7Var = new r7(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources, theme);
                r7Var.b = drawableNewDrawable;
                drawableNewDrawable.setCallback(r7Var.g);
                return r7Var;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
