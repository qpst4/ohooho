package defpackage;

import android.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dl0 implements ActionProvider.VisibilityListener {
    public tb0 a;
    public final ActionProvider b;

    public dl0(gl0 gl0Var, ActionProvider actionProvider) {
        this.b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        tb0 tb0Var = this.a;
        if (tb0Var != null) {
            zk0 zk0Var = ((cl0) tb0Var.c).n;
            zk0Var.h = true;
            zk0Var.p(true);
        }
    }
}
