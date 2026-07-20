package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends fc0 {
    public final AtomicReferenceFieldUpdater l;
    public final AtomicReferenceFieldUpdater m;
    public final AtomicReferenceFieldUpdater n;
    public final AtomicReferenceFieldUpdater o;
    public final AtomicReferenceFieldUpdater p;

    public r(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.l = atomicReferenceFieldUpdater;
        this.m = atomicReferenceFieldUpdater2;
        this.n = atomicReferenceFieldUpdater3;
        this.o = atomicReferenceFieldUpdater4;
        this.p = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.fc0
    public final void G(t tVar, t tVar2) {
        this.m.lazySet(tVar, tVar2);
    }

    @Override // defpackage.fc0
    public final void H(t tVar, Thread thread) {
        this.l.lazySet(tVar, thread);
    }

    @Override // defpackage.fc0
    public final boolean e(u uVar, q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.o;
            if (atomicReferenceFieldUpdater.compareAndSet(uVar, qVar, q.b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(uVar) == qVar);
        return false;
    }

    @Override // defpackage.fc0
    public final boolean f(u uVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.p;
            if (atomicReferenceFieldUpdater.compareAndSet(uVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(uVar) == obj);
        return false;
    }

    @Override // defpackage.fc0
    public final boolean g(u uVar, t tVar, t tVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.n;
            if (atomicReferenceFieldUpdater.compareAndSet(uVar, tVar, tVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(uVar) == tVar);
        return false;
    }
}
