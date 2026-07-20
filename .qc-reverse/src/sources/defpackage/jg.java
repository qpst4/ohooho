package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.BlacklistSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jg implements zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ BlacklistSettings.a c;

    public /* synthetic */ jg(BlacklistSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        BlacklistSettings.a aVar = this.c;
        switch (i) {
            case 0:
                aVar.h0.a(new s4(15));
                break;
            default:
                aVar.i0.B(!obj.equals("disabled"));
                aVar.h0.a(new s4(15));
                break;
        }
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        BlacklistSettings.a aVar = this.c;
        jl1 jl1Var = new jl1(aVar.o());
        jl1Var.m(R.string.are_you_sure);
        jl1Var.g(R.string.confirmation_reset_blacklist_settings);
        ((x6) jl1Var.c).c = R.drawable.icon_warning;
        jl1Var.k(android.R.string.yes, new z2(1, aVar));
        jl1Var.h(android.R.string.no, null);
        jl1Var.n();
        return true;
    }
}
