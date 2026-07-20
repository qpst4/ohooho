package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ck1 extends rj1 {
    public final qx0 b;
    public final l41 c;
    public final ow0 d;

    public ck1(qx0 qx0Var, l41 l41Var, ow0 ow0Var) {
        super(2);
        this.c = l41Var;
        this.b = qx0Var;
        this.d = ow0Var;
        if (qx0Var.a) {
            zy.n("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // defpackage.rj1
    public final boolean a(mj1 mj1Var) {
        return this.b.a;
    }

    @Override // defpackage.rj1
    public final l10[] b(mj1 mj1Var) {
        return (l10[]) this.b.b;
    }

    @Override // defpackage.rj1
    public final void c(Status status) {
        this.d.getClass();
        this.c.a(status.d != null ? new yv0(status) : new v7(status));
    }

    @Override // defpackage.rj1
    public final void d(Exception exc) {
        this.c.a(exc);
    }

    @Override // defpackage.rj1
    public final void e(mj1 mj1Var) throws DeadObjectException {
        l41 l41Var = this.c;
        try {
            this.b.a(mj1Var.c, l41Var);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            c(rj1.g(e2));
        } catch (RuntimeException e3) {
            l41Var.a(e3);
        }
    }

    @Override // defpackage.rj1
    public final void f(pn0 pn0Var, boolean z) {
        l41 l41Var = this.c;
        ((Map) pn0Var.d).put(l41Var, Boolean.valueOf(z));
        xa1 xa1Var = l41Var.a;
        pn0 pn0Var2 = new pn0(pn0Var, 17, l41Var);
        xa1Var.getClass();
        gq1 gq1Var = new gq1(m41.a, pn0Var2);
        qx0 qx0Var = (qx0) xa1Var.c;
        synchronized (qx0Var.b) {
            try {
                if (((ArrayDeque) qx0Var.c) == null) {
                    qx0Var.c = new ArrayDeque();
                }
                ((ArrayDeque) qx0Var.c).add(gq1Var);
            } finally {
            }
        }
        synchronized (xa1Var.b) {
            try {
                if (xa1Var.a) {
                    ((qx0) xa1Var.c).e(xa1Var);
                }
            } finally {
            }
        }
    }
}
