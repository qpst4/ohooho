package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bd1 implements cp, dp {
    public static final bd1 b = new bd1();

    @Override // defpackage.ep
    public final Object g(Object obj, z40 z40Var) {
        return z40Var.f(obj, this);
    }

    @Override // defpackage.ep
    public final ep h(ep epVar) {
        return xy0.t(this, epVar);
    }

    @Override // defpackage.ep
    public final cp i(dp dpVar) {
        dpVar.getClass();
        if (fc0.b(this, dpVar)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.ep
    public final ep m(dp dpVar) {
        dpVar.getClass();
        return fc0.b(this, dpVar) ? my.b : this;
    }

    @Override // defpackage.cp
    public final dp getKey() {
        return this;
    }
}
