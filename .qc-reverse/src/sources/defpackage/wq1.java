package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wq1 extends hp1 {
    private static final wq1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        wq1 wq1Var = new wq1();
        zzb = wq1Var;
        hp1.l(wq1.class, wq1Var);
    }

    public static /* synthetic */ void o(wq1 wq1Var, rr1 rr1Var) {
        wq1Var.zzf = rr1Var;
        wq1Var.zze = 3;
    }

    public static /* synthetic */ void p(wq1 wq1Var, int i) {
        wq1Var.zzg = i - 1;
        wq1Var.zzd |= 1;
    }

    public static vq1 q() {
        return (vq1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", qo1.c, hr1.class, rr1.class, jr1.class});
        }
        if (i2 == 3) {
            return new wq1();
        }
        if (i2 == 4) {
            return new vq1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
