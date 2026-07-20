package defpackage;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n71 implements zp0, aq0 {
    public final /* synthetic */ o71 b;

    public /* synthetic */ n71(o71 o71Var) {
        this.b = o71Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        String str = preference.m;
        oq0 oq0Var = oq0.x0;
        boolean zEquals = str.equals(oq0Var.name());
        o71 o71Var = this.b;
        if (zEquals) {
            o71Var.h0.M(((Integer) obj).intValue(), (int) oq0.b((SharedPreferences) pn0.t().d, oq0.z0));
        }
        if (str.equals(oq0.y0.name())) {
            TrackerActionsSettings trackerActionsSettings = o71Var.h0;
            trackerActionsSettings.E.o();
            trackerActionsSettings.E.setAlphaAnimation(1.0f);
            trackerActionsSettings.E.setActionsAnimation(1.0f);
            trackerActionsSettings.E.s = ((Integer) obj).intValue();
            trackerActionsSettings.E.invalidateSelf();
            trackerActionsSettings.C.a(new s4(18));
        }
        if (str.equals(oq0.v0.name())) {
            TrackerActionsSettings trackerActionsSettings2 = o71Var.h0;
            trackerActionsSettings2.E.o();
            trackerActionsSettings2.E.setAlphaAnimation(1.0f);
            trackerActionsSettings2.E.setActionsAnimation(1.0f);
            TrackerDrawable trackerDrawable = trackerActionsSettings2.E;
            trackerDrawable.o = Math.min(trackerDrawable.n, ((Integer) obj).intValue() / 2);
            trackerActionsSettings2.E.invalidateSelf();
            trackerActionsSettings2.C.a(new s4(18));
        }
        if (str.equals(oq0.z0.name())) {
            o71Var.h0.M((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var), ((Integer) obj).intValue());
        }
        if (str.equals(oq0.B0.name())) {
            TrackerActionsSettings trackerActionsSettings3 = o71Var.h0;
            trackerActionsSettings3.E.o();
            trackerActionsSettings3.E.setAlphaAnimation(1.0f);
            trackerActionsSettings3.E.setActionsAnimation(1.0f);
            trackerActionsSettings3.E.p = ((Integer) obj).intValue();
            trackerActionsSettings3.E.invalidateSelf();
            trackerActionsSettings3.C.a(new s4(18));
        }
        if (str.equals(oq0.w0.name())) {
            TrackerActionsSettings trackerActionsSettings4 = o71Var.h0;
            trackerActionsSettings4.E.o();
            trackerActionsSettings4.E.setAlphaAnimation(1.0f);
            trackerActionsSettings4.E.setActionsAnimation(1.0f);
            trackerActionsSettings4.E.r = ((Integer) obj).intValue();
            trackerActionsSettings4.E.invalidateSelf();
            trackerActionsSettings4.C.a(new s4(18));
        }
        if (str.equals(oq0.A0.name())) {
            TrackerActionsSettings trackerActionsSettings5 = o71Var.h0;
            trackerActionsSettings5.E.o();
            trackerActionsSettings5.E.setAlphaAnimation(1.0f);
            trackerActionsSettings5.E.setActionsAnimation(1.0f);
            trackerActionsSettings5.E.t = ((Integer) obj).intValue();
            trackerActionsSettings5.E.invalidateSelf();
            trackerActionsSettings5.C.a(new s4(18));
        }
        if (!str.equals(oq0.C0.name())) {
            return true;
        }
        TrackerActionsSettings trackerActionsSettings6 = o71Var.h0;
        trackerActionsSettings6.E.o();
        trackerActionsSettings6.E.setAlphaAnimation(1.0f);
        trackerActionsSettings6.E.setActionsAnimation(1.0f);
        trackerActionsSettings6.E.u = ((Integer) obj).intValue();
        trackerActionsSettings6.E.invalidateSelf();
        trackerActionsSettings6.C.a(new s4(18));
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        o71 o71Var = this.b;
        jl1 jl1Var = new jl1(o71Var.o());
        jl1Var.m(R.string.are_you_sure);
        jl1Var.g(R.string.confirmation_reset_tracker_actions_design_settings);
        ((x6) jl1Var.c).c = R.drawable.icon_warning;
        jl1Var.k(android.R.string.yes, new z2(15, o71Var));
        jl1Var.h(android.R.string.no, null);
        jl1Var.n();
        return true;
    }
}
