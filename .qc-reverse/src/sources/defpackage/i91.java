package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i91 implements e4, aq0, zp0, q2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ j91 c;

    public /* synthetic */ i91(j91 j91Var, int i) {
        this.b = i;
        this.c = j91Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        j91 j91Var = this.c;
        switch (i) {
            case 2:
                i3 i3VarValueOf = i3.empty;
                try {
                    i3VarValueOf = i3.valueOf((String) obj);
                    break;
                } catch (Exception unused) {
                }
                j91Var.j0.f(i3VarValueOf);
                j91Var.n0();
                j91Var.m0();
                break;
            case 3:
                int iIntValue = ((Integer) obj).intValue() - 1;
                List list = j91Var.k0;
                Collections.swap(list, list.indexOf(j91Var.j0), iIntValue);
                j91Var.m0();
                break;
            default:
                j91Var.j0.j(((Integer) obj).intValue());
                j91Var.m0();
                break;
        }
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.c.o0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        j91 j91Var = this.c;
        switch (i) {
            case 1:
                r2.o0(j91Var.l(), n3.b(128), new ArrayList(), new ArrayList(), new i91(j91Var, 6));
                break;
            default:
                jl1 jl1Var = new jl1(j91Var.u());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_delete_action);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(17, j91Var));
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
        j91 j91Var = this.c;
        j91Var.j0.e(iVar);
        j91Var.l0.J();
        j91Var.n0();
        j91Var.m0();
    }
}
