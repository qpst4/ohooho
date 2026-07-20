package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gj extends u81 {
    public boolean a = false;
    public final ViewGroup b;

    public gj(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    @Override // defpackage.u81, defpackage.s81
    public final void b() {
        fp1.B(this.b, false);
    }

    @Override // defpackage.u81, defpackage.s81
    public final void c() {
        fp1.B(this.b, true);
    }

    @Override // defpackage.s81
    public final void d(t81 t81Var) {
        if (!this.a) {
            fp1.B(this.b, false);
        }
        t81Var.x(this);
    }

    @Override // defpackage.u81, defpackage.s81
    public final void f(t81 t81Var) {
        fp1.B(this.b, false);
        this.a = true;
    }
}
