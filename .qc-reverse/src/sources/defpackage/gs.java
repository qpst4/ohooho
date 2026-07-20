package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gs extends wz implements Executor {
    public static final gs d = new gs();
    public static final hp e;

    static {
        hp jg0Var = dd1.d;
        int i = v31.a;
        if (64 >= i) {
            i = 64;
        }
        int iO = f01.O(i, 12, "kotlinx.coroutines.io.parallelism");
        jg0Var.getClass();
        if (iO < 1) {
            throw new IllegalArgumentException(qq0.i("Expected positive parallelism level, but got ", iO).toString());
        }
        if (iO < p41.d) {
            if (iO < 1) {
                throw new IllegalArgumentException(qq0.i("Expected positive parallelism level, but got ", iO).toString());
            }
            jg0Var = new jg0(jg0Var, iO);
        }
        e = jg0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        q(my.b, runnable);
    }

    @Override // defpackage.hp
    public final void q(ep epVar, Runnable runnable) {
        e.q(epVar, runnable);
    }

    @Override // defpackage.hp
    public final String toString() {
        return "Dispatchers.IO";
    }
}
