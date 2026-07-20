package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.preferences.ClickableSwitchPreference;
import com.quickcursor.android.preferences.ColorPreferenceWithDefault;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.quickcursor.android.preferences.TickSeekBarPreference;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uw extends cx {
    public EdgeActionsSettings h0;
    public ClickableSwitchPreference i0;
    public ClickableSwitchPreference j0;
    public ClickableSwitchPreference k0;
    public ClickableSwitchPreference l0;
    public TickSeekBarPreference m0;
    public TickSeekBarPreference n0;
    public SwitchPreference o0;
    public SeekBarDialogPreference p0;
    public ColorPreferenceWithDefault q0;
    public SeekBarDialogPreference r0;
    public SeekBarDialogPreference s0;
    public final boolean t0;
    public DetailedListPreference u0;

    public uw(boolean z) {
        this.t0 = z;
    }

    public static boolean l0() {
        xw xwVar = xw.e;
        return m0(xwVar.d("leftEdgeBar")) || m0(xwVar.d("topEdgeBar")) || m0(xwVar.d("bottomEdgeBar")) || m0(xwVar.d("rightEdgeBar"));
    }

    public static boolean m0(dx dxVar) {
        Iterator it = dxVar.d().iterator();
        while (it.hasNext()) {
            if (((lw) it.next()).a() == i3.delayed) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bx
    public final String i() {
        return lc1.K(R.string.edge_actions_general_subtitle);
    }

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        i3 i3VarValueOf;
        k0(str, R.xml.preferences_edge_actions_general_settings);
        this.h0 = (EdgeActionsSettings) Z();
        this.j0 = (ClickableSwitchPreference) h0("topEdgeBar");
        this.i0 = (ClickableSwitchPreference) h0("leftEdgeBar");
        this.k0 = (ClickableSwitchPreference) h0("rightEdgeBar");
        ClickableSwitchPreference clickableSwitchPreference = (ClickableSwitchPreference) h0("bottomEdgeBar");
        this.l0 = clickableSwitchPreference;
        this.j0.W = this;
        ClickableSwitchPreference clickableSwitchPreference2 = this.i0;
        clickableSwitchPreference2.W = this;
        this.k0.W = this;
        clickableSwitchPreference.W = this;
        xw xwVar = xw.e;
        clickableSwitchPreference2.J(xwVar.d("leftEdgeBar").g().booleanValue());
        this.j0.J(xwVar.d("topEdgeBar").g().booleanValue());
        this.k0.J(xwVar.d("rightEdgeBar").g().booleanValue());
        this.l0.J(xwVar.d("bottomEdgeBar").g().booleanValue());
        this.u0 = (DetailedListPreference) h0("edgeActionsTriggerMode");
        this.m0 = (TickSeekBarPreference) h0("edgeActionsPreviewSensitivity");
        this.n0 = (TickSeekBarPreference) h0("edgeActionsPreviewSize");
        this.o0 = (SwitchPreference) h0("edgeActionsPreviewIcon");
        this.q0 = (ColorPreferenceWithDefault) h0("edgeActionsVisualColor");
        this.r0 = (SeekBarDialogPreference) h0("edgeActionsVisualSize");
        this.p0 = (SeekBarDialogPreference) h0("edgeActionsDelay");
        SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) h0("edgeActionsVisualOpacity");
        this.s0 = seekBarDialogPreference;
        int i = 0;
        int i2 = 1;
        seekBarDialogPreference.B(this.r0.d0 > 0);
        TickSeekBarPreference tickSeekBarPreference = this.m0;
        tickSeekBarPreference.f = new tw(this, i);
        p0(tickSeekBarPreference.T);
        int i3 = 3;
        this.n0.f = new tw(this, i3);
        this.o0.f = new tw(this, i3);
        this.p0.f = new tw(this, i3);
        this.q0.f = new tw(this, i3);
        this.r0.f = new tw(this, 4);
        this.s0.f = new tw(this, i3);
        DetailedListPreference detailedListPreference = this.u0;
        detailedListPreference.f = new tw(this, 5);
        detailedListPreference.e0 = new c(22, this);
        h0("edgeActionsResetDefault").g = new tw(this, 6);
        h0("edgeActionsAdvancedSettingsShow").g = new tw(this, i2);
        SeekBarDialogPreference seekBarDialogPreference2 = (SeekBarDialogPreference) h0("edgeActionsThreshold");
        seekBarDialogPreference2.L((int) oq0.b((SharedPreferences) pn0.t().d, oq0.k0));
        seekBarDialogPreference2.f = new tw(this, 2);
        boolean z = this.t0;
        if (z || !zq0.b.c()) {
            o0(true);
            if (z) {
                nc ncVar = new nc(11, this);
                if (this.a0 == null) {
                    this.e0 = ncVar;
                } else {
                    ncVar.run();
                }
            }
        } else {
            o0(false);
        }
        DetailedListPreference detailedListPreference2 = this.u0;
        pn0 pn0VarT = pn0.t();
        pn0VarT.getClass();
        try {
            i3VarValueOf = i3.valueOf(oq0.d((SharedPreferences) pn0VarT.d, oq0.u0));
        } catch (Exception unused) {
            i3VarValueOf = i3.valueOf((String) oq0.u0.b);
        }
        detailedListPreference2.O((i3VarValueOf == i3.delayed || l0()) ? Integer.valueOf(R.drawable.icon_time) : null);
        fp1.o(this, Arrays.asList("topEdgeBar", "edgeActionsThreshold", "edgeActionsPreviewSensitivity", "edgeActionsPreviewSize"));
    }

    public final void n0() {
        this.h0.I();
    }

    public final void o0(boolean z) {
        h0("edgeActionsAdvancedSettingsShow").F(!z);
        h0("edgeActionsSensitivityCategory").F(z);
        h0("edgeActionsVisualCategory").F(z);
        h0("edgeActionsFeedbackCategory").F(z);
    }

    public final void p0(int i) {
        boolean z = false;
        this.n0.B(i > 0);
        SwitchPreference switchPreference = this.o0;
        if (i > 0 && zq0.b.c()) {
            z = true;
        }
        switchPreference.B(z);
    }
}
