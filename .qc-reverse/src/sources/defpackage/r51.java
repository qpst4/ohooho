package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r51 {
    public final boolean a;
    public long b;
    public final long c;
    public final Handler d = new Handler();

    public r51(long j, boolean z) {
        this.c = j;
        this.a = z;
    }

    public final void a(Runnable runnable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.b;
        long j2 = this.c;
        Handler handler = this.d;
        if (j >= j2) {
            runnable.run();
            this.b = jCurrentTimeMillis;
            handler.removeCallbacksAndMessages(null);
        } else if (this.a) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(runnable, j2);
        }
    }
}
