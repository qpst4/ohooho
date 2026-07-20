package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class yh0 extends bg1 {
    public static final c70 d = new c70(20);
    public final t11 c = new t11();

    @Override // defpackage.bg1
    public final void b() {
        t11 t11Var = this.c;
        int i = t11Var.d;
        Object[] objArr = t11Var.c;
        if (i > 0) {
            objArr[0].getClass();
            s1.d();
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        t11Var.d = 0;
    }
}
