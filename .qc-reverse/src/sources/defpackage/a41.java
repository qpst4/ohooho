package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a41 extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    public ValueAnimator b;
    public final /* synthetic */ TabLayout c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a41(TabLayout tabLayout, Context context) {
        super(context);
        this.c = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i) {
        TabLayout tabLayout = this.c;
        if (tabLayout.V == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            c70 c70Var = tabLayout.J;
            Drawable drawable = tabLayout.p;
            c70Var.getClass();
            RectF rectFE = c70.e(tabLayout, childAt);
            drawable.setBounds((int) rectFE.left, drawable.getBounds().top, (int) rectFE.right, drawable.getBounds().bottom);
            tabLayout.b = i;
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = this.c;
        Rect bounds = tabLayout.p.getBounds();
        tabLayout.p.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        TabLayout tabLayout = this.c;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.p;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.p.getBounds().bottom);
        } else {
            tabLayout.J.l(tabLayout, view, view2, f, tabLayout.p);
        }
        WeakHashMap weakHashMap = uf1.a;
        postInvalidateOnAnimation();
    }

    public final void d(int i, int i2, boolean z) {
        TabLayout tabLayout = this.c;
        if (tabLayout.b == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.b = i;
        z31 z31Var = new z31(this, childAt, childAt2);
        if (!z) {
            this.b.removeAllUpdateListeners();
            this.b.addUpdateListener(z31Var);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.b = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.K);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(z31Var);
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.c;
        int iHeight = tabLayout.p.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.p.getIntrinsicHeight();
        }
        int i = tabLayout.C;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                iHeight = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.p.getBounds().width() > 0) {
            Rect bounds = tabLayout.p.getBounds();
            tabLayout.p.setBounds(bounds.left, height, bounds.right, iHeight);
            tabLayout.p.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.b;
        TabLayout tabLayout = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            d(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.b == -1) {
            tabLayout.b = tabLayout.getSelectedTabPosition();
        }
        a(tabLayout.b);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.c;
        boolean z = true;
        if (tabLayout.A == 1 || tabLayout.D == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) i1.p(getContext(), 16)) * 2)) {
                boolean z2 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                tabLayout.A = 0;
                tabLayout.q(false);
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }
    }
}
