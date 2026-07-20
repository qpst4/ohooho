package com.quickcursor.android.activities.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import com.quickcursor.R;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.CustomSwitchPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import defpackage.b61;
import defpackage.bk;
import defpackage.d30;
import defpackage.f4;
import defpackage.fp1;
import defpackage.i41;
import defpackage.ir;
import defpackage.j41;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.pq0;
import defpackage.qs;
import defpackage.wj;
import defpackage.xr;
import defpackage.y30;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TapBehaviourSettings extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public DetailedListPreference i0;
        public PreferenceCategory j0;
        public ActionPickerPreference k0;
        public ActionPickerPreference l0;
        public ActionPickerPreference m0;
        public qs n0;
        public final bk h0 = new bk(200);
        public final d30 o0 = (d30) Y(new i41(this, 0), new f4(2));

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_tap_behaviour);
            this.i0 = (DetailedListPreference) h0(oq0.l.name());
            this.j0 = (PreferenceCategory) h0("auto_tap_settings");
            this.k0 = (ActionPickerPreference) h0(oq0.N0.name());
            this.l0 = (ActionPickerPreference) h0(oq0.P0.name());
            ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0(oq0.R0.name());
            this.m0 = actionPickerPreference;
            ActionPickerPreference actionPickerPreference2 = this.k0;
            actionPickerPreference2.P = new c(this, actionPickerPreference2);
            ActionPickerPreference actionPickerPreference3 = this.l0;
            actionPickerPreference3.P = new c(this, actionPickerPreference3);
            actionPickerPreference.P = new c(this, actionPickerPreference);
            actionPickerPreference2.g = new i41(this, 4);
            actionPickerPreference3.g = new i41(this, 7);
            actionPickerPreference.g = new i41(this, 8);
            actionPickerPreference2.K(pn0.t().w());
            this.l0.K(pn0.t().s());
            this.m0.K(pn0.t().y());
            ActionPickerPreference actionPickerPreference4 = this.k0;
            actionPickerPreference4.T = new j41(this, 3);
            this.l0.T = new j41(this, 4);
            actionPickerPreference4.B(!oq0.a((SharedPreferences) pn0.t().d, oq0.e1));
            oq0 oq0Var = oq0.M;
            ((SeekBarDialogPreference) h0(oq0Var.name())).L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var));
            int i = 5;
            h0("clickDistanceThreshold").f = new i41(this, i);
            oq0 oq0Var2 = oq0.M0;
            h0(oq0Var2.name()).f = new i41(this, i);
            h0("autoTapMode").f = new i41(this, i);
            h0(oq0.L.name()).f = new i41(this, i);
            h0(oq0.O0.name()).f = new i41(this, i);
            h0(oq0.Q0.name()).f = new i41(this, i);
            h0(oq0.P.name()).f = new i41(this, i);
            h0(oq0.Q.name()).f = new i41(this, i);
            h0(oq0.e0.name()).f = new i41(this, i);
            h0(oq0.f0.name()).f = new i41(this, i);
            this.i0.e0 = new j41(this, 1);
            ((CustomSwitchPreference) h0("hideTimeoutEnabled")).X = new j41(this, 2);
            h0("tap_behaviour_reset").g = new i41(this, 6);
            m0(oq0.a((SharedPreferences) pn0.t().d, oq0Var2));
            l0(pn0.t().j());
            fp1.o(this, Arrays.asList("longTapTrackerAction", "longTapTrackerThreshold", "secondTapTrackerAction", "clickDistanceThreshold", "limitedMode", "dispatchBugPopup"));
        }

        public final void l0(pq0 pq0Var) {
            ActionPickerPreference actionPickerPreference = this.l0;
            pq0 pq0Var2 = pq0.d;
            actionPickerPreference.B(pq0Var != pq0Var2);
            h0(oq0.Q0.name()).B(pq0Var != pq0Var2);
            b61.b(new j41(this, 0), 1L);
            DetailedListPreference detailedListPreference = this.i0;
            pq0 pq0Var3 = pq0.b;
            detailedListPreference.O(pq0Var != pq0Var3 ? Integer.valueOf(R.drawable.icon_time) : null);
            this.j0.K(2).F(pq0Var != pq0Var3);
        }

        public final void m0(boolean z) {
            PreferenceScreen preferenceScreen = this.Z.g;
            ArrayList arrayList = new ArrayList();
            xr.v(preferenceScreen, arrayList);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Preference preference = (Preference) obj;
                if (preference.m.equals("ignore")) {
                    preference.F(z);
                }
            }
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity_with_pro_overlay);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(14));
    }
}
