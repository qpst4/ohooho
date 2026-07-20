package com.rarepebble.colorpicker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.DialogPreference;
import defpackage.l11;
import defpackage.lq0;
import defpackage.nq0;
import defpackage.ns0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ColorPreference extends DialogPreference {
    public final String U;
    public Integer V;
    public final String W;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;

    public ColorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet == null) {
            this.U = null;
            this.W = null;
            this.X = true;
            this.Y = true;
            this.Z = true;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ns0.a, 0, 0);
        this.U = typedArrayObtainStyledAttributes.getString(1);
        this.W = typedArrayObtainStyledAttributes.getString(0);
        this.X = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.Y = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.Z = typedArrayObtainStyledAttributes.getBoolean(4, true);
    }

    public static String M(String str) {
        if (str.charAt(0) != '#' || str.length() > 5) {
            return str;
        }
        String string = "#";
        for (int i = 1; i < str.length(); i++) {
            StringBuilder sbL = l11.l(string);
            sbL.append(str.charAt(i));
            StringBuilder sbL2 = l11.l(sbL.toString());
            sbL2.append(str.charAt(i));
            string = sbL2.toString();
        }
        return string;
    }

    public final Integer K() {
        if (H()) {
            lq0 lq0Var = this.c;
            if ((lq0Var != null ? lq0Var.b() : null).contains(this.m)) {
                return Integer.valueOf(f(-7829368));
            }
        }
        return this.V;
    }

    public final void L(Integer num) {
        if (num != null) {
            y(num.intValue());
        } else if (H()) {
            lq0 lq0Var = this.c;
            (lq0Var != null ? lq0Var.b() : null).edit().remove(this.m).apply();
        }
        k();
    }

    @Override // androidx.preference.Preference
    public final CharSequence i() {
        String str = this.W;
        return (str == null || K() != null) ? super.i() : str;
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        LinearLayout linearLayout = (LinearLayout) nq0Var.a.findViewById(R.id.widget_frame);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        LayoutInflater.from(this.b).inflate(j() ? com.quickcursor.R.layout.color_preference_thumbnail : com.quickcursor.R.layout.color_preference_thumbnail_disabled, linearLayout);
        View viewFindViewById = linearLayout.findViewById(com.quickcursor.R.id.thumbnail);
        Integer numK = K();
        if (numK == null) {
            numK = this.V;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(numK == null ? 8 : 0);
            viewFindViewById.findViewById(com.quickcursor.R.id.colorPreview).setBackgroundColor(numK != null ? numK.intValue() : 0);
        }
        super.o(nq0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    @Override // androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(android.content.res.TypedArray r5, int r6) {
        /*
            r4 = this;
            android.util.TypedValue r0 = r5.peekValue(r6)
            if (r0 == 0) goto L43
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 != r1) goto L20
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r5 = M(r5)
            int r5 = android.graphics.Color.parseColor(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L44
        L20:
            r1 = 28
            r2 = -7829368(0xffffffffff888888, float:NaN)
            r3 = 31
            if (r1 > r0) goto L34
            if (r0 > r3) goto L34
            int r5 = r5.getColor(r6, r2)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L44
        L34:
            r1 = 16
            if (r1 > r0) goto L43
            if (r0 > r3) goto L43
            int r5 = r5.getInt(r6, r2)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L44
        L43:
            r5 = 0
        L44:
            r4.V = r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rarepebble.colorpicker.ColorPreference.r(android.content.res.TypedArray, int):java.lang.Object");
    }

    @Override // androidx.preference.Preference
    public final void v(Object obj, boolean z) {
        L(Integer.valueOf(z ? K().intValue() : obj == null ? -7829368 : obj instanceof Integer ? ((Integer) obj).intValue() : Color.parseColor(M(obj.toString()))));
    }
}
