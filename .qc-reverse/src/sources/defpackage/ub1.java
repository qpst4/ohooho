package defpackage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ub1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        try {
            String strG = vd0Var.G();
            if (strG.equals("null")) {
                return null;
            }
            return new URI(strG);
        } catch (URISyntaxException e) {
            throw new rd0(e);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        URI uri = (URI) obj;
        ae0Var.B(uri == null ? null : uri.toASCIIString());
    }
}
