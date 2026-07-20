package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jg0 extends hp implements zs {
    public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(jg0.class, "runningWorkers$volatile");
    public final hp d;
    public final int e;
    public final ii0 f;
    public final Object g;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public jg0(hp hpVar, int i) {
        this.d = hpVar;
        this.e = i;
        if ((hpVar instanceof zs ? (zs) hpVar : null) == null) {
            int i2 = es.a;
        }
        this.f = new ii0();
        this.g = new Object();
    }

    @Override // defpackage.hp
    public final void q(ep epVar, Runnable runnable) {
        this.f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h;
        if (atomicIntegerFieldUpdater.get(this) < this.e) {
            synchronized (this.g) {
                if (atomicIntegerFieldUpdater.get(this) >= this.e) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableS = s();
                if (runnableS == null) {
                    return;
                }
                this.d.q(this, new vn1(this, runnableS, 8, false));
            }
        }
    }

    public final Runnable s() {
        while (true) {
            Runnable runnable = (Runnable) this.f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
