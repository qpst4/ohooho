package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fs1 implements zn1 {
    public final WeakReference b;
    public final ds1 c = new ds1(this);

    public fs1(bs1 bs1Var) {
        this.b = new WeakReference(bs1Var);
    }

    @Override // defpackage.zn1
    public final void a(Runnable runnable, Executor executor) {
        this.c.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        bs1 bs1Var = (bs1) this.b.get();
        boolean zCancel = this.c.cancel(z);
        if (!zCancel || bs1Var == null) {
            return zCancel;
        }
        bs1Var.a = null;
        bs1Var.b = null;
        bs1Var.c.h(null);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.c.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.c.b instanceof wo1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.c.isDone();
    }

    public final String toString() {
        return this.c.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.c.get(j, timeUnit);
    }
}
