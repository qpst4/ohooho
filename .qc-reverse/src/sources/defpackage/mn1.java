package defpackage;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mn1 extends tk0 {
    public static final Unsafe l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new ln1());
            }
            try {
                n = unsafe.objectFieldOffset(on1.class.getDeclaredField("d"));
                m = unsafe.objectFieldOffset(on1.class.getDeclaredField("c"));
                o = unsafe.objectFieldOffset(on1.class.getDeclaredField("b"));
                p = unsafe.objectFieldOffset(nn1.class.getDeclaredField("a"));
                q = unsafe.objectFieldOffset(nn1.class.getDeclaredField("b"));
                l = unsafe;
            } catch (NoSuchFieldException e) {
                zy.m(e);
            }
        } catch (PrivilegedActionException e2) {
            zy.l("Could not initialize intrinsics", e2.getCause());
        }
    }

    @Override // defpackage.tk0
    public final gn1 S(on1 on1Var) {
        gn1 gn1Var;
        gn1 gn1Var2 = gn1.d;
        do {
            gn1Var = on1Var.c;
            if (gn1Var2 == gn1Var) {
                break;
            }
        } while (!Y(on1Var, gn1Var, gn1Var2));
        return gn1Var;
    }

    @Override // defpackage.tk0
    public final nn1 T(on1 on1Var) {
        nn1 nn1Var;
        nn1 nn1Var2 = nn1.c;
        do {
            nn1Var = on1Var.d;
            if (nn1Var2 == nn1Var) {
                break;
            }
        } while (!a0(on1Var, nn1Var, nn1Var2));
        return nn1Var;
    }

    @Override // defpackage.tk0
    public final void W(nn1 nn1Var, nn1 nn1Var2) {
        l.putObject(nn1Var, q, nn1Var2);
    }

    @Override // defpackage.tk0
    public final void X(nn1 nn1Var, Thread thread) {
        l.putObject(nn1Var, p, thread);
    }

    @Override // defpackage.tk0
    public final boolean Y(on1 on1Var, gn1 gn1Var, gn1 gn1Var2) {
        return sn1.a(l, on1Var, m, gn1Var, gn1Var2);
    }

    @Override // defpackage.tk0
    public final boolean Z(on1 on1Var, Object obj, Object obj2) {
        return sn1.a(l, on1Var, o, obj, obj2);
    }

    @Override // defpackage.tk0
    public final boolean a0(on1 on1Var, nn1 nn1Var, nn1 nn1Var2) {
        return sn1.a(l, on1Var, n, nn1Var, nn1Var2);
    }
}
