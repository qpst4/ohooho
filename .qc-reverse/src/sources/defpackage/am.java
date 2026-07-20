package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class am {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(am.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile = 0;
    public final Throwable a;

    public am(Throwable th) {
        this.a = th;
    }

    public final String toString() {
        return am.class.getSimpleName() + '[' + this.a + ']';
    }
}
