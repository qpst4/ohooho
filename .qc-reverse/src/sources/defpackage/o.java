package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o b;
    public static final o c;
    public final Throwable a;

    static {
        if (u.e) {
            c = null;
            b = null;
        } else {
            c = new o(false, null);
            b = new o(true, null);
        }
    }

    public o(boolean z, Throwable th) {
        this.a = th;
    }
}
