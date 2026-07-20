package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.quickcursor.R;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.TickSeekBarPreference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j91 extends ir implements m3 {
    public final f91 i0;
    public final h91 j0;
    public final List k0;
    public ActionPickerPreference l0;
    public DetailedListPreference m0;
    public TickSeekBarPreference n0;
    public qs o0;
    public final bk h0 = new bk(250);
    public final d30 p0 = (d30) Y(new i91(this, 0), new f4(2));

    public j91(f91 f91Var, List list, h91 h91Var) {
        this.i0 = f91Var;
        this.k0 = list;
        this.j0 = h91Var;
    }

    public static String[] l0(int i) {
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            if (i < 10) {
                strArr[i2] = i3 + "";
            } else if (i3 % 5 == 0 || i3 == 1) {
                strArr[i2] = i3 + "";
            } else {
                strArr[i2] = "";
            }
            i2 = i3;
        }
        return strArr;
    }

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        k0(str, R.xml.preferences_trigger_action);
        ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0("actionType");
        this.l0 = actionPickerPreference;
        actionPickerPreference.P = this;
        h91 h91Var = this.j0;
        actionPickerPreference.K(h91Var);
        this.l0.g = new i91(this, 1);
        DetailedListPreference detailedListPreference = (DetailedListPreference) h0("triggerActionTriggerMode");
        this.m0 = detailedListPreference;
        detailedListPreference.f = new i91(this, 2);
        detailedListPreference.M(h91Var.a().name());
        int i = 4;
        int i2 = 3;
        this.m0.U = new CharSequence[]{lc1.K(R.string.action_trigger_mode_default_title), lc1.K(R.string.action_trigger_mode_instant_title), lc1.K(R.string.action_trigger_mode_on_release_title), f01.P(R.string.action_trigger_mode_delayed_title_with_delay_ms, "delay", this.i0.b().d() + "")};
        n0();
        List list = this.k0;
        if (list.size() <= 1) {
            h0("actionPosition").F(false);
            h0("actionSize").F(false);
        } else {
            this.n0 = (TickSeekBarPreference) h0("actionPosition");
            TickSeekBarPreference tickSeekBarPreference = (TickSeekBarPreference) h0("actionSize");
            this.n0.f = new i91(this, i2);
            tickSeekBarPreference.f = new i91(this, i);
            tickSeekBarPreference.J(20, l0(20), h91Var.i());
            this.n0.J(list.size(), l0(list.size()), list.indexOf(h91Var) + 1);
            h0("actionDelete").g = new i91(this, 5);
        }
        fp1.n(this);
    }

    public final void m0() {
        r60.i(this.i0);
        this.h0.a(new s4(20));
    }

    @Override // defpackage.m3
    public final void n(Intent intent, e4 e4Var) {
        this.o0 = (qs) e4Var;
        this.p0.a(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0() {
        /*
            r7 = this;
            java.lang.String r0 = "warningTriggerMode"
            androidx.preference.Preference r0 = r7.h0(r0)
            h91 r1 = r7.j0
            n3 r2 = r1.b()
            r3 = 8192(0x2000, float:1.148E-41)
            int r2 = r2.requirements
            boolean r2 = defpackage.xr.y(r2, r3)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            i3 r2 = r1.a()
            i3 r5 = defpackage.i3.onRelease
            if (r2 == r5) goto L34
            i3 r2 = r1.a()
            i3 r6 = defpackage.i3.empty
            if (r2 != r6) goto L36
            f91 r2 = r7.i0
            m91 r2 = r2.b()
            i3 r2 = r2.c()
            if (r2 != r5) goto L36
        L34:
            r2 = r4
            goto L37
        L36:
            r2 = r3
        L37:
            r0.F(r2)
            n3 r0 = r1.b()
            int r0 = r0.requirements
            boolean r0 = defpackage.xr.y(r0, r4)
            com.quickcursor.android.preferences.DetailedListPreference r2 = r7.m0
            if (r0 == 0) goto L57
            r2.B(r3)
            com.quickcursor.android.preferences.DetailedListPreference r7 = r7.m0
            i3 r0 = defpackage.i3.onRelease
            java.lang.String r0 = r0.name()
            r7.M(r0)
            return
        L57:
            r2.B(r4)
            com.quickcursor.android.preferences.DetailedListPreference r7 = r7.m0
            i3 r0 = r1.a()
            java.lang.String r0 = r0.name()
            r7.M(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j91.n0():void");
    }

    @Override // defpackage.m3
    public final void q(i iVar) {
        if (!zq0.b.c()) {
            yb0.y(R.string.setting_not_available_for_free_version, 0);
            return;
        }
        this.j0.e(iVar);
        this.l0.J();
        m0();
    }
}
