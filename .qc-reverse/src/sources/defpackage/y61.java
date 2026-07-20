package defpackage;

import android.view.MenuItem;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y61 implements w61, xk0 {
    public final /* synthetic */ z61 b;

    @Override // defpackage.xk0
    public boolean e(zk0 zk0Var, MenuItem menuItem) {
        return false;
    }

    @Override // defpackage.xk0
    public void n(zk0 zk0Var) {
        z61 z61Var = this.b;
        boolean zP = z61Var.a.a.p();
        Window.Callback callback = z61Var.b;
        if (zP) {
            callback.onPanelClosed(108, zk0Var);
        } else if (callback.onPreparePanel(0, null, zk0Var)) {
            callback.onMenuOpened(108, zk0Var);
        }
    }
}
