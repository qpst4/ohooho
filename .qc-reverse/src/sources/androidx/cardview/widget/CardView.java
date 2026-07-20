package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.fp1;
import defpackage.i9;
import defpackage.qs0;
import defpackage.rw0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] g = {R.attr.colorBackground};
    public boolean b;
    public boolean c;
    public final Rect d;
    public final Rect e;
    public final i9 f;

    public CardView(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, com.quickcursor.R.attr.cardViewStyle);
        Rect rect = new Rect();
        this.d = rect;
        this.e = new Rect();
        i9 i9Var = new i9(this);
        this.f = i9Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qs0.a, com.quickcursor.R.attr.cardViewStyle, com.quickcursor.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(g);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.quickcursor.R.color.cardview_light_background) : getResources().getColor(com.quickcursor.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.b = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.c = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        rw0 rw0Var = new rw0(colorStateListValueOf, dimension);
        i9Var.c = rw0Var;
        setBackgroundDrawable(rw0Var);
        setClipToOutline(true);
        setElevation(dimension2);
        fp1.A(i9Var, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((rw0) this.f.c).h;
    }

    public float getCardElevation() {
        return ((CardView) this.f.d).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.d.bottom;
    }

    public int getContentPaddingLeft() {
        return this.d.left;
    }

    public int getContentPaddingRight() {
        return this.d.right;
    }

    public int getContentPaddingTop() {
        return this.d.top;
    }

    public float getMaxCardElevation() {
        return ((rw0) this.f.c).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return ((rw0) this.f.c).a;
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        rw0 rw0Var = (rw0) this.f.c;
        if (colorStateListValueOf == null) {
            rw0Var.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        rw0Var.h = colorStateListValueOf;
        rw0Var.b.setColor(colorStateListValueOf.getColorForState(rw0Var.getState(), rw0Var.h.getDefaultColor()));
        rw0Var.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.f.d).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        fp1.A(this.f, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.c) {
            this.c = z;
            i9 i9Var = this.f;
            fp1.A(i9Var, ((rw0) i9Var.c).e);
        }
    }

    public void setRadius(float f) {
        rw0 rw0Var = (rw0) this.f.c;
        if (f == rw0Var.a) {
            return;
        }
        rw0Var.a = f;
        rw0Var.b(null);
        rw0Var.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            i9 i9Var = this.f;
            fp1.A(i9Var, ((rw0) i9Var.c).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        rw0 rw0Var = (rw0) this.f.c;
        if (colorStateList == null) {
            rw0Var.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        rw0Var.h = colorStateList;
        rw0Var.b.setColor(colorStateList.getColorForState(rw0Var.getState(), rw0Var.h.getDefaultColor()));
        rw0Var.invalidateSelf();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }
}
