package com.quickcursor.android.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.tabs.TabItem;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.AdvancedTriggerActivity;
import defpackage.bf1;
import defpackage.c10;
import defpackage.c41;
import defpackage.d10;
import defpackage.f01;
import defpackage.fc0;
import defpackage.i1;
import defpackage.ik0;
import defpackage.lf1;
import defpackage.ma1;
import defpackage.mg1;
import defpackage.ms0;
import defpackage.o3;
import defpackage.q4;
import defpackage.s7;
import defpackage.tk0;
import defpackage.tp0;
import defpackage.uf1;
import defpackage.up0;
import defpackage.w31;
import defpackage.xo0;
import defpackage.xy0;
import defpackage.yb0;
import defpackage.ye1;
import defpackage.ze1;
import defpackage.zy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class VerticalTabLayout extends ScrollView {
    public static final up0 O = new up0(16);
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final ArrayList E;
    public q4 F;
    public ValueAnimator G;
    public mg1 H;
    public xo0 I;
    public d10 J;
    public c41 K;
    public w31 L;
    public boolean M;
    public final tp0 N;
    public final ArrayList b;
    public ze1 c;
    public final RectF d;
    public final ye1 e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public ColorStateList k;
    public ColorStateList l;
    public ColorStateList m;
    public Drawable n;
    public final PorterDuff.Mode o;
    public final float p;
    public final float q;
    public final int r;
    public int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public int x;
    public final int y;
    public int z;

    public VerticalTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.tabStyle);
        this.b = new ArrayList();
        this.d = new RectF();
        this.s = Integer.MAX_VALUE;
        this.E = new ArrayList();
        this.N = new tp0(12);
        setVerticalScrollBarEnabled(false);
        ye1 ye1Var = new ye1(this, context);
        this.e = ye1Var;
        super.addView(ye1Var, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayE = f01.E(context, attributeSet, ms0.f, R.attr.tabStyle, R.style.Widget_Design_TabLayout, 24);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            ik0 ik0Var = new ik0();
            ik0Var.k(ColorStateList.valueOf(colorDrawable.getColor()));
            ik0Var.i(context);
            WeakHashMap weakHashMap = uf1.a;
            ik0Var.j(lf1.e(this));
            setBackground(ik0Var);
        }
        int dimensionPixelSize = typedArrayE.getDimensionPixelSize(11, -1);
        if (ye1Var.b != dimensionPixelSize) {
            ye1Var.b = dimensionPixelSize;
            WeakHashMap weakHashMap2 = uf1.a;
            ye1Var.postInvalidateOnAnimation();
        }
        int color = typedArrayE.getColor(8, 0);
        Paint paint = ye1Var.c;
        if (paint.getColor() != color) {
            paint.setColor(color);
            WeakHashMap weakHashMap3 = uf1.a;
            ye1Var.postInvalidateOnAnimation();
        }
        setSelectedTabIndicator(yb0.j(context, typedArrayE, 5));
        setSelectedTabIndicatorGravity(typedArrayE.getInt(10, 0));
        setTabIndicatorFullWidth(typedArrayE.getBoolean(9, true));
        int dimensionPixelSize2 = typedArrayE.getDimensionPixelSize(16, 0);
        this.i = dimensionPixelSize2;
        this.h = dimensionPixelSize2;
        this.g = dimensionPixelSize2;
        this.f = dimensionPixelSize2;
        this.f = typedArrayE.getDimensionPixelSize(19, dimensionPixelSize2);
        this.h = typedArrayE.getDimensionPixelSize(18, dimensionPixelSize2);
        this.g = typedArrayE.getDimensionPixelSize(20, dimensionPixelSize2);
        this.i = typedArrayE.getDimensionPixelSize(17, dimensionPixelSize2);
        int resourceId = typedArrayE.getResourceId(24, R.style.TextAppearance_Design_Tab);
        this.j = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId, ms0.g);
        try {
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.k = yb0.i(context, typedArrayObtainStyledAttributes, 3);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayE.hasValue(25)) {
                this.k = yb0.i(context, typedArrayE, 25);
            }
            if (typedArrayE.hasValue(23)) {
                this.k = new ColorStateList(new int[][]{ScrollView.SELECTED_STATE_SET, ScrollView.EMPTY_STATE_SET}, new int[]{typedArrayE.getColor(23, 0), this.k.getDefaultColor()});
            }
            this.l = yb0.i(context, typedArrayE, 3);
            this.o = i1.J(typedArrayE.getInt(4, -1), null);
            this.m = yb0.i(context, typedArrayE, 21);
            this.y = 300;
            this.t = typedArrayE.getDimensionPixelSize(14, -1);
            this.u = typedArrayE.getDimensionPixelSize(13, -1);
            this.r = typedArrayE.getResourceId(0, 0);
            this.w = typedArrayE.getDimensionPixelSize(1, 0);
            this.A = typedArrayE.getInt(15, 1);
            this.x = typedArrayE.getInt(2, 0);
            this.B = typedArrayE.getBoolean(12, false);
            this.D = false;
            typedArrayE.recycle();
            Resources resources = getResources();
            this.q = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            e();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultWidth() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ze1 ze1Var = (ze1) arrayList.get(i);
            if (ze1Var != null && ze1Var.a != null && !TextUtils.isEmpty(ze1Var.b)) {
                return !this.B ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinHeight() {
        int i = this.t;
        if (i != -1) {
            return i;
        }
        int i2 = this.A;
        if (i2 == 0 || i2 == 2) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.e.getHeight() - getHeight()) - getPaddingTop()) - getPaddingBottom());
    }

    private void setSelectedTabView(int i) {
        ye1 ye1Var = this.e;
        int childCount = ye1Var.getChildCount();
        if (i < 0 || i >= childCount) {
            return;
        }
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = ye1Var.getChildAt(i2);
            boolean z = true;
            childAt.setSelected(i2 == i);
            if (i2 != i) {
                z = false;
            }
            childAt.setActivated(z);
            i2++;
        }
    }

    public final void a(ze1 ze1Var) {
        b(ze1Var, this.b.isEmpty());
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View view) {
        c(view);
    }

    public final void b(ze1 ze1Var, boolean z) {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        if (ze1Var.f != this) {
            zy.n("Tab belongs to a different TabLayout.");
            return;
        }
        ze1Var.d = size;
        arrayList.add(size, ze1Var);
        int size2 = arrayList.size();
        for (int i = size + 1; i < size2; i++) {
            ((ze1) arrayList.get(i)).d = i;
        }
        bf1 bf1Var = ze1Var.g;
        bf1Var.setSelected(false);
        bf1Var.setActivated(false);
        int i2 = ze1Var.d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.A == 1 && this.x == 0) {
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.height = -2;
            layoutParams.weight = 0.0f;
        }
        this.e.addView(bf1Var, i2, layoutParams);
        if (z) {
            VerticalTabLayout verticalTabLayout = ze1Var.f;
            if (verticalTabLayout != null) {
                verticalTabLayout.j(ze1Var, true);
            } else {
                zy.n("Tab not attached to a VerticalTabLayout");
            }
        }
    }

    public final void c(View view) {
        if (!(view instanceof TabItem)) {
            zy.n("Only TabItem instances can be added to TabLayout");
            return;
        }
        TabItem tabItem = (TabItem) view;
        ze1 ze1VarH = h();
        CharSequence charSequence = tabItem.b;
        if (charSequence != null) {
            ze1VarH.b(charSequence);
        }
        Drawable drawable = tabItem.c;
        if (drawable != null) {
            ze1VarH.a = drawable;
            VerticalTabLayout verticalTabLayout = ze1VarH.f;
            if (verticalTabLayout.x == 1 || verticalTabLayout.A == 2) {
                verticalTabLayout.n(true);
            }
            bf1 bf1Var = ze1VarH.g;
            if (bf1Var != null) {
                bf1Var.e();
            }
        }
        int i = tabItem.d;
        if (i != 0) {
            ze1VarH.e = LayoutInflater.from(ze1VarH.g.getContext()).inflate(i, (ViewGroup) ze1VarH.g, false);
            bf1 bf1Var2 = ze1VarH.g;
            if (bf1Var2 != null) {
                bf1Var2.e();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            ze1VarH.c = tabItem.getContentDescription();
            bf1 bf1Var3 = ze1VarH.g;
            if (bf1Var3 != null) {
                bf1Var3.e();
            }
        }
        a(ze1VarH);
    }

    public final void d(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = uf1.a;
            if (isLaidOut()) {
                ye1 ye1Var = this.e;
                int childCount = ye1Var.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (ye1Var.getChildAt(i2).getHeight() > 0) {
                    }
                }
                int scrollY = getScrollY();
                int iF = f(i, 0.0f);
                if (scrollY != iF) {
                    g();
                    this.G.setIntValues(scrollY, iF);
                    this.G.start();
                }
                ye1Var.a(i, this.y);
                return;
            }
        }
        l(i, 0.0f, true, true);
    }

    public final void e() {
        int i = this.A;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.w - this.f) : 0;
        WeakHashMap weakHashMap = uf1.a;
        ye1 ye1Var = this.e;
        ye1Var.setPaddingRelative(0, iMax, 0, 0);
        int i2 = this.A;
        if (i2 == 0) {
            ye1Var.setGravity(8388611);
        } else if (i2 == 1 || i2 == 2) {
            ye1Var.setGravity(1);
        }
        n(true);
    }

    public final int f(int i, float f) {
        int i2 = this.A;
        if (i2 != 0 && i2 != 2) {
            return 0;
        }
        ye1 ye1Var = this.e;
        View childAt = ye1Var.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < ye1Var.getChildCount() ? ye1Var.getChildAt(i3) : null;
        return ((((childAt != null ? childAt.getHeight() : 0) / 2) + childAt.getTop()) - (getHeight() / 2)) + ((int) ((r0 + (childAt2 != null ? childAt2.getHeight() : 0)) * 0.5f * f));
    }

    public final void g() {
        if (this.G == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.G = valueAnimator;
            valueAnimator.setInterpolator(s7.b);
            this.G.setDuration(this.y);
            this.G.addUpdateListener(new o3(3, this));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        ze1 ze1Var = this.c;
        if (ze1Var != null) {
            return ze1Var.d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.l;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    public int getTabMaxHeight() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    public ColorStateList getTabTextColors() {
        return this.k;
    }

    public final ze1 h() {
        ze1 ze1Var = (ze1) O.a();
        if (ze1Var == null) {
            ze1Var = new ze1();
            ze1Var.d = -1;
        }
        ze1Var.f = this;
        tp0 tp0Var = this.N;
        bf1 bf1Var = tp0Var != null ? (bf1) tp0Var.a() : null;
        if (bf1Var == null) {
            bf1Var = new bf1(this, getContext());
        }
        bf1Var.setTab(ze1Var);
        bf1Var.setFocusable(true);
        bf1Var.setMinimumHeight(getTabMinHeight());
        if (TextUtils.isEmpty(ze1Var.c)) {
            bf1Var.setContentDescription(ze1Var.b);
        } else {
            bf1Var.setContentDescription(ze1Var.c);
        }
        ze1Var.g = bf1Var;
        return ze1Var;
    }

    public final void i() {
        ze1 ze1Var;
        int currentItem;
        ye1 ye1Var = this.e;
        int childCount = ye1Var.getChildCount() - 1;
        while (true) {
            ze1Var = null;
            if (childCount < 0) {
                break;
            }
            bf1 bf1Var = (bf1) ye1Var.getChildAt(childCount);
            ye1Var.removeViewAt(childCount);
            if (bf1Var != null) {
                bf1Var.setTab(null);
                bf1Var.setSelected(false);
                this.N.c(bf1Var);
            }
            requestLayout();
            childCount--;
        }
        ArrayList arrayList = this.b;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ze1 ze1Var2 = (ze1) it.next();
            it.remove();
            ze1Var2.f = null;
            ze1Var2.g = null;
            ze1Var2.a = null;
            ze1Var2.b = null;
            ze1Var2.c = null;
            ze1Var2.d = -1;
            ze1Var2.e = null;
            O.c(ze1Var2);
        }
        this.c = null;
        xo0 xo0Var = this.I;
        if (xo0Var != null) {
            int iC = xo0Var.c();
            for (int i = 0; i < iC; i++) {
                ze1 ze1VarH = h();
                ze1VarH.b(this.I.e(i));
                b(ze1VarH, false);
            }
            mg1 mg1Var = this.H;
            if (mg1Var == null || iC <= 0 || (currentItem = mg1Var.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            if (currentItem >= 0 && currentItem < getTabCount()) {
                ze1Var = (ze1) arrayList.get(currentItem);
            }
            j(ze1Var, true);
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public final void j(ze1 ze1Var, boolean z) {
        ze1 ze1Var2 = this.c;
        ArrayList arrayList = this.E;
        if (ze1Var2 == ze1Var) {
            if (ze1Var2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((q4) arrayList.get(size)).getClass();
                }
                d(ze1Var.d);
                return;
            }
            return;
        }
        int i = ze1Var != null ? ze1Var.d : -1;
        if (z) {
            if ((ze1Var2 == null || ze1Var2.d == -1) && i != -1) {
                l(i, 0.0f, true, true);
            } else {
                d(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        }
        this.c = ze1Var;
        if (ze1Var2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((q4) arrayList.get(size2)).getClass();
            }
        }
        if (ze1Var != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                q4 q4Var = (q4) arrayList.get(size3);
                switch (q4Var.a) {
                    case 0:
                        AdvancedTriggerActivity advancedTriggerActivity = (AdvancedTriggerActivity) q4Var.b;
                        int i2 = ze1Var.d;
                        int i3 = AdvancedTriggerActivity.H;
                        advancedTriggerActivity.G(i2);
                        break;
                    case 1:
                        ((ma1) q4Var.b).h0(ze1Var.d);
                        break;
                    default:
                        ((mg1) q4Var.b).setCurrentItem(ze1Var.d);
                        break;
                }
            }
        }
    }

    public final void k(xo0 xo0Var, boolean z) {
        d10 d10Var;
        xo0 xo0Var2 = this.I;
        if (xo0Var2 != null && (d10Var = this.J) != null) {
            xo0Var2.o(d10Var);
        }
        this.I = xo0Var;
        if (z && xo0Var != null) {
            if (this.J == null) {
                this.J = new d10(4, this);
            }
            xo0Var.j(this.J);
        }
        i();
    }

    public final void l(int i, float f, boolean z, boolean z2) {
        int iRound = Math.round(i + f);
        if (iRound >= 0) {
            ye1 ye1Var = this.e;
            if (iRound >= ye1Var.getChildCount()) {
                return;
            }
            if (z2) {
                ValueAnimator valueAnimator = ye1Var.i;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    ye1Var.i.cancel();
                }
                ye1Var.e = i;
                ye1Var.f = f;
                ye1Var.c();
            }
            ValueAnimator valueAnimator2 = this.G;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.G.cancel();
            }
            scrollTo(f(i, f), 0);
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void m(mg1 mg1Var, boolean z) {
        ArrayList arrayList;
        mg1 mg1Var2 = this.H;
        if (mg1Var2 != null) {
            c41 c41Var = this.K;
            if (c41Var != null) {
                FadeableViewPager fadeableViewPager = (FadeableViewPager) mg1Var2;
                c10 c10Var = new c10(fadeableViewPager, c41Var);
                ArrayList arrayList2 = fadeableViewPager.U;
                if (arrayList2 != null) {
                    arrayList2.remove(c10Var);
                }
            }
            w31 w31Var = this.L;
            if (w31Var != null && (arrayList = this.H.W) != null) {
                arrayList.remove(w31Var);
            }
        }
        q4 q4Var = this.F;
        ArrayList arrayList3 = this.E;
        if (q4Var != null) {
            arrayList3.remove(q4Var);
            this.F = null;
        }
        if (mg1Var != null) {
            this.H = mg1Var;
            if (this.K == null) {
                this.K = new c41(this);
            }
            c41 c41Var2 = this.K;
            c41Var2.e = 0;
            c41Var2.d = 0;
            mg1Var.b(c41Var2);
            q4 q4Var2 = new q4(2, mg1Var);
            this.F = q4Var2;
            if (!arrayList3.contains(q4Var2)) {
                arrayList3.add(q4Var2);
            }
            xo0 adapter = mg1Var.getAdapter();
            if (adapter != null) {
                k(adapter, true);
            }
            if (this.L == null) {
                this.L = new w31(this, 1);
            }
            w31 w31Var2 = this.L;
            w31Var2.b = true;
            if (mg1Var.W == null) {
                mg1Var.W = new ArrayList();
            }
            mg1Var.W.add(w31Var2);
            l(mg1Var.getCurrentItem(), 0.0f, true, true);
        } else {
            this.H = null;
            k(null, false);
        }
        this.M = z;
    }

    public final void n(boolean z) {
        int i = 0;
        while (true) {
            ye1 ye1Var = this.e;
            if (i >= ye1Var.getChildCount()) {
                return;
            }
            View childAt = ye1Var.getChildAt(i);
            childAt.setMinimumHeight(getTabMinHeight());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.A == 1 && this.x == 0) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.height = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ik0) {
            fc0.O(this, (ik0) background);
        }
        if (this.H == null) {
            ViewParent parent = getParent();
            if (parent instanceof mg1) {
                m((mg1) parent, true);
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.M) {
            setupWithViewPager(null);
            this.M = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        bf1 bf1Var;
        Drawable drawable;
        ye1 ye1Var = this.e;
        int childCount = ye1Var.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ye1Var.getChildAt(i);
            if ((childAt instanceof bf1) && (drawable = (bf1Var = (bf1) childAt).j) != null) {
                drawable.setBounds(bf1Var.getLeft(), bf1Var.getTop(), bf1Var.getRight(), bf1Var.getBottom());
                bf1Var.j.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultWidth()
            float r0 = defpackage.i1.p(r0, r1)
            int r0 = (int) r0
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2b
            if (r1 == 0) goto L1c
            goto L3e
        L1c:
            int r7 = r6.getPaddingLeft()
            int r7 = r7 + r0
            int r0 = r6.getPaddingRight()
            int r0 = r0 + r7
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L3e
        L2b:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L3e
            int r1 = android.view.View.MeasureSpec.getSize(r7)
            if (r1 < r0) goto L3e
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumWidth(r0)
        L3e:
            int r0 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            if (r1 == 0) goto L5c
            int r1 = r6.u
            if (r1 <= 0) goto L4d
            goto L5a
        L4d:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = defpackage.i1.p(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5a:
            r6.s = r1
        L5c:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto La7
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.A
            if (r0 == 0) goto L7f
            if (r0 == r5) goto L73
            r1 = 2
            if (r0 == r1) goto L7f
            goto La7
        L73:
            int r0 = r7.getMeasuredHeight()
            int r1 = r6.getMeasuredHeight()
            if (r0 == r1) goto L7e
            goto L89
        L7e:
            return
        L7f:
            int r0 = r7.getMeasuredHeight()
            int r1 = r6.getMeasuredHeight()
            if (r0 >= r1) goto La7
        L89:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quickcursor.android.views.VerticalTabLayout.onMeasure(int, int):void");
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
        if (this.B == z) {
            return;
        }
        this.B = z;
        int i = 0;
        while (true) {
            ye1 ye1Var = this.e;
            if (i >= ye1Var.getChildCount()) {
                e();
                return;
            }
            View childAt = ye1Var.getChildAt(i);
            if (childAt instanceof bf1) {
                bf1 bf1Var = (bf1) childAt;
                bf1Var.setOrientation(!bf1Var.l.B ? 1 : 0);
                TextView textView = bf1Var.h;
                if (textView == null && bf1Var.i == null) {
                    bf1Var.g(bf1Var.c, bf1Var.d);
                } else {
                    bf1Var.g(textView, bf1Var.i);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.G.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(tk0.j(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        ye1 ye1Var = this.e;
        Paint paint = ye1Var.c;
        if (paint.getColor() != i) {
            paint.setColor(i);
            WeakHashMap weakHashMap = uf1.a;
            ye1Var.postInvalidateOnAnimation();
        }
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.z != i) {
            this.z = i;
            WeakHashMap weakHashMap = uf1.a;
            this.e.postInvalidateOnAnimation();
        }
    }

    public void setTabGravity(int i) {
        if (this.x != i) {
            this.x = i;
            e();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            ArrayList arrayList = this.b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bf1 bf1Var = ((ze1) arrayList.get(i)).g;
                if (bf1Var != null) {
                    bf1Var.e();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(xy0.p(getContext(), i));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.C = z;
        WeakHashMap weakHashMap = uf1.a;
        this.e.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.A) {
            this.A = i;
            e();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.m == colorStateList) {
            return;
        }
        this.m = colorStateList;
        int i = 0;
        while (true) {
            ye1 ye1Var = this.e;
            if (i >= ye1Var.getChildCount()) {
                return;
            }
            View childAt = ye1Var.getChildAt(i);
            if (childAt instanceof bf1) {
                Context context = getContext();
                int i2 = bf1.m;
                ((bf1) childAt).f(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(xy0.p(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            ArrayList arrayList = this.b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bf1 bf1Var = ((ze1) arrayList.get(i)).g;
                if (bf1Var != null) {
                    bf1Var.e();
                }
            }
        }
    }

    public void setUnboundedRipple(boolean z) {
        if (this.D != z) {
            this.D = z;
            ye1 ye1Var = this.e;
            int childCount = ye1Var.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ye1Var.getChildAt(i);
                if (childAt instanceof bf1) {
                    Context context = getContext();
                    int i2 = bf1.m;
                    ((bf1) childAt).f(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(mg1 mg1Var) {
        m(mg1Var, false);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        c(view);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.n != drawable) {
            this.n = drawable;
            WeakHashMap weakHashMap = uf1.a;
            this.e.postInvalidateOnAnimation();
        }
    }
}
