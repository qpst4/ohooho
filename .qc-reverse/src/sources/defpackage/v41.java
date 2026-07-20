package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v41 extends i1 {
    public final /* synthetic */ fp1 p;
    public final /* synthetic */ x41 q;

    public v41(x41 x41Var, fp1 fp1Var) {
        super(19);
        this.q = x41Var;
        this.p = fp1Var;
    }

    @Override // defpackage.i1
    public final void G(int i) {
        this.q.m = true;
        this.p.v(i);
    }

    @Override // defpackage.i1
    public final void H(Typeface typeface) {
        x41 x41Var = this.q;
        Typeface typefaceCreate = Typeface.create(typeface, x41Var.c);
        x41Var.n = typefaceCreate;
        x41Var.m = true;
        this.p.w(typefaceCreate, false);
    }
}
