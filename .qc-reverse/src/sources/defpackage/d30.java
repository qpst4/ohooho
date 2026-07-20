package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d30 extends g4 {
    public final /* synthetic */ AtomicReference a;

    public d30(AtomicReference atomicReference) {
        this.a = atomicReference;
    }

    @Override // defpackage.g4
    public final void a(Object obj) {
        g4 g4Var = (g4) this.a.get();
        if (g4Var != null) {
            g4Var.a(obj);
        } else {
            s1.f("Operation cannot be started before fragment is in created state");
        }
    }
}
