package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ir1 extends hp1 {
    private static final ir1 zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        ir1 ir1Var = new ir1();
        zzb = ir1Var;
        hp1.l(ir1.class, ir1Var);
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", qo1.h, "zzf"});
        }
        if (i2 == 3) {
            return new ir1();
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
