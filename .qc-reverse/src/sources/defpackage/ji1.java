package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ji1 {
    public final wi1 a;
    public xb0[] b;

    public ji1() {
        this(new wi1());
    }

    public final void a() {
        xb0[] xb0VarArr = this.b;
        if (xb0VarArr != null) {
            xb0 xb0VarF = xb0VarArr[0];
            xb0 xb0VarF2 = xb0VarArr[1];
            wi1 wi1Var = this.a;
            if (xb0VarF2 == null) {
                xb0VarF2 = wi1Var.a.f(2);
            }
            if (xb0VarF == null) {
                xb0VarF = wi1Var.a.f(1);
            }
            g(xb0.a(xb0VarF, xb0VarF2));
            xb0 xb0Var = this.b[tk0.o(16)];
            if (xb0Var != null) {
                f(xb0Var);
            }
            xb0 xb0Var2 = this.b[tk0.o(32)];
            if (xb0Var2 != null) {
                d(xb0Var2);
            }
            xb0 xb0Var3 = this.b[tk0.o(64)];
            if (xb0Var3 != null) {
                h(xb0Var3);
            }
        }
    }

    public abstract wi1 b();

    public void c(int i, xb0 xb0Var) {
        if (this.b == null) {
            this.b = new xb0[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.b[tk0.o(i2)] = xb0Var;
            }
        }
    }

    public abstract void e(xb0 xb0Var);

    public abstract void g(xb0 xb0Var);

    public ji1(wi1 wi1Var) {
        this.a = wi1Var;
    }

    public void d(xb0 xb0Var) {
    }

    public void f(xb0 xb0Var) {
    }

    public void h(xb0 xb0Var) {
    }
}
