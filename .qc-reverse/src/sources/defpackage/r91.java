package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.quickcursor.R;
import com.quickcursor.android.preferences.CustomSwitchPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r91 extends hr {
    public final bk j0;
    public final f91 k0;
    public final q91 l0;

    public r91(f91 f91Var) {
        super(R.xml.preferences_trigger_actions_design_pie);
        this.j0 = new bk(200L);
        this.k0 = f91Var;
        this.l0 = f91Var.b().j();
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        ((CustomSwitchPreference) h0("animation")).X = new lk0(18, this);
        h0("resetDesign").g = new r1(21, this);
        fp1.n(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1614280392:
                if (str.equals("animationDuration")) {
                    b = 0;
                }
                break;
            case -1416436118:
                if (str.equals("iconColor")) {
                    b = 1;
                }
                break;
            case -737956838:
                if (str.equals("iconSize")) {
                    b = 2;
                }
                break;
            case -718297801:
                if (str.equals("pieColor")) {
                    b = 3;
                }
                break;
            case -630788519:
                if (str.equals("strokeSize")) {
                    b = 4;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 5;
                }
                break;
            case 1430566280:
                if (str.equals("selectedColor")) {
                    b = 6;
                }
                break;
            case 1905781771:
                if (str.equals("strokeColor")) {
                    b = 7;
                }
                break;
        }
        q91 q91Var = this.l0;
        switch (b) {
            case 0:
                q91Var.l(sharedPreferences.getInt(str, dn.I2));
                break;
            case 1:
                q91Var.m(sharedPreferences.getInt(str, dn.Q0));
                break;
            case 2:
                q91Var.n(sharedPreferences.getInt(str, (int) dn.I0));
                break;
            case 3:
                q91Var.o(sharedPreferences.getInt(str, dn.N0));
                break;
            case 4:
                q91Var.r(sharedPreferences.getInt(str, (int) dn.H0));
                break;
            case 5:
                q91Var.k(sharedPreferences.getBoolean(str, dn.H2));
                break;
            case 6:
                q91Var.p(sharedPreferences.getInt(str, dn.O0));
                break;
            case 7:
                q91Var.q(sharedPreferences.getInt(str, dn.P0));
                break;
        }
        r60.i(this.k0);
        this.j0.a(new s4(22));
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        q91 q91Var = this.l0;
        editor.putInt("pieColor", q91Var.e());
        editor.putInt("selectedColor", q91Var.f());
        editor.putInt("iconColor", q91Var.c());
        editor.putInt("strokeColor", q91Var.g());
        editor.putInt("strokeSize", q91Var.h());
        editor.putInt("iconSize", q91Var.d());
        editor.putInt("animationDuration", q91Var.b());
        editor.putBoolean("animation", q91Var.i());
    }
}
