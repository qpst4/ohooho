package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class no1 extends hp1 {
    private static final no1 zzb;
    private kp1 zzd = bq1.f;

    static {
        no1 no1Var = new no1();
        zzb = no1Var;
        hp1.l(no1.class, no1Var);
    }

    public static mo1 o() {
        return (mo1) zzb.f();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void p(no1 no1Var, Iterable iterable) {
        kp1 kp1Var = no1Var.zzd;
        if (!((so1) kp1Var).b) {
            int size = kp1Var.size();
            no1Var.zzd = kp1Var.a(size + size);
        }
        kp1 kp1Var2 = no1Var.zzd;
        Charset charset = lp1.a;
        iterable.getClass();
        if (iterable instanceof ip1) {
            kp1Var2.addAll((Collection<? extends E>) ((Collection) iterable));
            return;
        }
        if (iterable instanceof Collection) {
            int size2 = ((Collection) iterable).size();
            if (kp1Var2 instanceof ArrayList) {
                ((ArrayList) kp1Var2).ensureCapacity(kp1Var2.size() + size2);
            }
            if (kp1Var2 instanceof bq1) {
                bq1 bq1Var = (bq1) kp1Var2;
                int i = bq1Var.d + size2;
                int length = bq1Var.c.length;
                if (i > length) {
                    if (length != 0) {
                        while (length < i) {
                            length = Math.max(((length * 3) / 2) + 1, 10);
                        }
                        bq1Var.c = Arrays.copyOf(bq1Var.c, length);
                    } else {
                        bq1Var.c = new Object[Math.max(i, 10)];
                    }
                }
            }
        }
        int size3 = kp1Var2.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    gp1.a(size3, kp1Var2);
                    throw null;
                }
                kp1Var2.add(obj);
            }
            return;
        }
        List list = (List) iterable;
        int size4 = list.size();
        for (int i2 = 0; i2 < size4; i2++) {
            Object obj2 = list.get(i2);
            if (obj2 == null) {
                gp1.a(size3, kp1Var2);
                throw null;
            }
            kp1Var2.add(obj2);
        }
    }

    @Override // defpackage.hp1
    public final Object d(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new cq1(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", lo1.class});
        }
        if (i2 == 3) {
            return new no1();
        }
        if (i2 == 4) {
            return new mo1(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
