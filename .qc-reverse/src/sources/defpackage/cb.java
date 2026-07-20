package defpackage;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cb extends lc1 {
    public static volatile cb o;
    public final Object n;

    public cb(int i) {
        switch (i) {
            case 1:
                this.n = new Object();
                Executors.newFixedThreadPool(4, new ys());
                break;
            default:
                this.n = new cb(1);
                break;
        }
    }

    public static cb K0() {
        if (o != null) {
            return o;
        }
        synchronized (cb.class) {
            try {
                if (o == null) {
                    o = new cb(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o;
    }
}
