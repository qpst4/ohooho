package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lr1 extends hp1 {
    private static final lr1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private er1 zzg;
    private fr1 zzh;

    static {
        lr1 lr1Var = new lr1();
        zzb = lr1Var;
        hp1.l(lr1.class, lr1Var);
    }

    public static /* synthetic */ void o(lr1 lr1Var, sq1 sq1Var) {
        lr1Var.zzf = sq1Var;
        lr1Var.zze = 2;
    }

    public static /* synthetic */ void p(lr1 lr1Var, wq1 wq1Var) {
        lr1Var.zzf = wq1Var;
        lr1Var.zze = 3;
    }

    public static /* synthetic */ void q(lr1 lr1Var, ar1 ar1Var) {
        ar1Var.getClass();
        lr1Var.zzf = ar1Var;
        lr1Var.zze = 7;
    }

    public static /* synthetic */ void r(lr1 lr1Var, er1 er1Var) {
        er1Var.getClass();
        lr1Var.zzg = er1Var;
        lr1Var.zzd |= 1;
    }

    public static /* synthetic */ void s(lr1 lr1Var, or1 or1Var) {
        lr1Var.zzf = or1Var;
        lr1Var.zze = 8;
    }

    public static /* synthetic */ void t(lr1 lr1Var, pr1 pr1Var) {
        lr1Var.zzf = pr1Var;
        lr1Var.zze = 4;
    }

    public static kr1 u() {
        return (kr1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", sq1.class, wq1.class, pr1.class, cr1.class, "zzh", ar1.class, or1.class});
        }
        if (i2 == 3) {
            return new lr1();
        }
        if (i2 == 4) {
            return new kr1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
