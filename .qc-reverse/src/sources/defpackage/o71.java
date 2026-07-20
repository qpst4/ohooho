package defpackage;

import android.os.Bundle;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class o71 extends ir {
    public TrackerActionsSettings h0;

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        k0(str, R.xml.preferences_tracker_actions_design);
        TrackerActionsSettings trackerActionsSettings = (TrackerActionsSettings) Z();
        this.h0 = trackerActionsSettings;
        trackerActionsSettings.L(-1);
        Iterator it = Arrays.asList(oq0.x0, oq0.v0, oq0.z0, oq0.B0, oq0.w0, oq0.y0, oq0.A0, oq0.C0).iterator();
        while (it.hasNext()) {
            h0(((oq0) it.next()).name()).f = new n71(this);
        }
        h0("trackerActionsResetDesign").g = new n71(this);
        fp1.n(this);
    }
}
