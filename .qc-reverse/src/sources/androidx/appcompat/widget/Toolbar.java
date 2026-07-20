package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.quickcursor.R;
import defpackage.a2;
import defpackage.b71;
import defpackage.cl0;
import defpackage.e9;
import defpackage.fc0;
import defpackage.h1;
import defpackage.l1;
import defpackage.m31;
import defpackage.nc;
import defpackage.r61;
import defpackage.ra;
import defpackage.s30;
import defpackage.s61;
import defpackage.t61;
import defpackage.tk0;
import defpackage.u61;
import defpackage.uf1;
import defpackage.v61;
import defpackage.vg1;
import defpackage.w61;
import defpackage.x61;
import defpackage.xg;
import defpackage.xw0;
import defpackage.y61;
import defpackage.yr;
import defpackage.zk0;
import defpackage.zs0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList E;
    public final ArrayList F;
    public final int[] G;
    public final ra H;
    public ArrayList I;
    public w61 J;
    public final s61 K;
    public b71 L;
    public a2 M;
    public u61 N;
    public xg O;
    public y61 P;
    public boolean Q;
    public OnBackInvokedCallback R;
    public OnBackInvokedDispatcher S;
    public boolean T;
    public final nc U;
    public ActionMenuView b;
    public AppCompatTextView c;
    public AppCompatTextView d;
    public e9 e;
    public AppCompatImageView f;
    public final Drawable g;
    public final CharSequence h;
    public e9 i;
    public View j;
    public Context k;
    public int l;
    public int m;
    public int n;
    public final int o;
    public final int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public xw0 u;
    public int v;
    public int w;
    public final int x;
    public CharSequence y;
    public CharSequence z;

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new ra(new r61(this, 1));
        this.I = new ArrayList();
        this.K = new s61(this);
        this.U = new nc(18, this);
        Context context2 = getContext();
        int[] iArr = zs0.x;
        ra raVarM = ra.M(context2, attributeSet, iArr, R.attr.toolbarStyle);
        uf1.m(this, context, iArr, attributeSet, (TypedArray) raVarM.c, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) raVarM.c;
        this.m = typedArray.getResourceId(28, 0);
        this.n = typedArray.getResourceId(19, 0);
        this.x = typedArray.getInteger(0, 8388627);
        this.o = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.t = dimensionPixelOffset;
        this.s = dimensionPixelOffset;
        this.r = dimensionPixelOffset;
        this.q = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.q = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.r = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.s = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.t = dimensionPixelOffset5;
        }
        this.p = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        xw0 xw0Var = this.u;
        xw0Var.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            xw0Var.e = dimensionPixelSize;
            xw0Var.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            xw0Var.f = dimensionPixelSize2;
            xw0Var.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            xw0Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.v = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.w = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.g = raVarM.y(4);
        this.h = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.k = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableY = raVarM.y(16);
        if (drawableY != null) {
            setNavigationIcon(drawableY);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableY2 = raVarM.y(11);
        if (drawableY2 != null) {
            setLogo(drawableY2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(raVarM.x(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(raVarM.x(20));
        }
        if (typedArray.hasValue(14)) {
            m(typedArray.getResourceId(14, 0));
        }
        raVarM.O();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new m31(getContext());
    }

    public static v61 h() {
        v61 v61Var = new v61();
        v61Var.b = 0;
        v61Var.a = 8388627;
        return v61Var;
    }

    public static v61 i(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof v61) {
            v61 v61Var = (v61) layoutParams;
            v61 v61Var2 = new v61(v61Var);
            v61Var2.b = 0;
            v61Var2.b = v61Var.b;
            return v61Var2;
        }
        if (layoutParams instanceof h1) {
            v61 v61Var3 = new v61((h1) layoutParams);
            v61Var3.b = 0;
            return v61Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            v61 v61Var4 = new v61(layoutParams);
            v61Var4.b = 0;
            return v61Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        v61 v61Var5 = new v61(marginLayoutParams);
        v61Var5.b = 0;
        ((ViewGroup.MarginLayoutParams) v61Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) v61Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) v61Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) v61Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return v61Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                v61 v61Var = (v61) childAt.getLayoutParams();
                if (v61Var.b == 0 && u(childAt)) {
                    int i3 = v61Var.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            v61 v61Var2 = (v61) childAt2.getLayoutParams();
            if (v61Var2.b == 0 && u(childAt2)) {
                int i5 = v61Var2.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        v61 v61VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (v61) layoutParams;
        v61VarH.b = 1;
        if (!z || this.j == null) {
            addView(view, v61VarH);
        } else {
            view.setLayoutParams(v61VarH);
            this.F.add(view);
        }
    }

    public final void c() {
        if (this.i == null) {
            e9 e9Var = new e9(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.i = e9Var;
            e9Var.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            v61 v61VarH = h();
            v61VarH.a = (this.o & 112) | 8388611;
            v61VarH.b = 2;
            this.i.setLayoutParams(v61VarH);
            this.i.setOnClickListener(new l1(7, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof v61);
    }

    public final void d() {
        if (this.u == null) {
            xw0 xw0Var = new xw0();
            xw0Var.a = 0;
            xw0Var.b = 0;
            xw0Var.c = Integer.MIN_VALUE;
            xw0Var.d = Integer.MIN_VALUE;
            xw0Var.e = 0;
            xw0Var.f = 0;
            xw0Var.g = false;
            xw0Var.h = false;
            this.u = xw0Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.b;
        if (actionMenuView.q == null) {
            zk0 zk0Var = (zk0) actionMenuView.getMenu();
            if (this.N == null) {
                this.N = new u61(this);
            }
            this.b.setExpandedActionViewsExclusive(true);
            zk0Var.b(this.N, this.k);
            w();
        }
    }

    public final void f() {
        if (this.b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.b = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.b.setOnMenuItemClickListener(this.K);
            ActionMenuView actionMenuView2 = this.b;
            xg xgVar = this.O;
            s61 s61Var = new s61(this);
            actionMenuView2.v = xgVar;
            actionMenuView2.w = s61Var;
            v61 v61VarH = h();
            v61VarH.a = (this.o & 112) | 8388613;
            this.b.setLayoutParams(v61VarH);
            b(this.b, false);
        }
    }

    public final void g() {
        if (this.e == null) {
            this.e = new e9(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            v61 v61VarH = h();
            v61VarH.a = (this.o & 112) | 8388611;
            this.e.setLayoutParams(v61VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        v61 v61Var = new v61(context, attributeSet);
        v61Var.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.b);
        v61Var.a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        v61Var.b = 0;
        return v61Var;
    }

    public CharSequence getCollapseContentDescription() {
        e9 e9Var = this.i;
        if (e9Var != null) {
            return e9Var.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        e9 e9Var = this.i;
        if (e9Var != null) {
            return e9Var.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        xw0 xw0Var = this.u;
        if (xw0Var != null) {
            return xw0Var.g ? xw0Var.a : xw0Var.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.w;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        xw0 xw0Var = this.u;
        if (xw0Var != null) {
            return xw0Var.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        xw0 xw0Var = this.u;
        if (xw0Var != null) {
            return xw0Var.b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        xw0 xw0Var = this.u;
        if (xw0Var != null) {
            return xw0Var.g ? xw0Var.b : xw0Var.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        zk0 zk0Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (zk0Var = actionMenuView.q) == null || !zk0Var.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.b.getMenu();
    }

    public View getNavButtonView() {
        return this.e;
    }

    public CharSequence getNavigationContentDescription() {
        e9 e9Var = this.e;
        if (e9Var != null) {
            return e9Var.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        e9 e9Var = this.e;
        if (e9Var != null) {
            return e9Var.getDrawable();
        }
        return null;
    }

    public a2 getOuterActionMenuPresenter() {
        return this.M;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.b.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.k;
    }

    public int getPopupTheme() {
        return this.l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.d;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public final TextView getTitleTextView() {
        return this.c;
    }

    public yr getWrapper() {
        if (this.L == null) {
            this.L = new b71(this, true);
        }
        return this.L;
    }

    public final int j(View view, int i) {
        v61 v61Var = (v61) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = v61Var.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.x & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) v61Var).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) v61Var).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) v61Var).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    public void m(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final void n() {
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.H.e).iterator();
        while (it.hasNext()) {
            ((s30) it.next()).a.k();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        w();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.D = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0285 A[LOOP:0: B:107:0x0283->B:108:0x0285, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029d A[LOOP:1: B:110:0x029b->B:111:0x029d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bd A[LOOP:2: B:113:0x02bb->B:114:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0310 A[LOOP:3: B:122:0x030e->B:123:0x0310, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        Object[] objArr;
        int iK;
        int iMax;
        int iCombineMeasuredStates;
        int iK2;
        int iL;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z = vg1.a;
        int i3 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c = 0;
        } else {
            c = 1;
            objArr = false;
        }
        if (u(this.e)) {
            t(this.e, i, 0, i2, this.p);
            iK = k(this.e) + this.e.getMeasuredWidth();
            iMax = Math.max(0, l(this.e) + this.e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.e.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (u(this.i)) {
            t(this.i, i, 0, i2, this.p);
            iK = k(this.i) + this.i.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.i) + this.i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.G;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (u(this.b)) {
            t(this.b, i, iMax3, i2, this.p);
            iK2 = k(this.b) + this.b.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.b) + this.b.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c] = Math.max(0, currentContentInsetEnd - iK2);
        if (u(this.j)) {
            iMax5 += s(this.j, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, l(this.j) + this.j.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.j.getMeasuredState());
        }
        if (u(this.f)) {
            iMax5 += s(this.f, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, l(this.f) + this.f.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((v61) childAt.getLayoutParams()).b == 0 && u(childAt)) {
                iMax5 += s(childAt, i, iMax5, i2, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i5 = iMax5;
        int i6 = this.s + this.t;
        int i7 = this.q + this.r;
        if (u(this.c)) {
            s(this.c, i, i5 + i7, i2, i6, iArr);
            int iK3 = k(this.c) + this.c.getMeasuredWidth();
            iL = l(this.c) + this.c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.c.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (u(this.d)) {
            iMax2 = Math.max(iMax2, s(this.d, i, i5 + i7, i2, i6 + iL, iArr));
            iL += l(this.d) + this.d.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.d.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i5 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (!this.Q) {
            i3 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            View childAt2 = getChildAt(i8);
            if (u(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i3 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof x61)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x61 x61Var = (x61) parcelable;
        super.onRestoreInstanceState(x61Var.b);
        ActionMenuView actionMenuView = this.b;
        zk0 zk0Var = actionMenuView != null ? actionMenuView.q : null;
        int i = x61Var.d;
        if (i != 0 && this.N != null && zk0Var != null && (menuItemFindItem = zk0Var.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (x61Var.e) {
            nc ncVar = this.U;
            removeCallbacks(ncVar);
            post(ncVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        xw0 xw0Var = this.u;
        boolean z = i == 1;
        if (z == xw0Var.g) {
            return;
        }
        xw0Var.g = z;
        if (!xw0Var.h) {
            xw0Var.a = xw0Var.e;
            xw0Var.b = xw0Var.f;
            return;
        }
        if (z) {
            int i2 = xw0Var.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = xw0Var.e;
            }
            xw0Var.a = i2;
            int i3 = xw0Var.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = xw0Var.f;
            }
            xw0Var.b = i3;
            return;
        }
        int i4 = xw0Var.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = xw0Var.e;
        }
        xw0Var.a = i4;
        int i5 = xw0Var.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = xw0Var.f;
        }
        xw0Var.b = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        cl0 cl0Var;
        x61 x61Var = new x61(super.onSaveInstanceState());
        u61 u61Var = this.N;
        if (u61Var != null && (cl0Var = u61Var.c) != null) {
            x61Var.d = cl0Var.a;
        }
        x61Var.e = p();
        return x61Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    public final boolean p() {
        a2 a2Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (a2Var = actionMenuView.u) == null || !a2Var.h()) ? false : true;
    }

    public final int q(View view, int i, int i2, int[] iArr) {
        v61 v61Var = (v61) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) v61Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int iJ = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) v61Var).rightMargin + iMax;
    }

    public final int r(View view, int i, int i2, int[] iArr) {
        v61 v61Var = (v61) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) v61Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iJ = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) v61Var).leftMargin);
    }

    public final int s(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.T != z) {
            this.T = z;
            w();
        }
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        e9 e9Var = this.i;
        if (e9Var != null) {
            e9Var.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.i.setImageDrawable(drawable);
        } else {
            e9 e9Var = this.i;
            if (e9Var != null) {
                e9Var.setImageDrawable(this.g);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.Q = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.f;
        if (drawable != null) {
            if (appCompatImageView == null) {
                this.f = new AppCompatImageView(getContext(), null);
            }
            if (!o(this.f)) {
                b(this.f, true);
            }
        } else if (appCompatImageView != null && o(appCompatImageView)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        AppCompatImageView appCompatImageView2 = this.f;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f == null) {
            this.f = new AppCompatImageView(getContext(), null);
        }
        AppCompatImageView appCompatImageView = this.f;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        e9 e9Var = this.e;
        if (e9Var != null) {
            e9Var.setContentDescription(charSequence);
            fc0.P(this.e, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.e)) {
                b(this.e, true);
            }
        } else {
            e9 e9Var = this.e;
            if (e9Var != null && o(e9Var)) {
                removeView(this.e);
                this.F.remove(this.e);
            }
        }
        e9 e9Var2 = this.e;
        if (e9Var2 != null) {
            e9Var2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(w61 w61Var) {
        this.J = w61Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.l != i) {
            this.l = i;
            if (i == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.d;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.d = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.n;
                if (i != 0) {
                    this.d.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.d.setTextColor(colorStateList);
                }
            }
            if (!o(this.d)) {
                b(this.d, true);
            }
        } else if (appCompatTextView != null && o(appCompatTextView)) {
            removeView(this.d);
            this.F.remove(this.d);
        }
        AppCompatTextView appCompatTextView3 = this.d;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        AppCompatTextView appCompatTextView = this.d;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.c;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!o(this.c)) {
                b(this.c, true);
            }
        } else if (appCompatTextView != null && o(appCompatTextView)) {
            removeView(this.c);
            this.F.remove(this.c);
        }
        AppCompatTextView appCompatTextView3 = this.c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        AppCompatTextView appCompatTextView = this.c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public final void t(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean v() {
        a2 a2Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (a2Var = actionMenuView.u) == null || !a2Var.l()) ? false : true;
    }

    public final void w() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = t61.a(this);
            u61 u61Var = this.N;
            int i = 0;
            boolean z = (u61Var == null || u61Var.c == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.T) ? false : true;
            if (z && this.S == null) {
                if (this.R == null) {
                    this.R = t61.b(new r61(this, i));
                }
                t61.c(onBackInvokedDispatcherA, this.R);
                this.S = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.S) == null) {
                return;
            }
            t61.d(onBackInvokedDispatcher, this.R);
            this.S = null;
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(tk0.j(getContext(), i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(tk0.j(getContext(), i));
    }

    public void setLogo(int i) {
        setLogo(tk0.j(getContext(), i));
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
