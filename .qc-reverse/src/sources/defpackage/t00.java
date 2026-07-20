package defpackage;

import android.animation.Animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t00 extends ke {
    public final /* synthetic */ ExtendedFloatingActionButton g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t00(ExtendedFloatingActionButton extendedFloatingActionButton, sp1 sp1Var) {
        super(extendedFloatingActionButton, sp1Var);
        this.g = extendedFloatingActionButton;
    }

    @Override // defpackage.ke
    public final int c() {
        return R.animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override // defpackage.ke
    public final void e() {
        this.d.c = null;
        this.g.u = 0;
    }

    @Override // defpackage.ke
    public final void f(Animator animator) {
        sp1 sp1Var = this.d;
        Animator animator2 = (Animator) sp1Var.c;
        if (animator2 != null) {
            animator2.cancel();
        }
        sp1Var.c = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.u = 2;
    }

    @Override // defpackage.ke
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.setAlpha(1.0f);
        extendedFloatingActionButton.setScaleY(1.0f);
        extendedFloatingActionButton.setScaleX(1.0f);
    }

    @Override // defpackage.ke
    public final boolean h() {
        ej ejVar = ExtendedFloatingActionButton.J;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        int visibility = extendedFloatingActionButton.getVisibility();
        int i = extendedFloatingActionButton.u;
        if (visibility != 0) {
            if (i != 2) {
                return false;
            }
        } else if (i == 1) {
            return false;
        }
        return true;
    }
}
