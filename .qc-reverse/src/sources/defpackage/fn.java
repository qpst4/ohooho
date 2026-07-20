package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fn implements bz0 {
    public final AtomicReference a;

    public fn(bz0 bz0Var) {
        this.a = new AtomicReference(bz0Var);
    }

    @Override // defpackage.bz0
    public final Iterator iterator() {
        bz0 bz0Var = (bz0) this.a.getAndSet(null);
        if (bz0Var != null) {
            return bz0Var.iterator();
        }
        s1.f("This sequence can be consumed only once.");
        return null;
    }
}
