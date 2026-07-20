package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class dc1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        int I = vd0Var.I();
        if (I != 9) {
            return I == 6 ? Boolean.valueOf(Boolean.parseBoolean(vd0Var.G())) : Boolean.valueOf(vd0Var.y());
        }
        vd0Var.E();
        return null;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            ae0Var.t();
            return;
        }
        ae0Var.D();
        ae0Var.a();
        ae0Var.b.write(bool.booleanValue() ? "true" : "false");
    }
}
