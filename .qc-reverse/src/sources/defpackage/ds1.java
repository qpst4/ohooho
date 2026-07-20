package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ds1 extends as1 {
    public final /* synthetic */ fs1 i;

    public ds1(fs1 fs1Var) {
        this.i = fs1Var;
    }

    @Override // defpackage.as1
    public final String b() {
        bs1 bs1Var = (bs1) this.i.b.get();
        return bs1Var == null ? "Completer object has been garbage collected, future will fail soon" : l11.j("tag=[", String.valueOf(bs1Var.a), "]");
    }
}
