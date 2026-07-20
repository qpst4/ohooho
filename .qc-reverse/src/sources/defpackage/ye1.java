package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.quickcursor.android.views.VerticalTabLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ye1 extends LinearLayout {
    public int b;
    public final Paint c;
    public final GradientDrawable d;
    public int e;
    public float f;
    public int g;
    public int h;
    public ValueAnimator i;
    public final /* synthetic */ VerticalTabLayout j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye1(VerticalTabLayout verticalTabLayout, Context context) {
        super(context);
        this.j = verticalTabLayout;
        this.e = -1;
        this.g = -1;
        this.h = -1;
        setWillNotDraw(false);
        setOrientation(1);
        this.c = new Paint();
        this.d = new GradientDrawable();
    }

    public final void a(int i, int i2) {
        VerticalTabLayout verticalTabLayout = this.j;
        RectF rectF = verticalTabLayout.d;
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.i.cancel();
        }
        View childAt = getChildAt(i);
        if (childAt == null) {
            c();
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        if (!verticalTabLayout.C && (childAt instanceof bf1)) {
            b((bf1) childAt, rectF);
            top = (int) rectF.top;
            bottom = (int) rectF.bottom;
        }
        final int i3 = top;
        final int i4 = bottom;
        final int i5 = this.g;
        final int i6 = this.h;
        if (i5 == i3 && i6 == i4) {
            return;
        }
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.i = valueAnimator2;
        valueAnimator2.setInterpolator(s7.b);
        valueAnimator2.setDuration(i2);
        valueAnimator2.setFloatValues(0.0f, 1.0f);
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xe1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                float animatedFraction = valueAnimator3.getAnimatedFraction();
                int iC = s7.c(animatedFraction, i5, i3);
                int iC2 = s7.c(animatedFraction, i6, i4);
                ye1 ye1Var = this.a;
                if (iC == ye1Var.g && iC2 == ye1Var.h) {
                    return;
                }
                ye1Var.g = iC;
                ye1Var.h = iC2;
                WeakHashMap weakHashMap = uf1.a;
                ye1Var.postInvalidateOnAnimation();
            }
        });
        valueAnimator2.addListener(new ds0(this, i, 1));
        valueAnimator2.start();
    }

    public final void b(bf1 bf1Var, RectF rectF) {
        int contentHeight = bf1Var.getContentHeight();
        int iP = (int) i1.p(getContext(), 24);
        if (contentHeight < iP) {
            contentHeight = iP;
        }
        int bottom = (bf1Var.getBottom() + bf1Var.getTop()) / 2;
        int i = contentHeight / 2;
        rectF.set(0.0f, bottom - i, 0.0f, bottom + i);
    }

    public final void c() {
        int top;
        int bottom;
        VerticalTabLayout verticalTabLayout = this.j;
        RectF rectF = verticalTabLayout.d;
        View childAt = getChildAt(this.e);
        if (childAt == null || childAt.getHeight() <= 0) {
            top = -1;
            bottom = -1;
        } else {
            top = childAt.getTop();
            bottom = childAt.getBottom();
            if (!verticalTabLayout.C && (childAt instanceof bf1)) {
                b((bf1) childAt, rectF);
                top = (int) rectF.top;
                bottom = (int) rectF.bottom;
            }
            if (this.f > 0.0f && this.e < getChildCount() - 1) {
                View childAt2 = getChildAt(this.e + 1);
                int top2 = childAt2.getTop();
                int bottom2 = childAt2.getBottom();
                if (!verticalTabLayout.C && (childAt2 instanceof bf1)) {
                    b((bf1) childAt2, rectF);
                    top2 = (int) rectF.top;
                    bottom2 = (int) rectF.bottom;
                }
                float f = this.f;
                float f2 = 1.0f - f;
                top = (int) ((top * f2) + (top2 * f));
                bottom = (int) ((f2 * bottom) + (f * bottom2));
            }
        }
        if (top == this.g && bottom == this.h) {
            return;
        }
        this.g = top;
        this.h = bottom;
        WeakHashMap weakHashMap = uf1.a;
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        VerticalTabLayout verticalTabLayout = this.j;
        Drawable drawable = verticalTabLayout.n;
        int width = 0;
        int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        int i2 = this.b;
        if (i2 >= 0) {
            intrinsicHeight = i2;
        }
        int i3 = verticalTabLayout.z;
        if (i3 != 0) {
            if (i3 == 1) {
                width = (getWidth() - intrinsicHeight) / 2;
                intrinsicHeight = (getWidth() + intrinsicHeight) / 2;
            } else if (i3 != 2) {
                intrinsicHeight = i3 != 3 ? 0 : getWidth();
            } else {
                width = getWidth() - intrinsicHeight;
                intrinsicHeight = getWidth();
            }
        }
        int i4 = this.g;
        if (i4 >= 0 && (i = this.h) > i4) {
            Drawable drawable2 = verticalTabLayout.n;
            if (drawable2 == null) {
                drawable2 = this.d;
            }
            drawable2.setBounds(width, i4, intrinsicHeight, i);
            Paint paint = this.c;
            if (paint != null) {
                drawable2.setTint(paint.getColor());
            }
            drawable2.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            c();
            return;
        }
        this.i.cancel();
        a(this.e, Math.round((1.0f - this.i.getAnimatedFraction()) * this.i.getDuration()));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            return;
        }
        VerticalTabLayout verticalTabLayout = this.j;
        boolean z = true;
        if (verticalTabLayout.x == 1 || verticalTabLayout.A == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredHeight());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredHeight() - (((int) i1.p(getContext(), 16)) * 2)) {
                boolean z2 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                    if (layoutParams.height != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.height = iMax;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                verticalTabLayout.x = 0;
                verticalTabLayout.n(false);
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }
    }
}
