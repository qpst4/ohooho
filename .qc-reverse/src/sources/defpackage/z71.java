package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.preferences.SeekBarDialogPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class z71 extends ir {
    public TrackerActionsSettings h0;
    public Preference i0;
    public SeekBarDialogPreference j0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        i3 i3VarValueOf;
        k0(str, R.xml.preferences_tracker_center_action);
        this.h0 = (TrackerActionsSettings) Z();
        ((TrackerActionsSettings) Z()).L(s71.e.c.size());
        Preference preferenceH0 = h0("trackerActionsCenterAction");
        this.i0 = preferenceH0;
        preferenceH0.g = new y71(this, 0 == true ? 1 : 0);
        int i = 1;
        h0("trackerActionsCenterActionIcon").f = new y71(this, i);
        SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) h0("trackerActionsCenterActionTriggerDelay");
        this.j0 = seekBarDialogPreference;
        pn0 pn0VarT = pn0.t();
        pn0VarT.getClass();
        try {
            i3VarValueOf = i3.valueOf(oq0.d((SharedPreferences) pn0VarT.d, oq0.J0));
        } catch (Exception unused) {
            i3VarValueOf = i3.valueOf((String) oq0.J0.b);
        }
        seekBarDialogPreference.F(i3VarValueOf == i3.delayed);
        this.j0.f = new y71(this, i);
        h0("trackerActionsCenterActionTriggerMode").f = new y71(this, 2);
        this.i0.E(lc1.K(s71.e.d.b().titleId));
        fp1.n(this);
    }
}
