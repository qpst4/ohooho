package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tw implements zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ uw c;

    public /* synthetic */ tw(uw uwVar, int i) {
        this.b = i;
        this.c = uwVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        uw uwVar = this.c;
        int i2 = 1;
        switch (i) {
            case 0:
                uwVar.p0(((Integer) obj).intValue());
                uwVar.h0.I();
                break;
            case 1:
            default:
                uwVar.u0.O((i3.delayed.name().equals((String) obj) || uw.l0()) ? Integer.valueOf(R.drawable.icon_time) : null);
                uwVar.n0();
                break;
            case 2:
                EdgeActionsSettings edgeActionsSettings = uwVar.h0;
                int iIntValue = ((Integer) obj).intValue();
                edgeActionsSettings.Q.a(new zw(edgeActionsSettings, i2));
                if (!edgeActionsSettings.R.booleanValue()) {
                    if (edgeActionsSettings.L.isEnabled()) {
                        edgeActionsSettings.L.animate().alpha(0.1f);
                        edgeActionsSettings.E.animate().alpha(1.0f);
                    }
                    if (edgeActionsSettings.M.isEnabled()) {
                        edgeActionsSettings.M.animate().alpha(0.1f);
                        edgeActionsSettings.D.animate().alpha(1.0f);
                    }
                    if (edgeActionsSettings.O.isEnabled()) {
                        edgeActionsSettings.O.animate().alpha(0.1f);
                        edgeActionsSettings.G.animate().alpha(1.0f);
                    }
                    if (edgeActionsSettings.N.isEnabled()) {
                        edgeActionsSettings.N.animate().alpha(0.1f);
                        edgeActionsSettings.F.animate().alpha(1.0f);
                    }
                    edgeActionsSettings.R = Boolean.TRUE;
                }
                if (edgeActionsSettings.L.isEnabled()) {
                    edgeActionsSettings.E.getLayoutParams().width = iIntValue;
                    edgeActionsSettings.E.requestLayout();
                }
                if (edgeActionsSettings.M.isEnabled()) {
                    edgeActionsSettings.D.getLayoutParams().height = iIntValue;
                    edgeActionsSettings.D.requestLayout();
                }
                if (edgeActionsSettings.O.isEnabled()) {
                    edgeActionsSettings.G.getLayoutParams().height = iIntValue;
                    edgeActionsSettings.G.requestLayout();
                }
                if (edgeActionsSettings.N.isEnabled()) {
                    edgeActionsSettings.F.getLayoutParams().width = iIntValue;
                    edgeActionsSettings.F.requestLayout();
                }
                uwVar.h0.I();
                break;
            case 3:
                uwVar.n0();
                break;
            case 4:
                uwVar.s0.B(((Integer) obj).intValue() > 0);
                uwVar.n0();
                break;
        }
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        uw uwVar = this.c;
        switch (i) {
            case 1:
                uwVar.o0(true);
                break;
            default:
                jl1 jl1Var = new jl1(uwVar.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_edge_actions_reset);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(8, uwVar));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
        }
        return true;
    }
}
