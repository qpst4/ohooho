package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b61 extends Handler {
    public final Runnable a;
    public long b;

    public b61(Runnable runnable, long j) {
        this.a = runnable;
        this.b = j;
    }

    public static void b(Runnable runnable, long j) {
        new b61(runnable, j).c();
    }

    public final void a() {
        d();
        c();
    }

    public final void c() {
        postDelayed(this.a, this.b);
    }

    public final void d() {
        removeCallbacks(this.a);
    }
}
