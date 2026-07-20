package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y81 extends u81 {
    public final /* synthetic */ int a = 1;
    public t81 b;

    public y81(t81 t81Var) {
        this.b = t81Var;
    }

    @Override // defpackage.u81, defpackage.s81
    public void a(t81 t81Var) {
        switch (this.a) {
            case 1:
                rc rcVar = (rc) this.b;
                if (!rcVar.F) {
                    rcVar.G();
                    rcVar.F = true;
                }
                break;
        }
    }

    @Override // defpackage.s81
    public final void d(t81 t81Var) {
        switch (this.a) {
            case 0:
                this.b.z();
                t81Var.x(this);
                break;
            default:
                rc rcVar = (rc) this.b;
                int i = rcVar.E - 1;
                rcVar.E = i;
                if (i == 0) {
                    rcVar.F = false;
                    rcVar.m();
                }
                t81Var.x(this);
                break;
        }
    }

    public /* synthetic */ y81() {
    }
}
