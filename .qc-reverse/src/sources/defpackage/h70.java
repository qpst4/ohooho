package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class h70 extends fz0 {
    public fb1 a = null;

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        fb1 fb1Var = this.a;
        if (fb1Var != null) {
            return fb1Var.b(vd0Var);
        }
        s1.f("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) {
        fb1 fb1Var = this.a;
        if (fb1Var != null) {
            fb1Var.c(ae0Var, obj);
        } else {
            s1.f("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    @Override // defpackage.fz0
    public final fb1 d() {
        fb1 fb1Var = this.a;
        if (fb1Var != null) {
            return fb1Var;
        }
        s1.f("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }
}
