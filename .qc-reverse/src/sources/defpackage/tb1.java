package defpackage;

import java.io.IOException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class tb1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        String strG = vd0Var.G();
        if (strG.equals("null")) {
            return null;
        }
        return new URL(strG);
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        URL url = (URL) obj;
        ae0Var.B(url == null ? null : url.toExternalForm());
    }
}
