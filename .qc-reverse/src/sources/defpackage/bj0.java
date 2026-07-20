package defpackage;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.MainActivity;
import com.quickcursor.android.preferences.SalePreference;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bj0 implements aq0, of, rf {
    public final /* synthetic */ int b;
    public final /* synthetic */ MainActivity.a c;

    public /* synthetic */ bj0(MainActivity.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.of
    public void a(String str, Boolean bool) {
        ((SalePreference) this.c.h0("proFeatures")).J(bool.booleanValue());
    }

    @Override // defpackage.rf
    public void b(int i) {
        this.c.m0(i);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        MainActivity.a aVar = this.c;
        switch (i) {
            case 0:
                ((SharedPreferences) pn0.t().d).edit().putBoolean(oq0.Z0.name(), CursorAccessibilityService.e()).apply();
                CursorAccessibilityService.m();
                aVar.o0();
                break;
            case 1:
                f01.J(aVar.u(), dn.l);
                break;
            default:
                jl1 jl1Var = new jl1(aVar.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_disable_accessibility);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(9, aVar));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
        }
        return true;
    }
}
