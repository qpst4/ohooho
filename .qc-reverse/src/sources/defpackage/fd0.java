package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fd0 extends xb {
    public final cd0 c;
    public wm0 d;
    public final /* synthetic */ gd0 e;
    public final /* synthetic */ xa0 f;

    public fd0(cd0 cd0Var, gd0 gd0Var, xa0 xa0Var) {
        this.e = gd0Var;
        this.f = xa0Var;
        this.c = cd0Var;
    }

    @Override // defpackage.xb
    public final void a(Object obj, Object obj2) {
        hi0 hi0Var = (hi0) obj;
        boolean z = obj2 == null;
        cd0 cd0Var = this.c;
        xa0 xa0Var = z ? cd0Var : this.d;
        if (xa0Var != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = hi0.a;
            while (!atomicReferenceFieldUpdater.compareAndSet(hi0Var, this, xa0Var)) {
                if (atomicReferenceFieldUpdater.get(hi0Var) != this) {
                    return;
                }
            }
            if (z) {
                wm0 wm0Var = this.d;
                wm0Var.getClass();
                cd0Var.h(wm0Var);
            }
        }
    }

    @Override // defpackage.xb
    public final c1 d(Object obj) {
        if (this.e.v() == this.f) {
            return null;
        }
        return fc0.d;
    }
}
