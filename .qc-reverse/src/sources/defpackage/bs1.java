package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bs1 {
    public Serializable a;
    public fs1 b;
    public gs1 c;
    public boolean d;

    public final void finalize() {
        gs1 gs1Var;
        fs1 fs1Var = this.b;
        if (fs1Var != null) {
            ds1 ds1Var = fs1Var.c;
            if (!ds1Var.isDone()) {
                if (as1.g.a0(ds1Var, null, new qp1(new en1("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(this.a)), 2)))) {
                    as1.c(ds1Var);
                }
            }
        }
        if (this.d || (gs1Var = this.c) == null) {
            return;
        }
        gs1Var.h(null);
    }
}
