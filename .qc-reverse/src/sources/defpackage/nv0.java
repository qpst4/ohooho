package defpackage;

import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nv0 extends Thread {
    public final int b;

    public nv0(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.b = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);
        super.run();
    }
}
