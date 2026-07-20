package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y71 implements aq0, zp0, q2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ z71 c;

    public /* synthetic */ y71(z71 z71Var, int i) {
        this.b = i;
        this.c = z71Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        z71 z71Var = this.c;
        switch (i) {
            case 1:
                String str = preference.m;
                if (str.equals(oq0.I0.name())) {
                    TrackerActionsSettings trackerActionsSettings = z71Var.h0;
                    trackerActionsSettings.E.o();
                    trackerActionsSettings.E.setAlphaAnimation(1.0f);
                    trackerActionsSettings.E.setActionsAnimation(1.0f);
                    trackerActionsSettings.E.w = ((Boolean) obj).booleanValue();
                    trackerActionsSettings.E.invalidateSelf();
                    trackerActionsSettings.C.a(new s4(18));
                } else if (str.equals(oq0.K0.name())) {
                    z71Var.h0.K();
                }
                break;
            default:
                z71Var.j0.F(i3.delayed.name().equals((String) obj));
                b61.b(new lk0(15, z71Var), 10L);
                break;
        }
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        z71 z71Var = this.c;
        r2.o0(z71Var.l(), n3.b(2), new ArrayList(), new ArrayList(), new y71(z71Var, 3));
        return true;
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        if (iVar == null) {
            return;
        }
        if (!zq0.b.c()) {
            yb0.y(R.string.setting_not_available_for_free_version, 0);
            return;
        }
        s71 s71Var = s71.e;
        s71Var.d = new j71(iVar);
        s71Var.c();
        z71 z71Var = this.c;
        z71Var.i0.E(lc1.K(s71Var.d.b().titleId));
        ((TrackerActionsSettings) z71Var.Z()).K();
    }
}
