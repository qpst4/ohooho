package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lo1 extends hp1 {
    private static final lo1 zzb;
    private int zzd;
    private po1 zze;
    private po1 zzf;
    private int zzg;

    static {
        lo1 lo1Var = new lo1();
        zzb = lo1Var;
        hp1.l(lo1.class, lo1Var);
    }

    public static ko1 o() {
        return (ko1) zzb.f();
    }

    public static /* synthetic */ void p(lo1 lo1Var, po1 po1Var) {
        lo1Var.zze = po1Var;
        lo1Var.zzd |= 1;
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", qo1.b});
        }
        if (i2 == 3) {
            return new lo1();
        }
        if (i2 == 4) {
            return new ko1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
