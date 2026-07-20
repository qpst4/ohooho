package defpackage;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n7 extends Animatable2.AnimationCallback {
    public final /* synthetic */ ak0 a;

    public n7(ak0 ak0Var) {
        this.a = ak0Var;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.a.b.p;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        ck0 ck0Var = this.a.b;
        ColorStateList colorStateList = ck0Var.p;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(ck0Var.t, colorStateList.getDefaultColor()));
        }
    }
}
