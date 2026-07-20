package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class iu0 extends st0 {
    public final /* synthetic */ RecyclerView a;

    public iu0(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override // defpackage.st0
    public final void a() {
        RecyclerView recyclerView = this.a;
        recyclerView.i(null);
        recyclerView.g0.f = true;
        recyclerView.W(true);
        if (recyclerView.e.j()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // defpackage.st0
    public final void b(int i, int i2, Object obj) {
        RecyclerView recyclerView = this.a;
        recyclerView.i(null);
        m4 m4Var = recyclerView.e;
        ArrayList arrayList = (ArrayList) m4Var.c;
        if (i2 < 1) {
            return;
        }
        arrayList.add(m4Var.l(obj, 4, i, i2));
        m4Var.a |= 4;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.st0
    public final void c(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.i(null);
        m4 m4Var = recyclerView.e;
        ArrayList arrayList = (ArrayList) m4Var.c;
        if (i2 < 1) {
            return;
        }
        arrayList.add(m4Var.l(null, 1, i, i2));
        m4Var.a |= 1;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.st0
    public final void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.i(null);
        m4 m4Var = recyclerView.e;
        ArrayList arrayList = (ArrayList) m4Var.c;
        if (i == i2) {
            return;
        }
        arrayList.add(m4Var.l(null, 8, i, i2));
        m4Var.a |= 8;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.st0
    public final void e(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.i(null);
        m4 m4Var = recyclerView.e;
        ArrayList arrayList = (ArrayList) m4Var.c;
        if (i2 < 1) {
            return;
        }
        arrayList.add(m4Var.l(null, 2, i, i2));
        m4Var.a |= 2;
        if (arrayList.size() == 1) {
            f();
        }
    }

    public final void f() {
        int[] iArr = RecyclerView.w0;
        RecyclerView recyclerView = this.a;
        if (!recyclerView.s || !recyclerView.r) {
            recyclerView.z = true;
            recyclerView.requestLayout();
        } else {
            ot0 ot0Var = recyclerView.i;
            WeakHashMap weakHashMap = uf1.a;
            recyclerView.postOnAnimation(ot0Var);
        }
    }
}
