package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cd0 extends hi0 implements lu, xa0 {
    public gd0 g;

    @Override // defpackage.xa0
    public final boolean a() {
        return true;
    }

    @Override // defpackage.lu
    public final void b() {
        p().I(this);
    }

    @Override // defpackage.xa0
    public final wm0 d() {
        return null;
    }

    public final gd0 p() {
        gd0 gd0Var = this.g;
        if (gd0Var != null) {
            return gd0Var;
        }
        fc0.S("job");
        throw null;
    }

    public abstract void q(Throwable th);

    @Override // defpackage.hi0
    public final String toString() {
        return getClass().getSimpleName() + '@' + xr.p(this) + "[job@" + xr.p(p()) + ']';
    }
}
