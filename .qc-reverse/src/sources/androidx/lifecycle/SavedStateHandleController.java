package androidx.lifecycle;

import defpackage.dg0;
import defpackage.gg0;
import defpackage.yf0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements dg0 {
    public boolean b;

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        if (yf0Var == yf0.ON_DESTROY) {
            this.b = false;
            gg0Var.p().f(this);
        }
    }
}
