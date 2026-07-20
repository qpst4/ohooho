package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ic1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        try {
            return new AtomicInteger(vd0Var.A());
        } catch (NumberFormatException e) {
            throw new wd0(e);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        ae0Var.z(((AtomicInteger) obj).get());
    }
}
