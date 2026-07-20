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
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e41 extends LinearLayout {
    public static final /* synthetic */ int m = 0;
    public b41 b;
    public TextView c;
    public ImageView d;
    public View e;
    public yd f;
    public View g;
    public TextView h;
    public ImageView i;
    public Drawable j;
    public int k;
    public final /* synthetic */ TabLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e41(TabLayout tabLayout, Context context) {
        super(context);
        this.l = tabLayout;
        this.k = 2;
        e(context);
        int i = tabLayout.f;
        int i2 = tabLayout.g;
        int i3 = tabLayout.h;
        int i4 = tabLayout.i;
        WeakHashMap weakHashMap = uf1.a;
        setPaddingRelative(i, i2, i3, i4);
        setGravity(17);
        setOrientation(!tabLayout.E ? 1 : 0);
        setClickable(true);
        nf1.a(this, PointerIcon.getSystemIcon(getContext(), 1002));
    }

    private yd getBadge() {
        return this.f;
    }

    private yd getOrCreateBadge() {
        if (this.f == null) {
            this.f = new yd(getContext());
        }
        b();
        yd ydVar = this.f;
        if (ydVar != null) {
            return ydVar;
        }
        s1.f("Unable to create badge");
        return null;
    }

    public final void a() {
        if (this.f != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.e;
            if (view != null) {
                yd ydVar = this.f;
                if (ydVar != null) {
                    if (ydVar.d() != null) {
                        ydVar.d().setForeground(null);
                    } else {
                        view.getOverlay().remove(ydVar);
                    }
                }
                this.e = null;
            }
        }
    }

    public final void b() {
        b41 b41Var;
        if (this.f != null) {
            if (this.g != null) {
                a();
                return;
            }
            ImageView imageView = this.d;
            if (imageView != null && (b41Var = this.b) != null && b41Var.b != null) {
                if (this.e == imageView) {
                    c(imageView);
                    return;
                }
                a();
                ImageView imageView2 = this.d;
                if (this.f == null || imageView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
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
                a();
                return;
            }
            if (this.e == textView) {
                c(textView);
                return;
            }
            a();
            TextView textView2 = this.c;
            if (this.f == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
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

    public final void c(View view) {
        yd ydVar = this.f;
        if (ydVar == null || view != this.e) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ydVar.setBounds(rect);
        ydVar.i(view, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            r3.f()
            b41 r0 = r3.b
            if (r0 == 0) goto L1e
            com.google.android.material.tabs.TabLayout r1 = r0.g
            if (r1 == 0) goto L18
            int r1 = r1.getSelectedTabPosition()
            r2 = -1
            if (r1 == r2) goto L1e
            int r0 = r0.e
            if (r1 != r0) goto L1e
            r0 = 1
            goto L1f
        L18:
            java.lang.String r3 = "Tab not attached to a TabLayout"
            defpackage.zy.n(r3)
            return
        L1e:
            r0 = 0
        L1f:
            r3.setSelected(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e41.d():void");
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

    public final void e(Context context) {
        TabLayout tabLayout = this.l;
        int i = tabLayout.u;
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
        if (tabLayout.o != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateListA = nw0.a(tabLayout.o);
            boolean z = tabLayout.I;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z ? null : gradientDrawable2);
        }
        WeakHashMap weakHashMap = uf1.a;
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void f() {
        int i;
        ViewParent parent;
        b41 b41Var = this.b;
        View view = b41Var != null ? b41Var.f : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.g;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.g);
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
            View view3 = this.g;
            if (view3 != null) {
                removeView(view3);
                this.g = null;
            }
            this.h = null;
            this.i = null;
        }
        if (this.g == null) {
            if (this.d == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.quickcursor.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                this.d = imageView2;
                addView(imageView2, 0);
            }
            if (this.c == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.quickcursor.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                this.c = textView3;
                addView(textView3);
                this.k = this.c.getMaxLines();
            }
            TextView textView4 = this.c;
            TabLayout tabLayout = this.l;
            textView4.setTextAppearance(tabLayout.j);
            if (!isSelected() || (i = tabLayout.l) == -1) {
                this.c.setTextAppearance(tabLayout.k);
            } else {
                this.c.setTextAppearance(i);
            }
            ColorStateList colorStateList = tabLayout.m;
            if (colorStateList != null) {
                this.c.setTextColor(colorStateList);
            }
            g(this.c, this.d, true);
            b();
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new d41(this, imageView3));
            }
            TextView textView5 = this.c;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new d41(this, textView5));
            }
        } else {
            TextView textView6 = this.h;
            if (textView6 != null || this.i != null) {
                g(textView6, this.i, false);
            }
        }
        if (b41Var == null || TextUtils.isEmpty(b41Var.d)) {
            return;
        }
        setContentDescription(b41Var.d);
    }

    public final void g(TextView textView, ImageView imageView, boolean z) {
        boolean z2;
        Drawable drawable;
        b41 b41Var = this.b;
        Drawable drawableMutate = (b41Var == null || (drawable = b41Var.b) == null) ? null : drawable.mutate();
        TabLayout tabLayout = this.l;
        if (drawableMutate != null) {
            drawableMutate.setTintList(tabLayout.n);
            PorterDuff.Mode mode = tabLayout.r;
            if (mode != null) {
                drawableMutate.setTintMode(mode);
            }
        }
        b41 b41Var2 = this.b;
        CharSequence charSequence = b41Var2 != null ? b41Var2.c : null;
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
                z2 = false;
            } else {
                this.b.getClass();
                z2 = true;
            }
            textView.setText(!zIsEmpty ? charSequence : null);
            textView.setVisibility(z2 ? 0 : 8);
            if (!zIsEmpty) {
                setVisibility(0);
            }
        } else {
            z2 = false;
        }
        if (z && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iP = (z2 && imageView.getVisibility() == 0) ? (int) i1.p(getContext(), 8) : 0;
            if (tabLayout.E) {
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
        b41 b41Var3 = this.b;
        CharSequence charSequence2 = b41Var3 != null ? b41Var3.d : null;
        if (zIsEmpty) {
            charSequence = charSequence2;
        }
        fc0.P(this, charSequence);
    }

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

    public int getContentWidth() {
        View[] viewArr = {this.c, this.d, this.g};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public b41 getTab() {
        return this.b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        yd ydVar = this.f;
        if (ydVar != null && ydVar.isVisible()) {
            accessibilityNodeInfo.setContentDescription(this.f.c());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) m0.a(isSelected(), 0, 1, this.b.e, 1).b);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) h0.e.a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(com.quickcursor.R.string.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.l;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.v, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            float f = tabLayout.s;
            int i3 = this.k;
            ImageView imageView = this.d;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.c;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.t;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int maxLines = this.c.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (tabLayout.D == 1 && f > textSize && lineCount == 1) {
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
        b41 b41Var = this.b;
        TabLayout tabLayout = b41Var.g;
        if (tabLayout != null) {
            tabLayout.m(b41Var, true);
            return true;
        }
        zy.n("Tab not attached to a TabLayout");
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

    public void setTab(b41 b41Var) {
        if (b41Var != this.b) {
            this.b = b41Var;
            d();
        }
    }
}
