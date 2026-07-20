package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p50 implements Cloneable {
    public final w50 b;
    public w50 c;
    public boolean d = false;

    public p50(w50 w50Var) {
        this.b = w50Var;
        this.c = (w50) w50Var.b(null, 5, null);
    }

    public final w50 a() {
        w50 w50VarB = b();
        if (w50VarB.b(Boolean.TRUE, 1, null) != null) {
            return w50VarB;
        }
        throw new cm();
    }

    public final w50 b() {
        boolean z = this.d;
        w50 w50Var = this.c;
        if (z) {
            return w50Var;
        }
        w50Var.g();
        this.d = true;
        return this.c;
    }

    public final void c() {
        if (this.d) {
            w50 w50Var = (w50) this.c.b(null, 5, null);
            w50Var.n(u50.a, this.c);
            this.c = w50Var;
            this.d = false;
        }
    }

    public final Object clone() {
        p50 p50Var = (p50) this.b.b(null, 6, null);
        p50Var.d(b());
        return p50Var;
    }

    public final p50 d(w50 w50Var) {
        c();
        this.c.n(u50.a, w50Var);
        return this;
    }
}
