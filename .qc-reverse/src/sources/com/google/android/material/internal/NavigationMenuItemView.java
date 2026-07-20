package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import defpackage.cl0;
import defpackage.ew0;
import defpackage.fc0;
import defpackage.lg0;
import defpackage.ql0;
import defpackage.uf1;
import defpackage.xj;
import defpackage.y20;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends y20 implements ql0 {
    public static final int[] H = {R.attr.state_checked};
    public final CheckedTextView A;
    public FrameLayout B;
    public cl0 C;
    public ColorStateList D;
    public boolean E;
    public Drawable F;
    public final xj G;
    public int w;
    public boolean x;
    public boolean y;
    public final boolean z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = true;
        xj xjVar = new xj(3, this);
        this.G = xjVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.quickcursor.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.quickcursor.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.quickcursor.R.id.design_menu_item_text);
        this.A = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        uf1.n(checkedTextView, xjVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.B == null) {
                this.B = (FrameLayout) ((ViewStub) findViewById(com.quickcursor.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.B.removeAllViews();
            this.B.addView(view);
        }
    }

    @Override // defpackage.ql0
    public final void c(cl0 cl0Var) {
        StateListDrawable stateListDrawable;
        this.C = cl0Var;
        int i = cl0Var.a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(cl0Var.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.quickcursor.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(H, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = uf1.a;
            setBackground(stateListDrawable);
        }
        setCheckable(cl0Var.isCheckable());
        setChecked(cl0Var.isChecked());
        setEnabled(cl0Var.isEnabled());
        setTitle(cl0Var.e);
        setIcon(cl0Var.getIcon());
        setActionView(cl0Var.getActionView());
        setContentDescription(cl0Var.q);
        fc0.P(this, cl0Var.r);
        cl0 cl0Var2 = this.C;
        CharSequence charSequence = cl0Var2.e;
        CheckedTextView checkedTextView = this.A;
        if (charSequence == null && cl0Var2.getIcon() == null && this.C.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                lg0 lg0Var = (lg0) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) lg0Var).width = -1;
                this.B.setLayoutParams(lg0Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.B;
        if (frameLayout2 != null) {
            lg0 lg0Var2 = (lg0) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) lg0Var2).width = -2;
            this.B.setLayoutParams(lg0Var2);
        }
    }

    @Override // defpackage.ql0
    public cl0 getItemData() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        cl0 cl0Var = this.C;
        if (cl0Var != null && cl0Var.isCheckable() && this.C.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.G.h(this.A, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.A;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.z) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.E) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.D);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.F == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = ew0.a;
                Drawable drawable2 = resources.getDrawable(com.quickcursor.R.drawable.navigation_empty_icon, theme);
                this.F = drawable2;
                if (drawable2 != null) {
                    int i2 = this.w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.F;
        }
        this.A.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.A.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.w = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.D = colorStateList;
        this.E = colorStateList != null;
        cl0 cl0Var = this.C;
        if (cl0Var != null) {
            setIcon(cl0Var.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.A.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.x = z;
    }

    public void setTextAppearance(int i) {
        this.A.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.A.setText(charSequence);
    }
}
