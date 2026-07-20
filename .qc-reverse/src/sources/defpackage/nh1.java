package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nh1 {
    public static int f;
    public ArrayList a;
    public int b;
    public int c;
    public ArrayList d;
    public int e;

    public final void a(ArrayList arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                nh1 nh1Var = (nh1) arrayList.get(i);
                if (this.e == nh1Var.b) {
                    c(this.c, nh1Var);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(rg0 rg0Var, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.a;
        if (arrayList.size() == 0) {
            return 0;
        }
        wn wnVar = (wn) ((vn) arrayList.get(0)).T;
        rg0Var.t();
        wnVar.b(rg0Var, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((vn) arrayList.get(i2)).b(rg0Var, false);
        }
        if (i == 0 && wnVar.z0 > 0) {
            xr.a(wnVar, rg0Var, arrayList, 0);
        }
        if (i == 1 && wnVar.A0 > 0) {
            xr.a(wnVar, rg0Var, arrayList, 1);
        }
        try {
            rg0Var.p();
        } catch (Exception e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.d = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            vn vnVar = (vn) arrayList.get(i3);
            c70 c70Var = new c70(29);
            new WeakReference(vnVar);
            rg0.n(vnVar.I);
            rg0.n(vnVar.J);
            rg0.n(vnVar.K);
            rg0.n(vnVar.L);
            rg0.n(vnVar.M);
            this.d.add(c70Var);
        }
        if (i == 0) {
            iN = rg0.n(wnVar.I);
            iN2 = rg0.n(wnVar.K);
            rg0Var.t();
        } else {
            iN = rg0.n(wnVar.J);
            iN2 = rg0.n(wnVar.L);
            rg0Var.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, nh1 nh1Var) {
        int i2 = nh1Var.b;
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            vn vnVar = (vn) obj;
            ArrayList arrayList2 = nh1Var.a;
            if (!arrayList2.contains(vnVar)) {
                arrayList2.add(vnVar);
            }
            if (i == 0) {
                vnVar.n0 = i2;
            } else {
                vnVar.o0 = i2;
            }
        }
        this.e = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.b);
        sb.append("] <");
        String string = sb.toString();
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            string = string + " " + ((vn) obj).h0;
        }
        return string.concat(" >");
    }
}
