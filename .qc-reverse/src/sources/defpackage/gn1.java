package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gn1 {
    public static final gn1 d = new gn1();
    public final Runnable a;
    public final Executor b;
    public gn1 c;

    public gn1() {
        this.a = null;
        this.b = null;
    }

    public gn1(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
