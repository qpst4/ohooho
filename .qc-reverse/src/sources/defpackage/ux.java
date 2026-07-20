package defpackage;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ux implements Runnable {
    public final /* synthetic */ int b;

    public /* synthetic */ ux(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                try {
                    int i = h71.a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (sx.k != null) {
                        sx.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i2 = h71.a;
                    Trace.endSection();
                    throw th;
                }
            default:
                return;
        }
    }

    private final void a() {
    }
}
