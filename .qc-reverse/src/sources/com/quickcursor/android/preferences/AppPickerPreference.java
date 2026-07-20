package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.quickcursor.R;
import defpackage.lc1;
import defpackage.ms0;
import defpackage.za;
import defpackage.zy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppPickerPreference extends Preference {
    public Set O;
    public String P;
    public final int Q;
    public final boolean R;
    public final boolean S;
    public final PackageManager T;

    public AppPickerPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3 = 1;
        if (attributeSet == null) {
            this.R = false;
            this.S = false;
            this.Q = 1;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.b, 0, 0);
            this.R = typedArrayObtainStyledAttributes.getBoolean(1, false);
            this.S = typedArrayObtainStyledAttributes.getBoolean(0, false);
            String string = typedArrayObtainStyledAttributes.getString(2);
            if (string != null) {
                if (!string.equals("App")) {
                    if (string.equals("IconPackApp")) {
                        i3 = 2;
                    } else if (string.equals("Shortcut")) {
                        i3 = 3;
                    } else {
                        zy.n("No enum constant com.quickcursor.android.fragments.AppPickerDialogFragment.Type.".concat(string));
                    }
                }
                this.Q = i3;
                typedArrayObtainStyledAttributes.recycle();
            } else {
                zy.r("Name is null");
            }
            i3 = 0;
            this.Q = i3;
            typedArrayObtainStyledAttributes.recycle();
        }
        this.T = context.getPackageManager();
        this.g = new za(this);
    }

    @Override // androidx.preference.Preference
    public final CharSequence i() {
        boolean z = this.R;
        PackageManager packageManager = this.T;
        if (!z) {
            String str = this.P;
            if (str == null || str.isEmpty()) {
                return lc1.K(R.string.preference_app_picker_no_app_selected);
            }
            String str2 = this.P;
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str2, 0)).toString();
            } catch (Exception unused) {
                return str2;
            }
        }
        Set set = this.O;
        if (set == null || set.isEmpty()) {
            return lc1.K(R.string.app_picker_preference_no_apps_selected);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lc1.K(R.string.app_picker_preference_currently_selected_apps));
        sb.append(" (");
        sb.append(this.O.size());
        sb.append("): ");
        Set<String> set2 = this.O;
        StringBuilder sb2 = new StringBuilder();
        for (String string : set2) {
            try {
                string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(string, 0)).toString();
            } catch (Exception unused2) {
            }
            sb2.append(string);
            sb2.append(", ");
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 2);
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    @Override // androidx.preference.Preference
    public final void v(Object obj, boolean z) {
        if (z) {
            if (this.R) {
                this.O = h(new HashSet());
            } else {
                this.P = g("");
            }
        }
    }

    public AppPickerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.preferenceStyle, 0);
    }
}
