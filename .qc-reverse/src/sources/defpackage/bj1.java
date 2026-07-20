package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bj1 {
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(bj1.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ long f = sz.a.objectFieldOffset(bj1.class.getDeclaredField("lastScheduledTask$volatile"));
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(bj1.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(bj1.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(bj1.class, "blockingTasksInBuffer$volatile");

    public final k41 a(k41 k41Var) {
        b.getClass();
        k41 k41Var2 = (k41) sz.a.getAndSetObject(this, f, k41Var);
        if (k41Var2 == null) {
            return null;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
        if (atomicIntegerFieldUpdater.get(this) - d.get(this) == 127) {
            return k41Var2;
        }
        if (k41Var2.c.a == 1) {
            e.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            if (atomicReferenceArray.get(i) == null) {
                atomicReferenceArray.lazySet(i, k41Var2);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final int b() {
        b.getClass();
        Object objectVolatile = sz.a.getObjectVolatile(this, f);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = c;
        return objectVolatile != null ? (atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this)) + 1 : atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this);
    }

    public final void c(u60 u60Var) {
        b.getClass();
        k41 k41Var = (k41) sz.a.getAndSetObject(this, f, (Object) null);
        if (k41Var != null) {
            u60Var.a(k41Var);
        }
        while (true) {
            k41 k41VarE = e();
            if (k41VarE == null) {
                return;
            } else {
                u60Var.a(k41VarE);
            }
        }
    }

    public final k41 d() {
        b.getClass();
        k41 k41Var = (k41) sz.a.getAndSetObject(this, f, (Object) null);
        return k41Var == null ? e() : k41Var;
    }

    public final k41 e() {
        k41 k41Var;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (k41Var = (k41) this.a.getAndSet(i2, null)) != null) {
                if (k41Var.c.a == 1) {
                    e.decrementAndGet(this);
                }
                return k41Var;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        r9 = defpackage.bj1.d.get(r4);
        r1 = defpackage.bj1.c.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r9 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (defpackage.bj1.e.get(r4) != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        r1 = r1 - 1;
        r2 = r4.g(r1, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        r4 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.k41 f() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.bj1.b
            r0.getClass()
            sun.misc.Unsafe r0 = defpackage.sz.a
            long r1 = defpackage.bj1.f
            java.lang.Object r0 = r0.getObjectVolatile(r9, r1)
            r7 = r0
            k41 r7 = (defpackage.k41) r7
            r0 = 1
            if (r7 != 0) goto L15
        L13:
            r4 = r9
            goto L32
        L15:
            vy0 r3 = r7.c
            int r3 = r3.a
            if (r3 != r0) goto L13
        L1b:
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r5 = defpackage.bj1.f
            r8 = 0
            r4 = r9
            boolean r9 = r3.compareAndSwapObject(r4, r5, r7, r8)
            if (r9 == 0) goto L28
            return r7
        L28:
            java.lang.Object r9 = r3.getObjectVolatile(r4, r1)
            if (r9 == r7) goto L30
            r9 = r4
            goto L0
        L30:
            r9 = r4
            goto L1b
        L32:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = defpackage.bj1.d
            int r9 = r9.get(r4)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = defpackage.bj1.c
            int r1 = r1.get(r4)
        L3e:
            if (r9 == r1) goto L52
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = defpackage.bj1.e
            int r2 = r2.get(r4)
            if (r2 != 0) goto L49
            goto L52
        L49:
            int r1 = r1 + (-1)
            k41 r2 = r4.g(r1, r0)
            if (r2 == 0) goto L3e
            return r2
        L52:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bj1.f():k41");
    }

    public final k41 g(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.a;
        k41 k41Var = (k41) atomicReferenceArray.get(i2);
        if (k41Var != null) {
            if ((k41Var.c.a == 1) == z) {
                while (!atomicReferenceArray.compareAndSet(i2, k41Var, null)) {
                    if (atomicReferenceArray.get(i2) != k41Var) {
                    }
                }
                if (z) {
                    e.decrementAndGet(this);
                }
                return k41Var;
            }
        }
        return null;
    }

    public final long h(int i, su0 su0Var) {
        bj1 bj1Var;
        while (true) {
            b.getClass();
            Unsafe unsafe = sz.a;
            long j = f;
            k41 k41Var = (k41) unsafe.getObjectVolatile(this, j);
            if (k41Var == null) {
                return -2L;
            }
            if (((k41Var.c.a != 1 ? 2 : 1) & i) == 0) {
                return -2L;
            }
            p41.f.getClass();
            long jNanoTime = System.nanoTime() - k41Var.b;
            long j2 = p41.b;
            if (jNanoTime < j2) {
                return j2 - jNanoTime;
            }
            while (true) {
                Unsafe unsafe2 = sz.a;
                bj1Var = this;
                if (unsafe2.compareAndSwapObject(bj1Var, f, k41Var, (Object) null)) {
                    su0Var.b = k41Var;
                    return -1L;
                }
                if (unsafe2.getObjectVolatile(bj1Var, j) != k41Var) {
                    break;
                }
                this = bj1Var;
            }
            this = bj1Var;
        }
    }
}
