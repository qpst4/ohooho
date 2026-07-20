package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.ColorPreferenceWithDefault;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.TickSeekBarPreference;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qw extends cx implements m3 {
    public nw h0;
    public final EdgeBarConstraintLayout i0;
    public ActionPickerPreference j0;
    public DetailedListPreference k0;
    public TickSeekBarPreference l0;
    public ColorPreferenceWithDefault m0;
    public final int n0;
    public int o0;
    public qs p0;
    public final d30 q0 = (d30) Y(new ow(this, 0), new f4(2));

    public qw(nw nwVar, EdgeBarConstraintLayout edgeBarConstraintLayout) {
        this.h0 = nwVar;
        this.i0 = edgeBarConstraintLayout;
        this.n0 = edgeBarConstraintLayout.getEdgeBar().c();
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

    @Override // defpackage.cx, defpackage.bx
    public final Runnable f() {
        return new pw(this, 1);
    }

    @Override // defpackage.bx
    public final String i() {
        return lc1.K(R.string.edge_actions_settings_action_subtitle);
    }

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        k0(str, R.xml.preferences_edge_action_settings);
        this.o0 = oq0.c((SharedPreferences) pn0.t().d, oq0.r0);
        ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0("actionType");
        this.j0 = actionPickerPreference;
        actionPickerPreference.P = this;
        actionPickerPreference.K(this.h0.getEdgeAction());
        this.j0.g = new ow(this, 2);
        DetailedListPreference detailedListPreference = (DetailedListPreference) h0("edgeActionTriggerMode");
        this.k0 = detailedListPreference;
        detailedListPreference.f = new ow(this, 3);
        detailedListPreference.M(this.h0.getEdgeAction().a().name());
        this.k0.U = new CharSequence[]{lc1.K(R.string.action_trigger_mode_default_title), lc1.K(R.string.action_trigger_mode_instant_title), lc1.K(R.string.action_trigger_mode_on_release_title), f01.P(R.string.action_trigger_mode_delayed_title_with_delay_ms, "delay", oq0.c((SharedPreferences) pn0.t().d, oq0.l0) + "")};
        ColorPreferenceWithDefault colorPreferenceWithDefault = (ColorPreferenceWithDefault) h0("edgeActionVisualColor");
        this.m0 = colorPreferenceWithDefault;
        colorPreferenceWithDefault.f = new ow(this, 4);
        Integer numValueOf = Integer.valueOf(this.o0);
        colorPreferenceWithDefault.u = numValueOf;
        colorPreferenceWithDefault.V = numValueOf;
        colorPreferenceWithDefault.a0 = numValueOf;
        this.m0.L(Integer.valueOf(this.h0.getEdgeAction().i() == null ? this.o0 : this.h0.getEdgeAction().i().intValue()));
        m0();
        int i = this.n0;
        if (i <= 1) {
            this.Z.g.K(1).F(false);
            this.Z.g.K(2).F(false);
        } else {
            this.l0 = (TickSeekBarPreference) h0("actionPosition");
            TickSeekBarPreference tickSeekBarPreference = (TickSeekBarPreference) h0("actionSize");
            this.l0.f = new ow(this, 5);
            tickSeekBarPreference.f = new ow(this, 6);
            tickSeekBarPreference.J(10, l0(10), this.h0.getEdgeAction().j());
            this.l0.J(i, l0(i), this.i0.E.a(this.h0) + 1);
            h0("actionDelete").g = new ow(this, 7);
        }
        fp1.n(this);
    }

    public final void m0() {
        boolean zY = xr.y(this.h0.getEdgeAction().b().requirements, 1);
        DetailedListPreference detailedListPreference = this.k0;
        if (zY) {
            detailedListPreference.B(false);
            this.k0.M(i3.onRelease.name());
        } else {
            detailedListPreference.B(true);
            this.k0.M(this.h0.getEdgeAction().a().name());
        }
    }

    @Override // defpackage.m3
    public final void n(Intent intent, e4 e4Var) {
        this.p0 = (qs) e4Var;
        this.q0.a(intent);
    }

    @Override // defpackage.m3
    public final void q(i iVar) {
        if (!zq0.b.c()) {
            yb0.y(R.string.setting_not_available_for_free_version, 0);
            return;
        }
        this.h0.getEdgeAction().e(iVar);
        this.j0.J();
        ((EdgeActionsSettings) Z()).L(this.i0.getEdgeBar());
    }
}
