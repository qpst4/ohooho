package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sq1 extends hp1 {
    private static final sq1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private yq1 zzh;

    static {
        sq1 sq1Var = new sq1();
        zzb = sq1Var;
        hp1.l(sq1.class, sq1Var);
    }

    public static sq1 o(byte[] bArr, bp1 bp1Var) throws np1 {
        hp1 hp1Var = zzb;
        int length = bArr.length;
        if (length != 0) {
            hp1 hp1Var2 = (hp1) hp1Var.d(4);
            try {
                dq1 dq1VarA = aq1.c.a(hp1Var2.getClass());
                uo1 uo1Var = new uo1();
                bp1Var.getClass();
                dq1VarA.f(hp1Var2, bArr, 0, length, uo1Var);
                dq1VarA.a(hp1Var2);
                hp1Var = hp1Var2;
            } catch (iq1 e) {
                ay0.b(e.getMessage());
                return null;
            } catch (np1 e2) {
                throw e2;
            } catch (IOException e3) {
                if (e3.getCause() instanceof np1) {
                    throw ((np1) e3.getCause());
                }
                throw new np1(e3.getMessage(), e3);
            } catch (IndexOutOfBoundsException unused) {
                ay0.b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return null;
            }
        }
        if (hp1Var == null || hp1.n(hp1Var, true)) {
            return (sq1) hp1Var;
        }
        ay0.b(new iq1().getMessage());
        return null;
    }

    public static /* synthetic */ void p(sq1 sq1Var, yq1 yq1Var) {
        sq1Var.zzh = yq1Var;
        sq1Var.zzd |= 2;
    }

    public static /* synthetic */ void q(sq1 sq1Var, int i) {
        sq1Var.zzg = i - 1;
        sq1Var.zzd |= 1;
    }

    public static rq1 r() {
        return (rq1) zzb.f();
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", qo1.c, "zzh", hr1.class});
        }
        if (i2 == 3) {
            return new sq1();
        }
        if (i2 == 4) {
            return new rq1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
