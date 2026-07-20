package com.rarepebble.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import defpackage.f9;
import defpackage.g11;
import defpackage.ql;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AlphaView extends g11 implements ql {
    public f9 l;

    public AlphaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new f9(2);
    }

    @Override // defpackage.ql
    public final void a(f9 f9Var) {
        setPos(f9Var.b / 255.0f);
        e();
        invalidate();
    }

    @Override // defpackage.g11
    public final int b(float f) {
        f9 f9Var = this.l;
        return ((f9Var.c(((float[]) f9Var.c)[2]) - 1.0f) * f) + 1.0f > 0.5f ? -16777216 : -1;
    }

    @Override // defpackage.g11
    public final Bitmap c(int i, int i2) {
        boolean z = i > i2;
        int iMax = Math.max(i, i2);
        f9 f9Var = this.l;
        int iHSVToColor = Color.HSVToColor(f9Var.b, (float[]) f9Var.c);
        int[] iArr = new int[iMax];
        for (int i3 = 0; i3 < iMax; i3++) {
            float f = i3 / iMax;
            if (!z) {
                f = 1.0f - f;
            }
            iArr[i3] = (((int) (f * 255.0f)) << 24) | (16777215 & iHSVToColor);
        }
        if (!z) {
            i = 1;
        }
        if (z) {
            i2 = 1;
        }
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    @Override // defpackage.g11
    public final void d(float f) {
        f9 f9Var = this.l;
        f9Var.b = (int) (f * 255.0f);
        f9Var.f(this);
    }
}
