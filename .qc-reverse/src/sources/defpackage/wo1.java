package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wo1 {
    public static final wo1 b;
    public static final wo1 c;
    public final Throwable a;

    static {
        if (as1.e) {
            c = null;
            b = null;
        } else {
            c = new wo1(null);
            b = new wo1(null);
        }
    }

    public wo1(CancellationException cancellationException) {
        this.a = cancellationException;
    }
}
