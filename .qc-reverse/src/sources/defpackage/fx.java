package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fx extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public boolean b;
    public final /* synthetic */ Object c;

    public fx(k10 k10Var) {
        this.a = 2;
        this.c = k10Var;
        this.b = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 2:
                this.b = true;
                break;
            case 3:
                this.b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                super.onAnimationEnd(animator);
                EdgeBarConstraintLayout edgeBarConstraintLayout = (EdgeBarConstraintLayout) obj;
                boolean z = this.b;
                xr.I(edgeBarConstraintLayout, z);
                if (!z) {
                    edgeBarConstraintLayout.setVisibility(8);
                }
                break;
            case 1:
                if (!this.b) {
                    ((View) obj).setVisibility(4);
                }
                break;
            case 2:
                k10 k10Var = (k10) obj;
                if (this.b) {
                    this.b = false;
                } else if (((Float) k10Var.z.getAnimatedValue()).floatValue() != 0.0f) {
                    k10Var.A = 2;
                    k10Var.s.invalidate();
                } else {
                    k10Var.A = 0;
                    k10Var.j(0);
                }
                break;
            default:
                b20 b20Var = (b20) obj;
                b20Var.q = 0;
                b20Var.l = null;
                if (!this.b) {
                    b20Var.r.a(4, false);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 1:
                if (this.b) {
                    ((View) obj).setVisibility(0);
                }
                break;
            case 2:
            default:
                super.onAnimationStart(animator);
                break;
            case 3:
                b20 b20Var = (b20) obj;
                b20Var.r.a(0, false);
                b20Var.q = 1;
                b20Var.l = animator;
                this.b = false;
                break;
        }
    }

    public fx(EdgeBarConstraintLayout edgeBarConstraintLayout, boolean z) {
        this.a = 0;
        this.c = edgeBarConstraintLayout;
        this.b = z;
    }

    public fx(b20 b20Var) {
        this.a = 3;
        this.c = b20Var;
    }

    public fx(View view, boolean z) {
        this.a = 1;
        this.b = z;
        this.c = view;
    }
}
