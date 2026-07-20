package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pt0 {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ pt0(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(l4 l4Var) {
        int i = l4Var.a;
        RecyclerView recyclerView = this.a;
        if (i == 1) {
            recyclerView.n.a0(l4Var.b, l4Var.d);
            return;
        }
        if (i == 2) {
            recyclerView.n.d0(l4Var.b, l4Var.d);
        } else if (i == 4) {
            recyclerView.n.e0(l4Var.b, l4Var.d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.n.c0(l4Var.b, l4Var.d);
        }
    }

    public pu0 b(int i) {
        RecyclerView recyclerView = this.a;
        int iF = recyclerView.f.F();
        int i2 = 0;
        pu0 pu0Var = null;
        while (true) {
            if (i2 >= iF) {
                break;
            }
            pu0 pu0VarJ = RecyclerView.J(recyclerView.f.E(i2));
            if (pu0VarJ != null && !pu0VarJ.i() && pu0VarJ.c == i) {
                if (!((ArrayList) recyclerView.f.e).contains(pu0VarJ.a)) {
                    pu0Var = pu0VarJ;
                    break;
                }
                pu0Var = pu0VarJ;
            }
            i2++;
        }
        if (pu0Var != null) {
            if (!((ArrayList) recyclerView.f.e).contains(pu0Var.a)) {
                return pu0Var;
            }
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int iF = recyclerView.f.F();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iF; i6++) {
            View viewE = recyclerView.f.E(i6);
            pu0 pu0VarJ = RecyclerView.J(viewE);
            if (pu0VarJ != null && !pu0VarJ.p() && (i4 = pu0VarJ.c) >= i && i4 < i5) {
                pu0VarJ.a(2);
                if (obj == null) {
                    pu0VarJ.a(1024);
                } else if ((1024 & pu0VarJ.j) == 0) {
                    if (pu0VarJ.k == null) {
                        ArrayList arrayList = new ArrayList();
                        pu0VarJ.k = arrayList;
                        pu0VarJ.l = Collections.unmodifiableList(arrayList);
                    }
                    pu0VarJ.k.add(obj);
                }
                ((au0) viewE.getLayoutParams()).c = true;
            }
        }
        gu0 gu0Var = recyclerView.c;
        ArrayList arrayList2 = gu0Var.c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            pu0 pu0Var = (pu0) arrayList2.get(size);
            if (pu0Var != null && (i3 = pu0Var.c) >= i && i3 < i5) {
                pu0Var.a(2);
                gu0Var.e(size);
            }
        }
        recyclerView.k0 = true;
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        int iF = recyclerView.f.F();
        for (int i3 = 0; i3 < iF; i3++) {
            pu0 pu0VarJ = RecyclerView.J(recyclerView.f.E(i3));
            if (pu0VarJ != null && !pu0VarJ.p() && pu0VarJ.c >= i) {
                pu0VarJ.m(i2, false);
                recyclerView.g0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.c.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            pu0 pu0Var = (pu0) arrayList.get(i4);
            if (pu0Var != null && pu0Var.c >= i) {
                pu0Var.m(i2, true);
            }
        }
        recyclerView.requestLayout();
        recyclerView.j0 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.a;
        int iF = recyclerView.f.F();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < iF; i11++) {
            pu0 pu0VarJ = RecyclerView.J(recyclerView.f.E(i11));
            if (pu0VarJ != null && (i9 = pu0VarJ.c) >= i4 && i9 <= i3) {
                if (i9 == i) {
                    pu0VarJ.m(i2 - i, false);
                } else {
                    pu0VarJ.m(i5, false);
                }
                recyclerView.g0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.c.c;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            pu0 pu0Var = (pu0) arrayList.get(i12);
            if (pu0Var != null && (i8 = pu0Var.c) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    pu0Var.m(i2 - i, false);
                } else {
                    pu0Var.m(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.j0 = true;
    }

    public void f(pu0 pu0Var, rm0 rm0Var, rm0 rm0Var2) {
        boolean zH;
        RecyclerView recyclerView = this.a;
        recyclerView.c.j(pu0Var);
        recyclerView.f(pu0Var);
        pu0Var.o(false);
        ns nsVar = (ns) recyclerView.L;
        nsVar.getClass();
        int i = rm0Var.a;
        int i2 = rm0Var.b;
        View view = pu0Var.a;
        int left = rm0Var2 == null ? view.getLeft() : rm0Var2.a;
        int top = rm0Var2 == null ? view.getTop() : rm0Var2.b;
        if (pu0Var.i() || (i == left && i2 == top)) {
            nsVar.m(pu0Var);
            nsVar.h.add(pu0Var);
            zH = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zH = nsVar.h(pu0Var, i, i2, left, top);
        }
        if (zH) {
            recyclerView.U();
        }
    }

    public void g(int i) {
        RecyclerView recyclerView = this.a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.o(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
