package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i8 implements Executor {
    public final Object b = new Object();
    public final ArrayDeque c = new ArrayDeque();
    public final j8 d;
    public Runnable e;

    public i8(j8 j8Var) {
        this.d = j8Var;
    }

    public final void a() {
        synchronized (this.b) {
            try {
                Runnable runnable = (Runnable) this.c.poll();
                this.e = runnable;
                if (runnable != null) {
                    this.d.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.b) {
            try {
                this.c.add(new k2(this, 1, runnable));
                if (this.e == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
