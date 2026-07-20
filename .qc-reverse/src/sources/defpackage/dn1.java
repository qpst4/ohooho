package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dn1 {
    public static final dn1 c;
    public static final dn1 d;
    public final boolean a;
    public final Throwable b;

    static {
        if (on1.e) {
            d = null;
            c = null;
        } else {
            d = new dn1(false, null);
            c = new dn1(true, null);
        }
    }

    public dn1(boolean z, Throwable th) {
        this.a = z;
        this.b = th;
    }
}
