package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.warkiz.tickseekbar.TickSeekBar;
import defpackage.fo0;
import defpackage.lc1;
import defpackage.ms0;
import defpackage.nq0;
import defpackage.oq0;
import defpackage.pn0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TickSeekBarPreference extends Preference implements fo0 {
    public final boolean O;
    public String[] P;
    public int Q;
    public int R;
    public final int S;
    public int T;
    public TickSeekBar U;

    public TickSeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        String[] strArr;
        super(context, attributeSet, i, i2);
        this.F = R.layout.preference_widget_tickseekbar;
        this.G = R.layout.preference_widget_tickseekbar;
        if (attributeSet == null) {
            this.Q = 0;
            this.R = 100;
            this.S = 0;
            this.O = true;
            this.P = new String[0];
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.e, 0, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, ms0.h, 0, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes2.getTextArray(0);
        textArray = textArray == null ? typedArrayObtainStyledAttributes2.getTextArray(0) : textArray;
        if (textArray == null) {
            strArr = new String[]{"Empty"};
        } else {
            String[] strArr2 = new String[textArray.length];
            int length = textArray.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                strArr2[i4] = textArray[i3].toString();
                i3++;
                i4++;
            }
            strArr = strArr2;
        }
        this.P = strArr;
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(1, true);
        String[] strArr3 = this.P;
        if (strArr3 == null || strArr3.length <= 1) {
            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, typedArrayObtainStyledAttributes.getInt(7, 0));
            this.R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, typedArrayObtainStyledAttributes.getInt(5, 100));
        } else {
            this.Q = 0;
            int length2 = strArr3.length;
            this.R = length2 - 1;
            if (!z) {
                this.Q = 1;
                this.R = length2;
            }
        }
        this.S = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, typedArrayObtainStyledAttributes.getInt(0, this.Q));
        this.O = typedArrayObtainStyledAttributes.getBoolean(13, true);
        typedArrayObtainStyledAttributes.recycle();
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void J(int i, String[] strArr, int i2) {
        this.Q = 1;
        this.R = i;
        this.P = strArr;
        this.T = i2;
        if (this.U != null) {
            K();
        }
    }

    public final void K() {
        this.U.setMin(this.Q);
        this.U.setMax(this.R);
        TickSeekBar tickSeekBar = this.U;
        String[] strArr = this.P;
        tickSeekBar.L = strArr;
        if (tickSeekBar.B != null) {
            int i = 0;
            while (i < tickSeekBar.B.length) {
                String strValueOf = i < strArr.length ? String.valueOf(strArr[i]) : "";
                int i2 = tickSeekBar.y ? (tickSeekBar.N - 1) - i : i;
                tickSeekBar.B[i2] = strValueOf;
                TextPaint textPaint = tickSeekBar.d;
                if (textPaint != null && tickSeekBar.f != null) {
                    textPaint.getTextBounds(strValueOf, 0, strValueOf.length(), tickSeekBar.f);
                    tickSeekBar.C[i2] = tickSeekBar.f.width();
                }
                i++;
            }
            tickSeekBar.invalidate();
        }
        this.U.setTickCount(this.P.length);
        this.U.setProgress(this.T);
        this.U.setOnSeekChangeListener(this);
    }

    @Override // androidx.preference.Preference
    public final CharSequence i() {
        if (!this.m.equals("triggerLength") || this.T <= 5 || !oq0.a((SharedPreferences) pn0.t().d, oq0.h)) {
            return super.i();
        }
        return "\n" + lc1.K(R.string.restrict_system_navigation_gesture_max_warning);
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        this.U = (TickSeekBar) nq0Var.r(R.id.seekbar);
        K();
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, 1));
    }

    @Override // androidx.preference.Preference
    public final void v(Object obj, boolean z) {
        int iIntValue = obj == null ? this.S : ((Integer) obj).intValue();
        if (z) {
            this.T = f(iIntValue);
            return;
        }
        this.T = iIntValue;
        if (H()) {
            y(this.T);
        }
    }

    public TickSeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TickSeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    public TickSeekBarPreference(Context context) {
        this(context, null);
    }
}
