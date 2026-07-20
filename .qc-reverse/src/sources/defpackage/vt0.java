package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vt0 {
    public pt0 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static void c(pu0 pu0Var) {
        int i = pu0Var.j;
        if (!pu0Var.g() && (i & 4) == 0) {
            pu0Var.b();
        }
    }

    public abstract boolean a(pu0 pu0Var, rm0 rm0Var, rm0 rm0Var2);

    public abstract boolean b(pu0 pu0Var, pu0 pu0Var2, rm0 rm0Var, rm0 rm0Var2);

    public final void d(pu0 pu0Var) {
        pt0 pt0Var = this.a;
        if (pt0Var != null) {
            RecyclerView recyclerView = pt0Var.a;
            boolean z = true;
            pu0Var.o(true);
            View view = pu0Var.a;
            if (pu0Var.h != null && pu0Var.i == null) {
                pu0Var.h = null;
            }
            pu0Var.i = null;
            if ((pu0Var.j & 16) != 0) {
                return;
            }
            gu0 gu0Var = recyclerView.c;
            recyclerView.f0();
            ra raVar = recyclerView.f;
            bk bkVar = (bk) raVar.d;
            pt0 pt0Var2 = (pt0) raVar.c;
            int iIndexOfChild = pt0Var2.a.indexOfChild(view);
            if (iIndexOfChild == -1) {
                raVar.U(view);
            } else if (bkVar.e(iIndexOfChild)) {
                bkVar.g(iIndexOfChild);
                raVar.U(view);
                pt0Var2.g(iIndexOfChild);
            } else {
                z = false;
            }
            if (z) {
                pu0 pu0VarJ = RecyclerView.J(view);
                gu0Var.j(pu0VarJ);
                gu0Var.g(pu0VarJ);
            }
            recyclerView.g0(!z);
            if (z || !pu0Var.k()) {
                return;
            }
            recyclerView.removeDetachedView(view, false);
        }
    }

    public abstract void e(pu0 pu0Var);

    public abstract void f();

    public abstract boolean g();
}
