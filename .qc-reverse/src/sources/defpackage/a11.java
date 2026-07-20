package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;
import com.quickcursor.android.preferences.SeekBarDialogPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class a11 extends hr {
    public final bk j0;
    public final r51 k0;
    public y01 l0;
    public xa1 m0;
    public SeekBarDialogPreference n0;

    public a11() {
        super(ey0.d() ? R.xml.preferences_simple_triggers_general_portrait : R.xml.preferences_simple_triggers_general_landscape);
        this.j0 = new bk(200L);
        this.k0 = new r51(50L, true);
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        this.n0 = (SeekBarDialogPreference) h0("triggerSize");
        this.m0 = new xa1(false);
        Preference preferenceH0 = h0("triggerMode");
        preferenceH0.f = new r1(22, (TriggersSettings) Z());
        preferenceH0.B(true);
        h0("triggers_reset").g = new r1(18, this);
        db dbVarH = ((f91) this.l0.l().get(0)).h();
        this.n0.L(Math.min(dbVarH.f(), dbVarH.c()));
        p0();
    }

    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            return;
        }
        switch (str) {
            case "triggerLength":
                this.l0.q(sharedPreferences.getInt("triggerLength", 0));
                break;
            case "cursorSpeed":
                this.l0.n(sharedPreferences.getInt("cursorSpeed", 0));
                break;
            case "triggerPosition":
                this.l0.r(sharedPreferences.getInt("triggerPosition", 0));
                break;
            case "trackerAlign":
                this.l0.o(sharedPreferences.getInt("trackerAlign", 0));
                break;
            case "triggerSides":
                this.l0.s(x01.valueOf(sharedPreferences.getString("triggerSides", "")));
                break;
            case "cursorAreaSize":
                this.l0.m(sharedPreferences.getInt("cursorAreaSize", 0));
                break;
            case "trackerDistance":
                this.l0.p(sharedPreferences.getInt("trackerDistance", 0));
                break;
        }
        this.k0.a(new k2(this, 17, sharedPreferences));
        this.j0.a(new s4(16));
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        y01 y01VarL = xv0.d.a().l();
        this.l0 = y01VarL;
        editor.putInt("triggerPosition", y01VarL.j());
        editor.putInt("triggerLength", this.l0.i());
        editor.putInt("cursorSpeed", this.l0.d());
        editor.putInt("cursorAreaSize", this.l0.c());
        editor.putInt("trackerAlign", this.l0.e());
        editor.putInt("trackerDistance", this.l0.f());
        editor.putString("triggerSides", this.l0.k().name());
    }

    public final void p0() {
        f91 f91VarH = this.l0.h("Left");
        f91 f91VarH2 = this.l0.h("Right");
        xa1 xa1Var = this.m0;
        if (f91VarH2 != null) {
            xa1Var.d(1, f91VarH2);
            this.m0.g(0);
            return;
        }
        xa1Var.g(1);
        xa1 xa1Var2 = this.m0;
        if (f91VarH != null) {
            xa1Var2.d(0, f91VarH);
        } else {
            xa1Var2.g(0);
        }
    }
}
