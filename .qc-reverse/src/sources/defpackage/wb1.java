package defpackage;

import java.io.IOException;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class wb1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        String strG = vd0Var.G();
        try {
            return UUID.fromString(strG);
        } catch (IllegalArgumentException e) {
            StringBuilder sbM = l11.m("Failed parsing '", strG, "' as UUID; at path ");
            sbM.append(vd0Var.u());
            throw new wd0(sbM.toString(), e);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        ae0Var.B(uuid == null ? null : uuid.toString());
    }
}
