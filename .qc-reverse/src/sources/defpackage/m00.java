package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m00 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;
    public final /* synthetic */ n00 d;
    public final /* synthetic */ ExpandableBehavior e;

    public m00(ExpandableBehavior expandableBehavior, View view, int i, n00 n00Var) {
        this.e = expandableBehavior;
        this.b = view;
        this.c = i;
        this.d = n00Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.b;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.e;
        if (expandableBehavior.a == this.c) {
            Object obj = this.d;
            expandableBehavior.r((View) obj, view, ((FloatingActionButton) obj).p.a, false);
        }
        return false;
    }
}
