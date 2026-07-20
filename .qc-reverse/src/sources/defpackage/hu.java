package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hu extends k41 {
    public int d;

    public final void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            f01.b(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        th.getClass();
        qp qpVar = new qp("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th);
        ep epVar = ((fu) this).f.c;
        epVar.getClass();
        fp1.m(epVar, qpVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Object jw0Var = ow0.h;
        vy0 vy0Var = this.c;
        try {
            fu fuVar = (fu) this;
            o31 o31Var = fuVar.f;
            Object obj = fuVar.h;
            ep epVar = o31Var.c;
            epVar.getClass();
            Object objV0 = lc1.v0(epVar, obj);
            ad1 ad1VarQ = objV0 != lc1.m ? f01.Q(o31Var, epVar, objV0) : null;
            try {
                ep epVar2 = o31Var.c;
                epVar2.getClass();
                fu fuVar2 = (fu) this;
                Object obj2 = fuVar2.g;
                fuVar2.g = xr.b;
                am amVar = obj2 instanceof am ? (am) obj2 : null;
                Throwable th = amVar != null ? amVar.a : null;
                yc0 yc0Var = (th == null && ((i = this.d) == 1 || i == 2)) ? (yc0) epVar2.i(ow0.f) : null;
                if (yc0Var != null && !yc0Var.a()) {
                    CancellationException cancellationExceptionR = ((gd0) yc0Var).r();
                    if (obj2 instanceof bm) {
                        throw null;
                    }
                    o31Var.e(new jw0(cancellationExceptionR));
                } else if (th != null) {
                    o31Var.e(new jw0(th));
                } else {
                    o31Var.e(obj2);
                }
                if (ad1VarQ == null || ad1VarQ.P()) {
                    lc1.g0(epVar, objV0);
                }
                try {
                    vy0Var.getClass();
                } catch (Throwable th2) {
                    jw0Var = new jw0(th2);
                }
                a(null, jw0Var instanceof jw0 ? ((jw0) jw0Var).b : null);
            } catch (Throwable th3) {
                if (ad1VarQ == null || ad1VarQ.P()) {
                    lc1.g0(epVar, objV0);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                vy0Var.getClass();
            } catch (Throwable th5) {
                jw0Var = new jw0(th5);
            }
            a(th4, jw0Var instanceof jw0 ? ((jw0) jw0Var).b : null);
        }
    }
}
