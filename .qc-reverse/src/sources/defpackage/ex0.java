package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ex0 extends hx0 implements Iterator {
    public fx0 b;
    public fx0 c;
    public final /* synthetic */ int d;

    public ex0(fx0 fx0Var, fx0 fx0Var2, int i) {
        this.d = i;
        this.b = fx0Var2;
        this.c = fx0Var;
    }

    @Override // defpackage.hx0
    public final void a(fx0 fx0Var) {
        fx0 fx0Var2;
        fx0 fx0VarB = null;
        if (this.b == fx0Var && fx0Var == this.c) {
            this.c = null;
            this.b = null;
        }
        fx0 fx0Var3 = this.b;
        if (fx0Var3 == fx0Var) {
            switch (this.d) {
                case 0:
                    fx0Var2 = fx0Var3.e;
                    break;
                default:
                    fx0Var2 = fx0Var3.d;
                    break;
            }
            this.b = fx0Var2;
        }
        fx0 fx0Var4 = this.c;
        if (fx0Var4 == fx0Var) {
            fx0 fx0Var5 = this.b;
            if (fx0Var4 != fx0Var5 && fx0Var5 != null) {
                fx0VarB = b(fx0Var4);
            }
            this.c = fx0VarB;
        }
    }

    public final fx0 b(fx0 fx0Var) {
        switch (this.d) {
            case 0:
                return fx0Var.d;
            default:
                return fx0Var.e;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        fx0 fx0Var = this.c;
        fx0 fx0Var2 = this.b;
        this.c = (fx0Var == fx0Var2 || fx0Var2 == null) ? null : b(fx0Var);
        return fx0Var;
    }
}
