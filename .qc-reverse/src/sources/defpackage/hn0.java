package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hn0 extends fb1 {
    public static final gn0 b = new gn0(new hn0(2), 0);
    public final int a;

    public hn0(int i) {
        this.a = i;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        int I = vd0Var.I();
        int iR = l11.r(I);
        if (iR == 5 || iR == 6) {
            return qq0.b(this.a, vd0Var);
        }
        if (iR == 8) {
            vd0Var.E();
            return null;
        }
        throw new wd0("Expecting number, got: " + l11.u(I) + "; at path " + vd0Var.s());
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        ae0Var.A((Number) obj);
    }
}
