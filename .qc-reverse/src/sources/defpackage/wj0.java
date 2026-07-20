package defpackage;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wj0 extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ zj0 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wj0(zj0 zj0Var, int i, int i2) {
        super(i);
        this.F = zj0Var;
        this.E = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.zt0
    public final void B0(RecyclerView recyclerView, int i) {
        l2 l2Var = new l2(recyclerView.getContext(), 2);
        l2Var.a = i;
        C0(l2Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void E0(mu0 mu0Var, int[] iArr) {
        zj0 zj0Var = this.F;
        RecyclerView recyclerView = zj0Var.f0;
        if (this.E == 0) {
            iArr[0] = recyclerView.getWidth();
            iArr[1] = zj0Var.f0.getWidth();
        } else {
            iArr[0] = recyclerView.getHeight();
            iArr[1] = zj0Var.f0.getHeight();
        }
    }
}
