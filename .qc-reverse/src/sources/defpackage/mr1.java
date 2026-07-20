package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mr1 extends hp1 {
    private static final mr1 zzb;
    private int zzd;
    private int zzf;
    private kp1 zze = bq1.f;
    private String zzg = "";

    static {
        mr1 mr1Var = new mr1();
        zzb = mr1Var;
        hp1.l(mr1.class, mr1Var);
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new mr1();
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
