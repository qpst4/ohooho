package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fu extends hu implements op, jo {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(fu.class, Object.class, "_reusableCancellableContinuation$volatile");
    public static final /* synthetic */ long j = sz.a.objectFieldOffset(fu.class.getDeclaredField("_reusableCancellableContinuation$volatile"));
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final hp e;
    public final o31 f;
    public Object g;
    public final Object h;

    public fu(hp hpVar, o31 o31Var) {
        super(0L, p41.g);
        this.d = -1;
        this.e = hpVar;
        this.f = o31Var;
        this.g = xr.b;
        ep epVar = o31Var.c;
        epVar.getClass();
        this.h = lc1.q0(epVar);
    }

    public final void b() {
        do {
            i.getClass();
        } while (sz.a.getObjectVolatile(this, j) == xr.c);
    }

    @Override // defpackage.op
    public final op c() {
        o31 o31Var = this.f;
        if (o31Var != null) {
            return o31Var;
        }
        return null;
    }

    @Override // defpackage.jo
    public final ep d() {
        ep epVar = this.f.c;
        epVar.getClass();
        return epVar;
    }

    @Override // defpackage.jo
    public final void e(Object obj) {
        o31 o31Var = this.f;
        ep epVar = o31Var.c;
        epVar.getClass();
        Throwable th = obj instanceof jw0 ? ((jw0) obj).b : null;
        Object amVar = th == null ? obj : new am(th);
        hp hpVar = this.e;
        if (hpVar.r()) {
            this.g = amVar;
            this.d = 0;
            hpVar.q(epVar, this);
            return;
        }
        ThreadLocal threadLocal = o51.a;
        pz sgVar = (pz) threadLocal.get();
        if (sgVar == null) {
            sgVar = new sg(Thread.currentThread());
            threadLocal.set(sgVar);
        }
        long j2 = sgVar.d;
        if (j2 >= 4294967296L) {
            this.g = amVar;
            this.d = 0;
            eb ebVar = sgVar.f;
            if (ebVar == null) {
                ebVar = new eb();
                sgVar.f = ebVar;
            }
            ebVar.addLast(this);
            return;
        }
        sgVar.d = 4294967296L + j2;
        try {
            ep epVar2 = o31Var.c;
            epVar2.getClass();
            Object objV0 = lc1.v0(epVar2, this.h);
            try {
                o31Var.e(obj);
                while (sgVar.t()) {
                }
            } finally {
                lc1.g0(epVar2, objV0);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void f() {
        i.getClass();
        sz.a.getObjectVolatile(this, j);
    }

    public final String toString() {
        Object jw0Var;
        StringBuilder sb = new StringBuilder("DispatchedContinuation[");
        sb.append(this.e);
        sb.append(", ");
        o31 o31Var = this.f;
        try {
            jw0Var = o31Var + '@' + xr.p(o31Var);
        } catch (Throwable th) {
            jw0Var = new jw0(th);
        }
        if ((jw0Var instanceof jw0 ? ((jw0) jw0Var).b : null) != null) {
            jw0Var = o31Var.getClass().getName() + '@' + xr.p(o31Var);
        }
        sb.append((String) jw0Var);
        sb.append(']');
        return sb.toString();
    }
}
