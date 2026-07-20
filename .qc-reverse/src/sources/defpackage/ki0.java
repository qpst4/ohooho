package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ki0 {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(ki0.class, Object.class, "_next$volatile");
    public static final /* synthetic */ long h = sz.a.objectFieldOffset(ki0.class.getDeclaredField("_next$volatile"));
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(ki0.class, "_state$volatile");
    public static final c1 g = new c1("REMOVE_FROZEN", 4);

    public ki0(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            s1.f("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        s1.f("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                ki0 ki0Var = this;
                if (f.compareAndSet(ki0Var, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    ki0 ki0VarD = ki0Var;
                    while ((atomicLongFieldUpdater.get(ki0VarD) & 1152921504606846976L) != 0) {
                        ki0VarD = ki0VarD.d();
                        AtomicReferenceArray atomicReferenceArray2 = ki0VarD.d;
                        int i4 = ki0VarD.c & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof ji0) && ((ji0) obj2).a == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            ki0VarD = null;
                        }
                        if (ki0VarD == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = ki0Var;
            } else {
                int i5 = this.a;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final ki0 b(long j) {
        ki0 ki0Var;
        while (true) {
            e.getClass();
            Unsafe unsafe = sz.a;
            long j2 = h;
            ki0 ki0Var2 = (ki0) unsafe.getObjectVolatile(this, j2);
            if (ki0Var2 != null) {
                return ki0Var2;
            }
            ki0 ki0Var3 = new ki0(this.a * 2, this.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object ji0Var = this.d.get(i4);
                if (ji0Var == null) {
                    ji0Var = new ji0(i);
                }
                ki0Var3.d.set(ki0Var3.c & i, ji0Var);
                i++;
            }
            f.set(ki0Var3, (-1152921504606846977L) & j);
            while (true) {
                Unsafe unsafe2 = sz.a;
                ki0Var = this;
                if (!unsafe2.compareAndSwapObject(ki0Var, h, (Object) null, ki0Var3) && unsafe2.getObjectVolatile(ki0Var, j2) == null) {
                    this = ki0Var;
                }
            }
            this = ki0Var;
        }
    }

    public final boolean c() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
            ki0 ki0Var = this;
            if (atomicLongFieldUpdater.compareAndSet(ki0Var, j, 2305843009213693952L | j)) {
                return true;
            }
            this = ki0Var;
        }
    }

    public final ki0 d() {
        long j;
        ki0 ki0Var;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                ki0Var = this;
                break;
            }
            long j2 = 1152921504606846976L | j;
            ki0Var = this;
            if (atomicLongFieldUpdater.compareAndSet(ki0Var, j, j2)) {
                j = j2;
                break;
            }
            this = ki0Var;
        }
        return ki0Var.b(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = defpackage.ki0.f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            c1 r0 = defpackage.ki0.g
            return r0
        L15:
            r11 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r11
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r13 = 30
            long r4 = r4 >> r13
            int r4 = (int) r4
            int r5 = r1.c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof defpackage.ji0
            if (r7 == 0) goto L42
        L41:
            return r14
        L42:
            int r0 = r0 + 1
            r7 = 1073741823(0x3fffffff, float:1.9999999)
            r0 = r0 & r7
            r7 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r7
            r20 = r7
            long r7 = (long) r0
            long r18 = r18 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.ki0.f
            r28 = r18
            r18 = r4
            r19 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L66
            r15.set(r13, r14)
            return r18
        L66:
            r1 = r30
            if (r19 == 0) goto L2
        L6a:
            long r24 = r6.get(r1)
            long r2 = r24 & r11
            int r0 = (int) r2
            long r2 = r24 & r16
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 == 0) goto L7d
            ki0 r0 = r1.d()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = defpackage.ki0.f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.d
            int r2 = r2.c
            r0 = r0 & r2
            r1.set(r0, r14)
            r1 = r14
        L96:
            if (r1 != 0) goto L6a
            return r18
        L99:
            r1 = r2
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ki0.e():java.lang.Object");
    }
}
