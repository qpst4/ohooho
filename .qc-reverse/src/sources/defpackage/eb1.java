package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eb1 extends fb1 {
    public final /* synthetic */ fb1 a;

    public eb1(fb1 fb1Var) {
        this.a = fb1Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() != 9) {
            return this.a.b(vd0Var);
        }
        vd0Var.E();
        return null;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (obj == null) {
            ae0Var.t();
        } else {
            this.a.c(ae0Var, obj);
        }
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.a + "]";
    }
}
