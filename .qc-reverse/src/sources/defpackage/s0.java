package defpackage;

import android.view.animation.Animation;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Animation.AnimationListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ FrameLayout c;

    public /* synthetic */ s0(FrameLayout frameLayout, int i) {
        this.b = i;
        this.c = frameLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i = this.b;
        FrameLayout frameLayout = this.c;
        switch (i) {
            case 0:
                try {
                    g3 g3Var = (g3) frameLayout;
                    g3Var.b.removeView(g3Var);
                } catch (Exception unused) {
                    return;
                }
                break;
            default:
                try {
                    vg vgVar = (vg) frameLayout;
                    vgVar.b.removeView(vgVar);
                } catch (Exception unused2) {
                    return;
                }
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.b;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.b;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
