package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p2 {
    public final n3 a;
    public final int b;
    public final String c;
    public final String d;

    public p2(n3 n3Var, Integer num) {
        this.a = n3Var;
        this.b = num != null ? num.intValue() : n3Var.categoryId;
        this.c = lc1.K(n3Var.titleId).toLowerCase();
        this.d = lc1.K(n3Var.descriptionId).toLowerCase();
    }
}
