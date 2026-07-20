package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jb1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() != 9) {
            return Float.valueOf((float) vd0Var.z());
        }
        vd0Var.E();
        return null;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            ae0Var.t();
            return;
        }
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(numberValueOf.floatValue());
        }
        ae0Var.A(numberValueOf);
    }
}
