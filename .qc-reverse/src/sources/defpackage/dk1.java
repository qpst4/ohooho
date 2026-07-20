package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dk1 extends rj1 {
    public final l41 b;

    public dk1(l41 l41Var) {
        super(4);
        this.b = l41Var;
    }

    @Override // defpackage.rj1
    public final boolean a(mj1 mj1Var) {
        if (mj1Var.g.get(null) == null) {
            return false;
        }
        s1.d();
        return false;
    }

    @Override // defpackage.rj1
    public final l10[] b(mj1 mj1Var) {
        if (mj1Var.g.get(null) == null) {
            return null;
        }
        s1.d();
        return null;
    }

    @Override // defpackage.rj1
    public final void c(Status status) {
        this.b.a(new v7(status));
    }

    @Override // defpackage.rj1
    public final void d(Exception exc) {
        this.b.a(exc);
    }

    @Override // defpackage.rj1
    public final void e(mj1 mj1Var) throws DeadObjectException {
        try {
            h(mj1Var);
        } catch (DeadObjectException e) {
            c(rj1.g(e));
            throw e;
        } catch (RemoteException e2) {
            c(rj1.g(e2));
        } catch (RuntimeException e3) {
            this.b.a(e3);
        }
    }

    public final void h(mj1 mj1Var) {
        if (mj1Var.g.remove(null) != null) {
            s1.d();
            return;
        }
        l41 l41Var = this.b;
        Boolean bool = Boolean.FALSE;
        xa1 xa1Var = l41Var.a;
        synchronized (xa1Var.b) {
            try {
                if (xa1Var.a) {
                    return;
                }
                xa1Var.a = true;
                xa1Var.d = bool;
                ((qx0) xa1Var.c).e(xa1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.rj1
    public final /* bridge */ /* synthetic */ void f(pn0 pn0Var, boolean z) {
    }
}
