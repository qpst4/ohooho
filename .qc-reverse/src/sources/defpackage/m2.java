package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m2 implements y31 {
    public final /* synthetic */ l2 b;
    public final /* synthetic */ r2 c;

    public m2(r2 r2Var, l2 l2Var) {
        this.c = r2Var;
        this.b = l2Var;
    }

    @Override // defpackage.x31
    public final void n(b41 b41Var) {
        r2 r2Var = this.c;
        if (r2Var.A0) {
            return;
        }
        for (int i = 0; i < r2Var.r0.d.size(); i++) {
            if (((p2) r2Var.r0.d.get(i)).b == b41Var.a.intValue()) {
                l2 l2Var = this.b;
                l2Var.a = i;
                r2Var.s0.C0(l2Var);
                return;
            }
        }
    }
}
