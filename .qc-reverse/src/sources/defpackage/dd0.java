package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dd0 extends cd0 {
    public final gd0 h;
    public final ed0 i;
    public final ak j;
    public final Object k;

    public dd0(gd0 gd0Var, ed0 ed0Var, ak akVar, Object obj) {
        this.h = gd0Var;
        this.i = ed0Var;
        this.j = akVar;
        this.k = obj;
    }

    @Override // defpackage.cd0
    public final void q(Throwable th) {
        ak akVarC = gd0.C(this.j);
        gd0 gd0Var = this.h;
        ed0 ed0Var = this.i;
        Object obj = this.k;
        if (akVarC != null) {
            while (i1.B(akVarC.h, false, new dd0(gd0Var, ed0Var, akVarC, obj), 1) == xm0.a) {
                akVarC = gd0.C(akVarC);
                if (akVarC == null) {
                }
            }
            return;
        }
        gd0Var.f(gd0Var.q(ed0Var, obj));
    }
}
