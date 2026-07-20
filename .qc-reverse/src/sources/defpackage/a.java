package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.activities.AboutActivity;
import com.quickcursor.android.activities.BatteryOptimizationsActivity;
import com.quickcursor.android.activities.BuyProActivity;
import com.quickcursor.android.activities.HowToUseActivity;
import com.quickcursor.android.activities.OpenSourceActivity;
import com.quickcursor.android.activities.SettingsActivity;
import com.quickcursor.android.activities.ThanksProActivity;
import com.quickcursor.android.activities.settings.BackupAndRestoreSettings;
import com.quickcursor.android.activities.settings.BlacklistSettings;
import com.quickcursor.android.activities.settings.CursorSettings;
import com.quickcursor.android.activities.settings.DebugSettings;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.activities.settings.InputDispatcherBug;
import com.quickcursor.android.activities.settings.MissingPermissions;
import com.quickcursor.android.activities.settings.TapBehaviourSettings;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.activities.settings.TrackerSettings;
import com.quickcursor.android.activities.settings.VibrationsAndVisualSettings;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.AdvancedTriggerActivity;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.TriggerActionEditActivity;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.design.TriggerActionsDesignActionIconActivity;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.design.TriggerActionsDesignPieActivity;
import java.util.HashMap;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                int i = AboutActivity.B;
                ((j1) obj).t(R.string.activity_title_about);
                break;
            case 1:
                j1 j1Var = (j1) obj;
                int i2 = AdvancedTriggerActivity.H;
                j1Var.t(R.string.advanced_trigger_editor_title);
                j1Var.o(true);
                break;
            case 2:
                int i3 = BackupAndRestoreSettings.C;
                ((j1) obj).t(R.string.activity_title_backup_and_restore);
                break;
            case 3:
                int i4 = BatteryOptimizationsActivity.B;
                ((j1) obj).t(R.string.activity_title_battery_optimizations);
                break;
            case 4:
                int i5 = BlacklistSettings.C;
                ((j1) obj).t(R.string.activity_title_blacklist);
                break;
            case 5:
                j1 j1Var2 = (j1) obj;
                int i6 = BuyProActivity.H;
                j1Var2.u("PRO");
                j1Var2.o(true);
                break;
            case 6:
                int i7 = CursorSettings.D;
                ((j1) obj).t(R.string.activity_title_cursor);
                break;
            case 7:
                int i8 = DebugSettings.C;
                ((j1) obj).t(R.string.activity_title_debug);
                break;
            case 8:
                int i9 = EdgeActionsSettings.S;
                ((j1) obj).o(true);
                break;
            case 9:
                int i10 = HowToUseActivity.C;
                ((j1) obj).t(R.string.activity_title_how_to_use);
                break;
            case 10:
                j1 j1Var3 = (j1) obj;
                int i11 = InputDispatcherBug.C;
                j1Var3.t(R.string.input_dispatcher_bug_title);
                j1Var3.o(true);
                break;
            case 11:
                j1 j1Var4 = (j1) obj;
                int i12 = MissingPermissions.D;
                j1Var4.t(R.string.activity_title_missing_permissions);
                j1Var4.o(true);
                break;
            case 12:
                int i13 = OpenSourceActivity.B;
                ((j1) obj).t(R.string.activity_title_open_source);
                break;
            case 13:
                int i14 = SettingsActivity.C;
                ((j1) obj).t(R.string.activity_title_settings);
                break;
            case 14:
                int i15 = TapBehaviourSettings.C;
                ((j1) obj).t(R.string.activity_title_tap_behaviour);
                break;
            case 15:
                int i16 = ThanksProActivity.D;
                ((j1) obj).t(R.string.thanks_pro_activity_subtitle);
                break;
            case 16:
                int i17 = TrackerActionsSettings.I;
                ((j1) obj).o(true);
                break;
            case 17:
                int i18 = TrackerSettings.D;
                ((j1) obj).t(R.string.activity_title_tracker);
                break;
            case 18:
                j1 j1Var5 = (j1) obj;
                int i19 = TriggerActionEditActivity.F;
                j1Var5.t(R.string.activity_trigger_action_edit_title);
                j1Var5.o(true);
                break;
            case 19:
                j1 j1Var6 = (j1) obj;
                int i20 = TriggerActionsDesignActionIconActivity.D;
                j1Var6.t(R.string.activity_trigger_actions_design_action_icon_title);
                j1Var6.o(true);
                break;
            case 20:
                j1 j1Var7 = (j1) obj;
                int i21 = TriggerActionsDesignPieActivity.D;
                j1Var7.t(R.string.activity_trigger_actions_design_pie_title);
                j1Var7.o(true);
                break;
            case 21:
                ((f91) obj).b().j().n((int) dn.I0);
                break;
            case 22:
                ((f91) obj).b().j().n((int) dn.I0);
                break;
            case 23:
                ((j71) obj).k(false);
                break;
            case 24:
                j jVar = (j) obj;
                if (jVar.b() == n3.brightnessBar) {
                    jVar.c().put("showBar", Boolean.valueOf(dn.M2));
                    si0.b("Update brightnessBar action, set 'showBar'");
                } else if (jVar.b() == n3.volumeBar) {
                    jVar.c().put("showBar", Boolean.valueOf(dn.L2));
                    si0.b("Update volumeBar action, set 'showBar'");
                } else if (jVar.b() == n3.toggleSoundProfile) {
                    jVar.h(new HashMap());
                    jVar.c().put("profiles", "0,1,2");
                    si0.b("Update toggleSoundProfile action, set 'profiles'");
                } else if (jVar.b() == n3.shortcutToggleCursor || jVar.b() == n3.shortcutTriggerCursor) {
                    HashMap mapC = jVar.c();
                    mapC.put("trigger", mapC.get("zone"));
                    mapC.remove("zone");
                    si0.b("Update '" + jVar.b() + "', rename 'zone' to 'trigger'");
                }
                break;
            default:
                int i22 = VibrationsAndVisualSettings.C;
                ((j1) obj).t(R.string.activity_title_vibrations_and_visual);
                break;
        }
    }
}
