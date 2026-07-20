package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class in1 implements Runnable {
    public final on1 b;
    public final zn1 c;

    public in1(on1 on1Var, zn1 zn1Var) {
        this.b = on1Var;
        this.c = zn1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.b != this) {
            return;
        }
        zn1 zn1Var = this.c;
        if (on1.g.Z(this.b, this, on1.e(zn1Var))) {
            on1.g(this.b);
        }
    }
}
