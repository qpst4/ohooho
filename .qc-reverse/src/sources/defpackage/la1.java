package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class la1 extends hr {
    public m91 A0;
    public qs B0;
    public final d30 C0;
    public final bk j0;
    public f20 k0;
    public final xa1 l0;
    public SeekBarDialogPreference m0;
    public SeekBarDialogPreference n0;
    public SeekBarDialogPreference o0;
    public SeekBarDialogPreference p0;
    public SeekBarDialogPreference q0;
    public SeekBarDialogPreference r0;
    public SeekBarDialogPreference s0;
    public SeekBarDialogPreference t0;
    public SeekBarDialogPreference u0;
    public SeekBarDialogPreference v0;
    public SwitchPreference w0;
    public ActionPickerPreference x0;
    public ActionPickerPreference y0;
    public f91 z0;

    public la1() {
        super(R.xml.preferences_triggers_mode_floating);
        this.j0 = new bk(200L);
        this.C0 = (d30) Y(new ka1(this, 0), new f4(2));
        this.l0 = new xa1(false);
    }

    @Override // defpackage.hr, defpackage.j30
    public final void P() {
        super.P();
        this.l0.f();
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        Preference preferenceH0 = h0("triggerMode");
        preferenceH0.f = new r1(22, (TriggersSettings) Z());
        preferenceH0.B(true);
        this.m0 = (SeekBarDialogPreference) h0("edgeTrackerSize");
        this.v0 = (SeekBarDialogPreference) h0("trackerAreaCursorScaleValue");
        this.w0 = (SwitchPreference) h0("trackerAreaCursorScale");
        SeekBarDialogPreference seekBarDialogPreference = this.m0;
        seekBarDialogPreference.c0 = dn.f1;
        seekBarDialogPreference.L(this.z0.h().f());
        this.r0 = (SeekBarDialogPreference) h0("trackerAreaWidth");
        this.s0 = (SeekBarDialogPreference) h0("trackerAreaHeight");
        this.t0 = (SeekBarDialogPreference) h0("trackerAreaMarginLeft");
        this.u0 = (SeekBarDialogPreference) h0("trackerAreaMarginTop");
        this.n0 = (SeekBarDialogPreference) h0("cursorAreaWidth");
        this.o0 = (SeekBarDialogPreference) h0("cursorAreaHeight");
        this.p0 = (SeekBarDialogPreference) h0("cursorAreaMarginLeft");
        this.q0 = (SeekBarDialogPreference) h0("cursorAreaMarginTop");
        SeekBarDialogPreference seekBarDialogPreference2 = this.r0;
        seekBarDialogPreference2.getClass();
        seekBarDialogPreference2.c0 = ey0.c();
        SeekBarDialogPreference seekBarDialogPreference3 = this.t0;
        seekBarDialogPreference3.getClass();
        seekBarDialogPreference3.c0 = ey0.c();
        SeekBarDialogPreference seekBarDialogPreference4 = this.s0;
        seekBarDialogPreference4.getClass();
        seekBarDialogPreference4.c0 = ey0.b();
        SeekBarDialogPreference seekBarDialogPreference5 = this.u0;
        seekBarDialogPreference5.getClass();
        seekBarDialogPreference5.c0 = ey0.b();
        this.n0.c0 = ey0.c();
        this.n0.b0 = ey0.c();
        this.p0.c0 = ey0.c();
        this.o0.b0 = ey0.b() / 2;
        this.o0.c0 = ey0.b();
        this.q0.c0 = ey0.b();
        this.r0.L(this.z0.f().f());
        this.s0.L(this.z0.f().c());
        this.t0.L(this.z0.f().d());
        this.u0.L(this.z0.f().e());
        this.n0.L(this.z0.c().f());
        this.o0.L(this.z0.c().c());
        this.p0.L(this.z0.c().d());
        this.q0.L(this.z0.c().e());
        h0("floating_reset_default").g = new ka1(this, 3);
        this.v0.f = new ka1(this, 4);
        this.w0.f = new ka1(this, 5);
        this.r0.f = new ka1(this, 6);
        int i = 7;
        this.n0.f = new ka1(this, i);
        this.o0.f = new ka1(this, i);
        this.w0.J(((int) ((this.z0.c().j() / this.z0.c().b()) * 100.0f)) == ((int) ((this.z0.f().j() / this.z0.f().b()) * 100.0f)));
        this.v0.L((int) ((this.z0.f().j() / this.z0.c().j()) * 100.0f));
        this.x0 = (ActionPickerPreference) h0("floatingTapAction");
        ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0("floatingLongTapAction");
        this.y0 = actionPickerPreference;
        ActionPickerPreference actionPickerPreference2 = this.x0;
        int i2 = 10;
        actionPickerPreference2.P = new pn0(this, i2, actionPickerPreference2);
        actionPickerPreference.P = new pn0(this, i2, actionPickerPreference);
        actionPickerPreference2.g = new ka1(this, 8);
        actionPickerPreference.g = new ka1(this, 9);
        actionPickerPreference2.K(this.A0.n());
        this.y0.K(this.A0.h());
        r0();
        p0();
        fp1.o(this, Arrays.asList("triggerMode"));
    }

    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            return;
        }
        try {
            int i = sharedPreferences.getInt(str, 0);
            if (str.equals("edgeTrackerOpacity")) {
                this.k0.e(i);
            } else if (str.equals(this.m0.m)) {
                this.z0.h().m(this.z0.h().d() - ((i - this.z0.h().f()) / 2));
                this.z0.h().o(i);
                this.z0.h().k(i);
                ra1 ra1Var = ((e20) CursorAccessibilityService.q.o).r;
                WindowManager.LayoutParams layoutParams = ra1Var.e;
                layoutParams.x -= (i - layoutParams.width) / 2;
                layoutParams.width = i;
                layoutParams.height = i;
                ra1Var.b.updateViewLayout(ra1Var, layoutParams);
                xr.M(ra1Var);
            } else if (str.equals(this.r0.m)) {
                this.z0.f().o(i);
            } else if (str.equals(this.s0.m)) {
                this.z0.f().k(i);
            } else if (str.equals(this.t0.m)) {
                this.z0.f().m(i);
            } else if (str.equals(this.u0.m)) {
                this.z0.f().n(i);
            } else if (str.equals(this.n0.m)) {
                this.z0.c().o(i);
            } else if (str.equals(this.o0.m)) {
                this.z0.c().k(i);
            } else if (str.equals(this.p0.m)) {
                this.z0.c().m(i);
            } else if (str.equals(this.q0.m)) {
                this.z0.c().n(i);
            }
            this.l0.d(-1, this.z0);
            this.j0.a(new s4(23));
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        f20 f20VarE = xv0.d.a().e();
        this.k0 = f20VarE;
        f91 f91VarD = f20VarE.d();
        this.z0 = f91VarD;
        this.A0 = f91VarD.b();
        editor.putInt("edgeTrackerOpacity", this.k0.c());
    }

    public final void p0() {
        Preference preferenceH0 = h0("customActionWarning");
        n3 n3VarB = this.A0.n().b();
        n3 n3Var = n3.nothing;
        preferenceH0.F((n3VarB == n3Var && this.A0.h().b() == n3Var) ? false : true);
    }

    public final void q0(Object obj) {
        Integer num = (Integer) obj;
        this.r0.L((num.intValue() * ((int) this.z0.c().j())) / 100);
        this.s0.L((num.intValue() * ((int) this.z0.c().b())) / 100);
    }

    public final void r0() {
        this.v0.B(this.w0.O);
        this.r0.B(!this.w0.O);
        this.s0.B(!this.w0.O);
        if (this.w0.O) {
            q0(Integer.valueOf(this.v0.d0));
        }
    }
}
