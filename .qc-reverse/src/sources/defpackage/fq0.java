package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fq0 extends st0 {
    public final jq0 a;
    public final RecyclerView b;

    public fq0(jq0 jq0Var, RecyclerView recyclerView) {
        this.a = jq0Var;
        this.b = recyclerView;
    }

    @Override // defpackage.st0
    public final void a() {
        f();
    }

    @Override // defpackage.st0
    public final void b(int i, int i2, Object obj) {
        f();
    }

    @Override // defpackage.st0
    public final void c(int i, int i2) {
        f();
    }

    @Override // defpackage.st0
    public final void d(int i, int i2) {
        f();
    }

    @Override // defpackage.st0
    public final void e(int i, int i2) {
        f();
    }

    public final void f() {
        jq0 jq0Var = this.a;
        jq0Var.a.unregisterObserver(this);
        int iK = jq0Var.k();
        if (iK != -1) {
            this.b.d0(iK);
        }
    }
}
