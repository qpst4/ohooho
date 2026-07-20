package defpackage;

import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ka1 implements e4, q2, aq0, zp0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ la1 c;

    public /* synthetic */ ka1(la1 la1Var, int i) {
        this.b = i;
        this.c = la1Var;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        la1 la1Var = this.c;
        switch (i) {
            case 4:
                la1Var.q0(obj);
                break;
            case 5:
                b61.b(new lk0(20, la1Var), 1L);
                break;
            case 6:
                la1Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / la1Var.z0.c().j()) * 100.0f));
                break;
            default:
                if (la1Var.w0.O) {
                    SeekBarDialogPreference seekBarDialogPreference = la1Var.n0;
                    SeekBarDialogPreference seekBarDialogPreference2 = la1Var.r0;
                    if (preference != seekBarDialogPreference) {
                        seekBarDialogPreference2.L((int) ((la1Var.z0.c().j() * la1Var.v0.d0) / 100.0f));
                        la1Var.s0.L((int) (((((Integer) obj).intValue() * 1.0f) * la1Var.v0.d0) / 100.0f));
                    } else {
                        seekBarDialogPreference2.L((int) (((((Integer) obj).intValue() * 1.0f) * la1Var.v0.d0) / 100.0f));
                        la1Var.s0.L((int) ((la1Var.z0.c().b() * la1Var.v0.d0) / 100.0f));
                    }
                }
                break;
        }
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.c.B0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        la1 la1Var = this.c;
        int i2 = 1;
        switch (i) {
            case 3:
                jl1 jl1Var = new jl1(la1Var.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_reset_floating_mode_settings);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(20, la1Var));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
            case 8:
                r2.o0(la1Var.l(), n3.b(128), Arrays.asList(n3.nothing, n3.backButton, n3.recentsButton, n3.homeButton, n3.expandNotifications, n3.expandQuickSettings, n3.lockScreen), new ArrayList(), new ka1(la1Var, i2));
                break;
            default:
                r2.o0(la1Var.l(), n3.b(128), Arrays.asList(n3.nothing, n3.backButton, n3.recentsButton, n3.homeButton, n3.expandNotifications, n3.expandQuickSettings, n3.lockScreen), new ArrayList(), new ka1(la1Var, 2));
                break;
        }
        return true;
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        int i = this.b;
        la1 la1Var = this.c;
        switch (i) {
            case 1:
                if (iVar != null) {
                    la1Var.A0.O(new h91(iVar));
                    la1Var.x0.K(la1Var.A0.n());
                    la1Var.p0();
                    xv0.d.c();
                    la1Var.j0.a(new s4(15));
                    break;
                }
                break;
            default:
                if (iVar != null) {
                    la1Var.A0.K(new h91(iVar));
                    la1Var.y0.K(la1Var.A0.h());
                    la1Var.p0();
                    xv0.d.c();
                    la1Var.j0.a(new s4(15));
                    break;
                }
                break;
        }
    }
}
