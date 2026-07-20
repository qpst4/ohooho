package defpackage;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends b30 {
    public final /* synthetic */ int k = 0;
    public final /* synthetic */ View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.l = actionMenuItemView;
    }

    @Override // defpackage.b30
    public final n01 b() {
        x1 x1Var;
        int i = this.k;
        View view = this.l;
        switch (i) {
            case 0:
                w1 w1Var = ((ActionMenuItemView) view).n;
                if (w1Var == null || (x1Var = ((y1) w1Var).a.u) == null) {
                    return null;
                }
                return x1Var.a();
            default:
                x1 x1Var2 = ((z1) view).e.t;
                if (x1Var2 == null) {
                    return null;
                }
                return x1Var2.a();
        }
    }

    @Override // defpackage.b30
    public final boolean c() {
        n01 n01VarB;
        int i = this.k;
        View view = this.l;
        switch (i) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
                yk0 yk0Var = actionMenuItemView.l;
                if (yk0Var == null || !yk0Var.a(actionMenuItemView.i) || (n01VarB = b()) == null || !n01VarB.b()) {
                }
                break;
            default:
                ((z1) view).e.l();
                break;
        }
        return true;
    }

    @Override // defpackage.b30
    public boolean d() {
        switch (this.k) {
            case 1:
                a2 a2Var = ((z1) this.l).e;
                if (a2Var.v != null) {
                    return false;
                }
                a2Var.d();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(z1 z1Var, z1 z1Var2) {
        super(z1Var2);
        this.l = z1Var;
    }
}
