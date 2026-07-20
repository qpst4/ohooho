package defpackage;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements Future {
    public static final boolean e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(u.class.getName());
    public static final fc0 g;
    public static final Object h;
    public volatile Object b;
    public volatile q c;
    public volatile t d;

    static {
        fc0 sVar;
        try {
            sVar = new r(AtomicReferenceFieldUpdater.newUpdater(t.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(t.class, t.class, "b"), AtomicReferenceFieldUpdater.newUpdater(u.class, t.class, "d"), AtomicReferenceFieldUpdater.newUpdater(u.class, q.class, "c"), AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "b"));
            th = null;
        } catch (Throwable th) {
            th = th;
            sVar = new s();
        }
        g = sVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    public static void c(u uVar) {
        t tVar;
        q qVar;
        do {
            tVar = uVar.d;
        } while (!g.g(uVar, tVar, t.c));
        while (tVar != null) {
            Thread thread = tVar.a;
            if (thread != null) {
                tVar.a = null;
                LockSupport.unpark(thread);
            }
            tVar = tVar.b;
        }
        do {
            qVar = uVar.c;
        } while (!g.e(uVar, qVar));
        q qVar2 = null;
        while (qVar != null) {
            q qVar3 = qVar.a;
            qVar.a = qVar2;
            qVar2 = qVar;
            qVar = qVar3;
        }
        while (qVar2 != null) {
            qVar2 = qVar2.a;
            try {
                throw null;
            } catch (RuntimeException e2) {
                f.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e2);
            }
        }
    }

    public static Object d(Object obj) throws ExecutionException {
        if (obj instanceof o) {
            Throwable th = ((o) obj).a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof p) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == h) {
            return null;
        }
        return obj;
    }

    public static Object e(u uVar) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = uVar.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void b(StringBuilder sb) {
        try {
            Object objE = e(this);
            sb.append("SUCCESS, result=[");
            sb.append(objE == this ? "this future" : String.valueOf(objE));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.b;
        if (obj != null) {
            return false;
        }
        if (!g.f(this, obj, e ? new o(z, new CancellationException("Future.cancel() was called.")) : z ? o.b : o.c)) {
            return false;
        }
        c(this);
        return true;
    }

    public final void f(t tVar) {
        tVar.a = null;
        while (true) {
            t tVar2 = this.d;
            if (tVar2 == t.c) {
                return;
            }
            t tVar3 = null;
            while (tVar2 != null) {
                t tVar4 = tVar2.b;
                if (tVar2.a != null) {
                    tVar3 = tVar2;
                } else if (tVar3 != null) {
                    tVar3.b = tVar4;
                    if (tVar3.a == null) {
                        break;
                    }
                } else if (!g.g(this, tVar2, tVar4)) {
                    break;
                }
                tVar2 = tVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        t tVar = t.c;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.b;
        if (obj != null) {
            return d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            t tVar2 = this.d;
            if (tVar2 != tVar) {
                t tVar3 = new t();
                do {
                    fc0 fc0Var = g;
                    fc0Var.G(tVar3, tVar2);
                    if (fc0Var.g(this, tVar2, tVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                f(tVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.b;
                            if (obj2 != null) {
                                return d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        f(tVar3);
                    } else {
                        tVar2 = this.d;
                    }
                } while (tVar2 != tVar);
            }
            return d(this.b);
        }
        while (nanos > 0) {
            Object obj3 = this.b;
            if (obj3 != null) {
                return d(obj3);
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
            boolean z = jConvert == 0 || nanos2 > 1000;
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
        return this.b instanceof o;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.b instanceof o) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
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
        t tVar = t.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if (obj2 != null) {
                return d(obj2);
            }
            t tVar2 = this.d;
            if (tVar2 != tVar) {
                t tVar3 = new t();
                do {
                    fc0 fc0Var = g;
                    fc0Var.G(tVar3, tVar2);
                    if (fc0Var.g(this, tVar2, tVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                f(tVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return d(obj);
                    }
                    tVar2 = this.d;
                } while (tVar2 != tVar);
            }
            return d(this.b);
        }
        throw new InterruptedException();
    }
}
