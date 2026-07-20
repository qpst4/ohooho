package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class co1 extends on1 implements Runnable, kn1 {
    public final Runnable i;

    public co1(Runnable runnable) {
        runnable.getClass();
        this.i = runnable;
    }

    @Override // defpackage.on1
    public final String b() {
        return l11.j("task=[", this.i.toString(), "]");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.i.run();
        } catch (Throwable th) {
            d(th);
            throw th;
        }
    }
}
