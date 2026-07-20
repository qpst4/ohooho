package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qg {
    public final /* synthetic */ int a;

    public /* synthetic */ qg(int i) {
        this.a = i;
    }

    public final Object a(h7 h7Var, kj0 kj0Var) {
        switch (this.a) {
            case 0:
                return new pg((ij0) h7Var.b, 0);
            case 1:
                return new al((ij0) h7Var.b);
            case 2:
                return new bl((ij0) h7Var.b);
            case 3:
                return new jy(0);
            case 4:
                return new z70((ij0) h7Var.b, ((Integer) lc1.d.a(kj0Var)).intValue());
            case 5:
                return new vg0((ij0) h7Var.b, (String) lc1.e.a(kj0Var), (ow0) h7Var.d);
            case 6:
                ij0 ij0Var = (ij0) h7Var.b;
                return ap.b == lc1.a.a(kj0Var) ? new rh(ij0Var, ((Integer) lc1.b.a(kj0Var)).intValue()) : new qo0(ij0Var, String.valueOf(lc1.c.a(kj0Var)).concat(". "));
            case 7:
                return new jy(1);
            default:
                return new pg((ij0) h7Var.b, 1);
        }
    }
}
