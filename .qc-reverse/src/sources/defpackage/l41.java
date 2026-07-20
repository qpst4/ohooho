package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l41 {
    public final xa1 a;

    public l41() {
        xa1 xa1Var = new xa1();
        xa1Var.b = new Object();
        xa1Var.c = new qx0();
        this.a = xa1Var;
    }

    public final void a(Exception exc) {
        xa1 xa1Var = this.a;
        xa1Var.getClass();
        xy0.e("Exception must not be null", exc);
        synchronized (xa1Var.b) {
            try {
                if (xa1Var.a) {
                    return;
                }
                xa1Var.a = true;
                xa1Var.e = exc;
                ((qx0) xa1Var.c).e(xa1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
