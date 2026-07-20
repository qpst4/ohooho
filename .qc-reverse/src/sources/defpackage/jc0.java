package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jc0 extends ad0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(jc0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;
    public final cd0 h;

    public jc0(cd0 cd0Var) {
        this.h = cd0Var;
    }

    @Override // defpackage.cd0
    public final void q(Throwable th) {
        if (i.compareAndSet(this, 0, 1)) {
            this.h.q(th);
        }
    }
}
