package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rr1 extends hp1 {
    private static final rr1 zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        rr1 rr1Var = new rr1();
        zzb = rr1Var;
        hp1.l(rr1.class, rr1Var);
    }

    public static /* synthetic */ void o(rr1 rr1Var) {
        rr1Var.zzd |= 2;
        rr1Var.zzf = true;
    }

    public static qr1 p() {
        return (qr1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new rr1();
        }
        if (i2 == 4) {
            return new qr1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
