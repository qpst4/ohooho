package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z10 extends a20 {
    public final /* synthetic */ int e;
    public final /* synthetic */ d20 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z10(d20 d20Var, int i) {
        super(d20Var);
        this.e = i;
        this.f = d20Var;
    }

    @Override // defpackage.a20
    public final float a() {
        float f;
        float f2;
        int i = this.e;
        d20 d20Var = this.f;
        switch (i) {
            case 0:
                f = d20Var.h;
                f2 = d20Var.i;
                break;
            case 1:
                f = d20Var.h;
                f2 = d20Var.j;
                break;
            default:
                return d20Var.h;
        }
        return f + f2;
    }
}
