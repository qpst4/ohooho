package defpackage;

import android.content.Context;
import android.view.View;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 extends jl0 {
    public final /* synthetic */ int l = 0;
    public final /* synthetic */ a2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(a2 a2Var, Context context, g31 g31Var, View view) {
        super(context, g31Var, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.m = a2Var;
        if ((g31Var.A.x & 32) != 32) {
            View view2 = a2Var.j;
            this.e = view2 == null ? (View) a2Var.i : view2;
        }
        sp1 sp1Var = a2Var.x;
        this.h = sp1Var;
        hl0 hl0Var = this.i;
        if (hl0Var != null) {
            hl0Var.e(sp1Var);
        }
    }

    @Override // defpackage.jl0
    public final void c() {
        int i = this.l;
        a2 a2Var = this.m;
        switch (i) {
            case 0:
                a2Var.u = null;
                super.c();
                break;
            default:
                zk0 zk0Var = a2Var.d;
                if (zk0Var != null) {
                    zk0Var.c(true);
                }
                a2Var.t = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(a2 a2Var, Context context, zk0 zk0Var, View view) {
        super(context, zk0Var, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.m = a2Var;
        this.f = 8388613;
        sp1 sp1Var = a2Var.x;
        this.h = sp1Var;
        hl0 hl0Var = this.i;
        if (hl0Var != null) {
            hl0Var.e(sp1Var);
        }
    }
}
