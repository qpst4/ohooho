package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g30 extends i30 {
    public final /* synthetic */ sp1 a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ f4 c;
    public final /* synthetic */ e4 d;
    public final /* synthetic */ j30 e;

    public g30(j30 j30Var, sp1 sp1Var, AtomicReference atomicReference, f4 f4Var, e4 e4Var) {
        this.e = j30Var;
        this.a = sp1Var;
        this.b = atomicReference;
        this.c = f4Var;
        this.d = e4Var;
    }

    @Override // defpackage.i30
    public final void a() {
        StringBuilder sb = new StringBuilder("fragment_");
        j30 j30Var = this.e;
        sb.append(j30Var.g);
        sb.append("_rq#");
        sb.append(j30Var.U.getAndIncrement());
        String string = sb.toString();
        j30 j30Var2 = (j30) this.a.c;
        l30 l30Var = j30Var2.u;
        this.b.set((l30Var != null ? l30Var.q : j30Var2.Z()).j.c(string, j30Var, this.c, this.d));
    }
}
