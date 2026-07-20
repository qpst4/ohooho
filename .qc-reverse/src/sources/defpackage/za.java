package defpackage;

import androidx.preference.Preference;
import com.quickcursor.android.preferences.AppPickerPreference;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class za implements aq0, xa {
    public final /* synthetic */ AppPickerPreference b;

    public /* synthetic */ za(AppPickerPreference appPickerPreference) {
        this.b = appPickerPreference;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        AppPickerPreference appPickerPreference = this.b;
        int i = appPickerPreference.Q;
        boolean z = appPickerPreference.R;
        new ya(new za(appPickerPreference), i, Boolean.valueOf(z), Boolean.valueOf(appPickerPreference.S), z ? appPickerPreference.O : null).j0(((z7) appPickerPreference.b).w(), "AppPickerDialogFragment");
        return true;
    }

    @Override // defpackage.xa
    public void onResult(Object obj) {
        AppPickerPreference appPickerPreference = this.b;
        if (appPickerPreference.R) {
            Set set = (Set) obj;
            if (set != null && appPickerPreference.a(set)) {
                appPickerPreference.O = set;
                if (appPickerPreference.H()) {
                    appPickerPreference.A(set);
                }
                appPickerPreference.k();
                return;
            }
            return;
        }
        String str = (String) obj;
        if (str != null && appPickerPreference.a(str)) {
            appPickerPreference.P = str;
            if (appPickerPreference.H()) {
                appPickerPreference.z(str);
            }
            appPickerPreference.k();
        }
    }
}
