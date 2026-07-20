package defpackage;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ro implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ CoordinatorLayout b;

    public ro(CoordinatorLayout coordinatorLayout) {
        this.b = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.b.p(0);
        return true;
    }
}
