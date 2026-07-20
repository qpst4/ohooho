package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.quickcursor.R;
import defpackage.f01;
import defpackage.fc0;
import defpackage.fp1;
import defpackage.ik;
import defpackage.ik0;
import defpackage.lc1;
import defpackage.lf1;
import defpackage.uf1;
import defpackage.xy0;
import defpackage.ys0;
import defpackage.zk0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] d0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer V;
    public boolean W;
    public boolean a0;
    public ImageView.ScaleType b0;
    public Boolean c0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(xy0.L(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.w, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayE.hasValue(2)) {
            setNavigationIconTint(typedArrayE.getColor(2, -1));
        }
        this.W = typedArrayE.getBoolean(4, false);
        this.a0 = typedArrayE.getBoolean(3, false);
        int i = typedArrayE.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = d0;
            if (i < scaleTypeArr.length) {
                this.b0 = scaleTypeArr[i];
            }
        }
        if (typedArrayE.hasValue(0)) {
            this.c0 = Boolean.valueOf(typedArrayE.getBoolean(0, false));
        }
        typedArrayE.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : lc1.x(background);
        if (colorStateListValueOf != null) {
            ik0 ik0Var = new ik0();
            ik0Var.k(colorStateListValueOf);
            ik0Var.i(context2);
            WeakHashMap weakHashMap = uf1.a;
            ik0Var.j(lf1.e(this));
            setBackground(ik0Var);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.b0;
    }

    public Integer getNavigationIconTint() {
        return this.V;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void m(int i) {
        Menu menu = getMenu();
        boolean z = menu instanceof zk0;
        if (z) {
            ((zk0) menu).w();
        }
        super.m(i);
        if (z) {
            ((zk0) menu).v();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ik0) {
            fc0.O(this, (ik0) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        ik ikVar = fp1.d;
        int i5 = 0;
        ImageView imageView2 = null;
        if (this.W || this.a0) {
            ArrayList arrayListL = fp1.l(this, getTitle());
            TextView textView = arrayListL.isEmpty() ? null : (TextView) Collections.min(arrayListL, ikVar);
            ArrayList arrayListL2 = fp1.l(this, getSubtitle());
            TextView textView2 = arrayListL2.isEmpty() ? null : (TextView) Collections.max(arrayListL2, ikVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.W && textView != null) {
                    x(textView, pair);
                }
                if (this.a0 && textView2 != null) {
                    x(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i5);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i5++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.c0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.b0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof ik0) {
            ((ik0) background).j(f);
        }
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.c0;
        if (bool == null || bool.booleanValue() != z) {
            this.c0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.b0 != scaleType) {
            this.b0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.V != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.V.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.V = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.W != z) {
            this.W = z;
            requestLayout();
        }
    }

    public final void x(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }
}
