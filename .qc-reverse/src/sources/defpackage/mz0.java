package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mz0 {
    public static final hv0 m = new hv0(0.5f);
    public fc0 a = new tw0();
    public fc0 b = new tw0();
    public fc0 c = new tw0();
    public fc0 d = new tw0();
    public bp e = new h(0.0f);
    public bp f = new h(0.0f);
    public bp g = new h(0.0f);
    public bp h = new h(0.0f);
    public ix i;
    public ix j;
    public ix k;
    public ix l;

    public mz0() {
        int i = 0;
        this.i = new ix(i);
        this.j = new ix(i);
        this.k = new ix(i);
        this.l = new ix(i);
    }

    public static lz0 a(Context context, int i, int i2, bp bpVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(ys0.z);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(1, i3);
            bp bpVarD = d(typedArrayObtainStyledAttributes, 5, bpVar);
            bp bpVarD2 = d(typedArrayObtainStyledAttributes, 8, bpVarD);
            bp bpVarD3 = d(typedArrayObtainStyledAttributes, 9, bpVarD);
            bp bpVarD4 = d(typedArrayObtainStyledAttributes, 7, bpVarD);
            bp bpVarD5 = d(typedArrayObtainStyledAttributes, 6, bpVarD);
            lz0 lz0Var = new lz0();
            lz0Var.a = fc0.j(i4);
            lz0Var.e = bpVarD2;
            lz0Var.b = fc0.j(i5);
            lz0Var.f = bpVarD3;
            lz0Var.c = fc0.j(i6);
            lz0Var.g = bpVarD4;
            lz0Var.d = fc0.j(i7);
            lz0Var.h = bpVarD5;
            return lz0Var;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static lz0 b(Context context, AttributeSet attributeSet, int i, int i2) {
        return c(context, attributeSet, i, i2, new h(0.0f));
    }

    public static lz0 c(Context context, AttributeSet attributeSet, int i, int i2, bp bpVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.t, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, bpVar);
    }

    public static bp d(TypedArray typedArray, int i, bp bpVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new h(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new hv0(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return bpVar;
    }

    public final boolean e(RectF rectF) {
        boolean z = this.l.getClass().equals(ix.class) && this.j.getClass().equals(ix.class) && this.i.getClass().equals(ix.class) && this.k.getClass().equals(ix.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof tw0) && (this.a instanceof tw0) && (this.c instanceof tw0) && (this.d instanceof tw0));
    }

    public final lz0 f() {
        lz0 lz0Var = new lz0();
        lz0Var.a = this.a;
        lz0Var.b = this.b;
        lz0Var.c = this.c;
        lz0Var.d = this.d;
        lz0Var.e = this.e;
        lz0Var.f = this.f;
        lz0Var.g = this.g;
        lz0Var.h = this.h;
        lz0Var.i = this.i;
        lz0Var.j = this.j;
        lz0Var.k = this.k;
        lz0Var.l = this.l;
        return lz0Var;
    }
}
