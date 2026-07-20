package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mn0 implements gb1 {
    public final /* synthetic */ int b;

    public mn0(int i) {
        this.b = i;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        if (mc1Var.a() == Object.class) {
            return new nn0(i70Var, this.b);
        }
        return null;
    }
}
