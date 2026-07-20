package defpackage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lp implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(lp.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(lp.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(lp.class, "_isTerminated$volatile");
    public static final c1 l = new c1("NOT_IN_STACK", 4);
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int b;
    public final int c;
    private volatile /* synthetic */ long controlState$volatile;
    public final long d;
    public final String e;
    public final u60 f;
    public final u60 g;
    public final rv0 h;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public lp(int i2, int i3, long j2, String str) {
        this.b = i2;
        this.c = i3;
        this.d = j2;
        this.e = str;
        if (i2 < 1) {
            s1.m("Core pool size ", i2, " should be at least 1");
            throw null;
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(qq0.h(i3, i2, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i3 > 2097150) {
            s1.m("Max pool size ", i3, " should not exceed maximal supported number of threads 2097150");
            throw null;
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f = new u60();
        this.g = new u60();
        this.h = new rv0((i2 + 1) * 2);
        this.controlState$volatile = ((long) i2) << 42;
        this._isTerminated$volatile = 0;
    }

    public final int a() {
        synchronized (this.h) {
            try {
                if (k.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = j;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.b) {
                    return 0;
                }
                if (i2 >= this.c) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.h.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                jp jpVar = new jp(this, i4);
                this.h.c(i4, jpVar);
                if (i4 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = i3 + 1;
                jpVar.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.lp.k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof defpackage.jp
            r3 = 0
            if (r1 == 0) goto L17
            jp r0 = (defpackage.jp) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L20
            lp r1 = r0.i
            if (r1 == r8) goto L1f
            goto L20
        L1f:
            r3 = r0
        L20:
            rv0 r0 = r8.h
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = defpackage.lp.j     // Catch: java.lang.Throwable -> La7
            long r4 = r1.get(r8)     // Catch: java.lang.Throwable -> La7
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r1 = (int) r4
            monitor-exit(r0)
            if (r2 > r1) goto L5c
            r0 = r2
        L32:
            rv0 r4 = r8.h
            java.lang.Object r4 = r4.b(r0)
            r4.getClass()
            jp r4 = (defpackage.jp) r4
            if (r4 == r3) goto L57
        L3f:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L50
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r5 = 10000(0x2710, double:4.9407E-320)
            r4.join(r5)
            goto L3f
        L50:
            bj1 r4 = r4.b
            u60 r5 = r8.g
            r4.c(r5)
        L57:
            if (r0 == r1) goto L5c
            int r0 = r0 + 1
            goto L32
        L5c:
            u60 r0 = r8.g
            r0.b()
            u60 r0 = r8.f
            r0.b()
        L66:
            if (r3 == 0) goto L6e
            k41 r0 = r3.a(r2)
            if (r0 != 0) goto L96
        L6e:
            u60 r0 = r8.f
            java.lang.Object r0 = r0.d()
            k41 r0 = (defpackage.k41) r0
            if (r0 != 0) goto L96
            u60 r0 = r8.g
            java.lang.Object r0 = r0.d()
            k41 r0 = (defpackage.k41) r0
            if (r0 != 0) goto L96
            if (r3 == 0) goto L89
            kp r0 = defpackage.kp.f
            r3.h(r0)
        L89:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.lp.i
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.lp.j
            r0.set(r8, r1)
            return
        L96:
            r0.run()     // Catch: java.lang.Throwable -> L9a
            goto L66
        L9a:
            r0 = move-exception
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r1.getUncaughtExceptionHandler()
            r4.uncaughtException(r1, r0)
            goto L66
        La7:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lp.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        g(runnable, p41.g);
    }

    public final void g(Runnable runnable, vy0 vy0Var) {
        k41 n41Var;
        kp kpVar;
        p41.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof k41) {
            n41Var = (k41) runnable;
            n41Var.b = jNanoTime;
            n41Var.c = vy0Var;
        } else {
            n41Var = new n41(runnable, jNanoTime, vy0Var);
        }
        boolean z = n41Var.c.a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = j;
        long jAddAndGet = z ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        jp jpVar = null;
        jp jpVar2 = threadCurrentThread instanceof jp ? (jp) threadCurrentThread : null;
        if (jpVar2 != null && jpVar2.i == this) {
            jpVar = jpVar2;
        }
        if (jpVar != null && (kpVar = jpVar.d) != kp.f && (n41Var.c.a != 0 || kpVar != kp.c)) {
            jpVar.h = true;
            n41Var = jpVar.b.a(n41Var);
        }
        if (n41Var != null) {
            if (!(n41Var.c.a == 1 ? this.g.a(n41Var) : this.f.a(n41Var))) {
                throw new RejectedExecutionException(l11.k(new StringBuilder(), this.e, " was terminated"));
            }
        }
        if (z) {
            if (m() || i(jAddAndGet)) {
                return;
            }
            m();
            return;
        }
        if (m() || i(atomicLongFieldUpdater.get(this))) {
            return;
        }
        m();
    }

    public final void h(jp jpVar, int i2, int i3) {
        while (true) {
            long j2 = i.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object objC = jpVar.c();
                    while (true) {
                        if (objC == l) {
                            i4 = -1;
                            break;
                        }
                        if (objC == null) {
                            i4 = 0;
                            break;
                        }
                        jp jpVar2 = (jp) objC;
                        int iB = jpVar2.b();
                        if (iB != 0) {
                            i4 = iB;
                            break;
                        }
                        objC = jpVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                lp lpVar = this;
                if (i.compareAndSet(lpVar, j2, ((long) i4) | j3)) {
                    return;
                } else {
                    this = lpVar;
                }
            }
        }
    }

    public final boolean i(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.b;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        lp lpVar;
        c1 c1Var;
        int iB;
        while (true) {
            long j2 = i.get(this);
            jp jpVar = (jp) this.h.b((int) (2097151 & j2));
            if (jpVar == null) {
                jpVar = null;
                lpVar = this;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = jpVar.c();
                while (true) {
                    c1Var = l;
                    if (objC == c1Var) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    jp jpVar2 = (jp) objC;
                    iB = jpVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = jpVar2.c();
                    j2 = j2;
                }
                if (iB >= 0) {
                    lp lpVar2 = this;
                    boolean zCompareAndSet = i.compareAndSet(lpVar2, j2, ((long) iB) | j3);
                    lpVar = lpVar2;
                    if (zCompareAndSet) {
                        jpVar.g(c1Var);
                    }
                    this = lpVar;
                } else {
                    continue;
                }
            }
            if (jpVar == null) {
                return false;
            }
            if (jp.j.compareAndSet(jpVar, -1, 0)) {
                LockSupport.unpark(jpVar);
                return true;
            }
            this = lpVar;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        rv0 rv0Var = this.h;
        int iA = rv0Var.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            jp jpVar = (jp) rv0Var.b(i7);
            if (jpVar != null) {
                int iB = jpVar.b.b();
                int iOrdinal = jpVar.d.ordinal();
                if (iOrdinal == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i4++;
                } else if (iOrdinal == 3) {
                    i5++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iOrdinal == 4) {
                    i6++;
                }
            }
        }
        long j2 = j.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.e);
        sb4.append('@');
        sb4.append(xr.p(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.b;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.c);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i2);
        sb4.append(", blocking = ");
        sb4.append(i3);
        sb4.append(", parked = ");
        sb4.append(i4);
        sb4.append(", dormant = ");
        sb4.append(i5);
        sb4.append(", terminated = ");
        sb4.append(i6);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.g.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
