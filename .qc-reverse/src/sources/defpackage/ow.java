package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ow implements e4, q2, aq0, zp0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ qw c;

    public /* synthetic */ ow(qw qwVar, int i) {
        this.b = i;
        this.c = qwVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        qw qwVar = this.c;
        switch (i) {
            case 3:
                i3 i3VarValueOf = i3.empty;
                try {
                    i3VarValueOf = i3.valueOf((String) obj);
                    break;
                } catch (Exception unused) {
                }
                qwVar.h0.getEdgeAction().f(i3VarValueOf);
                xw.e.g();
                ((EdgeActionsSettings) qwVar.Z()).I();
                break;
            case 4:
                int iIntValue = obj == null ? qwVar.o0 : ((Integer) obj).intValue();
                Integer numValueOf = Integer.valueOf(iIntValue);
                lw edgeAction = qwVar.h0.getEdgeAction();
                if (iIntValue == qwVar.o0) {
                    numValueOf = null;
                }
                edgeAction.k(numValueOf);
                qwVar.m0.L(Integer.valueOf(qwVar.h0.getEdgeAction().i() == null ? qwVar.o0 : qwVar.h0.getEdgeAction().i().intValue()));
                xw.e.g();
                ((EdgeActionsSettings) qwVar.Z()).I();
                break;
            case 5:
                int iIntValue2 = ((Integer) obj).intValue() - 1;
                EdgeBarConstraintLayout edgeBarConstraintLayout = qwVar.i0;
                nw nwVar = qwVar.h0;
                int iA = edgeBarConstraintLayout.E.a(nwVar);
                nwVar.b(false);
                Collections.swap(edgeBarConstraintLayout.getEdgeBar().d(), iA, iIntValue2);
                nw nwVar2 = (nw) edgeBarConstraintLayout.E.getChildAt(iIntValue2);
                nwVar2.b(true);
                qwVar.h0 = nwVar2;
                ((EdgeActionsSettings) qwVar.Z()).L(edgeBarConstraintLayout.getEdgeBar());
                break;
            default:
                qwVar.h0.getEdgeAction().l(((Integer) obj).intValue());
                ((EdgeActionsSettings) qwVar.Z()).L(qwVar.i0.getEdgeBar());
                break;
        }
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.c.p0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        qw qwVar = this.c;
        int i2 = 1;
        switch (i) {
            case 2:
                r2.o0(qwVar.l(), n3.b(1), new ArrayList(), new ArrayList(), new ow(qwVar, i2));
                break;
            default:
                jl1 jl1Var = new jl1(qwVar.u());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_delete_action);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(7, qwVar));
                jl1Var.h(android.R.string.no, new g2(5));
                jl1Var.n();
                break;
        }
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
        qw qwVar = this.c;
        qwVar.h0.getEdgeAction().e(iVar);
        qwVar.j0.J();
        ((EdgeActionsSettings) qwVar.Z()).L(qwVar.i0.getEdgeBar());
        qwVar.m0();
    }
}
