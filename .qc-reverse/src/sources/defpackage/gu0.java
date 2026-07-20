package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gu0 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public fu0 g;
    public final /* synthetic */ RecyclerView h;

    public gu0(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(pu0 pu0Var, boolean z) {
        RecyclerView.j(pu0Var);
        View view = pu0Var.a;
        RecyclerView recyclerView = this.h;
        ru0 ru0Var = recyclerView.n0;
        if (ru0Var != null) {
            y yVarJ = ru0Var.j();
            uf1.n(view, yVarJ instanceof qu0 ? (y) ((qu0) yVarJ).e.remove(view) : null);
        }
        if (z && recyclerView.g0 != null) {
            recyclerView.g.K(pu0Var);
        }
        pu0Var.r = null;
        fu0 fu0VarC = c();
        fu0VarC.getClass();
        int i = pu0Var.f;
        ArrayList arrayList = fu0VarC.a(i).a;
        if (((eu0) fu0VarC.a.get(i)).b <= arrayList.size()) {
            return;
        }
        pu0Var.n();
        arrayList.add(pu0Var);
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.h;
        mu0 mu0Var = recyclerView.g0;
        if (i >= 0 && i < mu0Var.b()) {
            return !mu0Var.g ? i : recyclerView.e.g(i, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + mu0Var.b() + recyclerView.z());
    }

    public final fu0 c() {
        if (this.g == null) {
            fu0 fu0Var = new fu0();
            fu0Var.a = new SparseArray();
            fu0Var.b = 0;
            this.g = fu0Var;
        }
        return this.g;
    }

    public final void d() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            e(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.w0;
        l50 l50Var = this.h.f0;
        int[] iArr2 = l50Var.c;
        if (iArr2 != null) {
            Arrays.fill(iArr2, -1);
        }
        l50Var.d = 0;
    }

    public final void e(int i) {
        ArrayList arrayList = this.c;
        a((pu0) arrayList.get(i), true);
        arrayList.remove(i);
    }

    public final void f(View view) {
        pu0 pu0VarJ = RecyclerView.J(view);
        boolean zK = pu0VarJ.k();
        RecyclerView recyclerView = this.h;
        if (zK) {
            recyclerView.removeDetachedView(view, false);
        }
        if (pu0VarJ.j()) {
            pu0VarJ.n.j(pu0VarJ);
        } else if (pu0VarJ.q()) {
            pu0VarJ.j &= -33;
        }
        g(pu0VarJ);
        if (recyclerView.L == null || pu0VarJ.h()) {
            return;
        }
        recyclerView.L.e(pu0VarJ);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(defpackage.pu0 r12) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gu0.g(pu0):void");
    }

    public final void h(View view) {
        vt0 vt0Var;
        pu0 pu0VarJ = RecyclerView.J(view);
        int i = pu0VarJ.j & 12;
        RecyclerView recyclerView = this.h;
        if (i == 0 && pu0VarJ.l() && (vt0Var = recyclerView.L) != null) {
            ns nsVar = (ns) vt0Var;
            if (pu0VarJ.d().isEmpty() && nsVar.g && !pu0VarJ.g()) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                pu0VarJ.n = this;
                pu0VarJ.o = true;
                this.b.add(pu0VarJ);
                return;
            }
        }
        if (pu0VarJ.g() && !pu0VarJ.i() && !recyclerView.m.b) {
            zy.n("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.".concat(recyclerView.z()));
            return;
        }
        pu0VarJ.n = this;
        pu0VarJ.o = false;
        this.a.add(pu0VarJ);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x052a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.pu0 i(int r28, long r29) {
        /*
            Method dump skipped, instruction units count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gu0.i(int, long):pu0");
    }

    public final void j(pu0 pu0Var) {
        if (pu0Var.o) {
            this.b.remove(pu0Var);
        } else {
            this.a.remove(pu0Var);
        }
        pu0Var.n = null;
        pu0Var.o = false;
        pu0Var.j &= -33;
    }

    public final void k() {
        zt0 zt0Var = this.h.n;
        this.f = this.e + (zt0Var != null ? zt0Var.j : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            e(size);
        }
    }
}
