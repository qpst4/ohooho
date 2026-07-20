package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b80 extends vn {
    public vn[] q0 = new vn[4];
    public int r0 = 0;

    public final void R(int i, nh1 nh1Var, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.r0; i2++) {
            vn vnVar = this.q0[i2];
            ArrayList arrayList2 = nh1Var.a;
            if (!arrayList2.contains(vnVar)) {
                arrayList2.add(vnVar);
            }
        }
        for (int i3 = 0; i3 < this.r0; i3++) {
            fp1.f(this.q0[i3], i, arrayList, nh1Var);
        }
    }

    public void S() {
    }
}
