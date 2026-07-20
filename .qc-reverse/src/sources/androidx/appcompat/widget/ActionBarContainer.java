package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.quickcursor.R;
import defpackage.k1;
import defpackage.py0;
import defpackage.zs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public boolean b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public final boolean h;
    public boolean i;
    public final int j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new k1(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.a);
        boolean z = false;
        this.e = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f = typedArrayObtainStyledAttributes.getDrawable(2);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.h = true;
            this.g = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.h ? !(this.e != null || this.f != null) : this.g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f.setState(getDrawableState());
        }
        Drawable drawable3 = this.g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.c = findViewById(R.id.action_bar);
        this.d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (this.h) {
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.e == null) {
                z2 = false;
            } else if (this.c.getVisibility() == 0) {
                this.e.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            } else {
                View view = this.d;
                if (view == null || view.getVisibility() != 0) {
                    this.e.setBounds(0, 0, 0, 0);
                } else {
                    this.e.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                }
            }
            this.i = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c == null) {
            return;
        }
        View.MeasureSpec.getMode(i2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.c;
            if (view != null) {
                this.e.setBounds(view.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = false;
        if (!this.h ? !(this.e != null || this.f != null) : this.g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.g);
        }
        this.g = drawable;
        boolean z = this.h;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.e != null || this.f != null) : this.g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.i && this.f != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.h ? !(this.e != null || this.f != null) : this.g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z) {
        this.b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.e;
        boolean z = this.h;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.f && this.i) {
            return true;
        }
        return (drawable == this.g && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public void setTabContainer(py0 py0Var) {
    }
}
