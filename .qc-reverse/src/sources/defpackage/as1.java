package defpackage;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class as1 implements zn1 {
    public static final boolean e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(as1.class.getName());
    public static final f01 g;
    public static final Object h;
    public volatile Object b;
    public volatile fq1 c;
    public volatile xr1 d;

    static {
        f01 wr1Var;
        try {
            wr1Var = new gr1(AtomicReferenceFieldUpdater.newUpdater(xr1.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(xr1.class, xr1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(as1.class, xr1.class, "d"), AtomicReferenceFieldUpdater.newUpdater(as1.class, fq1.class, "c"), AtomicReferenceFieldUpdater.newUpdater(as1.class, Object.class, "b"));
            th = null;
        } catch (Throwable th) {
            th = th;
            wr1Var = new wr1();
        }
        Throwable th2 = th;
        g = wr1Var;
        if (th2 != null) {
            f.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        h = new Object();
    }

    public static void c(as1 as1Var) {
        xr1 xr1Var;
        fq1 fq1Var;
        fq1 fq1Var2;
        fq1 fq1Var3;
        do {
            xr1Var = as1Var.d;
        } while (!g.c0(as1Var, xr1Var, xr1.c));
        while (true) {
            fq1Var = null;
            if (xr1Var == null) {
                break;
            }
            Thread thread = xr1Var.a;
            if (thread != null) {
                xr1Var.a = null;
                LockSupport.unpark(thread);
            }
            xr1Var = xr1Var.b;
        }
        do {
            fq1Var2 = as1Var.c;
        } while (!g.Z(as1Var, fq1Var2, fq1.d));
        while (true) {
            fq1Var3 = fq1Var;
            fq1Var = fq1Var2;
            if (fq1Var == null) {
                break;
            }
            fq1Var2 = fq1Var.c;
            fq1Var.c = fq1Var3;
        }
        while (fq1Var3 != null) {
            Runnable runnable = fq1Var3.a;
            fq1 fq1Var4 = fq1Var3.c;
            e(runnable, fq1Var3.b);
            fq1Var3 = fq1Var4;
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e2);
        }
    }

    public static final Object g(Object obj) throws ExecutionException {
        if (obj instanceof wo1) {
            Throwable th = ((wo1) obj).a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof qp1) {
            throw new ExecutionException(((qp1) obj).a);
        }
        if (obj == h) {
            return null;
        }
        return obj;
    }

    @Override // defpackage.zn1
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        fq1 fq1Var = this.c;
        fq1 fq1Var2 = fq1.d;
        if (fq1Var != fq1Var2) {
            fq1 fq1Var3 = new fq1(runnable, executor);
            do {
                fq1Var3.c = fq1Var;
                if (g.Z(this, fq1Var, fq1Var3)) {
                    return;
                } else {
                    fq1Var = this.c;
                }
            } while (fq1Var != fq1Var2);
        }
        e(runnable, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String b() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.b;
        if (obj != null) {
            return false;
        }
        if (!g.a0(this, obj, e ? new wo1(new CancellationException("Future.cancel() was called.")) : z ? wo1.b : wo1.c)) {
            return false;
        }
        c(this);
        return true;
    }

    public final void d(StringBuilder sb) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e2) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e2.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e3) {
                sb.append("FAILURE, cause=[");
                sb.append(e3.getCause());
                sb.append("]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    public final void f(xr1 xr1Var) {
        xr1Var.a = null;
        while (true) {
            xr1 xr1Var2 = this.d;
            if (xr1Var2 != xr1.c) {
                xr1 xr1Var3 = null;
                while (xr1Var2 != null) {
                    xr1 xr1Var4 = xr1Var2.b;
                    if (xr1Var2.a != null) {
                        xr1Var3 = xr1Var2;
                    } else if (xr1Var3 != null) {
                        xr1Var3.b = xr1Var4;
                        if (xr1Var3.a == null) {
                            break;
                        }
                    } else if (!g.c0(this, xr1Var2, xr1Var4)) {
                        break;
                    }
                    xr1Var2 = xr1Var4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        xr1 xr1Var = xr1.c;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.b;
        if (obj != null) {
            return g(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            xr1 xr1Var2 = this.d;
            if (xr1Var2 != xr1Var) {
                xr1 xr1Var3 = new xr1();
                do {
                    f01 f01Var = g;
                    f01Var.W(xr1Var3, xr1Var2);
                    if (f01Var.c0(this, xr1Var2, xr1Var3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                f(xr1Var3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.b;
                            if (obj2 != null) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        f(xr1Var3);
                    } else {
                        xr1Var2 = this.d;
                    }
                } while (xr1Var2 != xr1Var);
            }
            return g(this.b);
        }
        while (nanos > 0) {
            Object obj3 = this.b;
            if (obj3 != null) {
                return g(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = true;
            if (jConvert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        ay0.a(strConcat, string);
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b instanceof wo1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b != null;
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.b instanceof wo1) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            d(sb);
        } else {
            try {
                strConcat = b();
            } catch (RuntimeException e2) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e2.getClass()));
            }
            if (strConcat != null && !strConcat.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strConcat);
                sb.append("]");
            } else if (isDone()) {
                d(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        xr1 xr1Var = xr1.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if (obj2 != null) {
                return g(obj2);
            }
            xr1 xr1Var2 = this.d;
            if (xr1Var2 != xr1Var) {
                xr1 xr1Var3 = new xr1();
                do {
                    f01 f01Var = g;
                    f01Var.W(xr1Var3, xr1Var2);
                    if (f01Var.c0(this, xr1Var2, xr1Var3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                f(xr1Var3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return g(obj);
                    }
                    xr1Var2 = this.d;
                } while (xr1Var2 != xr1Var);
            }
            return g(this.b);
        }
        throw new InterruptedException();
    }
}
