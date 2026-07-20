package defpackage;

import androidx.activity.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ao0 implements mi {
    public final r30 b;
    public final /* synthetic */ a c;

    public ao0(a aVar, r30 r30Var) {
        r30Var.getClass();
        this.c = aVar;
        this.b = r30Var;
    }

    @Override // defpackage.mi
    public final void cancel() {
        a aVar = this.c;
        eb ebVar = aVar.b;
        r30 r30Var = this.b;
        ebVar.remove(r30Var);
        if (fc0.b(aVar.c, r30Var)) {
            r30Var.getClass();
            aVar.c = null;
        }
        r30Var.getClass();
        r30Var.b.remove(this);
        k40 k40Var = r30Var.c;
        if (k40Var != null) {
            k40Var.a();
        }
        r30Var.c = null;
    }
}
