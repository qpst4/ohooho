package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ns extends vt0 {
    public static TimeInterpolator s;
    public final boolean g;
    public final ArrayList h;
    public final ArrayList i;
    public final ArrayList j;
    public final ArrayList k;
    public final ArrayList l;
    public final ArrayList m;
    public final ArrayList n;
    public final ArrayList o;
    public final ArrayList p;
    public final ArrayList q;
    public final ArrayList r;

    public ns() {
        this.a = null;
        this.b = new ArrayList();
        this.c = 120L;
        this.d = 120L;
        this.e = 250L;
        this.f = 250L;
        this.g = true;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
    }

    public static void i(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((pu0) arrayList.get(size)).a.animate().cancel();
        }
    }

    @Override // defpackage.vt0
    public boolean a(pu0 pu0Var, rm0 rm0Var, rm0 rm0Var2) {
        int i;
        int i2;
        if (rm0Var != null && ((i = rm0Var.a) != (i2 = rm0Var2.a) || rm0Var.b != rm0Var2.b)) {
            return h(pu0Var, i, rm0Var.b, i2, rm0Var2.b);
        }
        m(pu0Var);
        pu0Var.a.setAlpha(0.0f);
        this.i.add(pu0Var);
        return true;
    }

    @Override // defpackage.vt0
    public final boolean b(pu0 pu0Var, pu0 pu0Var2, rm0 rm0Var, rm0 rm0Var2) {
        int i;
        int i2;
        int i3 = rm0Var.a;
        int i4 = rm0Var.b;
        if (pu0Var2.p()) {
            int i5 = rm0Var.a;
            i2 = rm0Var.b;
            i = i5;
        } else {
            i = rm0Var2.a;
            i2 = rm0Var2.b;
        }
        if (pu0Var == pu0Var2) {
            return h(pu0Var, i3, i4, i, i2);
        }
        View view = pu0Var.a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        m(pu0Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = pu0Var2.a;
        m(pu0Var2);
        view2.setTranslationX(-((int) ((i - i3) - translationX)));
        view2.setTranslationY(-((int) ((i2 - i4) - translationY)));
        view2.setAlpha(0.0f);
        ls lsVar = new ls();
        lsVar.a = pu0Var;
        lsVar.b = pu0Var2;
        lsVar.c = i3;
        lsVar.d = i4;
        lsVar.e = i;
        lsVar.f = i2;
        this.k.add(lsVar);
        return true;
    }

    @Override // defpackage.vt0
    public final void e(pu0 pu0Var) {
        View view = pu0Var.a;
        view.animate().cancel();
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((ms) arrayList.get(size)).a == pu0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                d(pu0Var);
                arrayList.remove(size);
            }
        }
        k(this.k, pu0Var);
        if (this.h.remove(pu0Var)) {
            view.setAlpha(1.0f);
            d(pu0Var);
        }
        if (this.i.remove(pu0Var)) {
            view.setAlpha(1.0f);
            d(pu0Var);
        }
        ArrayList arrayList2 = this.n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            k(arrayList3, pu0Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((ms) arrayList5.get(size4)).a == pu0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    d(pu0Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(pu0Var)) {
                view.setAlpha(1.0f);
                d(pu0Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.q.remove(pu0Var);
        this.o.remove(pu0Var);
        this.r.remove(pu0Var);
        this.p.remove(pu0Var);
        j();
    }

    @Override // defpackage.vt0
    public final void f() {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            ms msVar = (ms) arrayList.get(size);
            View view = msVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            d(msVar.a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            d((pu0) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            pu0 pu0Var = (pu0) arrayList3.get(size3);
            pu0Var.a.setAlpha(1.0f);
            d(pu0Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            ls lsVar = (ls) arrayList4.get(size4);
            pu0 pu0Var2 = lsVar.a;
            if (pu0Var2 != null) {
                l(lsVar, pu0Var2);
            }
            pu0 pu0Var3 = lsVar.b;
            if (pu0Var3 != null) {
                l(lsVar, pu0Var3);
            }
        }
        arrayList4.clear();
        if (g()) {
            ArrayList arrayList5 = this.m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    ms msVar2 = (ms) arrayList6.get(size6);
                    View view2 = msVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    d(msVar2.a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    pu0 pu0Var4 = (pu0) arrayList8.get(size8);
                    pu0Var4.a.setAlpha(1.0f);
                    d(pu0Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    ls lsVar2 = (ls) arrayList10.get(size10);
                    pu0 pu0Var5 = lsVar2.a;
                    if (pu0Var5 != null) {
                        l(lsVar2, pu0Var5);
                    }
                    pu0 pu0Var6 = lsVar2.b;
                    if (pu0Var6 != null) {
                        l(lsVar2, pu0Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            i(this.q);
            i(this.p);
            i(this.o);
            i(this.r);
            ArrayList arrayList11 = this.b;
            if (arrayList11.size() <= 0) {
                arrayList11.clear();
            } else {
                arrayList11.get(0).getClass();
                s1.d();
            }
        }
    }

    @Override // defpackage.vt0
    public final boolean g() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public final boolean h(pu0 pu0Var, int i, int i2, int i3, int i4) {
        View view = pu0Var.a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) pu0Var.a.getTranslationY());
        m(pu0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            d(pu0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ms msVar = new ms();
        msVar.a = pu0Var;
        msVar.b = translationX;
        msVar.c = translationY;
        msVar.d = i3;
        msVar.e = i4;
        this.j.add(msVar);
        return true;
    }

    public final void j() {
        if (g()) {
            return;
        }
        ArrayList arrayList = this.b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            s1.d();
        }
    }

    public final void k(ArrayList arrayList, pu0 pu0Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ls lsVar = (ls) arrayList.get(size);
            if (l(lsVar, pu0Var) && lsVar.a == null && lsVar.b == null) {
                arrayList.remove(lsVar);
            }
        }
    }

    public final boolean l(ls lsVar, pu0 pu0Var) {
        if (lsVar.b == pu0Var) {
            lsVar.b = null;
        } else {
            if (lsVar.a != pu0Var) {
                return false;
            }
            lsVar.a = null;
        }
        View view = pu0Var.a;
        View view2 = pu0Var.a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        d(pu0Var);
        return true;
    }

    public final void m(pu0 pu0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        pu0Var.a.animate().setInterpolator(s);
        e(pu0Var);
    }
}
