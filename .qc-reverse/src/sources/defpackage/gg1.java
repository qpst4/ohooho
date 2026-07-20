package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gg1 extends no {
    public ek0 a;

    @Override // defpackage.no
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        r(coordinatorLayout, view, i);
        if (this.a == null) {
            this.a = new ek0(view);
        }
        ek0 ek0Var = this.a;
        View view2 = ek0Var.b;
        ek0Var.c = view2.getTop();
        ek0Var.d = view2.getLeft();
        ek0 ek0Var2 = this.a;
        View view3 = ek0Var2.b;
        int top = 0 - (view3.getTop() - ek0Var2.c);
        WeakHashMap weakHashMap = uf1.a;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - ek0Var2.d));
        return true;
    }

    public void r(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.q(view, i);
    }
}
