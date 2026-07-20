package defpackage;

import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ja1 extends ir {
    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        ey0.e(o());
        k0(str, R.xml.preferences_triggers_mode_disabled);
        Preference preferenceH0 = h0("triggerMode");
        preferenceH0.f = new r1(22, (TriggersSettings) Z());
        preferenceH0.B(true);
    }
}
