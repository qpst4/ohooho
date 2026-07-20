package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rj1 {
    public final int a;

    public rj1(int i) {
        this.a = i;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(mj1 mj1Var);

    public abstract l10[] b(mj1 mj1Var);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(mj1 mj1Var);

    public abstract void f(pn0 pn0Var, boolean z);
}
