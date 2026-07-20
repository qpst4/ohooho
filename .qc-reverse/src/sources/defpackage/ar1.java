package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ar1 extends hp1 {
    private static final ar1 zzb;

    static {
        ar1 ar1Var = new ar1();
        zzb = ar1Var;
        hp1.l(ar1.class, ar1Var);
    }

    public static ar1 o() {
        return zzb;
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new ar1();
        }
        if (i2 == 4) {
            return new zq1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
