package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cr1 extends hp1 {
    private static final cr1 zzb;
    private int zzd;
    private int zzf;
    private yq1 zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private jp1 zzg = ip1.f;
    private kp1 zzh = bq1.f;

    static {
        cr1 cr1Var = new cr1();
        zzb = cr1Var;
        hp1.l(cr1.class, cr1Var);
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", qo1.f, "zzg", qo1.e, "zzh", mr1.class, "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new cr1();
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
