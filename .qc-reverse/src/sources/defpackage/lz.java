package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class lz implements gb1 {
    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Class clsA = mc1Var.a();
        if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
            return null;
        }
        if (!clsA.isEnum()) {
            clsA = clsA.getSuperclass();
        }
        return new mz(clsA);
    }
}
