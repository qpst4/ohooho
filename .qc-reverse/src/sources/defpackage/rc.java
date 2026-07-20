package defpackage;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rc extends t81 {
    public int E;
    public ArrayList C = new ArrayList();
    public boolean F = false;
    public int G = 0;
    public boolean D = false;

    public rc() {
        I(new b10(2));
        I(new ij());
        I(new b10(1));
    }

    @Override // defpackage.t81
    public final void A(long j) {
        ArrayList arrayList;
        this.d = j;
        if (j < 0 || (arrayList = this.C) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).A(j);
        }
    }

    @Override // defpackage.t81
    public final void B(xy0 xy0Var) {
        this.G |= 8;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).B(xy0Var);
        }
    }

    @Override // defpackage.t81
    public final void C(TimeInterpolator timeInterpolator) {
        this.G |= 1;
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((t81) this.C.get(i)).C(timeInterpolator);
            }
        }
        this.e = timeInterpolator;
    }

    @Override // defpackage.t81
    public final void D(ow0 ow0Var) {
        super.D(ow0Var);
        this.G |= 4;
        if (this.C != null) {
            for (int i = 0; i < this.C.size(); i++) {
                ((t81) this.C.get(i)).D(ow0Var);
            }
        }
    }

    @Override // defpackage.t81
    public final void E() {
        this.G |= 2;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).E();
        }
    }

    @Override // defpackage.t81
    public final void F(long j) {
        this.c = j;
    }

    @Override // defpackage.t81
    public final String H(String str) {
        String strH = super.H(str);
        for (int i = 0; i < this.C.size(); i++) {
            strH = strH + "\n" + ((t81) this.C.get(i)).H(str.concat("  "));
        }
        return strH;
    }

    public final void I(t81 t81Var) {
        this.C.add(t81Var);
        t81Var.k = this;
        long j = this.d;
        if (j >= 0) {
            t81Var.A(j);
        }
        if ((this.G & 1) != 0) {
            t81Var.C(this.e);
        }
        if ((this.G & 2) != 0) {
            t81Var.E();
        }
        if ((this.G & 4) != 0) {
            t81Var.D(this.x);
        }
        if ((this.G & 8) != 0) {
            t81Var.B(null);
        }
    }

    @Override // defpackage.t81
    public final void c() {
        super.c();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).c();
        }
    }

    @Override // defpackage.t81
    public final void d(b91 b91Var) {
        View view = b91Var.b;
        if (t(view)) {
            ArrayList arrayList = this.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                t81 t81Var = (t81) obj;
                if (t81Var.t(view)) {
                    t81Var.d(b91Var);
                    b91Var.c.add(t81Var);
                }
            }
        }
    }

    @Override // defpackage.t81
    public final void f(b91 b91Var) {
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).f(b91Var);
        }
    }

    @Override // defpackage.t81
    public final void g(b91 b91Var) {
        View view = b91Var.b;
        if (t(view)) {
            ArrayList arrayList = this.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                t81 t81Var = (t81) obj;
                if (t81Var.t(view)) {
                    t81Var.g(b91Var);
                    b91Var.c.add(t81Var);
                }
            }
        }
    }

    @Override // defpackage.t81
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final t81 clone() {
        rc rcVar = (rc) super.clone();
        rcVar.C = new ArrayList();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            t81 t81VarClone = ((t81) this.C.get(i)).clone();
            rcVar.C.add(t81VarClone);
            t81VarClone.k = rcVar;
        }
        return rcVar;
    }

    @Override // defpackage.t81
    public final void l(ViewGroup viewGroup, g7 g7Var, g7 g7Var2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.c;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            t81 t81Var = (t81) this.C.get(i);
            if (j > 0 && (this.D || i == 0)) {
                long j2 = t81Var.c;
                if (j2 > 0) {
                    t81Var.F(j2 + j);
                } else {
                    t81Var.F(j);
                }
            }
            t81Var.l(viewGroup, g7Var, g7Var2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.t81
    public final void w(View view) {
        super.w(view);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).w(view);
        }
    }

    @Override // defpackage.t81
    public final t81 x(s81 s81Var) {
        super.x(s81Var);
        return this;
    }

    @Override // defpackage.t81
    public final void y(View view) {
        super.y(view);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((t81) this.C.get(i)).y(view);
        }
    }

    @Override // defpackage.t81
    public final void z() {
        ArrayList arrayList;
        if (this.C.isEmpty()) {
            G();
            m();
            return;
        }
        y81 y81Var = new y81();
        y81Var.b = this;
        ArrayList arrayList2 = this.C;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((t81) obj).a(y81Var);
        }
        this.E = this.C.size();
        if (this.D) {
            ArrayList arrayList3 = this.C;
            int size2 = arrayList3.size();
            while (i < size2) {
                Object obj2 = arrayList3.get(i);
                i++;
                ((t81) obj2).z();
            }
            return;
        }
        int i3 = 1;
        while (true) {
            int size3 = this.C.size();
            arrayList = this.C;
            if (i3 >= size3) {
                break;
            }
            ((t81) arrayList.get(i3 - 1)).a(new y81((t81) this.C.get(i3)));
            i3++;
        }
        t81 t81Var = (t81) arrayList.get(0);
        if (t81Var != null) {
            t81Var.z();
        }
    }
}
