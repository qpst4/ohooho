package defpackage;

import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bo1 extends i1 implements ScheduledFuture, zn1, Future {
    public final on1 p;
    public final ScheduledFuture q;

    public bo1(on1 on1Var, ScheduledFuture scheduledFuture) {
        super(24);
        this.p = on1Var;
        this.q = scheduledFuture;
    }

    @Override // defpackage.zn1
    public final void a(Runnable runnable, Executor executor) {
        this.p.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean zCancel = this.p.cancel(z);
        if (zCancel) {
            this.q.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.q.compareTo(delayed);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.p.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.q.getDelay(timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.p.b instanceof dn1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.p.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.p.get(j, timeUnit);
    }
}
