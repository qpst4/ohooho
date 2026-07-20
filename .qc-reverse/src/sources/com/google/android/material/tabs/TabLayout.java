package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.quickcursor.R;
import defpackage.a41;
import defpackage.b41;
import defpackage.c10;
import defpackage.c41;
import defpackage.c70;
import defpackage.d10;
import defpackage.e41;
import defpackage.f01;
import defpackage.fc0;
import defpackage.hg1;
import defpackage.i1;
import defpackage.ik0;
import defpackage.lc1;
import defpackage.lf1;
import defpackage.mg1;
import defpackage.mx;
import defpackage.p4;
import defpackage.s7;
import defpackage.tk0;
import defpackage.tp0;
import defpackage.uf1;
import defpackage.up0;
import defpackage.w31;
import defpackage.wg;
import defpackage.x31;
import defpackage.xo0;
import defpackage.xy0;
import defpackage.y31;
import defpackage.yb0;
import defpackage.ys0;
import defpackage.zs0;
import defpackage.zy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@hg1
public class TabLayout extends HorizontalScrollView {
    public static final up0 a0 = new up0(16);
    public int A;
    public final int B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public boolean I;
    public c70 J;
    public final TimeInterpolator K;
    public x31 L;
    public final ArrayList M;
    public p4 N;
    public ValueAnimator O;
    public mg1 P;
    public xo0 Q;
    public d10 R;
    public c41 S;
    public w31 T;
    public boolean U;
    public int V;
    public final tp0 W;
    public int b;
    public final ArrayList c;
    public b41 d;
    public final a41 e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public ColorStateList m;
    public ColorStateList n;
    public ColorStateList o;
    public Drawable p;
    public int q;
    public final PorterDuff.Mode r;
    public final float s;
    public final float t;
    public final int u;
    public int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(xy0.L(context, attributeSet, R.attr.tabStyle, R.style.Widget_Design_TabLayout), attributeSet, R.attr.tabStyle);
        this.b = -1;
        this.c = new ArrayList();
        this.l = -1;
        this.q = 0;
        this.v = Integer.MAX_VALUE;
        this.G = -1;
        this.M = new ArrayList();
        this.W = new tp0(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        a41 a41Var = new a41(this, context2);
        this.e = a41Var;
        super.addView(a41Var, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.D, R.attr.tabStyle, R.style.Widget_Design_TabLayout, 24);
        ColorStateList colorStateListX = lc1.x(getBackground());
        if (colorStateListX != null) {
            ik0 ik0Var = new ik0();
            ik0Var.k(colorStateListX);
            ik0Var.i(context2);
            WeakHashMap weakHashMap = uf1.a;
            ik0Var.j(lf1.e(this));
            setBackground(ik0Var);
        }
        setSelectedTabIndicator(yb0.j(context2, typedArrayE, 5));
        setSelectedTabIndicatorColor(typedArrayE.getColor(8, 0));
        a41Var.b(typedArrayE.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(typedArrayE.getInt(10, 0));
        setTabIndicatorAnimationMode(typedArrayE.getInt(7, 0));
        setTabIndicatorFullWidth(typedArrayE.getBoolean(9, true));
        int dimensionPixelSize = typedArrayE.getDimensionPixelSize(16, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.f = typedArrayE.getDimensionPixelSize(19, dimensionPixelSize);
        this.g = typedArrayE.getDimensionPixelSize(20, dimensionPixelSize);
        this.h = typedArrayE.getDimensionPixelSize(18, dimensionPixelSize);
        this.i = typedArrayE.getDimensionPixelSize(17, dimensionPixelSize);
        if (i1.S(context2, R.attr.isMaterial3Theme, false)) {
            this.j = R.attr.textAppearanceTitleSmall;
        } else {
            this.j = R.attr.textAppearanceButton;
        }
        int resourceId = typedArrayE.getResourceId(24, R.style.TextAppearance_Design_Tab);
        this.k = resourceId;
        int[] iArr = zs0.w;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.s = dimensionPixelSize2;
            this.m = yb0.i(context2, typedArrayObtainStyledAttributes, 3);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayE.hasValue(22)) {
                this.l = typedArrayE.getResourceId(22, resourceId);
            }
            int i = this.l;
            int[] iArr2 = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr3 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i, iArr);
                try {
                    typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) dimensionPixelSize2);
                    ColorStateList colorStateListI = yb0.i(context2, typedArrayObtainStyledAttributes, 3);
                    if (colorStateListI != null) {
                        this.m = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{colorStateListI.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListI.getDefaultColor()), this.m.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (typedArrayE.hasValue(25)) {
                this.m = yb0.i(context2, typedArrayE, 25);
            }
            if (typedArrayE.hasValue(23)) {
                this.m = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{typedArrayE.getColor(23, 0), this.m.getDefaultColor()});
            }
            this.n = yb0.i(context2, typedArrayE, 3);
            this.r = i1.J(typedArrayE.getInt(4, -1), null);
            this.o = yb0.i(context2, typedArrayE, 21);
            this.B = typedArrayE.getInt(6, 300);
            this.K = i1.U(context2, R.attr.motionEasingEmphasizedInterpolator, s7.b);
            this.w = typedArrayE.getDimensionPixelSize(14, -1);
            this.x = typedArrayE.getDimensionPixelSize(13, -1);
            this.u = typedArrayE.getResourceId(0, 0);
            this.z = typedArrayE.getDimensionPixelSize(1, 0);
            this.D = typedArrayE.getInt(15, 1);
            this.A = typedArrayE.getInt(2, 0);
            this.E = typedArrayE.getBoolean(12, false);
            this.I = typedArrayE.getBoolean(26, false);
            typedArrayE.recycle();
            Resources resources = getResources();
            this.t = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.y = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            f();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b41 b41Var = (b41) arrayList.get(i);
            if (b41Var != null && b41Var.b != null && !TextUtils.isEmpty(b41Var.c)) {
                return !this.E ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.w;
        if (i != -1) {
            return i;
        }
        int i2 = this.D;
        if (i2 == 0 || i2 == 2) {
            return this.y;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        a41 a41Var = this.e;
        int childCount = a41Var.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = a41Var.getChildAt(i2);
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                } else {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                    if (childAt instanceof e41) {
                        ((e41) childAt).f();
                    }
                }
                i2++;
            }
        }
    }

    public final void a(x31 x31Var) {
        ArrayList arrayList = this.M;
        if (arrayList.contains(x31Var)) {
            return;
        }
        arrayList.add(x31Var);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        d(view);
    }

    public final void b(b41 b41Var) {
        c(b41Var, this.c.isEmpty());
    }

    public final void c(b41 b41Var, boolean z) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        if (b41Var.g != this) {
            zy.n("Tab belongs to a different TabLayout.");
            return;
        }
        b41Var.e = size;
        arrayList.add(size, b41Var);
        int size2 = arrayList.size();
        int i = -1;
        for (int i2 = size + 1; i2 < size2; i2++) {
            if (((b41) arrayList.get(i2)).e == this.b) {
                i = i2;
            }
            ((b41) arrayList.get(i2)).e = i2;
        }
        this.b = i;
        e41 e41Var = b41Var.h;
        e41Var.setSelected(false);
        e41Var.setActivated(false);
        int i3 = b41Var.e;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.D == 1 && this.A == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.e.addView(e41Var, i3, layoutParams);
        if (z) {
            TabLayout tabLayout = b41Var.g;
            if (tabLayout != null) {
                tabLayout.m(b41Var, true);
            } else {
                zy.n("Tab not attached to a TabLayout");
            }
        }
    }

    public final void d(View view) {
        if (!(view instanceof TabItem)) {
            zy.n("Only TabItem instances can be added to TabLayout");
            return;
        }
        TabItem tabItem = (TabItem) view;
        b41 b41VarJ = j();
        CharSequence charSequence = tabItem.b;
        if (charSequence != null) {
            b41VarJ.b(charSequence);
        }
        Drawable drawable = tabItem.c;
        if (drawable != null) {
            b41VarJ.b = drawable;
            TabLayout tabLayout = b41VarJ.g;
            if (tabLayout.A == 1 || tabLayout.D == 2) {
                tabLayout.q(true);
            }
            e41 e41Var = b41VarJ.h;
            if (e41Var != null) {
                e41Var.d();
            }
        }
        int i = tabItem.d;
        if (i != 0) {
            b41VarJ.f = LayoutInflater.from(b41VarJ.h.getContext()).inflate(i, (ViewGroup) b41VarJ.h, false);
            e41 e41Var2 = b41VarJ.h;
            if (e41Var2 != null) {
                e41Var2.d();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            b41VarJ.d = tabItem.getContentDescription();
            e41 e41Var3 = b41VarJ.h;
            if (e41Var3 != null) {
                e41Var3.d();
            }
        }
        b(b41VarJ);
    }

    public final void e(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = uf1.a;
            if (isLaidOut()) {
                a41 a41Var = this.e;
                int childCount = a41Var.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (a41Var.getChildAt(i2).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iG = g(i, 0.0f);
                if (scrollX != iG) {
                    h();
                    this.O.setIntValues(scrollX, iG);
                    this.O.start();
                }
                ValueAnimator valueAnimator = a41Var.b;
                if (valueAnimator != null && valueAnimator.isRunning() && a41Var.c.b != i) {
                    a41Var.b.cancel();
                }
                a41Var.d(i, this.B, true);
                return;
            }
        }
        o(i, 0.0f, true, true, true);
    }

    public final void f() {
        int i = this.D;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.z - this.f) : 0;
        WeakHashMap weakHashMap = uf1.a;
        a41 a41Var = this.e;
        a41Var.setPaddingRelative(iMax, 0, 0, 0);
        int i2 = this.D;
        if (i2 == 0) {
            int i3 = this.A;
            if (i3 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i3 == 1) {
                a41Var.setGravity(1);
            } else if (i3 == 2) {
            }
            a41Var.setGravity(8388611);
        } else if (i2 == 1 || i2 == 2) {
            if (this.A == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            a41Var.setGravity(1);
        }
        q(true);
    }

    public final int g(int i, float f) {
        a41 a41Var;
        View childAt;
        int i2 = this.D;
        if ((i2 != 0 && i2 != 2) || (childAt = (a41Var = this.e).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < a41Var.getChildCount() ? a41Var.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        WeakHashMap weakHashMap = uf1.a;
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        b41 b41Var = this.d;
        if (b41Var != null) {
            return b41Var.e;
        }
        return -1;
    }

    public int getTabCount() {
        return this.c.size();
    }

    public int getTabGravity() {
        return this.A;
    }

    public ColorStateList getTabIconTint() {
        return this.n;
    }

    public int getTabIndicatorAnimationMode() {
        return this.H;
    }

    public int getTabIndicatorGravity() {
        return this.C;
    }

    public int getTabMaxWidth() {
        return this.v;
    }

    public int getTabMode() {
        return this.D;
    }

    public ColorStateList getTabRippleColor() {
        return this.o;
    }

    public Drawable getTabSelectedIndicator() {
        return this.p;
    }

    public ColorStateList getTabTextColors() {
        return this.m;
    }

    public final void h() {
        if (this.O == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.O = valueAnimator;
            valueAnimator.setInterpolator(this.K);
            this.O.setDuration(this.B);
            this.O.addUpdateListener(new wg(6, this));
        }
    }

    public final b41 i(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (b41) this.c.get(i);
    }

    public final b41 j() {
        b41 b41Var = (b41) a0.a();
        if (b41Var == null) {
            b41Var = new b41();
            b41Var.e = -1;
        }
        b41Var.g = this;
        tp0 tp0Var = this.W;
        e41 e41Var = tp0Var != null ? (e41) tp0Var.a() : null;
        if (e41Var == null) {
            e41Var = new e41(this, getContext());
        }
        e41Var.setTab(b41Var);
        e41Var.setFocusable(true);
        e41Var.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(b41Var.d)) {
            e41Var.setContentDescription(b41Var.c);
        } else {
            e41Var.setContentDescription(b41Var.d);
        }
        b41Var.h = e41Var;
        return b41Var;
    }

    public final void k() {
        int currentItem;
        l();
        xo0 xo0Var = this.Q;
        if (xo0Var != null) {
            int iC = xo0Var.c();
            for (int i = 0; i < iC; i++) {
                b41 b41VarJ = j();
                b41VarJ.b(this.Q.e(i));
                c(b41VarJ, false);
            }
            mg1 mg1Var = this.P;
            if (mg1Var == null || iC <= 0 || (currentItem = mg1Var.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            m(i(currentItem), true);
        }
    }

    public final void l() {
        a41 a41Var = this.e;
        int childCount = a41Var.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            e41 e41Var = (e41) a41Var.getChildAt(childCount);
            a41Var.removeViewAt(childCount);
            if (e41Var != null) {
                e41Var.setTab(null);
                e41Var.setSelected(false);
                this.W.c(e41Var);
            }
            requestLayout();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            b41 b41Var = (b41) it.next();
            it.remove();
            b41Var.g = null;
            b41Var.h = null;
            b41Var.a = null;
            b41Var.b = null;
            b41Var.c = null;
            b41Var.d = null;
            b41Var.e = -1;
            b41Var.f = null;
            a0.c(b41Var);
        }
        this.d = null;
    }

    public final void m(b41 b41Var, boolean z) {
        TabLayout tabLayout;
        b41 b41Var2 = this.d;
        ArrayList arrayList = this.M;
        if (b41Var2 == b41Var) {
            if (b41Var2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((x31) arrayList.get(size)).getClass();
                }
                e(b41Var.e);
                return;
            }
            return;
        }
        int i = b41Var != null ? b41Var.e : -1;
        if (z) {
            if ((b41Var2 == null || b41Var2.e == -1) && i != -1) {
                tabLayout = this;
                tabLayout.o(i, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                tabLayout.e(i);
            }
            if (i != -1) {
                tabLayout.setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.d = b41Var;
        if (b41Var2 != null && b41Var2.g != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((x31) arrayList.get(size2)).getClass();
            }
        }
        if (b41Var != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((x31) arrayList.get(size3)).n(b41Var);
            }
        }
    }

    public final void n(xo0 xo0Var, boolean z) {
        d10 d10Var;
        xo0 xo0Var2 = this.Q;
        if (xo0Var2 != null && (d10Var = this.R) != null) {
            xo0Var2.o(d10Var);
        }
        this.Q = xo0Var;
        if (z && xo0Var != null) {
            if (this.R == null) {
                this.R = new d10(3, this);
            }
            xo0Var.j(this.R);
        }
        k();
    }

    public final void o(int i, float f, boolean z, boolean z2, boolean z3) {
        float f2 = i + f;
        int iRound = Math.round(f2);
        if (iRound >= 0) {
            a41 a41Var = this.e;
            if (iRound >= a41Var.getChildCount()) {
                return;
            }
            if (z2) {
                a41Var.c.b = Math.round(f2);
                ValueAnimator valueAnimator = a41Var.b;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    a41Var.b.cancel();
                }
                a41Var.c(a41Var.getChildAt(i), a41Var.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.O;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.O.cancel();
            }
            int iG = g(i, f);
            int scrollX = getScrollX();
            boolean z4 = (i < getSelectedTabPosition() && iG >= scrollX) || (i > getSelectedTabPosition() && iG <= scrollX) || i == getSelectedTabPosition();
            WeakHashMap weakHashMap = uf1.a;
            if (getLayoutDirection() == 1) {
                z4 = (i < getSelectedTabPosition() && iG <= scrollX) || (i > getSelectedTabPosition() && iG >= scrollX) || i == getSelectedTabPosition();
            }
            if (z4 || this.V == 1 || z3) {
                if (i < 0) {
                    iG = 0;
                }
                scrollTo(iG, 0);
            }
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ik0) {
            fc0.O(this, (ik0) background);
        }
        if (this.P == null) {
            ViewParent parent = getParent();
            if (parent instanceof mg1) {
                p((mg1) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.U) {
            setupWithViewPager(null);
            this.U = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        e41 e41Var;
        Drawable drawable;
        int i = 0;
        while (true) {
            a41 a41Var = this.e;
            if (i >= a41Var.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = a41Var.getChildAt(i);
            if ((childAt instanceof e41) && (drawable = (e41Var = (e41) childAt).j) != null) {
                drawable.setBounds(e41Var.getLeft(), e41Var.getTop(), e41Var.getRight(), e41Var.getBottom());
                e41Var.j.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = defpackage.i1.p(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.x
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = defpackage.i1.p(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.v = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.D
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void p(mg1 mg1Var, boolean z) {
        TabLayout tabLayout;
        ArrayList arrayList;
        mg1 mg1Var2 = this.P;
        if (mg1Var2 != null) {
            c41 c41Var = this.S;
            if (c41Var != null) {
                FadeableViewPager fadeableViewPager = (FadeableViewPager) mg1Var2;
                c10 c10Var = new c10(fadeableViewPager, c41Var);
                ArrayList arrayList2 = fadeableViewPager.U;
                if (arrayList2 != null) {
                    arrayList2.remove(c10Var);
                }
            }
            w31 w31Var = this.T;
            if (w31Var != null && (arrayList = this.P.W) != null) {
                arrayList.remove(w31Var);
            }
        }
        p4 p4Var = this.N;
        if (p4Var != null) {
            this.M.remove(p4Var);
            this.N = null;
        }
        if (mg1Var != null) {
            this.P = mg1Var;
            if (this.S == null) {
                this.S = new c41(this);
            }
            c41 c41Var2 = this.S;
            c41Var2.e = 0;
            c41Var2.d = 0;
            mg1Var.b(c41Var2);
            p4 p4Var2 = new p4(1, mg1Var);
            this.N = p4Var2;
            a(p4Var2);
            xo0 adapter = mg1Var.getAdapter();
            if (adapter != null) {
                n(adapter, true);
            }
            if (this.T == null) {
                this.T = new w31(this, 0);
            }
            w31 w31Var2 = this.T;
            w31Var2.b = true;
            if (mg1Var.W == null) {
                mg1Var.W = new ArrayList();
            }
            mg1Var.W.add(w31Var2);
            tabLayout = this;
            tabLayout.o(mg1Var.getCurrentItem(), 0.0f, true, true, true);
        } else {
            tabLayout = this;
            tabLayout.P = null;
            tabLayout.n(null, false);
        }
        tabLayout.U = z;
    }

    public final void q(boolean z) {
        int i = 0;
        while (true) {
            a41 a41Var = this.e;
            if (i >= a41Var.getChildCount()) {
                return;
            }
            View childAt = a41Var.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.D == 1 && this.A == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof ik0) {
            ((ik0) background).j(f);
        }
    }

    public void setInlineLabel(boolean z) {
        if (this.E == z) {
            return;
        }
        this.E = z;
        int i = 0;
        while (true) {
            a41 a41Var = this.e;
            if (i >= a41Var.getChildCount()) {
                f();
                return;
            }
            View childAt = a41Var.getChildAt(i);
            if (childAt instanceof e41) {
                e41 e41Var = (e41) childAt;
                e41Var.setOrientation(!e41Var.l.E ? 1 : 0);
                TextView textView = e41Var.h;
                if (textView == null && e41Var.i == null) {
                    e41Var.g(e41Var.c, e41Var.d, true);
                } else {
                    e41Var.g(textView, e41Var.i, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(x31 x31Var) {
        x31 x31Var2 = this.L;
        if (x31Var2 != null) {
            this.M.remove(x31Var2);
        }
        this.L = x31Var;
        if (x31Var != null) {
            a(x31Var);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        h();
        this.O.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.p = drawableMutate;
        int i = this.q;
        if (i != 0) {
            drawableMutate.setTint(i);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.G;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.p.getIntrinsicHeight();
        }
        this.e.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.q = i;
        Drawable drawable = this.p;
        if (i != 0) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
        q(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.C != i) {
            this.C = i;
            WeakHashMap weakHashMap = uf1.a;
            this.e.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.G = i;
        this.e.b(i);
    }

    public void setTabGravity(int i) {
        if (this.A != i) {
            this.A = i;
            f();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                e41 e41Var = ((b41) arrayList.get(i)).h;
                if (e41Var != null) {
                    e41Var.d();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(xy0.p(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.H = i;
        if (i == 0) {
            this.J = new c70(27);
            return;
        }
        int i2 = 1;
        if (i == 1) {
            this.J = new mx(0);
        } else {
            if (i == 2) {
                this.J = new mx(i2);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.F = z;
        int i = a41.d;
        a41 a41Var = this.e;
        a41Var.a(a41Var.c.getSelectedTabPosition());
        WeakHashMap weakHashMap = uf1.a;
        a41Var.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.D) {
            this.D = i;
            f();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        int i = 0;
        while (true) {
            a41 a41Var = this.e;
            if (i >= a41Var.getChildCount()) {
                return;
            }
            View childAt = a41Var.getChildAt(i);
            if (childAt instanceof e41) {
                Context context = getContext();
                int i2 = e41.m;
                ((e41) childAt).e(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(xy0.p(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                e41 e41Var = ((b41) arrayList.get(i)).h;
                if (e41Var != null) {
                    e41Var.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(xo0 xo0Var) {
        n(xo0Var, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.I == z) {
            return;
        }
        this.I = z;
        int i = 0;
        while (true) {
            a41 a41Var = this.e;
            if (i >= a41Var.getChildCount()) {
                return;
            }
            View childAt = a41Var.getChildAt(i);
            if (childAt instanceof e41) {
                Context context = getContext();
                int i2 = e41.m;
                ((e41) childAt).e(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(mg1 mg1Var) {
        p(mg1Var, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        d(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        d(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        d(view);
    }

    @Deprecated
    public void setOnTabSelectedListener(y31 y31Var) {
        setOnTabSelectedListener((x31) y31Var);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(tk0.j(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
