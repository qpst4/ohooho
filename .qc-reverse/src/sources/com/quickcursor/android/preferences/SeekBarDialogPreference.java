package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.DialogPreference;
import com.quickcursor.R;
import defpackage.ey0;
import defpackage.lc1;
import defpackage.ms0;
import defpackage.oq0;
import defpackage.pn0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SeekBarDialogPreference extends DialogPreference {
    public final String U;
    public final String V;
    public final boolean W;
    public final boolean X;
    public final boolean Y;
    public int Z;
    public final int a0;
    public int b0;
    public int c0;
    public int d0;

    public SeekBarDialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (attributeSet == null) {
            this.Z = 0;
            this.c0 = 100;
            this.a0 = 1;
            this.b0 = 0;
            this.U = "";
            this.V = "";
            this.W = false;
            this.X = false;
            this.Y = false;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.e, 0, 0);
        this.Z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, typedArrayObtainStyledAttributes.getInt(7, 0));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(11, typedArrayObtainStyledAttributes.getInt(10, 1));
        this.a0 = dimensionPixelOffset;
        this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, typedArrayObtainStyledAttributes.getInt(0, this.Z));
        this.U = typedArrayObtainStyledAttributes.getString(2);
        this.V = typedArrayObtainStyledAttributes.getString(12);
        this.W = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.X = typedArrayObtainStyledAttributes.getBoolean(4, false);
        this.Y = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, typedArrayObtainStyledAttributes.getInt(5, 100));
        if (typedArrayObtainStyledAttributes.getBoolean(9, false)) {
            int i3 = this.c0;
            this.c0 = i3 - (i3 % dimensionPixelOffset);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void K(int i) {
        if (!this.Y) {
            y(i);
            return;
        }
        float f = i;
        if (H()) {
            boolean zH = H();
            String str = this.m;
            if (f == (zH ? this.c.b().getFloat(str, Float.NaN) : Float.NaN)) {
                return;
            }
            SharedPreferences.Editor editorA = this.c.a();
            editorA.putFloat(str, f);
            I(editorA);
        }
    }

    public final void L(int i) {
        this.d0 = Math.min(this.c0, Math.max(this.Z, i));
        if (H()) {
            K(i);
        }
        k();
    }

    @Override // androidx.preference.Preference
    public final CharSequence i() {
        boolean zEquals = this.m.equals("triggerAreaHeight");
        String str = this.V;
        if (!zEquals || Math.round(this.d0 / (ey0.a.densityDpi / 160.0f)) <= 200 || !oq0.a((SharedPreferences) pn0.t().d, oq0.h)) {
            return this.d0 + " " + str;
        }
        return this.d0 + " " + str + "\n\n" + lc1.K(R.string.restrict_system_navigation_gesture_max_warning);
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, 1));
    }

    @Override // androidx.preference.Preference
    public final void v(Object obj, boolean z) {
        int iF;
        int iIntValue = obj == null ? this.b0 : ((Integer) obj).intValue();
        if (!z) {
            this.d0 = iIntValue;
            if (H()) {
                K(this.d0);
                return;
            }
            return;
        }
        if (this.Y) {
            float f = iIntValue;
            if (H()) {
                f = this.c.b().getFloat(this.m, f);
            }
            iF = (int) f;
        } else {
            iF = f(iIntValue);
        }
        this.d0 = iF;
    }

    public SeekBarDialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dialogPreferenceStyle);
    }

    public SeekBarDialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, i);
    }

    public SeekBarDialogPreference(Context context) {
        this(context, null);
    }
}
