package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jc1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        return new AtomicBoolean(vd0Var.y());
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        ae0Var.C(((AtomicBoolean) obj).get());
    }
}
