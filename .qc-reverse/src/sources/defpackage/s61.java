package defpackage;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s61 implements d2, xk0 {
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ s61(Toolbar toolbar) {
        this.b = toolbar;
    }

    @Override // defpackage.xk0
    public boolean e(zk0 zk0Var, MenuItem menuItem) {
        return false;
    }

    @Override // defpackage.xk0
    public void n(zk0 zk0Var) {
        Toolbar toolbar = this.b;
        a2 a2Var = toolbar.b.u;
        if (a2Var == null || !a2Var.h()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.H.e).iterator();
            while (it.hasNext()) {
                ((s30) it.next()).a.t();
            }
        }
        y61 y61Var = toolbar.P;
        if (y61Var != null) {
            y61Var.n(zk0Var);
        }
    }
}
