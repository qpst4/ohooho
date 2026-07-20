package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rz extends pz implements zs {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(rz.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h;
    public static final /* synthetic */ AtomicIntegerFieldUpdater i;
    public static final /* synthetic */ long j;
    public static final /* synthetic */ long k;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        Unsafe unsafe = sz.a;
        k = unsafe.objectFieldOffset(rz.class.getDeclaredField("_queue$volatile"));
        h = AtomicReferenceFieldUpdater.newUpdater(rz.class, Object.class, "_delayed$volatile");
        j = unsafe.objectFieldOffset(rz.class.getDeclaredField("_delayed$volatile"));
        i = AtomicIntegerFieldUpdater.newUpdater(rz.class, "_isCompleted$volatile");
    }

    public final boolean A() {
        eb ebVar = this.f;
        if (ebVar != null ? ebVar.isEmpty() : true) {
            h.getClass();
            Unsafe unsafe = sz.a;
            g.getClass();
            Object objectVolatile = unsafe.getObjectVolatile(this, k);
            if (objectVolatile != null) {
                if (objectVolatile instanceof ki0) {
                    long j2 = ki0.f.get((ki0) objectVolatile);
                    return ((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30));
                }
                if (objectVolatile == xy0.d) {
                }
            }
            return true;
        }
        return false;
    }

    public final long B() {
        if (t()) {
            return 0L;
        }
        h.getClass();
        Runnable runnableV = v();
        if (runnableV == null) {
            return y();
        }
        runnableV.run();
        return 0L;
    }

    public final void C() {
        System.nanoTime();
        h.getClass();
    }

    public final void D() {
        g.getClass();
        Unsafe unsafe = sz.a;
        unsafe.putObjectVolatile(this, k, (Object) null);
        h.getClass();
        unsafe.putObjectVolatile(this, j, (Object) null);
    }

    @Override // defpackage.hp
    public final void q(ep epVar, Runnable runnable) {
        w(runnable);
    }

    @Override // defpackage.pz
    public void shutdown() {
        o51.a.set(null);
        i.set(this, 1);
        u();
        while (B() <= 0) {
        }
        C();
    }

    public final void u() {
        rz rzVar;
        Unsafe unsafe;
        c1 c1Var = xy0.d;
        while (true) {
            g.getClass();
            Unsafe unsafe2 = sz.a;
            long j2 = k;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            if (objectVolatile == null) {
                while (true) {
                    Unsafe unsafe3 = sz.a;
                    rzVar = this;
                    if (unsafe3.compareAndSwapObject(rzVar, k, (Object) null, c1Var)) {
                        return;
                    }
                    if (unsafe3.getObjectVolatile(rzVar, j2) != null) {
                        break;
                    } else {
                        this = rzVar;
                    }
                }
            } else {
                rzVar = this;
                if (objectVolatile instanceof ki0) {
                    ((ki0) objectVolatile).c();
                    return;
                }
                if (objectVolatile == c1Var) {
                    return;
                }
                ki0 ki0Var = new ki0(8, true);
                ki0Var.a((Runnable) objectVolatile);
                do {
                    unsafe = sz.a;
                    if (unsafe.compareAndSwapObject(rzVar, k, objectVolatile, ki0Var)) {
                        return;
                    }
                } while (unsafe.getObjectVolatile(rzVar, j2) == objectVolatile);
            }
            this = rzVar;
        }
    }

    public final Runnable v() {
        rz rzVar;
        Unsafe unsafe;
        while (true) {
            g.getClass();
            Unsafe unsafe2 = sz.a;
            long j2 = k;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            if (objectVolatile == null) {
                return null;
            }
            if (objectVolatile instanceof ki0) {
                ki0 ki0Var = (ki0) objectVolatile;
                Object objE = ki0Var.e();
                if (objE != ki0.g) {
                    return (Runnable) objE;
                }
                ki0 ki0VarD = ki0Var.d();
                while (true) {
                    Unsafe unsafe3 = sz.a;
                    rzVar = this;
                    if (!unsafe3.compareAndSwapObject(rzVar, k, objectVolatile, ki0VarD) && unsafe3.getObjectVolatile(rzVar, j2) == objectVolatile) {
                        this = rzVar;
                    }
                }
            } else {
                rzVar = this;
                if (objectVolatile == xy0.d) {
                    return null;
                }
                do {
                    unsafe = sz.a;
                    if (unsafe.compareAndSwapObject(rzVar, k, objectVolatile, (Object) null)) {
                        return (Runnable) objectVolatile;
                    }
                } while (unsafe.getObjectVolatile(rzVar, j2) == objectVolatile);
            }
            this = rzVar;
        }
    }

    public void w(Runnable runnable) {
        if (!x(runnable)) {
            ds.l.w(runnable);
            return;
        }
        Thread threadZ = z();
        if (Thread.currentThread() != threadZ) {
            LockSupport.unpark(threadZ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Runnable r15) {
        /*
            r14 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.rz.g
            r0.getClass()
            sun.misc.Unsafe r0 = defpackage.sz.a
            long r1 = defpackage.rz.k
            java.lang.Object r7 = r0.getObjectVolatile(r14, r1)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.rz.i
            int r0 = r0.get(r14)
            r3 = 0
            if (r0 == 0) goto L17
            return r3
        L17:
            r0 = 1
            if (r7 != 0) goto L33
        L1a:
            sun.misc.Unsafe r8 = defpackage.sz.a
            long r10 = defpackage.rz.k
            r12 = 0
            r9 = r14
            r13 = r15
            boolean r14 = r8.compareAndSwapObject(r9, r10, r12, r13)
            r4 = r9
            if (r14 == 0) goto L29
            goto L7d
        L29:
            java.lang.Object r14 = r8.getObjectVolatile(r4, r1)
            if (r14 == 0) goto L30
            goto L84
        L30:
            r14 = r4
            r15 = r13
            goto L1a
        L33:
            r4 = r14
            r13 = r15
            boolean r14 = r7 instanceof defpackage.ki0
            if (r14 == 0) goto L5e
            r14 = r7
            ki0 r14 = (defpackage.ki0) r14
            int r15 = r14.a(r13)
            if (r15 == 0) goto L7d
            if (r15 == r0) goto L48
            r14 = 2
            if (r15 == r14) goto L62
            goto L84
        L48:
            ki0 r8 = r14.d()
        L4c:
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r5 = defpackage.rz.k
            boolean r14 = r3.compareAndSwapObject(r4, r5, r7, r8)
            if (r14 == 0) goto L57
            goto L84
        L57:
            java.lang.Object r14 = r3.getObjectVolatile(r4, r1)
            if (r14 == r7) goto L4c
            goto L84
        L5e:
            c1 r14 = defpackage.xy0.d
            if (r7 != r14) goto L63
        L62:
            return r3
        L63:
            ki0 r8 = new ki0
            r14 = 8
            r8.<init>(r14, r0)
            r14 = r7
            java.lang.Runnable r14 = (java.lang.Runnable) r14
            r8.a(r14)
            r8.a(r13)
        L73:
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r5 = defpackage.rz.k
            boolean r14 = r3.compareAndSwapObject(r4, r5, r7, r8)
            if (r14 == 0) goto L7e
        L7d:
            return r0
        L7e:
            java.lang.Object r14 = r3.getObjectVolatile(r4, r1)
            if (r14 == r7) goto L73
        L84:
            r14 = r4
            r15 = r13
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rz.x(java.lang.Runnable):boolean");
    }

    public final long y() {
        eb ebVar = this.f;
        if (((ebVar == null || ebVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
            g.getClass();
            Unsafe unsafe = sz.a;
            Object objectVolatile = unsafe.getObjectVolatile(this, k);
            if (objectVolatile == null) {
                h.getClass();
            } else if (objectVolatile instanceof ki0) {
                long j2 = ki0.f.get((ki0) objectVolatile);
                if (((int) (1073741823 & j2)) != ((int) ((j2 & 1152921503533105152L) >> 30))) {
                    return 0L;
                }
                h.getClass();
            } else if (objectVolatile == xy0.d) {
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public abstract Thread z();
}
