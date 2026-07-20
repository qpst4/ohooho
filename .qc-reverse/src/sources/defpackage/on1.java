package defpackage;

import java.util.Locale;
import java.util.Objects;
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
public abstract class on1 implements zn1 {
    public static final boolean e;
    public static final yn1 f;
    public static final tk0 g;
    public static final Object h;
    public volatile Object b;
    public volatile gn1 c;
    public volatile nn1 d;

    static {
        boolean z;
        tk0 jn1Var;
        Throwable th;
        Throwable th2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        e = z;
        f = new yn1(on1.class);
        try {
            jn1Var = new mn1();
            th = null;
            th2 = null;
        } catch (Error | Exception e2) {
            try {
                th2 = e2;
                jn1Var = new hn1(AtomicReferenceFieldUpdater.newUpdater(nn1.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(nn1.class, nn1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(on1.class, nn1.class, "d"), AtomicReferenceFieldUpdater.newUpdater(on1.class, gn1.class, "c"), AtomicReferenceFieldUpdater.newUpdater(on1.class, Object.class, "b"));
                th = null;
            } catch (Error | Exception e3) {
                jn1Var = new jn1();
                th = e3;
                th2 = e2;
            }
        }
        g = jn1Var;
        if (th != null) {
            yn1 yn1Var = f;
            Logger loggerA = yn1Var.a();
            Level level = Level.SEVERE;
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            yn1Var.a().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object e(defpackage.zn1 r6) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.on1.e(zn1):java.lang.Object");
    }

    public static void g(on1 on1Var) {
        gn1 gn1Var;
        gn1 gn1Var2 = null;
        while (true) {
            for (nn1 nn1VarT = g.T(on1Var); nn1VarT != null; nn1VarT = nn1VarT.b) {
                Thread thread = nn1VarT.a;
                if (thread != null) {
                    nn1VarT.a = null;
                    LockSupport.unpark(thread);
                }
            }
            on1Var.c();
            gn1 gn1Var3 = gn1Var2;
            gn1 gn1VarS = g.S(on1Var);
            gn1 gn1Var4 = gn1Var3;
            while (gn1VarS != null) {
                gn1 gn1Var5 = gn1VarS.c;
                gn1VarS.c = gn1Var4;
                gn1Var4 = gn1VarS;
                gn1VarS = gn1Var5;
            }
            while (gn1Var4 != null) {
                Runnable runnable = gn1Var4.a;
                gn1Var = gn1Var4.c;
                Objects.requireNonNull(runnable);
                if (runnable instanceof in1) {
                    in1 in1Var = (in1) runnable;
                    on1Var = in1Var.b;
                    if (on1Var.b == in1Var) {
                        if (g.Z(on1Var, in1Var, e(in1Var.c))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = gn1Var4.b;
                    Objects.requireNonNull(executor);
                    h(runnable, executor);
                }
                gn1Var4 = gn1Var;
            }
            return;
            gn1Var2 = gn1Var;
        }
    }

    public static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            f.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e2);
        }
    }

    public static final Object j(Object obj) throws ExecutionException {
        if (obj instanceof dn1) {
            Throwable th = ((dn1) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof fn1) {
            throw new ExecutionException(((fn1) obj).a);
        }
        if (obj == h) {
            return null;
        }
        return obj;
    }

    @Override // defpackage.zn1
    public final void a(Runnable runnable, Executor executor) {
        gn1 gn1Var;
        gn1 gn1Var2 = gn1.d;
        if (executor == null) {
            zy.r("Executor was null.");
            return;
        }
        if (!isDone() && (gn1Var = this.c) != gn1Var2) {
            gn1 gn1Var3 = new gn1(runnable, executor);
            do {
                gn1Var3.c = gn1Var;
                if (g.Y(this, gn1Var, gn1Var3)) {
                    return;
                } else {
                    gn1Var = this.c;
                }
            } while (gn1Var != gn1Var2);
        }
        h(runnable, executor);
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
        dn1 dn1Var;
        Object obj = this.b;
        if (!(obj instanceof in1) && !(obj == null)) {
            return false;
        }
        if (e) {
            dn1Var = new dn1(z, new CancellationException("Future.cancel() was called."));
        } else {
            dn1Var = z ? dn1.c : dn1.d;
            Objects.requireNonNull(dn1Var);
        }
        boolean z2 = false;
        while (true) {
            if (g.Z(this, obj, dn1Var)) {
                g(this);
                if (!(obj instanceof in1)) {
                    break;
                }
                zn1 zn1Var = ((in1) obj).c;
                if (!(zn1Var instanceof kn1)) {
                    zn1Var.cancel(z);
                    break;
                }
                this = (on1) zn1Var;
                obj = this.b;
                if (!(obj == null) && !(obj instanceof in1)) {
                    break;
                }
                z2 = true;
            } else {
                obj = this.b;
                if (!(obj instanceof in1)) {
                    return z2;
                }
            }
        }
        return true;
    }

    public final void d(Throwable th) {
        if (g.Z(this, null, new fn1(th))) {
            g(this);
        }
    }

    public final void f(StringBuilder sb) {
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
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append("]");
                return;
            } catch (Exception e3) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e3.getClass());
                sb.append(" thrown from get()]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long j2;
        nn1 nn1Var = nn1.c;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.b;
        if ((obj != null) && (!(obj instanceof in1))) {
            return j(obj);
        }
        long j3 = 0;
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            nn1 nn1Var2 = this.d;
            if (nn1Var2 != nn1Var) {
                nn1 nn1Var3 = new nn1();
                z = true;
                while (true) {
                    tk0 tk0Var = g;
                    tk0Var.W(nn1Var3, nn1Var2);
                    if (tk0Var.a0(this, nn1Var2, nn1Var3)) {
                        j2 = j3;
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                i(nn1Var3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.b;
                            if ((obj2 != null) && (!(obj2 instanceof in1))) {
                                return j(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        i(nn1Var3);
                    } else {
                        long j4 = j3;
                        nn1Var2 = this.d;
                        if (nn1Var2 == nn1Var) {
                            break;
                        }
                        j3 = j4;
                    }
                }
            }
            Object obj3 = this.b;
            Objects.requireNonNull(obj3);
            return j(obj3);
        }
        z = true;
        j2 = 0;
        while (nanos > j2) {
            Object obj4 = this.b;
            if ((obj4 != null ? z : false) && (!(obj4 instanceof in1))) {
                return j(obj4);
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
        if (nanos + 1000 < j2) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j5 = -nanos;
            long jConvert = timeUnit.convert(j5, TimeUnit.NANOSECONDS);
            long nanos2 = j5 - timeUnit.toNanos(jConvert);
            if (jConvert != j2 && nanos2 <= 1000) {
                z = false;
            }
            if (jConvert > j2) {
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

    public final void i(nn1 nn1Var) {
        nn1Var.a = null;
        while (true) {
            nn1 nn1Var2 = this.d;
            if (nn1Var2 != nn1.c) {
                nn1 nn1Var3 = null;
                while (nn1Var2 != null) {
                    nn1 nn1Var4 = nn1Var2.b;
                    if (nn1Var2.a != null) {
                        nn1Var3 = nn1Var2;
                    } else if (nn1Var3 != null) {
                        nn1Var3.b = nn1Var4;
                        if (nn1Var3.a == null) {
                            break;
                        }
                    } else if (!g.a0(this, nn1Var2, nn1Var4)) {
                        break;
                    }
                    nn1Var2 = nn1Var4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b instanceof dn1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.b != null) & (!(r2 instanceof in1));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.on1.toString():java.lang.String");
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        nn1 nn1Var = nn1.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if ((obj2 != null) & (!(obj2 instanceof in1))) {
                return j(obj2);
            }
            nn1 nn1Var2 = this.d;
            if (nn1Var2 != nn1Var) {
                nn1 nn1Var3 = new nn1();
                do {
                    tk0 tk0Var = g;
                    tk0Var.W(nn1Var3, nn1Var2);
                    if (tk0Var.a0(this, nn1Var2, nn1Var3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                i(nn1Var3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof in1))));
                        return j(obj);
                    }
                    nn1Var2 = this.d;
                } while (nn1Var2 != nn1Var);
            }
            Object obj3 = this.b;
            Objects.requireNonNull(obj3);
            return j(obj3);
        }
        throw new InterruptedException();
    }
}
