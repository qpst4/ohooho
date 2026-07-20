package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jp extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(jp.class, "workerCtl$volatile");
    public final bj1 b;
    public final su0 c;
    public kp d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public final /* synthetic */ lp i;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public jp(lp lpVar, int i) {
        this.i = lpVar;
        setDaemon(true);
        setContextClassLoader(lp.class.getClassLoader());
        this.b = new bj1();
        this.c = new su0();
        this.d = kp.e;
        this.nextParkedWorker = lp.l;
        int iNanoTime = (int) System.nanoTime();
        this.g = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    public final k41 a(boolean z) {
        k41 k41VarE;
        k41 k41VarE2;
        long j2;
        kp kpVar = this.d;
        lp lpVar = this.i;
        bj1 bj1Var = this.b;
        kp kpVar2 = kp.b;
        if (kpVar != kpVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = lp.j;
            do {
                j2 = atomicLongFieldUpdater.get(lpVar);
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    k41 k41VarF = bj1Var.f();
                    return (k41VarF == null && (k41VarF = (k41) lpVar.g.d()) == null) ? i(1) : k41VarF;
                }
            } while (!lp.j.compareAndSet(lpVar, j2, j2 - 4398046511104L));
            this.d = kpVar2;
        }
        if (z) {
            boolean z2 = d(lpVar.b * 2) == 0;
            if (z2 && (k41VarE2 = e()) != null) {
                return k41VarE2;
            }
            k41 k41VarD = bj1Var.d();
            if (k41VarD != null) {
                return k41VarD;
            }
            if (!z2 && (k41VarE = e()) != null) {
                return k41VarE;
            }
        } else {
            k41 k41VarE3 = e();
            if (k41VarE3 != null) {
                return k41VarE3;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.g;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.g = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
    }

    public final k41 e() {
        int iD = d(2);
        lp lpVar = this.i;
        u60 u60Var = lpVar.g;
        u60 u60Var2 = lpVar.f;
        if (iD == 0) {
            k41 k41Var = (k41) u60Var2.d();
            return k41Var != null ? k41Var : (k41) u60Var.d();
        }
        k41 k41Var2 = (k41) u60Var.d();
        return k41Var2 != null ? k41Var2 : (k41) u60Var2.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.e);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(kp kpVar) {
        kp kpVar2 = this.d;
        boolean z = kpVar2 == kp.b;
        if (z) {
            lp.j.addAndGet(this.i, 4398046511104L);
        }
        if (kpVar2 != kpVar) {
            this.d = kpVar;
        }
        return z;
    }

    public final k41 i(int i) {
        k41 k41VarG;
        long jH;
        AtomicLongFieldUpdater atomicLongFieldUpdater = lp.j;
        lp lpVar = this.i;
        int i2 = (int) (atomicLongFieldUpdater.get(lpVar) & 2097151);
        if (i2 < 2) {
            return null;
        }
        int iD = d(i2);
        long jMin = Long.MAX_VALUE;
        for (int i3 = 0; i3 < i2; i3++) {
            iD++;
            if (iD > i2) {
                iD = 1;
            }
            jp jpVar = (jp) lpVar.h.b(iD);
            if (jpVar != null && jpVar != this) {
                bj1 bj1Var = jpVar.b;
                if (i == 3) {
                    k41VarG = bj1Var.e();
                } else {
                    bj1Var.getClass();
                    int i4 = bj1.d.get(bj1Var);
                    int i5 = bj1.c.get(bj1Var);
                    boolean z = i == 1;
                    while (i4 != i5 && (!z || bj1.e.get(bj1Var) != 0)) {
                        int i6 = i4 + 1;
                        k41VarG = bj1Var.g(i4, z);
                        if (k41VarG != null) {
                            break;
                        }
                        i4 = i6;
                    }
                    k41VarG = null;
                }
                su0 su0Var = this.c;
                if (k41VarG != null) {
                    su0Var.b = k41VarG;
                    jH = -1;
                } else {
                    jH = bj1Var.h(i, su0Var);
                }
                if (jH == -1) {
                    k41 k41Var = (k41) su0Var.b;
                    su0Var.b = null;
                    return k41Var;
                }
                if (jH > 0) {
                    jMin = Math.min(jMin, jH);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f = jMin;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jp.run():void");
    }
}
