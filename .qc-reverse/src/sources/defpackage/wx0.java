package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class wx0 extends l implements op {
    public final o31 g;

    public wx0(ep epVar, o31 o31Var) {
        super(epVar, true);
        this.g = o31Var;
    }

    @Override // defpackage.gd0
    public final boolean A() {
        return true;
    }

    @Override // defpackage.op
    public final op c() {
        o31 o31Var = this.g;
        if (o31Var != null) {
            return o31Var;
        }
        return null;
    }

    @Override // defpackage.gd0
    public void f(Object obj) {
        xr.H(fp1.q(this.g), xr.G(obj));
    }

    @Override // defpackage.gd0
    public void j(Object obj) {
        this.g.e(xr.G(obj));
    }
}
