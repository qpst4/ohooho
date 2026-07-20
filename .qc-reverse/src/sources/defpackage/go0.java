package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class go0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View b;
    public ViewTreeObserver c;
    public final Runnable d;

    public go0(View view, Runnable runnable) {
        this.b = view;
        this.c = view.getViewTreeObserver();
        this.d = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            zy.r("view == null");
            return;
        }
        go0 go0Var = new go0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(go0Var);
        view.addOnAttachStateChangeListener(go0Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.c.isAlive();
        View view = this.b;
        if (zIsAlive) {
            this.c.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.c.isAlive();
        View view2 = this.b;
        if (zIsAlive) {
            this.c.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
