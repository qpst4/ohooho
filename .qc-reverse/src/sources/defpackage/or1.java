package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class or1 extends hp1 {
    private static final or1 zzb;
    private int zzd;
    private yq1 zze;

    static {
        or1 or1Var = new or1();
        zzb = or1Var;
        hp1.l(or1.class, or1Var);
    }

    public static /* synthetic */ void o(or1 or1Var, yq1 yq1Var) {
        or1Var.zze = yq1Var;
        or1Var.zzd |= 1;
    }

    public static nr1 p() {
        return (nr1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new or1();
        }
        if (i2 == 4) {
            return new nr1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
