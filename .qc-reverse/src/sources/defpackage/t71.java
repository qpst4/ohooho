package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.preferences.DetailedListPreference;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t71 implements zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ w71 c;

    public /* synthetic */ t71(w71 w71Var, int i) {
        this.b = i;
        this.c = w71Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        Integer numValueOf = null;
        w71 w71Var = this.c;
        switch (i) {
            case 0:
                String str = preference.m;
                if (!str.equals(oq0.D0.name())) {
                    boolean zEquals = str.equals(oq0.E0.name());
                    TrackerActionsSettings trackerActionsSettings = w71Var.h0;
                    if (!zEquals) {
                        trackerActionsSettings.K();
                    } else {
                        trackerActionsSettings.E.o();
                        trackerActionsSettings.E.setAlphaAnimation(1.0f);
                        trackerActionsSettings.E.setActionsAnimation(1.0f);
                        trackerActionsSettings.E.p(((Integer) obj).intValue() * 1.0f);
                        trackerActionsSettings.E.invalidateSelf();
                        trackerActionsSettings.C.a(new s4(18));
                    }
                } else if (((Boolean) obj).booleanValue()) {
                    w71Var.j0.L((int) w71.l0());
                    TrackerActionsSettings trackerActionsSettings2 = w71Var.h0;
                    trackerActionsSettings2.E.o();
                    trackerActionsSettings2.E.setAlphaAnimation(1.0f);
                    trackerActionsSettings2.E.setActionsAnimation(1.0f);
                    trackerActionsSettings2.E.p(w71.l0());
                    trackerActionsSettings2.E.invalidateSelf();
                    trackerActionsSettings2.C.a(new s4(18));
                }
                break;
            case 1:
                String str2 = (String) obj;
                DetailedListPreference detailedListPreference = w71Var.l0;
                s71 s71Var = s71.e;
                if (s71Var.d.a() == i3.delayed) {
                    numValueOf = Integer.valueOf(R.drawable.icon_time);
                } else {
                    Iterator it = s71Var.c.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((j71) it.next()).a() == i3.delayed) {
                            }
                        } else if (i3.delayed.name().equals(str2)) {
                        }
                    }
                    numValueOf = Integer.valueOf(R.drawable.icon_time);
                }
                detailedListPreference.O(numValueOf);
                b61.b(new u71(w71Var, 1), 10L);
                break;
            default:
                if (!((Boolean) obj).booleanValue()) {
                    pn0.t().S(new j71(n3.longTap, xi0.k));
                    w71Var.h0.K();
                } else {
                    j71 j71VarW = pn0.t().w();
                    if (j71VarW.b() == n3.nothing || j71VarW.b() == n3.longTap) {
                        pn0.t().S(new j71(n3.openTrackerActionsOnce, null));
                        w71Var.h0.K();
                    } else {
                        jl1 jl1Var = new jl1(w71Var.o());
                        jl1Var.m(R.string.are_you_sure);
                        String strP = f01.P(R.string.tracker_actions_settings_confirm_long_tap_tracker_replace, "action", lc1.K(j71VarW.b().titleId));
                        x6 x6Var = (x6) jl1Var.c;
                        x6Var.g = strP;
                        x6Var.c = R.drawable.icon_warning;
                        jl1Var.k(android.R.string.yes, new z2(16, w71Var));
                        jl1Var.h(android.R.string.no, null);
                        jl1Var.n();
                    }
                }
                break;
        }
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        w71 w71Var = this.c;
        switch (i) {
            case 2:
                w71Var.h0.I();
                break;
            default:
                w71Var.h0("trackerActionsAdvancedSettingsShow").F(false);
                w71Var.h0("trackerActionsAdvancedCategory").F(true);
                w71Var.h0("trackerActionsAdvancedOtherWaysCategory").F(true);
                break;
        }
        return true;
    }
}
