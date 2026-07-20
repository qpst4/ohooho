package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class er1 extends hp1 {
    private static final er1 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private long zzh;

    static {
        er1 er1Var = new er1();
        zzb = er1Var;
        hp1.l(er1.class, er1Var);
    }

    public static /* synthetic */ void o(er1 er1Var, int i) {
        er1Var.zzd |= 4;
        er1Var.zzg = i;
    }

    public static /* synthetic */ void p(er1 er1Var, long j) {
        er1Var.zzd |= 8;
        er1Var.zzh = j;
    }

    public static /* synthetic */ void q(er1 er1Var, String str) {
        str.getClass();
        er1Var.zzd |= 2;
        er1Var.zzf = str;
    }

    public static /* synthetic */ void r(er1 er1Var, String str) {
        str.getClass();
        er1Var.zzd |= 1;
        er1Var.zze = str;
    }

    public static dr1 s() {
        return (dr1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new er1();
        }
        if (i2 == 4) {
            return new dr1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
