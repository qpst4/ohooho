package defpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u91 {
    public final LinkedList a;
    public final LinkedList b;
    public final float c;
    public final int d;
    public final int e;
    public final int f;

    public u91(f91 f91Var) {
        int i = t91.a[f91Var.e().ordinal()];
        if (i == 1) {
            this.c = -90.0f;
        } else if (i == 2) {
            this.c = 90.0f;
        } else if (i == 3) {
            this.c = 0.0f;
        } else if (i == 4) {
            this.c = 180.0f;
        }
        m91 m91VarB = f91Var.b();
        List list = z91.a;
        this.a = a(m91VarB.s() ? z91.a : m91VarB.k(), this.c);
        m91 m91VarB2 = f91Var.b();
        this.b = a(m91VarB2.t() ? m91VarB2.f() : z91.b, this.c);
        m91 m91VarB3 = f91Var.b();
        int iM = m91VarB3.s() ? z91.e : m91VarB3.m();
        this.d = iM;
        m91 m91VarB4 = f91Var.b();
        int iL = iM + (m91VarB4.s() ? z91.f : m91VarB4.l());
        this.e = iL;
        m91 m91VarB5 = f91Var.b();
        this.f = iL + (m91VarB5.s() ? z91.g : m91VarB5.g());
    }

    public static LinkedList a(List list, float f) {
        LinkedList linkedList = new LinkedList();
        if (list.size() == 1) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.add((h91) arrayList.get(0));
            list = arrayList;
        }
        float fSum = 180.0f / list.stream().mapToInt(new v71(1)).sum();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < list.size()) {
            h91 h91Var = (h91) list.get((f == 90.0f || f == 0.0f) ? (list.size() - i) - 1 : i);
            float f2 = f;
            linkedList.add(new v91(i3, fSum, f2, h91Var, i2 == 0, i2 == list.size() - 1));
            i3 += h91Var.i();
            i2++;
            i++;
            f = f2;
        }
        return linkedList;
    }
}
