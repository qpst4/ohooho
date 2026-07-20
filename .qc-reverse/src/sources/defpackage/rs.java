package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rs extends wz {
    public static final rs e;
    public lp d;

    static {
        int i = p41.c;
        int i2 = p41.d;
        long j = p41.e;
        String str = p41.a;
        rs rsVar = new rs();
        rsVar.d = new lp(i, i2, j, str);
        e = rsVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.hp
    public final void q(ep epVar, Runnable runnable) {
        this.d.g(runnable, p41.g);
    }

    @Override // defpackage.hp
    public final String toString() {
        return "Dispatchers.Default";
    }
}
