package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ii0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ii0.class, Object.class, "_cur$volatile");
    public static final /* synthetic */ long b = sz.a.objectFieldOffset(ii0.class.getDeclaredField("_cur$volatile"));
    private volatile /* synthetic */ Object _cur$volatile = new ki0(8, false);

    public final boolean a(Runnable runnable) {
        ii0 ii0Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = sz.a;
            long j = b;
            ki0 ki0Var = (ki0) unsafe.getObjectVolatile(this, j);
            int iA = ki0Var.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                ki0 ki0VarD = ki0Var.d();
                while (true) {
                    Unsafe unsafe2 = sz.a;
                    ii0Var = this;
                    if (!unsafe2.compareAndSwapObject(ii0Var, b, ki0Var, ki0VarD) && unsafe2.getObjectVolatile(ii0Var, j) == ki0Var) {
                        this = ii0Var;
                    }
                }
            } else {
                if (iA == 2) {
                    return false;
                }
                ii0Var = this;
            }
            this = ii0Var;
        }
    }

    public final void b() {
        ii0 ii0Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = sz.a;
            long j = b;
            ki0 ki0Var = (ki0) unsafe.getObjectVolatile(this, j);
            if (ki0Var.c()) {
                return;
            }
            ki0 ki0VarD = ki0Var.d();
            while (true) {
                Unsafe unsafe2 = sz.a;
                ii0Var = this;
                if (!unsafe2.compareAndSwapObject(ii0Var, b, ki0Var, ki0VarD) && unsafe2.getObjectVolatile(ii0Var, j) == ki0Var) {
                    this = ii0Var;
                }
            }
            this = ii0Var;
        }
    }

    public final int c() {
        a.getClass();
        ki0 ki0Var = (ki0) sz.a.getObjectVolatile(this, b);
        ki0Var.getClass();
        long j = ki0.f.get(ki0Var);
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final Object d() {
        ii0 ii0Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = sz.a;
            long j = b;
            ki0 ki0Var = (ki0) unsafe.getObjectVolatile(this, j);
            Object objE = ki0Var.e();
            if (objE != ki0.g) {
                return objE;
            }
            ki0 ki0VarD = ki0Var.d();
            while (true) {
                Unsafe unsafe2 = sz.a;
                ii0Var = this;
                if (!unsafe2.compareAndSwapObject(ii0Var, b, ki0Var, ki0VarD) && unsafe2.getObjectVolatile(ii0Var, j) == ki0Var) {
                    this = ii0Var;
                }
            }
            this = ii0Var;
        }
    }
}
