package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class us implements Animation.AnimationListener {
    public final /* synthetic */ v11 b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ View d;
    public final /* synthetic */ vs e;

    public us(v11 v11Var, ViewGroup viewGroup, View view, vs vsVar) {
        this.b = v11Var;
        this.c = viewGroup;
        this.d = view;
        this.e = vsVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.c.post(new nc(3, this));
        if (y30.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.b + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (y30.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.b + " has reached onAnimationStart.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
