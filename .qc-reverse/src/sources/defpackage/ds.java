package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends rz implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final ds l;
    public static final long m;

    static {
        Long l2;
        ds dsVar = new ds();
        l = dsVar;
        dsVar.d = 1 + dsVar.d;
        dsVar.e = true;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        m = TimeUnit.MILLISECONDS.toNanos(l2.longValue());
    }

    public final synchronized void E() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            D();
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        o51.a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (zA) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jB = B();
                    if (jB == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = m + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            E();
                            if (A()) {
                                return;
                            }
                            z();
                            return;
                        }
                        if (jB > j2) {
                            jB = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jB > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            E();
                            if (A()) {
                                return;
                            }
                            z();
                            return;
                        }
                        LockSupport.parkNanos(this, jB);
                    }
                }
            }
        } finally {
            _thread = null;
            E();
            if (!A()) {
                z();
            }
        }
    }

    @Override // defpackage.rz, defpackage.pz
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // defpackage.rz
    public final void w(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.w(runnable);
    }

    @Override // defpackage.rz
    public final Thread z() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(ds.class.getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }
}
