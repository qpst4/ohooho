package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n9 extends i9 {
    public final m9 f;
    public Drawable g;
    public ColorStateList h;
    public PorterDuff.Mode i;
    public boolean j;
    public boolean k;

    public n9(m9 m9Var) {
        super(m9Var);
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.f = m9Var;
    }

    @Override // defpackage.i9
    public final void A(AttributeSet attributeSet, int i) {
        super.A(attributeSet, R.attr.seekBarStyle);
        m9 m9Var = this.f;
        Context context = m9Var.getContext();
        int[] iArr = zs0.g;
        ra raVarM = ra.M(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) raVarM.c;
        uf1.m(m9Var, m9Var.getContext(), iArr, attributeSet, (TypedArray) raVarM.c, R.attr.seekBarStyle);
        Drawable drawableZ = raVarM.z(0);
        if (drawableZ != null) {
            m9Var.setThumb(drawableZ);
        }
        Drawable drawableY = raVarM.y(1);
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.g = drawableY;
        if (drawableY != null) {
            drawableY.setCallback(m9Var);
            drawableY.setLayoutDirection(m9Var.getLayoutDirection());
            if (drawableY.isStateful()) {
                drawableY.setState(m9Var.getDrawableState());
            }
            K();
        }
        m9Var.invalidate();
        if (typedArray.hasValue(3)) {
            this.i = vu.c(typedArray.getInt(3, -1), this.i);
            this.k = true;
        }
        if (typedArray.hasValue(2)) {
            this.h = raVarM.x(2);
            this.j = true;
        }
        raVarM.O();
        K();
    }

    public final void K() {
        Drawable drawable = this.g;
        if (drawable != null) {
            if (this.j || this.k) {
                Drawable drawableMutate = drawable.mutate();
                this.g = drawableMutate;
                if (this.j) {
                    drawableMutate.setTintList(this.h);
                }
                if (this.k) {
                    this.g.setTintMode(this.i);
                }
                if (this.g.isStateful()) {
                    this.g.setState(this.f.getDrawableState());
                }
            }
        }
    }

    public final void L(Canvas canvas) {
        if (this.g != null) {
            int max = this.f.getMax();
            if (max > 1) {
                int intrinsicWidth = this.g.getIntrinsicWidth();
                int intrinsicHeight = this.g.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.g.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.g.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
