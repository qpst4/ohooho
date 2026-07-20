package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rw0 extends Drawable {
    public float a;
    public final Paint b;
    public final RectF c;
    public final Rect d;
    public float e;
    public ColorStateList h;
    public PorterDuffColorFilter i;
    public ColorStateList j;
    public boolean f = false;
    public boolean g = true;
    public PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    public rw0(ColorStateList colorStateList, float f) {
        this.a = f;
        Paint paint = new Paint(5);
        this.b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.h.getDefaultColor()));
        this.c = new RectF();
        this.d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        float f;
        if (rect == null) {
            rect = getBounds();
        }
        float f2 = rect.left;
        float f3 = rect.top;
        float f4 = rect.right;
        float f5 = rect.bottom;
        RectF rectF = this.c;
        rectF.set(f2, f3, f4, f5);
        Rect rect2 = this.d;
        rect2.set(rect);
        if (this.f) {
            float f6 = this.e;
            float f7 = this.a;
            boolean z = this.g;
            if (z) {
                f = (float) (((1.0d - sw0.a) * ((double) f7)) + ((double) (1.5f * f6)));
            } else {
                int i = sw0.b;
                f = 1.5f * f6;
            }
            if (z) {
                f6 = (float) (((1.0d - sw0.a) * ((double) f7)) + ((double) f6));
            }
            rect2.inset((int) Math.ceil(f6), (int) Math.ceil(f));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        PorterDuffColorFilter porterDuffColorFilter = this.i;
        Paint paint = this.b;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.c;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.b;
        boolean z = colorForState != paint.getColor();
        if (z) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a(this.j, mode);
        invalidateSelf();
    }
}
