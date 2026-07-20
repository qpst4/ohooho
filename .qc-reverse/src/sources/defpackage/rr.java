package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rr {
    public final long b;
    public final long c;
    public final Handler a = new Handler();
    public long d = 0;

    public rr(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    public final void a(Runnable runnable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.d == 0) {
            this.d = jCurrentTimeMillis;
        }
        Handler handler = this.a;
        handler.removeCallbacksAndMessages(null);
        if (jCurrentTimeMillis - this.d <= this.c) {
            handler.postDelayed(new k2(this, 12, runnable), this.b);
        } else {
            this.d = jCurrentTimeMillis;
            runnable.run();
        }
    }
}
