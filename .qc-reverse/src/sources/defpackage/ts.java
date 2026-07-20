package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ts extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ v11 d;
    public final /* synthetic */ vs e;

    public ts(ViewGroup viewGroup, View view, boolean z, v11 v11Var, vs vsVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = v11Var;
        this.e = vsVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.a;
        View view = this.b;
        viewGroup.endViewTransition(view);
        boolean z = this.c;
        v11 v11Var = this.d;
        if (z) {
            qq0.a(view, v11Var.a);
        }
        this.e.d();
        if (y30.I(2)) {
            Log.v("FragmentManager", "Animator from operation " + v11Var + " has ended.");
        }
    }
}
