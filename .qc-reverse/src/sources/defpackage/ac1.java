package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ac1 implements gb1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ fb1 d;

    public /* synthetic */ ac1(Class cls, fb1 fb1Var, int i) {
        this.b = i;
        this.c = cls;
        this.d = fb1Var;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        int i = this.b;
        Class cls = this.c;
        switch (i) {
            case 0:
                if (mc1Var.a() == cls) {
                    return this.d;
                }
                return null;
            default:
                Class<?> clsA = mc1Var.a();
                if (cls.isAssignableFrom(clsA)) {
                    return new hl(this, clsA);
                }
                return null;
        }
    }

    public final String toString() {
        int i = this.b;
        fb1 fb1Var = this.d;
        Class cls = this.c;
        switch (i) {
            case 0:
                return "Factory[type=" + cls.getName() + ",adapter=" + fb1Var + "]";
            default:
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + fb1Var + "]";
        }
    }
}
