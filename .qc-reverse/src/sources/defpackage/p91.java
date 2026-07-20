package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p91 extends hr {
    public final bk j0;
    public final o91 k0;

    public p91(f91 f91Var) {
        super(R.xml.preferences_trigger_actions_design_action_icon);
        this.j0 = new bk(200L);
        this.k0 = f91Var.b().b();
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        h0("resetDesign").g = new r1(20, this);
        fp1.n(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1548407259:
                if (str.equals("offsetX")) {
                    b = 0;
                }
                break;
            case -1548407258:
                if (str.equals("offsetY")) {
                    b = 1;
                }
                break;
            case -1416436118:
                if (str.equals("iconColor")) {
                    b = 2;
                }
                break;
            case -737956838:
                if (str.equals("iconSize")) {
                    b = 3;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 4;
                }
                break;
        }
        o91 o91Var = this.k0;
        switch (b) {
            case 0:
                o91Var.j(sharedPreferences.getInt(str, dn.R0));
                break;
            case 1:
                o91Var.k(sharedPreferences.getInt(str, dn.S0));
                break;
            case 2:
                o91Var.h(sharedPreferences.getInt(str, dn.U0));
                break;
            case 3:
                o91Var.i(sharedPreferences.getInt(str, dn.T0));
                break;
            case 4:
                o91Var.g(sharedPreferences.getInt(str, dn.V0));
                break;
        }
        this.j0.a(new s4(21));
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        o91 o91Var = this.k0;
        editor.putInt("iconColor", o91Var.b());
        editor.putInt("backgroundColor", o91Var.a());
        editor.putInt("iconSize", o91Var.c());
        editor.putInt("offsetX", o91Var.d());
        editor.putInt("offsetY", o91Var.e());
    }
}
