package defpackage;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e11 extends xo0 {
    public final y30 c;
    public ld d = null;
    public j30 e = null;
    public boolean f;
    public final ArrayList g;
    public final y30 h;

    public e11(y30 y30Var) {
        this.c = y30Var;
        this.g = new ArrayList();
        this.h = y30Var;
        this.g = new ArrayList();
    }

    @Override // defpackage.xo0
    public final void a(ViewGroup viewGroup, int i, Object obj) {
        j30 j30Var = (j30) obj;
        if (j30Var == null) {
            return;
        }
        if (this.d == null) {
            y30 y30Var = this.c;
            y30Var.getClass();
            this.d = new ld(y30Var);
        }
        this.d.f(j30Var);
        if (j30Var != this.e) {
            return;
        }
        this.e = null;
    }

    @Override // defpackage.xo0
    public final void b(ViewGroup viewGroup) {
        ld ldVar = this.d;
        if (ldVar != null) {
            if (!this.f) {
                try {
                    this.f = true;
                    if (ldVar.g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    ldVar.h = false;
                    ldVar.q.A(ldVar, true);
                } finally {
                    this.f = false;
                }
            }
            this.d = null;
        }
    }

    @Override // defpackage.xo0
    public final int c() {
        return this.g.size();
    }

    @Override // defpackage.xo0
    public final int d(Object obj) {
        if (!(obj instanceof j30)) {
            return -1;
        }
        y30 y30Var = this.h;
        y30Var.getClass();
        ld ldVar = new ld(y30Var);
        j30 j30Var = (j30) obj;
        ldVar.f(j30Var);
        ldVar.b(new h40(7, j30Var));
        ldVar.e(false);
        return -1;
    }

    @Override // defpackage.xo0
    public final Object g(mg1 mg1Var, int i) {
        ArrayList arrayList = this.g;
        j30 j30VarB = ((d11) arrayList.get(i)).b();
        if (j30VarB.D()) {
            return j30VarB;
        }
        ld ldVar = this.d;
        y30 y30Var = this.c;
        if (ldVar == null) {
            y30Var.getClass();
            this.d = new ld(y30Var);
        }
        long j = i;
        j30 j30VarD = y30Var.D("android:switcher:" + mg1Var.getId() + ":" + j);
        if (j30VarD != null) {
            ld ldVar2 = this.d;
            ldVar2.getClass();
            ldVar2.b(new h40(7, j30VarD));
        } else {
            j30VarD = ((d11) arrayList.get(i)).b();
            this.d.g(mg1Var.getId(), j30VarD, "android:switcher:" + mg1Var.getId() + ":" + j, 1);
        }
        if (j30VarD != this.e) {
            if (j30VarD.E) {
                j30VarD.E = false;
            }
            j30VarD.e0(false);
        }
        d11 d11Var = (d11) arrayList.get(i);
        if (d11Var instanceof iw0) {
            ((iw0) d11Var).g(j30VarD);
            arrayList.set(i, d11Var);
            if ((j30VarD instanceof f11) && j30VarD.D()) {
                ((f11) j30VarD).h0();
            }
        }
        return j30VarD;
    }

    @Override // defpackage.xo0
    public final boolean h(View view, Object obj) {
        return ((j30) obj).H == view;
    }

    @Override // defpackage.xo0
    public final Parcelable l() {
        return null;
    }

    @Override // defpackage.xo0
    public final void m(mg1 mg1Var, int i, Object obj) {
        j30 j30Var = (j30) obj;
        j30 j30Var2 = this.e;
        if (j30Var != j30Var2) {
            if (j30Var2 != null) {
                if (j30Var2.E) {
                    j30Var2.E = false;
                }
                j30Var2.e0(false);
            }
            if (!j30Var.E) {
                j30Var.E = true;
            }
            j30Var.e0(true);
            this.e = j30Var;
        }
    }

    @Override // defpackage.xo0
    public final void n(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        zy.e(this, " requires a view id", "ViewPager with adapter ");
    }

    @Override // defpackage.xo0
    public final void k(Parcelable parcelable, ClassLoader classLoader) {
    }
}
