package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y9 extends Spinner {
    public static final int[] j = {R.attr.spinnerMode};
    public final m4 b;
    public final Context c;
    public final o9 d;
    public SpinnerAdapter e;
    public final boolean f;
    public final x9 g;
    public int h;
    public final Rect i;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y9(android.content.Context r13, android.util.AttributeSet r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y9.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.i;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        x9 x9Var = this.g;
        return x9Var != null ? x9Var.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        x9 x9Var = this.g;
        return x9Var != null ? x9Var.n() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.g != null ? this.h : super.getDropDownWidth();
    }

    public final x9 getInternalPopup() {
        return this.g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        x9 x9Var = this.g;
        return x9Var != null ? x9Var.a() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        x9 x9Var = this.g;
        return x9Var != null ? x9Var.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.i();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x9 x9Var = this.g;
        if (x9Var == null || !x9Var.b()) {
            return;
        }
        x9Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        w9 w9Var = (w9) parcelable;
        super.onRestoreInstanceState(w9Var.getSuperState());
        if (!w9Var.b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new p9(0, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        w9 w9Var = new w9(super.onSaveInstanceState());
        x9 x9Var = this.g;
        w9Var.b = x9Var != null && x9Var.b();
        return w9Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        o9 o9Var = this.d;
        if (o9Var == null || !o9Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        x9 x9Var = this.g;
        if (x9Var == null) {
            return super.performClick();
        }
        if (x9Var.b()) {
            return true;
        }
        x9Var.m(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        x9 x9Var = this.g;
        if (x9Var != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            s9 s9Var = new s9();
            s9Var.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                s9Var.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                q9.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            x9Var.p(s9Var);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.n(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        x9 x9Var = this.g;
        if (x9Var == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            x9Var.k(i);
            x9Var.l(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        x9 x9Var = this.g;
        if (x9Var != null) {
            x9Var.j(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        x9 x9Var = this.g;
        if (x9Var != null) {
            x9Var.g(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(tk0.j(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        x9 x9Var = this.g;
        if (x9Var != null) {
            x9Var.e(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.t(mode);
        }
    }
}
