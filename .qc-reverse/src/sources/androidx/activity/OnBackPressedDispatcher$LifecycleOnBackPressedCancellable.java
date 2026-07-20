package androidx.activity;

import defpackage.ao0;
import defpackage.dg0;
import defpackage.gg0;
import defpackage.mi;
import defpackage.r30;
import defpackage.yf0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements dg0, mi {
    public final androidx.lifecycle.a b;
    public final r30 c;
    public ao0 d;
    public final /* synthetic */ a e;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(a aVar, androidx.lifecycle.a aVar2, r30 r30Var) {
        r30Var.getClass();
        this.e = aVar;
        this.b = aVar2;
        this.c = r30Var;
        aVar2.a(this);
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        if (yf0Var == yf0.ON_START) {
            this.d = this.e.b(this.c);
            return;
        }
        if (yf0Var != yf0.ON_STOP) {
            if (yf0Var == yf0.ON_DESTROY) {
                cancel();
            }
        } else {
            ao0 ao0Var = this.d;
            if (ao0Var != null) {
                ao0Var.cancel();
            }
        }
    }

    @Override // defpackage.mi
    public final void cancel() {
        this.b.f(this);
        r30 r30Var = this.c;
        r30Var.getClass();
        r30Var.b.remove(this);
        ao0 ao0Var = this.d;
        if (ao0Var != null) {
            ao0Var.cancel();
        }
        this.d = null;
    }
}
