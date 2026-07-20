package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class fi1 extends ji1 {
    public final WindowInsets.Builder c;

    public fi1(wi1 wi1Var) {
        super(wi1Var);
        WindowInsets windowInsetsG = wi1Var.g();
        this.c = windowInsetsG != null ? ei1.c(windowInsetsG) : ei1.b();
    }

    @Override // defpackage.ji1
    public wi1 b() {
        a();
        wi1 wi1VarH = wi1.h(null, this.c.build());
        wi1VarH.a.o(this.b);
        return wi1VarH;
    }

    @Override // defpackage.ji1
    public void d(xb0 xb0Var) {
        this.c.setMandatorySystemGestureInsets(xb0Var.d());
    }

    @Override // defpackage.ji1
    public void e(xb0 xb0Var) {
        this.c.setStableInsets(xb0Var.d());
    }

    @Override // defpackage.ji1
    public void f(xb0 xb0Var) {
        this.c.setSystemGestureInsets(xb0Var.d());
    }

    @Override // defpackage.ji1
    public void g(xb0 xb0Var) {
        this.c.setSystemWindowInsets(xb0Var.d());
    }

    @Override // defpackage.ji1
    public void h(xb0 xb0Var) {
        this.c.setTappableElementInsets(xb0Var.d());
    }

    public fi1() {
        this.c = ei1.b();
    }
}
