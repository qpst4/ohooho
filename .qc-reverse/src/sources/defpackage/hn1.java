package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hn1 extends tk0 {
    public final AtomicReferenceFieldUpdater l;
    public final AtomicReferenceFieldUpdater m;
    public final AtomicReferenceFieldUpdater n;
    public final AtomicReferenceFieldUpdater o;
    public final AtomicReferenceFieldUpdater p;

    public hn1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.l = atomicReferenceFieldUpdater;
        this.m = atomicReferenceFieldUpdater2;
        this.n = atomicReferenceFieldUpdater3;
        this.o = atomicReferenceFieldUpdater4;
        this.p = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.tk0
    public final gn1 S(on1 on1Var) {
        return (gn1) this.o.getAndSet(on1Var, gn1.d);
    }

    @Override // defpackage.tk0
    public final nn1 T(on1 on1Var) {
        return (nn1) this.n.getAndSet(on1Var, nn1.c);
    }

    @Override // defpackage.tk0
    public final void W(nn1 nn1Var, nn1 nn1Var2) {
        this.m.lazySet(nn1Var, nn1Var2);
    }

    @Override // defpackage.tk0
    public final void X(nn1 nn1Var, Thread thread) {
        this.l.lazySet(nn1Var, thread);
    }

    @Override // defpackage.tk0
    public final boolean Y(on1 on1Var, gn1 gn1Var, gn1 gn1Var2) {
        return xy0.O(this.o, on1Var, gn1Var, gn1Var2);
    }

    @Override // defpackage.tk0
    public final boolean Z(on1 on1Var, Object obj, Object obj2) {
        return xy0.O(this.p, on1Var, obj, obj2);
    }

    @Override // defpackage.tk0
    public final boolean a0(on1 on1Var, nn1 nn1Var, nn1 nn1Var2) {
        return xy0.O(this.n, on1Var, nn1Var, nn1Var2);
    }
}
