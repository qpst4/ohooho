package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q70 extends hp implements zs {
    public final Handler d;
    public final boolean e;
    public final q70 f;

    public q70(Handler handler, boolean z) {
        this.d = handler;
        this.e = z;
        this.f = z ? this : new q70(handler, true);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q70)) {
            return false;
        }
        q70 q70Var = (q70) obj;
        return q70Var.d == this.d && q70Var.e == this.e;
    }

    public final int hashCode() {
        return (this.e ? 1231 : 1237) ^ System.identityHashCode(this.d);
    }

    @Override // defpackage.hp
    public final void q(ep epVar, Runnable runnable) throws IllegalAccessException, InvocationTargetException {
        if (this.d.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        yc0 yc0Var = (yc0) epVar.i(ow0.f);
        if (yc0Var != null) {
            ((gd0) yc0Var).k(cancellationException);
        }
        iu.b.q(epVar, runnable);
    }

    @Override // defpackage.hp
    public final boolean r() {
        return (this.e && fc0.b(Looper.myLooper(), this.d.getLooper())) ? false : true;
    }

    @Override // defpackage.hp
    public final String toString() {
        q70 q70Var;
        String str;
        rs rsVar = iu.a;
        q70 q70Var2 = dj0.a;
        if (this == q70Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                q70Var = q70Var2.f;
            } catch (UnsupportedOperationException unused) {
                q70Var = null;
            }
            str = this == q70Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.d.toString();
        if (!this.e) {
            return string;
        }
        return string + ".immediate";
    }
}
