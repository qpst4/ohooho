package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class a61 {
    public static final z51 d = new z51();
    public boolean a;
    public long b;
    public long c;

    public a61 a() {
        this.a = false;
        return this;
    }

    public a61 b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        s1.f("No deadline");
        return 0L;
    }

    public a61 d(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public a61 g(long j) {
        if (j < 0) {
            s1.i("timeout < 0: ", j);
            return null;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (timeUnit != null) {
            this.c = timeUnit.toNanos(j);
            return this;
        }
        zy.n("unit == null");
        return null;
    }
}
