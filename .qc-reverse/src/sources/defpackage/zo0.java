package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zo0 extends bu0 {
    public RecyclerView a;
    public final i11 b = new i11(this);
    public ro0 c;
    public ro0 d;

    public static int b(View view, px pxVar) {
        return ((pxVar.c(view) / 2) + pxVar.e(view)) - ((pxVar.l() / 2) + pxVar.k());
    }

    public static View c(zt0 zt0Var, px pxVar) {
        int iV = zt0Var.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iL = (pxVar.l() / 2) + pxVar.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = zt0Var.u(i2);
            int iAbs = Math.abs(((pxVar.c(viewU) / 2) + pxVar.e(viewU)) - iL);
            if (iAbs < i) {
                view = viewU;
                i = iAbs;
            }
        }
        return view;
    }

    public final int[] a(zt0 zt0Var, View view) {
        int[] iArr = new int[2];
        if (zt0Var.d()) {
            iArr[0] = b(view, d(zt0Var));
        } else {
            iArr[0] = 0;
        }
        if (zt0Var.e()) {
            iArr[1] = b(view, e(zt0Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final px d(zt0 zt0Var) {
        ro0 ro0Var = this.d;
        if (ro0Var == null || ((zt0) ro0Var.b) != zt0Var) {
            this.d = new ro0(zt0Var, 0);
        }
        return this.d;
    }

    public final px e(zt0 zt0Var) {
        ro0 ro0Var = this.c;
        if (ro0Var == null || ((zt0) ro0Var.b) != zt0Var) {
            this.c = new ro0(zt0Var, 1);
        }
        return this.c;
    }

    public final void f() {
        zt0 layoutManager;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View viewC = layoutManager.e() ? c(layoutManager, e(layoutManager)) : layoutManager.d() ? c(layoutManager, d(layoutManager)) : null;
        if (viewC == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewC);
        int i = iArrA[0];
        if (i == 0 && iArrA[1] == 0) {
            return;
        }
        this.a.e0(i, iArrA[1], false);
    }
}
