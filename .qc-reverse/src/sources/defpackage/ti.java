package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ti implements Runnable {
    public final /* synthetic */ ui b;
    public final /* synthetic */ cl0 c;
    public final /* synthetic */ zk0 d;
    public final /* synthetic */ sp1 e;

    public ti(sp1 sp1Var, ui uiVar, cl0 cl0Var, zk0 zk0Var) {
        this.e = sp1Var;
        this.b = uiVar;
        this.c = cl0Var;
        this.d = zk0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        vi viVar = (vi) this.e.c;
        ui uiVar = this.b;
        if (uiVar != null) {
            viVar.A = true;
            uiVar.b.c(false);
            viVar.A = false;
        }
        cl0 cl0Var = this.c;
        if (cl0Var.isEnabled() && cl0Var.hasSubMenu()) {
            this.d.q(cl0Var, null, 4);
        }
    }
}
