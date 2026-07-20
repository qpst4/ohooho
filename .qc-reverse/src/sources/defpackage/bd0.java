package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bd0 extends gd0 {
    public final boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd0() {
        super(true);
        boolean z = true;
        y(null);
        zj zjVarU = u();
        ak akVar = zjVarU instanceof ak ? (ak) zjVarU : null;
        if (akVar == null) {
            z = false;
            break;
        }
        gd0 gd0VarP = akVar.p();
        while (!gd0VarP.s()) {
            zj zjVarU2 = gd0VarP.u();
            ak akVar2 = zjVarU2 instanceof ak ? (ak) zjVarU2 : null;
            if (akVar2 == null) {
                z = false;
                break;
            }
            gd0VarP = akVar2.p();
        }
        this.f = z;
    }

    @Override // defpackage.gd0
    public final boolean s() {
        return this.f;
    }
}
