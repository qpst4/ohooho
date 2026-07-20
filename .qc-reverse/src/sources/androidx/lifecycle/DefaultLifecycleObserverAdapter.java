package androidx.lifecycle;

import defpackage.dg0;
import defpackage.gg0;
import defpackage.os;
import defpackage.ps;
import defpackage.yf0;
import defpackage.zy;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements dg0 {
    public final os b;
    public final dg0 c;

    public DefaultLifecycleObserverAdapter(os osVar, dg0 dg0Var) {
        this.b = osVar;
        this.c = dg0Var;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        int i = ps.a[yf0Var.ordinal()];
        if (i == 3) {
            this.b.a();
        } else if (i == 7) {
            zy.n("ON_ANY must not been send by anybody");
            return;
        }
        dg0 dg0Var = this.c;
        if (dg0Var != null) {
            dg0Var.c(gg0Var, yf0Var);
        }
    }
}
