package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gr1 extends f01 {
    public final AtomicReferenceFieldUpdater m;
    public final AtomicReferenceFieldUpdater n;
    public final AtomicReferenceFieldUpdater o;
    public final AtomicReferenceFieldUpdater p;
    public final AtomicReferenceFieldUpdater q;

    public gr1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.m = atomicReferenceFieldUpdater;
        this.n = atomicReferenceFieldUpdater2;
        this.o = atomicReferenceFieldUpdater3;
        this.p = atomicReferenceFieldUpdater4;
        this.q = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.f01
    public final void W(xr1 xr1Var, xr1 xr1Var2) {
        this.n.lazySet(xr1Var, xr1Var2);
    }

    @Override // defpackage.f01
    public final void Y(xr1 xr1Var, Thread thread) {
        this.m.lazySet(xr1Var, thread);
    }

    @Override // defpackage.f01
    public final boolean Z(as1 as1Var, fq1 fq1Var, fq1 fq1Var2) {
        return xr.S(this.p, as1Var, fq1Var, fq1Var2);
    }

    @Override // defpackage.f01
    public final boolean a0(as1 as1Var, Object obj, Object obj2) {
        return xr.S(this.q, as1Var, obj, obj2);
    }

    @Override // defpackage.f01
    public final boolean c0(as1 as1Var, xr1 xr1Var, xr1 xr1Var2) {
        return xr.S(this.o, as1Var, xr1Var, xr1Var2);
    }
}
