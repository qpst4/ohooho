package defpackage;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t81 implements Cloneable {
    public ArrayList m;
    public ArrayList n;
    public s81[] o;
    public static final Animator[] y = new Animator[0];
    public static final int[] z = {2, 1, 3, 4};
    public static final ow0 A = new ow0(27);
    public static final ThreadLocal B = new ThreadLocal();
    public final String b = getClass().getName();
    public long c = -1;
    public long d = -1;
    public TimeInterpolator e = null;
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();
    public ArrayList h = null;
    public g7 i = new g7(13);
    public g7 j = new g7(13);
    public rc k = null;
    public final int[] l = z;
    public final ArrayList p = new ArrayList();
    public Animator[] q = y;
    public int r = 0;
    public boolean s = false;
    public boolean t = false;
    public t81 u = null;
    public ArrayList v = null;
    public ArrayList w = new ArrayList();
    public ow0 x = A;

    public static void b(g7 g7Var, View view, b91 b91Var) {
        kb kbVar = (kb) g7Var.c;
        kb kbVar2 = (kb) g7Var.e;
        SparseArray sparseArray = (SparseArray) g7Var.d;
        vi0 vi0Var = (vi0) g7Var.b;
        kbVar.put(view, b91Var);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = uf1.a;
        String strF = lf1.f(view);
        if (strF != null) {
            if (kbVar2.containsKey(strF)) {
                kbVar2.put(strF, null);
            } else {
                kbVar2.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (vi0Var.b) {
                    int i = vi0Var.e;
                    long[] jArr = vi0Var.c;
                    Object[] objArr = vi0Var.d;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object obj = objArr[i3];
                        if (obj != tk0.f) {
                            if (i3 != i2) {
                                jArr[i2] = jArr[i3];
                                objArr[i2] = obj;
                                objArr[i3] = null;
                            }
                            i2++;
                        }
                    }
                    vi0Var.b = false;
                    vi0Var.e = i2;
                }
                if (f01.f(vi0Var.c, vi0Var.e, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    vi0Var.d(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) vi0Var.b(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    vi0Var.d(itemIdAtPosition, null);
                }
            }
        }
    }

    public static kb p() {
        ThreadLocal threadLocal = B;
        kb kbVar = (kb) threadLocal.get();
        if (kbVar != null) {
            return kbVar;
        }
        kb kbVar2 = new kb(0);
        threadLocal.set(kbVar2);
        return kbVar2;
    }

    public static boolean u(b91 b91Var, b91 b91Var2, String str) {
        Object obj = b91Var.a.get(str);
        Object obj2 = b91Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(long j) {
        this.d = j;
    }

    public void C(TimeInterpolator timeInterpolator) {
        this.e = timeInterpolator;
    }

    public void D(ow0 ow0Var) {
        if (ow0Var == null) {
            this.x = A;
        } else {
            this.x = ow0Var;
        }
    }

    public void F(long j) {
        this.c = j;
    }

    public final void G() {
        if (this.r == 0) {
            v(this, ay0.c);
            this.t = false;
        }
        this.r++;
    }

    public String H(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.d != -1) {
            sb.append("dur(");
            sb.append(this.d);
            sb.append(") ");
        }
        if (this.c != -1) {
            sb.append("dly(");
            sb.append(this.c);
            sb.append(") ");
        }
        if (this.e != null) {
            sb.append("interp(");
            sb.append(this.e);
            sb.append(") ");
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.g;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(s81 s81Var) {
        if (this.v == null) {
            this.v = new ArrayList();
        }
        this.v.add(s81Var);
    }

    public void c() {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.q);
        this.q = y;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.q = animatorArr;
        v(this, ay0.e);
    }

    public abstract void d(b91 b91Var);

    public final void e(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (view.getParent() instanceof ViewGroup) {
            b91 b91Var = new b91(view);
            if (z2) {
                g(b91Var);
            } else {
                d(b91Var);
            }
            b91Var.c.add(this);
            f(b91Var);
            if (z2) {
                b(this.i, view, b91Var);
            } else {
                b(this.j, view, b91Var);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList arrayList = this.h;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    e(viewGroup.getChildAt(i), z2);
                }
            }
        }
    }

    public abstract void g(b91 b91Var);

    public final void h(ViewGroup viewGroup, boolean z2) {
        i(z2);
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.g;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z2);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                b91 b91Var = new b91(viewFindViewById);
                if (z2) {
                    g(b91Var);
                } else {
                    d(b91Var);
                }
                b91Var.c.add(this);
                f(b91Var);
                if (z2) {
                    b(this.i, viewFindViewById, b91Var);
                } else {
                    b(this.j, viewFindViewById, b91Var);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            b91 b91Var2 = new b91(view);
            if (z2) {
                g(b91Var2);
            } else {
                d(b91Var2);
            }
            b91Var2.c.add(this);
            f(b91Var2);
            if (z2) {
                b(this.i, view, b91Var2);
            } else {
                b(this.j, view, b91Var2);
            }
        }
    }

    public final void i(boolean z2) {
        if (z2) {
            ((kb) this.i.c).clear();
            ((SparseArray) this.i.d).clear();
            ((vi0) this.i.b).a();
        } else {
            ((kb) this.j.c).clear();
            ((SparseArray) this.j.d).clear();
            ((vi0) this.j.b).a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: j */
    public t81 clone() {
        try {
            t81 t81Var = (t81) super.clone();
            t81Var.w = new ArrayList();
            t81Var.i = new g7(13);
            t81Var.j = new g7(13);
            t81Var.m = null;
            t81Var.n = null;
            t81Var.u = this;
            t81Var.v = null;
            return t81Var;
        } catch (CloneNotSupportedException e) {
            zy.m(e);
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, b91 b91Var, b91 b91Var2) {
        return null;
    }

    public void l(ViewGroup viewGroup, g7 g7Var, g7 g7Var2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i2;
        View view;
        b91 b91Var;
        Animator animator;
        b91 b91Var2;
        kb kbVarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i3 = 0;
        while (i3 < size) {
            b91 b91Var3 = (b91) arrayList.get(i3);
            b91 b91Var4 = (b91) arrayList2.get(i3);
            if (b91Var3 != null && !b91Var3.c.contains(this)) {
                b91Var3 = null;
            }
            if (b91Var4 != null && !b91Var4.c.contains(this)) {
                b91Var4 = null;
            }
            if ((b91Var3 != null || b91Var4 != null) && (b91Var3 == null || b91Var4 == null || s(b91Var3, b91Var4))) {
                Animator animatorK = k(viewGroup, b91Var3, b91Var4);
                if (animatorK != null) {
                    String str = this.b;
                    if (b91Var4 != null) {
                        view = b91Var4.b;
                        String[] strArrQ = q();
                        if (strArrQ != null && strArrQ.length > 0) {
                            b91Var2 = new b91(view);
                            b91 b91Var5 = (b91) ((kb) g7Var2.c).get(view);
                            i = size;
                            if (b91Var5 != null) {
                                int i4 = 0;
                                while (i4 < strArrQ.length) {
                                    String str2 = strArrQ[i4];
                                    int i5 = i3;
                                    b91Var2.a.put(str2, b91Var5.a.get(str2));
                                    i4++;
                                    i3 = i5;
                                    b91Var5 = b91Var5;
                                }
                            }
                            i2 = i3;
                            int i6 = kbVarP.d;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    animator = animatorK;
                                    break;
                                }
                                r81 r81Var = (r81) kbVarP.get((Animator) kbVarP.f(i7));
                                if (r81Var.c != null && r81Var.a == view && r81Var.b.equals(str) && r81Var.c.equals(b91Var2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator = animatorK;
                            b91Var2 = null;
                        }
                        animatorK = animator;
                        b91Var = b91Var2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = b91Var3.b;
                        b91Var = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        r81 r81Var2 = new r81();
                        r81Var2.a = view;
                        r81Var2.b = str;
                        r81Var2.c = b91Var;
                        r81Var2.d = windowId;
                        r81Var2.e = this;
                        r81Var2.f = animatorK;
                        kbVarP.put(animatorK, r81Var2);
                        this.w.add(animatorK);
                    }
                }
                i3 = i2 + 1;
                size = i;
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                r81 r81Var3 = (r81) kbVarP.get((Animator) this.w.get(sparseIntArray.keyAt(i8)));
                r81Var3.f.setStartDelay(r81Var3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i = this.r - 1;
        this.r = i;
        if (i == 0) {
            v(this, ay0.d);
            for (int i2 = 0; i2 < ((vi0) this.i.b).e(); i2++) {
                View view = (View) ((vi0) this.i.b).f(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((vi0) this.j.b).e(); i3++) {
                View view2 = (View) ((vi0) this.j.b).f(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.t = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r4 = r4.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = r4.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (defpackage.b91) r4.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b91 n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            rc r0 = r4.k
            if (r0 == 0) goto L9
            b91 r4 = r0.n(r5, r6)
            return r4
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.m
            goto L10
        Le:
            java.util.ArrayList r0 = r4.n
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            b91 r3 = (defpackage.b91) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r4 = r4.n
            goto L35
        L33:
            java.util.ArrayList r4 = r4.m
        L35:
            java.lang.Object r4 = r4.get(r2)
            b91 r4 = (defpackage.b91) r4
            return r4
        L3c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t81.n(android.view.View, boolean):b91");
    }

    public final t81 o() {
        rc rcVar = this.k;
        return rcVar != null ? rcVar.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final b91 r(View view, boolean z2) {
        rc rcVar = this.k;
        if (rcVar != null) {
            return rcVar.r(view, z2);
        }
        return (b91) ((kb) (z2 ? this.i : this.j).c).get(view);
    }

    public boolean s(b91 b91Var, b91 b91Var2) {
        if (b91Var != null && b91Var2 != null) {
            String[] strArrQ = q();
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    if (u(b91Var, b91Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = b91Var.a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(b91Var, b91Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.g;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return H("");
    }

    public final void v(t81 t81Var, ay0 ay0Var) {
        t81 t81Var2 = this.u;
        if (t81Var2 != null) {
            t81Var2.v(t81Var, ay0Var);
        }
        ArrayList arrayList = this.v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.v.size();
        s81[] s81VarArr = this.o;
        if (s81VarArr == null) {
            s81VarArr = new s81[size];
        }
        this.o = null;
        s81[] s81VarArr2 = (s81[]) this.v.toArray(s81VarArr);
        for (int i = 0; i < size; i++) {
            s81 s81Var = s81VarArr2[i];
            switch (ay0Var.b) {
                case 9:
                    s81Var.e(t81Var);
                    break;
                case 10:
                    s81Var.d(t81Var);
                    break;
                case 11:
                    s81Var.f(t81Var);
                    break;
                case 12:
                    s81Var.b();
                    break;
                default:
                    s81Var.c();
                    break;
            }
            s81VarArr2[i] = null;
        }
        this.o = s81VarArr2;
    }

    public void w(View view) {
        if (this.t) {
            return;
        }
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.q);
        this.q = y;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.q = animatorArr;
        v(this, ay0.f);
        this.s = true;
    }

    public t81 x(s81 s81Var) {
        t81 t81Var;
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            if (!arrayList.remove(s81Var) && (t81Var = this.u) != null) {
                t81Var.x(s81Var);
            }
            if (this.v.size() == 0) {
                this.v = null;
            }
        }
        return this;
    }

    public void y(View view) {
        if (this.s) {
            if (!this.t) {
                ArrayList arrayList = this.p;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.q);
                this.q = y;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.q = animatorArr;
                v(this, ay0.g);
            }
            this.s = false;
        }
    }

    public void z() {
        G();
        kb kbVarP = p();
        ArrayList arrayList = this.w;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (kbVarP.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new p3(this, 1, kbVarP));
                    long j = this.d;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.c;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.e;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new m1(9, this));
                    animator.start();
                }
            }
        }
        this.w.clear();
        m();
    }

    public void E() {
    }

    public void B(xy0 xy0Var) {
    }

    public void f(b91 b91Var) {
    }
}
