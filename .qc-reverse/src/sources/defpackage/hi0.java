package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class hi0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(hi0.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b;
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ long d;
    public static final /* synthetic */ long e;
    public static final /* synthetic */ long f;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Unsafe unsafe = sz.a;
        d = unsafe.objectFieldOffset(hi0.class.getDeclaredField("_next$volatile"));
        b = AtomicReferenceFieldUpdater.newUpdater(hi0.class, Object.class, "_prev$volatile");
        e = unsafe.objectFieldOffset(hi0.class.getDeclaredField("_prev$volatile"));
        c = AtomicReferenceFieldUpdater.newUpdater(hi0.class, Object.class, "_removedRef$volatile");
        f = unsafe.objectFieldOffset(hi0.class.getDeclaredField("_removedRef$volatile"));
    }

    public static hi0 g(hi0 hi0Var) {
        while (hi0Var.l()) {
            b.getClass();
            hi0Var = (hi0) sz.a.getObjectVolatile(hi0Var, e);
        }
        return hi0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        r9 = r4;
        r10 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(defpackage.wm0 r10) {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.hi0.b
            r0.getClass()
            sun.misc.Unsafe r0 = defpackage.sz.a
            long r1 = defpackage.hi0.e
            r0.putObjectVolatile(r10, r1, r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.hi0.a
            r1.getClass()
            long r1 = defpackage.hi0.d
            r0.putObjectVolatile(r10, r1, r9)
        L16:
            java.lang.Object r0 = r9.i()
            if (r0 == r9) goto L1d
            return
        L1d:
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r5 = defpackage.hi0.d
            r7 = r9
            r4 = r9
            r8 = r10
            boolean r9 = r3.compareAndSwapObject(r4, r5, r7, r8)
            if (r9 == 0) goto L2e
            r8.h(r4)
            return
        L2e:
            java.lang.Object r9 = r3.getObjectVolatile(r4, r1)
            if (r9 == r4) goto L37
            r9 = r4
            r10 = r8
            goto L16
        L37:
            r9 = r4
            r10 = r8
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hi0.e(wm0):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.hi0 f() {
        /*
            r15 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.hi0.b
            r0.getClass()
            sun.misc.Unsafe r0 = defpackage.sz.a
            long r1 = defpackage.hi0.e
            java.lang.Object r0 = r0.getObjectVolatile(r15, r1)
            r7 = r0
            hi0 r7 = (defpackage.hi0) r7
            r0 = 0
            r9 = r0
            r8 = r7
        L13:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = defpackage.hi0.a
            r3.getClass()
            if (r8 == 0) goto L92
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r4 = defpackage.hi0.d
            java.lang.Object r6 = r3.getObjectVolatile(r8, r4)
            if (r6 != r15) goto L40
            if (r7 != r8) goto L27
            goto L4b
        L27:
            sun.misc.Unsafe r3 = defpackage.sz.a
            long r5 = defpackage.hi0.e
            r4 = r15
            boolean r15 = r3.compareAndSwapObject(r4, r5, r7, r8)
            r14 = r7
            r7 = r4
            if (r15 == 0) goto L35
            goto L4b
        L35:
            java.lang.Object r15 = r3.getObjectVolatile(r7, r1)
            if (r15 == r14) goto L3d
        L3b:
            r15 = r7
            goto L0
        L3d:
            r15 = r7
            r7 = r14
            goto L27
        L40:
            r14 = r7
            r7 = r15
            boolean r15 = r7.l()
            if (r15 == 0) goto L49
            return r0
        L49:
            if (r6 != 0) goto L4c
        L4b:
            return r8
        L4c:
            boolean r15 = r6 instanceof defpackage.xb
            if (r15 == 0) goto L56
            xb r6 = (defpackage.xb) r6
            r6.c(r8)
            goto L3b
        L56:
            boolean r15 = r6 instanceof defpackage.iv0
            if (r15 == 0) goto L89
            if (r9 == 0) goto L79
            iv0 r6 = (defpackage.iv0) r6
            hi0 r13 = r6.a
        L60:
            r12 = r8
            sun.misc.Unsafe r8 = defpackage.sz.a
            long r10 = defpackage.hi0.d
            boolean r15 = r8.compareAndSwapObject(r9, r10, r12, r13)
            r3 = r8
            r8 = r12
            if (r15 == 0) goto L72
            r15 = r7
            r8 = r9
            r7 = r14
            r9 = r0
            goto L13
        L72:
            java.lang.Object r15 = r3.getObjectVolatile(r9, r4)
            if (r15 == r8) goto L60
            goto L3b
        L79:
            if (r8 == 0) goto L85
            java.lang.Object r15 = r3.getObjectVolatile(r8, r1)
            r8 = r15
            hi0 r8 = (defpackage.hi0) r8
        L82:
            r15 = r7
            r7 = r14
            goto L13
        L85:
            defpackage.s1.d()
            return r0
        L89:
            r6.getClass()
            r15 = r6
            hi0 r15 = (defpackage.hi0) r15
            r9 = r8
            r8 = r15
            goto L82
        L92:
            defpackage.s1.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hi0.f():hi0");
    }

    public final void h(hi0 hi0Var) {
        hi0 hi0Var2;
        while (true) {
            b.getClass();
            if (hi0Var == null) {
                s1.d();
                return;
            }
            Unsafe unsafe = sz.a;
            long j = e;
            hi0 hi0Var3 = (hi0) unsafe.getObjectVolatile(hi0Var, j);
            if (this.i() != hi0Var) {
                return;
            }
            while (hi0Var != null) {
                Unsafe unsafe2 = sz.a;
                hi0Var2 = this;
                hi0 hi0Var4 = hi0Var;
                if (unsafe2.compareAndSwapObject(hi0Var4, e, hi0Var3, hi0Var2)) {
                    if (hi0Var2.l()) {
                        hi0Var4.f();
                        return;
                    }
                    return;
                } else {
                    if (hi0Var4 == null) {
                        s1.d();
                        return;
                    }
                    hi0Var = hi0Var4;
                    if (unsafe2.getObjectVolatile(hi0Var4, j) != hi0Var3) {
                        break;
                    } else {
                        this = hi0Var2;
                    }
                }
            }
            s1.d();
            return;
            this = hi0Var2;
        }
    }

    public final Object i() {
        while (true) {
            a.getClass();
            Object objectVolatile = sz.a.getObjectVolatile(this, d);
            if (!(objectVolatile instanceof xb)) {
                return objectVolatile;
            }
            ((xb) objectVolatile).c(this);
        }
    }

    public final hi0 j() {
        Object objI = i();
        iv0 iv0Var = objI instanceof iv0 ? (iv0) objI : null;
        if (iv0Var != null) {
            return iv0Var.a;
        }
        objI.getClass();
        return (hi0) objI;
    }

    public final hi0 k() {
        hi0 hi0VarF = f();
        if (hi0VarF != null) {
            return hi0VarF;
        }
        b.getClass();
        return g((hi0) sz.a.getObjectVolatile(this, e));
    }

    public boolean l() {
        return i() instanceof iv0;
    }

    public final hi0 m() {
        hi0 hi0Var;
        while (true) {
            Object objI = this.i();
            if (objI instanceof iv0) {
                return ((iv0) objI).a;
            }
            if (objI == this) {
                return (hi0) objI;
            }
            objI.getClass();
            hi0 hi0Var2 = (hi0) objI;
            iv0 iv0VarN = hi0Var2.n();
            while (true) {
                a.getClass();
                Unsafe unsafe = sz.a;
                long j = d;
                hi0Var = this;
                if (unsafe.compareAndSwapObject(hi0Var, j, objI, iv0VarN)) {
                    hi0Var2.f();
                    return null;
                }
                if (unsafe.getObjectVolatile(hi0Var, j) != objI) {
                    break;
                }
                this = hi0Var;
            }
            this = hi0Var;
        }
    }

    public final iv0 n() {
        c.getClass();
        Unsafe unsafe = sz.a;
        long j = f;
        iv0 iv0Var = (iv0) unsafe.getObjectVolatile(this, j);
        if (iv0Var != null) {
            return iv0Var;
        }
        iv0 iv0Var2 = new iv0(this);
        unsafe.putObjectVolatile(this, j, iv0Var2);
        return iv0Var2;
    }

    public final int o(cd0 cd0Var, wm0 wm0Var, fd0 fd0Var) {
        b.getClass();
        Unsafe unsafe = sz.a;
        unsafe.putObjectVolatile(cd0Var, e, this);
        a.getClass();
        long j = d;
        unsafe.putObjectVolatile(cd0Var, j, wm0Var);
        fd0Var.d = wm0Var;
        while (true) {
            Unsafe unsafe2 = sz.a;
            hi0 hi0Var = this;
            wm0 wm0Var2 = wm0Var;
            fd0 fd0Var2 = fd0Var;
            if (unsafe2.compareAndSwapObject(hi0Var, d, wm0Var2, fd0Var2)) {
                return fd0Var2.c(hi0Var) == null ? 1 : 2;
            }
            if (unsafe2.getObjectVolatile(hi0Var, j) != wm0Var2) {
                return 0;
            }
            this = hi0Var;
            wm0Var = wm0Var2;
            fd0Var = fd0Var2;
        }
    }

    public String toString() {
        return new gi0(this, xr.class, 1) + '@' + xr.p(this);
    }
}
