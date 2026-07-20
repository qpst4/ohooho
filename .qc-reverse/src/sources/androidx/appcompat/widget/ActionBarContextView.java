package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.a2;
import defpackage.d;
import defpackage.e2;
import defpackage.l1;
import defpackage.ng1;
import defpackage.rl0;
import defpackage.s1;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.vg1;
import defpackage.x1;
import defpackage.zk0;
import defpackage.zs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public final d b;
    public final Context c;
    public ActionMenuView d;
    public a2 e;
    public int f;
    public ng1 g;
    public boolean h;
    public boolean i;
    public CharSequence j;
    public CharSequence k;
    public View l;
    public View m;
    public View n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public final int r;
    public final int s;
    public boolean t;
    public final int u;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.b = new d(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.c = context;
        } else {
            this.c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.d, R.attr.actionModeStyle, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : tk0.j(context, resourceId));
        this.r = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.s = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.u = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(int i, int i2, int i3, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final void c(e2 e2Var) {
        View view = this.l;
        int i = 0;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.u, (ViewGroup) this, false);
            this.l = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.l);
        }
        View viewFindViewById = this.l.findViewById(R.id.action_mode_close_button);
        this.m = viewFindViewById;
        viewFindViewById.setOnClickListener(new l1(i, e2Var));
        zk0 zk0VarC = e2Var.c();
        a2 a2Var = this.e;
        if (a2Var != null) {
            a2Var.d();
            x1 x1Var = a2Var.u;
            if (x1Var != null && x1Var.b()) {
                x1Var.i.dismiss();
            }
        }
        a2 a2Var2 = new a2(getContext());
        this.e = a2Var2;
        a2Var2.m = true;
        a2Var2.n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        zk0VarC.b(this.e, this.c);
        a2 a2Var3 = this.e;
        rl0 rl0Var = a2Var3.i;
        if (rl0Var == null) {
            rl0 rl0Var2 = (rl0) a2Var3.e.inflate(a2Var3.g, (ViewGroup) this, false);
            a2Var3.i = rl0Var2;
            rl0Var2.b(a2Var3.d);
            a2Var3.g();
        }
        rl0 rl0Var3 = a2Var3.i;
        if (rl0Var != rl0Var3) {
            ((ActionMenuView) rl0Var3).setPresenter(a2Var3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) rl0Var3;
        this.d = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.d, layoutParams);
    }

    public final void d() {
        if (this.o == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = linearLayout;
            this.p = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.q = (TextView) this.o.findViewById(R.id.action_bar_subtitle);
            int i = this.r;
            if (i != 0) {
                this.p.setTextAppearance(getContext(), i);
            }
            int i2 = this.s;
            if (i2 != 0) {
                this.q.setTextAppearance(getContext(), i2);
            }
        }
        this.p.setText(this.j);
        this.q.setText(this.k);
        boolean zIsEmpty = TextUtils.isEmpty(this.j);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.k);
        this.q.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.o.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.o.getParent() == null) {
            addView(this.o);
        }
    }

    public final void e() {
        removeAllViews();
        this.n = null;
        this.d = null;
        this.e = null;
        View view = this.m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.b.b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    public CharSequence getSubtitle() {
        return this.k;
    }

    public CharSequence getTitle() {
        return this.j;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            ng1 ng1Var = this.g;
            if (ng1Var != null) {
                ng1Var.b();
            }
            super.setVisibility(i);
        }
    }

    public final ng1 i(int i, long j) {
        ng1 ng1Var = this.g;
        if (ng1Var != null) {
            ng1Var.b();
        }
        d dVar = this.b;
        if (i != 0) {
            ng1 ng1VarA = uf1.a(this);
            ng1VarA.a(0.0f);
            ng1VarA.c(j);
            ((ActionBarContextView) dVar.c).g = ng1VarA;
            dVar.b = i;
            ng1VarA.d(dVar);
            return ng1VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ng1 ng1VarA2 = uf1.a(this);
        ng1VarA2.a(1.0f);
        ng1VarA2.c(j);
        ((ActionBarContextView) dVar.c).g = ng1VarA2;
        dVar.b = i;
        ng1VarA2.d(dVar);
        return ng1VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, zs0.a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        a2 a2Var = this.e;
        if (a2Var != null) {
            Configuration configuration2 = a2Var.c.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            a2Var.q = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            zk0 zk0Var = a2Var.d;
            if (zk0Var != null) {
                zk0Var.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a2 a2Var = this.e;
        if (a2Var != null) {
            a2Var.d();
            x1 x1Var = this.e.u;
            if (x1Var == null || !x1Var.b()) {
                return;
            }
            x1Var.i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.i = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = vg1.a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            int i5 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = z3 ? paddingRight - i5 : paddingRight + i5;
            int iG = g(i7, paddingTop, paddingTop2, this.l, z3) + i7;
            paddingRight = z3 ? iG - i6 : iG + i6;
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(paddingRight, paddingTop, paddingTop2, this.o, z3);
        }
        View view2 = this.n;
        if (view2 != null) {
            g(paddingRight, paddingTop, paddingTop2, view2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null) {
            g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            s1.f(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
            return;
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            s1.f(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.l;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.d, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null) {
            if (this.t) {
                this.o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.o.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.o.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.n;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = i3 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i3 >= 0) {
                paddingLeft = Math.min(i3, paddingLeft);
            }
            int i5 = layoutParams.height;
            int i6 = i5 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i5 >= 0) {
                iMin = Math.min(i5, iMin);
            }
            this.n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(iMin, i6));
        }
        if (this.f > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.h = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.f = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.n;
        if (view2 != null) {
            removeView(view2);
        }
        this.n = view;
        if (view != null && (linearLayout = this.o) != null) {
            removeView(linearLayout);
            this.o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.k = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        d();
        uf1.o(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
