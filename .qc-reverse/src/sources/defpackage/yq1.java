package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yq1 extends hp1 {
    private static final yq1 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        yq1 yq1Var = new yq1();
        zzb = yq1Var;
        hp1.l(yq1.class, yq1Var);
    }

    public static /* synthetic */ void o(yq1 yq1Var, String str) {
        yq1Var.zzd |= 8;
        yq1Var.zzh = str;
    }

    public static /* synthetic */ void p(yq1 yq1Var, String str) {
        str.getClass();
        yq1Var.zzd |= 2;
        yq1Var.zzf = str;
    }

    public static /* synthetic */ void q(yq1 yq1Var, int i) {
        yq1Var.zzd |= 1;
        yq1Var.zze = i;
    }

    public static /* synthetic */ void r(yq1 yq1Var, int i) {
        yq1Var.zzg = i - 1;
        yq1Var.zzd |= 4;
    }

    public static xq1 s() {
        return (xq1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", qo1.d, "zzh"});
        }
        if (i2 == 3) {
            return new yq1();
        }
        if (i2 == 4) {
            return new xq1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
