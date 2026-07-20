package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ci0 extends hf0 implements k40 {
    public final /* synthetic */ int c;
    public final /* synthetic */ fg1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ci0(fg1 fg1Var, int i) {
        super(0);
        this.c = i;
        this.d = fg1Var;
    }

    @Override // defpackage.k40
    public final Object a() {
        int i = this.c;
        fg1 fg1Var = this.d;
        switch (i) {
            case 0:
                return new ei0((di0) fg1Var);
            default:
                return tk0.n(fg1Var);
        }
    }
}
