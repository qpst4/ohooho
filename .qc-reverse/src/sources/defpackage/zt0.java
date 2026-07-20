package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zt0 {
    public ra a;
    public RecyclerView b;
    public final pn0 c;
    public final pn0 d;
    public qg0 e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;

    public zt0() {
        xt0 xt0Var = new xt0(this, 0);
        xt0 xt0Var2 = new xt0(this, 1);
        this.c = new pn0(xt0Var);
        this.d = new pn0(xt0Var2);
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
    }

    public static int A(View view) {
        return view.getLeft() - ((au0) view.getLayoutParams()).b.left;
    }

    public static int B(View view) {
        Rect rect = ((au0) view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int C(View view) {
        Rect rect = ((au0) view.getLayoutParams()).b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int D(View view) {
        return view.getRight() + ((au0) view.getLayoutParams()).b.right;
    }

    public static int E(View view) {
        return view.getTop() - ((au0) view.getLayoutParams()).b.top;
    }

    public static int L(View view) {
        return ((au0) view.getLayoutParams()).a.c();
    }

    public static yt0 M(Context context, AttributeSet attributeSet, int i, int i2) {
        yt0 yt0Var = new yt0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ws0.a, i, i2);
        yt0Var.a = typedArrayObtainStyledAttributes.getInt(0, 1);
        yt0Var.b = typedArrayObtainStyledAttributes.getInt(10, 1);
        yt0Var.c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        yt0Var.d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return yt0Var;
    }

    public static boolean Q(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void R(View view, int i, int i2, int i3, int i4) {
        au0 au0Var = (au0) view.getLayoutParams();
        Rect rect = au0Var.b;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) au0Var).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) au0Var).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) au0Var).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) au0Var).bottomMargin);
    }

    public static int g(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zt0.w(boolean, int, int, int, int):int");
    }

    public static int y(View view) {
        return view.getBottom() + ((au0) view.getLayoutParams()).b.bottom;
    }

    public final boolean A0(View view, int i, int i2, au0 au0Var) {
        return (this.h && Q(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) au0Var).width) && Q(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) au0Var).height)) ? false : true;
    }

    public abstract void B0(RecyclerView recyclerView, int i);

    public final void C0(qg0 qg0Var) {
        qg0 qg0Var2 = this.e;
        if (qg0Var2 != null && qg0Var != qg0Var2 && qg0Var2.e) {
            qg0Var2.j();
        }
        this.e = qg0Var;
        RecyclerView recyclerView = this.b;
        ou0 ou0Var = recyclerView.d0;
        ou0Var.h.removeCallbacks(ou0Var);
        ou0Var.d.abortAnimation();
        if (qg0Var.h) {
            Log.w("RecyclerView", "An instance of " + qg0Var.getClass().getSimpleName() + " was started more than once. Each instance of" + qg0Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        qg0Var.b = recyclerView;
        qg0Var.c = this;
        int i = qg0Var.a;
        if (i == -1) {
            zy.n("Invalid target position");
            return;
        }
        recyclerView.g0.a = i;
        qg0Var.e = true;
        qg0Var.d = true;
        qg0Var.f = recyclerView.n.q(i);
        qg0Var.b.d0.a();
        qg0Var.h = true;
    }

    public boolean D0() {
        return false;
    }

    public final int F() {
        RecyclerView recyclerView = this.b;
        qt0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public final int G() {
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = uf1.a;
        return recyclerView.getLayoutDirection();
    }

    public final int H() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int I() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int J() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int K() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int N(gu0 gu0Var, mu0 mu0Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.m == null || !e()) {
            return 1;
        }
        return this.b.m.a();
    }

    public final void O(Rect rect, View view) {
        Matrix matrix;
        Rect rect2 = ((au0) view.getLayoutParams()).b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.b.l;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean P();

    public void S(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iW = recyclerView.f.w();
            for (int i2 = 0; i2 < iW; i2++) {
                recyclerView.f.v(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void T(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iW = recyclerView.f.w();
            for (int i2 = 0; i2 < iW; i2++) {
                recyclerView.f.v(i2).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void V(RecyclerView recyclerView);

    public abstract View W(View view, int i, gu0 gu0Var, mu0 mu0Var);

    public void X(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.b;
        gu0 gu0Var = recyclerView.c;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        qt0 qt0Var = this.b.m;
        if (qt0Var != null) {
            accessibilityEvent.setItemCount(qt0Var.a());
        }
    }

    public void Y(gu0 gu0Var, mu0 mu0Var, View view, n0 n0Var) {
        n0Var.j(m0.a(false, e() ? L(view) : 0, 1, d() ? L(view) : 0, 1));
    }

    public final void Z(View view, n0 n0Var) {
        pu0 pu0VarJ = RecyclerView.J(view);
        if (pu0VarJ == null || pu0VarJ.i()) {
            return;
        }
        ra raVar = this.a;
        if (((ArrayList) raVar.e).contains(pu0VarJ.a)) {
            return;
        }
        RecyclerView recyclerView = this.b;
        Y(recyclerView.c, recyclerView.g0, view, n0Var);
    }

    public final void b(View view, int i, boolean z) {
        pu0 pu0VarJ = RecyclerView.J(view);
        if (z || pu0VarJ.i()) {
            t01 t01Var = (t01) this.b.g.c;
            ag1 ag1VarA = (ag1) t01Var.get(pu0VarJ);
            if (ag1VarA == null) {
                ag1VarA = ag1.a();
                t01Var.put(pu0VarJ, ag1VarA);
            }
            ag1VarA.a |= 1;
        } else {
            this.b.g.J(pu0VarJ);
        }
        au0 au0Var = (au0) view.getLayoutParams();
        if (pu0VarJ.q() || pu0VarJ.j()) {
            if (pu0VarJ.j()) {
                pu0VarJ.n.j(pu0VarJ);
            } else {
                pu0VarJ.j &= -33;
            }
            this.a.l(view, i, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.b;
            ra raVar = this.a;
            if (parent == recyclerView) {
                bk bkVar = (bk) raVar.d;
                int iIndexOfChild = ((pt0) raVar.c).a.indexOfChild(view);
                int iC = (iIndexOfChild == -1 || bkVar.e(iIndexOfChild)) ? -1 : iIndexOfChild - bkVar.c(iIndexOfChild);
                if (i == -1) {
                    i = this.a.w();
                }
                if (iC == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.z());
                }
                if (iC != i) {
                    zt0 zt0Var = this.b.n;
                    View viewU = zt0Var.u(iC);
                    if (viewU == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iC + zt0Var.b.toString());
                    }
                    zt0Var.u(iC);
                    zt0Var.a.p(iC);
                    au0 au0Var2 = (au0) viewU.getLayoutParams();
                    pu0 pu0VarJ2 = RecyclerView.J(viewU);
                    boolean zI = pu0VarJ2.i();
                    RecyclerView recyclerView2 = zt0Var.b;
                    if (zI) {
                        t01 t01Var2 = (t01) recyclerView2.g.c;
                        ag1 ag1VarA2 = (ag1) t01Var2.get(pu0VarJ2);
                        if (ag1VarA2 == null) {
                            ag1VarA2 = ag1.a();
                            t01Var2.put(pu0VarJ2, ag1VarA2);
                        }
                        ag1VarA2.a = 1 | ag1VarA2.a;
                    } else {
                        recyclerView2.g.J(pu0VarJ2);
                    }
                    zt0Var.a.l(viewU, i, au0Var2, pu0VarJ2.i());
                }
            } else {
                raVar.k(view, i, false);
                au0Var.c = true;
                qg0 qg0Var = this.e;
                if (qg0Var != null && qg0Var.e) {
                    qg0Var.b.getClass();
                    pu0 pu0VarJ3 = RecyclerView.J(view);
                    if ((pu0VarJ3 != null ? pu0VarJ3.c() : -1) == qg0Var.a) {
                        qg0Var.f = view;
                    }
                }
            }
        }
        if (au0Var.d) {
            pu0VarJ.a.invalidate();
            au0Var.d = false;
        }
    }

    public void c(String str) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.i(str);
        }
    }

    public abstract boolean d();

    public abstract boolean e();

    public boolean f(au0 au0Var) {
        return au0Var != null;
    }

    public abstract void f0(gu0 gu0Var, mu0 mu0Var);

    public abstract void g0(mu0 mu0Var);

    public Parcelable i0() {
        return null;
    }

    public abstract int j(mu0 mu0Var);

    public abstract int k(mu0 mu0Var);

    public final void k0(gu0 gu0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.J(u(iV)).p()) {
                View viewU = u(iV);
                n0(iV);
                gu0Var.f(viewU);
            }
        }
    }

    public abstract int l(mu0 mu0Var);

    public final void l0(gu0 gu0Var) {
        ArrayList arrayList;
        int size = gu0Var.a.size();
        int i = size - 1;
        while (true) {
            arrayList = gu0Var.a;
            if (i < 0) {
                break;
            }
            View view = ((pu0) arrayList.get(i)).a;
            pu0 pu0VarJ = RecyclerView.J(view);
            if (!pu0VarJ.p()) {
                pu0VarJ.o(false);
                if (pu0VarJ.k()) {
                    this.b.removeDetachedView(view, false);
                }
                vt0 vt0Var = this.b.L;
                if (vt0Var != null) {
                    vt0Var.e(pu0VarJ);
                }
                pu0VarJ.o(true);
                pu0 pu0VarJ2 = RecyclerView.J(view);
                pu0VarJ2.n = null;
                pu0VarJ2.o = false;
                pu0VarJ2.j &= -33;
                gu0Var.g(pu0VarJ2);
            }
            i--;
        }
        arrayList.clear();
        ArrayList arrayList2 = gu0Var.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.b.invalidate();
        }
    }

    public abstract int m(mu0 mu0Var);

    public final void m0(View view, gu0 gu0Var) {
        ra raVar = this.a;
        pt0 pt0Var = (pt0) raVar.c;
        int iIndexOfChild = pt0Var.a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            if (((bk) raVar.d).g(iIndexOfChild)) {
                raVar.U(view);
            }
            pt0Var.g(iIndexOfChild);
        }
        gu0Var.f(view);
    }

    public abstract int n(mu0 mu0Var);

    public final void n0(int i) {
        if (u(i) != null) {
            ra raVar = this.a;
            int iD = raVar.D(i);
            pt0 pt0Var = (pt0) raVar.c;
            View childAt = pt0Var.a.getChildAt(iD);
            if (childAt == null) {
                return;
            }
            if (((bk) raVar.d).g(iD)) {
                raVar.U(childAt);
            }
            pt0Var.g(iD);
        }
    }

    public abstract int o(mu0 mu0Var);

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.I()
            int r1 = r8.K()
            int r2 = r8.n
            int r3 = r8.J()
            int r2 = r2 - r3
            int r3 = r8.o
            int r4 = r8.H()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.G()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.I()
            int r2 = r8.K()
            int r3 = r8.n
            int r4 = r8.J()
            int r3 = r3 - r4
            int r4 = r8.o
            int r5 = r8.H()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.b
            android.graphics.Rect r5 = r5.j
            r8.z(r5, r13)
            int r8 = r5.left
            int r8 = r8 - r11
            if (r8 >= r3) goto Lb3
            int r8 = r5.right
            int r8 = r8 - r11
            if (r8 <= r1) goto Lb3
            int r8 = r5.top
            int r8 = r8 - r10
            if (r8 >= r4) goto Lb3
            int r8 = r5.bottom
            int r8 = r8 - r10
            if (r8 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.e0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zt0.o0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void p(gu0 gu0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            pu0 pu0VarJ = RecyclerView.J(viewU);
            if (!pu0VarJ.p()) {
                if (!pu0VarJ.g() || pu0VarJ.i() || this.b.m.b) {
                    u(iV);
                    this.a.p(iV);
                    gu0Var.h(viewU);
                    this.b.g.J(pu0VarJ);
                } else {
                    n0(iV);
                    gu0Var.g(pu0VarJ);
                }
            }
        }
    }

    public final void p0() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            pu0 pu0VarJ = RecyclerView.J(viewU);
            if (pu0VarJ != null && pu0VarJ.c() == i && !pu0VarJ.p() && (this.b.g0.g || !pu0VarJ.i())) {
                return viewU;
            }
        }
        return null;
    }

    public abstract int q0(int i, gu0 gu0Var, mu0 mu0Var);

    public abstract au0 r();

    public abstract void r0(int i);

    public au0 s(Context context, AttributeSet attributeSet) {
        return new au0(context, attributeSet);
    }

    public abstract int s0(int i, gu0 gu0Var, mu0 mu0Var);

    public au0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof au0 ? new au0((au0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new au0((ViewGroup.MarginLayoutParams) layoutParams) : new au0(layoutParams);
    }

    public final void t0(RecyclerView recyclerView) {
        u0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final View u(int i) {
        ra raVar = this.a;
        if (raVar != null) {
            return raVar.v(i);
        }
        return null;
    }

    public final void u0(int i, int i2) {
        this.n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.l = mode;
        if (mode == 0) {
            int[] iArr = RecyclerView.w0;
        }
        this.o = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.m = mode2;
        if (mode2 == 0) {
            int[] iArr2 = RecyclerView.w0;
        }
    }

    public final int v() {
        ra raVar = this.a;
        if (raVar != null) {
            return raVar.w();
        }
        return 0;
    }

    public void v0(Rect rect, int i, int i2) {
        int iJ = J() + I() + rect.width();
        int iH = H() + K() + rect.height();
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = uf1.a;
        this.b.setMeasuredDimension(g(i, iJ, recyclerView.getMinimumWidth()), g(i2, iH, this.b.getMinimumHeight()));
    }

    public final void w0(int i, int i2) {
        int iV = v();
        if (iV == 0) {
            this.b.n(i, i2);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < iV; i7++) {
            View viewU = u(i7);
            Rect rect = this.b.j;
            z(rect, viewU);
            int i8 = rect.left;
            if (i8 < i6) {
                i6 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i4) {
                i4 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i5) {
                i5 = i11;
            }
        }
        this.b.j.set(i6, i4, i3, i5);
        v0(this.b.j, i, i2);
    }

    public int x(gu0 gu0Var, mu0 mu0Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.m == null || !d()) {
            return 1;
        }
        return this.b.m.a();
    }

    public final void x0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.b = null;
            this.a = null;
            this.n = 0;
            this.o = 0;
        } else {
            this.b = recyclerView;
            this.a = recyclerView.f;
            this.n = recyclerView.getWidth();
            this.o = recyclerView.getHeight();
        }
        this.l = 1073741824;
        this.m = 1073741824;
    }

    public final boolean y0(View view, int i, int i2, au0 au0Var) {
        return (!view.isLayoutRequested() && this.h && Q(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) au0Var).width) && Q(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) au0Var).height)) ? false : true;
    }

    public void z(Rect rect, View view) {
        RecyclerView.K(rect, view);
    }

    public boolean z0() {
        return false;
    }

    public void b0() {
    }

    public void U(RecyclerView recyclerView) {
    }

    public void h0(Parcelable parcelable) {
    }

    public void j0(int i) {
    }

    public void a0(int i, int i2) {
    }

    public void c0(int i, int i2) {
    }

    public void d0(int i, int i2) {
    }

    public void e0(int i, int i2) {
    }

    public void i(int i, l50 l50Var) {
    }

    public void h(int i, int i2, mu0 mu0Var, l50 l50Var) {
    }
}
