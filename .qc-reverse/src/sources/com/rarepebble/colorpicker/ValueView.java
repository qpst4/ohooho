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
public class ValueView extends g11 implements ql {
    public f9 l;

    public ValueView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new f9(2);
    }

    @Override // defpackage.ql
    public final void a(f9 f9Var) {
        setPos(((float[]) this.l.c)[2]);
        e();
        invalidate();
    }

    @Override // defpackage.g11
    public final int b(float f) {
        f9 f9Var = this.l;
        return f9Var.c(((float[]) f9Var.c)[2]) * f > 0.5f ? -16777216 : -1;
    }

    @Override // defpackage.g11
    public final Bitmap c(int i, int i2) {
        boolean z = i > i2;
        int iMax = Math.max(i, i2);
        int[] iArr = new int[iMax];
        float[] fArr = {0.0f, 0.0f, 0.0f};
        float[] fArr2 = (float[]) this.l.c;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        for (int i3 = 0; i3 < iMax; i3++) {
            float f = i3 / iMax;
            if (!z) {
                f = 1.0f - f;
            }
            fArr[2] = f;
            iArr[i3] = Color.HSVToColor(fArr);
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
        ((float[]) f9Var.c)[2] = f;
        f9Var.f(this);
    }
}
