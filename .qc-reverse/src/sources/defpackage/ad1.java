package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ad1 extends wx0 {
    public final ThreadLocal h;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public ad1(ep epVar, o31 o31Var) {
        bd1 bd1Var = bd1.b;
        super(epVar.i(bd1Var) == null ? epVar.h(bd1Var) : epVar, o31Var);
        this.h = new ThreadLocal();
        ep epVar2 = o31Var.c;
        epVar2.getClass();
        if (epVar2.i(ow0.d) instanceof hp) {
            return;
        }
        Object objV0 = lc1.v0(epVar, null);
        lc1.g0(epVar, objV0);
        Q(epVar, objV0);
    }

    public final boolean P() {
        boolean z = this.threadLocalIsSet && this.h.get() == null;
        this.h.remove();
        return !z;
    }

    public final void Q(ep epVar, Object obj) {
        this.threadLocalIsSet = true;
        this.h.set(new bp0(epVar, obj));
    }

    @Override // defpackage.wx0, defpackage.gd0
    public final void j(Object obj) {
        if (this.threadLocalIsSet) {
            bp0 bp0Var = (bp0) this.h.get();
            if (bp0Var != null) {
                lc1.g0((ep) bp0Var.b, bp0Var.c);
            }
            this.h.remove();
        }
        Object objG = xr.G(obj);
        o31 o31Var = this.g;
        ep epVar = o31Var.c;
        epVar.getClass();
        Object objV0 = lc1.v0(epVar, null);
        ad1 ad1VarQ = objV0 != lc1.m ? f01.Q(o31Var, epVar, objV0) : null;
        try {
            this.g.e(objG);
            if (ad1VarQ == null || ad1VarQ.P()) {
                lc1.g0(epVar, objV0);
            }
        } catch (Throwable th) {
            if (ad1VarQ == null || ad1VarQ.P()) {
                lc1.g0(epVar, objV0);
            }
            throw th;
        }
    }
}
