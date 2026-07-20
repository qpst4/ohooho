package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.TickSeekBarPreference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l71 extends ir implements m3 {
    public static final /* synthetic */ int p0 = 0;
    public final j71 h0;
    public ActionPickerPreference j0;
    public SwitchPreference k0;
    public DetailedListPreference l0;
    public TickSeekBarPreference m0;
    public qs n0;
    public final d30 o0 = (d30) Y(new k71(this, 6), new f4(2));
    public final List i0 = s71.e.c;

    public l71(j71 j71Var) {
        this.h0 = j71Var;
    }

    public static String[] l0(int i) {
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            StringBuilder sb = new StringBuilder();
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append("");
            strArr[i2] = sb.toString();
            i2 = i3;
        }
        return strArr;
    }

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        k0(str, R.xml.preferences_tracker_action);
        TrackerActionsSettings trackerActionsSettings = (TrackerActionsSettings) Z();
        List list = this.i0;
        j71 j71Var = this.h0;
        trackerActionsSettings.L(list.indexOf(j71Var));
        ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0("actionType");
        this.j0 = actionPickerPreference;
        actionPickerPreference.P = this;
        actionPickerPreference.K(j71Var);
        this.j0.g = new k71(this, 0);
        DetailedListPreference detailedListPreference = (DetailedListPreference) h0("trackerActionTriggerMode");
        this.l0 = detailedListPreference;
        detailedListPreference.f = new k71(this, 1);
        detailedListPreference.M(j71Var.a().name());
        SwitchPreference switchPreference = (SwitchPreference) h0("hideTrackerAfter");
        this.k0 = switchPreference;
        switchPreference.f = new k71(this, 2);
        switchPreference.J(j71Var.j());
        int i = 4;
        int i2 = 3;
        this.l0.U = new CharSequence[]{lc1.K(R.string.action_trigger_mode_default_title), lc1.K(R.string.action_trigger_mode_instant_title), lc1.K(R.string.action_trigger_mode_on_release_title), f01.P(R.string.action_trigger_mode_delayed_title_with_delay_ms, "delay", oq0.c((SharedPreferences) pn0.t().d, oq0.H0) + "")};
        m0();
        if (list.size() <= 1) {
            h0("actionPosition").F(false);
            h0("actionSize").F(false);
        } else {
            this.m0 = (TickSeekBarPreference) h0("actionPosition");
            TickSeekBarPreference tickSeekBarPreference = (TickSeekBarPreference) h0("actionSize");
            this.m0.f = new k71(this, i2);
            tickSeekBarPreference.f = new k71(this, i);
            tickSeekBarPreference.J(10, l0(10), j71Var.i());
            this.m0.J(list.size(), l0(list.size()), list.indexOf(j71Var) + 1);
            h0("actionDelete").g = new k71(this, 5);
        }
        fp1.n(this);
    }

    public final void m0() {
        j71 j71Var = this.h0;
        boolean zY = xr.y(j71Var.b().requirements, 1);
        DetailedListPreference detailedListPreference = this.l0;
        if (zY) {
            detailedListPreference.B(false);
            this.l0.M(i3.onRelease.name());
        } else {
            detailedListPreference.B(true);
            this.l0.M(j71Var.a().name());
        }
        boolean zY2 = xr.y(j71Var.b().requirements, 16384);
        SwitchPreference switchPreference = this.k0;
        if (zY2) {
            switchPreference.B(false);
            this.k0.J(false);
        } else {
            switchPreference.B(true);
            this.k0.J(j71Var.j());
        }
    }

    @Override // defpackage.m3
    public final void n(Intent intent, e4 e4Var) {
        this.n0 = (qs) e4Var;
        this.o0.a(intent);
    }

    @Override // defpackage.m3
    public final void q(i iVar) {
        if (!zq0.b.c()) {
            yb0.y(R.string.setting_not_available_for_free_version, 0);
            return;
        }
        this.h0.e(iVar);
        this.j0.J();
        ((TrackerActionsSettings) Z()).K();
    }
}
