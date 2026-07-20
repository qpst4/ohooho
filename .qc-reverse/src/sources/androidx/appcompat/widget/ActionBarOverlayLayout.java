package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.quickcursor.R;
import defpackage.a2;
import defpackage.b71;
import defpackage.di1;
import defpackage.fi1;
import defpackage.gi1;
import defpackage.hi1;
import defpackage.ii1;
import defpackage.jf1;
import defpackage.ji1;
import defpackage.lf1;
import defpackage.m1;
import defpackage.n1;
import defpackage.o1;
import defpackage.og1;
import defpackage.ol0;
import defpackage.p1;
import defpackage.pm0;
import defpackage.q1;
import defpackage.qm0;
import defpackage.ri1;
import defpackage.rm0;
import defpackage.s1;
import defpackage.tk0;
import defpackage.u61;
import defpackage.uf1;
import defpackage.vh1;
import defpackage.wi1;
import defpackage.xb0;
import defpackage.yr;
import defpackage.zk0;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements pm0, qm0 {
    public static final int[] D = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final wi1 E;
    public static final Rect F;
    public final n1 A;
    public final rm0 B;
    public final q1 C;
    public int b;
    public int c;
    public ContentFrameLayout d;
    public ActionBarContainer e;
    public yr f;
    public Drawable g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public final Rect n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public wi1 r;
    public wi1 s;
    public wi1 t;
    public wi1 u;
    public o1 v;
    public OverScroller w;
    public ViewPropertyAnimator x;
    public final m1 y;
    public final n1 z;

    static {
        int i = Build.VERSION.SDK_INT;
        ji1 ii1Var = i >= 34 ? new ii1() : i >= 31 ? new hi1() : i >= 30 ? new gi1() : i >= 29 ? new fi1() : new di1();
        ii1Var.g(xb0.b(0, 1, 0, 1));
        E = ii1Var.b();
        F = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        wi1 wi1Var = wi1.b;
        this.r = wi1Var;
        this.s = wi1Var;
        this.t = wi1Var;
        this.u = wi1Var;
        this.y = new m1(0, this);
        this.z = new n1(this, 0);
        this.A = new n1(this, 1);
        i(context);
        this.B = new rm0();
        q1 q1Var = new q1(context);
        q1Var.setWillNotDraw(true);
        this.C = q1Var;
        addView(q1Var);
    }

    public static boolean g(View view, Rect rect, boolean z) {
        boolean z2;
        p1 p1Var = (p1) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) p1Var).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) p1Var).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) p1Var).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) p1Var).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) p1Var).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) p1Var).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) p1Var).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) p1Var).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    @Override // defpackage.pm0
    public final void a(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // defpackage.pm0
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof p1;
    }

    @Override // defpackage.qm0
    public final void d(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        e(view, i, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.g != null) {
            if (this.e.getVisibility() == 0) {
                translationY = (int) (this.e.getTranslationY() + this.e.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.g.setBounds(0, translationY, getWidth(), this.g.getIntrinsicHeight() + translationY);
            this.g.draw(canvas);
        }
    }

    @Override // defpackage.pm0
    public final void e(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // defpackage.pm0
    public final boolean f(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new p1(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new p1(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        rm0 rm0Var = this.B;
        return rm0Var.b | rm0Var.a;
    }

    public CharSequence getTitle() {
        k();
        return ((b71) this.f).a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(D);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.g = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.w = new OverScroller(context);
    }

    public final void j(int i) {
        k();
        if (i == 2) {
            ((b71) this.f).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((b71) this.f).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        yr wrapper;
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof yr) {
                wrapper = (yr) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    s1.f("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f = wrapper;
        }
    }

    public final void l(Menu menu, ol0 ol0Var) {
        k();
        b71 b71Var = (b71) this.f;
        Toolbar toolbar = b71Var.a;
        if (b71Var.m == null) {
            b71Var.m = new a2(toolbar.getContext());
        }
        a2 a2Var = b71Var.m;
        a2Var.f = ol0Var;
        zk0 zk0Var = (zk0) menu;
        if (zk0Var == null && toolbar.b == null) {
            return;
        }
        toolbar.f();
        zk0 zk0Var2 = toolbar.b.q;
        if (zk0Var2 == zk0Var) {
            return;
        }
        if (zk0Var2 != null) {
            zk0Var2.r(toolbar.M);
            zk0Var2.r(toolbar.N);
        }
        if (toolbar.N == null) {
            toolbar.N = new u61(toolbar);
        }
        a2Var.r = true;
        Context context = toolbar.k;
        if (zk0Var != null) {
            zk0Var.b(a2Var, context);
            zk0Var.b(toolbar.N, toolbar.k);
        } else {
            a2Var.i(context, null);
            toolbar.N.i(toolbar.k, null);
            a2Var.g();
            toolbar.N.g();
        }
        toolbar.b.setPopupTheme(toolbar.l);
        toolbar.b.setPresenter(a2Var);
        toolbar.M = a2Var;
        toolbar.w();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        wi1 wi1VarH = wi1.h(this, windowInsets);
        boolean zG = g(this.e, new Rect(wi1VarH.b(), wi1VarH.d(), wi1VarH.c(), wi1VarH.a()), false);
        WeakHashMap weakHashMap = uf1.a;
        Rect rect = this.n;
        lf1.b(this, wi1VarH, rect);
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        ri1 ri1Var = wi1VarH.a;
        wi1 wi1VarL = ri1Var.l(i, i2, i3, i4);
        this.r = wi1VarL;
        boolean z = true;
        if (!this.s.equals(wi1VarL)) {
            this.s = this.r;
            zG = true;
        }
        Rect rect2 = this.o;
        if (rect2.equals(rect)) {
            z = zG;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return ri1Var.a().a.c().a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = uf1.a;
        jf1.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                p1 p1Var = (p1) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) p1Var).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) p1Var).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.j || !z) {
            return false;
        }
        this.w.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.w.getFinalY() > this.e.getHeight()) {
            h();
            this.A.run();
        } else {
            h();
            this.z.run();
        }
        this.k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.l + i2;
        this.l = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        vh1 vh1Var;
        og1 og1Var;
        this.B.a = i;
        this.l = getActionBarHideOffset();
        h();
        o1 o1Var = this.v;
        if (o1Var == null || (og1Var = (vh1Var = (vh1) o1Var).s) == null) {
            return;
        }
        og1Var.a();
        vh1Var.s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.j || this.k) {
            return;
        }
        if (this.l <= this.e.getHeight()) {
            h();
            postDelayed(this.z, 600L);
        } else {
            h();
            postDelayed(this.A, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i2 = this.m ^ i;
        this.m = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        o1 o1Var = this.v;
        if (o1Var != null) {
            vh1 vh1Var = (vh1) o1Var;
            vh1Var.o = !z2;
            if (z || !z2) {
                if (vh1Var.p) {
                    vh1Var.p = false;
                    vh1Var.C(true);
                }
            } else if (!vh1Var.p) {
                vh1Var.p = true;
                vh1Var.C(true);
            }
        }
        if ((i2 & 256) == 0 || this.v == null) {
            return;
        }
        WeakHashMap weakHashMap = uf1.a;
        jf1.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        o1 o1Var = this.v;
        if (o1Var != null) {
            ((vh1) o1Var).n = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        h();
        this.e.setTranslationY(-Math.max(0, Math.min(i, this.e.getHeight())));
    }

    public void setActionBarVisibilityCallback(o1 o1Var) {
        this.v = o1Var;
        if (getWindowToken() != null) {
            ((vh1) this.v).n = this.c;
            int i = this.m;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = uf1.a;
                jf1.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.j) {
            this.j = z;
            if (z) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        b71 b71Var = (b71) this.f;
        b71Var.d = i != 0 ? tk0.j(b71Var.a.getContext(), i) : null;
        b71Var.e();
    }

    public void setLogo(int i) {
        k();
        b71 b71Var = (b71) this.f;
        b71Var.e = i != 0 ? tk0.j(b71Var.a.getContext(), i) : null;
        b71Var.e();
    }

    public void setOverlayMode(boolean z) {
        this.h = z;
    }

    public void setWindowCallback(Window.Callback callback) {
        k();
        ((b71) this.f).k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        k();
        b71 b71Var = (b71) this.f;
        if (b71Var.g) {
            return;
        }
        Toolbar toolbar = b71Var.a;
        b71Var.h = charSequence;
        if ((b71Var.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (b71Var.g) {
                uf1.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new p1(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        b71 b71Var = (b71) this.f;
        b71Var.d = drawable;
        b71Var.e();
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // defpackage.pm0
    public final void c(View view, int i, int i2, int[] iArr, int i3) {
    }
}
