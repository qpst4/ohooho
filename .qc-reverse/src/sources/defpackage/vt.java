package defpackage;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vt extends f01 {
    public final /* synthetic */ f30 m;
    public final /* synthetic */ wt n;

    public vt(wt wtVar, f30 f30Var) {
        this.n = wtVar;
        this.m = f30Var;
    }

    @Override // defpackage.f01
    public final View F(int i) {
        f30 f30Var = this.m;
        if (f30Var.G()) {
            return f30Var.F(i);
        }
        Dialog dialog = this.n.j0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // defpackage.f01
    public final boolean G() {
        return this.m.G() || this.n.n0;
    }
}
