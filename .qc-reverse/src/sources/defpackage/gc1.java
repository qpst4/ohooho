package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class gc1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        try {
            int iA = vd0Var.A();
            if (iA <= 65535 && iA >= -32768) {
                return Short.valueOf((short) iA);
            }
            ay0.e("Lossy conversion from ", iA, " to short; at path ", vd0Var.u());
            return null;
        } catch (NumberFormatException e) {
            throw new wd0(e);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (((Number) obj) == null) {
            ae0Var.t();
        } else {
            ae0Var.z(r4.shortValue());
        }
    }
}
