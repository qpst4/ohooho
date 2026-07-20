package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cc1 implements gb1 {
    public final /* synthetic */ Class b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ fb1 d;

    public cc1(Class cls, Class cls2, fb1 fb1Var) {
        this.b = cls;
        this.c = cls2;
        this.d = fb1Var;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Class clsA = mc1Var.a();
        if (clsA == this.b || clsA == this.c) {
            return this.d;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.c.getName() + "+" + this.b.getName() + ",adapter=" + this.d + "]";
    }
}
