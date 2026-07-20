package com.quickcursor.android.preferences;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.preference.ListPreference;
import com.quickcursor.App;
import com.quickcursor.R;
import defpackage.a3;
import defpackage.lc1;
import defpackage.nq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class DetailedListPreference extends ListPreference {
    public final boolean[] Z;
    public final CharSequence[] a0;
    public final int[] b0;
    public Drawable c0;
    public final String d0;
    public Runnable e0;
    public AppCompatImageView f0;
    public View g0;

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)|5|(3:7|(4:10|(2:12|56)(2:13|55)|14|8)|54)(1:15)|16|(2:52|17)|(6:19|39|48|40|43|44)(12:20|50|21|22|(4:25|26|23|46)|57|29|39|48|40|43|44)|(1:29)|39|48|40|43|44|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0098, code lost:
    
        r4.c0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DetailedListPreference(android.content.Context r5, android.util.AttributeSet r6, int r7, int r8) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7, r8)
            r0 = 2131558567(0x7f0d00a7, float:1.8742453E38)
            r4.F = r0
            int[] r0 = defpackage.ms0.d
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r0, r7, r8)
            r6 = 2
            java.lang.CharSequence[] r6 = r5.getTextArray(r6)
            r7 = 0
            if (r6 != 0) goto L1a
            java.lang.CharSequence[] r6 = r5.getTextArray(r7)
        L1a:
            r4.a0 = r6
            r6 = 3
            int r6 = r5.getResourceId(r6, r7)
            r8 = 0
            r0 = 1
            if (r6 == 0) goto L40
            android.content.res.Resources r1 = r5.getResources()
            int[] r6 = r1.getIntArray(r6)
            int r1 = r6.length
            boolean[] r1 = new boolean[r1]
            r2 = r7
        L31:
            int r3 = r6.length
            if (r2 >= r3) goto L41
            r3 = r6[r2]
            if (r3 == 0) goto L3a
            r3 = r0
            goto L3b
        L3a:
            r3 = r7
        L3b:
            r1[r2] = r3
            int r2 = r2 + 1
            goto L31
        L40:
            r1 = r8
        L41:
            r4.Z = r1
            r6 = 4
            int r6 = r5.getResourceId(r6, r7)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r6 != 0) goto L4c
            r1 = r8
            goto L83
        L4c:
            android.content.Context r1 = com.quickcursor.App.c     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            android.content.res.TypedArray r6 = r1.obtainTypedArray(r6)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L73
            int[] r1 = new int[r1]     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L73
            r2 = r7
        L5d:
            int r3 = r6.length()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            if (r2 >= r3) goto L6f
            int r3 = r6.getResourceId(r2, r7)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            r1[r2] = r3     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            int r2 = r2 + 1
            goto L5d
        L6c:
            r4 = move-exception
            r8 = r6
            goto L7a
        L6f:
            r6.recycle()
            goto L83
        L73:
            r1 = r8
            goto L80
        L75:
            r4 = move-exception
            goto L7a
        L77:
            r6 = r8
            r1 = r6
            goto L80
        L7a:
            if (r8 == 0) goto L7f
            r8.recycle()
        L7f:
            throw r4
        L80:
            if (r6 == 0) goto L83
            goto L6f
        L83:
            r4.b0 = r1
            java.lang.String r6 = r5.getString(r0)
            r4.d0 = r6
            int r6 = r5.getResourceId(r7, r7)     // Catch: java.lang.Exception -> L98
            android.content.Context r7 = com.quickcursor.App.c     // Catch: java.lang.Exception -> L98
            android.graphics.drawable.Drawable r6 = defpackage.lc1.A(r7, r6)     // Catch: java.lang.Exception -> L98
            r4.c0 = r6     // Catch: java.lang.Exception -> L98
            goto L9a
        L98:
            r4.c0 = r8
        L9a:
            r5.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quickcursor.android.preferences.DetailedListPreference.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    @Override // androidx.preference.DialogPreference
    public final CharSequence J() {
        return this.d0;
    }

    public final void N() {
        AppCompatImageView appCompatImageView = this.f0;
        if (appCompatImageView != null) {
            int i = this.c0 == null ? 8 : 0;
            appCompatImageView.setVisibility(i);
            this.g0.setVisibility(i);
            this.f0.setImageDrawable(this.c0);
            this.f0.setAlpha(j() ? 1.0f : 0.3f);
            this.f0.setEnabled(j());
        }
    }

    public final void O(Integer num) {
        Drawable drawableA;
        if (num == null) {
            drawableA = null;
        } else {
            drawableA = lc1.A(App.c, num.intValue());
        }
        this.c0 = drawableA;
        N();
    }

    @Override // androidx.preference.ListPreference, androidx.preference.Preference
    public final CharSequence i() {
        return L();
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        View view = nq0Var.a;
        this.f0 = (AppCompatImageView) view.findViewById(R.id.edit_button);
        this.g0 = view.findViewById(R.id.edit_separator);
        this.f0.setOnClickListener(new a3(5, this));
        N();
    }

    public DetailedListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dialogPreferenceStyle);
        this.F = R.layout.preference_action_chooser;
    }

    public DetailedListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, i);
        this.F = R.layout.preference_action_chooser;
    }

    public DetailedListPreference(Context context) {
        this(context, null);
        this.F = R.layout.preference_action_chooser;
    }
}
