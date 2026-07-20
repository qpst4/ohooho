package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hp extends m implements cp {
    public static final gp c = new gp(ow0.d, fp.d);

    public hp() {
        super(ow0.d);
    }

    @Override // defpackage.m, defpackage.ep
    public final cp i(dp dpVar) {
        cp cpVar;
        dpVar.getClass();
        if (dpVar instanceof gp) {
            gp gpVar = (gp) dpVar;
            dp dpVar2 = this.b;
            if ((dpVar2 == gpVar || gpVar.c == dpVar2) && (cpVar = (cp) gpVar.b.g(this)) != null) {
                return cpVar;
            }
        } else if (ow0.d == dpVar) {
            return this;
        }
        return null;
    }

    @Override // defpackage.m, defpackage.ep
    public final ep m(dp dpVar) {
        dpVar.getClass();
        if (dpVar instanceof gp) {
            gp gpVar = (gp) dpVar;
            dp dpVar2 = this.b;
            if ((dpVar2 != gpVar && gpVar.c != dpVar2) || ((cp) gpVar.b.g(this)) == null) {
                return this;
            }
        } else if (ow0.d != dpVar) {
            return this;
        }
        return my.b;
    }

    public abstract void q(ep epVar, Runnable runnable);

    public boolean r() {
        return !(this instanceof zc1);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + xr.p(this);
    }
}
