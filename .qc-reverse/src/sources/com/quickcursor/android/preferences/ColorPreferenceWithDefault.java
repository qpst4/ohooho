package com.quickcursor.android.preferences;

import android.content.Context;
import android.util.AttributeSet;
import com.rarepebble.colorpicker.ColorPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ColorPreferenceWithDefault extends ColorPreference {
    public Integer a0;

    public ColorPreferenceWithDefault(Context context) {
        super(context, null);
    }

    @Override // androidx.preference.Preference
    public final boolean a(Object obj) {
        if (obj == null) {
            obj = this.a0;
        }
        if (obj == null) {
            obj = -1;
        }
        return super.a(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    @Override // com.rarepebble.colorpicker.ColorPreference, androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(android.content.res.TypedArray r5, int r6) {
        /*
            r4 = this;
            android.util.TypedValue r0 = r5.peekValue(r6)
            if (r0 == 0) goto L7a
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 != r1) goto L57
            java.lang.String r0 = r5.getString(r6)
            r1 = 0
            char r1 = r0.charAt(r1)
            r2 = 35
            if (r1 != r2) goto L4e
            int r1 = r0.length()
            r2 = 5
            if (r1 > r2) goto L4e
            r1 = 1
            java.lang.String r2 = "#"
        L26:
            int r3 = r0.length()
            if (r1 >= r3) goto L4d
            java.lang.StringBuilder r2 = defpackage.l11.l(r2)
            char r3 = r0.charAt(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r2 = defpackage.l11.l(r2)
            char r3 = r0.charAt(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r1 = r1 + 1
            goto L26
        L4d:
            r0 = r2
        L4e:
            int r0 = android.graphics.Color.parseColor(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L7b
        L57:
            r1 = 28
            r2 = -7829368(0xffffffffff888888, float:NaN)
            r3 = 31
            if (r1 > r0) goto L6b
            if (r0 > r3) goto L6b
            int r0 = r5.getColor(r6, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L7b
        L6b:
            r1 = 16
            if (r1 > r0) goto L7a
            if (r0 > r3) goto L7a
            int r0 = r5.getInt(r6, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L7b
        L7a:
            r0 = 0
        L7b:
            r4.a0 = r0
            java.lang.Object r4 = super.r(r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quickcursor.android.preferences.ColorPreferenceWithDefault.r(android.content.res.TypedArray, int):java.lang.Object");
    }

    public ColorPreferenceWithDefault(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
