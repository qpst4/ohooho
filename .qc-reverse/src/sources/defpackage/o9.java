package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o9 extends b30 {
    public final /* synthetic */ v9 k;
    public final /* synthetic */ y9 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o9(y9 y9Var, y9 y9Var2, v9 v9Var) {
        super(y9Var2);
        this.l = y9Var;
        this.k = v9Var;
    }

    @Override // defpackage.b30
    public final n01 b() {
        return this.k;
    }

    @Override // defpackage.b30
    public final boolean c() {
        y9 y9Var = this.l;
        if (y9Var.getInternalPopup().b()) {
            return true;
        }
        y9Var.g.m(y9Var.getTextDirection(), y9Var.getTextAlignment());
        return true;
    }
}
