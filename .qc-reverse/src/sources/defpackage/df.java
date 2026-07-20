package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class df {
    public int a;
    public String b;

    public static jl1 a() {
        jl1 jl1Var = new jl1();
        jl1Var.c = "";
        return jl1Var;
    }

    public final String toString() {
        int i = this.a;
        int i2 = pn1.a;
        ym1 ym1Var = om1.d;
        Integer numValueOf = Integer.valueOf(i);
        return "Response Code: " + (!ym1Var.containsKey(numValueOf) ? om1.c : (om1) ym1Var.get(numValueOf)).toString() + ", Debug Message: " + this.b;
    }
}
