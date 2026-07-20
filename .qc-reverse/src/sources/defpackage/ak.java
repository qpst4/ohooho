package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ak extends ad0 implements zj {
    public final gd0 h;

    public ak(gd0 gd0Var) {
        this.h = gd0Var;
    }

    @Override // defpackage.zj
    public final boolean c(Throwable th) {
        gd0 gd0VarP = p();
        if (th instanceof CancellationException) {
            return true;
        }
        return gd0VarP.k(th) && gd0VarP.s();
    }

    @Override // defpackage.cd0
    public final void q(Throwable th) throws IllegalAccessException, InvocationTargetException {
        this.h.k(p());
    }
}
