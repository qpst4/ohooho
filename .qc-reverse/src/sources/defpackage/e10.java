package defpackage;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e10 extends xo0 {
    public final xo0 c;

    public e10(xo0 xo0Var) {
        this.c = xo0Var;
        xo0Var.j(new d10(0, this));
    }

    @Override // defpackage.xo0
    public final void a(ViewGroup viewGroup, int i, Object obj) {
        xo0 xo0Var = this.c;
        if (i < xo0Var.c()) {
            xo0Var.a(viewGroup, i, obj);
        }
    }

    @Override // defpackage.xo0
    public final void b(ViewGroup viewGroup) {
        this.c.b(viewGroup);
    }

    @Override // defpackage.xo0
    public final int c() {
        return this.c.c() + 1;
    }

    @Override // defpackage.xo0
    public final int d(Object obj) {
        xo0 xo0Var = this.c;
        int iD = xo0Var.d(obj);
        if (iD < xo0Var.c()) {
            return iD;
        }
        return -2;
    }

    @Override // defpackage.xo0
    public final CharSequence e(int i) {
        xo0 xo0Var = this.c;
        if (i < xo0Var.c()) {
            return xo0Var.e(i);
        }
        return null;
    }

    @Override // defpackage.xo0
    public final float f(int i) {
        xo0 xo0Var = this.c;
        if (i < xo0Var.c()) {
            return xo0Var.f(i);
        }
        return 1.0f;
    }

    @Override // defpackage.xo0
    public final Object g(mg1 mg1Var, int i) {
        xo0 xo0Var = this.c;
        if (i < xo0Var.c()) {
            return xo0Var.g(mg1Var, i);
        }
        return null;
    }

    @Override // defpackage.xo0
    public final boolean h(View view, Object obj) {
        return obj != null && this.c.h(view, obj);
    }

    @Override // defpackage.xo0
    public final void j(DataSetObserver dataSetObserver) {
        this.c.j(dataSetObserver);
    }

    @Override // defpackage.xo0
    public final void k(Parcelable parcelable, ClassLoader classLoader) {
        this.c.k(parcelable, classLoader);
    }

    @Override // defpackage.xo0
    public final Parcelable l() {
        return this.c.l();
    }

    @Override // defpackage.xo0
    public final void m(mg1 mg1Var, int i, Object obj) {
        xo0 xo0Var = this.c;
        if (i < xo0Var.c()) {
            xo0Var.m(mg1Var, i, obj);
        }
    }

    @Override // defpackage.xo0
    public final void n(ViewGroup viewGroup) {
        this.c.n(viewGroup);
    }

    @Override // defpackage.xo0
    public final void o(DataSetObserver dataSetObserver) {
        this.c.o(dataSetObserver);
    }
}
