package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class io1 extends AtomicReference implements Runnable {
    public static final ux d;
    public static final ux e;
    public final Callable b;
    public final /* synthetic */ jo1 c;

    static {
        int i = 1;
        d = new ux(i);
        e = new ux(i);
    }

    public io1(jo1 jo1Var, Callable callable) {
        this.c = jo1Var;
        callable.getClass();
        this.b = callable;
    }

    public final void a(Thread thread) {
        Runnable runnable = (Runnable) get();
        xn1 xn1Var = null;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = runnable instanceof xn1;
            ux uxVar = e;
            if (!z2) {
                if (runnable != uxVar) {
                    break;
                }
            } else {
                xn1Var = (xn1) runnable;
            }
            i++;
            if (i <= 1000) {
                Thread.yield();
            } else if (runnable == uxVar || compareAndSet(runnable, uxVar)) {
                z = Thread.interrupted() || z;
                LockSupport.park(xn1Var);
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            jo1 jo1Var = this.c;
            boolean zIsDone = jo1Var.isDone();
            ux uxVar = d;
            if (zIsDone) {
                objCall = null;
            } else {
                try {
                    objCall = this.b.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, uxVar)) {
                            a(threadCurrentThread);
                        }
                        jo1Var.d(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, uxVar)) {
                            a(threadCurrentThread);
                        }
                        if (on1.g.Z(jo1Var, null, on1.h)) {
                            on1.g(jo1Var);
                        }
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, uxVar)) {
                a(threadCurrentThread);
            }
            if (zIsDone) {
                return;
            }
            if (objCall == null) {
                objCall = on1.h;
            }
            if (on1.g.Z(jo1Var, null, objCall)) {
                on1.g(jo1Var);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable runnable = (Runnable) get();
        return (runnable == d ? "running=[DONE]" : runnable instanceof xn1 ? "running=[INTERRUPTED]" : runnable instanceof Thread ? l11.j("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]") + ", " + this.b.toString();
    }
}
