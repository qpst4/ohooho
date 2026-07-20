package defpackage;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TapBehaviourSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i41 implements e4, q2, aq0, zp0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ TapBehaviourSettings.a c;

    public /* synthetic */ i41(TapBehaviourSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        String str = preference.m;
        boolean zEquals = str.equals(oq0.M0.name());
        TapBehaviourSettings.a aVar = this.c;
        if (zEquals) {
            aVar.m0(((Boolean) obj).booleanValue());
        } else if (str.equals(oq0.l.name())) {
            aVar.l0(pq0.valueOf((String) obj));
        }
        aVar.h0.a(new s4(15));
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.c.n0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        TapBehaviourSettings.a aVar = this.c;
        int i2 = 1;
        switch (i) {
            case 4:
                y30 y30VarL = aVar.l();
                List listB = n3.b(4);
                n3 n3Var = n3.nothing;
                n3 n3Var2 = n3.longTap;
                n3 n3Var3 = n3.realtimeGesture;
                n3 n3Var4 = n3.startGestureRecorder;
                r2.o0(y30VarL, listB, Arrays.asList(n3Var, n3Var2, n3Var3, n3Var4, n3.openTrackerActionsOnce, n3.copy), Arrays.asList(n3Var, n3Var2, n3Var4, n3.expandNotifications, n3.expandQuickSettings, n3.takeScreenshot, n3.multiTap), new i41(aVar, 3));
                break;
            case 5:
            default:
                y30 y30VarL2 = aVar.l();
                List listB2 = n3.b(16);
                n3 n3Var5 = n3.nothing;
                n3 n3Var6 = n3.copy;
                n3 n3Var7 = n3.toggleTrackerActionsAlwaysVisible;
                n3 n3Var8 = n3.openQuickSettings;
                n3 n3Var9 = n3.temporarilyDisable;
                r2.o0(y30VarL2, listB2, Arrays.asList(n3Var5, n3Var6, n3Var7, n3Var8, n3Var9), Arrays.asList(n3Var5, n3Var8, n3Var9, n3.takeScreenshot), new i41(aVar, i2));
                break;
            case 6:
                jl1 jl1Var = new jl1(aVar.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.tap_behaviour_reset_settings_confirmation);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(13, aVar));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
            case 7:
                r2.o0(aVar.l(), n3.b(8), Arrays.asList(n3.nothing, n3.longTap, n3.openTrackerActions, n3.toggleTrackerActionsAlwaysVisible, n3.copy), new ArrayList(), new i41(aVar, 2));
                break;
        }
        return true;
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        int i = this.b;
        TapBehaviourSettings.a aVar = this.c;
        switch (i) {
            case 1:
                if (iVar != null) {
                    pn0 pn0VarT = pn0.t();
                    ((SharedPreferences) pn0VarT.d).edit().putString(oq0.R0.name(), ((i70) pn0VarT.c).i(new j71(iVar))).apply();
                    aVar.m0.K(pn0.t().y());
                    aVar.h0.a(new s4(15));
                    break;
                }
                break;
            case 2:
                if (iVar != null) {
                    pn0 pn0VarT2 = pn0.t();
                    ((SharedPreferences) pn0VarT2.d).edit().putString(oq0.P0.name(), ((i70) pn0VarT2.c).i(new j71(iVar))).apply();
                    aVar.l0.K(pn0.t().s());
                    aVar.h0.a(new s4(15));
                    break;
                }
                break;
            default:
                if (iVar != null) {
                    pn0.t().S(new j71(iVar));
                    aVar.k0.K(pn0.t().w());
                    aVar.h0.a(new s4(15));
                    break;
                }
                break;
        }
    }
}
