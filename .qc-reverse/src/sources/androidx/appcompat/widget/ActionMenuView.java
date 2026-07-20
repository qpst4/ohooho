package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import defpackage.a2;
import defpackage.b2;
import defpackage.c2;
import defpackage.cl0;
import defpackage.d2;
import defpackage.ix;
import defpackage.lg0;
import defpackage.ol0;
import defpackage.rl0;
import defpackage.sp1;
import defpackage.vg1;
import defpackage.x1;
import defpackage.xg;
import defpackage.xk0;
import defpackage.yk0;
import defpackage.z1;
import defpackage.zk0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements yk0, rl0 {
    public final int A;
    public d2 B;
    public zk0 q;
    public Context r;
    public int s;
    public boolean t;
    public a2 u;
    public xg v;
    public xk0 w;
    public boolean x;
    public int y;
    public final int z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f);
        this.A = (int) (f * 4.0f);
        this.r = context;
        this.s = 0;
    }

    public static c2 j() {
        c2 c2Var = new c2(-2, -2);
        c2Var.a = false;
        ((LinearLayout.LayoutParams) c2Var).gravity = 16;
        return c2Var;
    }

    public static c2 k(ViewGroup.LayoutParams layoutParams) {
        c2 c2Var;
        if (layoutParams == null) {
            return j();
        }
        if (layoutParams instanceof c2) {
            c2 c2Var2 = (c2) layoutParams;
            c2Var = new c2(c2Var2);
            c2Var.a = c2Var2.a;
        } else {
            c2Var = new c2(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c2Var).gravity <= 0) {
            ((LinearLayout.LayoutParams) c2Var).gravity = 16;
        }
        return c2Var;
    }

    @Override // defpackage.yk0
    public final boolean a(cl0 cl0Var) {
        return this.q.q(cl0Var, null, 0);
    }

    @Override // defpackage.rl0
    public final void b(zk0 zk0Var) {
        this.q = zk0Var;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c2;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ lg0 generateDefaultLayoutParams() {
        return j();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: g */
    public final lg0 generateLayoutParams(AttributeSet attributeSet) {
        return new c2(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c2(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            zk0 zk0Var = new zk0(context);
            this.q = zk0Var;
            zk0Var.e = new sp1(3, this);
            a2 a2Var = new a2(context);
            this.u = a2Var;
            a2Var.m = true;
            a2Var.n = true;
            ol0 ixVar = this.v;
            if (ixVar == null) {
                ixVar = new ix(7);
            }
            a2Var.f = ixVar;
            this.q.b(a2Var, this.r);
            a2 a2Var2 = this.u;
            a2Var2.i = this;
            this.q = a2Var2.d;
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        a2 a2Var = this.u;
        z1 z1Var = a2Var.j;
        if (z1Var != null) {
            return z1Var.getDrawable();
        }
        if (a2Var.l) {
            return a2Var.k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ lg0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public final boolean l(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof b2)) {
            zA = ((b2) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof b2)) ? zA : ((b2) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a2 a2Var = this.u;
        if (a2Var != null) {
            a2Var.g();
            if (this.u.h()) {
                this.u.d();
                this.u.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a2 a2Var = this.u;
        if (a2Var != null) {
            a2Var.d();
            x1 x1Var = a2Var.u;
            if (x1Var == null || !x1Var.b()) {
                return;
            }
            x1Var.i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.x) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = vg1.a;
        boolean z3 = getLayoutDirection() == 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c2 c2Var = (c2) childAt.getLayoutParams();
                if (c2Var.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c2Var).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c2Var).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c2Var).leftMargin) + ((LinearLayout.LayoutParams) c2Var).rightMargin;
                    l(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                c2 c2Var2 = (c2) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c2Var2.a) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) c2Var2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c2Var2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            c2 c2Var3 = (c2) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c2Var3.a) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) c2Var3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) c2Var3).rightMargin + iMax + i18;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        ?? r11;
        int i5;
        int i6;
        zk0 zk0Var;
        boolean z = this.x;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.x = z2;
        if (z != z2) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.x && (zk0Var = this.q) != null && size != this.y) {
            this.y = size;
            zk0Var.p(true);
        }
        int childCount = getChildCount();
        if (!this.x || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                c2 c2Var = (c2) getChildAt(i7).getLayoutParams();
                ((LinearLayout.LayoutParams) c2Var).rightMargin = 0;
                ((LinearLayout.LayoutParams) c2Var).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.z;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        boolean z3 = false;
        int i15 = 0;
        long j = 0;
        while (true) {
            i3 = this.A;
            if (i14 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i14);
            int i16 = size3;
            int i17 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i5 = i12;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z4) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                c2 c2Var2 = (c2) childAt.getLayoutParams();
                c2Var2.f = false;
                c2Var2.c = 0;
                c2Var2.b = 0;
                c2Var2.d = false;
                ((LinearLayout.LayoutParams) c2Var2).leftMargin = 0;
                ((LinearLayout.LayoutParams) c2Var2).rightMargin = 0;
                c2Var2.e = z4 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i18 = c2Var2.a ? 1 : i10;
                c2 c2Var3 = (c2) childAt.getLayoutParams();
                int i19 = i10;
                i5 = i12;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i17, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z4 ? (ActionMenuItemView) childAt : null;
                boolean z5 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z6 = z5;
                if (i18 <= 0 || (z5 && i18 < 2)) {
                    i6 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5 * i18, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = measuredWidth / i5;
                    if (measuredWidth % i5 != 0) {
                        i6++;
                    }
                    if (z6 && i6 < 2) {
                        i6 = 2;
                    }
                }
                c2Var3.d = !c2Var3.a && z6;
                c2Var3.b = i6;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i6);
                if (c2Var2.d) {
                    i15++;
                }
                if (c2Var2.a) {
                    z3 = true;
                }
                i10 = i19 - i6;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i6 == 1) {
                    j |= (long) (1 << i14);
                }
            }
            i14++;
            size3 = i16;
            paddingBottom = i17;
            i12 = i5;
        }
        int i20 = size3;
        int i21 = i10;
        int i22 = i12;
        boolean z7 = z3 && i13 == 2;
        int i23 = i21;
        boolean z8 = false;
        while (i15 > 0 && i23 > 0) {
            int i24 = Integer.MAX_VALUE;
            long j2 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i26 < childCount2) {
                int i27 = iMax;
                c2 c2Var4 = (c2) getChildAt(i26).getLayoutParams();
                boolean z9 = z7;
                if (c2Var4.d) {
                    int i28 = c2Var4.b;
                    if (i28 < i24) {
                        j2 = 1 << i26;
                        i24 = i28;
                        i25 = 1;
                    } else if (i28 == i24) {
                        j2 |= 1 << i26;
                        i25++;
                    }
                }
                i26++;
                z7 = z9;
                iMax = i27;
            }
            i4 = iMax;
            boolean z10 = z7;
            j |= j2;
            if (i25 > i23) {
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount2) {
                View childAt2 = getChildAt(i30);
                c2 c2Var5 = (c2) childAt2.getLayoutParams();
                boolean z11 = z3;
                long j3 = 1 << i30;
                if ((j2 & j3) != 0) {
                    if (z10 && c2Var5.e) {
                        r11 = 1;
                        r11 = 1;
                        if (i23 == 1) {
                            childAt2.setPadding(i3 + i22, 0, i3, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    c2Var5.b += r11;
                    c2Var5.f = r11;
                    i23--;
                } else if (c2Var5.b == i29) {
                    j |= j3;
                }
                i30++;
                z3 = z11;
            }
            z7 = z10;
            iMax = i4;
            z8 = true;
        }
        i4 = iMax;
        boolean z12 = !z3 && i13 == 1;
        if (i23 > 0 && j != 0 && (i23 < i13 - 1 || z12 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j);
            if (!z12) {
                if ((j & 1) != 0 && !((c2) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i31 = childCount2 - 1;
                if ((j & ((long) (1 << i31))) != 0 && !((c2) getChildAt(i31).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i32 = fBitCount > 0.0f ? (int) ((i23 * i22) / fBitCount) : 0;
            boolean z13 = z8;
            for (int i33 = 0; i33 < childCount2; i33++) {
                if ((j & ((long) (1 << i33))) != 0) {
                    View childAt3 = getChildAt(i33);
                    c2 c2Var6 = (c2) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c2Var6.c = i32;
                        c2Var6.f = true;
                        if (i33 == 0 && !c2Var6.e) {
                            ((LinearLayout.LayoutParams) c2Var6).leftMargin = (-i32) / 2;
                        }
                        z13 = true;
                    } else if (c2Var6.a) {
                        c2Var6.c = i32;
                        c2Var6.f = true;
                        ((LinearLayout.LayoutParams) c2Var6).rightMargin = (-i32) / 2;
                        z13 = true;
                    } else {
                        if (i33 != 0) {
                            ((LinearLayout.LayoutParams) c2Var6).leftMargin = i32 / 2;
                        }
                        if (i33 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) c2Var6).rightMargin = i32 / 2;
                        }
                    }
                }
            }
            z8 = z13;
        }
        if (z8) {
            for (int i34 = 0; i34 < childCount2; i34++) {
                View childAt4 = getChildAt(i34);
                c2 c2Var7 = (c2) childAt4.getLayoutParams();
                if (c2Var7.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c2Var7.b * i22) + c2Var7.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i8, mode != 1073741824 ? i4 : i20);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.u.r = z;
    }

    public void setOnMenuItemClickListener(d2 d2Var) {
        this.B = d2Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        a2 a2Var = this.u;
        z1 z1Var = a2Var.j;
        if (z1Var != null) {
            z1Var.setImageDrawable(drawable);
        } else {
            a2Var.l = true;
            a2Var.k = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.t = z;
    }

    public void setPopupTheme(int i) {
        if (this.s != i) {
            this.s = i;
            if (i == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(a2 a2Var) {
        this.u = a2Var;
        a2Var.i = this;
        this.q = a2Var.d;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }
}
