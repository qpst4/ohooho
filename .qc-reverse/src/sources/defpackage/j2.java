package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j2 implements e4, w2 {
    public final /* synthetic */ r2 b;

    public /* synthetic */ j2(r2 r2Var) {
        this.b = r2Var;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.b.J0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.w2
    public void g(n3 n3Var, Boolean bool) {
        k3 k3Var = n3Var.actionTypePickedInterceptor;
        r2 r2Var = this.b;
        if (k3Var != null) {
            k3Var.c(r2Var, n3Var, bool.booleanValue(), null);
        } else {
            b61.b(new k2(r2Var, 0, n3Var), 200L);
        }
    }
}
