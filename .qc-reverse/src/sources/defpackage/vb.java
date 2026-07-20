package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vb extends a61 {
    public static final long h = 60000000000L;
    public static vb i;
    public boolean e;
    public vb f;
    public long g;

    public static vb h() throws InterruptedException {
        vb vbVar = i.f;
        if (vbVar == null) {
            long jNanoTime = System.nanoTime();
            vb.class.wait(60000L);
            if (i.f != null || System.nanoTime() - jNanoTime < h) {
                return null;
            }
            return i;
        }
        long jNanoTime2 = vbVar.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            long j = jNanoTime2 / 1000000;
            vb.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
            return null;
        }
        i.f = vbVar.f;
        vbVar.f = null;
        return vbVar;
    }

    public final void i() {
        vb vbVar;
        if (this.e) {
            s1.f("Unbalanced enter/exit");
            return;
        }
        long j = this.c;
        boolean z = this.a;
        if (j != 0 || z) {
            this.e = true;
            synchronized (vb.class) {
                try {
                    if (i == null) {
                        i = new vb();
                        ub ubVar = new ub("Okio Watchdog");
                        ubVar.setDaemon(true);
                        ubVar.start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (j != 0 && z) {
                        this.g = Math.min(j, c() - jNanoTime) + jNanoTime;
                    } else if (j != 0) {
                        this.g = j + jNanoTime;
                    } else {
                        if (!z) {
                            throw new AssertionError();
                        }
                        this.g = c();
                    }
                    long j2 = this.g - jNanoTime;
                    vb vbVar2 = i;
                    while (true) {
                        vbVar = vbVar2.f;
                        if (vbVar == null || j2 < vbVar.g - jNanoTime) {
                            break;
                        } else {
                            vbVar2 = vbVar;
                        }
                    }
                    this.f = vbVar;
                    vbVar2.f = this;
                    if (vbVar2 == i) {
                        vb.class.notify();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void j(boolean z) throws IOException {
        if (k() && z) {
            throw l(null);
        }
    }

    public final boolean k() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        synchronized (vb.class) {
            vb vbVar = i;
            while (vbVar != null) {
                vb vbVar2 = vbVar.f;
                if (vbVar2 == this) {
                    vbVar.f = this.f;
                    this.f = null;
                    return false;
                }
                vbVar = vbVar2;
            }
            return true;
        }
    }

    public IOException l(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void m() {
    }
}
