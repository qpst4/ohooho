package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quickcursor.android.views.VerticalTabLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bf1 extends LinearLayout {
    public static final /* synthetic */ int m = 0;
    public ze1 b;
    public TextView c;
    public ImageView d;
    public View e;
    public yd f;
    public View g;
    public TextView h;
    public ImageView i;
    public Drawable j;
    public int k;
    public final /* synthetic */ VerticalTabLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf1(VerticalTabLayout verticalTabLayout, Context context) {
        super(context);
        this.l = verticalTabLayout;
        this.k = 2;
        f(context);
        int i = verticalTabLayout.f;
        int i2 = verticalTabLayout.g;
        int i3 = verticalTabLayout.h;
        int i4 = verticalTabLayout.i;
        WeakHashMap weakHashMap = uf1.a;
        setPaddingRelative(i, i2, i3, i4);
        setGravity(17);
        setOrientation(!verticalTabLayout.B ? 1 : 0);
        setClickable(true);
        nf1.a(this, PointerIcon.getSystemIcon(getContext(), 1002));
        uf1.n(this, null);
    }

    private yd getBadge() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentHeight() {
        View[] viewArr = {this.c, this.d, this.g};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z = true;
            }
        }
        return iMax - iMin;
    }

    private yd getOrCreateBadge() {
        if (this.f == null) {
            this.f = new yd(getContext());
        }
        c();
        yd ydVar = this.f;
        if (ydVar != null) {
            return ydVar;
        }
        s1.f("Unable to create badge");
        return null;
    }

    public final void b() {
        if (this.f == null || this.e == null) {
            return;
        }
        setClipChildren(true);
        setClipToPadding(true);
        this.e = null;
    }

    public final void c() {
        ze1 ze1Var;
        if (this.f != null) {
            if (this.g != null) {
                b();
                return;
            }
            ImageView imageView = this.d;
            if (imageView != null && (ze1Var = this.b) != null && ze1Var.a != null) {
                if (this.e == imageView) {
                    d(imageView);
                    return;
                }
                b();
                ImageView imageView2 = this.d;
                if (this.f == null || imageView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                yd ydVar = this.f;
                Rect rect = new Rect();
                imageView2.getDrawingRect(rect);
                ydVar.setBounds(rect);
                ydVar.i(imageView2, null);
                if (ydVar.d() != null) {
                    ydVar.d().setForeground(ydVar);
                } else {
                    imageView2.getOverlay().add(ydVar);
                }
                this.e = imageView2;
                return;
            }
            TextView textView = this.c;
            if (textView == null || this.b == null) {
                b();
                return;
            }
            if (this.e == textView) {
                d(textView);
                return;
            }
            b();
            TextView textView2 = this.c;
            if (this.f == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            yd ydVar2 = this.f;
            Rect rect2 = new Rect();
            textView2.getDrawingRect(rect2);
            ydVar2.setBounds(rect2);
            ydVar2.i(textView2, null);
            if (ydVar2.d() != null) {
                ydVar2.d().setForeground(ydVar2);
            } else {
                textView2.getOverlay().add(ydVar2);
            }
            this.e = textView2;
        }
    }

    public final void d(View view) {
        yd ydVar = this.f;
        if (ydVar == null || view != this.e) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ydVar.setBounds(rect);
        ydVar.i(view, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.j;
        if ((drawable == null || !drawable.isStateful()) ? false : this.j.setState(drawableState)) {
            invalidate();
            this.l.invalidate();
        }
    }

    public final void e() {
        Drawable drawable;
        ze1 ze1Var = this.b;
        Drawable drawableMutate = null;
        View view = ze1Var != null ? ze1Var.e : null;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
            }
            this.g = view;
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.d.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.h = textView2;
            if (textView2 != null) {
                this.k = textView2.getMaxLines();
            }
            this.i = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view2 = this.g;
            if (view2 != null) {
                removeView(view2);
                this.g = null;
            }
            this.h = null;
            this.i = null;
        }
        boolean z = false;
        if (this.g == null) {
            if (this.d == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.quickcursor.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                this.d = imageView2;
                addView(imageView2, 0);
            }
            if (ze1Var != null && (drawable = ze1Var.a) != null) {
                drawableMutate = drawable.mutate();
            }
            VerticalTabLayout verticalTabLayout = this.l;
            if (drawableMutate != null) {
                drawableMutate.setTintList(verticalTabLayout.l);
                PorterDuff.Mode mode = verticalTabLayout.o;
                if (mode != null) {
                    drawableMutate.setTintMode(mode);
                }
            }
            if (this.c == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.quickcursor.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                this.c = textView3;
                addView(textView3);
                this.k = this.c.getMaxLines();
            }
            this.c.setTextAppearance(verticalTabLayout.j);
            ColorStateList colorStateList = verticalTabLayout.k;
            if (colorStateList != null) {
                this.c.setTextColor(colorStateList);
            }
            g(this.c, this.d);
            c();
            final ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: af1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        View view4 = imageView3;
                        if (view4.getVisibility() == 0) {
                            this.a.d(view4);
                        }
                    }
                });
            }
            final TextView textView4 = this.c;
            if (textView4 != null) {
                textView4.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: af1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        View view4 = textView4;
                        if (view4.getVisibility() == 0) {
                            this.a.d(view4);
                        }
                    }
                });
            }
        } else {
            TextView textView5 = this.h;
            if (textView5 != null || this.i != null) {
                g(textView5, this.i);
            }
        }
        if (ze1Var != null && !TextUtils.isEmpty(ze1Var.c)) {
            setContentDescription(ze1Var.c);
        }
        if (ze1Var != null) {
            VerticalTabLayout verticalTabLayout2 = ze1Var.f;
            if (verticalTabLayout2 == null) {
                zy.n("Tab not attached to a VerticalTabLayout");
                return;
            } else if (verticalTabLayout2.getSelectedTabPosition() == ze1Var.d) {
                z = true;
            }
        }
        setSelected(z);
    }

    public final void f(Context context) {
        VerticalTabLayout verticalTabLayout = this.l;
        int i = verticalTabLayout.r;
        if (i != 0) {
            Drawable drawableJ = tk0.j(context, i);
            this.j = drawableJ;
            if (drawableJ != null && drawableJ.isStateful()) {
                this.j.setState(getDrawableState());
            }
        } else {
            this.j = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        Drawable rippleDrawable = gradientDrawable;
        if (verticalTabLayout.m != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateListA = nw0.a(verticalTabLayout.m);
            boolean z = verticalTabLayout.D;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z ? null : gradientDrawable2);
        }
        WeakHashMap weakHashMap = uf1.a;
        setBackground(rippleDrawable);
        verticalTabLayout.invalidate();
    }

    public final void g(TextView textView, ImageView imageView) {
        Drawable drawable;
        ze1 ze1Var = this.b;
        Drawable drawableMutate = (ze1Var == null || (drawable = ze1Var.a) == null) ? null : drawable.mutate();
        ze1 ze1Var2 = this.b;
        CharSequence charSequence = ze1Var2 != null ? ze1Var2.b : null;
        if (imageView != null) {
            if (drawableMutate != null) {
                imageView.setImageDrawable(drawableMutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            } else {
                textView.setText(charSequence);
                this.b.getClass();
                textView.setVisibility(0);
                setVisibility(0);
            }
        }
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iP = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) i1.p(getContext(), 8);
            if (this.l.B) {
                if (iP != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iP);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iP != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iP;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        ze1 ze1Var3 = this.b;
        fc0.P(this, zIsEmpty ? ze1Var3 != null ? ze1Var3.c : null : null);
    }

    public ze1 getTab() {
        return this.b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(i1.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(i1.class.getName());
        yd ydVar = this.f;
        if (ydVar == null || !ydVar.isVisible()) {
            return;
        }
        accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f.c()));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        VerticalTabLayout verticalTabLayout = this.l;
        int tabMaxHeight = verticalTabLayout.getTabMaxHeight();
        if (tabMaxHeight > 0 && (mode == 0 || size > tabMaxHeight)) {
            i2 = View.MeasureSpec.makeMeasureSpec(verticalTabLayout.s, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            float f = verticalTabLayout.p;
            int i3 = this.k;
            ImageView imageView = this.d;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.c;
                if (textView != null && textView.getLineCount() > 1) {
                    f = verticalTabLayout.q;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int maxLines = this.c.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (verticalTabLayout.A == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.c.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.c.setTextSize(0, f);
                this.c.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.b == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        ze1 ze1Var = this.b;
        VerticalTabLayout verticalTabLayout = ze1Var.f;
        if (verticalTabLayout != null) {
            verticalTabLayout.j(ze1Var, true);
            return true;
        }
        zy.n("Tab not attached to a VerticalTabLayout");
        return false;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        isSelected();
        super.setSelected(z);
        TextView textView = this.c;
        if (textView != null) {
            textView.setSelected(z);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        View view = this.g;
        if (view != null) {
            view.setSelected(z);
        }
    }

    public void setTab(ze1 ze1Var) {
        if (ze1Var != this.b) {
            this.b = ze1Var;
            e();
        }
    }
}
