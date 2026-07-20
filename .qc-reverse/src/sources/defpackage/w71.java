package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class w71 extends ir {
    public TrackerActionsSettings h0;
    public SwitchPreference i0;
    public SeekBarDialogPreference j0;
    public SwitchPreference k0;
    public DetailedListPreference l0;

    public static float l0() {
        List list = s71.e.c;
        if (list.size() == 0) {
            return 0.0f;
        }
        int iSum = list.stream().mapToInt(new v71(0)).sum();
        if (list.size() == 1) {
            iSum *= 2;
        }
        return ((((360.0f / iSum) * ((j71) list.get(0)).i()) / 2.0f) - 90.0f) * (-1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        i3 i3VarValueOf;
        k0(str, R.xml.preferences_tracker_actions_settings);
        this.h0 = (TrackerActionsSettings) Z();
        ((TrackerActionsSettings) Z()).L(-1);
        this.k0 = (SwitchPreference) h0("trackerLongTapTrackerActions");
        this.i0 = (SwitchPreference) h0("trackerActionsAutoSweepOffset");
        this.j0 = (SeekBarDialogPreference) h0("trackerActionsSweepOffset");
        DetailedListPreference detailedListPreference = (DetailedListPreference) h0("trackerActionsTriggerMode");
        this.l0 = detailedListPreference;
        this.i0.f = new t71(this, 0 == true ? 1 : 0);
        this.j0.f = new t71(this, 0 == true ? 1 : 0);
        detailedListPreference.f = new t71(this, 1);
        h0("trackerActionsTriggerDelay").f = new t71(this, 0 == true ? 1 : 0);
        h0("trackerActionsVibrationFeedback").f = new t71(this, 0 == true ? 1 : 0);
        h0("trackerActionsAlwaysVisible").f = new t71(this, 0 == true ? 1 : 0);
        h0("openCenterActionSettings").g = new t71(this, 2);
        DetailedListPreference detailedListPreference2 = this.l0;
        detailedListPreference2.e0 = new u71(this, 0 == true ? 1 : 0);
        pn0 pn0VarT = pn0.t();
        pn0VarT.getClass();
        try {
            i3VarValueOf = i3.valueOf(oq0.d((SharedPreferences) pn0VarT.d, oq0.F0));
        } catch (Exception unused) {
            i3VarValueOf = i3.valueOf((String) oq0.F0.b);
        }
        detailedListPreference2.O(i3VarValueOf == i3.delayed ? Integer.valueOf(R.drawable.icon_time) : null);
        h0("trackerActionsAdvancedSettingsShow").g = new t71(this, 3);
        h0("trackerActionsAdvancedSettingsShow").F(true);
        h0("trackerActionsAdvancedCategory").F(false);
        h0("trackerActionsAdvancedOtherWaysCategory").F(false);
        this.k0.f = new t71(this, 4);
        this.k0.J(pn0.t().w().b() == n3.openTrackerActionsOnce);
        fp1.o(this, Arrays.asList("trackerActionsAlwaysVisible", "trackerLongTapTrackerActions", "trackerActionsAdvancedSettingsShow"));
    }
}
