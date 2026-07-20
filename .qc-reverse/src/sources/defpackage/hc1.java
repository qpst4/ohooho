package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class hc1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        try {
            return Integer.valueOf(vd0Var.A());
        } catch (NumberFormatException e) {
            throw new wd0(e);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (((Number) obj) == null) {
            ae0Var.t();
        } else {
            ae0Var.z(r4.intValue());
        }
    }
}
