package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jo1 extends un1 implements RunnableFuture {
    public volatile io1 i;

    public jo1(Callable callable) {
        this.i = new io1(this, callable);
    }

    @Override // defpackage.on1
    public final String b() {
        io1 io1Var = this.i;
        return io1Var != null ? l11.j("task=[", io1Var.toString(), "]") : super.b();
    }

    @Override // defpackage.on1
    public final void c() {
        io1 io1Var;
        Object obj = this.b;
        if ((obj instanceof dn1) && ((dn1) obj).a && (io1Var = this.i) != null) {
            ux uxVar = io1.e;
            ux uxVar2 = io1.d;
            Runnable runnable = (Runnable) io1Var.get();
            if (runnable instanceof Thread) {
                xn1 xn1Var = new xn1(io1Var);
                xn1Var.setExclusiveOwnerThread(Thread.currentThread());
                if (io1Var.compareAndSet(runnable, xn1Var)) {
                    try {
                        Thread thread = (Thread) runnable;
                        thread.interrupt();
                        if (((Runnable) io1Var.getAndSet(uxVar2)) == uxVar) {
                            LockSupport.unpark(thread);
                        }
                    } catch (Throwable th) {
                        if (((Runnable) io1Var.getAndSet(uxVar2)) == uxVar) {
                            LockSupport.unpark((Thread) runnable);
                        }
                        throw th;
                    }
                }
            }
        }
        this.i = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        io1 io1Var = this.i;
        if (io1Var != null) {
            io1Var.run();
        }
        this.i = null;
    }
}
