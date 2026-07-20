package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f30 extends f01 {
    public final /* synthetic */ j30 m;

    public f30(j30 j30Var) {
        this.m = j30Var;
    }

    @Override // defpackage.f01
    public final View F(int i) {
        j30 j30Var = this.m;
        View view = j30Var.H;
        if (view != null) {
            return view.findViewById(i);
        }
        s1.f(l11.i("Fragment ", j30Var, " does not have a view"));
        return null;
    }

    @Override // defpackage.f01
    public final boolean G() {
        return this.m.H != null;
    }
}
