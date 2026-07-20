package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import defpackage.ag1;
import defpackage.au0;
import defpackage.bk;
import defpackage.bu0;
import defpackage.cu0;
import defpackage.du0;
import defpackage.eu0;
import defpackage.fu0;
import defpackage.gu0;
import defpackage.h71;
import defpackage.hu0;
import defpackage.iu0;
import defpackage.ju0;
import defpackage.k10;
import defpackage.l4;
import defpackage.l50;
import defpackage.lf1;
import defpackage.m4;
import defpackage.mu0;
import defpackage.n50;
import defpackage.ns;
import defpackage.nu0;
import defpackage.of1;
import defpackage.om0;
import defpackage.ot0;
import defpackage.ou0;
import defpackage.pa0;
import defpackage.pn0;
import defpackage.pt0;
import defpackage.pu0;
import defpackage.qc0;
import defpackage.qg0;
import defpackage.qt0;
import defpackage.ra;
import defpackage.rm0;
import defpackage.ru0;
import defpackage.s1;
import defpackage.sc0;
import defpackage.t01;
import defpackage.t3;
import defpackage.tt0;
import defpackage.uf1;
import defpackage.ut0;
import defpackage.vf1;
import defpackage.vi0;
import defpackage.vt0;
import defpackage.ws0;
import defpackage.wt0;
import defpackage.zt0;
import defpackage.zy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static final int[] w0 = {R.attr.nestedScrollingEnabled};
    public static final Class[] x0;
    public static final qc0 y0;
    public final AccessibilityManager A;
    public ArrayList B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public ut0 G;
    public EdgeEffect H;
    public EdgeEffect I;
    public EdgeEffect J;
    public EdgeEffect K;
    public vt0 L;
    public int M;
    public int N;
    public VelocityTracker O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public bu0 U;
    public final int V;
    public final int W;
    public final float a0;
    public final iu0 b;
    public final float b0;
    public final gu0 c;
    public boolean c0;
    public ju0 d;
    public final ou0 d0;
    public final m4 e;
    public n50 e0;
    public final ra f;
    public final l50 f0;
    public final pn0 g;
    public final mu0 g0;
    public boolean h;
    public du0 h0;
    public final ot0 i;
    public ArrayList i0;
    public final Rect j;
    public boolean j0;
    public final Rect k;
    public boolean k0;
    public final RectF l;
    public final pt0 l0;
    public qt0 m;
    public boolean m0;
    public zt0 n;
    public ru0 n0;
    public final ArrayList o;
    public final int[] o0;
    public final ArrayList p;
    public om0 p0;
    public cu0 q;
    public final int[] q0;
    public boolean r;
    public final int[] r0;
    public boolean s;
    public final int[] s0;
    public boolean t;
    public final ArrayList t0;
    public int u;
    public final ot0 u0;
    public boolean v;
    public final pt0 v0;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

    static {
        Class cls = Integer.TYPE;
        x0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        y0 = new qc0(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Class[], java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v5 */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float fA;
        int i2;
        char c;
        TypedArray typedArray;
        char c2;
        char c3;
        ?? r11;
        int i3;
        Object[] objArr;
        Constructor constructor;
        super(context, attributeSet, i);
        this.b = new iu0(this);
        this.c = new gu0(this);
        this.g = new pn0(13);
        this.i = new ot0(this, 0);
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.u = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = new ut0();
        this.L = new ns();
        this.M = 0;
        this.N = -1;
        this.a0 = Float.MIN_VALUE;
        this.b0 = Float.MIN_VALUE;
        this.c0 = true;
        this.d0 = new ou0(this);
        this.f0 = new l50();
        mu0 mu0Var = new mu0();
        mu0Var.a = -1;
        mu0Var.b = 0;
        mu0Var.c = 0;
        mu0Var.d = 1;
        mu0Var.e = 0;
        mu0Var.f = false;
        mu0Var.g = false;
        mu0Var.h = false;
        mu0Var.i = false;
        mu0Var.j = false;
        mu0Var.k = false;
        this.g0 = mu0Var;
        this.j0 = false;
        this.k0 = false;
        pt0 pt0Var = new pt0(this);
        this.l0 = pt0Var;
        this.m0 = false;
        this.o0 = new int[2];
        this.q0 = new int[2];
        this.r0 = new int[2];
        this.s0 = new int[2];
        this.t0 = new ArrayList();
        this.u0 = new ot0(this, 1);
        this.v0 = new pt0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.T = viewConfiguration.getScaledTouchSlop();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Method method = vf1.a;
            fA = pa0.c(viewConfiguration);
        } else {
            fA = vf1.a(viewConfiguration, context);
        }
        this.a0 = fA;
        this.b0 = i4 >= 26 ? pa0.d(viewConfiguration) : vf1.a(viewConfiguration, context);
        this.V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.L.a = pt0Var;
        this.e = new m4(new pt0(this));
        this.f = new ra(new pt0(this));
        WeakHashMap weakHashMap = uf1.a;
        if ((i4 >= 26 ? of1.a(this) : 0) == 0 && i4 >= 26) {
            of1.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ru0(this));
        int[] iArr = ws0.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        if (i4 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.h = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                zy.n("Trying to set fast scroller without both required drawables.".concat(z()));
                throw null;
            }
            Resources resources = getContext().getResources();
            c3 = 2;
            i2 = i;
            typedArray = typedArrayObtainStyledAttributes;
            c2 = 1;
            i3 = 4;
            r11 = 0;
            c = 3;
            new k10(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.quickcursor.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.quickcursor.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.quickcursor.R.dimen.fastscroll_margin));
        } else {
            i2 = i;
            c = 3;
            typedArray = typedArrayObtainStyledAttributes;
            c2 = 1;
            c3 = 2;
            r11 = 0;
            i3 = 4;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(zt0.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(x0);
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = context;
                        objArr2[c2] = attributeSet;
                        objArr2[c3] = Integer.valueOf(i2);
                        objArr2[c] = 0;
                        objArr = objArr2;
                        constructor = constructor2;
                    } catch (NoSuchMethodException e) {
                        try {
                            Constructor constructor3 = clsAsSubclass.getConstructor(r11);
                            objArr = r11;
                            constructor = constructor3;
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(c2);
                    setLayoutManager((zt0) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    zy.d(attributeSet.getPositionDescription(), ": Class is not a LayoutManager ", str, e3);
                    throw r11;
                } catch (ClassNotFoundException e4) {
                    zy.d(attributeSet.getPositionDescription(), ": Unable to find LayoutManager ", str, e4);
                    throw r11;
                } catch (IllegalAccessException e5) {
                    zy.d(attributeSet.getPositionDescription(), ": Cannot access non-public constructor ", str, e5);
                    throw r11;
                } catch (InstantiationException e6) {
                    zy.d(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e6);
                    throw r11;
                } catch (InvocationTargetException e7) {
                    zy.d(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e7);
                    throw r11;
                }
            }
        }
        int[] iArr2 = w0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        }
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewE = E(viewGroup.getChildAt(i));
            if (recyclerViewE != null) {
                return recyclerViewE;
            }
        }
        return null;
    }

    public static pu0 J(View view) {
        if (view == null) {
            return null;
        }
        return ((au0) view.getLayoutParams()).a;
    }

    public static void K(Rect rect, View view) {
        au0 au0Var = (au0) view.getLayoutParams();
        Rect rect2 = au0Var.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) au0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) au0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) au0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) au0Var).bottomMargin);
    }

    private om0 getScrollingChildHelper() {
        if (this.p0 == null) {
            this.p0 = new om0(this);
        }
        return this.p0;
    }

    public static void j(pu0 pu0Var) {
        WeakReference weakReference = pu0Var.b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == pu0Var.a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            pu0Var.b = null;
        }
    }

    public final void A(mu0 mu0Var) {
        if (getScrollState() != 2) {
            mu0Var.getClass();
            return;
        }
        OverScroller overScroller = this.d0.d;
        overScroller.getFinalX();
        overScroller.getCurrX();
        mu0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View B(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cu0 cu0Var = (cu0) arrayList.get(i);
            if (cu0Var.b(motionEvent) && action != 3) {
                this.q = cu0Var;
                return true;
            }
        }
        return false;
    }

    public final void D(int[] iArr) {
        ra raVar = this.f;
        int iW = raVar.w();
        if (iW == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iW; i3++) {
            pu0 pu0VarJ = J(raVar.v(i3));
            if (!pu0VarJ.p()) {
                int iC = pu0VarJ.c();
                if (iC < i) {
                    i = iC;
                }
                if (iC > i2) {
                    i2 = iC;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final pu0 F(int i) {
        pu0 pu0Var = null;
        if (this.C) {
            return null;
        }
        ra raVar = this.f;
        int iF = raVar.F();
        for (int i2 = 0; i2 < iF; i2++) {
            pu0 pu0VarJ = J(raVar.E(i2));
            if (pu0VarJ != null && !pu0VarJ.i() && G(pu0VarJ) == i) {
                if (!((ArrayList) raVar.e).contains(pu0VarJ.a)) {
                    return pu0VarJ;
                }
                pu0Var = pu0VarJ;
            }
        }
        return pu0Var;
    }

    public final int G(pu0 pu0Var) {
        if ((pu0Var.j & 524) == 0 && pu0Var.f()) {
            int i = pu0Var.c;
            ArrayList arrayList = (ArrayList) this.e.c;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                l4 l4Var = (l4) arrayList.get(i2);
                int i3 = l4Var.a;
                if (i3 != 1) {
                    if (i3 == 2) {
                        int i4 = l4Var.b;
                        if (i4 <= i) {
                            int i5 = l4Var.d;
                            if (i4 + i5 <= i) {
                                i -= i5;
                            }
                        } else {
                            continue;
                        }
                    } else if (i3 == 8) {
                        int i6 = l4Var.b;
                        if (i6 == i) {
                            i = l4Var.d;
                        } else {
                            if (i6 < i) {
                                i--;
                            }
                            if (l4Var.d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (l4Var.b <= i) {
                    i += l4Var.d;
                }
            }
            return i;
        }
        return -1;
    }

    public final long H(pu0 pu0Var) {
        return this.m.b ? pu0Var.e : pu0Var.c;
    }

    public final pu0 I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return J(view);
        }
        zy.i("View ", view, " is not a direct child of ", this);
        return null;
    }

    public final Rect L(View view) {
        au0 au0Var = (au0) view.getLayoutParams();
        boolean z = au0Var.c;
        Rect rect = au0Var.b;
        if (!z || (this.g0.g && (au0Var.a.l() || au0Var.a.g()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.j;
            rect2.set(0, 0, 0, 0);
            ((wt0) arrayList.get(i)).d(rect2, view, this);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        au0Var.c = false;
        return rect;
    }

    public final boolean M() {
        return !this.t || this.C || this.e.j();
    }

    public final boolean N() {
        return this.E > 0;
    }

    public final void O(int i) {
        if (this.n == null) {
            return;
        }
        setScrollState(2);
        this.n.r0(i);
        awakenScrollBars();
    }

    public final void P() {
        ra raVar = this.f;
        int iF = raVar.F();
        for (int i = 0; i < iF; i++) {
            ((au0) raVar.E(i).getLayoutParams()).c = true;
        }
        ArrayList arrayList = this.c.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            au0 au0Var = (au0) ((pu0) arrayList.get(i2)).a.getLayoutParams();
            if (au0Var != null) {
                au0Var.c = true;
            }
        }
    }

    public final void Q(int i, int i2, boolean z) {
        int i3 = i + i2;
        ra raVar = this.f;
        int iF = raVar.F();
        for (int i4 = 0; i4 < iF; i4++) {
            pu0 pu0VarJ = J(raVar.E(i4));
            if (pu0VarJ != null && !pu0VarJ.p()) {
                int i5 = pu0VarJ.c;
                mu0 mu0Var = this.g0;
                if (i5 >= i3) {
                    pu0VarJ.m(-i2, z);
                    mu0Var.f = true;
                } else if (i5 >= i) {
                    pu0VarJ.a(8);
                    pu0VarJ.m(-i2, z);
                    pu0VarJ.c = i - 1;
                    mu0Var.f = true;
                }
            }
        }
        gu0 gu0Var = this.c;
        ArrayList arrayList = gu0Var.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            pu0 pu0Var = (pu0) arrayList.get(size);
            if (pu0Var != null) {
                int i6 = pu0Var.c;
                if (i6 >= i3) {
                    pu0Var.m(-i2, z);
                } else if (i6 >= i) {
                    pu0Var.a(8);
                    gu0Var.e(size);
                }
            }
        }
        requestLayout();
    }

    public final void R() {
        this.E++;
    }

    public final void S(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.E - 1;
        this.E = i2;
        if (i2 < 1) {
            this.E = 0;
            if (z) {
                int i3 = this.y;
                this.y = 0;
                if (i3 != 0 && (accessibilityManager = this.A) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.t0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    pu0 pu0Var = (pu0) arrayList.get(size);
                    if (pu0Var.a.getParent() == this && !pu0Var.p() && (i = pu0Var.q) != -1) {
                        View view = pu0Var.a;
                        WeakHashMap weakHashMap = uf1.a;
                        view.setImportantForAccessibility(i);
                        pu0Var.q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void T(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.N) {
            int i = actionIndex == 0 ? 1 : 0;
            this.N = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.R = x;
            this.P = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.S = y;
            this.Q = y;
        }
    }

    public final void U() {
        if (this.m0 || !this.r) {
            return;
        }
        WeakHashMap weakHashMap = uf1.a;
        postOnAnimation(this.u0);
        this.m0 = true;
    }

    public final void V() {
        boolean z;
        boolean z2 = this.C;
        m4 m4Var = this.e;
        boolean z3 = false;
        if (z2) {
            m4Var.q((ArrayList) m4Var.c);
            m4Var.q((ArrayList) m4Var.d);
            m4Var.a = 0;
            if (this.D) {
                this.n.b0();
            }
        }
        if (this.L != null && this.n.D0()) {
            m4Var.p();
        } else {
            m4Var.d();
        }
        boolean z4 = this.j0 || this.k0;
        boolean z5 = this.t && this.L != null && ((z = this.C) || z4 || this.n.f) && (!z || this.m.b);
        mu0 mu0Var = this.g0;
        mu0Var.j = z5;
        if (z5 && z4 && !this.C && this.L != null && this.n.D0()) {
            z3 = true;
        }
        mu0Var.k = z3;
    }

    public final void W(boolean z) {
        this.D = z | this.D;
        this.C = true;
        ra raVar = this.f;
        int iF = raVar.F();
        for (int i = 0; i < iF; i++) {
            pu0 pu0VarJ = J(raVar.E(i));
            if (pu0VarJ != null && !pu0VarJ.p()) {
                pu0VarJ.a(6);
            }
        }
        P();
        gu0 gu0Var = this.c;
        ArrayList arrayList = gu0Var.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            pu0 pu0Var = (pu0) arrayList.get(i2);
            if (pu0Var != null) {
                pu0Var.a(6);
                pu0Var.a(1024);
            }
        }
        qt0 qt0Var = gu0Var.h.m;
        if (qt0Var == null || !qt0Var.b) {
            gu0Var.d();
        }
    }

    public final void X(pu0 pu0Var, rm0 rm0Var) {
        pu0Var.j &= -8193;
        boolean z = this.g0.h;
        pn0 pn0Var = this.g;
        if (z && pu0Var.l() && !pu0Var.i() && !pu0Var.p()) {
            ((vi0) pn0Var.d).d(H(pu0Var), pu0Var);
        }
        t01 t01Var = (t01) pn0Var.c;
        ag1 ag1VarA = (ag1) t01Var.get(pu0Var);
        if (ag1VarA == null) {
            ag1VarA = ag1.a();
            t01Var.put(pu0Var, ag1VarA);
        }
        ag1VarA.b = rm0Var;
        ag1VarA.a |= 4;
    }

    public final void Y(wt0 wt0Var) {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            zt0Var.c("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.o;
        arrayList.remove(wt0Var);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        P();
        requestLayout();
    }

    public final void Z(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.j;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof au0) {
            au0 au0Var = (au0) layoutParams;
            if (!au0Var.c) {
                Rect rect2 = au0Var.b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.n.o0(this, view, this.j, !this.t, view2 == null);
    }

    public final void a0() {
        VelocityTracker velocityTracker = this.O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        h0(0);
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = uf1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            zt0Var.getClass();
        }
        super.addFocusables(arrayList, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b0(int r18, int r19, android.view.MotionEvent r20) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.b0(int, int, android.view.MotionEvent):boolean");
    }

    public final void c0(int i, int i2, int[] iArr) {
        pu0 pu0Var;
        f0();
        R();
        int i3 = h71.a;
        Trace.beginSection("RV Scroll");
        mu0 mu0Var = this.g0;
        A(mu0Var);
        gu0 gu0Var = this.c;
        int iQ0 = i != 0 ? this.n.q0(i, gu0Var, mu0Var) : 0;
        int iS0 = i2 != 0 ? this.n.s0(i2, gu0Var, mu0Var) : 0;
        Trace.endSection();
        ra raVar = this.f;
        int iW = raVar.w();
        for (int i4 = 0; i4 < iW; i4++) {
            View viewV = raVar.v(i4);
            pu0 pu0VarI = I(viewV);
            if (pu0VarI != null && (pu0Var = pu0VarI.i) != null) {
                View view = pu0Var.a;
                int left = viewV.getLeft();
                int top = viewV.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        S(true);
        g0(false);
        if (iArr != null) {
            iArr[0] = iQ0;
            iArr[1] = iS0;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof au0) && this.n.f((au0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.d()) {
            return this.n.j(this.g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.d()) {
            return this.n.k(this.g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.d()) {
            return this.n.l(this.g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.e()) {
            return this.n.m(this.g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.e()) {
            return this.n.n(this.g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        zt0 zt0Var = this.n;
        if (zt0Var != null && zt0Var.e()) {
            return this.n.o(this.g0);
        }
        return 0;
    }

    public final void d0(int i) {
        qg0 qg0Var;
        if (this.w) {
            return;
        }
        setScrollState(0);
        ou0 ou0Var = this.d0;
        ou0Var.h.removeCallbacks(ou0Var);
        ou0Var.d.abortAnimation();
        zt0 zt0Var = this.n;
        if (zt0Var != null && (qg0Var = zt0Var.e) != null) {
            qg0Var.j();
        }
        zt0 zt0Var2 = this.n;
        if (zt0Var2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            zt0Var2.r0(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i2, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().d(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((wt0) arrayList.get(i)).f(canvas, this);
        }
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.H;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.I;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.J;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.L == null || arrayList.size() <= 0 || !this.L.g()) ? z : true) {
            WeakHashMap weakHashMap = uf1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public final void e0(int i, int i2, boolean z) {
        zt0 zt0Var = this.n;
        if (zt0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.w) {
            return;
        }
        if (!zt0Var.d()) {
            i = 0;
        }
        if (!this.n.e()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (z) {
            int i3 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i3 |= 2;
            }
            getScrollingChildHelper().g(i3, 1);
        }
        this.d0.b(i, i2, Integer.MIN_VALUE, null);
    }

    public final void f(pu0 pu0Var) {
        View view = pu0Var.a;
        boolean z = view.getParent() == this;
        this.c.j(I(view));
        boolean zK = pu0Var.k();
        ra raVar = this.f;
        if (zK) {
            raVar.l(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            raVar.k(view, -1, true);
            return;
        }
        int iIndexOfChild = ((pt0) raVar.c).a.indexOfChild(view);
        if (iIndexOfChild < 0) {
            zy.h("view is not a child, cannot hide ", view);
        } else {
            ((bk) raVar.d).i(iIndexOfChild);
            raVar.H(view);
        }
    }

    public final void f0() {
        int i = this.u + 1;
        this.u = i;
        if (i != 1 || this.w) {
            return;
        }
        this.v = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0162, code lost:
    
        if (r16 > 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x016f, code lost:
    
        if (r5 > 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0172, code lost:
    
        if (r16 < 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0175, code lost:
    
        if (r5 < 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x017d, code lost:
    
        if ((r5 * r6) < 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0185, code lost:
    
        if ((r5 * r6) > 0) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010e  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r19, int r20) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(wt0 wt0Var) {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            zt0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(wt0Var);
        P();
        requestLayout();
    }

    public final void g0(boolean z) {
        if (this.u < 1) {
            this.u = 1;
        }
        if (!z && !this.w) {
            this.v = false;
        }
        if (this.u == 1) {
            if (z && this.v && !this.w && this.n != null && this.m != null) {
                p();
            }
            if (!this.w) {
                this.v = false;
            }
        }
        this.u--;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            return zt0Var.r();
        }
        s1.f("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            return zt0Var.s(getContext(), attributeSet);
        }
        s1.f("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public qt0 getAdapter() {
        return this.m;
    }

    @Override // android.view.View
    public int getBaseline() {
        zt0 zt0Var = this.n;
        if (zt0Var == null) {
            return super.getBaseline();
        }
        zt0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.h;
    }

    public ru0 getCompatAccessibilityDelegate() {
        return this.n0;
    }

    public ut0 getEdgeEffectFactory() {
        return this.G;
    }

    public vt0 getItemAnimator() {
        return this.L;
    }

    public int getItemDecorationCount() {
        return this.o.size();
    }

    public zt0 getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.W;
    }

    public int getMinFlingVelocity() {
        return this.V;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public bu0 getOnFlingListener() {
        return this.U;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.c0;
    }

    public fu0 getRecycledViewPool() {
        return this.c.c();
    }

    public int getScrollState() {
        return this.M;
    }

    public final void h(du0 du0Var) {
        if (this.i0 == null) {
            this.i0 = new ArrayList();
        }
        this.i0.add(du0Var);
    }

    public final void h0(int i) {
        getScrollingChildHelper().h(i);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(String str) {
        if (!N()) {
            if (this.F > 0) {
                Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(z()));
            }
        } else if (str == null) {
            s1.f("Cannot call this method while RecyclerView is computing a layout or scrolling".concat(z()));
        } else {
            s1.f(str);
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.w;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public final void k() {
        ra raVar = this.f;
        int iF = raVar.F();
        for (int i = 0; i < iF; i++) {
            pu0 pu0VarJ = J(raVar.E(i));
            if (!pu0VarJ.p()) {
                pu0VarJ.d = -1;
                pu0VarJ.g = -1;
            }
        }
        gu0 gu0Var = this.c;
        ArrayList arrayList = gu0Var.a;
        ArrayList arrayList2 = gu0Var.c;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            pu0 pu0Var = (pu0) arrayList2.get(i2);
            pu0Var.d = -1;
            pu0Var.g = -1;
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            pu0 pu0Var2 = (pu0) arrayList.get(i3);
            pu0Var2.d = -1;
            pu0Var2.g = -1;
        }
        ArrayList arrayList3 = gu0Var.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                pu0 pu0Var3 = (pu0) gu0Var.b.get(i4);
                pu0Var3.d = -1;
                pu0Var3.g = -1;
            }
        }
    }

    public final void l(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.H;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.H.onRelease();
            zIsFinished = this.H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.J.onRelease();
            zIsFinished |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.I.onRelease();
            zIsFinished |= this.I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.K.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = uf1.a;
            postInvalidateOnAnimation();
        }
    }

    public final void m() {
        if (!this.t || this.C) {
            int i = h71.a;
            Trace.beginSection("RV FullInvalidate");
            p();
            Trace.endSection();
            return;
        }
        m4 m4Var = this.e;
        if (m4Var.j()) {
            int i2 = m4Var.a;
            if ((i2 & 4) == 0 || (i2 & 11) != 0) {
                if (m4Var.j()) {
                    int i3 = h71.a;
                    Trace.beginSection("RV FullInvalidate");
                    p();
                    Trace.endSection();
                    return;
                }
                return;
            }
            int i4 = h71.a;
            Trace.beginSection("RV PartialInvalidate");
            f0();
            R();
            m4Var.p();
            if (!this.v) {
                ra raVar = this.f;
                int iW = raVar.w();
                int i5 = 0;
                while (true) {
                    if (i5 < iW) {
                        pu0 pu0VarJ = J(raVar.v(i5));
                        if (pu0VarJ != null && !pu0VarJ.p() && pu0VarJ.l()) {
                            p();
                            break;
                        }
                        i5++;
                    } else {
                        m4Var.c();
                        break;
                    }
                }
            }
            g0(true);
            S(true);
            Trace.endSection();
        }
    }

    public final void n(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = uf1.a;
        setMeasuredDimension(zt0.g(i, paddingRight, getMinimumWidth()), zt0.g(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final void o(View view) {
        J(view);
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                sc0 sc0Var = (sc0) this.B.get(size);
                if (view == sc0Var.w) {
                    sc0Var.w = null;
                }
                pu0 pu0VarI = sc0Var.r.I(view);
                if (pu0VarI != null) {
                    pu0 pu0Var = sc0Var.c;
                    if (pu0Var == null || pu0VarI != pu0Var) {
                        sc0Var.j(pu0VarI, false);
                        if (sc0Var.a.remove(pu0VarI.a)) {
                            sc0Var.m.getClass();
                            t3.a(pu0VarI);
                        }
                    } else {
                        sc0Var.o(null, 0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.E = r0
            r1 = 1
            r5.r = r1
            boolean r2 = r5.t
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.t = r2
            zt0 r2 = r5.n
            if (r2 == 0) goto L21
            r2.g = r1
            r2.U(r5)
        L21:
            r5.m0 = r0
            java.lang.ThreadLocal r0 = defpackage.n50.f
            java.lang.Object r1 = r0.get()
            n50 r1 = (defpackage.n50) r1
            r5.e0 = r1
            if (r1 != 0) goto L6b
            n50 r1 = new n50
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.b = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.e = r2
            r5.e0 = r1
            java.util.WeakHashMap r1 = defpackage.uf1.a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L5d
            if (r1 == 0) goto L5d
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L5d
            goto L5f
        L5d:
            r1 = 1114636288(0x42700000, float:60.0)
        L5f:
            n50 r2 = r5.e0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.d = r3
            r0.set(r2)
        L6b:
            n50 r0 = r5.e0
            java.util.ArrayList r0 = r0.b
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        qg0 qg0Var;
        super.onDetachedFromWindow();
        vt0 vt0Var = this.L;
        if (vt0Var != null) {
            vt0Var.f();
        }
        setScrollState(0);
        ou0 ou0Var = this.d0;
        ou0Var.h.removeCallbacks(ou0Var);
        ou0Var.d.abortAnimation();
        zt0 zt0Var = this.n;
        if (zt0Var != null && (qg0Var = zt0Var.e) != null) {
            qg0Var.j();
        }
        this.r = false;
        zt0 zt0Var2 = this.n;
        if (zt0Var2 != null) {
            zt0Var2.g = false;
            zt0Var2.V(this);
        }
        this.t0.clear();
        removeCallbacks(this.u0);
        this.g.getClass();
        while (ag1.d.a() != null) {
        }
        n50 n50Var = this.e0;
        if (n50Var != null) {
            n50Var.b.remove(this);
            this.e0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((wt0) arrayList.get(i)).e(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            zt0 r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L7
            goto L79
        L7:
            boolean r0 = r5.w
            if (r0 == 0) goto Ld
            goto L79
        Ld:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L79
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L40
            zt0 r0 = r5.n
            boolean r0 = r0.e()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = r2
        L2f:
            zt0 r3 = r5.n
            boolean r3 = r3.d()
            if (r3 == 0) goto L3e
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L66
        L3e:
            r3 = r2
            goto L66
        L40:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L64
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            zt0 r3 = r5.n
            boolean r3 = r3.e()
            if (r3 == 0) goto L59
            float r0 = -r0
            goto L3e
        L59:
            zt0 r3 = r5.n
            boolean r3 = r3.d()
            if (r3 == 0) goto L64
            r3 = r0
            r0 = r2
            goto L66
        L64:
            r0 = r2
            r3 = r0
        L66:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6e
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L79
        L6e:
            float r2 = r5.a0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.b0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.b0(r2, r0, r6)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.w) {
            this.q = null;
            if (C(motionEvent)) {
                a0();
                setScrollState(0);
                return true;
            }
            zt0 zt0Var = this.n;
            if (zt0Var != null) {
                boolean zD = zt0Var.d();
                boolean zE = this.n.e();
                if (this.O == null) {
                    this.O = VelocityTracker.obtain();
                }
                this.O.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.x) {
                        this.x = false;
                    }
                    this.N = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.R = x;
                    this.P = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.S = y;
                    this.Q = y;
                    if (this.M == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        h0(1);
                    }
                    int[] iArr = this.r0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i = zD;
                    if (zE) {
                        i = (zD ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i, 0);
                } else if (actionMasked == 1) {
                    this.O.clear();
                    h0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.N);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.N + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.M != 1) {
                        int i2 = x2 - this.P;
                        int i3 = y2 - this.Q;
                        if (!zD || Math.abs(i2) <= this.T) {
                            z = false;
                        } else {
                            this.R = x2;
                            z = true;
                        }
                        if (zE && Math.abs(i3) > this.T) {
                            this.S = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    a0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.N = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.R = x3;
                    this.P = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.S = y3;
                    this.Q = y3;
                } else if (actionMasked == 6) {
                    T(motionEvent);
                }
                if (this.M == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = h71.a;
        Trace.beginSection("RV OnLayout");
        p();
        Trace.endSection();
        this.t = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        zt0 zt0Var = this.n;
        if (zt0Var == null) {
            n(i, i2);
            return;
        }
        boolean zP = zt0Var.P();
        mu0 mu0Var = this.g0;
        if (zP) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.n.b.n(i, i2);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.m == null) {
                return;
            }
            if (mu0Var.d == 1) {
                q();
            }
            this.n.u0(i, i2);
            mu0Var.i = true;
            r();
            this.n.w0(i, i2);
            if (this.n.z0()) {
                this.n.u0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                mu0Var.i = true;
                r();
                this.n.w0(i, i2);
                return;
            }
            return;
        }
        if (this.s) {
            this.n.b.n(i, i2);
            return;
        }
        if (this.z) {
            f0();
            R();
            V();
            S(true);
            if (mu0Var.k) {
                mu0Var.g = true;
            } else {
                this.e.d();
                mu0Var.g = false;
            }
            this.z = false;
            g0(false);
        } else if (mu0Var.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        qt0 qt0Var = this.m;
        if (qt0Var != null) {
            mu0Var.e = qt0Var.a();
        } else {
            mu0Var.e = 0;
        }
        f0();
        this.n.b.n(i, i2);
        g0(false);
        mu0Var.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (N()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof ju0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ju0 ju0Var = (ju0) parcelable;
        this.d = ju0Var;
        super.onRestoreInstanceState(ju0Var.b);
        zt0 zt0Var = this.n;
        if (zt0Var == null || (parcelable2 = this.d.d) == null) {
            return;
        }
        zt0Var.h0(parcelable2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ju0 ju0Var = new ju0(super.onSaveInstanceState());
        ju0 ju0Var2 = this.d;
        if (ju0Var2 != null) {
            ju0Var.d = ju0Var2.d;
            return ju0Var;
        }
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            ju0Var.d = zt0Var.i0();
            return ju0Var;
        }
        ju0Var.d = null;
        return ju0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.K = null;
        this.I = null;
        this.J = null;
        this.H = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb A[PHI: r1
  0x00fb: PHI (r1v64 int) = (r1v49 int), (r1v68 int) binds: [B:50:0x00e6, B:55:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r10v4, types: [zo0] */
    /* JADX WARN: Type inference failed for: r11v3, types: [zt0] */
    /* JADX WARN: Type inference failed for: r1v17, types: [om0] */
    /* JADX WARN: Type inference failed for: r1v21, types: [om0] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r30) {
        /*
            Method dump skipped, instruction units count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    public final void q() {
        ag1 ag1Var;
        View viewB;
        mu0 mu0Var = this.g0;
        mu0Var.a(1);
        A(mu0Var);
        mu0Var.i = false;
        f0();
        pn0 pn0Var = this.g;
        t01 t01Var = (t01) pn0Var.c;
        t01 t01Var2 = (t01) pn0Var.c;
        t01Var.clear();
        vi0 vi0Var = (vi0) pn0Var.d;
        vi0Var.a();
        R();
        V();
        pu0 pu0VarI = null;
        View focusedChild = (this.c0 && hasFocus() && this.m != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewB = B(focusedChild)) != null) {
            pu0VarI = I(viewB);
        }
        if (pu0VarI == null) {
            mu0Var.m = -1L;
            mu0Var.l = -1;
            mu0Var.n = -1;
        } else {
            mu0Var.m = this.m.b ? pu0VarI.e : -1L;
            mu0Var.l = this.C ? -1 : pu0VarI.i() ? pu0VarI.d : pu0VarI.b();
            View focusedChild2 = pu0VarI.a;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            mu0Var.n = id;
        }
        mu0Var.h = mu0Var.j && this.k0;
        this.k0 = false;
        this.j0 = false;
        mu0Var.g = mu0Var.k;
        mu0Var.e = this.m.a();
        D(this.o0);
        boolean z = mu0Var.j;
        ra raVar = this.f;
        if (z) {
            int iW = raVar.w();
            for (int i = 0; i < iW; i++) {
                pu0 pu0VarJ = J(raVar.v(i));
                if (!pu0VarJ.p() && (!pu0VarJ.g() || this.m.b)) {
                    vt0 vt0Var = this.L;
                    vt0.c(pu0VarJ);
                    pu0VarJ.d();
                    vt0Var.getClass();
                    rm0 rm0Var = new rm0();
                    rm0Var.a(pu0VarJ);
                    ag1 ag1VarA = (ag1) t01Var2.get(pu0VarJ);
                    if (ag1VarA == null) {
                        ag1VarA = ag1.a();
                        t01Var2.put(pu0VarJ, ag1VarA);
                    }
                    ag1VarA.b = rm0Var;
                    ag1VarA.a |= 4;
                    if (mu0Var.h && pu0VarJ.l() && !pu0VarJ.i() && !pu0VarJ.p() && !pu0VarJ.g()) {
                        vi0Var.d(H(pu0VarJ), pu0VarJ);
                    }
                }
            }
        }
        if (mu0Var.k) {
            int iF = raVar.F();
            for (int i2 = 0; i2 < iF; i2++) {
                pu0 pu0VarJ2 = J(raVar.E(i2));
                if (!pu0VarJ2.p() && pu0VarJ2.d == -1) {
                    pu0VarJ2.d = pu0VarJ2.c;
                }
            }
            boolean z2 = mu0Var.f;
            mu0Var.f = false;
            this.n.f0(this.c, mu0Var);
            mu0Var.f = z2;
            for (int i3 = 0; i3 < raVar.w(); i3++) {
                pu0 pu0VarJ3 = J(raVar.v(i3));
                if (!pu0VarJ3.p() && ((ag1Var = (ag1) t01Var2.get(pu0VarJ3)) == null || (ag1Var.a & 4) == 0)) {
                    vt0.c(pu0VarJ3);
                    boolean z3 = (pu0VarJ3.j & 8192) != 0;
                    vt0 vt0Var2 = this.L;
                    pu0VarJ3.d();
                    vt0Var2.getClass();
                    rm0 rm0Var2 = new rm0();
                    rm0Var2.a(pu0VarJ3);
                    if (z3) {
                        X(pu0VarJ3, rm0Var2);
                    } else {
                        ag1 ag1VarA2 = (ag1) t01Var2.get(pu0VarJ3);
                        if (ag1VarA2 == null) {
                            ag1VarA2 = ag1.a();
                            t01Var2.put(pu0VarJ3, ag1VarA2);
                        }
                        ag1VarA2.a |= 2;
                        ag1VarA2.b = rm0Var2;
                    }
                }
            }
            k();
        } else {
            k();
        }
        S(true);
        g0(false);
        mu0Var.d = 2;
    }

    public final void r() {
        f0();
        R();
        mu0 mu0Var = this.g0;
        mu0Var.a(6);
        this.e.d();
        mu0Var.e = this.m.a();
        mu0Var.c = 0;
        mu0Var.g = false;
        this.n.f0(this.c, mu0Var);
        mu0Var.f = false;
        this.d = null;
        mu0Var.j = mu0Var.j && this.L != null;
        mu0Var.d = 4;
        S(true);
        g0(false);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        pu0 pu0VarJ = J(view);
        if (pu0VarJ != null) {
            if (pu0VarJ.k()) {
                pu0VarJ.j &= -257;
            } else if (!pu0VarJ.p()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + pu0VarJ + z());
            }
        }
        view.clearAnimation();
        o(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        qg0 qg0Var = this.n.e;
        if ((qg0Var == null || !qg0Var.e) && !N() && view2 != null) {
            Z(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.n.o0(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((cu0) arrayList.get(i)).c(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.u != 0 || this.w) {
            this.v = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        zt0 zt0Var = this.n;
        if (zt0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.w) {
            return;
        }
        boolean zD = zt0Var.d();
        boolean zE = this.n.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i2 = 0;
            }
            b0(i, i2, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!N()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.y |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(ru0 ru0Var) {
        this.n0 = ru0Var;
        uf1.n(this, ru0Var);
    }

    public void setAdapter(qt0 qt0Var) {
        setLayoutFrozen(false);
        qt0 qt0Var2 = this.m;
        iu0 iu0Var = this.b;
        if (qt0Var2 != null) {
            qt0Var2.a.unregisterObserver(iu0Var);
            this.m.getClass();
        }
        vt0 vt0Var = this.L;
        if (vt0Var != null) {
            vt0Var.f();
        }
        zt0 zt0Var = this.n;
        gu0 gu0Var = this.c;
        if (zt0Var != null) {
            zt0Var.k0(gu0Var);
            this.n.l0(gu0Var);
        }
        gu0Var.a.clear();
        gu0Var.d();
        m4 m4Var = this.e;
        m4Var.q((ArrayList) m4Var.c);
        m4Var.q((ArrayList) m4Var.d);
        m4Var.a = 0;
        qt0 qt0Var3 = this.m;
        this.m = qt0Var;
        if (qt0Var != null) {
            qt0Var.a.registerObserver(iu0Var);
        }
        qt0 qt0Var4 = this.m;
        gu0Var.a.clear();
        gu0Var.d();
        fu0 fu0VarC = gu0Var.c();
        if (qt0Var3 != null) {
            fu0VarC.b--;
        }
        if (fu0VarC.b == 0) {
            SparseArray sparseArray = fu0VarC.a;
            for (int i = 0; i < sparseArray.size(); i++) {
                ((eu0) sparseArray.valueAt(i)).a.clear();
            }
        }
        if (qt0Var4 != null) {
            fu0VarC.b++;
        }
        this.g0.f = true;
        W(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(tt0 tt0Var) {
        if (tt0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.h) {
            this.K = null;
            this.I = null;
            this.J = null;
            this.H = null;
        }
        this.h = z;
        super.setClipToPadding(z);
        if (this.t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(ut0 ut0Var) {
        ut0Var.getClass();
        this.G = ut0Var;
        this.K = null;
        this.I = null;
        this.J = null;
        this.H = null;
    }

    public void setHasFixedSize(boolean z) {
        this.s = z;
    }

    public void setItemAnimator(vt0 vt0Var) {
        vt0 vt0Var2 = this.L;
        if (vt0Var2 != null) {
            vt0Var2.f();
            this.L.a = null;
        }
        this.L = vt0Var;
        if (vt0Var != null) {
            vt0Var.a = this.l0;
        }
    }

    public void setItemViewCacheSize(int i) {
        gu0 gu0Var = this.c;
        gu0Var.e = i;
        gu0Var.k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(zt0 zt0Var) {
        RecyclerView recyclerView;
        qg0 qg0Var;
        if (zt0Var == this.n) {
            return;
        }
        setScrollState(0);
        ou0 ou0Var = this.d0;
        ou0Var.h.removeCallbacks(ou0Var);
        ou0Var.d.abortAnimation();
        zt0 zt0Var2 = this.n;
        if (zt0Var2 != null && (qg0Var = zt0Var2.e) != null) {
            qg0Var.j();
        }
        zt0 zt0Var3 = this.n;
        gu0 gu0Var = this.c;
        if (zt0Var3 != null) {
            vt0 vt0Var = this.L;
            if (vt0Var != null) {
                vt0Var.f();
            }
            this.n.k0(gu0Var);
            this.n.l0(gu0Var);
            gu0Var.a.clear();
            gu0Var.d();
            if (this.r) {
                zt0 zt0Var4 = this.n;
                zt0Var4.g = false;
                zt0Var4.V(this);
            }
            this.n.x0(null);
            this.n = null;
        } else {
            gu0Var.a.clear();
            gu0Var.d();
        }
        ra raVar = this.f;
        ((bk) raVar.d).h();
        ArrayList arrayList = (ArrayList) raVar.e;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = ((pt0) raVar.c).a;
            if (size < 0) {
                break;
            }
            pu0 pu0VarJ = J((View) arrayList.get(size));
            if (pu0VarJ != null) {
                int i = pu0VarJ.p;
                if (recyclerView.N()) {
                    pu0VarJ.q = i;
                    recyclerView.t0.add(pu0VarJ);
                } else {
                    View view = pu0VarJ.a;
                    WeakHashMap weakHashMap = uf1.a;
                    view.setImportantForAccessibility(i);
                }
                pu0VarJ.p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.o(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.n = zt0Var;
        if (zt0Var != null) {
            if (zt0Var.b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(zt0Var);
                String strZ = zt0Var.b.z();
                sb.append(" is already attached to a RecyclerView:");
                sb.append(strZ);
                throw new IllegalArgumentException(sb.toString());
            }
            zt0Var.x0(this);
            if (this.r) {
                zt0 zt0Var5 = this.n;
                zt0Var5.g = true;
                zt0Var5.U(this);
            }
        }
        gu0Var.k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
        } else {
            zy.n("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        om0 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            ViewGroup viewGroup = scrollingChildHelper.c;
            WeakHashMap weakHashMap = uf1.a;
            lf1.m(viewGroup);
        }
        scrollingChildHelper.d = z;
    }

    public void setOnFlingListener(bu0 bu0Var) {
        this.U = bu0Var;
    }

    @Deprecated
    public void setOnScrollListener(du0 du0Var) {
        this.h0 = du0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.c0 = z;
    }

    public void setRecycledViewPool(fu0 fu0Var) {
        gu0 gu0Var = this.c;
        if (gu0Var.g != null) {
            r0.b--;
        }
        gu0Var.g = fu0Var;
        if (fu0Var == null || gu0Var.h.getAdapter() == null) {
            return;
        }
        gu0Var.g.b++;
    }

    public void setScrollState(int i) {
        qg0 qg0Var;
        if (i == this.M) {
            return;
        }
        this.M = i;
        if (i != 2) {
            ou0 ou0Var = this.d0;
            ou0Var.h.removeCallbacks(ou0Var);
            ou0Var.d.abortAnimation();
            zt0 zt0Var = this.n;
            if (zt0Var != null && (qg0Var = zt0Var.e) != null) {
                qg0Var.j();
            }
        }
        zt0 zt0Var2 = this.n;
        if (zt0Var2 != null) {
            zt0Var2.j0(i);
        }
        du0 du0Var = this.h0;
        if (du0Var != null) {
            du0Var.a(this, i);
        }
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((du0) this.i0.get(size)).a(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(nu0 nu0Var) {
        this.c.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        qg0 qg0Var;
        if (z != this.w) {
            i("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.w = false;
                if (this.v && this.n != null && this.m != null) {
                    requestLayout();
                }
                this.v = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.w = true;
            this.x = true;
            setScrollState(0);
            ou0 ou0Var = this.d0;
            ou0Var.h.removeCallbacks(ou0Var);
            ou0Var.d.abortAnimation();
            zt0 zt0Var = this.n;
            if (zt0Var == null || (qg0Var = zt0Var.e) == null) {
                return;
            }
            qg0Var.j();
        }
    }

    public final void t(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().d(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public final void u(int i, int i2) {
        this.F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        du0 du0Var = this.h0;
        if (du0Var != null) {
            du0Var.b(this, i, i2);
        }
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((du0) this.i0.get(size)).b(this, i, i2);
            }
        }
        this.F--;
    }

    public final void v() {
        if (this.K != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.K = edgeEffect;
        if (this.h) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void w() {
        if (this.H != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.H = edgeEffect;
        if (this.h) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.J != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.J = edgeEffect;
        if (this.h) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y() {
        if (this.I != null) {
            return;
        }
        this.G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.I = edgeEffect;
        if (this.h) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String z() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        zt0 zt0Var = this.n;
        if (zt0Var != null) {
            return zt0Var.t(layoutParams);
        }
        s1.f("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    public void setRecyclerListener(hu0 hu0Var) {
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.quickcursor.R.attr.recyclerViewStyle);
    }
}
