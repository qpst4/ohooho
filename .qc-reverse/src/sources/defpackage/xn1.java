package defpackage;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xn1 extends AbstractOwnableSynchronizer implements Runnable {
    public final io1 b;

    public /* synthetic */ xn1(io1 io1Var) {
        this.b = io1Var;
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
