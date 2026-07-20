package com.quickcursor.android.preferences;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import defpackage.lf0;
import defpackage.r1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class WindowConfigPreference extends Preference {
    public String O;
    public lf0 P;

    public WindowConfigPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new r1(24, this);
    }

    @Override // androidx.preference.Preference
    public final CharSequence i() {
        return this.O;
    }
}
