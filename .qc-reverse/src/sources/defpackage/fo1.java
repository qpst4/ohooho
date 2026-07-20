package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fo1 extends ao1 implements ScheduledExecutorService {
    public final ScheduledExecutorService c;

    public fo1(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.c = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        jo1 jo1Var = new jo1(Executors.callable(runnable, null));
        return new bo1(jo1Var, this.c.schedule(jo1Var, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        co1 co1Var = new co1(runnable);
        return new bo1(co1Var, this.c.scheduleAtFixedRate(co1Var, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        co1 co1Var = new co1(runnable);
        return new bo1(co1Var, this.c.scheduleWithFixedDelay(co1Var, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        jo1 jo1Var = new jo1(callable);
        return new bo1(jo1Var, this.c.schedule(jo1Var, j, timeUnit));
    }
}
