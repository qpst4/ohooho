package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u90 implements Closeable {
    public static final ThreadPoolExecutor v;
    public final boolean b;
    public final q90 c;
    public final String e;
    public int f;
    public int g;
    public boolean h;
    public final ScheduledThreadPoolExecutor i;
    public final ThreadPoolExecutor j;
    public final ow0 k;
    public boolean l;
    public long n;
    public final jl1 o;
    public final jl1 p;
    public boolean q;
    public final Socket r;
    public final ba0 s;
    public final s90 t;
    public final LinkedHashSet u;
    public final LinkedHashMap d = new LinkedHashMap();
    public long m = 0;

    static {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = be1.a;
        v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, synchronousQueue, new ae1("OkHttp Http2Connection", true));
    }

    public u90(o90 o90Var) {
        jl1 jl1Var = new jl1(8);
        this.o = jl1Var;
        jl1 jl1Var2 = new jl1(8);
        this.p = jl1Var2;
        this.q = false;
        this.u = new LinkedHashSet();
        this.k = ow0.g;
        boolean z = o90Var.b;
        this.b = z;
        this.c = (q90) o90Var.g;
        int i = z ? 1 : 2;
        this.g = i;
        if (z) {
            this.g = i + 2;
        }
        if (z) {
            jl1Var.e(7, 16777216);
        }
        String str = (String) o90Var.d;
        this.e = str;
        byte[] bArr = be1.a;
        Locale locale = Locale.US;
        this.i = new ScheduledThreadPoolExecutor(1, new ae1(l11.j("OkHttp ", str, " Writer"), false));
        this.j = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ae1(l11.j("OkHttp ", str, " Push Observer"), true));
        jl1Var2.e(7, 65535);
        jl1Var2.e(5, 16384);
        this.n = jl1Var2.d();
        this.r = (Socket) o90Var.c;
        this.s = new ba0((ft0) o90Var.f, z);
        this.t = new s90(this, new w90((gt0) o90Var.e, z));
    }

    public final void a(int i, int i2) throws IOException {
        aa0[] aa0VarArr = null;
        try {
            r(i);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (!this.d.isEmpty()) {
                    aa0VarArr = (aa0[]) this.d.values().toArray(new aa0[this.d.size()]);
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aa0VarArr != null) {
            for (aa0 aa0Var : aa0VarArr) {
                try {
                    aa0Var.c(i2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.s.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.r.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.i.shutdown();
        this.j.shutdown();
        if (e != null) {
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(1, 6);
    }

    public final void flush() {
        this.s.flush();
    }

    public final void g() {
        try {
            a(2, 2);
        } catch (IOException unused) {
        }
    }

    public final synchronized aa0 h(int i) {
        return (aa0) this.d.get(Integer.valueOf(i));
    }

    public final synchronized int i() {
        jl1 jl1Var;
        jl1Var = this.p;
        return (jl1Var.b & 16) != 0 ? ((int[]) jl1Var.c)[4] : Integer.MAX_VALUE;
    }

    public final synchronized void m(km0 km0Var) {
        synchronized (this) {
        }
        if (!this.h) {
            this.j.execute(km0Var);
        }
    }

    public final synchronized aa0 q(int i) {
        aa0 aa0Var;
        aa0Var = (aa0) this.d.remove(Integer.valueOf(i));
        notifyAll();
        return aa0Var;
    }

    public final void r(int i) {
        synchronized (this.s) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                this.h = true;
                this.s.i(be1.a, this.f, i);
            }
        }
    }

    public final synchronized void s(long j) {
        long j2 = this.m + j;
        this.m = j2;
        if (j2 >= this.o.d() / 2) {
            v(0, this.m);
            this.m = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.s.e);
        r6 = r2;
        r8.n -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(int r9, boolean r10, defpackage.mh r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            ba0 r8 = r8.s
            r8.g(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L65
            monitor-enter(r8)
        L12:
            long r4 = r8.n     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.LinkedHashMap r2 = r8.d     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            goto L12
        L28:
            r9 = move-exception
            goto L63
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            ba0 r4 = r8.s     // Catch: java.lang.Throwable -> L28
            int r4 = r4.e     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.n     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.n = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            ba0 r4 = r8.s
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.g(r5, r9, r11, r2)
            goto Ld
        L56:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L63:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u90.t(int, boolean, mh, long):void");
    }

    public final void u(int i, int i2) {
        try {
            this.i.execute(new k90(this, new Object[]{this.e, Integer.valueOf(i)}, i, i2));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void v(int i, long j) {
        try {
            this.i.execute(new l90(this, new Object[]{this.e, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }
}
