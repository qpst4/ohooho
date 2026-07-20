package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.google.android.material.tabs.TabLayout;
import com.quickcursor.android.views.VerticalTabLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mg1 extends ViewGroup {
    public static final int[] c0 = {R.attr.layout_gravity};
    public static final ik d0 = new ik(7);
    public static final qc0 e0 = new qc0(4);
    public final int A;
    public int B;
    public final int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public VelocityTracker I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public boolean N;
    public long O;
    public final EdgeEffect P;
    public final EdgeEffect Q;
    public boolean R;
    public boolean S;
    public int T;
    public ArrayList U;
    public kg1 V;
    public ArrayList W;
    public final nc a0;
    public int b;
    public int b0;
    public final ArrayList c;
    public final ig1 d;
    public final Rect e;
    public xo0 f;
    public int g;
    public int h;
    public Parcelable i;
    public ClassLoader j;
    public final Scroller k;
    public boolean l;
    public d10 m;
    public int n;
    public Drawable o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    public mg1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        this.d = new ig1();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.x = 1;
        this.H = -1;
        this.R = true;
        this.a0 = new nc(21, this);
        this.b0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.k = new Scroller(context2, e0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context2);
        this.Q = new EdgeEffect(context2);
        this.L = (int) (25.0f * f);
        this.M = (int) (2.0f * f);
        this.A = (int) (f * 16.0f);
        uf1.n(this, new xj(5, this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        lf1.l(this, new pn0(this));
    }

    public static boolean e(int i, int i2, int i3, View view, boolean z) {
        int i4;
        if (!(view instanceof ViewGroup)) {
            return z ? false : false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            int i5 = i2 + scrollX;
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && e(i, i5 - childAt.getLeft(), i4 - childAt.getTop(), childAt, true)) {
                break;
            }
        }
        if (z || !view.canScrollHorizontally(-i)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.v != z) {
            this.v = z;
        }
    }

    public final void A(int i, int i2, boolean z, boolean z2) {
        xo0 xo0Var = this.f;
        if (xo0Var == null || xo0Var.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.c;
        if (!z2 && this.g == i && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f.c()) {
            i = this.f.c() - 1;
        }
        int i3 = this.x;
        int i4 = this.g;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((ig1) arrayList.get(i5)).c = true;
            }
        }
        boolean z3 = this.g != i;
        if (!this.R) {
            v(i);
            y(i, i2, z, z3);
        } else {
            this.g = i;
            if (z3) {
                i(i);
            }
            requestLayout();
        }
    }

    public final ig1 a(int i, int i2) {
        ig1 ig1Var = new ig1();
        ig1Var.b = i;
        ig1Var.a = this.f.g(this, i);
        ig1Var.d = this.f.f(i);
        ArrayList arrayList = this.c;
        if (i2 < 0 || i2 >= arrayList.size()) {
            arrayList.add(ig1Var);
            return ig1Var;
        }
        arrayList.add(i2, ig1Var);
        return ig1Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ig1 ig1VarM;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (ig1VarM = m(childAt)) != null && ig1VarM.b == this.g) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        ig1 ig1VarM;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ig1VarM = m(childAt)) != null && ig1VarM.b == this.g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        jg1 jg1Var = (jg1) layoutParams;
        boolean z = jg1Var.a | (view.getClass().getAnnotation(hg1.class) != null);
        jg1Var.a = z;
        if (!this.u) {
            super.addView(view, i, layoutParams);
        } else if (z) {
            s1.f("Cannot add pager decor view during layout");
        } else {
            jg1Var.d = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    public abstract void b(kg1 kg1Var);

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r8) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.c(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.r)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.s));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof jg1) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.l = true;
        Scroller scroller = this.k;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!s(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = uf1.a;
        postInvalidateOnAnimation();
    }

    public final boolean d() {
        if (this.y) {
            return false;
        }
        this.N = true;
        setScrollState(1);
        this.D = 0.0f;
        this.F = 0.0f;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker == null) {
            this.I = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.O = jUptimeMillis;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L64
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L5f
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L5f
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r5 = r5.c(r4)
            goto L60
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L5f
            boolean r5 = r5.c(r1)
            goto L60
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r5 = r5.r()
            goto L60
        L41:
            r6 = 66
            boolean r5 = r5.c(r6)
            goto L60
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L58
            int r6 = r5.g
            if (r6 <= 0) goto L5f
            int r6 = r6 - r1
            r5.z(r6, r1)
            r5 = r1
            goto L60
        L58:
            r6 = 17
            boolean r5 = r5.c(r6)
            goto L60
        L5f:
            r5 = r2
        L60:
            if (r5 == 0) goto L63
            goto L64
        L63:
            return r2
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ig1 ig1VarM;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ig1VarM = m(childAt)) != null && ig1VarM.b == this.g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        xo0 xo0Var;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        EdgeEffect edgeEffect = this.Q;
        EdgeEffect edgeEffect2 = this.P;
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (xo0Var = this.f) != null && xo0Var.c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.r * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.s + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = uf1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void f(boolean z) {
        boolean z2 = this.b0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            Scroller scroller = this.k;
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        s(currX);
                    }
                }
            }
        }
        this.w = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.c;
            if (i >= arrayList.size()) {
                break;
            }
            ig1 ig1Var = (ig1) arrayList.get(i);
            if (ig1Var.c) {
                ig1Var.c = false;
                z2 = true;
            }
            i++;
        }
        if (z2) {
            nc ncVar = this.a0;
            if (!z) {
                ncVar.run();
            } else {
                WeakHashMap weakHashMap = uf1.a;
                postOnAnimation(ncVar);
            }
        }
    }

    public final void g() {
        int iC = this.f.c();
        this.b = iC;
        ArrayList arrayList = this.c;
        boolean z = arrayList.size() < (this.x * 2) + 1 && arrayList.size() < iC;
        int iMax = this.g;
        int i = 0;
        boolean z2 = false;
        while (i < arrayList.size()) {
            ig1 ig1Var = (ig1) arrayList.get(i);
            int iD = this.f.d(ig1Var.a);
            if (iD != -1) {
                if (iD == -2) {
                    arrayList.remove(i);
                    i--;
                    if (!z2) {
                        this.f.n(this);
                        z2 = true;
                    }
                    this.f.a(this, ig1Var.b, ig1Var.a);
                    int i2 = this.g;
                    if (i2 == ig1Var.b) {
                        iMax = Math.max(0, Math.min(i2, iC - 1));
                    }
                } else {
                    int i3 = ig1Var.b;
                    if (i3 != iD) {
                        if (i3 == this.g) {
                            iMax = iD;
                        }
                        ig1Var.b = iD;
                    }
                }
                z = true;
            }
            i++;
        }
        if (z2) {
            this.f.b(this);
        }
        Collections.sort(arrayList, d0);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                jg1 jg1Var = (jg1) getChildAt(i4).getLayoutParams();
                if (!jg1Var.a) {
                    jg1Var.c = 0.0f;
                }
            }
            A(iMax, 0, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        jg1 jg1Var = new jg1(-1, -1);
        jg1Var.c = 0.0f;
        return jg1Var;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        jg1 jg1Var = new jg1(context, attributeSet);
        jg1Var.c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0);
        jg1Var.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return jg1Var;
    }

    public xo0 getAdapter() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        throw null;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    public final int h(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.L || Math.abs(i2) <= this.J) {
            i += (int) (f + (i >= this.g ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        ArrayList arrayList = this.c;
        if (arrayList.size() > 0) {
            return Math.max(((ig1) arrayList.get(0)).b, Math.min(i, ((ig1) arrayList.get(arrayList.size() - 1)).b));
        }
        return i;
    }

    public final void i(int i) {
        kg1 kg1Var = this.V;
        if (kg1Var != null) {
            kg1Var.d(i);
        }
        ArrayList arrayList = this.U;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                kg1 kg1Var2 = (kg1) this.U.get(i2);
                if (kg1Var2 != null) {
                    kg1Var2.d(i);
                }
            }
        }
    }

    public final void j() {
        if (!this.N) {
            s1.f("No fake drag in progress. Call beginFakeDrag first.");
            return;
        }
        if (this.f != null) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ig1 ig1VarN = n();
            A(h(ig1VarN.b, ((scrollX / clientWidth) - ig1VarN.e) / ig1VarN.d, xVelocity, (int) (this.D - this.F)), xVelocity, true, true);
        }
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker2 = this.I;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.I = null;
        }
        this.N = false;
    }

    public final void k(float f) {
        if (!this.N) {
            s1.f("No fake drag in progress. Call beginFakeDrag first.");
            return;
        }
        if (this.f == null) {
            return;
        }
        this.D += f;
        float scrollX = getScrollX() - f;
        float clientWidth = getClientWidth();
        float f2 = this.r * clientWidth;
        float f3 = this.s * clientWidth;
        ArrayList arrayList = this.c;
        ig1 ig1Var = (ig1) arrayList.get(0);
        ig1 ig1Var2 = (ig1) arrayList.get(arrayList.size() - 1);
        if (ig1Var.b != 0) {
            f2 = ig1Var.e * clientWidth;
        }
        if (ig1Var2.b != this.f.c() - 1) {
            f3 = ig1Var2.e * clientWidth;
        }
        if (scrollX < f2) {
            scrollX = f2;
        } else if (scrollX > f3) {
            scrollX = f3;
        }
        int i = (int) scrollX;
        this.D = (scrollX - i) + this.D;
        scrollTo(i, getScrollY());
        s(i);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.O, SystemClock.uptimeMillis(), 2, this.D, 0.0f, 0);
        this.I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final Rect l(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public final ig1 m(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.c;
            if (i >= arrayList.size()) {
                return null;
            }
            ig1 ig1Var = (ig1) arrayList.get(i);
            if (this.f.h(view, ig1Var.a)) {
                return ig1Var;
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ig1 n() {
        /*
            r13 = this;
            int r0 = r13.getClientWidth()
            r1 = 0
            if (r0 <= 0) goto Lf
            int r2 = r13.getScrollX()
            float r2 = (float) r2
            float r3 = (float) r0
            float r2 = r2 / r3
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r0 <= 0) goto L18
            int r3 = r13.n
            float r3 = (float) r3
            float r0 = (float) r0
            float r3 = r3 / r0
            goto L19
        L18:
            r3 = r1
        L19:
            r0 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            r8 = r0
            r9 = r5
            r7 = r6
            r6 = r4
            r4 = r1
        L22:
            java.util.ArrayList r10 = r13.c
            int r11 = r10.size()
            if (r8 >= r11) goto L71
            java.lang.Object r11 = r10.get(r8)
            ig1 r11 = (defpackage.ig1) r11
            if (r9 != 0) goto L4b
            int r12 = r11.b
            int r6 = r6 + r5
            if (r12 == r6) goto L4b
            float r1 = r1 + r4
            float r1 = r1 + r3
            ig1 r4 = r13.d
            r4.e = r1
            r4.b = r6
            xo0 r1 = r13.f
            float r1 = r1.f(r6)
            r4.d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4c
        L4b:
            r6 = r11
        L4c:
            float r1 = r6.e
            float r4 = r6.d
            float r4 = r4 + r1
            float r4 = r4 + r3
            if (r9 != 0) goto L58
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L71
        L58:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L70
            int r4 = r10.size()
            int r4 = r4 - r5
            if (r8 != r4) goto L64
            goto L70
        L64:
            int r4 = r6.b
            float r7 = r6.d
            int r8 = r8 + 1
            r9 = r6
            r6 = r4
            r4 = r7
            r7 = r9
            r9 = r0
            goto L22
        L70:
            return r6
        L71:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.n():ig1");
    }

    public final ig1 o(int i) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.c;
            if (i2 >= arrayList.size()) {
                return null;
            }
            ig1 ig1Var = (ig1) arrayList.get(i2);
            if (ig1Var.b == i) {
                return ig1Var;
            }
            i2++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.a0);
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            scroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        float f;
        ArrayList arrayList;
        int i2;
        super.onDraw(canvas);
        if (this.n <= 0 || this.o == null) {
            return;
        }
        ArrayList arrayList2 = this.c;
        if (arrayList2.size() <= 0 || this.f == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f2 = this.n / width;
        int i3 = 0;
        ig1 ig1Var = (ig1) arrayList2.get(0);
        float f3 = ig1Var.e;
        int size = arrayList2.size();
        int i4 = ig1Var.b;
        int i5 = ((ig1) arrayList2.get(size - 1)).b;
        while (i4 < i5) {
            while (true) {
                i = ig1Var.b;
                if (i4 <= i || i3 >= size) {
                    break;
                }
                i3++;
                ig1Var = (ig1) arrayList2.get(i3);
            }
            if (i4 == i) {
                float f4 = ig1Var.e + ig1Var.d;
                f = f4 * width;
                f3 = f4 + f2;
            } else {
                float f5 = this.f.f(i4);
                float f6 = (f3 + f5) * width;
                f3 = f5 + f2 + f3;
                f = f6;
            }
            if (this.n + f > scrollX) {
                arrayList = arrayList2;
                i2 = scrollX;
                this.o.setBounds(Math.round(f), this.p, Math.round(this.n + f), this.q);
                this.o.draw(canvas);
            } else {
                arrayList = arrayList2;
                i2 = scrollX;
            }
            if (f > i2 + r3) {
                return;
            }
            i4++;
            arrayList2 = arrayList;
            scrollX = i2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            x();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.F = x;
            this.D = x;
            float y = motionEvent.getY();
            this.G = y;
            this.E = y;
            this.H = motionEvent.getPointerId(0);
            this.z = false;
            this.l = true;
            Scroller scroller = this.k;
            scroller.computeScrollOffset();
            if (this.b0 != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.M) {
                f(false);
                this.y = false;
            } else {
                scroller.abortAnimation();
                this.w = false;
                u();
                this.y = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.H;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.D;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.G);
                if (f != 0.0f) {
                    float f2 = this.D;
                    if ((f2 >= this.B || f <= 0.0f) && ((f2 <= getWidth() - this.B || f >= 0.0f) && e((int) f, (int) x2, (int) y2, this, false))) {
                        this.D = x2;
                        this.E = y2;
                        this.z = true;
                        return false;
                    }
                }
                int i2 = this.C;
                float f3 = i2;
                if (fAbs > f3 && fAbs * 0.5f > fAbs2) {
                    this.y = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f4 = this.F;
                    float f5 = i2;
                    this.D = f > 0.0f ? f4 + f5 : f4 - f5;
                    this.E = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f3) {
                    this.z = true;
                }
                if (this.y && t(x2)) {
                    WeakHashMap weakHashMap = uf1.a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            q(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        return this.y;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        jg1 jg1Var;
        jg1 jg1Var2;
        int i3;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.B = Math.min(measuredWidth / 10, this.A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && (jg1Var2 = (jg1) childAt.getLayoutParams()) != null && jg1Var2.a) {
                int i6 = jg1Var2.b;
                int i7 = i6 & 7;
                int i8 = i6 & 112;
                boolean z2 = i8 == 48 || i8 == 80;
                if (i7 != 3 && i7 != 5) {
                    z = false;
                }
                int i9 = Integer.MIN_VALUE;
                if (z2) {
                    i3 = Integer.MIN_VALUE;
                    i9 = 1073741824;
                } else {
                    i3 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i10 = ((ViewGroup.LayoutParams) jg1Var2).width;
                if (i10 != -2) {
                    if (i10 == -1) {
                        i10 = paddingLeft;
                    }
                    i9 = 1073741824;
                } else {
                    i10 = paddingLeft;
                }
                int i11 = ((ViewGroup.LayoutParams) jg1Var2).height;
                if (i11 == -2) {
                    i11 = measuredHeight;
                    i5 = i3;
                } else if (i11 == -1) {
                    i11 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec(i11, i5));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.u = true;
        u();
        this.u = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((jg1Var = (jg1) childAt2.getLayoutParams()) == null || !jg1Var.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * jg1Var.c), 1073741824), this.t);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        ig1 ig1VarM;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (ig1VarM = m(childAt)) != null && ig1VarM.b == this.g && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof lg1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        lg1 lg1Var = (lg1) parcelable;
        ClassLoader classLoader = lg1Var.f;
        super.onRestoreInstanceState(lg1Var.b);
        xo0 xo0Var = this.f;
        if (xo0Var != null) {
            xo0Var.k(lg1Var.e, classLoader);
            A(lg1Var.d, 0, false, true);
        } else {
            this.h = lg1Var.d;
            this.i = lg1Var.e;
            this.j = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        lg1 lg1Var = new lg1(super.onSaveInstanceState());
        lg1Var.d = this.g;
        xo0 xo0Var = this.f;
        if (xo0Var != null) {
            lg1Var.e = xo0Var.l();
        }
        return lg1Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.n;
            w(i, i3, i5, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e0  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(float r13, int r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.T
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            jg1 r9 = (defpackage.jg1) r9
            boolean r10 = r9.a
            if (r10 != 0) goto L2c
            goto L69
        L2c:
            int r9 = r9.b
            r9 = r9 & 7
            if (r9 == r2) goto L50
            r10 = 3
            if (r9 == r10) goto L4a
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5d
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L46:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5d
        L4a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5d
        L50:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L46
        L5d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L68
            r8.offsetLeftAndRight(r3)
        L68:
            r3 = r9
        L69:
            int r7 = r7 + 1
            goto L1b
        L6c:
            kg1 r0 = r12.V
            if (r0 == 0) goto L73
            r0.l(r13, r14, r15)
        L73:
            java.util.ArrayList r0 = r12.U
            if (r0 == 0) goto L8d
            int r0 = r0.size()
        L7b:
            if (r1 >= r0) goto L8d
            java.util.ArrayList r3 = r12.U
            java.lang.Object r3 = r3.get(r1)
            kg1 r3 = (defpackage.kg1) r3
            if (r3 == 0) goto L8a
            r3.l(r13, r14, r15)
        L8a:
            int r1 = r1 + 1
            goto L7b
        L8d:
            r12.S = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.p(float, int, int):void");
    }

    public final void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i);
            this.H = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean r() {
        xo0 xo0Var = this.f;
        if (xo0Var == null || this.g >= xo0Var.c() - 1) {
            return false;
        }
        z(this.g + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s(int i) {
        if (this.c.size() == 0) {
            if (!this.R) {
                this.S = false;
                p(0.0f, 0, 0);
                if (!this.S) {
                    s1.f("onPageScrolled did not call superclass implementation");
                    return false;
                }
            }
            return false;
        }
        ig1 ig1VarN = n();
        int clientWidth = getClientWidth();
        int i2 = this.n;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = ig1VarN.b;
        float f2 = ((i / f) - ig1VarN.e) / (ig1VarN.d + (i2 / f));
        this.S = false;
        p(f2, i4, (int) (i3 * f2));
        if (this.S) {
            return true;
        }
        s1.f("onPageScrolled did not call superclass implementation");
        return false;
    }

    public void setAdapter(xo0 xo0Var) {
        ArrayList arrayList = this.c;
        xo0 xo0Var2 = this.f;
        if (xo0Var2 != null) {
            synchronized (xo0Var2) {
                xo0Var2.b = null;
            }
            this.f.n(this);
            for (int i = 0; i < arrayList.size(); i++) {
                ig1 ig1Var = (ig1) arrayList.get(i);
                this.f.a(this, ig1Var.b, ig1Var.a);
            }
            this.f.b(this);
            arrayList.clear();
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((jg1) getChildAt(i2).getLayoutParams()).a) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.g = 0;
            scrollTo(0, 0);
        }
        this.f = xo0Var;
        this.b = 0;
        if (xo0Var != null) {
            if (this.m == null) {
                this.m = new d10(5, this);
            }
            xo0 xo0Var3 = this.f;
            d10 d10Var = this.m;
            synchronized (xo0Var3) {
                xo0Var3.b = d10Var;
            }
            this.w = false;
            boolean z = this.R;
            this.R = true;
            this.b = this.f.c();
            if (this.h >= 0) {
                this.f.k(this.i, this.j);
                A(this.h, 0, false, true);
                this.h = -1;
                this.i = null;
                this.j = null;
            } else if (z) {
                requestLayout();
            } else {
                u();
            }
        }
        ArrayList arrayList2 = this.W;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.W.size();
        for (int i3 = 0; i3 < size; i3++) {
            w31 w31Var = (w31) this.W.get(i3);
            switch (w31Var.a) {
                case 0:
                    TabLayout tabLayout = (TabLayout) w31Var.c;
                    if (tabLayout.P == this) {
                        tabLayout.n(xo0Var, w31Var.b);
                    }
                    break;
                default:
                    VerticalTabLayout verticalTabLayout = (VerticalTabLayout) w31Var.c;
                    if (verticalTabLayout.H == this) {
                        verticalTabLayout.k(xo0Var, w31Var.b);
                    }
                    break;
            }
        }
    }

    public void setCurrentItem(int i) {
        this.w = false;
        A(i, 0, !this.R, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.x) {
            this.x = i;
            u();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(kg1 kg1Var) {
        this.V = kg1Var;
    }

    public void setPageMargin(int i) {
        int i2 = this.n;
        this.n = i;
        int width = getWidth();
        w(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.b0 == i) {
            return;
        }
        this.b0 = i;
        kg1 kg1Var = this.V;
        if (kg1Var != null) {
            kg1Var.a(i);
        }
        ArrayList arrayList = this.U;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                kg1 kg1Var2 = (kg1) this.U.get(i2);
                if (kg1Var2 != null) {
                    kg1Var2.a(i);
                }
            }
        }
    }

    public final boolean t(float f) {
        boolean z;
        boolean z2;
        float f2 = this.D - f;
        this.D = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.r * clientWidth;
        float f4 = this.s * clientWidth;
        ArrayList arrayList = this.c;
        boolean z3 = false;
        ig1 ig1Var = (ig1) arrayList.get(0);
        ig1 ig1Var2 = (ig1) arrayList.get(arrayList.size() - 1);
        if (ig1Var.b != 0) {
            f3 = ig1Var.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (ig1Var2.b != this.f.c() - 1) {
            f4 = ig1Var2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.P.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.Q.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.D = (scrollX - i) + this.D;
        scrollTo(i, getScrollY());
        s(i);
        return z3;
    }

    public final void u() {
        v(this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3 A[PHI: r7 r11 r15
  0x00c3: PHI (r7v13 int) = (r7v12 int), (r7v4 int), (r7v16 int) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]
  0x00c3: PHI (r11v26 int) = (r11v1 int), (r11v25 int), (r11v29 int) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]
  0x00c3: PHI (r15v6 float) = (r15v4 float), (r15v5 float), (r15v3 float) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0145 A[PHI: r3 r12
  0x0145: PHI (r3v42 float) = (r3v40 float), (r3v41 float), (r3v39 float) binds: [B:96:0x016c, B:93:0x0156, B:86:0x013c] A[DONT_GENERATE, DONT_INLINE]
  0x0145: PHI (r12v10 int) = (r12v8 int), (r12v9 int), (r12v7 int) binds: [B:96:0x016c, B:93:0x0156, B:86:0x013c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(int r18) {
        /*
            Method dump skipped, instruction units count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg1.v(int):void");
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    public final void w(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.c.isEmpty()) {
            ig1 ig1VarO = o(this.g);
            int iMin = (int) ((ig1VarO != null ? Math.min(ig1VarO.e, this.s) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                f(false);
                scrollTo(iMin, getScrollY());
                return;
            }
            return;
        }
        Scroller scroller = this.k;
        if (!scroller.isFinished()) {
            scroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
        }
    }

    public final boolean x() {
        this.H = -1;
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
        EdgeEffect edgeEffect = this.P;
        edgeEffect.onRelease();
        EdgeEffect edgeEffect2 = this.Q;
        edgeEffect2.onRelease();
        return edgeEffect.isFinished() || edgeEffect2.isFinished();
    }

    public final void y(int i, int i2, boolean z, boolean z2) {
        int scrollX;
        ig1 ig1VarO = o(i);
        int iMax = ig1VarO != null ? (int) (Math.max(this.r, Math.min(ig1VarO.e, this.s)) * getClientWidth()) : 0;
        if (!z) {
            if (z2) {
                i(i);
            }
            f(false);
            scrollTo(iMax, 0);
            s(iMax);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            Scroller scroller = this.k;
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.l ? scroller.getCurrX() : scroller.getStartX();
                scroller.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i3 = scrollX;
            int scrollY = getScrollY();
            int i4 = iMax - i3;
            int i5 = 0 - scrollY;
            if (i4 == 0 && i5 == 0) {
                f(false);
                u();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i6 = clientWidth / 2;
                float f = clientWidth;
                float f2 = i6;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i4) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                int iAbs = Math.abs(i2);
                int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i4) / ((this.f.f(this.g) * f) + this.n)) + 1.0f) * 100.0f), 600);
                this.l = false;
                this.k.startScroll(i3, scrollY, i4, i5, iMin);
                WeakHashMap weakHashMap = uf1.a;
                postInvalidateOnAnimation();
            }
        }
        if (z2) {
            i(i);
        }
    }

    public final void z(int i, boolean z) {
        this.w = false;
        A(i, 0, z, false);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getDrawable(i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }
}
