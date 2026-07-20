package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k71 implements aq0, zp0, e4, q2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ l71 c;

    public /* synthetic */ k71(l71 l71Var, int i) {
        this.b = i;
        this.c = l71Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        l71 l71Var = this.c;
        switch (i) {
            case 1:
                i3 i3VarValueOf = i3.empty;
                try {
                    i3VarValueOf = i3.valueOf((String) obj);
                    break;
                } catch (Exception unused) {
                }
                l71Var.h0.f(i3VarValueOf);
                s71.e.c();
                ((TrackerActionsSettings) l71Var.Z()).K();
                break;
            case 2:
                l71Var.h0.k(((Boolean) obj).booleanValue());
                s71.e.c();
                break;
            case 3:
                int iIntValue = ((Integer) obj).intValue() - 1;
                List list = l71Var.i0;
                Collections.swap(list, list.indexOf(l71Var.h0), iIntValue);
                pn0.t().getClass();
                pn0.V();
                ((TrackerActionsSettings) l71Var.Z()).K();
                ((TrackerActionsSettings) l71Var.Z()).L(iIntValue);
                break;
            default:
                l71Var.h0.l(((Integer) obj).intValue());
                pn0.t().getClass();
                pn0.V();
                ((TrackerActionsSettings) l71Var.Z()).K();
                break;
        }
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
        int i2 = 7;
        l71 l71Var = this.c;
        switch (i) {
            case 0:
                r2.o0(l71Var.l(), n3.b(2), new ArrayList(), new ArrayList(), new k71(l71Var, i2));
                break;
            default:
                jl1 jl1Var = new jl1(l71Var.u());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_delete_action);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(14, l71Var));
                jl1Var.h(android.R.string.no, new g2(7));
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
        l71 l71Var = this.c;
        l71Var.h0.e(iVar);
        l71Var.j0.J();
        l71Var.m0();
        ((TrackerActionsSettings) l71Var.Z()).K();
    }
}
