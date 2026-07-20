package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m4 {
    public int a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;
    public Object f;

    public m4(pt0 pt0Var) {
        this.b = new tp0(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = 0;
        this.e = pt0Var;
        this.f = new tb0(11, this);
    }

    public void a() {
        View view = (View) this.b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((zm) this.d) != null) {
                if (((zm) this.f) == null) {
                    this.f = new zm();
                }
                zm zmVar = (zm) this.f;
                zmVar.c = null;
                zmVar.b = false;
                zmVar.d = null;
                zmVar.a = false;
                WeakHashMap weakHashMap = uf1.a;
                ColorStateList colorStateListC = lf1.c(view);
                if (colorStateListC != null) {
                    zmVar.b = true;
                    zmVar.c = colorStateListC;
                }
                PorterDuff.Mode modeD = lf1.d(view);
                if (modeD != null) {
                    zmVar.a = true;
                    zmVar.d = modeD;
                }
                if (zmVar.b || zmVar.a) {
                    b9.e(background, zmVar, view.getDrawableState());
                    return;
                }
            }
            zm zmVar2 = (zm) this.e;
            if (zmVar2 != null) {
                b9.e(background, zmVar2, view.getDrawableState());
                return;
            }
            zm zmVar3 = (zm) this.d;
            if (zmVar3 != null) {
                b9.e(background, zmVar3, view.getDrawableState());
            }
        }
    }

    public boolean b(int i) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = (l4) arrayList.get(i2);
            int i3 = l4Var.a;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = l4Var.b;
                    int i5 = l4Var.d + i4;
                    while (i4 < i5) {
                        if (g(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (g(l4Var.d, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((pt0) this.e).a((l4) arrayList.get(i));
        }
        q(arrayList);
        this.a = 0;
    }

    public void d() {
        pt0 pt0Var = (pt0) this.e;
        c();
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            l4 l4Var = (l4) arrayList.get(i);
            int i2 = l4Var.a;
            if (i2 == 1) {
                pt0Var.a(l4Var);
                pt0Var.d(l4Var.b, l4Var.d);
            } else if (i2 == 2) {
                pt0Var.a(l4Var);
                int i3 = l4Var.b;
                int i4 = l4Var.d;
                RecyclerView recyclerView = pt0Var.a;
                recyclerView.Q(i3, i4, true);
                recyclerView.j0 = true;
                recyclerView.g0.c += i4;
            } else if (i2 == 4) {
                pt0Var.a(l4Var);
                pt0Var.c(l4Var.b, l4Var.d, l4Var.c);
            } else if (i2 == 8) {
                pt0Var.a(l4Var);
                pt0Var.e(l4Var.b, l4Var.d);
            }
        }
        q(arrayList);
        this.a = 0;
    }

    public void e(l4 l4Var) {
        int i;
        tp0 tp0Var = (tp0) this.b;
        int i2 = l4Var.a;
        if (i2 == 1 || i2 == 8) {
            zy.n("should not dispatch add or move for pre layout");
            return;
        }
        int iU = u(l4Var.b, i2);
        int i3 = l4Var.b;
        int i4 = l4Var.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                zy.h("op should be remove or update.", l4Var);
                return;
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < l4Var.d; i6++) {
            int iU2 = u((i * i6) + l4Var.b, l4Var.a);
            int i7 = l4Var.a;
            if (i7 == 2 ? iU2 != iU : !(i7 == 4 && iU2 == iU + 1)) {
                l4 l4VarL = l(l4Var.c, i7, iU, i5);
                f(l4VarL, i3);
                l4VarL.c = null;
                tp0Var.c(l4VarL);
                if (l4Var.a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iU = iU2;
            } else {
                i5++;
            }
        }
        Object obj = l4Var.c;
        l4Var.c = null;
        tp0Var.c(l4Var);
        if (i5 > 0) {
            l4 l4VarL2 = l(obj, l4Var.a, iU, i5);
            f(l4VarL2, i3);
            l4VarL2.c = null;
            tp0Var.c(l4VarL2);
        }
    }

    public void f(l4 l4Var, int i) {
        pt0 pt0Var = (pt0) this.e;
        pt0Var.a(l4Var);
        int i2 = l4Var.a;
        if (i2 != 2) {
            if (i2 == 4) {
                pt0Var.c(i, l4Var.d, l4Var.c);
                return;
            } else {
                zy.n("only remove and update ops can be dispatched in first pass");
                return;
            }
        }
        int i3 = l4Var.d;
        RecyclerView recyclerView = pt0Var.a;
        recyclerView.Q(i, i3, true);
        recyclerView.j0 = true;
        recyclerView.g0.c += i3;
    }

    public int g(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i2 < size) {
            l4 l4Var = (l4) arrayList.get(i2);
            int i3 = l4Var.a;
            int i4 = l4Var.b;
            if (i3 == 8) {
                if (i4 == i) {
                    i = l4Var.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (l4Var.d <= i) {
                        i++;
                    }
                }
            } else if (i4 > i) {
                continue;
            } else if (i3 == 2) {
                int i5 = l4Var.d;
                if (i < i4 + i5) {
                    return -1;
                }
                i -= i5;
            } else if (i3 == 1) {
                i += l4Var.d;
            }
            i2++;
        }
        return i;
    }

    public ColorStateList h() {
        zm zmVar = (zm) this.e;
        if (zmVar != null) {
            return (ColorStateList) zmVar.c;
        }
        return null;
    }

    public PorterDuff.Mode i() {
        zm zmVar = (zm) this.e;
        if (zmVar != null) {
            return (PorterDuff.Mode) zmVar.d;
        }
        return null;
    }

    public boolean j() {
        return ((ArrayList) this.c).size() > 0;
    }

    public void k(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListF;
        View view = (View) this.b;
        Context context = view.getContext();
        int[] iArr = zs0.z;
        ra raVarM = ra.M(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) raVarM.c;
        View view2 = (View) this.b;
        uf1.m(view2, view2.getContext(), iArr, attributeSet, (TypedArray) raVarM.c, i);
        try {
            if (typedArray.hasValue(0)) {
                this.a = typedArray.getResourceId(0, -1);
                b9 b9Var = (b9) this.c;
                Context context2 = view.getContext();
                int i2 = this.a;
                synchronized (b9Var) {
                    colorStateListF = b9Var.a.f(context2, i2);
                }
                if (colorStateListF != null) {
                    r(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                lf1.i(view, raVarM.x(1));
            }
            if (typedArray.hasValue(2)) {
                lf1.j(view, vu.c(typedArray.getInt(2, -1), null));
            }
            raVarM.O();
        } catch (Throwable th) {
            raVarM.O();
            throw th;
        }
    }

    public l4 l(Object obj, int i, int i2, int i3) {
        l4 l4Var = (l4) ((tp0) this.b).a();
        if (l4Var != null) {
            l4Var.a = i;
            l4Var.b = i2;
            l4Var.d = i3;
            l4Var.c = obj;
            return l4Var;
        }
        l4 l4Var2 = new l4();
        l4Var2.a = i;
        l4Var2.b = i2;
        l4Var2.d = i3;
        l4Var2.c = obj;
        return l4Var2;
    }

    public void m() {
        this.a = -1;
        r(null);
        a();
    }

    public void n(int i) {
        ColorStateList colorStateListF;
        this.a = i;
        b9 b9Var = (b9) this.c;
        if (b9Var != null) {
            Context context = ((View) this.b).getContext();
            synchronized (b9Var) {
                colorStateListF = b9Var.a.f(context, i);
            }
        } else {
            colorStateListF = null;
        }
        r(colorStateListF);
        a();
    }

    public void o(l4 l4Var) {
        pt0 pt0Var = (pt0) this.e;
        ((ArrayList) this.d).add(l4Var);
        int i = l4Var.a;
        if (i == 1) {
            pt0Var.d(l4Var.b, l4Var.d);
            return;
        }
        if (i == 2) {
            int i2 = l4Var.b;
            int i3 = l4Var.d;
            RecyclerView recyclerView = pt0Var.a;
            recyclerView.Q(i2, i3, false);
            recyclerView.j0 = true;
            return;
        }
        if (i == 4) {
            pt0Var.c(l4Var.b, l4Var.d, l4Var.c);
        } else if (i == 8) {
            pt0Var.e(l4Var.b, l4Var.d);
        } else {
            zy.h("Unknown update op type for ", l4Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m4.p():void");
    }

    public void q(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            l4 l4Var = (l4) arrayList.get(i);
            l4Var.c = null;
            ((tp0) this.b).c(l4Var);
        }
        arrayList.clear();
    }

    public void r(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((zm) this.d) == null) {
                this.d = new zm();
            }
            zm zmVar = (zm) this.d;
            zmVar.c = colorStateList;
            zmVar.b = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void s(ColorStateList colorStateList) {
        if (((zm) this.e) == null) {
            this.e = new zm();
        }
        zm zmVar = (zm) this.e;
        zmVar.c = colorStateList;
        zmVar.b = true;
        a();
    }

    public void t(PorterDuff.Mode mode) {
        if (((zm) this.e) == null) {
            this.e = new zm();
        }
        zm zmVar = (zm) this.e;
        zmVar.d = mode;
        zmVar.a = true;
        a();
    }

    public int u(int i, int i2) {
        int i3;
        int i4;
        tp0 tp0Var = (tp0) this.b;
        ArrayList arrayList = (ArrayList) this.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l4 l4Var = (l4) arrayList.get(size);
            int i5 = l4Var.a;
            int i6 = l4Var.b;
            if (i5 == 8) {
                int i7 = l4Var.d;
                if (i6 < i7) {
                    i4 = i7;
                    i3 = i6;
                } else {
                    i3 = i7;
                    i4 = i6;
                }
                if (i < i3 || i > i4) {
                    if (i < i6) {
                        if (i2 == 1) {
                            l4Var.b = i6 + 1;
                            l4Var.d = i7 + 1;
                        } else if (i2 == 2) {
                            l4Var.b = i6 - 1;
                            l4Var.d = i7 - 1;
                        }
                    }
                } else if (i3 == i6) {
                    if (i2 == 1) {
                        l4Var.d = i7 + 1;
                    } else if (i2 == 2) {
                        l4Var.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        l4Var.b = i6 + 1;
                    } else if (i2 == 2) {
                        l4Var.b = i6 - 1;
                    }
                    i--;
                }
            } else if (i6 <= i) {
                if (i5 == 1) {
                    i -= l4Var.d;
                } else if (i5 == 2) {
                    i += l4Var.d;
                }
            } else if (i2 == 1) {
                l4Var.b = i6 + 1;
            } else if (i2 == 2) {
                l4Var.b = i6 - 1;
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            l4 l4Var2 = (l4) arrayList.get(size2);
            int i8 = l4Var2.a;
            int i9 = l4Var2.d;
            if (i8 == 8) {
                if (i9 == l4Var2.b || i9 < 0) {
                    arrayList.remove(size2);
                    l4Var2.c = null;
                    tp0Var.c(l4Var2);
                }
            } else if (i9 <= 0) {
                arrayList.remove(size2);
                l4Var2.c = null;
                tp0Var.c(l4Var2);
            }
        }
        return i;
    }

    public m4(View view) {
        this.a = -1;
        this.b = view;
        this.c = b9.a();
    }
}
