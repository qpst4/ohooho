package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.b2;
import defpackage.cl0;
import defpackage.fc0;
import defpackage.ql0;
import defpackage.v1;
import defpackage.w1;
import defpackage.yk0;
import defpackage.zk0;
import defpackage.zs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements ql0, View.OnClickListener, b2 {
    public cl0 i;
    public CharSequence j;
    public Drawable k;
    public yk0 l;
    public v1 m;
    public w1 n;
    public boolean o;
    public boolean p;
    public final int q;
    public int r;
    public final int s;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.o = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.c, 0, 0);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.s = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.r = -1;
        setSaveEnabled(false);
    }

    @Override // defpackage.b2
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // defpackage.b2
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.i.getIcon() == null;
    }

    @Override // defpackage.ql0
    public final void c(cl0 cl0Var) {
        this.i = cl0Var;
        setIcon(cl0Var.getIcon());
        setTitle(cl0Var.getTitleCondensed());
        setId(cl0Var.a);
        setVisibility(cl0Var.isVisible() ? 0 : 8);
        setEnabled(cl0Var.isEnabled());
        if (cl0Var.hasSubMenu() && this.m == null) {
            this.m = new v1(this);
        }
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // defpackage.ql0
    public cl0 getItemData() {
        return this.i;
    }

    public final void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.j);
        if (this.k != null && ((this.i.y & 4) != 4 || (!this.o && !this.p))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.j : null);
        CharSequence charSequence = this.i.q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.i.e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.i.r;
        if (TextUtils.isEmpty(charSequence2)) {
            fc0.P(this, z3 ? null : this.i.e);
        } else {
            fc0.P(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        yk0 yk0Var = this.l;
        if (yk0Var != null) {
            yk0Var.a(this.i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.o = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.r) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.q;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zIsEmpty || this.k == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.k.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        v1 v1Var;
        if (this.i.hasSubMenu() && (v1Var = this.m) != null && v1Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.p != z) {
            this.p = z;
            cl0 cl0Var = this.i;
            if (cl0Var != null) {
                zk0 zk0Var = cl0Var.n;
                zk0Var.k = true;
                zk0Var.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.k = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.s;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(yk0 yk0Var) {
        this.l = yk0Var;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.r = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(w1 w1Var) {
        this.n = w1Var;
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        h();
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }
}
