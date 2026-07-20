package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v81 extends u81 {
    public final /* synthetic */ kb a;
    public final /* synthetic */ w81 b;

    public v81(w81 w81Var, kb kbVar) {
        this.b = w81Var;
        this.a = kbVar;
    }

    @Override // defpackage.s81
    public final void d(t81 t81Var) {
        ((ArrayList) this.a.get(this.b.c)).remove(t81Var);
        t81Var.x(this);
    }
}
