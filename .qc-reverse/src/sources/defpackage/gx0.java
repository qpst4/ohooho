package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gx0 extends hx0 implements Iterator {
    public fx0 b;
    public boolean c = true;
    public final /* synthetic */ ix0 d;

    public gx0(ix0 ix0Var) {
        this.d = ix0Var;
    }

    @Override // defpackage.hx0
    public final void a(fx0 fx0Var) {
        fx0 fx0Var2 = this.b;
        if (fx0Var == fx0Var2) {
            fx0 fx0Var3 = fx0Var2.e;
            this.b = fx0Var3;
            this.c = fx0Var3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.c) {
            return this.d.b != null;
        }
        fx0 fx0Var = this.b;
        return (fx0Var == null || fx0Var.d == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.c) {
            this.c = false;
            this.b = this.d.b;
        } else {
            fx0 fx0Var = this.b;
            this.b = fx0Var != null ? fx0Var.d : null;
        }
        return this.b;
    }
}
